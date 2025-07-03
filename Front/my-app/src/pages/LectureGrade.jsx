import React, { useContext } from 'react';
import { CourseContext } from '../context/CourseContext';
import StudentTab from './StudentTab';
import '../page-css/LectureGrade.css'; 

function LectureGrade() {
  const { enrolledCourses } = useContext(CourseContext); // 전역 수강신청 목록 접근

  return (
    <div className="lecturegrade-bg">
      <div className="card">
        <StudentTab />
        <div className="card-title">성적 확인</div>

        {enrolledCourses.length === 0 ? (
          <p>😅 아직 수강한 과목이 없습니다.</p>
        ) : (
          <ul>
            {enrolledCourses.map(course => (
              <li key={course.id}>
                {course.code} - {course.name} / 교수: {course.professor} →  
                <strong> 성적: {course.grade || '미입력'}</strong>
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default LectureGrade;
