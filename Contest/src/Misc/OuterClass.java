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
public class OuterClass {

	public String msg = "";

	public OuterClass() {
		msg = "Hello";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	class InnerClass {

		public String innerMsg = "";

		public InnerClass() {
			innerMsg = "Hello inner";
		}

		public String getInnerMsg() {
			return innerMsg;
		}

		public void setInnerMsg(String innerMsg) {
			innerMsg = innerMsg;
		}

		public void setMsg(String msg1) {
			innerMsg = msg.concat(msg1);
		}
	}
}
