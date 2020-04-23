

import java.util.*;
public class MaximumPossibleAmount {
	
	public static int maximumPossibleAmount(int a[], int start, int end) {
		if(start == end-1) {
			return Math.max(a[start], a[end]);
		}
		return Math.max(a[start] + Math.min(maximumPossibleAmount(a,start+2,end),maximumPossibleAmount(a, start+1, end-1)),  
					a[end] + Math.min(maximumPossibleAmount(a, start+1, end-1), maximumPossibleAmount(a, start, end-2)));
	}
}
