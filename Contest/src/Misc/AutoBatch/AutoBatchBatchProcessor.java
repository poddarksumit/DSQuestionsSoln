/**
 * 
 */
package Misc.AutoBatch;

/**
 * This class is used to
 * 
 * @author Sumit 28-Nov-2013
 * 
 */
public abstract class AutoBatchBatchProcessor {

	private boolean[] orderStatus = new boolean[256];

	private ProcessorDescription processorDescript = new ProcessorDescription();

	private String processorDisplayName;

	private String processorDisplayValue;

	public AutoBatchBatchProcessor() {
		super();
	}

	public AutoBatchBatchProcessor(boolean[] orderStatus,
			ProcessorDescription processorDescript) {
		super();
		this.orderStatus = orderStatus;
		this.processorDescript = processorDescript;
	}

	public boolean[] getOrderStatus() {
		return orderStatus;
	}

	public ProcessorDescription getProcessorDescript() {
		return processorDescript;
	}

	public String getProcessorDisplayName() {
		return processorDisplayName;
	}

	public String getProcessorDisplayValue() {
		return processorDisplayValue;
	}

	public boolean isOrderStatusAvbl(char orderStatusToCheck) {
		if (this.orderStatus[orderStatusToCheck] == true) {
			return true;
		} else {
			return false;
		}
	}

	public abstract void setOrderStatus();

	public void setOrderStatus(boolean[] orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setOrderStatus(char orderStatusVal) {
		this.orderStatus[orderStatusVal] = true;
	}

	public abstract void setProcessorDescript();

	public void setProcessorDescript(ProcessorDescription processorDescript) {
		this.processorDescript = processorDescript;
	}

	public abstract void setProcessorDisplayName();

	public void setProcessorDisplayName(String processorDisplayName) {
		this.processorDisplayName = processorDisplayName;
	}

	public abstract void setProcessorDisplayValue();

	public void setProcessorDisplayValue(String processorDisplayValue) {
		this.processorDisplayValue = processorDisplayValue;
	}

}
