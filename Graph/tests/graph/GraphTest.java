package graph;

import static org.junit.Assert.*;
import graph.Graph.Pair;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph gr;
	//private Pair p;
	private LinkedList<String>coord=new LinkedList<>();
	
	private int[][] a;
	
	@Before
	public void setup(){
		gr=new Graph();
        a = new int[][] { 
        		{ 1, 1, 1 }, 
        		{ 1, 1, 2 }, 
        		{ 3, 3, 2 }, 
        		};
        
	}
	
	
	
	@Test
	public void testNumberOne() {
		coord.clear();
		coord.add(0,(new Pair(0,0).getPair()));
		coord.add(1,(new Pair(0,1).getPair()));
		coord.add(2,(new Pair(0,2).getPair()));
		coord.add(3,(new Pair(1,0).getPair()));
		coord.add(4,(new Pair(1,1).getPair()));
		
		
		
		assertEquals(coord, gr.findAll(a,0,0));
		
		
	}
	@Test
	public void testNumberTwo() {
		coord.clear();
		coord.add(0,(new Pair(1,2).getPair()));
		coord.add(1,(new Pair(2,2).getPair()));
		
		
		
		assertEquals(coord, gr.findAll(a,2,2));
		
		
	}
	@Test
	public void testNumberThree() {
		coord.clear();
		coord.add(0,(new Pair(2,0).getPair()));
		coord.add(1,(new Pair(2,1).getPair()));
		
		
		
		
		assertEquals(coord, gr.findAll(a,2,0));
		
		
	}

	
	

}
