package net.qtip.qtipmod.entity.custom;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Flutterer;
import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableShoulderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.*;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import net.qtip.qtipmod.entity.ModEntities;
import net.qtip.qtipmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrowEntity extends TameableShoulderEntity implements Flutterer {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    boolean isFlying;

    public CrowEntity(EntityType<? extends TameableShoulderEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new FlightMoveControl(this, 20, false);
        this.navigation = new BirdNavigation(this, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.7D));
        this.goalSelector.add(2, new FollowParentGoal(this, 0.7D));
        this.goalSelector.add(3, new TemptGoal(this, 0.7D, Ingredient.ofItems(ModItems.STRAWBERRY), false));
        this.goalSelector.add(3, new TemptGoal(this, 0.7D, Ingredient.ofItems(ModItems.PEANUTS), false));
        this.goalSelector.add(4, new CrowFlyOntoTreeGoal(this, 0.7));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.2));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CROW.create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(ModItems.STRAWBERRY);
    }

    public static DefaultAttributeContainer.Builder createCrowAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f)
                .add(EntityAttributes.GENERIC_FLYING_SPEED, 0.9f);


    }


    @Override
    public EntityView method_48926() {
        return null;
    }

    @Override
    protected void fall(double heightDifference, boolean onGround, BlockState state, BlockPos landedPosition) {
        // Prevent fall damage for flying entities
    }

    @Override
    public boolean isInAir() {
        return true;
    }

    static class CrowFlyOntoTreeGoal
            extends FlyGoal {
        public CrowFlyOntoTreeGoal(PathAwareEntity pathAwareEntity, double d) {
            super(pathAwareEntity, d);
        }

        @Override
        @Nullable
        protected Vec3d getWanderTarget() {
            Vec3d vec3d = null;
            if (this.mob.isTouchingWater()) {
                vec3d = FuzzyTargeting.find(this.mob, 15, 15);
            }
            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3d = this.locateTree();
            }
            return vec3d == null ? super.getWanderTarget() : vec3d;
        }

        @Nullable
        private Vec3d locateTree() {
            BlockPos blockPos = this.mob.getBlockPos();
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            BlockPos.Mutable mutable2 = new BlockPos.Mutable();
            Iterable<BlockPos> iterable = BlockPos.iterate(MathHelper.floor(this.mob.getX() - 10.0), MathHelper.floor(this.mob.getY() - 10.0), MathHelper.floor(this.mob.getZ() - 10.0), MathHelper.floor(this.mob.getX() + 10.0), MathHelper.floor(this.mob.getY() + 10.0), MathHelper.floor(this.mob.getZ() + 10.0));
            for (BlockPos blockPos2 : iterable) {
                BlockState blockState;
                boolean bl;
                if (blockPos.equals(blockPos2) || !(bl = (blockState = this.mob.getWorld().getBlockState(mutable2.set((Vec3i) blockPos2, Direction.DOWN))).getBlock() instanceof FenceBlock || blockState.isIn(BlockTags.LOGS)) || !this.mob.getWorld().isAir(blockPos2) || !this.mob.getWorld().isAir(mutable.set((Vec3i) blockPos2, Direction.UP)))
                    continue;
                return Vec3d.ofBottomCenter(blockPos2);
            }
            return null;
        }
    }


    //public boolean getIsFlying() {return this.isFlying;}
    //animatiom=================
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    public void tick() {
        super.tick();
        if (this.isFlying()) {
            this.setFlying(true);
        } else {
            this.setFlying(false);
        }

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

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ActionResult actionResult = super.interactMob(player, hand);
        if (actionResult.isAccepted()) {

            return actionResult;
        }

        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(ModItems.PEANUTS)) {
            if (!this.getWorld().isClient) {

                // Ensure the random casting is correct
                Item barterItem = BarterItem.getRandomBarterItem(this.getWorld().getRandom());
                this.dropStack(new ItemStack(barterItem));

                // Decrease the stack size of the peanuts
                itemStack.decrement(1);


                // Play sound effect
                this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

}












