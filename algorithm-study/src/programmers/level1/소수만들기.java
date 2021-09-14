package programmers.level1;

// https://programmers.co.kr/learn/courses/30/lessons/12977
public class �Ҽ������ {
	// �Ҽ����� �ƴ��� �Ǻ��ϴ� �Լ�
    public boolean isDecimal(int num){
	    boolean res = true;
        // �Ҽ��� ���� : 1~num ������ ���� ����������� �ʾƾ� ��
	    for(int i=2; i<num; i++) {
            // ����� �ϳ��� �����ϸ� �Ҽ� �ƴ� == false
	    	if(num % i == 0) res = false;
	    }
		return res;
	    }
    public int solution(int[] nums) {
        int answer = 0;
        // ��ġ�� �ʰ� 3���� ���� ��� ���ϴ� ���
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
