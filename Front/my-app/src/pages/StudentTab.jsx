import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../page-css/StudentTab.css'; 

function StudentTab() {
    const navigate = useNavigate();

    // 각 버튼 클릭 시 이동할 페이지 설정
    const handleTabClickProfile = () => {
        navigate('/profile');
    };

    const handleTabClickEnroll = () => {
        navigate('/LectureEnroll'); // 너가 정한 파일명 기준으로!
    };

    const handleTabClickCheck = () => {
        navigate('/course-check'); // 수강 확인 페이지 (아직 없으면 나중에 만들면 됨)
    };

    const handleTabClickView = () => {
        navigate('/grade-view'); // 성적 확인 페이지 (나중에 만들면 됨)
    };

    return (
        <div className="studenttab-bg">
            <div className="student-tab-nav">
                <button className="student-tab-item" onClick={handleTabClickProfile}>
                    학생 프로필
                </button>
                <button className="student-tab-item" onClick={handleTabClickEnroll}>
                    수강신청
                </button>
                <button className="student-tab-item" onClick={handleTabClickCheck}>
                    수강확인
                </button>
                <button className="student-tab-item" onClick={handleTabClickView}>
                    성적확인
                </button>
            </div>
        </div>
    );
}

export default StudentTab;
