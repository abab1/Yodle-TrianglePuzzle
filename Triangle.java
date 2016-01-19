import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhishek
 * This class provides the solution to the Yodle Triangle puzzle.
 */
public class Triangle {
	
	/**
	 * @param args - takes in an array of string from the command line
	 */
	public static void main(String[] args) {
		List<String> lines = new ArrayList<String>();
		try {
			//put the file in the same directory containing the jar 
		    lines = Files.readAllLines(Paths.get("triangle.txt"),
		    		StandardCharsets.UTF_8);
		    ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
		    for (String line : lines) {
		    	String numbers[] =  line.split(" ");
		    	ArrayList<Integer> row = new ArrayList<Integer>();
		    	for (int i=0; i<numbers.length; i++) {
		    		row.add(Integer.parseInt(numbers[i]));
		    	}
		    	rows.add(row);
		    }
		    int totalRows=rows.size();
			
			for (int i = totalRows-1 ; i>0; )
			{
				ArrayList<Integer> row=generateNewRow(rows.get(i), rows.get(i-1));
				rows.remove(i--);
				rows.set(i,row);
			}
			System.out.println("Max Sum is "+rows.get(0).get(0));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	 
	/**
	 * @param row - the current integer list 
	 * @param rowAbove - the integer list just above the current list
	 * @return - return a modified integer list
	 * containing the max of the adjacent numbers at all indexes
	 */
	public static ArrayList<Integer> generateNewRow(ArrayList<Integer> row, ArrayList<Integer> rowAbove)
	{
		ArrayList<Integer> newrow=new ArrayList<Integer>();
		for(int i=0;i<rowAbove.size();i++)
		{
			int max=rowAbove.get(i)+row.get(i) > rowAbove.get(i)+row.get(i+1) ?
					rowAbove.get(i)+row.get(i) : rowAbove.get(i)+row.get(i+1);
			newrow.add(max);
		}
		return newrow;
	}
	

}
