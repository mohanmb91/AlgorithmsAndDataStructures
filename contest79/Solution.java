package contest79;

import java.util.*;

class Solution {
	public double largestTriangleArea(int[][] points) {

		int n = points.length;
		double max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					max = Math.max(max, areaPoly2(points[i], points[j], points[k]));
				}
			}
		}
		return max / 2;
	}

	public long areaPoly2(int[]... co) {
		int n = co.length;
		long s = 0;
		for (int i = 0, j = 1; i < n; i++, j++) {
			if (j == n)
				j = 0;
			s += (long) co[i][0] * co[j][1] - (long) co[j][0] * co[i][1];
		}
		return Math.abs(s);
	}
}
