import { createContext, useState } from 'react';

export const CourseContext = createContext();

export const CourseProvider = ({ children }) => {
  const [enrolledCourses, setEnrolledCourses] = useState([]);

  return (
    <CourseContext.Provider value={{ enrolledCourses, setEnrolledCourses }}>
      {children}
    </CourseContext.Provider>
  );
};
