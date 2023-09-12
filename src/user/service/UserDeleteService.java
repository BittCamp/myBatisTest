package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		System.err.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력");
		String id = scan.next();
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");	
			return;// 메소드를 벗어나라. 보이드가 리턴이면 반환할게 없다 그냥나가는거
		}else {
			userDAO.delete(id);
			
			System.out.println("데이터를 삭제하였습니다.");			
		}
		

	}

}
