package com.yeji.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.yeji.spring06.dto.BoardDto;

@Component
public class BoardListMapper implements RowMapper<BoardDto>{

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto dto = new BoardDto();
		dto.setBoardNo(rs.getInt("board_no"));
		dto.setBoardTitle(rs.getString("board_title"));
		//dto.setBoardContent(rs.getString("board_content"));
		dto.setBoardWriter(rs.getString("board_writer"));
		dto.setBoardReadcount(rs.getInt("board_readcount"));
		return dto;
	}

}
