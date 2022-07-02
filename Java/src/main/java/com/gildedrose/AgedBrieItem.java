package com.gildedrose;

public class AgedBrieItem extends Item {
    public AgedBrieItem(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    void updateQualityAfterExpiration() {
        if (isNotMaxQuality()) {
            addQuality();
        }
    }

    @Override
    void updateQuality() {
        addQuality();
    }
}
