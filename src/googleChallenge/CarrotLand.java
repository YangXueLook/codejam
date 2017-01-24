package googleChallenge;

import java.math.BigInteger;

public class CarrotLand {
	// Based on Pick's theorem algorithm: http://stackoverflow.com/a/1049604/60261
    public static int answer(int[][] vertices) {
        long left = Math.min(Math.min(vertices[0][0], vertices[1][0]), vertices[2][0]);
        long right = Math.max(Math.max(vertices[0][0], vertices[1][0]), vertices[2][0]);
        long bottom = Math.min(Math.min(vertices[0][1], vertices[1][1]), vertices[2][1]);
        long top = Math.max(Math.max(vertices[0][1], vertices[1][1]), vertices[2][1]);

        long j = right - left;
        long k = top - bottom;

        long totalPointsInRec = (j - 1) * (k - 1);

       //acute triangle: rectangle - 3 * (outside triangle + points on edges)
        for (int i = 0; i < 3; i++) {
            int[] p1 = vertices[i];
            int[] p2 = i == 2 ? vertices[0] : vertices[i + 1];

            if (noOutsideTriangle(p1, p2)) {
            	//not outside triangle
                continue;
            }

            long pointsOnDiagonal = getPointsOnDiagonal(p1, p2);

            long width = Math.abs(p1[0] - p2[0]);
            long height = Math.abs(p1[1] - p2[1]);

            long outsideTrianglePoints = ((width - 1) * (height - 1) - pointsOnDiagonal)/2;
            // remove outside triangle points and points on diagonal
            totalPointsInRec = totalPointsInRec - outsideTrianglePoints - pointsOnDiagonal;
            		
        }

        // obtuse triangle
        for (int i = 0; i < 3; i++) {
            long x = vertices[i][0];
            long y = vertices[i][1];

            if (x == left || x == right || y == top || y == bottom) {
                continue;
            }

            // This implies that the other two points *are* the corners of the bounding rectangle
            int[] corner1 = vertices[(i + 1) % 3];
            int[] corner2 = vertices[(i + 2) % 3];

            // Therefore, these are the last two corners
            int[] corner3 = new int[] {
                corner1[0],
                corner2[1]
            };
            int[] corner4 = new int[] {
                corner2[0],
                corner1[1]
            };

            // Find the corner that's closer; that area between this point and that corner is *not* part
            // of the triangle.
            double d3 = distance(x, y, corner3[0], corner3[1]);
            double d4 = distance(x, y, corner4[0], corner4[1]);

            int[] corner = d3 < d4 ? corner3 : corner4;

            // Subtract the double-counted area from the corner
            long width = Math.abs(corner[0] - x);
            long height = Math.abs(corner[1] - y);

            totalPointsInRec -= width * height;
        }

        return (int) totalPointsInRec;
    }

    static boolean noOutsideTriangle(int[] p1, int[] p2) {
        return p1[0] == p2[0] || p1[1] == p2[1];
    }

    static int getPointsOnDiagonal(int[] p1, int[] p2) {
        return gcd(p2[0] - p1[0], p2[1] - p1[1]) - 1;
    }

    static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }

    static double distance(long x1, long y1, long x2, long y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

	public static void main(String[] args) {
		System.out.println(answer(new int[][]{{-1, -1}, {1, 0},{0, 1}}));

	
		System.out.println(answer(new int[][]{{91207, 89566}, {-88690, -83026},{67100, 47194}}));

	}

}
