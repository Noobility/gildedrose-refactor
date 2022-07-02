package com.gildedrose;

public class Item {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void minusQuality() {
        if (this.isHasMoreQuality()) {
            this.quality--;
        }
    }

    public void addQuality() {
        if (this.isNotMaxQuality()) {
            this.quality++;
        }
    }

    public void emptyQuality() {
        this.quality = MIN_QUALITY;
    }

    public boolean isHasMoreQuality() {
        return this.quality > MIN_QUALITY;
    }

    public boolean isNotMaxQuality() {
        return this.quality < MAX_QUALITY;
    }

    public boolean isExpired() {
        return this.sellIn < 0;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateSellIn() {
        sellIn = sellIn - 1;
    }

    void updateQuality() {
        minusQuality();
    }

    void updateQualityAfterExpiration() {
        minusQuality();
    }

    void passOneDay() {
        updateQuality();

        updateSellIn();

        if (isExpired()) {
            updateQualityAfterExpiration();
        }
    }
}
