package programmers.weekchallenge;

public class Week6 {
	public static void main(String[] args) {
		int[] weights = {60,70,60};
		String[] head2head = {"NNN","NNN","NNN"};
		
		int[] answer = solution( weights, head2head );
		for( int i : answer ) {
			System.out.println( i );
		}
	}
	
	public static int[] solution(int[] weights, String[] head2head) {
		int tot = weights.length;
		
        int[] answer = new int[tot];
        // {1,2,3};
        for( int i=0; i<tot; i++ ) {
        	answer[i] = i+1;
        }

        double[] 승률 = new double[tot];
        int[] 무거운복서이긴횟수 = new int[tot];
        
        // 승률 & 무거운 복서 이긴 횟수 구하기
        for( int i=0; i<tot; i++ ) {
            int round = 0;
        	double winCnt = 0;
        	// ex) "NLWL" >> "N" "L" "W" "L"
        	String[] h2h = head2head[i].split("");
        	
        	// i번째 선수의 몸무게
        	int weight = weights[i];
        	
        	for( int j=0; j<tot; j++ ) {
        		// 자기 자신과의 승패결과인 경우 pass
        		if( j == i ) continue;
        		
        		// 경기 안한 경우 라운드 수 세지 않기
                if( !h2h[j].equals("N")  ){
                    round++;
                }
                
        		// j번째 선수 이긴 경우
        		if( h2h[j].equals("W") ) {
        			// 승리 횟수 +1
        			winCnt++;
        			// j번째 선수의 몸무게가 더 무거운 경우 > 무거운 복서 이긴 횟수 +1 
        			if( weight < weights[j] ) 무거운복서이긴횟수[i]++;
        		}
        	}
            if( round == 0 ){
                승률[i] = 0;
            } else {
                승률[i] = winCnt / round ;      
            }
        }
        
        for( int i=0; i<tot; i++ ) {
        	for( int j=i+1; j<tot; j++ ) {
        		// 승률 비교
        		if( 승률[answer[i]-1] < 승률[answer[j]-1] ) {
        			int tmp = answer[i];
        			answer[i] = answer[j];
        			answer[j] = tmp;
       			// 승률이 같은 경우
        		} else if( 승률[answer[i]-1] == 승률[answer[j]-1] ) {
        			// 무거운 복서 이긴 횟수 비교
        			if( 무거운복서이긴횟수[answer[i]-1] < 무거운복서이긴횟수[answer[j]-1] ) {
        				int tmp = answer[i];
            			answer[i] = answer[j];
            			answer[j] = tmp;
            		// 무거운 복서 이긴 횟수가 같은 경우
        			} else if( 무거운복서이긴횟수[answer[i]-1] == 무거운복서이긴횟수[answer[j]-1] ) {
        				// 몸무게 비교
        				if( weights[answer[i]-1] < weights[answer[j]-1] ) {
        					int tmp = answer[i];
                			answer[i] = answer[j];
                			answer[j] = tmp;
                		// 몸무게가 같은 경우
        				} else if( weights[answer[i]-1] == weights[answer[j]-1] ) {
        					if( answer[i] > answer[j]) {
        						int tmp = answer[i];
                    			answer[i] = answer[j];
                    			answer[j] = tmp;
        					}
        				}
        			}
        		}
        	}
        }

        return answer;
    }
	
}
