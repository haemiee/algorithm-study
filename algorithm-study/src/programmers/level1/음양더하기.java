package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/76501
public class 음양더하기 {

	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            // signs[i] == true >> 실제 값이 양수인 경우 
            if(signs[i]){ 
                answer += absolutes[i];
            // signs[i] == false >> 실제 값이 음수인 경우 
            } else {
                answer += ((-1) * absolutes[i]);
            }
        }        
        return answer;
    }
	
}
