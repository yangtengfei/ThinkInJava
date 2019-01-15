package _20;

import java.util.List;

// 注解用例的使用
public class PasswordUtils {
	
	@UseCase(id = 47, desc = "password must content at least one number")
	public boolean validatePassword(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}
	
	@UseCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49, desc = "no password")
	public boolean checkForNewPassword(List<String> prevPasswords, String password) {
		return !prevPasswords.contains(password);
	}
}
