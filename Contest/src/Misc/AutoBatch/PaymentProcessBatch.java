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
public class PaymentProcessBatch extends AutoBatchBatchProcessor {

	public PaymentProcessBatch() {
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
		super.setOrderStatus('F');
		super.setOrderStatus('X');
		super.setOrderStatus('R');
		super.setOrderStatus('1');
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDescript()
	 */
	@Override
	public void setProcessorDescript() {
		ProcessorDescription desc = new ProcessorDescription();
		desc.setAction("This process will update process the payment of the order placed by creadit card/paypal.");
		desc.setPreCond("Payment Status should be 'Authorised (AUT)' and the Order Status should be 'Credit Pending (F)/ Cancelled (X)/ Returned (R)/ Security Release (1)'. ");
		desc.setPostCond("Payment Status will be changed to 'Payment Successful (BIL)/ Payment Failed (PTF)' and the Order Status will be changed to 'Multi Order (5)/ Normal Order (M)'. ");
		super.setProcessorDescript(desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayName()
	 */
	@Override
	public void setProcessorDisplayName() {
		super.setProcessorDisplayName("Payment Processor");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayValue()
	 */
	@Override
	public void setProcessorDisplayValue() {
		super.setProcessorDisplayValue("PP");

	}
}
