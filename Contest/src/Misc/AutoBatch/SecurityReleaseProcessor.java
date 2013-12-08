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
public class SecurityReleaseProcessor extends AutoBatchBatchProcessor {

	public SecurityReleaseProcessor() {
		super();
		setOrderStatus();
		setProcessorDescript();
		setProcessorDisplayName();
		setProcessorDisplayValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setOrderStatus()
	 */
	@Override
	public void setOrderStatus() {
		super.setOrderStatus('S');
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDescript()
	 */
	@Override
	public void setProcessorDescript() {
		ProcessorDescription desc = new ProcessorDescription();
		desc.setAction("This process will release order from security.");
		desc.setPreCond("Order should be placed and should be in status 'Submitted (S)'.");
		desc.setPostCond("Order status will be changed to 'Security Release (1)'.");
		super.setProcessorDescript(desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayName()
	 */
	@Override
	public void setProcessorDisplayName() {
		super.setProcessorDisplayValue("SRP");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayValue()
	 */
	@Override
	public void setProcessorDisplayValue() {
		super.setProcessorDisplayName("Security Release");

	}

}
