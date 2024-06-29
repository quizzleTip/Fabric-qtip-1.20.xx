package net.qtip.qtipmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.qtip.qtipmod.QtipMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.block.ModBlocks;


public class ModItems {
    // add any other items exactly like this pretty much
    public static final Item MOREL = registerItem("morel", new AliasedBlockItem(ModBlocks.MOREL,
            new Item.Settings()));

    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()));
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings()));
    public static final Item ROSEQUARTZ = registerItem("rosequartz", new Item(new Item.Settings()));

    //food items==========
    public static final Item PEANUTBUTTER = registerItem("peanutbutter", new Item(new Item.Settings().food(ModFoodComponents.PEANUTBUTTER)));
    public static final Item PEANUTS = registerItem("peanuts",new AliasedBlockItem(ModBlocks.PEANUT_CROP,
            new Item.Settings().food(ModFoodComponents.PEANUTS)));

    public static final Item ROASTEDPEANUTS = registerItem("roastedpeanuts", new Item(new Item.Settings().food(ModFoodComponents.ROASTEDPEANUTS)));
    public static final Item CHEESE = registerItem("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item STRAWBERRY = registerItem("strawberry", new AliasedBlockItem(ModBlocks.STRAWBERRY_BUSH,
            new Item.Settings().food(ModFoodComponents.STRAWBERRY)));

    public static final Item CHEESESTEAK = registerItem("cheesesteak", new Item(new Item.Settings().food(ModFoodComponents.CHEESESTEAK)));
    public static final Item GLOWBERRYPIE = registerItem("glowberrypie", new Item(new Item.Settings().food(ModFoodComponents.GLOWBERRYPIE)));
    public static final Item SWEETBERRYPIE = registerItem("sweetberrypie", new Item(new Item.Settings().food(ModFoodComponents.SWEETBERRYPIE)));
    public static final Item APPLEPIE = registerItem("applepie", new Item(new Item.Settings().food(ModFoodComponents.APPLEPIE)));
    public static final Item STRAWBERRYPIE = registerItem("strawberrypie", new Item(new Item.Settings().food(ModFoodComponents.STRAWBERRYPIE)));

    //not food===========

    public static final Item MAROON_GREATSWORD = registerItem("maroon_greatsword",
            new SwordItem(ModToolMaterial.RUBY, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterial.RUBY,3,-2.4f))));
    public static final Item MOONLIGHT_GREATSWORD = registerItem("moonlight_greatsword",
            new SwordItem(ModToolMaterial.SAPPHIRE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(
                    ModToolMaterial.SAPPHIRE,3,-2.4f))));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        //misc==
        entries.add(MOREL);
        entries.add(SAPPHIRE);
        entries.add(RUBY);
        entries.add(ROSEQUARTZ);
        entries.add(MAROON_GREATSWORD);
        entries.add(MOONLIGHT_GREATSWORD);


        //foods==
        entries.add(PEANUTS);
        entries.add(ROASTEDPEANUTS);
        entries.add(CHEESE);
        entries.add(STRAWBERRY);
        entries.add(CHEESESTEAK);
        entries.add(PEANUTBUTTER);
        entries.add(GLOWBERRYPIE);
        entries.add(SWEETBERRYPIE);
        entries.add(APPLEPIE);
        entries.add(STRAWBERRYPIE);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(QtipMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        QtipMod.LOGGER.info("Registering Mod Items for" + QtipMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);



    }

}
