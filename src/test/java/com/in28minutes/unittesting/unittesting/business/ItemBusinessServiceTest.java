package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;
@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	@InjectMocks
	private ItemBusinessService business;
	@Mock
	private ItemRepository repository;
	
	
	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService bussinessService = new ItemBusinessService();
		Item item = bussinessService.retreiveHardcodedItem();
		assertNotNull(item);
//		assertEquals(new Item(1, "Ball", 10, 100), item);
	}
	
	@Test
	void testSaveItem(){
		Item item = new Item(-2, "Item2", 20, 20);
		when(repository.save(item)).thenReturn(item);
		Item saved = business.saveItem(item);
		assertEquals("fraud", saved.getName());
		assertNotNull(saved.getId());
	}
	
	@Test
	void testSaveItemWithNoNameShouldThrowException() {
		Item item = new Item(5, null, 20, 20);
		try {
			String name = item.getName();
			name.equals(null);
		}
		catch(Exception e){
			assertNotNull(e);
			assertEquals(NullPointerException.class, e.getClass());			
		}
//		when(repository.save(item)).thenReturn(item);
//		Item saved = business.saveItemWithNoNameShouldThrowException(item);
//		assertEquals("ABC", saved.getName());
	}

	
	@Test
	void testRetrieveAllItems() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "Item2", 20, 20),new Item(3, "Item3", 20, 20)));
		business.retrieveAllItems();
		
	}

}
