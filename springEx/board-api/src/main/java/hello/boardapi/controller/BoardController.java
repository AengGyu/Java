package hello.boardapi.controller;

import hello.boardapi.model.Board;
import hello.boardapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private final BoardService boardService;

    //게시글 저장
    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board){
        return ResponseEntity.ok(boardService.createBoard(board));
    }

    //전체 게시글 조회
    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards(){
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    //특정 게시글 조회
    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long id){
        Optional<Board> board = boardService.getBoardById(id);
        return board.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board board){
        Board updateBoard = boardService.updateBoard(id, board);
        return updateBoard != null ? ResponseEntity.ok(updateBoard) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id){
        boardService.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
