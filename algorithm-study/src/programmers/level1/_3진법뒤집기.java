package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/68935
public class _3���������� {
	public int solution(int n) {
		int answer = 0;
		String str = "";

		// #1. 3�������� �ٲٱ�
		while (n >= 3) {
			str = (n % 3) + str;
			n = n / 3;
		}
		// ������ �� ��ġ��
		str = n + str;

		// #2. 10�������� �ٲٱ�
		for (int i = 0; i < str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			answer += tmp * Math.pow(3, i);
		}
		return answer;
	}
}
