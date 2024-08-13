package com.majesticstudios.entity.scalecrow;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Objects;
import java.util.UUID;

public class ScalecrowEntity extends TamableAnimal implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public ScalecrowEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
    }

    public static AttributeSupplier.Builder bakeAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FLYING_SPEED, 0.4)
                .add(Attributes.ATTACK_DAMAGE, 0.5)
                .add(Attributes.FOLLOW_RANGE, 100F)
                .add(ForgeMod.SWIM_SPEED.get(), 0.2);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1, 20) {
            @Override
            protected Vec3 getPosition() {
                double dir_x = ScalecrowEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 32);
                double dir_y = ScalecrowEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
                double dir_z = ScalecrowEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 32);
                return new Vec3(dir_x, dir_y, dir_z);
            }
        });
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
    }



    @Override
    public void travel(@NotNull Vec3 pDirection) {
        if (this.isAlive()) {
            super.travel(pDirection);
        }
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack item = pPlayer.getItemInHand(pHand);
        //ItemStack itemOffhand = player.getOffhandItem();
        InteractionResult returnValue = InteractionResult.sidedSuccess(this.level.isClientSide());
        //Inventory inventory = player.getInventory();

        // Taming the Entity
        if (item.getItem() == Items.ROTTEN_FLESH) {
            this.setInLove(pPlayer);
            return InteractionResult.sidedSuccess(this.level.isClientSide());
        }

        // Healing the Entity
        if (item.getItem() == Items.ROTTEN_FLESH) {
            if (this.getHealth() < this.getMaxHealth()) {
                this.heal((float) Objects.requireNonNull(item.getFoodProperties(this)).getNutrition());
                if (!pPlayer.getAbilities().instabuild) {
                    item.shrink(1);
                    this.level.broadcastEntityEvent(this, (byte) 7);
                }
                this.gameEvent(GameEvent.EAT, this);
            }
        }

        return returnValue;
    }


    @Override
    protected void tickDeath() {
        super.tickDeath();
        ++this.deathTime;
        if (this.deathTime == 20) {
            this.remove(RemovalReason.KILLED);
            this.dropExperience();
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel pServerLevel, @NotNull AgeableMob pAgeableMob) {
        return this;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> pEvent) {
        if (pEvent.isMoving()) {
            pEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scalecrow.walk", true));
        }
        pEvent.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scalecrow.walk", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData pData) {
        pData.addAnimationController(new AnimationController(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
