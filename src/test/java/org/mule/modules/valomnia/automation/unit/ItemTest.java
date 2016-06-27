package unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.modules.valomnia.entities.Item;

public class ItemTest {

	
	@Test
	public void testItemsAreEqual() {
		
		Item item = new Item ();
		item.setId(3);
		item.setReference("test reference");
		item.setCategoryReference("drinks");
		item.setName("item test");
		
		Item item1 = new Item ();
		item1.setId(3);
		item1.setReference("test reference");
		item1.setCategoryReference("drinks");
		item1.setName("item test");
		
		
		assertEquals(item,item1);
		
	}
	
	@Test
	public void testItemsAreNotEqual() {
		
		Item item = new Item ();
		item.setId(1);
		item.setReference("test reference");
		item.setCategoryReference("drinks");
		item.setName("item test");
		
		Item item1 = new Item ();
		item1.setId(2);
		item1.setReference("test reference");
		item1.setCategoryReference("drinks");
		item1.setName("item test");
		
		
		assertFalse(item.equals(item1));
		
	}
	
	
	
}