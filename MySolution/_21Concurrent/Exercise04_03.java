package _21Concurrent;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.mindview.util.Generator;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月2日上午11:26:16 
 * @todo:TODO
 */
public class Exercise04_03 implements Runnable,Generator<Integer>{
	private int n;
	private int count = 0;
	
	public Exercise04_03(){}
	public Exercise04_03(int n){//含有构造参数的构造器
		this.n = n;
		System.out.println("Exercise04_03 " + n);
	}
	
	//实现Generator接口
	public Integer next() { return fib(count++); }
	
	@Override
	public void run() {
		Integer[] sequence = new Integer[n];//定义一个数组准备放入生成的数字
		for(int i=0; i<n; i++){
			sequence[i] = next();//给数组进行赋值
		}
		System.out.println("sequence " + n + " : " + Arrays.toString(sequence));//打印产生的位数和数组。	
	}
	
	//利用递归进行调用，注意退出条件
	private int fib(int n) {
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}

	public static void main(String[] args) {
		ExecutorService exe = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			exe.execute(new Exercise04_03(i));
		}
		exe.shutdown();
	}
}
