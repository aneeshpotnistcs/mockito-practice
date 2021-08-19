package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class BiscuitTest {
	@Test
	public void testEquals() {
		Biscuit theBiscuit = new Biscuit("Ginger");
		Biscuit myBiscuit = new Biscuit("Ginger");
//		assertEquals(theBiscuit.getName(), myBiscuit.getName());
	    assertThat(theBiscuit.getName(), equalTo(myBiscuit.getName())); 
	}
}