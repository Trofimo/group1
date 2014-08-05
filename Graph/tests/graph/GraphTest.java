package graph;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph gr;
	private LinkedList<Integer>X=new LinkedList<>();
	private LinkedList<Integer>Y=new LinkedList<>();
	
	@Before
	public void setup(){
		gr=new Graph();
        gr.a = new int[][] { 
        		{ 1, 1, 1 }, 
        		{ 1, 1, 2 }, 
        		{ 3, 3, 2 }, };
        gr.b=new boolean[3][3];
	}
	
	
	
	@Test
	public void testNumberOne() {
		X.clear();
		Y.clear();
		
		X.add(0,0);Y.add(0,0);
		X.add(1,0);Y.add(1,1);
		X.add(2,0);Y.add(2,2);
		X.add(3,1);Y.add(3,0);
		X.add(4,1);Y.add(4,1);
		
		
		
		assertEquals(X, gr.findAllX(0,0));
		System.out.println("X: "+gr.findAllX(0,0));
		assertEquals(Y, gr.findAllY(0,0));
		System.out.println("Y: "+gr.findAllY(0,0));
	}
	@Test
	public void testNumberTwo() {
		X.clear();
		Y.clear();
		
		
		
		X.add(0,1);Y.add(0,2);
		X.add(1,2);Y.add(1,2);
		
		
		assertEquals(X, gr.findAllX(2,2));
		System.out.println("X: "+gr.findAllX(2,2));
		assertEquals(Y, gr.findAllY(2,2));
		System.out.println("Y: "+gr.findAllY(2,2));
	}
	@Test
	public void testNumberThree() {
		X.clear();
		Y.clear();
		
		
		
		X.add(0,2);Y.add(0,0);
		X.add(1,2);Y.add(1,1);
		
		
		assertEquals(X, gr.findAllX(2,0));
		System.out.println("X: "+gr.findAllX(2,0));
		assertEquals(Y, gr.findAllY(2,0));
		System.out.println("Y: "+gr.findAllY(2,0));
	}
}
