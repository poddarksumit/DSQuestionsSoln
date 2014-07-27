package graph;

public enum GraphColor {

	WHITE('W'), GRAY('G'), BLACK('B');

	char colorCode;

	private GraphColor(char colorCode) {
		this.colorCode = colorCode;
	}

}
