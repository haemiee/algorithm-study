package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12901
public class _2016³â {
	public String solution(int a, int b) {
		String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int[] days = { -1, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < a; i++) {
			b += days[i];
		}

		return day[b % 7];
	}
}
