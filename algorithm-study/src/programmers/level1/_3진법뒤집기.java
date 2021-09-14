package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/68935
public class _3진법뒤집기 {
	public int solution(int n) {
		int answer = 0;
		String str = "";

		// #1. 3진법으로 바꾸기
		while (n >= 3) {
			str = (n % 3) + str;
			n = n / 3;
		}
		// 마지막 몫 합치기
		str = n + str;

		// #2. 10진법으로 바꾸기
		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			answer += tmp * Math.pow(3, i);
		}
		return answer;
	}
}
