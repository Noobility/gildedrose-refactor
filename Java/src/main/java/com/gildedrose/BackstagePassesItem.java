package com.gildedrose;

public class BackstagePassesItem extends Item {
    public BackstagePassesItem(int sellIn, int quality) {
        super(BACKSTAGE_PASSES, sellIn, quality);
    }

    @Override
    void updateQualityAfterExpiration() {
        emptyQuality();
    }

    @Override
    void updateQuality() {
        addQuality();

        if (sellIn < 11) {
            addQuality();
        }

        if (sellIn < 6) {
            addQuality();
        }
    }
}
