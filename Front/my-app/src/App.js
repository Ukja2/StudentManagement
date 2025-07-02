import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'; 
import Login from './pages/Login.jsx';  // 로그인 페이지
import Profile from './pages/Profile.jsx'; // 학생 프로필 페이지

function App() {
  return (
    <Router>
      <Routes>
        {/* "/" 경로에 로그인 페이지를 렌더링 */}
        <Route path="/" element={<Login />} /> {/* 로그인 페이지 */}
        <Route path="/profile" element={<Profile />} /> {/* 학생 프로필 페이지 */}
      </Routes>
    </Router>
  );
}

export default App;
