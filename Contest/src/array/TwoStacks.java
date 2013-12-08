/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 03-Nov-2013
 * 
 */
public class TwoStacks {

	private int[] array = null;
	private int size1 = -1;
	private int size2 = 0;
	private int pop1 = -1;
	private int pop2 = 0;

	public TwoStacks(int size) {
		array = new int[size];
		size2 = array.length;
		pop2 = array.length - 1;
	}

	public boolean push1(int element) {
		boolean operationSuccess = false;
		if (size1 < size2 - 1) {
			size1++;
			array[size1] = element;
			operationSuccess = true;
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack 1 is full.");
		}
		return operationSuccess;
	}

	public boolean push2(int element) {
		boolean operationSuccess = false;
		if (size2 > size1 + 1) {
			size2--;
			array[size2] = element;

			operationSuccess = true;
		} else {
			throw new ArrayIndexOutOfBoundsException("Stack 2 is full.");
		}
		return operationSuccess;
	}

	public int pop1() {
		int returnInt = 0;
		if (pop1 < size1) {
			pop1++;
			returnInt = array[pop1];
		} else {
			throw new ArrayIndexOutOfBoundsException(
					"All element of Stack 1 is popped");
		}
		return returnInt;
	}

	public int pop2() {
		int returnInt = 0;
		if (pop2 > size2) {
			returnInt = array[pop2];
			pop2--;
		} else {
			throw new ArrayIndexOutOfBoundsException(
					"All element of Stack 2 is popped");
		}
		return returnInt;
	}

	public static void main(String[] args) {
		TwoStacks stcks = new TwoStacks(5);
		stcks.push1(2);
		stcks.push1(4);
		stcks.push1(34);
		stcks.push1(67);
		stcks.push2(670);
		// stcks.push2(7);
		System.out.println(stcks);
		System.out.println(stcks.pop1());
		System.out.println(stcks.pop1());
		System.out.println(stcks.pop1());
		System.out.println(stcks.pop1());
		System.out.println(stcks.pop1());
		System.out.println(stcks.pop1());

	}

}
