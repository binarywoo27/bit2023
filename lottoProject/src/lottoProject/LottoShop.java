package lottoProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;

public class LottoShop {
	final int userCnt = 100;
	int[] winNum;	// 당첨번호 
	User[] users;	// 사용자 객체 배열 
	Reward reward;	// 당첨금관리 객체 
	
	LottoShop() throws NumberFormatException, IOException{
		users = new User[userCnt];
		reward = new Reward(userCnt);
		
		setWinNum();
		inputNums();
		genOthers();
		
		// 당청금 계산하기
		reward.setWinnerReward();
		
	}
	
	public void setWinNum(){
		// 당첨번호 만들고 저장하기. 
		winNum = genRandom();
	}

	public void genOthers() {
		// 나를 제외한 userCnt(99명)의 번호 5자리 생성하기. 
		for(int i=1; i<userCnt; i++) {
			users[i] = new User(i, genRandom());
			
			users[i].setRank(winNum);
			
			reward.setWinnerCnt(users[i].rank);
		}
	}

	
	public void inputNums() throws NumberFormatException, IOException{
		// 사용자로부터 로또 번호 입력받기 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("나의 로또 번호(1~40) 5개를 입력해주세요. ex) 1 2 3 4 5 : ");
		
		int[] nums = new int[5]; 	// 번호 5개 저장 배열 
		String[] temp = br.readLine().split(" ");
		for(int i=0; i<5; i++) {
			nums[i] = Integer.parseInt(temp[i]); 
		}
		
		users[0] = new User(0,nums);  // 나의 정보 저장.
		
		users[0].setRank(winNum);	// 나의 등수 설정. 
		
		reward.setWinnerCnt(users[0].rank); 
		br.close();
	}
	
	public int[] genRandom() {
		// 로또 번호 5자리 생성. 
		int min = 1;
		int max = 40;
		
		HashSet<Integer> set = new HashSet<>();
		Random random = new Random();
		
		while(true) {
			int num = random.nextInt(max - min + 1) + min;
			set.add(num);
			if(set.size() == 5) break;
		}
		
		int[] nums = new int[5];
		int i = 0;
		for(int s: set) {
			nums[i++] = s;
		}
		
		return nums;
	}
}
