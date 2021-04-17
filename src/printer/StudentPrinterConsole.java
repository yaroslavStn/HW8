package printer;

import converter.IStudentStringConverter;
import human.Student;

public class StudentPrinterConsole implements IStudentPrinter {

    private IStudentStringConverter converter;

    public StudentPrinterConsole(IStudentStringConverter converter) {
        this.converter = converter;
    }

    @Override
    public void print(Student student) {
        System.out.println(converter.convert(student));
    }
}
