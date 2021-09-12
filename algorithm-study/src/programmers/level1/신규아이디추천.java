package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/72410
public class �űԾ��̵���õ {
	
	public String solution(String new_id) {
		// #1. �޾ƿ� �Ķ���� �ҹ��ڷ� ġȯ
		String answer = new_id.toLowerCase();

		// #2. �ҹ���(97-122), ����(48-57), -(45) .(46) _(95)�� ������ ��� ���ڸ� ����
		for (int i = 0; i < answer.length(); i++) {
			char c = answer.charAt(i);
			boolean b = c < 45 || c == 47 || (c > 57 && c < 95) || c == 96 || c > 122;
			if (c < 45 || c == 47 || (c > 57 && c < 95) || c == 96 || c > 122) {
				answer = answer.replace(Character.toString(c), "");
				i--;
			}
		}

		// #3. ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ
		for (int i = 0; i < answer.length(); i++) {
			answer = answer.replace("..", ".");
		}

		// #4. ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� ����
		while (answer.startsWith(".")) {
			if (answer.startsWith("."))
				answer = answer.substring(1, answer.length());
		}
		while (answer.endsWith(".")) {
			if (answer.endsWith("."))
				answer = answer.substring(0, answer.length() - 1);
		}

		// #5. �� ���ڿ��̶��, new_id�� "a"�� ����
		if (answer.length() < 1)
			answer = "a";

		// #6. ���̰� 16�� �̻��̸�,
		// new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
		if (answer.length() > 15)
			answer = answer.substring(0, 15);

		// ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ�
		// ���� ��ġ�� ��ħǥ(.) ���ڸ� ����
		if (answer.endsWith("."))
			answer = answer.substring(0, answer.length() - 1);

		// #7. new_id�� ���̰� 2�� ���϶��
		// new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�
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
