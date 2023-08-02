package lottoProject;

import java.util.ArrayList;

public class User {
	int[] myNum;
	int id;
	int rank;
	
	User(int id, int[] myNum){
		this.id = id;
		this.myNum = myNum;
	}
	// 등수 설정 
	public void setRank(int[] winNum){
		ArrayList<Integer> list = new ArrayList<>();
		for(int n: myNum) {
			list.add(n);
		}
		
		int cnt = 0;
		for(int i=0; i<winNum.length; i++) {
			if(list.contains(winNum[i])) {
				cnt++;
			}
		}
		
		if(cnt==5) {
			rank = 1;
		}
		else if(cnt==4) {
			rank = 2;
		}
		else if(cnt==3) {
			rank = 3;
		}
	}
}
