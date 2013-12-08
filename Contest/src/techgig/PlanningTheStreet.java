/**
 * 
 */
package techgig;

import org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor;

/**
 * This class is used to "Planning the street"
 * 
 * @author Sumit 09-May-2012
 * 
 */
public class PlanningTheStreet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		abstractte
	}

	public IContentAssistant getContentAssistant(ISourceViewer sv) {
	    ContentAssistant ca = new ContentAssistant();
	    IContentAssistProcessor pr = new TagCompletionProcessor();
	    ca.setContentAssistProcessor(pr, HTML_TAG);
	    ca.setContentAssistProcessor(pr, IDocument.DEFAULT_CONTENT_TYPE);
	    ca.setInformationControlCreator(getInformationControlCreator(sv));
	    return ca;s;
	}
}
