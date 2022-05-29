package manager;

/**
 * Represents a Room within a {@link Hotel}.
 * 
 * @author mdixon
 *
 */
public class Room implements SecuredAccess {

	private String storedCode;
	private int incorrectAttempts = 0;

	/**
	 * The room number within the hotel.
	 */
	private int roomNumber;

	// Attribute to store current Guest (occupant)
	private Guest currentGuest;

	////////////////////////////////

	/**
	 * Sets the occupant of the room.
	 * 
	 * @param guest the guest which is to occupy the room
	 */
	public void setOccupant(Guest guest) {
		currentGuest = guest;
	}

	/**
	 * Removes any occupant from the room.
	 */
	public void removeOccupant() {
		currentGuest = null;
	}

	/**
	 * 
	 * @return true if the room has an occupant
	 */
	public boolean hasOccupant() {
		if (currentGuest != null)
			return true;
		else
			return false;
	}

	@Override
	public void setCode(String code) {
		storedCode = code;
	}

	@Override
	public boolean checkCode(String code) {
		if (storedCode == code) {
			incorrectAttempts = 0;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void resetToDefault() {
		storedCode = "9999";
	}

	@Override
	public boolean isLockedOut() {
		return false;
	}

	@Override
	public int getIncorrectAttempts() {
		return incorrectAttempts; // always equal to 0 (see declaration)
	}

	/**
	 * @return the roomNum
	 */
	public int getRoomNum() {
		return roomNumber;
	}

	/**
	 * @param roomNum the roomNum to set
	 */
	public void setRoomNum(int roomNum) {
		roomNumber = roomNum;
	}

	////////////////////////////////

	/**
	 * Constructor.
	 * 
	 * @param roomNum the room number
	 */
	public Room(int roomNum) {
		setRoomNum(roomNum);
		resetToDefault();
	}

}
