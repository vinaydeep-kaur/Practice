import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.MethodDeclaration;

/**
 * Question : Collect all exceptions you catch in a method body
 * 
 * Sample Output: Method Declaration: main (String args[]) Catches Exceptions:
 * ArrayIndexOutOfBoundsException
 */
public class Question4 extends ASTVisitor {

	/**
	 * Method : overridden method visit of ASTParser class Parameter
	 * :MethodDeclaration
	 * 
	 * Use ASTVisitor and visit all the the CatchClause. There are different ways in
	 * which a catch clause can be implemented in Java. This method catches all the
	 * Exceptions in any format.
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		//print the method name
		System.out.println("\n\nMethodDeclaration: " + node.getName().getIdentifier());
		node.accept(new ASTVisitor() {
			//visit all the CatchClause
			@Override
			public boolean visit(CatchClause cc) {
				System.out.println("Catch Exceptions: " + cc.getException());
				return true;
			}
		});
		return true;
	}
}
