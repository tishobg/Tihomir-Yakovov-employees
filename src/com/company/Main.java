package com.company;




import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException, ParseException {


        List<OverlapDuration> end=OverlapDuration.maxquantity();
        OverlapDuration maxValue = end.stream().max(Comparator.comparing(v -> v.getOverlapdays())).get(); //max days spend by one couple in mutual projects
        System.out.println("Employee ID "+maxValue.getEmp().getEmployeeID()+" and "+maxValue.getEmp2().getEmployeeID()+" have spent a total of "+maxValue.getOverlapdays()+" days working together in mutual projects");


    }


public static List<Employee> CreateEmployee() throws IOException { //Creating a new employee object
    Path fileName = Path.of("project.txt");
    String textfile = Files.readString(fileName); //put entire text file into string

    String lines[] = textfile.split("\\r?\\n");
    for (int i = 0; i < lines.length; i++) {
        lines[i] = lines[i].replaceAll("\\s", "");
    }
    List<Employee> list = new ArrayList<Employee>();
    for (int i = 0; i < lines.length; i++) {
    String emp2[] = lines[i].split(",", 4);
    Employee e = new Employee(Integer.parseInt(emp2[0]), Integer.parseInt(emp2[1]), emp2[2], emp2[3]);
    list.add(e);


}
    return list;
} //creating a new employee object


public static List<OverlapDuration> DurationOverlap() throws IOException {
    List<Employee> list=CreateEmployee();
    List<OverlapDuration> list2= new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
        int j=i+1;
        for (; j < list.size(); j++) {
            if (list.get(i).getProjectID() == list.get(j).getProjectID() && list.get(i).getEmployeeID() != list.get(j).getEmployeeID()) {
                LocalDate emp1start = LocalDate.parse(list.get(i).getStartDate());
                LocalDate emp1end = LocalDate.parse(list.get(i).getEndDate());
                LocalDate emp2start = LocalDate.parse(list.get(j).getStartDate());
                LocalDate emp2end = LocalDate.parse(list.get(j).getEndDate());


                if (emp1end.isBefore(emp1start) || emp2end.isBefore(emp2start)) {
                    System.out.println("Not proper intervals");
                } else {
                    long numberOfOverlappingDates;
                    if (emp1end.isBefore(emp2start) || emp2end.isBefore(emp1start)) {
                        // no overlap
                        numberOfOverlappingDates = 0;
                    } else {
                        LocalDate laterStart = Collections.max(Arrays.asList(emp1start, emp2start));
                        LocalDate earlierEnd = Collections.min(Arrays.asList(emp1end, emp2end));
                        numberOfOverlappingDates = ChronoUnit.DAYS.between(laterStart, earlierEnd);
                        OverlapDuration overP=new OverlapDuration(list.get(i), list.get(j), numberOfOverlappingDates);
                        //
                        list2.add(overP);
                    }
                    //System.out.println("" + numberOfOverlappingDates + " days of overlap");
                    //System.out.println(list.get(i).getEmployeeID()+" and "+list.get(j).getEmployeeID());


                }

            }

        }

    }

        return list2;
} //find overlap duration between employees











    }



