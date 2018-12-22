package com.csmart.eval;

import java.util.Hashtable;

import com.csmart.eval.UserKey;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The UserTest class extends TestCase in JUnit tool for the automated tests
 * 
 * @author John Shi
 * @version     %I%, %G%
 */
public class UserTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UserTest( String testName )
    {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
 	
		return new TestSuite( UserTest.class );
	}
    
    /**
     * Rigourous Test
     */
	public void testMain() {
		
		// Input sample test data
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		UserKey b3 = new UserKey("Susan Smith", "SSMITH");
		UserKey b4 = new UserKey(null,null);
	
		// Prints out true or false
		assertTrue( b1.equals(b1) );  // prints true
		assertTrue( b1.equals(b2) );  // prints true
		assertFalse( b1.equals(b3) );  // prints false
		assertFalse( b1.equals(null) ); // prints false
		assertFalse( b1.equals("Some String") ); // prints false
		assertFalse( b4.equals(b1) ); // prints false
	
		// Creating a Hashtable
		Hashtable<UserKey, String> ht = new Hashtable<UserKey, String>();
	
		// Adding Key and Value pairs to Hashtable
		ht.put(b1,"Some Data");
	
		String s = (String) ht.get(b2);
	
		assertTrue( s.equals("Some Data") );  // prints true

	}
	
}

