package programmers.level1;


// https://programmers.co.kr/learn/courses/30/lessons/77484
public class �ζ����ְ�������������� {
	
	public int[] solution( int[] lottos, int[] win_nums ) {
	       
        int [] answer = {};
        
		// zero_cnt : �˾ƺ� �� ���� ��ȣ�� ����
        int zero_cnt = 0;
        
        // win_cnt : ��÷ ��ȣ�� ��ġ�ϴ� ��ȣ�� ����
        int win_cnt = 0;
        
        // zero_cnt�� win_cnt ���ϴ� ����
        for( int i=0; i<6; i++ ){
            if( lottos[i] == 0 ){
                zero_cnt++; 
                continue;
            }
            
            for( int j=0; j<6; j++ ){
                if(lottos[i] == win_nums[j]){
                    win_cnt++;
                }    
            }
        }
        // ��÷ 0 & �˾ƺ��� ���� ���ڴ� 0�̾ƴѰ�� 
        if(win_cnt == 0 && zero_cnt != 0) {
        	answer = new int [] {1, 6};
        }
        // ��÷ 0 & �˾ƺ��� ���� ���ڴ� 0�� ���
        else if(win_cnt == 0 && zero_cnt == 0) {
        	answer = new int [] {6, 6};
        }
        else {
			answer = new int[] { 7 - (win_cnt + zero_cnt), 7 - win_cnt };
		}
		return answer;
	}
}
