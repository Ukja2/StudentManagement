import React from 'react';
import '../page-css/common.css';
import '../page-css/Profile.css'; // 프로필 페이지 전용 CSS
import StudentTab from './StudentTab'; // 학생 전용 탭 컴포넌트

const Profile = () => {
  const studentInfo = {
    name: '홍길동',
    studentId: '20231234',
    major: '컴퓨터공학과',
    grade: '3학년',
    email: 'hong@student.ac.kr',
    phone: '010-1234-5678',
  };

  return (
    <div className="profile-bg">

        
        
        <div className="card">
            <StudentTab /> {/* 학생 전용 탭 컴포넌트 */}
          <div className="card-title">학생 프로필</div>
          <div className="grid-2">
            <div className="form-group">
              <label className="form-label">이름</label>
              <input type="text" className="form-input" value={studentInfo.name} readOnly />
            </div>
            <div className="form-group">
              <label className="form-label">학번</label>
              <input type="text" className="form-input" value={studentInfo.studentId} readOnly />
            </div>
            <div className="form-group">
              <label className="form-label">학과</label>
              <input type="text" className="form-input" value={studentInfo.major} readOnly />
            </div>
            <div className="form-group">
              <label className="form-label">학년</label>
              <input type="text" className="form-input" value={studentInfo.grade} readOnly />
            </div>
            <div className="form-group">
              <label className="form-label">이메일</label>
              <input type="email" className="form-input" value={studentInfo.email} readOnly />
            </div>
            <div className="form-group">
              <label className="form-label">전화번호</label>
              <input type="tel" className="form-input" value={studentInfo.phone} readOnly />
            </div>
          </div>
        </div>
      </div>
    
  );
};

export default Profile;
