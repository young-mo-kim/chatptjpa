// package com.choon.chatptjpa.Manage.ManageService;

// import org.hibernate.mapping.List;
// import org.springframework.stereotype.Service;

// @Service
// public class BoardService {
//    private final BoardRepository boardRepository;

//    public List<BoardDTO> getBoardList() {
//       List<BoardVO> boardEntities = this.boardRepository.findAll();
//       List<BoardDTO> dtos = new ArrayList();
//       Iterator var3 = boardEntities.iterator();

//       while(var3.hasNext()) {
//          BoardVO entity = (BoardVO)var3.next();
//          BoardDTO dto = BoardDTO.builder().idx(entity.getIdx()).author(entity.getAuthor()).title(entity.getTitle()).contents(entity.getContents()).bdate(entity.getBdate()).build();
//          dtos.add(dto);
//       }

//       return dtos;
//    }

//    public Header<List<BoardDTO>> getBoardList(Pageable pageable) {
//       List<BoardDTO> dtos = new ArrayList();
//       Page<BoardVO> boardEntities = this.boardRepository.findAllByOrderByIdxDesc(pageable);
//       Iterator var4 = boardEntities.iterator();

//       while(var4.hasNext()) {
//          BoardVO entity = (BoardVO)var4.next();
//          BoardDTO dto = BoardDTO.builder().idx(entity.getIdx()).author(entity.getAuthor()).title(entity.getTitle()).contents(entity.getContents()).bdate(entity.getBdate()).build();
//          dtos.add(dto);
//       }

//       Pagination pagination = new Pagination((int)boardEntities.getTotalElements(), pageable.getPageNumber() + 1, pageable.getPageSize(), 10);
//       return Header.OK(dtos, pagination);
//    }

//    public BoardDTO getBoard(Long id) {
//       BoardVO entity = (BoardVO)this.boardRepository.findById(id).orElseThrow(() -> {
//          return new RuntimeException("\uac8c\uc2dc\uae00\uc744 \ucc3e\uc744 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4.");
//       });
//       return BoardDTO.builder().idx(entity.getIdx()).title(entity.getTitle()).contents(entity.getContents()).author(entity.getAuthor()).bdate(entity.getBdate()).build();
//    }

//    public BoardVO create(BoardDTO boardDto) {
//       BoardVO entity = BoardVO.builder().title(boardDto.getTitle()).contents(boardDto.getContents()).author(boardDto.getAuthor()).bdate(new Date()).build();
//       return (BoardVO)this.boardRepository.save(entity);
//    }

//    public BoardVO update(BoardDTO boardDto) {
//       BoardVO entity = (BoardVO)this.boardRepository.findById(boardDto.getIdx()).orElseThrow(() -> {
//          return new RuntimeException("\uac8c\uc2dc\uae00\uc744 \ucc3e\uc744 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4.");
//       });
//       entity.setTitle(boardDto.getTitle());
//       entity.setContents(boardDto.getContents());
//       return (BoardVO)this.boardRepository.save(entity);
//    }

//    public void delete(Long id) {
//       BoardVO entity = (BoardVO)this.boardRepository.findById(id).orElseThrow(() -> {
//          return new RuntimeException("\uac8c\uc2dc\uae00\uc744 \ucc3e\uc744 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4.");
//       });
//       this.boardRepository.delete(entity);
//    }

//    public BoardService(final BoardRepository boardRepository) {
//       this.boardRepository = boardRepository;
//    }
// }