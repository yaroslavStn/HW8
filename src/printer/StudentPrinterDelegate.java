package printer;

import human.Student;

public class StudentPrinterDelegate implements IStudentPrinter{

    private IStudentPrinter [] printers;

    public StudentPrinterDelegate(IStudentPrinter[] printers) {
        this.printers = printers;
    }

    @Override
    public void print(Student student) {
        for (IStudentPrinter printer : printers) {
            printer.print(student);
        }

    }
}
