package mybatis.guest.session;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.guest.model.Comment;

public class CommentRepository {
	
	String namespace = "mapper.CommentMapper";
			
	SqlSessionFactory getSqlSessionFactory() {
		InputStream inStream =null;
		
		try {
			inStream = Resources.getResourceAsStream("mybatis-config.xml");
		
			
		}catch(Exception ex){
			System.out.println("config 연결 실패" + ex.getMessage());
		}
		SqlSessionFactory sessFactory = new 
				SqlSessionFactoryBuilder().build(inStream);
		return sessFactory;
	}
	
	public List<Comment> selectComment(){
		// 마이바티즈가 관리하는 Connection 하나 얻어오기
		SqlSession sess = getSqlSessionFactory().openSession();
		try {
			return sess.selectList("mapper.CommentMapper.selectComment");
			//같다 return sess.selectList("mapper.CommentMapper.selectComment");
		}finally {
			sess.close(); // Connection 마이바티즈에게 반환 
		}
		
	}
	
			// 아이디에 따른 검색 
		public Comment selectCommentByPK(long commentNo) {
			SqlSession sess = getSqlSessionFactory().openSession();
			try {
				Map map = new HashMap();
				map.put("commentNo",commentNo);
				// 원하는 값을 맵에 추가해서 map을 반환 
				Comment c= sess.selectOne(namespace+".selectComment", map);
				return c;
			}
			finally {
				sess.close();
				
			}
		}
		//입력 n개의 행을 삽입했습니다
		public void insertComment(Comment c) {
			SqlSession sess = getSqlSessionFactory().openSession(); //인자 받아오기 
			try {
				int result = sess.insert(namespace+".insertComment",c);
				if(result>0) {
					sess.commit();
					
				}else {
					sess.rollback();
					
				}
			}finally {
				sess.close(); // 인자 반환
			}
		}
		//삭제 
		public void deleteComment(Comment c) {
			SqlSession sess = getSqlSessionFactory().openSession(); //인자 받아오기 
			try {
				
				int result = sess.delete(namespace+".deleteComment",c);
				if(result>0) {
					sess.commit();
					
				}else {
					sess.rollback();
					
				}
			}finally {
				sess.close(); // 인자 반환
			}
		}
		// 수정 
		public void updateComment(Comment c) {
			SqlSession sess = getSqlSessionFactory().openSession(); //인자 받아오기 
				try {
				int result = sess.update(namespace+".updateComment",c);
				if(result != 0) {
					sess.commit();
					
				}else {
					sess.rollback();
					
				}
				
			}finally {
				sess.close(); // 인자 반환
			}
		}

}
