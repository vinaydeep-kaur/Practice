import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * Question: Collect all the method calls and constructors in each method body.
 * 1. Sample Output: Method Declaration: createAndShowGUI() Method calls and
 * constructors: JFrame, setDefaultCloseOperation, JLabel, setPreferredSize,
 * Dimension, getContentPane, add, pack, setVisible
 */
public class Question1 extends ASTVisitor {

	/**
	 * Method name : visit Parameter : MethodDeclation node
	 * 
	 * The method traverse all the methods and stores its method body in node
	 * variable. Hence, this method body is traversed using ASTVisitor to find all
	 * the Method invocations and ConstructorInstanceCreations.
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		// get the name of the method that is being traversed
		System.out.println("\n\nMethodDeclaration: " + node.getName().getIdentifier() + ", ");

		System.out.println("Method calls and constructors: ");
		// create a new ASTVisitor to traverse the node
		node.accept(new ASTVisitor() {
			@Override
			// find all the methods inside the node and get their name
			public boolean visit(MethodInvocation mi) {
				System.out.print(mi.getName().getIdentifier() + ", ");
				return true;
			}

			@Override
			// find all the constructors inside the node
			public boolean visit(ClassInstanceCreation cic) {
				String ele = cic.getType().toString();
				System.out.print(ele + ", ");
				return true;
			}
		});

		return true;
	}
}

//!!!!!!!!!!!!!!!!Note my methods are listed without the parantheses and its parameters in all the question classes
//!!!!!!!!!!!!!!!!Add comments in all the code