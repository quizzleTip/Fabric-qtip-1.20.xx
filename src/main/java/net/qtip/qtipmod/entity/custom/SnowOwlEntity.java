package net.qtip.qtipmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.qtip.qtipmod.entity.ModEntities;
import net.qtip.qtipmod.entity.goal.OwlChaseMouseAndRabbitGoal;
import org.jetbrains.annotations.Nullable;



public class SnowOwlEntity extends AnimalEntity implements Flutterer {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    boolean isFlying;
    boolean isMoving;
    public float owlYaw;

    public SnowOwlEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, false);
        this.navigation = new BirdNavigation(this, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.7D));
        this.goalSelector.add(2, new FollowParentGoal(this, 0.7D));
        this.goalSelector.add(3, new OwlChaseMouseAndRabbitGoal(this, 1.0D,20));
        this.goalSelector.add(4, new FlyGoal(this, 0.7));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.2));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
    }
    public static DefaultAttributeContainer.Builder createSnowOwlAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.9f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,4);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.CHICKEN);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SNOWOWL.create(world);
    }
    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
        // Prevent fall damage for flying entities
    }




    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            //controls how often the animation is done
            this.idleAnimationTimeout = this.random.nextInt(1000) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
        if (this.isFlying()) {
            this.setFlying(true);
        } else {
            this.setFlying(false);
        }
        this.setMoving(this.isMoving());

    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public boolean isFlying() {
        return !this.isOnGround() && this.getVelocity().y != 0;
    }

    public void setFlying(boolean isFlying) {
        this.isFlying = isFlying;
    }

    public boolean getIsFlying() {
        return this.isFlying;
    }

    public boolean isMoving() {
        return !this.isOnGround() && this.getVelocity().x != 0 && this.getVelocity().z != 0;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean getIsMoving() {
        return this.isMoving;
    }

    @Override
    public boolean isInAir() {
        return true;
    }
    public static boolean canSpawnInBiome(EntityType<SnowOwlEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return world.getBiome(pos).equals(BiomeKeys.SNOWY_TAIGA);
    }
}
