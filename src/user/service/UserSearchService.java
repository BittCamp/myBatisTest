package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		
		System.out.println("***************");
		System.out.println("1.   이름 검색 : ");
		System.out.println("2.   아이디 검색: ");
		System.out.println("***************");
		
		//DB
		Scanner scan = new Scanner(System.in);
		UserDAO userDAO = new UserDAO();
		int num = scan.nextInt();
		String name = null;
		String id = null;
		List<UserDTO> list = null;
		if(num ==1 ) {
			System.out.println("검색할 이름 입력");
			name = scan.next();
			
		}else if(num ==2 ) {
			System.out.println("검색할 아이디 입력");
			id = scan.next();
		}else {
			System.out.println("종료합니다.");
			return; //잘못입력 종료.
		}
		list = userDAO.search(name,id,num);
		//응답 
		for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName()+"\t"+ userDTO.getId()+"\t"+userDTO.getPwd());				
		}//for

	}
	
	// 1번인경우
	// 검색할 이름 입력 : %홍% ( 이름에서 홍이 들어간 레코드는 전부 가져온다.)

	//홍길동 hong 111(비번)
	//진분홍 pink 111
	
	//2번인 경우
	// 검색할 아이디 입력 : %n% ( 아이디에서 n이 들어간 레코드는 전부 가져온다.)
	
	// 코난 conan 111
	// 홍길동 hong 111
	
	
}
