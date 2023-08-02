package lottoProject;

public class Reward {
	long totalReward;
	int[] winnerCnt;	// ��� �ο�
	int[] winnerReward;	// ����� ��� 
	
	// �����ڸ� ���� totalReward �� ���
	Reward(int userCnt){
		totalReward = userCnt*5000;
		winnerCnt = new int[4];	// {x,1,2,3} 
		winnerReward = new int[4]; // {x,1,2,3}
	}
	
	// ��� �ο� ��� 
	void setWinnerCnt(int rank) {
		winnerCnt[rank]++;
	}
	// 3��: 25000�� , 2��: ���� �ݾ� 30%�� �������� , 1��: ���� �ݾ� 70%�� �������� 
	void setWinnerReward() {
		long remain = 0;
		
		// 3��
		if(winnerCnt[3]>0) {
			winnerReward[3] = winnerCnt[3]*25000; 
			remain = totalReward - winnerReward[3];
		}
		// 2��
		if(winnerCnt[2]>0 && remain>0)
			winnerReward[2] = (int) ((remain*0.3)/winnerCnt[2]);
		// 1��
		if(winnerCnt[1]>0 && remain>0)
			winnerReward[1] = (int) ((remain*0.7)/winnerCnt[1]);
	}
}
