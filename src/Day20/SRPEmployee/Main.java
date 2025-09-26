package Day20.SRPEmployee;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", "alice@example.com", 50000);

        EmpReportGenerator reportGenerator = new EmpReportGenerator();
        reportGenerator.generatePdfReport(emp);

        EmpEmailService emailService = new EmpEmailService();
        emailService.sendEmail(emp);
    }
}
