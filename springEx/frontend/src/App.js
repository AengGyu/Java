import React, { useEffect, useState } from "react";
import axios from "axios";
import { BrowserRouter as Router, Routes, Route, Link, useParams } from "react-router-dom";
import "./App.css"; // ✅ CSS 적용

// ✅ 게시글 목록 페이지
function BoardList() {
  const [boards, setBoards] = useState([]);
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  useEffect(() => {
    fetchBoards();
  }, []);

  const fetchBoards = () => {
    axios.get("http://localhost:8080/api/boards")
      .then(response => {
        setBoards(response.data);
      })
      .catch(error => {
        console.error("Error fetching boards:", error);
      });
  };

  // ✅ 게시글 추가 기능
  const addBoard = () => {
    if (!title || !content) {
      alert("제목과 내용을 입력하세요.");
      return;
    }

    axios.post("http://localhost:8080/api/boards", { title, content })
      .then(() => {
        setTitle("");
        setContent("");
        fetchBoards();
      })
      .catch(error => {
        console.error("Error adding board:", error);
      });
  };

  // ✅ 게시글 삭제 기능 다시 추가!
  const deleteBoard = (id) => {
    if (window.confirm("게시글을 삭제하시겠습니까?")) {
      axios.delete(`http://localhost:8080/api/boards/${id}`)
        .then(() => {
          fetchBoards(); // 삭제 후 목록 다시 불러오기
        })
        .catch(error => {
          console.error("Error deleting board:", error);
        });
    }
  };

  return (
    <div className="container">
      <h1>게시판</h1>

      {/* ✅ 게시글 추가 폼 */}
      <div className="form">
        <input
          type="text"
          placeholder="제목"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <textarea
          placeholder="내용"
          value={content}
          onChange={(e) => setContent(e.target.value)}
        />
        <button onClick={addBoard}>게시글 추가</button>
      </div>

      {/* ✅ 게시글 목록 */}
      <ul className="board-list">
        {boards.map(board => (
          <li key={board.id}>
            <Link to={`/boards/${board.id}`}>
              <h2>{board.title}</h2>
            </Link>
            <button onClick={() => deleteBoard(board.id)}>삭제</button> {/* ✅ 삭제 버튼 추가 */}
          </li>
        ))}
      </ul>
    </div>
  );
}

// ✅ 게시글 상세 페이지
function BoardDetail() {
  const { id } = useParams();
  const [board, setBoard] = useState(null);

  useEffect(() => {
    axios.get(`http://localhost:8080/api/boards/${id}`)
      .then(response => {
        setBoard(response.data);
      })
      .catch(error => {
        console.error("Error fetching board:", error);
      });
  }, [id]);

  if (!board) return <p>게시글을 불러오는 중...</p>;

  return (
    <div className="container">
      <h1>{board.title}</h1>
      <p>{board.content}</p>
      <Link to="/">🔙 목록으로 돌아가기</Link>
    </div>
  );
}

// ✅ React Router 설정
function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<BoardList />} />
        <Route path="/boards/:id" element={<BoardDetail />} />
      </Routes>
    </Router>
  );
}

export default App;
