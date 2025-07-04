import React, { useState } from 'react';
import '../page-css/SignupPage.css';

function SignupPage() {
  const [formData, setFormData] = useState({
    userId: '',
    userName: '',
    password: '',
    confirmPassword: '',
    email: '',
    department: '',
    role: '학생',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      alert('비밀번호가 일치하지 않아요!');
      return;
    }

    console.log('회원가입 정보:', formData);

    
  };

  return (
    <div className="signup-bg">
      <div className="form-box">
        <div className="form-title">회원가입</div>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>학번 / 교번</label>
            <input type="text" name="userId" value={formData.userId} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>이름</label>
            <input type="text" name="userName" value={formData.userName} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>이메일</label>
            <input type="email" name="email" value={formData.email} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>비밀번호</label>
            <input type="password" name="password" value={formData.password} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>비밀번호 확인</label>
            <input type="password" name="confirmPassword" value={formData.confirmPassword} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>소속 학과 / 부서</label>
            <input type="text" name="department" value={formData.department} onChange={handleChange} required />
          </div>

          <div className="form-group">
            <label>사용자 유형</label>
            <select name="role" value={formData.role} onChange={handleChange}>
              <option value="학생">학생</option>
              <option value="교수">교수</option>
            </select>
          </div>

          <button type="submit" className="btn-primary">가입하기</button>
        </form>
      </div>
    </div>
  );
}

export default SignupPage;
