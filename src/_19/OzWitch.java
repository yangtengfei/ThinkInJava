package _19;

public enum OzWitch {
	WEST("west west"),
	EAST("east east");
	
	private String desc;
	private OzWitch(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {return desc;}
	
	public static void main(String[] args) {
		for (OzWitch ozWitch : OzWitch.values()) {
			System.out.println(ozWitch + ": " + ozWitch.getDesc());
		}
	}
}
