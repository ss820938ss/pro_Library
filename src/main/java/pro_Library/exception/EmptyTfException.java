package pro_Library.exception;

@SuppressWarnings("serial")
public class EmptyTfException extends RuntimeException {

	public EmptyTfException() {
		super("형식이 맞지 않습니다.");
	}

	public EmptyTfException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EmptyTfException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EmptyTfException(String arg0) {
		super(arg0);
	}

	public EmptyTfException(Throwable arg0) {
		super(arg0);
	}
	
}
