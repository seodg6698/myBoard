package board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDto;
import board.dto.Criteria;


@Mapper
public interface BoardMapper {

		public List<BoardDto> selectBoardList();
		
		void insertBoard(BoardDto board) throws Exception;

		void updateHitCount(int boardIdx) throws Exception;

		BoardDto selectBoardDetail(int boardIdx) throws Exception;

		void updateBoard(BoardDto board) throws Exception;

		void deleteBoard(int boardIdx) throws Exception;

		List<Map<String, Object>> selectBoardList(Criteria cri) throws Exception;

		public int countBoardList() throws Exception;

		public void selectAndDeleteBoard(List<Integer> idxList);

		
	

	
	

}
