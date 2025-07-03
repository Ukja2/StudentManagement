import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { CourseProvider } from './context/CourseContext';
import Login from './pages/Login.jsx';  // 로그인 페이지
import Profile from './pages/Profile.jsx'; // 학생 프로필 페이지
import LectureEnroll from './pages/LectureEnroll.jsx'; // 수강신청 페이지

function App() {
  return (
    <CourseProvider>{/* CourseContext를 제공하는 프로바이더 */}
      <Router>
        <Routes>
          {/* "/" 경로에 로그인 페이지를 렌더링 */}
          <Route path="/" element={<Login />} /> {/* 로그인 페이지 */}
          <Route path="/profile" element={<Profile />} /> {/* 학생 프로필 페이지 */}
          <Route path="/LectureEnroll" element={<LectureEnroll />} /> {/* 수강신청 페이지 */}
        </Routes>
      </Router>
    </CourseProvider>
  );
}

export default App;
