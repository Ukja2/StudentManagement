import React, { useState } from 'react';
import '../page-css/SignupPage.css';
import { useNavigate } from 'react-router-dom';

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

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // const handleSubmit = (e) => {
  //   e.preventDefault();
  //
  //   if (formData.password !== formData.confirmPassword) {
  //     alert('비밀번호가 일치하지 않아요!');
  //     return;
  //   }
  //
  //   console.log('회원가입 정보:', formData);
  //
  //
  // };

  const BASE_URL = process.env.REACT_APP_API_BASE_URL;

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      alert('비밀번호가 일치하지 않아요!');
      return;
    }

    const payload = {
      userName: formData.userName,
      password: formData.password,
      email: formData.email,
      department: formData.department,
    };

    const endpoint =
        formData.role === '학생'
            ? '/auth/register/student'
            : '/auth/register/professor';

    try {
      const response = await fetch(`${BASE_URL}${endpoint}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(payload),
      });

      if (response.ok) {
        const message = await response.text();
        alert(message);
        navigate(-1);

      } else {
        alert('회원가입 실패! 다시 시도해주세요.');
      }
    } catch (error) {
      console.error('서버 연결 실패:', error);
      alert('서버와 연결할 수 없습니다.');
    }
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
