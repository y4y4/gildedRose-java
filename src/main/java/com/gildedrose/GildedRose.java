package com.gildedrose;

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
      for (Item item : items) {
          if (isNormalItem(item)){
              decreaseQuality(item);
          } else if (isAgedBrie(item) || isBackStagePass(item)) {
              increaseQuality(item);
              if (isBackStagePass(item)){
                  modifyBackstagePass(item);
              }
          }
          decreaseSellIn(item);
          if (isExpired(item)){
              expirationHandling(item);
          }
      }
  }

  public boolean isAgedBrie(Item item) {
    return item.name.equals("Aged Brie");
  }

  public boolean isSulfuras(Item item) {
    return item.name.equals("Sulfuras, Hand of Ragnaros");
  }

    public boolean isBackStagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

  public boolean isNormalItem(Item item){
      return !isAgedBrie(item) && !isSulfuras(item) && !isBackStagePass(item);
  }

  public boolean isExpired(Item item){
      return item.sellIn <= 0;
  }

  public void increaseQuality(Item item) {
    if (item.quality < 50) {
      item.quality++;
    }
  }

  public void decreaseQuality(Item item) {
    if (item.quality > 0 && !isSulfuras(item)) {
      item.quality--;
    }
  }

  public void decreaseSellIn(Item item) {
    if (!isSulfuras(item)) {
      item.sellIn--;
    }
  }

  public void modifyBackstagePass(Item item) {
    if (item.sellIn <= 10 && item.sellIn >= 6) {
      item.sellIn += 2;
    } else if (item.sellIn <= 5) {
      item.sellIn += 3;
    }
  }

  public void expirationHandling(Item item) {
    if (!isAgedBrie(item)) {
      if (!isBackStagePass(item)) {
        decreaseQuality(item);
      } else {
        item.quality = 0;
      }
    } else {
      increaseQuality(item);
    }
  }

//    public void updateQuality() {
//        for (int i = 0; i < items.length; i++) {
//            if (!items[i].name.equals("Aged Brie")
//                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (items[i].quality > 0) {
//                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                        items[i].quality = items[i].quality - 1;
//                    }
//                }
//            } else {
//                if (items[i].quality < 50) {
//                    items[i].quality = items[i].quality + 1;
//
//                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].sellIn < 11) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//
//                        if (items[i].sellIn < 6) {
//                            if (items[i].quality < 50) {
//                                items[i].quality = items[i].quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].sellIn = items[i].sellIn - 1;
//            }
//
//            if (items[i].sellIn < 0) {
//                if (!items[i].name.equals("Aged Brie")) {
//                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (items[i].quality > 0) {
//                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                                items[i].quality = items[i].quality - 1;
//                            }
//                        }
//                    } else {
//                        items[i].quality = items[i].quality - items[i].quality;
//                    }
//                } else {
//                    if (items[i].quality < 50) {
//                        items[i].quality = items[i].quality + 1;
//                    }
//                }
//            }
//        }
//    }
}