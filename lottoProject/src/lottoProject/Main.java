package lottoProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		showMenu();
	}

	private static void showMenu() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LottoShop shop = new LottoShop();
		
		// 메뉴 옵션: 1) 내 당첨 결과(등수,상금) 2) 등수별 인원수 3) 종료 
		while(true) {
			System.out.println("메뉴 번호를 선택해주세요. \n"
					+ "1. 내 당첨 결과(등수,상금) 2. 등수별 인원수 3. 종료");
			int num = Integer.parseInt(br.readLine());
			switch(num) {
				case 1: 
					System.out.printf("당첨 번호: %d %d %d %d %d\n", shop.winNum[0], shop.winNum[1], shop.winNum[2], shop.winNum[3], shop.winNum[4]);
					System.out.println("나의 등수: "+shop.users[0].rank+", 나의 상금: 25000");
					break;
				case 2:
					System.out.println("등수별 인원수 및 상금: ");
					System.out.printf("1등: %d명, 상금: %d\n", shop.reward.winnerCnt[1], shop.reward.winnerReward[1]);
					System.out.printf("2등: %d명, 상금: %d\n", shop.reward.winnerCnt[2], shop.reward.winnerReward[2]);
					System.out.printf("3등: %d명, 상금: %d\n", shop.reward.winnerCnt[3], shop.reward.winnerReward[3]);
					break;
				case 3:
					System.out.println("프로그램 종료!!");
					br.close();
					return;
			}
		}
		
	}
	
}
