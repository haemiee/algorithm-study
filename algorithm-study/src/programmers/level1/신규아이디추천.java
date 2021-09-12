package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/72410
public class 신규아이디추천 {
	
	public String solution(String new_id) {
		// #1. 받아온 파라미터 소문자로 치환
		String answer = new_id.toLowerCase();

		// #2. 소문자(97-122), 숫자(48-57), -(45) .(46) _(95)를 제외한 모든 문자를 제거
		for (int i = 0; i < answer.length(); i++) {
			char c = answer.charAt(i);
			boolean b = c < 45 || c == 47 || (c > 57 && c < 95) || c == 96 || c > 122;
			if (c < 45 || c == 47 || (c > 57 && c < 95) || c == 96 || c > 122) {
				answer = answer.replace(Character.toString(c), "");
				i--;
			}
		}

		// #3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
		for (int i = 0; i < answer.length(); i++) {
			answer = answer.replace("..", ".");
		}

		// #4. 마침표(.)가 처음이나 끝에 위치한다면 제거
		while (answer.startsWith(".")) {
			if (answer.startsWith("."))
				answer = answer.substring(1, answer.length());
		}
		while (answer.endsWith(".")) {
			if (answer.endsWith("."))
				answer = answer.substring(0, answer.length() - 1);
		}

		// #5. 빈 문자열이라면, new_id에 "a"를 대입
		if (answer.length() < 1)
			answer = "a";

		// #6. 길이가 16자 이상이면,
		// new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
		if (answer.length() > 15)
			answer = answer.substring(0, 15);

		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면
		// 끝에 위치한 마침표(.) 문자를 제거
		if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);

		// #7. new_id의 길이가 2자 이하라면
		// new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
		if (answer.length() <= 2) {
			int end_idx = answer.length() - 1;
			char end_word = answer.charAt(end_idx);
			do {
				answer += end_word;
			} while (answer.length() < 3);
		}

		return answer;
	}
}
