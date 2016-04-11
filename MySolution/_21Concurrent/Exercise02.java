package _21Concurrent;

import net.mindview.util.Generator;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年3月29日下午10:21:45 
 * @todo:TODO
 */
public class Exercise02 implements Runnable,Generator<Integer>{
	int n, count=0;
	
	public Exercise02() {}
	public Exercise02(int n) {
		this.n = n;
	}
	
	@Override
	public Integer next() {return count ++;}

	/*private Integer fib(int i) {
		if (n < 2) {return 1;}
		return fib(n-2) + fib(n-1);
	}*/
	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			System.out.println(next() + " " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		Exercise02 p1 = new Exercise02(3);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p1);
		Thread t3 = new Thread(p1);
		t1.start();t2.start();t3.start();
	}
}
