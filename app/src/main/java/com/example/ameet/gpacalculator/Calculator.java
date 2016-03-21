package com.example.ameet.gpacalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Ameet on 10/24/2015.
 */
public class Calculator {


    public Calculator() {

    }


//    public void addClassToArray(Class mClass) {
//        if (mClass != null) {
//            classList.add(mClass);
//        }
//    }
//    public String listOfGradesWithBreaks(){
//        String gradesList="";
//        for (int i = 0;i<classList.size();i++)
//        {
//            gradesList+="class 1:"
//                    +classList.get(i).getGrade()
//                    +System.getProperty("line.separator")
//            ;
//
//        }
//        return gradesList;
//    }

    public String calculate(ArrayList<Class>classList) {
        double GPA = 0.0;

        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).getGrade().equals("A+"))
                GPA += 4;
            else if (classList.get(i).getGrade().equals("A"))
                GPA += 4;
            else if (classList.get(i).getGrade().equals("A-"))
                GPA += 3.67;
            else if (classList.get(i).getGrade().equals("B+"))
                GPA += 3.33;
            else if (classList.get(i).getGrade().equals("B"))
                GPA += 3.0;
            else if (classList.get(i).getGrade().equals("B-"))
                GPA += 2.67;
            else if (classList.get(i).getGrade().equals("C+"))
                GPA += 2.33;
            else if (classList.get(i).getGrade().equals("C"))
                GPA += 2.0;
            else if (classList.get(i).getGrade().equals("C-"))
                GPA += 1.67;
            else if (classList.get(i).getGrade().equals("D+"))
                GPA += 1.33;
            else if (classList.get(i).getGrade().equals("D"))
                GPA += 1.0;
            else if (classList.get(i).getGrade().equals("D-"))
                GPA += .67;
            else if (classList.get(i).getGrade().equals("F"))
                GPA += 0;
        }


        if (classList.size() == 0) {
            return "please enter a class";
        } else {
            double dblVar = (GPA / classList.size());
            return String.valueOf(new DecimalFormat("#.##").format(dblVar));

        }
    }
    public boolean checkValidGrade(String grade)
    {
        boolean b=false;
        if (grade.equals("A+"))
           b=true;
        else if (grade.equals("A"))
            b=true;
        else if (grade.equals("A-"))
            b=true;
        else if (grade.equals("B+"))
            b=true;
        else if (grade.equals("B"))
            b=true;
        else if (grade.equals("B-"))
            b=true;
        else if (grade.equals("C+"))
            b=true;
        else if (grade.equals("C"))
            b=true;
        else if (grade.equals("C-"))
            b=true;
        else if (grade.equals("D+"))
            b=true;
        else if (grade.equals("D"))
            b=true;
        else if (grade.equals("D-"))
            b=true;
        else if (grade.equals("F"))
            b=true;


       return b;
    }

}
