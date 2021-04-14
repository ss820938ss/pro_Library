package pro_Library.exception;

@SuppressWarnings("serial")
public class InValidationException extends RuntimeException {

	public InValidationException() {
		super("공란 존재");
	}

	public InValidationException(String message) {
		super(message);
	}

	public InValidationException(Throwable cause) {
		super("형식이 맞지 않습니다.", cause);
	}

}