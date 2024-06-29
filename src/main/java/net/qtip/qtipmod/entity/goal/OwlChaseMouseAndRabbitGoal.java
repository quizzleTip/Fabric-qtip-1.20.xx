package net.qtip.qtipmod.entity.goal;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.qtip.qtipmod.entity.custom.MouseEntity;

import java.util.EnumSet;

public class OwlChaseMouseAndRabbitGoal extends Goal {
    private final PathAwareEntity owl;
    private LivingEntity target;
    private final double speed;
    private final int chaseRadius;
    private int updateCountdownTicks;

    public OwlChaseMouseAndRabbitGoal(PathAwareEntity owl, double speed, int chaseRadius) {
        this.owl = owl;
        this.speed = speed;
        this.chaseRadius = chaseRadius;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        ServerWorld world = (ServerWorld) this.owl.getWorld();
        Box box = this.owl.getBoundingBox().expand(chaseRadius);

        this.target = world.getEntitiesByClass(LivingEntity.class, box, entity ->
                entity instanceof MouseEntity || entity instanceof RabbitEntity).stream().findFirst().orElse(null);

        return this.target != null;
    }

    @Override
    public void start() {
        this.updateCountdownTicks = 0;
        this.owl.getNavigation().startMovingTo(this.target, this.speed);
    }

    @Override
    public boolean shouldContinue() {
        return this.target != null && this.target.isAlive() && this.owl.squaredDistanceTo(this.target) > 2.0;
    }

    @Override
    public void stop() {
        this.target = null;
        this.owl.getNavigation().stop();
    }

    @Override
    public void tick() {
        if (this.target != null) {
            this.owl.getLookControl().lookAt(this.target, 30.0F, 30.0F);
            if (--this.updateCountdownTicks <= 0) {
                this.updateCountdownTicks = 10;
                this.owl.getNavigation().startMovingTo(this.target, this.speed);
            }
            if (this.owl.squaredDistanceTo(this.target) < 2.0) {
                this.owl.tryAttack(this.target);
            }
        }
    }
}