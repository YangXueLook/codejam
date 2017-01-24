package googleChallenge;

public class TrappingWater {
	
	public static int answer(int[] heights) { 

		if (heights == null || heights.length == 0 || heights.length == 1 || heights.length == 2)
			return 0;

		int result = 0;

		int[] leftBounderArray = new int[heights.length];
		int[] rightBounderArray = new int[heights.length];

		leftBounderArray[0] = heights[0];
		for (int i = 1; i < heights.length; i++) {
			if (heights[i] <= heights[i - 1])
				leftBounderArray[i] = leftBounderArray[i - 1];
			else {
				if (heights[i] <= leftBounderArray[i - 1])
					leftBounderArray[i] = leftBounderArray[i - 1];
				else
					leftBounderArray[i] = heights[i];

			}
		}

		rightBounderArray[heights.length - 1] = heights[heights.length - 1];
		for (int i = heights.length - 2; i >= 0; i--) {
			if (heights[i] <= heights[i + 1])
				rightBounderArray[i] = rightBounderArray[i + 1];
			else {
				if (heights[i] <= rightBounderArray[i + 1])
					rightBounderArray[i] = rightBounderArray[i + 1];
				else
					rightBounderArray[i] = heights[i];

			}
		}

		for (int i = 0; i < heights.length; i++) {
			result = result + Math.min(leftBounderArray[i], rightBounderArray[i])
					- heights[i];
		}

		return result;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
