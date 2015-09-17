package TheFifthChapter;

public class Tree {

	int height;
	Tree(){
		System.out.println("Plantint a seedling--------");
		height = 0;
	}
	Tree(int initialHeight){
		height = initialHeight;
		System.out.println("Creating new Tree that is" + height + "feet tall-----");
	}
	void info(){
		System.out.println("Three is " + height + "feet tall----");
	}
	void info(String s){
		System.out.println(s + ":Tree is "+ height + "feet tall------------");
	}
}
