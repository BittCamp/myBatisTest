package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSearchService_t;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {
	
	public void menu() { // MyBatis에선 이렇게 쓴다.
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		int num;

		while(true){
			System.out.println();
			System.out.println("******************");
			System.out.println("      1.등록");
			System.out.println("      2.출력");
			System.out.println("      3.수정");
			System.out.println("      4.삭제");
			System.out.println("      5.검색");
			System.out.println("      6.검색_t");
			System.out.println("      7.끝");
			System.out.println("******************");
			System.out.println("번호 입력 : ");
			num = scan.nextInt();
			if(num==7) break;
			
			if(num ==1) 
				userService = new UserInsertService(); //부모 = 자식 
			else if( num ==2 ) 
				userService = new UserSelectService(); //부모 = 자식
			else if( num ==3 )
				userService = new UserUpdateService(); //부모 = 자식
			else if( num ==4 )
				userService = new UserDeleteService(); //부모 = 자식
			else if( num ==5 )
				userService = new UserSearchService(); //부모 = 자식
			else if( num ==6 )
				userService = new UserSearchService_t(); //선생님꺼 해쉬맵방식으로 썼음.
			userService.execute(); //호출. 모든 클래스가 execute를 가지고 있다.
		}//while
	}
	
	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu(); //호출
		System.out.println("프로그램을 종료합니다.");
	}
}
