import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * To execute: ensure the dependencies mentioned in the ReadMe file are added and
 * the FrameDemo.java file location is updated in the code below.
 * 
 * @author vinaydeep
 *
 */
public class TestRunner {
	CompilationUnit cu;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		String content = null;

		// update the location of FrameDemo.java file here
		try {
			content = FileUtils.readFileToString(
					new File("D:\\eclipseWorkspace\\eclipse-workspace\\Assignment1\\src\\parser_test.java"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		//create a parser object
		ASTParser parser = ASTParser.newParser(AST.JLS8);

		// pass the content to the parser
		parser.setSource(content.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		CompilationUnit cu = (CompilationUnit) parser.createAST(null);
		
		System.out.println("Enter the method call to determine the methods that are called on the receiver variable prior to method call");
		System.out.println("Ensure the input format is as described in the examples: frame.pack() or frame.getContentPane().add()");
		Scanner sc = new Scanner(System.in);
		String question3Input = sc.next();

		//create instances of each question class
		Question1 q1 = new Question1();
		Question2 q2 = new Question2(cu);
		Question3 q3 = new Question3(question3Input); 
		Question4 q4 = new Question4();

		//Format output and call each Question
		System.out.println();
		System.out.println("################Question 1 ################");
		cu.accept(q1);

		System.out.println();
		System.out.println("################Question 2 ################");
		cu.accept(q2);

		System.out.println();
		System.out.println("################Question 3 ################");
		cu.accept(q3);

		System.out.println();
		System.out.println("################Question 4 ################");
		cu.accept(q4);
	}
}
