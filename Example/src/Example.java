import java.util.ArrayList;
import java.util.Scanner;

//http://kvodo.ru/search-width.html
public class Example{

 static int n=5;
int i, j;
static boolean[] visited=new boolean[n];
//������� ������� �� �����
static int[][] graph=new int[][]
{
{0, 1, 0, 0, 1},
{1, 0, 1, 1, 0},
{0, 1, 0, 0, 1},
{0, 1, 0, 0, 1},
{1, 0, 1, 1, 0}
};
//_______________________________________
public static void DFS(int st)
{
int r;
System.out.println(st+1+ " ");

visited[st]=true;
for (r=0; r<=n; r++)
if ((graph[st][r]!=0) && (!visited[r]))
DFS(r);
}
//_______________________________________
//������� �������
public static void main(String[] args) {
	
	int start;
	System.out.println("������� ��������� �����: ");
	
	for (int i=0; i<n; i++)
	{
	visited[i]=false;
	for (int j=0; j<n; j++)
	System.out.println(" "+graph[i][j]);
		
	}
	System.out.println("��������� ������� >> ");
	
	Scanner scanner = new Scanner(System.in);
	start=scanner.nextInt();
	
	//������ ���������� ������
	boolean[]vis=new boolean[n];
	System.out.println("������� ������: ");
	
	DFS(start-1);
	//delete []visited;
	
}

}