package hello.boardapi.repository;

import hello.boardapi.model.Board;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BoardRepository {

    private final Map<Long, Board> boardMap = new HashMap<>();
    private Long sequence = 1L;

    //게시글 저장
    public Board save(Board board) {
        board.setId(sequence++);
        boardMap.put(board.getId(), board);
        return board;
    }

    //모든 게시글 조회
    public List<Board> findAll() {
        return new ArrayList<>(boardMap.values());
    }

    //특정 게시글 조회
    public Optional<Board> findById(Long id) {
        return Optional.ofNullable(boardMap.get(id));
    }

    //게시글 수정
    public Board update(Long id, Board newBoard) {
        if (boardMap.containsKey(id)) {
            newBoard.setId(id);
            boardMap.put(id, newBoard);
            return newBoard;
        }
        return null;
    }

    //게시물 삭제
    public void delete(Long id){
        boardMap.remove(id);
    }
}
