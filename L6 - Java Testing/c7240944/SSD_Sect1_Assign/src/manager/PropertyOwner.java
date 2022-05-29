package manager;

import java.util.ArrayList;
import java.util.List;

/**
 * A person that owns {@link Property} instances.
 * 
 * @author mdixon
 *
 */
public class PropertyOwner extends Person {

	// TODO:Part3 - Add attribute to store multiple Property instances
	List<Property> properties = new ArrayList<Property>();

	//////////////////////////////////////////////////////////////////////

	/**
	 * Adds a property to the set of owned properties.
	 * 
	 * @param prop the property to be added
	 * @return true if the property added, false if already owned.
	 */
	public boolean addProperty(Property prop) {
		if (properties.contains(prop) == false) {
			properties.add(prop);
			return true;
		} else
			return false;

	}

	/**
	 * Removes a property from the set of owned properties.
	 * 
	 * @param prop the property to be removed
	 * @return true if the property was removed, false if it was not owned
	 */
	public boolean removeProperty(Property prop) {
		if (properties.contains(prop) == true) {
			properties.remove(prop);
			return true;
		} else
			return false;

	}

	/**
	 * Clears all properties from the set of owned properties.
	 */
	public void clearOwnedProperties() {
		properties.clear();
	}

	/**
	 * Gets the number of owned properties
	 * 
	 * @return the number of owned properties
	 */
	public int getPropertyCount() {
		return properties.size();
	}

	/////////////////////////////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param name the property owner's name
	 */
	public PropertyOwner(String name) {

		super(name);
	}
}
