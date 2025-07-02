import React from 'react';
import { useNavigate } from 'react-router-dom';

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
            <h2>학생 전용 탭</h2>

            {/* 네비게이션 버튼들 */}
            <div className="student-tab-nav">
                <button
                    className="student-tab-item"
                    onClick={handleTabClickProfile}
                >
                    학생 프로필
                </button>

                <button
                    className="student-tab-item"
                    onClick={handleTabClickEnroll}
                >
                    수강신청
                </button>

                <button
                    className="student-tab-item"
                    onClick={handleTabClickCheck}
                >
                    수강확인
                </button>

                <button
                    className="student-tab-item"
                    onClick={handleTabClickView}
                >
                    성적확인
                </button>
            </div>
        </div>
    );
}

export default StudentTab;
