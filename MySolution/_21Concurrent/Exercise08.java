package _21Concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月8日上午9:16:34
 * @todo:TODO
 */
public class Exercise08 extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public Exercise08() {
		// Store the thread name:
		super(Integer.toString(++threadCount));
		start();
	}

	public String toString() {
		return "#" + getName() + "(" + countDown + "), ";
	}

	public void run() {
		while (true) {
			System.out.print(this);
			if (--countDown <= 0)
				return;
		}
	}

	public static void main(String[] args) throws InterruptedException   {
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new Exercise08());
			t.setDaemon(true);
			t.start();
		}
		
		// 本来下面这句忘了，导致程序一直运行没有终止
		TimeUnit.MILLISECONDS.sleep(100);// Run for a while
	}
}
