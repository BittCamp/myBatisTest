package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {//[ 김찬영  2023-09-11 오후 02:20:02 ]
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() { //이거 퍼블릭??
		//String resource = "mybatis-config.xml";
		try {
			///InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 바이트단위
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml"); // 문자단위  Reader Writer
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //생성
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//여기서는 이제 sql을 절대 안쓸거다. 그게 마이바티스이다.
	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//인터페이스라 뉴못함. 생성
		sqlSession.insert("userSQL.write",userDTO);//lock - insert update delete // 네임스페이스이름 userSQL 네임스페이스에있는 아이디이름 .write //xml이 여러개일까봐 네임스페이스랑 아이디를 같이써줘서 구분되게 함.
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList"); // 여러개면 selectList ,  한개면 selectOne
		sqlSession.close();
		return list;
	}
	
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUser",id); // 여러개면 selectList ,  한개면 selectOne
		sqlSession.close();
		return userDTO;
	}
	
	public void update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.update");
		sqlSession.update("userSQL.update",userDTO); // 뭉쳐서 넘길수 있는건 하나밖에 안된다.
		sqlSession.commit();
		sqlSession.close();
	}
	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete",id);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<UserDTO> search(String name,String id , int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();//해쉬맵으로 넘기는 방법
		
		List<UserDTO> list =  null;
		if(num ==1) {
			list = sqlSession.selectList("userSQL.search",name);			
		}else if(num ==2 ) {
			list = sqlSession.selectList("userSQL.search",id);
		}
		sqlSession.close();
		return list;
	}

	public List<UserDTO> search_t(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search_t" , map);
		sqlSession.close();
		return list;
	}
	

}
