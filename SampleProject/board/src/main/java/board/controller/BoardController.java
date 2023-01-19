package board.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.dto.Criteria;
import board.dto.PageMaker;
import board.dto.idxDto;
import board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	/*
	//게시글 리스트 불러오기
	@GetMapping("/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{
		ModelAndView mv = new ModelAndView("/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		
		System.out.println(list.toString());
		
		
		return mv;
	}
	*/

	//게시글 작성화면
	@GetMapping("/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
	
		return "/boardWrite";
	}
	
	//게시글 작성 처리
	@PostMapping("/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
		System.out.println(board.toString());
		boardService.insertBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	//게시글 상세화면
	@GetMapping("/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/boardDetail");
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		
		
	
		mv.addObject("board", board);
		
		return mv;
	}
	
	
	//게시글 수정처리
	@PostMapping("/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	
	//게시글 삭제처리
	@PostMapping("/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{ 
		
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
  }
	
	
	
	//게시글 선택삭제
	@ResponseBody
	@PostMapping("/deleteSelection.do")
	public String deleteSelection(HttpServletRequest request,
								@RequestParam(value="boardIdx[]") int[] boardIdx, BoardDto board) throws Exception {
	
		System.out.println(Arrays.toString(boardIdx) + "::controller boardIdx");
		
		List<Integer> idxList = new ArrayList<>();
		for(int i=0; i<boardIdx.length; i++) {
			idxList.add(boardIdx[i]);
		}
		System.out.println(idxList  + "::controller idxList");
		
		boardService.selectAndDeleteBoard(idxList);
			
		
		String result = null;
		if(boardIdx.length == 0) {
			result = "게시글 선택요망";
		}else {
			result = "삭제 성공";
		}
		
	return result;
	}
	
	/*
		
			String[] ajaxMsg = request.getParameterValues("boardIdx");
			
		System.out.println(Arrays.toString(ajaxMsg) + ":: controller array");
			
			
			for(int i=0; i<ajaxMsg.length; i++) {
				boardService.selectAndDeleteBoard(ajaxMsg[i]);
			}
	 */
	//Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	
	//System.out.println(Arrays.toString(boardIdx) + ":: controller array");
	/*
	List<Integer> idx = new ArrayList<>();
	
	for(int i=0; i<boardIdx.length; i++) {
	    idx.add(boardIdx[i]);
	}
	System.out.println(idx.size() + " :: listSize");
	
	System.out.println(idx.get(j) + ":: controller idxlist" + j);
	
	*/
	
		
		/*
		for(int i=0; i<boardIdx.length; i++) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
				
	
		paramMap.put("boardIdx", boardIdx[i]);
		
		
		System.out.println(paramMap + ":: controller map");
		
		
		
		}
		
		/*
		
		for(int i=0; i<boardIdx.length; i++) {
			paramMap.put("boardIdx", boardIdx[i]);
		}
		
		
		 for (Entry<String,Object> entrySet : paramMap.entrySet()) {
	            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
	        }
	        */
	
		
		
		/*
		int [] checkidx;
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
			
			int checkNum = entry.getValue();
			System.out.println(checkNum + ":: controller");
			
			checkidx = {entry.getValue()};
			boardService.selectAndDeleteBoard(checkidx);
					
		}
		
		*/
		
	
		//boardService.selectAndDeleteBoard(map);
		
		
			/*
			for(int i=0; i<boardIdx.length; i++) {
				boardService.selectAndDeleteBoard(boardIdx[i]);
			}
			*/
        
	
	
	
	@GetMapping("/openBoardList.do")
	public ModelAndView openBoardList(Criteria cri) throws Exception {
	        
	    ModelAndView mav = new ModelAndView("/boardList");
	        
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(100);
	   
	    pageMaker.setEndPage(225);
	    
	    pageMaker.setTotalCount(boardService.countBoardListTotal());
	    
	   System.out.println(pageMaker.getStartPage()); 
	   System.out.println(pageMaker.getEndPage());
	        
	    List<Map<String,Object>> list = boardService.selectBoardList(cri);
	    mav.addObject("list", list);
	    mav.addObject("pageMaker", pageMaker);
	        
	    return mav;
	        
	}

	
	
	
	
	
	
	
	
}
  