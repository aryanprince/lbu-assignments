package manager;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A Hotel containing many {@link Room} instances.
 * 
 * @author mdixon
 *
 */
public class Hotel extends Property {

	// Attribute to store multiple Room instances
	private List<Room> rooms = new ArrayList<Room>();
	private Map<Integer, Guest> roomMap = new LinkedHashMap<Integer, Guest>();

	//////////////////////////////////

	/**
	 * 
	 * @return the number of rooms within the hotel.
	 */
	public int getRooms() {
		return rooms.size();
	}

	/**
	 * Set the specified room to be occupied by the given guest.
	 * 
	 * @param roomNo the room number
	 * @param guest  the guest
	 */
	public void occupyRoom(int roomNo, Guest guest) {
		rooms.get(roomNo).setOccupant(guest);
		roomMap.put(roomNo, guest);
	}

	/**
	 * Ensures the specified room is unoccupied.
	 * 
	 * @param roomNo the room number
	 */
	public void freeRoom(int roomNo) {
		if (roomMap.containsKey(roomNo)) {
			roomMap.remove(roomNo);
		}
	}

	/**
	 * Gets the count of number of occupied rooms
	 * 
	 * @return the occupied room count
	 */
	public int getOccupiedRoomCount() {

		int count = 0;

		// Loop to calculate number of occupied rooms
		for (Entry<Integer, Guest> entry : roomMap.entrySet()) {
			int roomNum = entry.getKey();
			if (roomNum > 0) {
				count++;
			}
		}

		return count;
	}

	//////////////////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param addr      the address of the hotel
	 * @param roomCount the number of rooms in the hotel
	 */
	public Hotel(String addr, int roomCount) {

		super(addr);

		for (int i = 0; i < roomCount; i++) {
			rooms.add(new Room(i));
		}

	}
}
