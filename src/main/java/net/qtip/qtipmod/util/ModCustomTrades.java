package net.qtip.qtipmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.qtip.qtipmod.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades(){
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 5),
                            new ItemStack(ModItems.STRAWBERRY,1),
                            16, 5,0.05f));
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 3),
                            new ItemStack(ModItems.PEANUTS,1),
                            16, 15,0.05f));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.STRAWBERRY, 32),
                            new ItemStack(Items.EMERALD,6),
                            16, 5,0.05f));
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.PEANUTS, 32),
                            new ItemStack(Items.EMERALD,3),
                            16, 15,0.05f));
                });
    }
}
