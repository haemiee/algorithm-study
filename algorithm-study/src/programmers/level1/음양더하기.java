package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/76501
public class ������ϱ� {

	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length; i++){
            // signs[i] == true >> ���� ���� ����� ��� 
            if(signs[i]){ 
                answer += absolutes[i];
            // signs[i] == false >> ���� ���� ������ ��� 
            } else {
                answer += ((-1) * absolutes[i]);
            }
        }        
        return answer;
    }
	
}
