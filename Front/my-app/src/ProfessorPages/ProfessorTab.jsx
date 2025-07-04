import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../ProfessorPages-css/ProfessorTab.css'; 

function ProfessorTab() {
  const navigate = useNavigate();

  const handleTabClickRegister = () => {
    navigate('/LectureRegister'); 
  };

  const handleTabClickGrade = () => {
    navigate('/GradeInput');
  };

  return (
    <div className="professortab-bg">
      <div className="professor-tab-nav">
        <button className="professor-tab-item" onClick={handleTabClickRegister}>
          수강 등록
        </button>
        <button className="professor-tab-item" onClick={handleTabClickGrade}>
          성적 입력
        </button>
      </div>
    </div>
  );
}

export default ProfessorTab;
