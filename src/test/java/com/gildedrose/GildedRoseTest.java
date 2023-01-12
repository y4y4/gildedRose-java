package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new BasicItem("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality(items);
        assertEquals(4, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
    @Test
    void specialItemUpdateTest() {
        Item[] items = new Item[] { new SpecialItem("foo", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality(items);
        assertEquals(5, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
    }
}
