package com.demo.inventory;

import com.demo.inventory.api.InventoryController;
import com.demo.inventory.database.Inventory;
import com.demo.inventory.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InventoryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryDataLayerTests {

	@Autowired
	private Inventory inventory;

	@Autowired
	private InventoryController invController;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort private int port;

	private Iterable<Item> items;

	@Test
	void initialSeeding()
	{
		ResponseEntity<Iterable<Item>> responseEntity =
				restTemplate
				.exchange("http://localhost:"+port+"/item",
						HttpMethod.GET, null,
						new ParameterizedTypeReference<Iterable<Item>>() {});

		this.items = responseEntity.getBody();

		List<Item> inv = new ArrayList<Item>();
		items.forEach(item -> inv.add(item));
		assertEquals(10,inv.size());
	}

	@Test
	void testSaveandRetrieve() {

		ResponseEntity<Iterable<Item>> responseEntity =
				restTemplate
						.exchange("http://localhost:"+port+"/item",
								HttpMethod.GET, null,
								new ParameterizedTypeReference<Iterable<Item>>() {});

		Iterator it = responseEntity.getBody().iterator();

		Item retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Pear",retrieved.getName());
		assertEquals(40,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Golden apple",retrieved.getName());
		assertEquals(60,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Banana",retrieved.getName());
		assertEquals(80,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Orange",retrieved.getName());
		assertEquals(55,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Lemon",retrieved.getName());
		assertEquals(30,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Onion",retrieved.getName());
		assertEquals(43,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Carrot",retrieved.getName());
		assertEquals(33,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Potato",retrieved.getName());
		assertEquals(148,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Avocado",retrieved.getName());
		assertEquals(17,retrieved.getCount());

		retrieved = (Item) it.next();
		assertNotNull(retrieved);
		assertEquals("Eggplant",retrieved.getName());
		assertEquals(44,retrieved.getCount());
	}

}
