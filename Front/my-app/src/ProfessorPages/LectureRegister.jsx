// 📂 LectureRegister.jsx
import React, { useState } from 'react';
import '../ProfessorPages-css/LectureRegister.css'; 

function LectureRegister() {
  const [code, setCode] = useState('');
  const [name, setName] = useState('');
  const [professor, setProfessor] = useState('');
  const [credit, setCredit] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const newLecture = {
      code,
      name,
      professor,
      credit: parseInt(credit),
    };
    console.log('등록된 강의:', newLecture);
    alert('강의가 등록되었습니다!');
  };

  return (
    <div className="enroll-bg"> {/* 중앙 정렬용 */}
      <div className="lecture-register-card">
        <h2 className="form-title">📚 수강 등록</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label className="form-label">과목 코드</label>
            <input
              className="form-input"
              type="text"
              value={code}
              onChange={(e) => setCode(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label className="form-label">과목 이름</label>
            <input
              className="form-input"
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label className="form-label">교수 이름</label>
            <input
              className="form-input"
              type="text"
              value={professor}
              onChange={(e) => setProfessor(e.target.value)}
              required
            />
          </div>

          <div className="form-group">
            <label className="form-label">학점</label>
            <input
              className="form-input"
              type="number"
              value={credit}
              onChange={(e) => setCredit(e.target.value)}
              required
            />
          </div>

          <button type="submit" className="btn-primary">강의 등록</button>
        </form>
      </div>
    </div>
  );
}

export default LectureRegister;
