package programmers.weekchallenge;

public class Week4 {
	public static void main(String[] args) {
		String[] table = new String[] {
				// 5 4 3 2 1
				"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };

		String[] languages = new String[] { "PYTHON", "C++", "SQL" };

		int[] preference = new int[] { 7, 5, 5 };

//		String res = solution(table, languages, preference);
//		System.out.println(res);
		System.out.println( "ba".compareToIgnoreCase("apple") );
	}

	// ������ ��� ������ ������ ���ڿ� �迭 table
	// �����ڰ� ����ϴ� �� ���� ���ڿ� �迭 languages
	// ��� ��ȣ���� ���� ���� �迭 preference
	public static String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		int tableLen = table.length;
		int lanLen = languages.length;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < tableLen; i++) {
			String[] scores = table[i].split(" ");
			int sum = 0;
			for (int j = 0; j < lanLen; j++) {
				for (int k = 1; k < 6; k++) {
					if (scores[k].equals(languages[j])) {
						sum += (6 - k) * preference[j];
					}
				}
			}
			if (max == sum) {
				if( answer.compareToIgnoreCase( scores[0] ) > 0 ) {
					answer = scores[0];
				}
			} else if (max < sum) {
				max = sum;
				answer = scores[0];
			}
		}
		return answer;
	}
}
