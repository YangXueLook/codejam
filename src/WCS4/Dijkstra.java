package WCS4;

import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		int[][] e = new int[10][10];
		int[] dis = new int[10];
		int[] book = new int[10];
		int i,j,n,m,t1,t2,t3,u = 0,v,min;
	    int inf=99999999; //��inf(infinity����д)�洢һ��������Ϊ��������ֵ
	    //����n��m��n��ʾ���������m��ʾ�ߵ�����
	    Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
	                                                                   
	    //��ʼ��
	    for(i=1;i<=n;i++)
	        for(j=1;j<=n;j++)
	            if(i==j) e[i][j]=0;
	              else e[i][j]=inf;
	                                                                             
	    //�����
	    for(i=1;i<=m;i++)
	    {
	    	t1 = in.nextInt();
			t2 = in.nextInt();
			t3 = in.nextInt();

			e[t1][t2] = t3;
	    }
	    //��ʼ��dis���飬������1�Ŷ��㵽�����������ĳ�ʼ·��
	    for(i=1;i<=n;i++)
	        dis[i]=e[1][i];
	    //book�����ʼ��
	    for(i=1;i<=n;i++)
	        book[i]=0;
	    book[1]=1;
	                                                                   
	    //Dijkstra�㷨�������
	    for(i=1;i<=n-1;i++)
	    {
	        //�ҵ���1�Ŷ�������Ķ���
	        min=inf;
	        for(j=1;j<=n;j++)
	        {
	            if(book[j]==0 && dis[j]<min)
	            {
	                min=dis[j];
	                u=j;
	            }
	        }
	        book[u]=1;
	        for(v=1;v<=n;v++)
	        {
	            if(e[u][v]<inf)
	            {
	                if(dis[v]>dis[u]+e[u][v])
	                    dis[v]=dis[u]+e[u][v];
	            }
	        }
	    }
	                                                                   
	    //������յĽ��
	    for(i=1;i<=n;i++)
	        System.out.print(dis[i] + "\t");
	                                                                       
	    

	}

}
