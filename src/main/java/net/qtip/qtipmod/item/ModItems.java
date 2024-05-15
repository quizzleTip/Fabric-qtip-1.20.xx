package net.qtip.qtipmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.qtip.qtipmod.QtipMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {
    // add any other items exactly like this pretty much


    //food items==========
    public static final Item PEANUTBUTTER = registerItem("peanutbutter", new Item(new Item.Settings().food(ModFoodComponents.PEANUTBUTTER)));
    public static final Item PEANUTS = registerItem("peanuts", new Item(new Item.Settings().food(ModFoodComponents.PEANUTS)));
    public static final Item CHEESE = registerItem("cheese", new Item(new Item.Settings().food(ModFoodComponents.CHEESE)));
    public static final Item GLOWBERRYPIE = registerItem("glowberrypie", new Item(new Item.Settings().food(ModFoodComponents.GLOWBERRYPIE)));
    public static final Item SWEETBERRYPIE = registerItem("sweetberrypie", new Item(new Item.Settings().food(ModFoodComponents.SWEETBERRYPIE)));
    public static final Item APPLEPIE = registerItem("applepie", new Item(new Item.Settings().food(ModFoodComponents.APPLEPIE)));



    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {

        entries.add(PEANUTS);
        entries.add(CHEESE);
        entries.add(PEANUTBUTTER);
        entries.add(GLOWBERRYPIE);
        entries.add(SWEETBERRYPIE);
        entries.add(APPLEPIE);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(QtipMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        QtipMod.LOGGER.info("Registering Mod Items for" + QtipMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);



    }

}
