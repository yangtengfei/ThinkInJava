package _21ConcurrentOther;
/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年3月29日下午10:02:53 
 * @todo:《Java编程思想》21并发练习1
 */
public class Practice01 implements Runnable{
	private String startMsg, endMsg;
	
	public Practice01() {}
	public Practice01(String start, String end) {
		startMsg = start;
		endMsg = end;
	}
	
	@Override
	public void run() {
		System.out.println("Start Message: " + startMsg);
		for (int i = 0; i < 3; i++) {
			System.out.println("The" + i + "time");
			Thread.yield();
		}
		System.out.println("End Message: " + endMsg);
	}
	
	/**
	 *  多个线程并发执行
	 * @param args
	 */
	public static void main(String[] args) {
		String startMsg = "begin";
		String endMsg = "end";
		
		Practice01 practice01 = new Practice01(startMsg, endMsg);
		Thread t1 = new Thread(practice01);
		t1.start();
		Thread t2 = new Thread(practice01);
		t2.start();
		Thread t3 = new Thread(practice01);
		t3.start();
	}
}
