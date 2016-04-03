package _21Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月3日上午10:24:35 
 * @todo:TODO
 */
public class Exercise03_01 implements Runnable{
private String startMsg, endMsg;
	
	public Exercise03_01() {}
	public Exercise03_01(String start, String end) {
		startMsg = start;
		endMsg = end;
	}
	
	@Override
	public void run() {
		System.out.println("Start Message: " + startMsg);
		for (int i = 0; i < 3; i++) {
			System.out.println("The" + i + "time" + " " + Thread.currentThread().getName());
			Thread.yield();
		}
		System.out.println("End Message: " + endMsg);
	}
	
	/**
	 * 多个线程并发执行
	 * @param args
	 */
	public static void main(String[] args) {
		String startMsg = "begin";
		String endMsg = "end";
		
		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 3; i++) {
			exe.execute(new Exercise03_01(startMsg, endMsg));
		}
		exe.shutdown();
	}
}
