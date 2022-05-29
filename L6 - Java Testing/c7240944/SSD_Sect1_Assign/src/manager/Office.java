package manager;

public class Office extends Property implements SecuredAccess {

	/**
	 * The stored security code.
	 */
	private String storedCode = "";
	private int incorrectAttempts = 0;

	//////////////////////////////////////////////////////

	@Override
	public void setCode(String code) {
		storedCode = code;
		incorrectAttempts = 0;
	}

	@Override
	public boolean checkCode(String code) {
		// is locked out, or codes do not match
		if (isLockedOut() || !code.equals(storedCode)) {
			incorrectAttempts++;
			return false;
		}

		// not locked, and codes match
		else {
			incorrectAttempts = 0;
			return true;
		}
	}

	@Override
	public void resetToDefault() {
		storedCode = "1234";
		incorrectAttempts = 0;
	}

	@Override
	public boolean isLockedOut() {
		if (incorrectAttempts > 5)
			return true;
		else
			return false;
	}

	@Override
	public int getIncorrectAttempts() {
		return incorrectAttempts;
	}

	//////////////////////////////////////////////////////

	/**
	 * Constructor
	 * 
	 * @param address the address of the office
	 */
	public Office(String address) {
		super(address);
		resetToDefault();
	}

}
