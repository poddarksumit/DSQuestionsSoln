/**
 * 
 */
package techgig.escapeTheMaze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class is used to
 * 
 * @author Sumit 25-May-2012
 * 
 */
public class TrackFlow {

	private List<Integer> startingCordinate;
	private ArrayList<TrackFlowObject> trackFlowdetails = new ArrayList<TrackFlowObject>();
	private static HashMap<List<Integer>, ArrayList<TrackFlowObject>> trackingDetails = new HashMap<List<Integer>, ArrayList<TrackFlowObject>>();

	private TrackFlow(List<Integer> startingCordinate,
			ArrayList<TrackFlowObject> trackFlowdetails) {
		super();
		this.startingCordinate = startingCordinate;
		this.trackFlowdetails = trackFlowdetails;
		setTrackingDetails(startingCordinate, trackFlowdetails);
	}

	public List<Integer> getStartingCordinate() {
		return startingCordinate;
	}

	public void setStartingCordinate(List<Integer> startingCordinate) {
		this.startingCordinate = startingCordinate;
	}

	public static HashMap<List<Integer>, ArrayList<TrackFlowObject>> getTrackingDetails() {
		return trackingDetails;
	}

	public static void setTrackingDetails(List<Integer> startingpoint,
			ArrayList<TrackFlowObject> trackingDetails) {
		TrackFlow.trackingDetails.put(startingpoint, trackingDetails);
	}

	public ArrayList<TrackFlowObject> getTrackFlowdetails() {
		return trackFlowdetails;
	}

}