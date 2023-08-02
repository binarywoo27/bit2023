package lottoProject;

public class Reward {
	long totalReward;
	int[] winnerCnt;	// 등수 인원
	int[] winnerReward;	// 등수별 상금 
	
	// 생성자를 통해 totalReward 값 계산
	Reward(int userCnt){
		totalReward = userCnt*5000;
		winnerCnt = new int[4];	// {x,1,2,3} 
		winnerReward = new int[4]; // {x,1,2,3}
	}
	
	// 등수 인원 기록 
	void setWinnerCnt(int rank) {
		winnerCnt[rank]++;
	}
	// 3등: 25000씩 , 2등: 남은 금액 30%를 나눠갖음 , 1등: 남은 금액 70%를 나눠갖음 
	void setWinnerReward() {
		long remain = 0;
		
		// 3등
		if(winnerCnt[3]>0) {
			winnerReward[3] = winnerCnt[3]*25000; 
			remain = totalReward - winnerReward[3];
		}
		// 2등
		if(winnerCnt[2]>0 && remain>0)
			winnerReward[2] = (int) ((remain*0.3)/winnerCnt[2]);
		// 1등
		if(winnerCnt[1]>0 && remain>0)
			winnerReward[1] = (int) ((remain*0.7)/winnerCnt[1]);
	}
}
