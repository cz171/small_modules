package closestPoints;

import java.util.Arrays;

public class Solution {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	static double dist(Point p1, Point p2) {
		return Math.sqrt(Math.pow((double)(p1.x - p2.x), 2) + Math.pow((double)(p1.y - p2.y), 2));
	}
	
	static double bruteForce(Point[] points) {
		double min = Double.MAX_VALUE;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				min = Math.min(min, dist(points[i], points[j]));
			}
		}
		return min;
	}
	
	private double stripClosest(Point[] strip, int size, double d) {
		double min = d;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size && strip[j].y - strip[i].y < min; j++) {
				min = dist(strip[i], strip[j]);
			}
		}
		return min;
	}
	
	public static double closestDist(Point[] pointsX, Point[] pointsY, int n) {
		if (n <= 3) {
			return bruteForce(pointsX);
		}
		
		int mid = n / 2;
		Point midPoint = pointsX[mid];
		
		Point[] pointsYLeft = new Point[mid + 1];
		Point[] pointsYRight = new Point[n - mid+ 1];
		int li = 0;
		int ri = 0;
		for (int i = 0; i < n; i++) {
			if (pointsY[i].x <= midPoint.x) {
				pointsYLeft[li++] = pointsY[i];
			} else {
				pointsYRight[ri++] = pointsY[i];
			}
		}
		
		double dl = closestDist(pointsX, pointsY, mid);
		double dr = closestDist(pointsX)
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
