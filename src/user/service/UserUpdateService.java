package user.service;

import java.util.List;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 아이디 입력");
		String id = scan.next();
		
		//DB
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("아이디가 존재하지 않습니다.");
		}else {
			System.out.println(userDTO.getName()+"\t"+ userDTO.getId()+"\t"+userDTO.getPwd());
			
			System.out.println();
			System.out.print("수정할 아이디 입력 : ");
			String name = scan.next();
			System.out.print("수정할 비밀번호 입력 : ");
			String pwd = scan.next();
			
			userDTO.setName(name);
			userDTO.setPwd(pwd);
			
			//DB
			userDAO.update(userDTO);
			
			System.out.println("데이터를 수정하였습니다.");
		}//else
		
	}

}
//수정할 아이디 입력	angel ==> select * from usertable where id ='angel' (getUser())
// 아이디가 존재하지 않습니다. 

//수정할 아이디 입력 : 홍길동
//홍길동 hong 111

//수정할 이름을 입력  :
//수정할 비밀번호 입력 :

//데이터를 수정하였습니다. ==> update (update())