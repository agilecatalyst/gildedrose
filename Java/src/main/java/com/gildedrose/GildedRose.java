package com.gildedrose;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY_FOR_ITEM = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        switch (item.getName()) {
            case AGED_BRIE:
                updateAgedBrie(item);
                break;
            case BACKSTAGE_PASSES:
                updateBackstagePasses(item);
                break;
            case SULFURAS: {
                // legendary item, no adjustments needed
                break;
            }
            default:
                updateNormalItem(item);
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.getQuality() < MAX_QUALITY_FOR_ITEM) {
            increaseQuality(item);
        }

        if (item.getSellIn()-1 < 0 && item.getQuality() < MAX_QUALITY_FOR_ITEM) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.setQuality(item.getQuality()+1);
    }

    private void updateBackstagePasses(Item item) {
        if (item.getQuality() < MAX_QUALITY_FOR_ITEM) {
            increaseQuality(item);

            if (item.getSellIn() < 11 && item.getQuality() < MAX_QUALITY_FOR_ITEM) {
                increaseQuality(item);
            }

            if (item.getSellIn() < 6 && item.getQuality() < MAX_QUALITY_FOR_ITEM) {
                increaseQuality(item);
            }
        }

        if (item.getSellIn()-1 < 0) {
            item.setQuality(0);
        }
    }

    private void updateNormalItem(Item item) {
        if (item.getQuality() > 0) {
            decreaseQuality(item);
        }

        if (item.getSellIn() < -1 && item.getQuality() > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        item.setQuality(item.getQuality()-1);
    }
}
