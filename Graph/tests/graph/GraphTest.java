package graph;

import static org.junit.Assert.*;
import graph.Graph.Pair;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph gr;

	private LinkedList<Pair> coord = new LinkedList<>();

	private int[][] a;

	@Before
	public void setup() {
		gr = new Graph();
		a = new int[][] { 
				{ 2, 1, 3 }, 
				{ 1, 1, 2 }, 
				{ 3, 3, 2 }, };

	}

	@Test
	public void testNumberOne() {
		coord.clear();
		
		coord.add(new Pair(0, 0));

		assertEquals(1, gr.findAll(a, 0, 0).size());
		
		assertEquals(coord, gr.findAll(a, 0, 0));

	}

	@Test
	public void testNumberTwo() {

		coord.clear();

		coord.add(new Pair(2, 2));
		coord.add(new Pair(1, 2));

		assertEquals(2, gr.findAll(a, 2, 2).size());
		assertEquals(coord, gr.findAll(a, 2, 2));

	}

	@Test
	public void testNumberThree() {

		coord.clear();

		coord.add(new Pair(2, 0));
		coord.add(new Pair(2, 1));

		assertEquals(coord.toString(), gr.findAll(a, 2, 0).toString());
		
	}

}
