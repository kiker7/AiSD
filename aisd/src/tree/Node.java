package tree;

// MOZNA W INNY SPOSOB ZAPROJEKTOWAC KLASE WEZEL 
// ZAMIAST UMIESZCZAC W NIEJ DANE MOZNA UMIESCIC ODWOLANIE DO OBIEKTU PRZECHOWUJACEGO TE DANE 
/* 
 * class Node {
 * 	person p1;    odwolanie do obiektu person
 * 	Node leftChild;
 * 	Node rightChild;
 * }
 */
// WEZEL I DANE PRZECHOWYWANE W NIM NIE SA TYM SAMYM !!!!!!!

public class Node {

	public int iData;
	public double dData;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int id, double dd){
		iData = id;
		dData = dd;
	}
	
	public void displayNode(){
		System.out.print("{ ");
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
}
