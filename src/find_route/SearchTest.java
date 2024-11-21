package find_route;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	@Test
	public void test1() {
		BuildGraph graph = new BuildGraph("input.txt");
		Node test = Search.uniformCostSearch(graph, "Saarbruecken", "Luebeck");
		Node actual = new Node("Luebeck", 
				new Node("Hamburg", 
						new Node("Hannover", 
								new Node("Kassel", 
										new Node("Frankfurt",
												new Node("Saarbruecken", null, 0, 0)
										, 0, 0)
								, 0, 0)
						, 0, 0)
				, 0, 0)
			, 0, 0);
		assertTrue(test.equals(actual));
	}
	
	@Test
	public void test2() {
		BuildGraph graph = new BuildGraph("input.txt");
		Node test = Search.uniformCostSearch(graph, "Karlsruhe", "Magdeburg");
		Node actual = new Node("Magdeburg", 
				new Node("Leipzig", 
						new Node("Nuremberg", 
								new Node("Stuttgart", 
										new Node("Karlsruhe", null, 0, 0)
								, 0, 0)
						, 0, 0)
				, 0, 0)
			, 0, 0);
		assertTrue(test.equals(actual));
	}
	
	@Test
	public void test3() {
		BuildGraph graph = new BuildGraph("input.txt");
		Node test = Search.uniformCostSearch(graph, "London", "Frankfurt");
		Node actual = new Node("",null, 0, 0);
		assertTrue(test.equals(actual));
	}
	
	@Test
	public void test4() {
		BuildGraph graph = new BuildGraph("input.txt");
		Node test = Search.uniformCostSearch(graph, "Dortmund", "Dortmund");
		Node actual = new Node("Dortmund",null, 0, 0);
		assertTrue(test.equals(actual));
	}
	
	@Test
	public void test5() {
		BuildGraph graph = new BuildGraph("input.txt");
		Node test = Search.uniformCostSearch(graph, "Munich", "Hannover");
		Node actual = new Node("Hannover", 
				new Node("Magdeburg", 
						new Node("Leipzig", 
								new Node("Nuremberg", 
										new Node("Munich", null, 0, 0)
								, 0, 0)
						, 0, 0)
				, 0, 0)
			, 0, 0);
		assertTrue(test.equals(actual));
	}
}
