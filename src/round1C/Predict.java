package round1C;

import java.util.ArrayList;
import java.util.Scanner;

public class Predict {
	
	public static int[] process(final int windowSize, final float stringency, float[] T) {

		// Compute peak function values
		float[] S = new float[T.length];
		float maxLeft, maxRight;
		for (int i = windowSize; i < S.length - windowSize; i++) {

			maxLeft = T[i] - T[i - 1];
			maxRight = T[i] - T[i + 1];
			for (int j = 2; j <= windowSize; j++) {
				if (T[i] - T[i - j] > maxLeft)
					maxLeft = T[i] - T[i - j];
				if (T[i] - T[i + j] > maxRight)
					maxRight = T[i] - T[i + j];
			}
			S[i] = 0.5f * (maxRight + maxLeft);

		}

		// Compute mean and std of peak function
		float mean = 0;
		int n = 0;
		float M2 = 0;
		float delta;
		for (int i = 0; i < S.length; i++) {
			n = n + 1;
			delta = S[i] - mean;
			mean = mean + delta / n;
			M2 = M2 + delta * (S[i] - mean);
		}

		float variance = M2 / (n - 1);
		float std = (float) Math.sqrt(variance);

		// Collect only large peaks
		ArrayList<Integer> peakLocations = new ArrayList<Integer>();
		for (int i = 0; i < S.length; i++) {
			if (S[i] > 0 && (S[i] - mean) > stringency * std) {
				peakLocations.add(i);
			}
		}
		// System.out.println("1111111111111111111");
		// for (int i = 0; i < peakLocations.size(); i++) {
		// System.out.print( peakLocations.get(i)+"\t");
		// }
		// System.out.println("------------------");

		// Remove peaks too close
		ArrayList<Integer> toPrune = new ArrayList<Integer>();
		int peak1, peak2, weakerPeak;
		for (int i = 0; i < peakLocations.size() - 1; i++) {
			peak1 = peakLocations.get(i);
			peak2 = peakLocations.get(i + 1);

			if (peak2 - peak1 < windowSize) {
				// Too close, prune the smallest one
				if (T[peak2] > T[peak1])
					weakerPeak = peak1;
				else
					weakerPeak = peak2;
				toPrune.add(weakerPeak);
			}
		}

		// System.out.println("ppppppppppppppp");
		// for (int i = 0; i < toPrune.size(); i++) {
		// System.out.print( toPrune.get(i)+"\t");
		// }
		// System.out.println("------------------");

		peakLocations.removeAll(toPrune);

		// Convert to int[]
		int[] peakArray = new int[peakLocations.size()];
		for (int i = 0; i < peakArray.length; i++) {
			peakArray[i] = peakLocations.get(i);
		}
		return peakArray;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		float[] array = new float[546];
		
		for(int i = 1; i <= 545; i++)
		{
			String s = scan.nextLine();
			int lastSpace = s.lastIndexOf("\t");
//			System.out.println(s.substring(lastSpace + 1, s.length()));
			
			array[i] = Float.parseFloat(s.substring(lastSpace + 1, s.length()));
		}

		int[] peakIndexArray =  process(17, (float)2.4, array);
		
//		for(int index : peakIndexArray )
//			System.out.println(index);
		
//		int nextPeak = peakIndexArray[peakIndexArray.length - 1] + 52;
		
		int[] result = new int[51];
//		
//		if(nextPeak <= 595)
//		{
//			float sum = 0;
//			float weight = 0;
//			
//			for(int i = 0; i < peakIndexArray.length; i++)
//			{
//				sum = sum + array[peakIndexArray[i]] * (i+1)* (float)0.1;
//				weight = weight + (i+1)* (float)0.1;
//			}
//			
//			result[nextPeak - 545] = Math.round(sum/weight);
//			
//			System.out.println("value should be "+ Math.round(sum/weight));
//			
//			
//			for(int leftOffset =  1; nextPeak - leftOffset > 545; leftOffset++)
//			{
//				sum = 0;
//				weight = 0;
//				for(int i = 0; i < peakIndexArray.length; i++)
//				{
//					sum = sum + array[peakIndexArray[i] - leftOffset] * (float)0.1 * (i + 1);
//					weight = weight + (i+1)* (float)0.1;
//				}
//				result[nextPeak - 545 - leftOffset] = Math.round(sum/weight);
//				
//			}
//			
//			for(int rightOffset =  1; nextPeak + rightOffset <= 595; rightOffset++)
//			{
//				sum = 0;
//				weight = 0;
//				for(int i = 0; i < peakIndexArray.length; i++)
//				{
//					sum = sum + array[peakIndexArray[i] + rightOffset] * (float)0.1 * (i + 1);
//					weight = weight + (i+1)* (float)0.1;
//				}
//				result[nextPeak - 545 + rightOffset] = Math.round(sum/weight);
//				
//			}
//		}
//		
//		else
//		{
//			
//		}
		
		
		
		for(int i = 1; i <= 50; i++)
		{
			int offset = 52;
			float sum = 0;
			float weight = 0;
			int counter = 0;
			while(545 + i - offset > 0)
			{
				sum = sum + array[545 + i - offset] * (float)0.1 * (counter + 1);
				weight = weight + (counter+1)* (float)0.1;
				
				offset = offset + 52;
				counter++;
			}
			System.out.println(Math.round(sum/weight));
		}

		
	}

}
