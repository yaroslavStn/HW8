package converter;

import human.Student;

public class StudentStringConverterJSON implements IStudentStringConverter {
    @Override
    public String convert(Student student) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        result.append("\"name\" : \"");
        result.append(student.getName());
        result.append("\",\n");
        result.append("\"surname\" : \"");
        result.append(student.getSurname());
        result.append("\",\n");
        result.append("\"age\" : \"");
        result.append(student.getAge());
        result.append("\"\n}");

        return result.toString();
    }
}
