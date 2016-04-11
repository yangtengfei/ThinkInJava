package _21Concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import net.mindview.util.Generator;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月2日上午11:26:16 
 * @todo:此解决方式就是在call()方法里调用了 runTask()
 */
public class Exercise10 implements Callable<String>,Generator<Integer>{
	private int n;
	private int count = 0;
	public Integer next() { return fib(count++); }//实现Generator接口
	public Exercise10(){}
	public Exercise10(int n){//含有构造参数的构造器
		this.n = n;
		System.out.println("Exercise10 " + n);
	}
	@Override
	public String call() throws Exception {
		return runTask(n);
	}
	
	public String runTask(int n){
		Integer[] sequence = new Integer[n];//定义一个数组准备放入生成的数字
		for(int i=0; i<n; i++){
			sequence[i] = next();//给数组进行赋值
		}
		return "sequence " + n + " : " + Arrays.toString(sequence);
	}
	
	private int fib(int n) {//利用递归进行调用，注意退出条件。
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}

	public static void main(String[] args) {
		ExecutorService exes = Executors.newCachedThreadPool();
		ArrayList<Future<String>> result = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) result.add(exes.submit(new Exercise10(i)));
		for (Future<String> future : result) {
			try {
				if (future.isDone()) {
					System.out.println(future.get());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally{
				exes.shutdown();
			}
		}
	}
	
}
