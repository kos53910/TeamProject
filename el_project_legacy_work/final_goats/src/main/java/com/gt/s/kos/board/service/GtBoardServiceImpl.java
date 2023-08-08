package com.gt.s.kos.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.board.dao.GtBoardDAO;

@Service
@Transactional
public class GtBoardServiceImpl implements GtBoardService {

	@Autowired(required = false)
	private GtBoardDAO gtBoardDAO;
}
