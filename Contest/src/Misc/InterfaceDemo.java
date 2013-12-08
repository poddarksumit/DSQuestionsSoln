/**
 * 
 */
package Misc;

/**
 * This class is used to
 * 
 * @author Sumit 11-Aug-2013
 * 
 */
public class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo demo = new DemoImpl();
		// DemoImpl demoImpl = new Demo();
		// demo.

	}
}

class DemoImpl implements Demo {
	int state;

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.Demo#fact()
	 */
	@Override
	public int fact() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int factFact() {
		return state;

	}

}

interface Demo {
	int hello = 0;

	int fact();
}