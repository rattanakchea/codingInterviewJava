package codingInterviewJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubList {

	public static void main(String[] args) {

		SubList s = new SubList();
		int[] nums = new int[] { 1, 2, 3 };

		s.subSets(nums);
	}

	public List<List<Integer>> subSets(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);

		System.out.print(list);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}