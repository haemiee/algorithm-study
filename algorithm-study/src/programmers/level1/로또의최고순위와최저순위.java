package programmers.level1;


// https://programmers.co.kr/learn/courses/30/lessons/77484
public class 로또의최고순위와최저순위 {
	
	public int[] solution( int[] lottos, int[] win_nums ) {
	       
        int [] answer = {};
        
		// zero_cnt : 알아볼 수 없는 번호의 개수
        int zero_cnt = 0;
        
        // win_cnt : 당첨 번호와 일치하는 번호의 개수
        int win_cnt = 0;
        
        // zero_cnt와 win_cnt 구하는 과정
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
        // 당첨 0 & 알아볼수 없는 숫자는 0이아닌경우 
        if(win_cnt == 0 && zero_cnt != 0) {
        	answer = new int [] {1, 6};
        }
        // 당첨 0 & 알아볼수 없는 숫자는 0인 경우
        else if(win_cnt == 0 && zero_cnt == 0) {
        	answer = new int [] {6, 6};
        }
        else {
			answer = new int[] { 7 - (win_cnt + zero_cnt), 7 - win_cnt };
		}
		return answer;
	}
}
