/**
 * 
 */
package Misc;

/**
 * This class is used to
 * 
 * @author Sumit 16-Jun-2013
 * 
 */
public class NestedClassExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass outClass = new OuterClass();

		System.out.println(outClass.getMsg());
		OuterClass.InnerClass inClass = outClass.new InnerClass();
		System.out.println(inClass.getInnerMsg());

		inClass.setMsg("Hello Cls in Inner");
		System.out.println(inClass.getInnerMsg());
	}

}
