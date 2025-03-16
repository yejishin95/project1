package com.yeji.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yeji.spring06.dto.BoardDto;
import com.yeji.spring06.mapper.BoardDetailMapper;
import com.yeji.spring06.mapper.BoardListMapper;

@Repository
public class BoardDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	BoardListMapper listmapper;
	
	@Autowired
	BoardDetailMapper detailMapper;
	
	public void insert(BoardDto dto){
		String sql = "insert into board(board_no, board_title, board_content, board_writer, board_readcount) "
				+ "values(board_seq.nextval,?,?,?,0)";
		Object[] data = {
			dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardWriter()
		};
		
		jdbcTemplate.update(sql, data);
	}

	
	public boolean update(BoardDto dto) {
	    String sql = "UPDATE board SET board_title=?, board_content=?, board_writer=? WHERE board_no=?";
	    Object[] data = {
	            dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardWriter(), dto.getBoardNo()
	    };
	    
	    return jdbcTemplate.update(sql, data) > 0;
	}


	public boolean delete(int boardNo) {
		String sql = "delete board where board_no=?";
	    Object[] data = {boardNo};
	    return jdbcTemplate.update(sql, data) > 0;
	}

	public List<BoardDto> selectList(){
		String sql ="select board_no, board_title, board_writer, board_readcount from board order by board_no desc";
		return jdbcTemplate.query(sql, listmapper);
	}
	
	public List<BoardDto> detail(){
		String sql ="select * from board order by board_no desc";
		return jdbcTemplate.query(sql, detailMapper);
	}
	
	public BoardDto selectOne(int boardNo){
		String sql = "select * from board where board_no=?";
		Object[] data = {boardNo};
		List<BoardDto> list = jdbcTemplate.query(sql, detailMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}
