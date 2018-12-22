package com.csmart.eval;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Objects;

/**
 * The UserKey class is placed into the HttpSession session of a Servlet and used as a key for a Hashtable of other objects. 
 * The serialVersionUID is required for a Serializable object and used during the serialization and deserialization 
 * of this objects.
 * 
 * @author      John Shi
 * @version     %I%, %G%
 *
 */
public class UserKey implements Serializable {

	/**
	 * A unique serial version identifier
	 * @see Serializable
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String userid;

	/**
	 * Class constructor specifying number of objects to create.
	 * <p>
	 * @param name		user name as (First Name Last name)
	 * @param userid	userid as a reference key to the specified user. 
	 */
	public UserKey(String name, String userid) {
		this.name = name;
		this.userid = userid;
		
	}
	
	/* {@inheritDoc}
	 * <p>
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, userid);
	}

	/* {@inheritDoc}
	 * <p>
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserKey)) {
			return false;
		}
		UserKey other = (UserKey) obj;
		return Objects.equals(name, other.name) && Objects.equals(userid, other.userid);
	}

	/**
	 * The program entry point to test UserKey class 
	 * @param args	supplies command-line arguments as an array of String objects.
	 * @exception 	any exception
	 * @return 		no return value.
	 */
	public static void main(String[] args) {
		
		// Input sample test data
		UserKey b1 = new UserKey("Bill Smith", "BSMITH");
		UserKey b2 = new UserKey("Bill Smith", "BSMITH");
		UserKey b3 = new UserKey("Susan Smith", "SSMITH");
		UserKey b4 = new UserKey(null,null);
	
		// Prints out true or false
		System.out.println( b1.equals(b1) );  // prints true
		System.out.println( b1.equals(b2) );  // prints true
		System.out.println( b1.equals(b3) );  // prints false
		System.out.println( b1.equals(null) ); // prints false
		System.out.println( b1.equals("Some String") ); // prints false
		System.out.println( b4.equals(b1) ); // prints false
	
		// Creating a Hashtable
		Hashtable<UserKey, String> ht = new Hashtable<UserKey, String>();
	
		// Adding Key and Value pairs to Hashtable
		ht.put(b1,"Some Data");
	
		String s = (String) ht.get(b2);
	
		System.out.println( s.equals("Some Data") );  // prints true
	}
	
	/**
	 * @return  user name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return	userid
	 */
	public String getUserID() {
		return userid;
	}
	
}
