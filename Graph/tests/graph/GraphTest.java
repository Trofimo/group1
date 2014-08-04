package graph;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	 private Graph gr;
	private LinkedList<String>up=new LinkedList<>();
	private LinkedList<String>d=new LinkedList<>();
	private LinkedList<String>left=new LinkedList<>();
	private LinkedList<String>r=new LinkedList<>();
	@Before
	public void setup(){
		gr=new Graph();
        gr.a = new int[][] { 
        	{ 1, 1, 1 ,2 },   
            { 1, 1, 2 ,2 }, 
            { 1, 1, 1, 0 },
            { 2, 1, 1, 2 }, 
          };
		
	}
	
	@Test
	public void testUp() {
		up.clear();
		up.add(0,"21");
		up.add(1,"11");
		up.add(2,"01");
		
		assertEquals(up, gr.findUp(3,1));
		
	}
	
	@Test
	public void testDown() {
		d.clear();
		d.add(0,"10");
		d.add(1,"20");
		
		assertEquals(d, gr.findDown(0,0));
		
	}
	
	@Test
	public void testLeft() {
		
		left.clear();
		left.add(0,"21");
		left.add(1,"20");
		assertEquals(left, gr.findLeft(2,2));
	}
	
	@Test
	public void testRight() {
		r.clear();
		r.add(0,"21");
		r.add(1,"22");
		assertEquals(r, gr.findRight(2,0));
	}
}
