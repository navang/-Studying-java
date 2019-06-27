package mybatis.guest.service;

import java.util.List;

import mybatis.guest.model.Comment;
import mybatis.guest.session.CommentRepository;

public class CommentService {
		private static CommentService service;
		
		private CommentService() {}
		
		public static CommentService getInstance() {
			if(service == null) service = new CommentService();
			return service;
		}
		// 검색
		CommentRepository repo = new CommentRepository();
		public List<Comment> selectComment(){
			return repo.selectComment();
		}
		//글번호로 검색
		public Comment selectCommentByPrimaryKey(long cId) {
			return repo.selectCommentByPK(cId);
		}
		// 입력
		public void insertComment(Comment c) {
			repo.insertComment(c);
		}
		// 삭제
		public void deleteComment(Comment c) {
			repo.deleteComment(c);
		}
		// 수정
		public void updateComment(Comment c) {
			repo.updateComment(c);
		}
}
