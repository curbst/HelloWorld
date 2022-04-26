package AAA;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThdPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		Thread homework1 = new WeileHomeworkThd(); //java 多态
		
		
		LinkedList<Thread> taskq= new LinkedList<>();
		taskq.add(homework1);
		
		Thread th1 = taskq.poll();
		executor.submit(th1);
		
		executor.submit(taskq.poll());
		executor.submit(taskq.poll());
		executor.submit(taskq.poll());

	}

}




class WeileHomeworkThd extends Thread{ //Thread implements Runnable
	//override run
	public void run()
	{
		
	}
}


