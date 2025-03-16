package com.yeji.spring05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yeji.spring05.dto.PocketmonDto;
import com.yeji.spring05.mapper.PocketmonMapper;


@Repository
public class PocketmonDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PocketmonMapper mapper;
	
	public void insert(PocketmonDto dto) {
		String sql = "insert into pocketmon(no,name,type) "
				+ "values(?,?,?)";
		Object[] data = {dto.getNo(), dto.getName(), dto.getType()};
		
		jdbcTemplate.update(sql, data);
	}

	public boolean update(PocketmonDto dto) {
		String sql = "update pocketmon set name = ?, type = ? where no = ?";
		Object[] data = {dto.getName(), dto.getType(), dto.getNo()};
		//jdbcTemplate.update(sql, data);
		return jdbcTemplate.update(sql, data) > 0;
	}

	public boolean delete(int no) {
		String sql ="delete pocketmon where no=?";
		Object[] data = {no};
		
		return jdbcTemplate.update(sql, data)>0;
	}
	
	public List<PocketmonDto> selectList(){
		String sql ="select * from pocketmon order by no asc";
		return jdbcTemplate.query(sql, mapper);
	}
	
	public PocketmonDto selectOne(int no) {
		String sql = "select * from pocketmon where no=?";
		Object[] data = {no};
		List<PocketmonDto> list = jdbcTemplate.query(sql, mapper, data);
		return list.isEmpty() ? null : list.get(0);
	}


}

