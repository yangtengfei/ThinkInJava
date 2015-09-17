package TheFifthChapter;

public class Overloading {
	public static void main(String[] args){
		for(int i = 0 ; i <= 8 ; i++){
			Tree t = new Tree(i);
			t.info();
			t.info("overLoading method");
		}
	}
}
