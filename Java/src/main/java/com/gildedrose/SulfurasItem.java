package com.gildedrose;

public class SulfurasItem extends Item {
    public SulfurasItem(int sellIn, int quality) {
        super(SULFURAS, sellIn, quality);
    }

    @Override
    void updateSellIn() {
        // no-op
    }

    @Override
    void updateQualityAfterExpiration() {
        // no-op
    }

    @Override
    void updateQuality() {
        // no-op
    }
}
