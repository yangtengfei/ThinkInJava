package _12;

import java.awt.Event;

class BaseballException extends Exception{}
class Foul extends BaseballException{}
class Strike extends BaseballException{}

abstract class Inning{
	public Inning() throws BaseballException{}
	public void event() throws BaseballException{}
	public abstract void atBat() throws Strike, Foul;
	public void walk() {}
}
class StormException extends Exception{}
class RainedOut extends StormException{}
class PopFoul extends Foul{}

interface Storm{
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}
public class StromyInning extends Inning implements Storm{
	public StromyInning() throws RainedOut, BaseballException {}
	
	public StromyInning(String s) throws Foul, BaseballException{}
	
	// Exception PopFoul is not compatible with throws clause in Inning.walk()
	// public void walk() throws PopFoul{} 
	
	// 不能通过接口增加异常
	// public void event() throws RainedOut{}

	public void rainHard() throws RainedOut{}

	public void event() {};

	public void atBat() throws PopFoul {}

	public static void main(String[] args) {
		try {
			StromyInning sInning = new StromyInning();
			sInning.atBat();
		} catch (PopFoul e) {
			System.out.println("Pop Foul");
		} catch (RainedOut e) {
			System.out.println("RainedOut");
		} catch (BaseballException e) {
			System.out.println("BaseballException");
		}
		
		try {
			Inning inning = new StromyInning();
			inning.atBat();
		} catch (Strike e) {
			System.out.println("Strike");
		} catch (Foul e) {
			System.out.println("Strike");
		} catch (RainedOut e) {
			System.out.println("Strike");
		} catch (BaseballException e) {
			System.out.println("Strike");
		}
	}
}
