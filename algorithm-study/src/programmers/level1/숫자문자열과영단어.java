package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/81301
public class 숫자문자열과영단어 {
	
	public int solution(String s) {

		String[] intNum = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String[] strNum = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int i = 0; i < 10; i++) {
			s = s.replace(strNum[i], intNum[i]);
		}
		return Integer.parseInt(s);
	}
	
}
