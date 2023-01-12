package com.gildedrose;

public class SpecialItem extends Item {

  public SpecialItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void updateQuality() {
    this.sellIn--;
  }
}
