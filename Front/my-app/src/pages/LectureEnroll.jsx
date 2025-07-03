import React, { useState, useContext } from 'react'; 
import StudentTab from './StudentTab'; 
import '../page-css/LectureEnroll.css'; // 이 페이지 전용 CSS
import { CourseContext } from '../context/CourseContext'; // 수강신청 목록을 저장하는 전역 상태

// 수강 가능한 과목 리스트 (임시 더미 데이터)
// 나중에는 이 부분을 서버(API)에서 가져오면 됨!
const courseList = [
  { id: 1, code: '10001-01', name: '자료구조', professor: '주홍택', credit: 3 },
  { id: 2, code: '20002-01', name: '운영체제', professor: '이덕우', credit: 3 },
  { id: 3, code: '30003-01', name: '네트워크', professor: '사공상욱', credit: 3 },
];

function LectureEnroll() {
  const [inputCode, setInputCode] = useState(''); // 사용자가 입력한 수강번호 상태
  
  // 전역 상태인 수강신청한 과목들 배열과 그걸 수정할 함수 가져옴
  const { enrolledCourses, setEnrolledCourses } = useContext(CourseContext); 
  

  // 수강신청 버튼 클릭 시 실행되는 함수
  const handleEnroll = () => {
    // 입력한 수강코드로 과목이 실제로 존재하는지 찾음
    const course = courseList.find(c => c.code === inputCode.trim().toUpperCase());

    // 찾은 과목이 없으면 → 존재하지 않는 과목이라는 메시지 출력
    if (!course) {
      alert('❌ 해당 과목이 존재하지 않습니다.');
      return;
    }

    // 이미 수강신청한 과목이라면 → 중복 신청 막기
    if (enrolledCourses.find(c => c.id === course.id)) {
      alert('⚠️ 이미 신청한 과목입니다.');
      return;
    }

    // 수강신청 성공 시 → 기존 신청 목록에 새 과목 추가
    setEnrolledCourses([...enrolledCourses, course]);

    // 성공 메시지 alert
    alert(`${course.name} 수강신청 완료!`);

    // 입력 필드 초기화
    setInputCode('');
  };

  return (
    <div className="enroll-bg">
      <div className="card">
        <StudentTab /> {/* 학생 탭 영역 */}
        <div className="card-title">수강신청 (코드 입력 방식)</div>

        <div className="form-group">
          <label className="form-label">수강번호 입력</label>
          <input
            type="text"
            className="form-input"
            placeholder="예: 10001-01"
            value={inputCode}
            onChange={(e) => setInputCode(e.target.value)} // 입력값 변경 감지
          />
        </div>

        <button className="btn-primary" onClick={handleEnroll}>
          신청하기
        </button>
      </div>
    </div>
  );
}

export default LectureEnroll;
