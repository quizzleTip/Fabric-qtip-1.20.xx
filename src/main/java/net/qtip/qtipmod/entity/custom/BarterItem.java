package net.qtip.qtipmod.entity.custom;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.qtip.qtipmod.item.ModItems;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.math.random.Random;

public class BarterItem {
    private final Item item;
    private final double probability;

    public BarterItem(Item item, double probability) {
        this.item = item;
        this.probability = probability;
    }

    public Item getItem() {
        return item;
    }

    public double getProbability() {
        return probability;
    }

    public static Item getRandomBarterItem(Random random) {
        List<BarterItem> barterItems = new ArrayList<>();
        barterItems.add(new BarterItem(Items.STICK, 0.40)); // 20% chance
        barterItems.add(new BarterItem(Items.IRON_NUGGET, 0.10)); // 30% chance
        barterItems.add(new BarterItem(ModItems.MOREL, 0.10)); // 10% chance for a custom item
        barterItems.add(new BarterItem(ModItems.SAPPHIRE, 0.005)); // 0.5% chance for rare item 1
        barterItems.add(new BarterItem(ModItems.RUBY, 0.005)); // 0.5% chance for rare item 2
        barterItems.add(new BarterItem(Items.EMERALD, 0.345)); // Adjusted to make total probability 100%

        double totalProbability = 0.0;
        for (BarterItem barterItem : barterItems) {
            totalProbability += barterItem.getProbability();
        }

        double randomValue = random.nextDouble() * totalProbability;

        for (BarterItem barterItem : barterItems) {
            randomValue -= barterItem.getProbability();
            if (randomValue <= 0.0) {
                return barterItem.getItem();
            }
        }
        return Items.AIR;
    }
}