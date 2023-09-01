package shop.mtcoding.teamproject.board;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.W3CDomHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/comunitydetail")
    public String comunitydetail() {
        return "comunity/comunityDetail";
    }

    @GetMapping("/comunitywrite")
    public String comunitywrite() {
        return "comunity/comunityWrite";
    }

    @PostMapping("/comunity/save")
    public String save(BoardRequest.SaveDTO saveDTO) {
        boardService.글쓰기(saveDTO);
        return "redirect:/";
    }

    @PostMapping("/comunity/{id}/delete")
    public String delete(@PathVariable Integer id) {
        boardService.삭제하기(id);
        return "redirect:/";
    }

    @GetMapping("/comunity") // 객체를 파라미터로 받음
    public String boardIndex(@RequestParam(defaultValue = "0") Integer page, HttpServletRequest request) {
        // 컨트롤러에 페이지 메서드 선언 (인터페이스)
        // 보드 타입으로 객체를 넣어주면 페이지를 하겠구나하는 정보를 가지고 서비스로 감
        Page<Board> boardPG = boardService.게시글목록보기(page);
        request.setAttribute("boardPG", boardPG.getContent());
        request.setAttribute("prevPage", boardPG.getNumber() - 1);
        request.setAttribute("nextPage", boardPG.getNumber() + 1);

        return "comunity/comunityList";

    }

    @GetMapping("/comunity/comunitydetail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Board board = boardService.상세보기(id);
        model.addAttribute("board", board);
        return "comunity/comunityDetail";
    }

}
// 컨트롤러에서는 model 써서 detail.mustache로 보낸다
