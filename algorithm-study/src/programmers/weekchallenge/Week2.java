package programmers.weekchallenge;

public class Week2 {

	public static void main(String[] args) {
	}

	public String solution( int[][] scores ) {
		StringBuffer answer = new StringBuffer();
		int len = scores.length;
		for( int i=0; i<len; i++ ) {
			int score = scores[i][i];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean b = true;
			double sum = 0.0;
			
			for( int j=0; j<len; j++) {
				int s = scores[j][i];
				
				if( ( i!=j ) && ( score == s ) ) {
					b = false;
				}
				
				min = Math.min(min, s);
				max = Math.max(max, s);
				
				sum += s;
			}
			
			if( b && ( score == min || score == max ) ) {
				sum -= score;
				answer.append( rank(sum / ( len - 1 )) );
				
			} else {
				answer.append( rank( sum / len ) );
			}
		}
		return answer.toString();
	}
	
	public String rank( double score ) {
		if( score >= 90.0 ) {
			return "A";
		} else if( score >= 80.0 ) {
			return "B";
		} else if( score >= 70.0 ) {
			return "C";
		} else if( score >= 50.0 ) {
			return "D";
		} else {
			return "F";
		}
	}
}
