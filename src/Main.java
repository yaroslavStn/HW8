import converter.IStudentStringConverter;
import human.Student;
import printer.IStudentPrinter;

public class Main {
    public static void main(String[] args) {
        Main.run();
    }

    private static void run() {
        Student student1 = new Student("Vasia", "Pupkin", 20);
        IStudentStringConverter converterJSON = new IStudentStringConverter() {
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
        };


        IStudentStringConverter converterXML = new IStudentStringConverter() {
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
        };

        IStudentStringConverter converterStandard = new IStudentStringConverter() {
            @Override
            public String convert(Student student) {
                StringBuilder result = new StringBuilder();
                result.append("student:\n");
                result.append("name=");
                result.append(student.getName() + '\n');
                result.append("surname=");
                result.append(student.getSurname() + '\n');
                result.append("age=");
                result.append(student.getAge());
                result.append('\n');

                return result.toString();
            }
        };

        IStudentStringConverter[] converters = {
                converterJSON,
                converterStandard,
                converterXML
        };

        for (IStudentStringConverter converter : converters) {
            IStudentPrinter printerConsole = new IStudentPrinter() {
                @Override
                public void print(Student student) {
                    System.out.println(converter.convert(student));
                }
            };
            printerConsole.print(student1);
        }

        IStudentPrinter printerConsole = new IStudentPrinter() {
            @Override
            public void print(Student student) {
                System.out.println(converterStandard.convert(student));
            }
        };
        printerConsole.print(student1);
        IStudentPrinter printerDefault = new IStudentPrinter() {
            @Override
            public void print(Student student) {

            }
        };
        printerDefault.print(student1);

        IStudentPrinter[] printers = {
                printerConsole,
                printerDefault
        };

        IStudentPrinter printerDelegate = new IStudentPrinter() {
            @Override
            public void print(Student student) {
                for (IStudentPrinter printer : printers) {
                    printer.print(student);
                }
            }
        };
       printerDelegate.print(student1);

    }
}
