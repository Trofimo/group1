import java.util.ArrayList;
import java.util.Scanner;

//http://kvodo.ru/search-width.html
public class Example{

 static int n=5;
int i, j;
static boolean[] visited=new boolean[n];
//матрица смежнос ти графа
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
//Главная функция
public static void main(String[] args) {
	
	int start;
	System.out.println("Матрица смежности графа: ");
	
	for (int i=0; i<n; i++)
	{
	visited[i]=false;
	for (int j=0; j<n; j++)
	System.out.println(" "+graph[i][j]);
		
	}
	System.out.println("Стартовая вершина >> ");
	
	Scanner scanner = new Scanner(System.in);
	start=scanner.nextInt();
	
	//массив посещенных вершин
	boolean[]vis=new boolean[n];
	System.out.println("Порядок обхода: ");
	
	DFS(start-1);
	//delete []visited;
	
}

}