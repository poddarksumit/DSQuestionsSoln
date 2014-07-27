package design.starategy;

public class WildCat extends Cat {

	public WildCat() {
		super.setBehav(new WildCatTalkBehave());
		// TODO Auto-generated constructor stub
	}

}
