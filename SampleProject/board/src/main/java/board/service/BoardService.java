package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dto.BoardDto;
import board.dto.Criteria;


public interface BoardService {

	public List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(BoardDto board) throws Exception;

	List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception;

	public int countBoardListTotal() throws Exception;

	public void selectAndDeleteBoard(List<Integer> idxList) throws Exception;

	public void deleteBoard(int boardIdx) throws Exception;

	
	
}
