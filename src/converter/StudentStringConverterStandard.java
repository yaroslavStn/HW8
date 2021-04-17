package converter;

import human.Student;

public class StudentStringConverterStandard implements IStudentStringConverter{
    @Override
    public String convert(Student student) {
        StringBuilder result = new StringBuilder();
        result.append("student:\n");
        result.append("name=");
        result.append(student.getName()+'\n');
        result.append("surname=");
        result.append(student.getSurname()+'\n');
        result.append("age=");
        result.append(student.getAge());
        result.append('\n');

        return result.toString();
    }
}
