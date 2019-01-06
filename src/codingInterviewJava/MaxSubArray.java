package codingInterviewJava;

// example
// A : [1, 2, 5, -7, 2, 3]
// The answer is [1, 2, 5] as its sum is larger than [2, 3]

// kadane's algorithm
public class MaxSubArray {
	public static void main() {

		MaxSubArray m = new MaxSubArray();
		int[] a = { 1, 2, 5, -7, 2, 3 };
		int answer = m.solve(a);
		System.out.print(answer);

	}

	public int solve(int[] a) {

		int current_sum = a[0];
		int global_sum = a[0];
		for (int i = 1; i < a.length; i++) {
			current_sum = Math.max(a[i], a[i] + current_sum);

			if (current_sum > global_sum) {
				global_sum = current_sum;
			}

		}
		return global_sum;
	}
}