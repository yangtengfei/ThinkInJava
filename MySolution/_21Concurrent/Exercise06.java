package _21Concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月4日下午12:29:09 
 * @todo:TODO
 */
public class Exercise06 implements Runnable{

	@Override
	public void run() {
		int time = (int) (Math.random() * 10);
		try {
			TimeUnit.MILLISECONDS.sleep(time);
			System.out.println(time + " " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exe.execute(new Exercise06());
		}
		exe.shutdown();
	}
}
