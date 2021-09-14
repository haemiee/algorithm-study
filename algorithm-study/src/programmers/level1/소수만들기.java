package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12977
public class 소수만들기 {
	// 소수인지 아닌지 판별하는 함수
    public boolean isDecimal(int num){
	    boolean res = true;
        // 소수일 조건 : 1~num 사이의 수로 나누어떨어지지 않아야 함
	    for(int i=2; i<num; i++) {
            // 약수가 하나라도 존재하면 소수 아님 == false
	    	if(num % i == 0) res = false;
	    }
		return res;
	    }
    public int solution(int[] nums) {
        int answer = 0;
        // 겹치지 않게 3개의 수를 모두 더하는 방법
        for(int i=0; i<nums.length-2; i++) {
        	for(int j=i+1; j<nums.length-1; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			int sum = nums[i] + nums[j] + nums[k];
        			if(isDecimal(sum)) answer++;
        		}
        	}
        }
        return answer;
    }
}
