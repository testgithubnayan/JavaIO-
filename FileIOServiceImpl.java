package com.bridgelabz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileIOServiceImpl implements PayrollService {
        private final String FILE_PATH = "C:\\Users\\chetan bhagat\\IdeaProjects\\RFP186-JavaIO\\src\\main\\java\\com\\bridgelabz\\Payroll.txt";

        @Override
        public void read() {

        }

        @Override
        public boolean write(List<EmployeePayrollData> employeePayrollDataList) throws IOException {
            StringBuffer buffer = new StringBuffer();
            employeePayrollDataList.forEach(empData -> {
                String empDataString = empData.toString().concat("\n");
                buffer.append(empDataString);
            });
            Path path = Files.write(Paths.get(FILE_PATH), buffer.toString().getBytes());
            return (path == null) ? false : true;
        }

        @Override
        public long countEntries() throws IOException {
            return Files.lines(new File(FILE_PATH).toPath()).count();
        }
}
