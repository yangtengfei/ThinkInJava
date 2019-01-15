package _13;

public class DatabaseException extends Exception{
	public DatabaseException(int transactionsID, int queryID, String message) {
		super(String.format("(t%d, q%d) %s", transactionsID, queryID, message));
	}
	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "Write failed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
