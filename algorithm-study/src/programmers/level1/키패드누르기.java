package programmers.level1;

import java.util.HashMap;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class 키패드누르기 {

	public String solution(int[] numbers, String hand) {
		// 키패드 배열
		int[][] n = new int[4][3];

		n[0][0] = 1;
		n[0][1] = 2;
		n[0][2] = 3;
		n[1][0] = 4;
		n[1][1] = 5;
		n[1][2] = 6;
		n[2][0] = 7;
		n[2][1] = 8;
		n[2][2] = 9;
		n[3][0] = 99;
		n[3][1] = 0;
		n[3][2] = 99;

		// 양 손의 초기 위치 * #
		HashMap<String, Integer> lHand = new HashMap<String, Integer>();
		lHand.put("x", 3);
		lHand.put("y", 0);

		HashMap<String, Integer> rHand = new HashMap<String, Integer>();
		rHand.put("x", 3);
		rHand.put("y", 2);

		StringBuilder sb = new StringBuilder();

		for (int num : numbers) {
			if (num == 1) {
				sb.append("L");
				lHand.replace("x", 0);
				lHand.replace("y", 0);
			} else if (num == 4) {
				sb.append("L");
				lHand.replace("x", 1);
				lHand.replace("y", 0);
			} else if (num == 7) {
				sb.append("L");
				lHand.replace("x", 2);
				lHand.replace("y", 0);
			} else if (num == 3) {
				sb.append("R");
				rHand.replace("x", 0);
				rHand.replace("y", 2);
			} else if (num == 6) {
				sb.append("R");
				rHand.replace("x", 1);
				rHand.replace("y", 2);
			} else if (num == 9) {
				sb.append("R");
				rHand.replace("x", 2);
				rHand.replace("y", 2);
			} else {
				int nX = 0, nY = 0;

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						if (n[i][j] == num) {
							nX = i;
							nY = j;
						}
					}
				}

				int lDist = Math.abs(nX - lHand.get("x")) + Math.abs(nY - lHand.get("y"));
				int rDist = Math.abs(nX - rHand.get("x")) + Math.abs(nY - rHand.get("y"));

				if (lDist < rDist) {
					sb.append("L");
					lHand.replace("x", nX);
					lHand.replace("y", nY);
				} else if (rDist < lDist) {
					sb.append("R");
					rHand.replace("x", nX);
					rHand.replace("y", nY);
				} else {
					if (hand.equals("left")) {
						sb.append("L");
						lHand.replace("x", nX);
						lHand.replace("y", nY);
					} else {
						sb.append("R");
						rHand.replace("x", nX);
						rHand.replace("y", nY);
					}
				}
			} // if (2, 5, 8, 0)

		} // for

		return sb.toString();
	}
}
