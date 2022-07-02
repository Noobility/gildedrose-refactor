package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_normal_goods_quality_to_zero() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_normal_goods_sellin_smaller_than_zero_double_quality_minus() {
        Item[] items = new Item[]{new Item("foo", -1, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void test_normal_goods() {
        Item[] items = new Item[]{new Item("foo", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void test_aged_brie() {
        Item[] items = new Item[]{new AgedBrieItem(2, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.AGED_BRIE, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void test_aged_brie_exceeded_sellin() {
        Item[] items = new Item[]{new AgedBrieItem(0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.AGED_BRIE, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void test_aged_brie_quality_larger_than_50() {
        Item[] items = new Item[]{new AgedBrieItem(2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.AGED_BRIE, app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sulfuras() {
        Item[] items = new Item[]{new SulfurasItem(2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.SULFURAS, app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_to_max_quality() {
        Item[] items = new Item[]{new BackstagePassesItem(10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.BACKSTAGE_PASSES, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_last_ten_days_add_two_quality() {
        Item[] items = new Item[]{new BackstagePassesItem(10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.BACKSTAGE_PASSES, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(32, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_normal_add_one_quality() {
        Item[] items = new Item[]{new BackstagePassesItem(11, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.BACKSTAGE_PASSES, app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(31, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_last_five_days_add_three_quality() {
        Item[] items = new Item[]{new BackstagePassesItem(5, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.BACKSTAGE_PASSES, app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(33, app.items[0].quality);
    }

    @Test
    void test_backstage_pass_exceeded_quality_to_zero() {
        Item[] items = new Item[]{new BackstagePassesItem(0, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.BACKSTAGE_PASSES, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_conjured() {
        Item[] items = new Item[]{new ConjuredItem(10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.CONJURED, app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void test_conjured_expired() {
        Item[] items = new Item[]{new ConjuredItem(0, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Item.CONJURED, app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(26, app.items[0].quality);
    }

}
