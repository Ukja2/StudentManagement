import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../page-css/StudentTab.css'; 

function StudentTab() {
    const navigate = useNavigate();

    // 네비게이션 핸들러들
    const handleTabClickProfile = () => {
        navigate('/profile');
    };

    const handleTabClickEnroll = () => {
        navigate('/enroll');
    };

    const handleTabClickCheck = () => {
        navigate('/check');
    };

    const handleTabClickView = () => {
        navigate('/view');
    };

    return (
        <div className="studenttab-bg">
            {/* 네비게이션 버튼들 */}
            <div className="student-tab-nav">
                <button className="student-tab-item">
                    학생 프로필
                </button>
                <button className="student-tab-item">
                    수강신청
                </button>
                <button className="student-tab-item">
                    수강확인
                </button>
                <button className="student-tab-item">
                    성적확인
                </button>
            </div>
        </div>
    );
}

export default StudentTab;
