package programmers.level1;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42576
public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String p : participant) {
			if (map.get(p) == null) {
				map.put(p, 1);
			} else {
				map.put(p, map.get(p) + 1);
			}
		}

		for (String c : completion) {
			map.put(c, map.get(c) - 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				answer = key;
				break;
			}
		}

		return answer;
	}
}
