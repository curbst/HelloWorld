package AAA;

public class Test2Thread {

	public static void main(String[] args) throws Exception {
	        var add = new AddThread();
	        var dec = new DecThread();
	        add.start();
	        dec.start();
	        add.join();
	        dec.join();
	        System.out.println(Counter2.count);
	    }
	}

class Counter2 {
	    public static final String lock = new String(); 
	   
	    public static int count = 0;
	}

class AddThread extends Thread {
	    String str = null;
	    public void run() {
	        for (int i=0; i<10000; i++) 
	        {
	        	 synchronized(Counter2.lock) {
	                 Counter2.count += 1;
	             }
	        }
	    }
	}

class DecThread extends Thread {
	    public void run() {
	        for (int i=0; i<10000; i++) 
	        {
	        	 synchronized(Counter2.lock) {
	                 Counter2.count -= 1;
	             }
	        }
	    }
	}


