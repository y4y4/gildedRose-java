package com.gildedrose;

public class BasicItem extends Item {

  public BasicItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    this.quality--;
    this.sellIn--;
  }
}