package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/42862
public class Ã¼À°º¹ {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] stu = new int[n];
		for (int i = 0; i < stu.length; i++) {
			stu[i] = 0;
		}
		for (int l : lost) {
			stu[l - 1]--;
		}
		for (int r : reserve) {
			stu[r - 1]++;
		}
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (stu[i] == -1 && stu[i + 1] == 1) {
					stu[i] = 0;
					stu[i + 1] = 0;
				}
			} else if (i == n) {
				if (stu[i] == -1 && stu[i - 1] == 1) {
					stu[i] = 0;
					stu[i - 1] = 0;
				}
			} else {
				if (stu[i] == -1 && stu[i + 1] == 1) {
					stu[i] = 0;
					stu[i + 1] = 0;
				}
				if (stu[i] == -1 && stu[i - 1] == 1) {
					stu[i] = 0;
					stu[i - 1] = 0;
				}
			}
		}
		for (int s : stu) {
			if (s > -1)
				answer++;
		}
		return answer;
	}
}
