import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Class that takes in a file and outputs the bi-directional non measured
 * relations between the specified entities.
 */

/**
 * @author Brandon Poole
 * Dalhousie University
 * 
 * @version 1.0.0
 * @since 25/1/2016
 * 
 *         TODO Remove requirement to specify number of entities 
 *         TODO Display the relations in a UI 
 *         TODO Allow specification of direction and cost (third variable)
 *         TODO Look into using built in Java LinkedList & Queue
 */
public class Demo {

	public static void main(String[] args) {

		// some initialization of things
		Scanner kb = new Scanner(System.in);
		System.out.println("Hey! Enter the file name: ");
		String file = kb.nextLine();

		// set the matrix from the file
		int[][] matrix = setMatrix(file);

		// read the matrix. Probably should have used tostring
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");

			}
			System.out.println();
		}

		// traverse(matrix);
		ArrayList<String> trav = traverse(matrix);
		System.out.println(trav.toString());

	}

	// creates the heap from reading a file
	public static int[][] setMatrix(String f) {

		int[][] adjMatrix = null;
		int num = 0;
		File file = new File(f);

		// gets the first value as it is different from the rest of the file
		// The first number represents the number of letters there are
		// TODO If number is not supplied, find it in n time.
		try {
			Scanner scan = new Scanner(file);
			String line = scan.nextLine();
			StringTokenizer tok = new StringTokenizer(line, "\t");
			num = Integer.parseInt(tok.nextToken());

			adjMatrix = new int[num][num];

			// creates the processes and adds them to the heap
			// the heap is created by looking at the initiation time
			while (scan.hasNext()) {
				line = scan.nextLine();
				tok = new StringTokenizer(line, "\t");
				String a = tok.nextToken();
				String b = tok.nextToken();

				int aa = a.charAt(0) - 65;
				int bb = b.charAt(0) - 65;

				adjMatrix[aa][bb] = 1;
				adjMatrix[bb][aa] = 1;

			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Oops! No File Error :(");
		}
		return adjMatrix;
	}

	public static ArrayList<String> traverse(int[][] matrix) {

		ArrayList<String> ret = new ArrayList<String>();
		Queue<String> trav = new Queue<String>();

		// enqueue String value of the digit.
		// The [0] is needed because toChars returns an array of chars
		trav.enqueue(String.valueOf(Character.toChars(65)[0]));

		while (!trav.isEmpty()) {

			// dequeue the next vertex
			ret.add(trav.dequeue());

			// find and add neighbors to queue
			for (int i = 0; i < matrix.length; i++) {

				// if the value in the matrix is a 1, and the value has not been
				// added to the array or queue.
				if (matrix[ret.get(ret.size() - 1).charAt(0) - 65][i] == 1
						&& !ret.contains(String.valueOf(Character.toChars(i + 65)[0]))
						&& trav.positionOf(String.valueOf(Character.toChars(i + 65)[0])) == -1) {
					// add it to the queue
					trav.enqueue(String.valueOf(Character.toChars(i + 65)[0]));
				}

			}

		}

		return ret;

	}

}
