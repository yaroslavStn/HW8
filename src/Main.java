import converter.IStudentStringConverter;
import converter.StudentStringConverterJSON;
import converter.StudentStringConverterStandard;
import converter.StudentStringConverterXML;
import human.Student;
import printer.IStudentPrinter;
import printer.StudentPrinterConsole;
import printer.StudentPrinterDefault;
import printer.StudentPrinterDelegate;

public class Main {
    public static void main (String[] args) {
    Main.run();
    }

    private static void run() {
        Student student1 = new Student("Vasia", "Pupkin",20 );
        IStudentStringConverter converterJSON = new StudentStringConverterJSON();
        IStudentStringConverter converterXML = new StudentStringConverterXML();
        IStudentStringConverter converterStandard = new StudentStringConverterStandard();
        IStudentStringConverter [] converters ={
                converterJSON,
                converterStandard,
                converterXML
        };

        for (IStudentStringConverter converter : converters) {
            IStudentPrinter printerConsole = new StudentPrinterConsole(converter);
            printerConsole.print(student1);
        }

        IStudentPrinter printerConsole= new StudentPrinterConsole(converters[0]);
        IStudentPrinter printerDefault = new StudentPrinterDefault();
        printerDefault.print(student1);
        IStudentPrinter[] printers = {
                printerConsole,
                printerDefault
        };
        IStudentPrinter printerDelegate = new StudentPrinterDelegate(printers);
        printerDelegate.print(student1);

    }
}
