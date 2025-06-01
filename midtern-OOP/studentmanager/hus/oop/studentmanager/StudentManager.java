package hus.oop.studentmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    public StudentManager() {
        this.studentList = new LinkedList<>();
    }

    public StudentManager getInstance() {
        if (studentList == null) {
            return new StudentManager();
        }
        return this;
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        /* TODO */
        return index >= 0 && index <= limit;
    }

    public List<Student> getStudentList() {
        /* TODO */
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        this.studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index, chỉ thêm vào nếu index có giá trị
     * nằm trong đoạn từ [0 - length], trong đó length là số sinh viên trong danh sách hiện tại.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        this.studentList.add(index, student);
    }

    /**
     * Xóa sinh viên ở vị trí index, chỉ xóa được nếu index nằm trong đoạn [0 - (length - 1)],
     * trong đó length là số sinh viên trong danh sách hiện tại.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        this.studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index.
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return this.studentList.get(index);
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
     * @return
     */
    public List<Student> sortStudentByName() {
        /* TODO */
        List<Student> studentList = new LinkedList<>(this.studentList);
        Collections.sort(studentList);
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeIncreasing() {
        /* TODO */
        List<Student> studentList = new LinkedList<>(this.studentList);
        studentList.sort((o1, o2) -> {
            if (o1.getAverageGrade() > o2.getAverageGrade()) {
                return 1;
            } else if (o1.getAverageGrade() < o2.getAverageGrade()) {
                return -1;
            }
            if (o1.getMathsGrade() > o2.getMathsGrade()) {
                return 1;
            } else if (o1.getMathsGrade() < o2.getMathsGrade()) {
                return -1;
            }
            return 0;
        });
        return studentList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeDecreasing() {
        /* TODO */
        List<Student> studentList = new LinkedList<>(this.studentList);
        studentList.sort(Collections.reverseOrder((o1, o2) -> {
            if (o1.getAverageGrade() > o2.getAverageGrade()) {
                return 1;
            } else if (o1.getAverageGrade() < o2.getAverageGrade()) {
                return -1;
            }
            if (o1.getMathsGrade() > o2.getMathsGrade()) {
                return 1;
            } else if (o1.getMathsGrade() < o2.getMathsGrade()) {
                return -1;
            }
            return 0;
        }));
        return studentList;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortByGradeDecreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsLowestGrade(int howMany) {
        /* TODO */
        List<Student> studentList = sortByGradeIncreasing();
        List<Student> filteredStudentList = new LinkedList<>();
        for (Student student : studentList) {
            if (howMany > 0) {
                filteredStudentList.add(student);
                howMany--;
            }
        }
        return filteredStudentList;
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
