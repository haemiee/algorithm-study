package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/77884
public class 약수의개수와덧셈 {
	public int solution(int left, int right) {
		int answer = 0;
		int cnt = 0;
		for (int i = left; i <= right; i++) {
			// 약수 개수 구하기
			for (int j = 1; j <= i; j++) {
				if (i % j == 0)
					cnt++;
			}
			if (cnt % 2 == 0)
				answer += i;
			if (cnt % 2 != 0)
				answer -= i;
			cnt = 0;
		}

		return answer;
	}
}
