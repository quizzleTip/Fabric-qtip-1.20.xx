package net.qtip.qtipmod.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;

public class ModModelLayers {
    public static final EntityModelLayer MOUSE =
            new EntityModelLayer(Identifier.of(QtipMod.MOD_ID,"mouse"),"main");
    public static final EntityModelLayer CROW =
            new EntityModelLayer(Identifier.of(QtipMod.MOD_ID,"crow"),"main");
    public static final EntityModelLayer SNOWOWL =
            new EntityModelLayer(Identifier.of(QtipMod.MOD_ID,"snowowl"),"main");
    public static final EntityModelLayer MOTH =
            new EntityModelLayer(Identifier.of(QtipMod.MOD_ID,"moth"),"main");
}
