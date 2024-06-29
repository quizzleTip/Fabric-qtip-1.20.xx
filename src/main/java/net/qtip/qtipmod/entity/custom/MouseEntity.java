package net.qtip.qtipmod.entity.custom;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeKeys;
import net.qtip.qtipmod.entity.ModEntities;
import net.qtip.qtipmod.item.ModItems;
import org.jetbrains.annotations.Nullable;




public class MouseEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;




    public MouseEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this,0.3D));
        this.goalSelector.add(2, new TemptGoal(this,0.3D, Ingredient.ofItems(ModItems.CHEESE), true));
        this.goalSelector.add(3, new FollowParentGoal(this,0.3D));
        this.goalSelector.add(4, new FleeEntityGoal<CatEntity>(this, CatEntity.class, 8.0f, 0.4f,0.3f,entity -> !((CatEntity)entity).isTamed()));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.6D));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(5, new LookAroundGoal(this));

    }

    public static DefaultAttributeContainer.Builder createMouseAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);


    }



    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.MOUSE.create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.CHEESE);
    }
//you can use ur own sound events if theyre registered properly
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_RABBIT_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_RABBIT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_RABBIT_DEATH;
    }


}

