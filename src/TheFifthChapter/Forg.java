package TheFifthChapter;

public class Forg extends Amphibian {
	public void play(){
		System.out.println("I AM FORG");
	}
	
	public static void main(String[] args) {
		Forg forg = new Forg();
		Amphibian.tune(forg); 
	}
}
