package graph;

import static org.junit.Assert.*;
import graph.Graph.Pair;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph gr;
	//private Pair p;
	private LinkedList<Pair>coord=new LinkedList<>();
	
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
		
		Pair p = new Pair(0,0);
		coord.addAll((p.getPair()));
		
		Pair p1 = new Pair(0,1);
		coord.addAll((p1.getPair()));
		
		Pair p2 = new Pair(0,2);
		coord.addAll((p2.getPair()));
		
		Pair p3 = new Pair(1,0);
		coord.addAll((p3.getPair()));
		
		Pair p4 = new Pair(1,1);
		coord.addAll((p4.getPair()));
		
		
		
		for (Iterator<Pair> iterator = coord.iterator(); iterator.hasNext();) {
			
			assertEquals(coord.pop(), gr.findAll(a,0,0).pop());
		}
		
		
		
	}

	
	
		@Test
	public void testNumberTwo() {

			coord.clear();
			
			Pair p = new Pair(1,2);
			coord.addAll((p.getPair()));
			
			Pair p1 = new Pair(2,2);
			coord.addAll((p1.getPair()));
			
			
			
			
			
			for (Iterator<Pair> iterator = coord.iterator(); iterator.hasNext();) {
				
				assertEquals(coord.pop(), gr.findAll(a,2,2).pop());
			}
			
	}
	@Test
	public void testNumberThree() {

		coord.clear();
		
		Pair p = new Pair(2,0);
		coord.addAll((p.getPair()));
		
		Pair p1 = new Pair(2,1);
		coord.addAll((p1.getPair()));
		
		
		
		
		
		for (Iterator<Pair> iterator = coord.iterator(); iterator.hasNext();) {
			
			assertEquals(coord.pop(), gr.findAll(a,2,0).pop());
		}
	
	}

	
	

}
