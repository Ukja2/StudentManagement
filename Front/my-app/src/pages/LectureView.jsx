import React, { useContext } from 'react';
import { CourseContext } from '../context/CourseContext';
import StudentTab from './StudentTab';
import '../page-css/LectureView.css';

function LectureView() {
  // 수강신청한 과목 리스트 (전역 상태에서 가져옴)
  const { enrolledCourses } = useContext(CourseContext);

  return (
    <div className="lectureview-bg">
      <div className="card">
        <StudentTab />
        <div className="card-title">수강확인</div>

        {/* 수강한 과목이 없다면 메시지 출력 */}
        {enrolledCourses.length === 0 ? (
          <p>😅 아직 수강한 과목이 없습니다.</p>
        ) : (
          // 수강한 과목이 있다면 리스트로 출력
          <ul>
            {enrolledCourses.map(course => (
              <li key={course.id}>
                {course.code} - {course.name} ({course.credit}학점) / {course.professor}
              </li>
            ))}
          </ul>
        )}
      </div>
    </div>
  );
}

export default LectureView;
