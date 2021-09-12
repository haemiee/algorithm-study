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

        double[] �·� = new double[tot];
        int[] ���ſ���̱�Ƚ�� = new int[tot];
        
        // �·� & ���ſ� ���� �̱� Ƚ�� ���ϱ�
        for( int i=0; i<tot; i++ ) {
            int round = 0;
        	double winCnt = 0;
        	// ex) "NLWL" >> "N" "L" "W" "L"
        	String[] h2h = head2head[i].split("");
        	
        	// i��° ������ ������
        	int weight = weights[i];
        	
        	for( int j=0; j<tot; j++ ) {
        		// �ڱ� �ڽŰ��� ���а���� ��� pass
        		if( j == i ) continue;
        		
        		// ��� ���� ��� ���� �� ���� �ʱ�
                if( !h2h[j].equals("N")  ){
                    round++;
                }
                
        		// j��° ���� �̱� ���
        		if( h2h[j].equals("W") ) {
        			// �¸� Ƚ�� +1
        			winCnt++;
        			// j��° ������ �����԰� �� ���ſ� ��� > ���ſ� ���� �̱� Ƚ�� +1 
        			if( weight < weights[j] ) ���ſ���̱�Ƚ��[i]++;
        		}
        	}
            if( round == 0 ){
                �·�[i] = 0;
            } else {
                �·�[i] = winCnt / round ;      
            }
        }
        
        for( int i=0; i<tot; i++ ) {
        	for( int j=i+1; j<tot; j++ ) {
        		// �·� ��
        		if( �·�[answer[i]-1] < �·�[answer[j]-1] ) {
        			int tmp = answer[i];
        			answer[i] = answer[j];
        			answer[j] = tmp;
       			// �·��� ���� ���
        		} else if( �·�[answer[i]-1] == �·�[answer[j]-1] ) {
        			// ���ſ� ���� �̱� Ƚ�� ��
        			if( ���ſ���̱�Ƚ��[answer[i]-1] < ���ſ���̱�Ƚ��[answer[j]-1] ) {
        				int tmp = answer[i];
            			answer[i] = answer[j];
            			answer[j] = tmp;
            		// ���ſ� ���� �̱� Ƚ���� ���� ���
        			} else if( ���ſ���̱�Ƚ��[answer[i]-1] == ���ſ���̱�Ƚ��[answer[j]-1] ) {
        				// ������ ��
        				if( weights[answer[i]-1] < weights[answer[j]-1] ) {
        					int tmp = answer[i];
                			answer[i] = answer[j];
                			answer[j] = tmp;
                		// �����԰� ���� ���
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
