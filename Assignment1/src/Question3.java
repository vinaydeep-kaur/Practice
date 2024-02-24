import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

public class Question3 extends ASTVisitor {
	/**
	 * For each method call (mc), if the receiver of the method call is a variable
	 * (i.e., SimpleName, check documentation), determine the methods that are
	 * called on this variable prior to mc and located within the same method body.
	 * 
	 * Sample Output: Method Declaration: createAndShowGUI() Method Call:
	 * frame.pack(), Receiver variable: frame Methods called on frame:
	 * setDefaultCloseOperation, getContentPane,
	 */

	// create an input variable to store method call under observation
	String input;

	// use constructor to initialize the input variable
	public Question3(String input) {
		this.input = input;
	}

	/**
	 * Method : overridden method visit of ASTParser class Parameter :
	 * MethodDeclaration (Because it is required to check method calls for each
	 * method body)
	 * 
	 * Here, create a map of String and ArrayList where receiver variables is key
	 * and method invocations on the variable are the values stored as arrayList.
	 * 
	 * get the corresponding arrayList of method calls on the variable and find all
	 * the methods preceding the input.
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		// Print the Method Declaration
		System.out.println("\n\nMethodDeclaration: " + node.getName().getIdentifier());
		// create a map to store the variables and corresponding method calls on those
		// variables.
		Map<String, ArrayList<String>> map = new HashMap<>();
		node.accept(new ASTVisitor() {
			ArrayList<String> temp = new ArrayList<>();

			/**
			 * Visit all the MethodInvocations and retrieve the corresponding receiving
			 * variable using getExpression() method. Keep storing the methods and their
			 * corresponding variables in the map. Fetch the entry for the required input
			 * and display the methods before the input method call
			 */
			@Override
			public boolean visit(MethodInvocation mi) {
				// get receiver variable
				Expression expression = mi.getExpression();
				// create map of receiver variables and methods
					if (map.containsKey(expression.toString())) {
						if (mi.getExpression().toString().equals(expression.toString())) {
							temp = map.get(expression.toString());
							temp.add(mi.getName().getIdentifier());
							map.put(expression.toString(), temp);
						}
					} else {
						ArrayList<String> t = new ArrayList<>();
						t.add(mi.getName().getIdentifier());
						map.put(expression.toString(), t);
					}
				return true;
			}
		});
		// Method Call and receiver variable:
		System.out.println(
				"Method Call: " + input + ", Receiver variable: " + input.substring(0, input.lastIndexOf(".")));

		// Finding all the previous calls for a given string input
		System.out.print("List of all methods occuring before " + input + " is ");
		String inputArray[] = input.split("\\.");
		ArrayList<String> resultList = map.get(input.substring(0, input.lastIndexOf(".")));
		if (resultList != null) {
			for (String s : resultList) {
				if (s.equals(inputArray[inputArray.length - 1].substring(0,
						inputArray[inputArray.length - 1].length() - 2))) {
					break;
				}
				System.out.print(s + ", ");
			}
		} else {
			System.out.println(" none");
		}

		return true;
	}
}
