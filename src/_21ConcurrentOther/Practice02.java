package _21ConcurrentOther;

import java.util.Arrays;

import net.mindview.util.Generator;

/**
 * @author: tengfei yang
 * @email: yangtengfei666666@163.com
 * @version: 2016年4月2日上午11:26:16 
 * @todo:TODO
 */
public class Practice02 implements Runnable,Generator<Integer>{
	private int n;
	private int count = 0;
	public Integer next() { return fib(count++); }//实现Generator接口
	public Practice02(){}
	public Practice02(int n){//含有构造参数的构造器
		this.n = n;
		System.out.println("Practice02 " + n);
	}
	@Override
	public void run() {
		Integer[] sequence = new Integer[n];//定义一个数组准备放入生成的数字
		for(int i=0; i<n; i++){
			sequence[i] = next();//给数组进行赋值
		}
		System.out.println("sequence " + n + " : " + Arrays.toString(sequence));//打印产生的位数和数组。	
	}
	private int fib(int n) {//利用递归进行调用，注意退出条件。
		if(n < 2) return 1;
		return fib(n-2) + fib(n-1);
	}

	public static void main(String[] args) {
		for(int i=1; i<10; i++){
			new Thread(new Practice02(i)).start();
		}
	}
}
