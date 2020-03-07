package com.gildedrose;
import java.util.ArrayList;

public class GildedRose {

	ArrayList<Item> items=new ArrayList<Item>();
	
	public GildedRose(ArrayList<Item> items) {		
		this.items = items;
	}
	
	public void updateQuality() {
		for(Item item:items) {
			if(!item.name.equals("Sulfuras, Hand of Ragnaros") ) {
				item.sellIn-=1;
				
				if(item.sellIn>0) {					
					if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
					if(item.sellIn<=5)
						IncrementQual(item,3);
					else if(item.sellIn<=10) 
						IncrementQual(item,2);
					else
						IncrementQual(item,1);					
				}				
					else if(item.name.equals("Aged Brie")) {					
						IncrementQual(item,1);
				}
					else if(item.name.equals("Conjured Mana Cake"))					
						DecrementQual(item,2);
					else
						DecrementQual(item,1);
			  }				
				else {
					if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						item.quality=0;
					}else if(!item.name.equals("Aged Brie")) {
						DecrementQual(item,2);						
						}					
			   }
			}
		}
	}
	
	public void IncrementQual(Item it,int a) {
		it.quality+=a;
		if(it.quality>50) {
			it.quality=50;
		}
	}
	public void DecrementQual(Item it,int a) {
		it.quality-=a;
		if(it.quality<0) {
			it.quality=0;
		}
	}

}
