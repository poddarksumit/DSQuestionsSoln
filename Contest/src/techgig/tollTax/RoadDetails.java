/**
 * 
 */
package techgig.tollTax;

/**
 * This class is used to
 * 
 * @author Sumit 21-Jul-2012
 * 
 */
public class RoadDetails {
	private int price;
	private String city1 = "";
	private String city2 = "";
	private RoadDetails roadDetail;

	public RoadDetails() {
	}

	public RoadDetails(RoadDetails roadDetail) {
		this.roadDetail = roadDetail;
		this.price = roadDetail.getPrice();
		this.city1 = roadDetail.getCity1();
		this.city2 = roadDetail.getCity2();
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getCity2() {
		return city2;
	}

	public void setCity2(String city2) {
		this.city2 = city2;
	}

	public RoadDetails swapCities() {
		String cityOne = roadDetail.getCity1();
		roadDetail.setCity1(roadDetail.getCity2());
		roadDetail.setCity2(cityOne);
		return roadDetail;

	}
}
