package MaxPossibleAmount;

import java.util.*;
public class MaximumPossibleAmountMemoized {
	
	public static int maximumPossibleAmount(int a[], int start, int end, int maxMat[][]) {
		if(start == end-1) {
			maxMat[start][end] = Math.max(a[start], a[end]);
			return maxMat[start][end];
		}
		if(maxMat[start][end] != -1) {
			return maxMat[start][end];
		}
		maxMat[start][end] = Math.max(a[start] + Math.min(maximumPossibleAmount(a,start+2,end,maxMat),maximumPossibleAmount(a, start+1, end-1,maxMat)),  
				a[end] + Math.min(maximumPossibleAmount(a, start+1, end-1,maxMat), maximumPossibleAmount(a, start, end-2,maxMat)));  
		return maxMat[start][end];
	}
}
