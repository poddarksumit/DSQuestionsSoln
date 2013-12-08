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
public class OrderExportProcessor extends AutoBatchBatchProcessor {

	public OrderExportProcessor() {
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
		super.setOrderStatus('M');
		super.setOrderStatus('5');
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDescript()
	 */

	/*
	 * <ul> For Order Type 'Ordered (ORD)/ Returned (RET)' and 'Not of Exchange
	 * (EXC)/ Submitted (S)/ Click And Collect (CLC)' <li>Hello</li> </ul>
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDescript()
	 */
	@Override
	public void setProcessorDescript() {
		ProcessorDescription desc = new ProcessorDescription();
		desc.setAction("This process will update process the payment of the order placed by creadit card/paypal.");
		desc.setPreCond("Order Status should be 'Multi Order (5)/ Normal Order (M)'.");
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("<ul>For Order Type 'Ordered (ORD)/ Returned (RET)' and 'Not of Exchange (EXC)/ Submitted (S)/ Click And Collect (CLC)'");
		strBuf.append("<li>Order Status will be changed to 'Awaiting Process (P)'. </li>");
		strBuf.append("<li>Lable will be changed to 'FC'. </li></ul>");
		strBuf.append("<ul>For Order Type 'Not of Returned (RET)' or 'Not of Exchange (EXC)/ Complete (C)/  (U)'");
		strBuf.append("<li>Order Status will be changed to 'Complete (C)'. </li>");
		strBuf.append("<li>Lable will be changed to 'SALES'. </li></ul>");
		desc.setPostCond(strBuf.toString());
		super.setProcessorDescript(desc);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayName()
	 */
	@Override
	public void setProcessorDisplayName() {
		super.setProcessorDisplayName("Order Export");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Misc.AutoBatch.AutoBatchBatchProcessor#setProcessorDisplayValue()
	 */
	@Override
	public void setProcessorDisplayValue() {
		super.setProcessorDisplayValue("OEP");

	}
}
