package _21Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月8日上午10:28:21
 * @todo:TODO
 */
public class Exercise09 implements Runnable {
	private int countDown = 5;
	private volatile double d;

	public String toString() {
		// record name and sequence number of current thread
		return Thread.currentThread() + ":" + countDown + " " + Thread.currentThread().getPriority();
	}

	public void run() {
		while (true) {
			for (int i = 0; i < 1000; i++) {
				d += (Math.PI + Math.E) / (double) i;
				if (i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));
		for (int i = 0; i < 5; i++) {
			exec.execute(new Exercise09());
		}
		Thread.yield();
		exec.shutdown();
		
		exec = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
		for (int i = 0; i < 5; i++) {
			exec.execute(new Exercise09());
		}
		Thread.yield();
		exec.shutdown();
	}
}

class PriorityThreadFactory implements ThreadFactory {
	private final int priority;

	public PriorityThreadFactory(int priority) {
		this.priority = priority;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}

}