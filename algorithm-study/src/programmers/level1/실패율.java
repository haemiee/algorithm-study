package programmers.level1;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42889
public class 실패율 {
	public int[] solution(int N, int[] stages) {
		// 총 유저 수 : 스테이지 배열의 길이와 같음
		double totalUser = stages.length;

		Map<Integer, Double> score = new HashMap<Integer, Double>();
		Map<Integer, Double> failureRateMap = new HashMap<Integer, Double>();

		double failureRate = 0.0;

		// map 초기화
		for (int i = 1; i <= N + 1; i++) {
			score.put(i, 0.0);
		}

		// 각 스테이지별 점수 맞춰서 넣기
		for (int s : stages) {
			score.put(s, score.get(s) + 1);
		}
		score.remove(N + 1);

		// 실패율 계산
		for (int key : score.keySet()) {
			failureRate = score.get(key) / totalUser;
			failureRateMap.put(key, failureRate);
			totalUser -= score.get(key);
		}

		double[][] rank = new double[N + 1][2];

		for (int i = 1; i <= N; i++) {
			rank[i][0] = i;
			rank[i][1] = failureRateMap.get(i);
		}

		double tmp = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (rank[i][1] < rank[j][1] || (rank[i][1] == rank[j][1] && rank[i][0] > rank[j][0])) {
					tmp = rank[i][0];
					rank[i][0] = rank[j][0];
					rank[j][0] = tmp;

					tmp = rank[i][1];
					rank[i][1] = rank[j][1];
					rank[j][1] = tmp;
				}
			}
		}

		int[] answer = new int[N];

		for (int i = 1; i <= N; i++) {
			answer[i - 1] = (int) rank[i][0];
		}

		return answer;
	}
}
