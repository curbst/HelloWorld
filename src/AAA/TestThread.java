package AAA;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class TestThread {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		  TaskQueue q = new TaskQueue();
		  Thread inThd = new Thread() {
			  public void run() {
				  for(int i=0;i<4;i++) {
					  String s = LocalDateTime.now().toString();
					  System.out.println("Add："+s);
					  q.addTask(s);
				  }
				  
				  try{sleep(5000);}catch(Exception e) {}
				  
				  for(int i=0;i<4;i++) {
					  String s = LocalDateTime.now().toString();
					  System.out.println("Add："+s);
					  q.addTask(s);
					  System.out.println("Add end "+s);
				  }
			  }
		  };
		  inThd.start();
		  
		  
		  Thread outThd = new Thread() {
			  public void run() {
				  while(true) {
					  System.out.println("\t\t\t\tGet begin");
					  String s = q.getTask();
					  System.out.println("\t\t\t\tGet"+s);
					  try{sleep(500);}catch(Exception e) {}
			  	  }
			  }
		  };
		  outThd.start(); 
		  
		  inThd.join();
		  outThd.join();
		  
		  System.out.println("end");
		  

	}

}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notify();
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) 
        {
        	try{this.wait();}catch(Exception e) {}
        }
        return queue.remove();
    }
}


