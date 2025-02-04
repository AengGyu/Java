package hello.boardapi.service;

import hello.boardapi.model.Board;
import hello.boardapi.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    //게시글 저장
    public Board createBoard(Board board){
        return boardRepository.save(board);
    }

    //전체 게시글 조회
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

    //특정 게시글 조회
    public Optional<Board> getBoardById(Long id){
        return boardRepository.findById(id);
    }

    //게시글 수정
    public Board updateBoard(Long id, Board board){
        return boardRepository.update(id,board);
    }

    //게시글 삭제
    public void deleteBoard(Long id){
        boardRepository.delete(id);
    }
}
