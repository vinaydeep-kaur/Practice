import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

/**
 * Question : For each method body, identify the declared variables along with
 * their line numbers. Sample Output: Method Declaration: createAndShowGUI()
 * Variable: frame, Line Number: x Variable: emptyLabel, Line Number: y
 */
public class Question2 extends ASTVisitor {
	CompilationUnit cu;

	public Question2(CompilationUnit cu) {
		this.cu = cu;
	}

	/**
	 * Method : It is a overridden method of ASTVisitor class called visit Parameter
	 * : MethodDeclaration node
	 * 
	 * To obtain variable declarations along with line number in each body, first
	 * obtain the method body of the method in a variable called node. Then visit
	 * all the Variable declarations using VariableDeclarationFragment and obtain
	 * their line number using getStartPosition.
	 */
	@Override
	public boolean visit(MethodDeclaration node) {
		// Print the name of the method
		System.out.println("\n\nMethodDeclaration: " + node.getName().getIdentifier());
		// visit all nodes in the method body
		node.accept(new ASTVisitor() {
			@Override
			// identify all the variables in the method body and print along with the line
			// number
			public boolean visit(VariableDeclarationFragment vdf) {
				System.out.println("Variable: " + vdf.getName().getIdentifier() + ", Line Number: "
						+ cu.getLineNumber(vdf.getStartPosition()));
				return true;
			}
		});
		return true;
	}
}
