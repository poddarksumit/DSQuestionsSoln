/**
 * 
 */
package Misc.AutoBatch;

/**
 * This class is used to
 * 
 * @author Sumit 29-Nov-2013
 * 
 */
public class ProcessorDescription {

	private String action = "";
	private String addShortDesc = "";
	private String postCond = "";
	private String preCond = "";

	public ProcessorDescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAction() {
		return action;
	}

	public String getAddShortDesc() {
		return addShortDesc;
	}

	public String getPostCond() {
		return postCond;
	}

	public String getPreCond() {
		return preCond;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setAddShortDesc(String addShortDesc) {
		this.addShortDesc = addShortDesc;
	}

	public void setPostCond(String postCond) {
		this.postCond = postCond;
	}

	public void setPreCond(String preCond) {
		this.preCond = preCond;
	}

}
