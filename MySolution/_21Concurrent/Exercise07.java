package _21Concurrent;

import java.util.concurrent.TimeUnit;

import net.mindview.util.Print;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月6日下午1:11:55
 * @todo:TODO
 */
public class Exercise07 {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Damen());
		d.setDaemon(true);
		d.start();
		Print.print("d.isDaemon() = " + d.isDaemon() + ",");
		TimeUnit.SECONDS.sleep(10);
	}
}

class Damen implements Runnable {
	private Thread[] t = new Thread[10];

	@Override
	public void run() {
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DemonSpawn());
			t[i].start();
			Print.print("DaemonSpawn " + i + " started.");
		}
		for (int i = 0; i < t.length; i++)
			Print.print("t[" + i + "].isDamen() = " + t[i].isDaemon() + ",");
		while (true)
			Thread.yield();

	}

}

class DemonSpawn implements Runnable {

	@Override
	public void run() {
		while (true) {
			Thread.yield();
		}
	}
}
