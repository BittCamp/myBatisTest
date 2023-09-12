package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService_t implements UserService {

	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("==============");
		System.out.println(" 1. 이름 검색");
		System.out.println(" 2. 아이디 검색");
		System.out.println(" 3. 나가기");
		System.out.println("==============\"");
		System.out.print(" 번호 : ");
		int num = scan.nextInt();
		
		System.out.println();
		String columnName = null;
		String value = null;
		if( num == 1) {
			System.out.println("검색 할 이름 입력: ");
			value = scan.next();
			columnName = "name";
		}else if( num == 2 ) {
			System.out.println("검색 할 아이디 입력: ");
			value = scan.next();
			columnName = "id";
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("columnName", columnName);
		map.put("value", value); //map으로 매개변수 한개로 다나오게
		
		//DB
		UserDAO userDAO = new UserDAO();
	    List<UserDTO> list = userDAO.search_t(map); // _t로 잡아서 선생님꺼로 구분
		
		//응답 
		for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName()+"\t"+ userDTO.getId()+"\t"+userDTO.getPwd());				
		}//for
		
		
	}
}

// 1번인경우
// 검색할 이름 입력 : %홍% ( 이름에서 홍이 들어간 레코드는 전부 가져온다.)

//홍길동 hong 111(비번)
//진분홍 pink 111

//2번인 경우
// 검색할 아이디 입력 : %n% ( 아이디에서 n이 들어간 레코드는 전부 가져온다.)

// 코난 conan 111
// 홍길동 hong 111


