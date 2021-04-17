package converter;

import human.Student;

public class StudentStringConverterXML implements IStudentStringConverter {
    @Override
    public String convert(Student student) {
        StringBuilder result = new StringBuilder();
        result.append("<student>\n");
        result.append("<name>");
        result.append(student.getName());
        result.append("</name>\n");
        result.append("<surname>");
        result.append(student.getSurname());
        result.append("</surname>\n");
        result.append("<age>");
        result.append(student.getAge());
        result.append("</age>\n");
        result.append("</student>");

        return result.toString();
    }
}
