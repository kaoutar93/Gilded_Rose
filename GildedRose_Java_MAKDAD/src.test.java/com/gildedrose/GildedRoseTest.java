package com.gildedrose;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GildedRoseTest {
	
//decrements Items Quality and SellIn by 1
	@Test
	public void decrements_Quality_SellIn() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
        
    }
	
	//Once the sell by date has passed, Quality degrades twice as fast
	@Test
	public void DatePassed_QualityDegradesTwice() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Elixir of the Mongoose", -1, 8));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(-2, item.sellIn);
        assertEquals(6, item.quality);
        
    }
	
	// The Quality of an item is never negative
	@Test
	public void quality_NeverNegative() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("+5 Dexterity Vest", 4, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(3, item.sellIn);
        assertEquals(0, item.quality);
        
    }

	
	//"Aged Brie"  increases in Quality the older it gets
	@Test
	public void AgedBrie_Inc() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Aged Brie", 2, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(1, item.sellIn);
        assertEquals(1, item.quality);
        
    }
	
	//The Quality of an item is never more than 50	
	@Test
	public void Quality_NeverMore50() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Aged Brie", -1, 50));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(-2, item.sellIn);
        assertEquals(50, item.quality);
        
        Item item2 = items.get(1);       
        assertEquals(2, item2.sellIn);
        assertEquals(50, item2.quality);
        
    }
	
	//"Sulfuras", being a legendary item, never has to be sold or decreases in Quality
	@Test
	public void Sulfuras_Legendary() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 80));     
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(-1, item.sellIn);
        assertEquals(80, item.quality);        
    }
	
	//"Backstage passes to a TAFKAL80ETC concert" 
	//Quality increases by 2 when there are 10 days or less
	@Test
	public void backstagePasses_10Days() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 44));     
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(9, item.sellIn);
        assertEquals(46, item.quality);        
    }
	//"Backstage passes to a TAFKAL80ETC concert" 
	//Quality increases by 3 when there are 5 days or less
	@Test
	public void backstagePasses_5Days() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 44));     
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(5, item.sellIn);
        assertEquals(47, item.quality);        
    }
	
	//Quality drops to 0 after the concert
	@Test
	public void Backstage_AfterConcert() {
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 24));     
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);        
    }
	
	//"Conjured Mana Cake" items degrade in Quality twice as fast as normal items
	@Test
	public void conjured_Decr(){
        ArrayList<Item> items = new ArrayList<Item>(); 
        items.add(new Item("Conjured Mana Cake", 5, 30));     
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        Item item = items.get(0);       
        assertEquals(4, item.sellIn);
        assertEquals(28, item.quality);        
    }

}
