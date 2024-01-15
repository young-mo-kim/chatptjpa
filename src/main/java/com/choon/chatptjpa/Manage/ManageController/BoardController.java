// // Source code is decompiled from a .class file using FernFlower decompiler.
// package com.choon.chatptjpa.Manage.ManageController;

// import com.choon.chatptjpa.Manage.ManageDTO.Board.BoardDTO;
// import com.choon.chatptjpa.Manage.ManageService.BoardService;
// import com.choon.chatptjpa.Manage.ManageVO.Board.BoardVO;
// import com.choon.chatptjpa.Manage.model.Header;
// import java.util.List;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.web.PageableDefault;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin
// @RestController
// public class BoardController {
//    private final BoardService boardService;

//    @GetMapping({"/board/list"})
//    public Header<List<BoardDTO>> boardList(@PageableDefault(sort = {"idx"}) Pageable pageable) {
//       return this.boardService.getBoardList(pageable);
//    }

//    @GetMapping({"/board/{id}"})
//    public BoardDTO getBoard(@PathVariable Long id) {
//       return this.boardService.getBoard(id);
//    }

//    @PostMapping({"/board"})
//    public BoardVO create(@RequestBody BoardDTO boardDto) {
//       return this.boardService.create(boardDto);
//    }

//    @PatchMapping({"/board"})
//    public BoardVO update(@RequestBody BoardDTO boardDto) {
//       return this.boardService.update(boardDto);
//    }

//    @DeleteMapping({"/board/{id}"})
//    public void delete(@PathVariable Long id) {
//       this.boardService.delete(id);
//    }

//    public BoardController(final BoardService boardService) {
//       this.boardService = boardService;
//    }
// }
