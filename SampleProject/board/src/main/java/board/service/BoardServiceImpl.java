
package board.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import board.dto.BoardDto;
import board.dto.Criteria;
import board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception{
		
		return boardMapper.selectBoardList();
	
	}

	@Override
	public void insertBoard(BoardDto board) throws Exception {
		boardMapper.insertBoard(board);
		
		
		
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
		
		BoardDto board = boardMapper.selectBoardDetail(boardIdx);
		return board;
	}
	
	@Override
	public void updateBoard(BoardDto board) throws Exception{
		boardMapper.updateBoard(board);
	}
	
	@Override
	public void deleteBoard(int boardIdx) throws Exception{
		boardMapper.deleteBoard(boardIdx);
	}
	
	//게시글 선택삭제
	@Override
	public void selectAndDeleteBoard(List<Integer> idxList) throws Exception{
		System.out.println(idxList + ":: service idxList");
		boardMapper.selectAndDeleteBoard(idxList);
		
		/*
		Map<String, Object> idxMap = new HashMap<String, Object>();
		
		idxMap=paramMap;
		System.out.println(idxMap + ":: service map");
		
		
		List<Integer> bIdx = new ArrayList<>();
		bIdx = idx;
		for(int i=0; i<bIdx.size(); i++) {
			System.out.println(bIdx.get(i) + " :: sevice bidxList" + i);
		}
		
		*/
		
		
	}
	
	
	@Override
	public List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception {
		 return boardMapper.selectBoardList(cri);
	}
	 
	
	@Override
	public int countBoardListTotal() throws Exception {
	    return boardMapper.countBoardList();
	}



	


	
	

}
