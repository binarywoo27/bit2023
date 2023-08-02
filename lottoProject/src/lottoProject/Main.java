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
		
		// �޴� �ɼ�: 1) �� ��÷ ���(���,���) 2) ����� �ο��� 3) ���� 
		while(true) {
			System.out.println("�޴� ��ȣ�� �������ּ���. \n"
					+ "1. �� ��÷ ���(���,���) 2. ����� �ο��� 3. ����");
			int num = Integer.parseInt(br.readLine());
			switch(num) {
				case 1: 
					System.out.printf("��÷ ��ȣ: %d %d %d %d %d\n", shop.winNum[0], shop.winNum[1], shop.winNum[2], shop.winNum[3], shop.winNum[4]);
					System.out.println("���� ���: "+shop.users[0].rank+", ���� ���: 25000");
					break;
				case 2:
					System.out.println("����� �ο��� �� ���: ");
					System.out.printf("1��: %d��, ���: %d\n", shop.reward.winnerCnt[1], shop.reward.winnerReward[1]);
					System.out.printf("2��: %d��, ���: %d\n", shop.reward.winnerCnt[2], shop.reward.winnerReward[2]);
					System.out.printf("3��: %d��, ���: %d\n", shop.reward.winnerCnt[3], shop.reward.winnerReward[3]);
					break;
				case 3:
					System.out.println("���α׷� ����!!");
					br.close();
					return;
			}
		}
		
	}
	
}
