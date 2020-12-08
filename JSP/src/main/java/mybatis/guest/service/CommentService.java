package mybatis.guest.service;

import mybatis.guest.model.CommentVO;
import mybatis.guest.session.CommentRepository;

import java.util.List;

public class CommentService {
	
	private static CommentService service;
	private CommentRepository commentRepository = new CommentRepository();
	
	private CommentService() {}
	public static CommentService getInstance(){
		if( service == null) service = new CommentService();
		return service;
	}

	public List<CommentVO> selectComment(){

		return commentRepository.selectComment();
	}

	public Integer insertComment(CommentVO commentVO){

	    return commentRepository.insertComment(commentVO);
    }

	public CommentVO selectCommentByPrimaryKey(long commentNo) {
		return commentRepository.selectCommentByPrimaryKey(commentNo);
	}

	public Integer modifyComment(CommentVO commentVO){
		System.out.println("CommentService 34Line : " + commentVO.getUserId());
		return commentRepository.modifyComment(commentVO);
	}

	public Integer deleteComment(long commentNo){
	    return commentRepository.deleteComment(commentNo);
    }
}