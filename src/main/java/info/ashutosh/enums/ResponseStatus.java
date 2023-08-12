package info.ashutosh.enums;

public enum ResponseStatus {
	NOT_ALLOWED(-5, "Not Allowed"),
	ALREADY_EXIST(-4, "Already Exist"), 
	ERROR(-3, "Error"),
	BAD_CREDENTIAL(-2, "Bad Credential"),
	NOT_EXIST(-1, "Not Exist"), 
	SUCCESS(0, "Success");

	private int code;
	private String message;

	ResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
