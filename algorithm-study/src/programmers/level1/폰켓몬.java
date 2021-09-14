package programmers.level1;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/1845
public class ÆùÄÏ¸ó {
	public int solution(int[] nums) {
		HashMap<Integer, Integer> pon = new HashMap<Integer, Integer>();
		int answer = 0;
		for (int n : nums) {
			if (pon.get(n) == null) {
				pon.put(n, 1);
			} else {
				pon.put(n, pon.get(n) + 1);
			}
		}
		int n = nums.length / 2;
		if (pon.size() < n) {
			answer = pon.size();
		} else {
			answer = n;
		}
		return answer;
	}
}
