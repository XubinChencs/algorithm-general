package zdzxls;

/**
 * 基于这样一个事实，最大和子序列要么在中点左边，要么在中点右边，要么
 * 包含中点（中点是一个虚的点，不是真是存在的，比如i和i+1之间）
 * @author liyuncong
 *
 */
public class MaxSubSum3 implements MaxSubSum {

	public int maxSubSum(int[] a) {
		return maxSubSum(a, 0, a.length - 1);
	}

	public int maxSubSum(int[] a, int left, int right) {
		if (left == right) {
			if (a[left] > 0) {
				return a[left];
			} else {
				return 0;
			}
		}

		int center = (left + right) / 2;
		int maxLeftSubSum = maxSubSum(a, left, center);
		int maxRightSubSum = maxSubSum(a, center + 1, right);

		int maxLeftBorderSum = 0;
		int leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum) {
				maxLeftBorderSum = leftBorderSum;
			}
		}

		int maxRightBorderSum = 0;
		int RightBorderSum = 0;
		for (int j = center + 1; j <= right; j++) {
			RightBorderSum += a[j];
			if (maxRightBorderSum < RightBorderSum) {
				maxRightBorderSum = RightBorderSum;
			}
		}
		return max(maxLeftSubSum, maxRightSubSum, maxLeftBorderSum
				+ maxRightBorderSum);
	}

	public int max(int num1, int num2, int num3) {
		return num1 > num2 ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2
				: num3);
	}
	
	public static void main(String args[]) {
		System.out.println(new MaxSubSum3().max(34, 14, 25));
	}

}
