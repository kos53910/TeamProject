package com.gt.s.kos.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class GtBoardDAOImpl implements GtBoardDAO {

	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
}
