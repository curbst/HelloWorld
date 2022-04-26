package AAA;

public class OutOfAgeException extends RuntimeException {
	  public OutOfAgeException() {
	        super();
	    }

	    public OutOfAgeException(String message, Throwable cause) {
	        super(message, cause);
	    }

	    public OutOfAgeException(String message) {
	        super(message);
	    }

	    public OutOfAgeException(Throwable cause) {
	        super(cause);
	    }
}
