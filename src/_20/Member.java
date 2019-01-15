package _20;

@DBTable(name = "MEMBER")
public class Member {
	@SQLString(30) String firstName;
	@SQLString(50) String lastName;
	@SQLInteger int age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true)) String handle;
	
	static int memberCount;
	public String getHandle() {return handle;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public Integer getAge() {return age;}
	public String toString() {return handle;}
}
