package lottoProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;

public class LottoShop {
	final int userCnt = 100;
	int[] winNum;	// ��÷��ȣ 
	User[] users;	// ����� ��ü �迭 
	Reward reward;	// ��÷�ݰ��� ��ü 
	
	LottoShop() throws NumberFormatException, IOException{
		users = new User[userCnt];
		reward = new Reward(userCnt);
		
		setWinNum();
		inputNums();
		genOthers();
		
		// ��û�� ����ϱ�
		reward.setWinnerReward();
		
	}
	
	public void setWinNum(){
		// ��÷��ȣ ����� �����ϱ�. 
		winNum = genRandom();
	}

	public void genOthers() {
		// ���� ������ userCnt(99��)�� ��ȣ 5�ڸ� �����ϱ�. 
		for(int i=1; i<userCnt; i++) {
			users[i] = new User(i, genRandom());
			
			users[i].setRank(winNum);
			
			reward.setWinnerCnt(users[i].rank);
		}
	}

	
	public void inputNums() throws NumberFormatException, IOException{
		// ����ڷκ��� �ζ� ��ȣ �Է¹ޱ� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� �ζ� ��ȣ(1~40) 5���� �Է����ּ���. ex) 1 2 3 4 5 : ");
		
		int[] nums = new int[5]; 	// ��ȣ 5�� ���� �迭 
		String[] temp = br.readLine().split(" ");
		for(int i=0; i<5; i++) {
			nums[i] = Integer.parseInt(temp[i]); 
		}
		
		users[0] = new User(0,nums);  // ���� ���� ����.
		
		users[0].setRank(winNum);	// ���� ��� ����. 
		
		reward.setWinnerCnt(users[0].rank); 
		br.close();
	}
	
	public int[] genRandom() {
		// �ζ� ��ȣ 5�ڸ� ����. 
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
