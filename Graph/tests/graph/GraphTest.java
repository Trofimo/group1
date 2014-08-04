package graph;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph gr;
	private LinkedList<String>l=new LinkedList<>();
	
	@Before
	public void setup(){
		gr=new Graph();
        gr.a = new int[][] { 
        	{ 1, 1, 1 ,1 ,1},   
            { 1, 1, 2 ,2 ,1}, 
            { 1, 1, 1, 0 ,1},
            { 1, 1, 1, 0 ,1},
            { 2, 1, 1, 2 ,1}, 
          };
       gr.b=new boolean[5][5];
	}
	
	
	
	@Test
	public void testUp() {
		l.clear();
		l.add(0,"44");
		l.add(1,"34");
		l.add(2,"24");
		l.add(3,"14");
		l.add(4,"04");
		System.out.println(l);
		
		assertEquals(l, gr.findUp(4,4));
		
	}
	
	@Test
	public void testDown() {
		l.clear();
		l.add(0,"00");
		l.add(1,"10");
		l.add(2,"20");
		l.add(3,"30");
		
		assertEquals(l, gr.findDown(0,0));
		
	}
	
	@Test
	public void testLeft() {
		
		l.clear();
		l.add(0,"22");
		l.add(1,"21");
		l.add(2,"20");
		assertEquals(l, gr.findLeft(2,2));
	}
	
	@Test
	public void testRight() {
		l.clear();
		l.add(0,"00");
		l.add(1,"01");
		l.add(2,"02");
		l.add(3,"03");
		l.add(4,"04");
		
		
		assertEquals(l, gr.findRight(0,0));
	}
}
