/**
 * 
 */
package Misc;

/**
 * This class is used to
 * 
 * @author Sumit 07-Aug-2013
 * 
 */
public class ObjectCreation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AB abObject = new AC();
	}
}

class A {
	int aObject;

}

class AB extends A {
	String bObject;
}

class AC extends A {
	boolean ac;
}