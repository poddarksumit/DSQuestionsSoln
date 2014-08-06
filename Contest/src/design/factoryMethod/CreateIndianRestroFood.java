package design.factoryMethod;

import design.factory.CholeBhature;
import design.factory.Food;
import design.factory.MakkeDiRotiSarsoDaSaag;
import design.factory.RajmaChawal;

public class CreateIndianRestroFood implements FactoryInterface {

	@Override
	public Food createFood(int code) {
		Food food = null;
		switch (code) {
		case 01:
			food = new CholeBhature();
			break;
		case 02:
			food = new RajmaChawal();
			break;
		case 03:
			food = new MakkeDiRotiSarsoDaSaag();
			break;
		default:
			break;
		}
		return food;
	}

}
