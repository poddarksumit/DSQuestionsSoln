package thread;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("Hello");
		update(str);
System.out.println(str.toString());
	}

	private static void update(StringBuffer str){
		str.append(" sumit. How are u");
	}
}
