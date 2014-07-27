package Tree;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(10, null, null);
		Node n3 = new Node(14, null, null);
		Node n4 = new Node(12, n2, n3);
		Node n5 = new Node(8, n1, n4);
		Node n6 = new Node(22, null, null);
		Node n7 = new Node(20, n5, n6);

		print(n7, null);

	}

	public static Node print(Node pN7, Node sum){
		if(pN7 == null){ return sum;}
			if(pN7.left != null)
			{
				sum = print(pN7.left, sum);
			}
			if(pN7.right != null){
				sum = print(pN7.right, sum);
			}
			if(sum == null){
				sum = pN7;
			}else{
				sum.data += pN7.data; 
			}
			return sum;
		}
}
