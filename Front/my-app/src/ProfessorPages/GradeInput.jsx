import React, { useState } from 'react';
import '../ProfessorPages-css/GradeInput.css';
import ProfessorTab from './ProfessorTab';

const lectures = [
    { id: 1, name: '운영체제' },
    { id: 2, name: '컴퓨터네트워크' },
];

// 더미 학생 데이터
const studentsData = {
    1: [
        { id: 'S1', name: '김재욱' },
        { id: 'S2', name: '박민호' },
    ],
    2: [
        { id: 'S3', name: '이지은' },
        { id: 'S4', name: '최유나' },
    ],
};

function GradeInput() {
    const [page, setPage] = useState('lectureList');
    const [selectedLecture, setSelectedLecture] = useState(null);
    const [grades, setGrades] = useState({});

    const handleLectureClick = (lecture) => {
        setSelectedLecture(lecture);
        setPage('studentList');
    };

    const handleScoreChange = (studentId, value) => {
        setGrades({ ...grades, [studentId]: value });
    };

    const handleSubmit = (studentId) => {
        alert(`${studentId} 성적: ${grades[studentId]}점 등록됨!`);
    };

    return (
        <div className="grade-container">
            <ProfessorTab />
            <h2 className="grade-title">성적 입력</h2>

            {page === 'lectureList' && (
                <>
                    <h3 className="grade-subtitle">개설한 강의</h3>
                    <ul className="lecture-list">
                        {lectures.map((lec) => (
                            <li key={lec.id} className="lecture-item">
                                <button
                                    className="lecture-button"
                                    onClick={() => handleLectureClick(lec)}
                                >
                                    {lec.name}
                                </button>
                            </li>
                        ))}
                    </ul>
                </>
            )}

            {page === 'studentList' && (
                <>
                    <h3 className="grade-subtitle">
                        {selectedLecture.name} - 수강 학생 목록
                    </h3>
                    <ul className="student-list">
                        {studentsData[selectedLecture.id].map((stu) => (
                            <li key={stu.id} className="student-item">
                                <span className="student-name">{stu.name}</span>

                                <select
                                    className="score-select"
                                    value={grades[stu.id] || ''}
                                    onChange={(e) => handleScoreChange(stu.id, e.target.value)}
                                >
                                    <option value="">성적 선택</option>
                                    <option value="F">F</option>
                                    <option value="D">D</option>
                                    <option value="C">C</option>
                                    <option value="C+">C+</option>
                                    <option value="B">B</option>
                                    <option value="B+">B+</option>
                                    <option value="A">A</option>
                                    <option value="A+">A+</option>
                                </select>
                                <button
                                    className="submit-btn"
                                    onClick={() => handleSubmit(stu.id)}
                                >
                                    성적 등록
                                </button>
                            </li>
                        ))}
                    </ul>

                    <button
                        className="back-btn"
                        onClick={() => setPage('lectureList')}
                    >
                        🔙 강의 목록으로 돌아가기
                    </button>
                </>
            )}
        </div>
    );
}

export default GradeInput;
