package videoshop.model;

import java.sql.*;
import java.util.ArrayList;

import videoshop.model.vo.VideoVO;

public class VideoDAO {
	
	Connection con;
	
	public VideoDAO() throws Exception{
		con = DBCon.getInstance();
	}
	
	
	public void insertVideo(VideoVO videoVo, int count) throws Exception{
		// 3. sql 문장 만들기
		String sql = "INSERT INTO video(video_no, title,genre,director,actor,detail) values" +
				" (seq_video_no.NEXTVAL,?,?,?,?,?) ";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement pStatement = con.prepareStatement(sql);

		// 5. sql 전송
		for(int i=0; i<count; i++){
			pStatement.setString(1,videoVo.getTitle());
			pStatement.setString(2,videoVo.getGenre());
			pStatement.setString(3,videoVo.getDirector());
			pStatement.setString(4,videoVo.getActor());
			pStatement.setString(5,videoVo.getDetail());
			pStatement.executeUpdate();
		}

		// 6. 닫기 ( 연결객체 닫지 않음 )
		pStatement.close();
		
	}

	public ArrayList searchVideo(int idx, String word) throws Exception{
		ArrayList data = new ArrayList();
		String[] columnName = {"title","director"};
		String sql = "SELECT video_no,title,director,actor FROM video where " + columnName[idx]+" LIKE '%" + word+"%'";
		System.out.println(sql);

		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			ArrayList temp = new ArrayList();
			temp.add(resultSet.getInt("VIDEO_NO"));
			temp.add(resultSet.getString("TITLE"));
			temp.add(resultSet.getString("DIRECTOR"));
			temp.add(resultSet.getString("ACTOR"));
			data.add(temp);
		}
		resultSet.close();
		statement.close();
		return data;
	}

	public VideoVO searchByPk(int video_no) throws Exception{
		VideoVO videoVO = new VideoVO();
		String sql = "SELECT * FROM video WHERE video_no = ? ";

		PreparedStatement statement = con.prepareStatement(sql);
		statement.setInt(1,video_no);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			videoVO.setTitle(resultSet.getString("TITLE"));
			videoVO.setGenre(resultSet.getString("GENRE"));
			videoVO.setDirector(resultSet.getString("DIRECTOR"));
			videoVO.setActor(resultSet.getString("ACTOR"));
			videoVO.setDetail(resultSet.getString("DETAIL"));
		}

		resultSet.close();
		statement.close();
		return videoVO;
	}
}
