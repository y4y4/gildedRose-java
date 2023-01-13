package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

  private GildedRose app;
  private Item[] items;

  @BeforeEach
  public void init() {
    items = new Item[]{
        new Item("+5 Dexterity Vest", 10, 20),
        new Item("Aged Brie", 2, 0),
        new Item("Elixir of the Mongoose", 5, 7),
        new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        new Item("Conjured Mana Cake", 3, 6)};

    app = new GildedRose(items);
  }

  @Test
  void foo() {
    app.updateQuality();
    assertEquals("+5 Dexterity Vest", app.items[0].name);
  }

  @Test
   void agedBrieIncreaseQualityTest() {

    app.increaseQuality(items[1]);
    assertEquals(1, items[1].quality);
  }

  @Test
  void normalItemIncreaseQualityTest(){
    app.increaseQuality(items[2]);
    assertEquals(8, items[2].quality);
  }

  @Test
  void normalItemDecreaseQualityAndSellInTest(){
    app.decreaseQuality(items[2]);
    app.decreaseSellIn(items[2]);
    assertEquals(6, items[2].quality);
    assertEquals(4,items[2].sellIn);
  }

  @Test
  public void testModifyBackstagePass() {
    app.modifyBackstagePass(items[5]);
    app.modifyBackstagePass(items[6]);
    app.modifyBackstagePass(items[7]);
    assertEquals(15, items[5].sellIn);
    assertEquals(12, items[6].sellIn);
    assertEquals(8, items[7].sellIn);
  }
}
