package AAA;

public class Counter {
	private Object lockA = new Object();
	private Object lockB = new Object();
	
	private int value =0;
	private int another =0;
	
	
	public void add(int m) { //thread1
	    synchronized(lockA) { // 获得lockA的锁
	    	
	        this.value += m;
	        synchronized(lockB) { // 获得lockB的锁
	            this.another += m;
	        } // 释放lockB的锁
	    } // 释放lockA的锁
	}

	public void dec(int m) { //thread2
	    synchronized(lockB) { // 获得lockB的锁
	        this.another -= m; 
	        synchronized(lockA) { // 获得lockA的锁
	            this.value -= m;
	        } // 释放lockA的锁
	    } // 释放lockB的锁
	}
}
