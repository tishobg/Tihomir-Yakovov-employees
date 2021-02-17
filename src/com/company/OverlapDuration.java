package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OverlapDuration {

public Employee emp;
public Employee emp2;
public long overlapdays;

    public OverlapDuration(Employee emp, Employee emp2, long overlapdays) {
        this.emp = emp;
        this.emp2 = emp2;
        this.overlapdays = overlapdays;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Employee getEmp2() {
        return emp2;
    }

    public void setEmp2(Employee emp2) {
        this.emp2 = emp2;
    }

    public long getOverlapdays() {
        return overlapdays;
    }

    public void setOverlapdays(long overlapdays) {
        this.overlapdays = overlapdays;
    }

    public static List<OverlapDuration> maxquantity() throws IOException { //this function sums the days a couple has worked together in different projects, so the total sum of days they've worked together
        List<OverlapDuration> list=Main.DurationOverlap();
        List<OverlapDuration> maxhours=new ArrayList<OverlapDuration>();
        for(int i=0;i<list.size();i++)
        {
            int j=i+1;
            for(;j<list.size();j++)
            {

                if(list.get(i).getEmp().getEmployeeID()==list.get(j).getEmp().getEmployeeID() && list.get(i).getEmp2().getEmployeeID()==list.get(j).getEmp2().getEmployeeID())
                {
                    Employee one=list.get(i).getEmp();
                    Employee two=list.get(i).getEmp2();
                    long number=list.get(i).overlapdays+list.get(j).overlapdays;
                    OverlapDuration od=new OverlapDuration(one,two,number);
                    maxhours.add(od);
                    list.remove(j);

                }

            }
           if (maxhours.get(maxhours.size()-1).getEmp().getEmployeeID()==list.get(i).getEmp().getEmployeeID())
           {}
           else{maxhours.add(list.get(i));}
        }

        return maxhours;
    } //this function


    @Override
    public String toString() {
        return "OverlapDuration{" +
                "emp=" + this.emp.getEmployeeID() +
                ", emp2=" + this.emp2.getEmployeeID() +
                ", overlapdays=" + this.overlapdays +
                '}';
    }
}
