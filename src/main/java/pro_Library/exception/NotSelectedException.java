package pro_Library.exception;

@SuppressWarnings("serial")
public class NotSelectedException extends RuntimeException {

	public NotSelectedException() {
		super("해당 직책을 선택하세요.");
	}

	public NotSelectedException(Throwable cause) {
		super("해당 직책을 선택하세요.", cause);
	}
	
}
