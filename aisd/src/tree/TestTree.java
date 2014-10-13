package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestTree {

	public static void main(String[] args) throws IOException {
		int value;
		Tree theTree = new Tree();
		theTree.insert(50, 1.5);
		theTree.insert(25, 1.2);
		theTree.insert(75, 1.7);
		theTree.insert(12, 1.5);
		theTree.insert(37, 1.2);

		while (true) {
			System.out.print("Wpisz litere by wykona� polecenie, ");
			System.out
					.print("(i) - wstaw, (f) - wyszukaj, (d) - usu� lub (t) - trawersowanie: ");
			int choice = getChar();
			switch (choice) {
			case 's':
				theTree.displayTree();
				break;
			case 'i':
				System.out.print("Wpisz warto�� klucza wstawianego w�z�a: ");
				value = getInt();
				theTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Wpisz warto�� klucza poszukiwanego wez�a: ");
				value = getInt();
				Node found = theTree.find(value);
				if (found != null) {
					System.out.print("Znaleziono weze�: ");
					found.displayNode();
					System.out.println();
				} else
					System.out.println("Nie uda�o sie znale�� wez�a o kluczu: "
							+ value);
				break;
			case 'd':
				System.out.println("Podaj warto�� klucza usuwanego wezla: ");
				value = getInt();
				boolean didDelete = theTree.delete(value);
				if (didDelete)
					System.out.println("Usunieto wezel " + value);
				else
					System.out.println("Nie uda�o sie usun�c wezla o kluczu: "
							+ value);
				break;
			case 't':
				System.out.println("Wpisz 1, 2 lub 3: ");
				value = getInt();
				theTree.traverse(value);
				break;
			default:
				System.out.println("Nieprawid�owe dane!");
			}
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}

}
