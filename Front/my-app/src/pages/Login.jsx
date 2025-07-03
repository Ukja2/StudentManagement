import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../page-css/common.css';
import '../page-css/Login.css';
import StudentTab from './StudentTab';

function LoginForm() {
    const navigate = useNavigate();
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const [userType, setUserType] = useState('학생');

    const handleLoginClick = (e) => {
        e.preventDefault();
        if (userType === '학생') {
            if (userId === 'student' && password === 'student123') {
                navigate('/profile');
            }
        } else if (userType === '교수') {
            if (userId === 'professor' && password === 'professor123') {
                navigate('/LectureRegister');
                
            }
        }
    };

    return (
        <div className="login-bg">
            <div className="form-box">
                <div className="form-title">로그인</div>
                <form>
                    <div className="form-group">
                        <label htmlFor="userId" className="form-label">학번/교번</label>
                        <input
                            type="text"
                            id="userId"
                            className="form-input"
                            placeholder="학번 또는 교번 입력"
                            value={userId}
                            onChange={(e) => setUserId(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password" className="form-label">비밀번호</label>
                        <input
                            type="password"
                            id="password"
                            className="form-input"
                            placeholder="비밀번호 입력"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="userType" className="form-label">사용자 유형</label>
                        <select
                            id="userType"
                            className="form-input"
                            value={userType}
                            onChange={(e) => setUserType(e.target.value)}
                        >
                            <option value="학생">학생</option>
                            <option value="교수">교수</option>
                        </select>
                    </div>
                    <button type="button" className="btn-primary" onClick={handleLoginClick}>로그인</button>
                    <div className='signup-link'>
                        <a href="#" >회원가입</a>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default LoginForm;
