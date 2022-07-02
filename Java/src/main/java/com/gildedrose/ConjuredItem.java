package com.gildedrose;

public class ConjuredItem extends Item {
    public ConjuredItem(int sellIn, int quality) {
        super(CONJURED, sellIn, quality);
    }

    @Override
    public void minusQuality() {
        this.quality -= 2;
    }
}
