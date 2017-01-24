package googleChallenge;

public class TriangleLand {
	static class LineSegment {
		double k;
		double b;
		int left;
		int right;
		int top;
		int bottom;

	}

	public static int answer(int[][] vertices) {
		int left = Math.min(Math.min(vertices[0][0], vertices[1][0]),
				vertices[2][0]);
		int right = Math.max(Math.max(vertices[0][0], vertices[1][0]),
				vertices[2][0]);
		int bottom = Math.min(Math.min(vertices[0][1], vertices[1][1]),
				vertices[2][1]);
		int top = Math.max(Math.max(vertices[0][1], vertices[1][1]),
				vertices[2][1]);
		
		LineSegment l1 = new LineSegment();
		l1.left = Math.min(vertices[0][0], vertices[1][0]);
		l1.right = Math.max(vertices[0][0], vertices[1][0]);
		l1.bottom = Math.min(vertices[0][1], vertices[1][1]);
		l1.top = Math.max(vertices[0][1], vertices[1][1]);
		
		if(vertices[0][0] == vertices[1][0])
			l1.k = Double.MAX_VALUE;
		else
			l1.k = (double)(vertices[0][1] - vertices[1][1])/(double)(vertices[0][0] - vertices[1][0]);
		
		if(vertices[0][0] == vertices[1][0])
			l1.b = vertices[0][0];
		else
			l1.b = (double)vertices[0][1] - l1.k * (double)vertices[0][0];
		
		
		
		LineSegment l2 = new LineSegment();
		l2.left = Math.min(vertices[1][0], vertices[2][0]);
		l2.right = Math.max(vertices[1][0], vertices[2][0]);
		l2.bottom = Math.min(vertices[1][1], vertices[2][1]);
		l2.top = Math.max(vertices[1][1], vertices[2][1]);
		
		if(vertices[1][0] == vertices[2][0])
			l2.k = Double.MAX_VALUE;
		else
			l2.k = (double)(vertices[1][1] - vertices[2][1])/(double)(vertices[1][0] - vertices[2][0]);
		
		if(vertices[1][0] == vertices[2][0])
			l2.b = vertices[1][0];
		else
			l2.b = (double)vertices[1][1] - l2.k * (double)vertices[1][0];
		
		LineSegment l3 = new LineSegment();
		l3.left = Math.min(vertices[0][0], vertices[2][0]);
		l3.right = Math.max(vertices[0][0], vertices[2][0]);
		l3.bottom = Math.min(vertices[0][1], vertices[2][1]);
		l3.top = Math.max(vertices[0][1], vertices[2][1]);
		
		if(vertices[0][0] == vertices[2][0])
			l3.k = Double.MAX_VALUE;
		else
			l3.k = (double)(vertices[0][1] - vertices[2][1])/(double)(vertices[0][0] - vertices[2][0]);
		
		if(vertices[0][0] == vertices[2][0])
			l3.b = vertices[0][0];
		else
			l3.b = (double)vertices[0][1] - l3.k * (double)vertices[0][0];
		
		for(int i = left + 1; i < right; i++)
		{
			double a1 = getValue(l1, i);
		}
		

		return 0;
	}

	private static double getValue(LineSegment l, int i) {
		if(l.k == Double.MAX_VALUE)
			return Double.MAX_VALUE;
		
		else 
		{
			
		}
			return
		
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
