package programs.others;

import java.util.*;

/**
 * Hacker rank leader board problem
 */
public class RankMarks {

    public static void main(String args[]) throws Exception {
        List<Student> list = new ArrayList<>();
 /*       Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int size =  Integer.parseInt(s);
        for(int i=0;i<size;i++){
            String[] input = new String[2];
            String a, b;
            input = sc.nextLine().split(" ");
            a= input[0];
            b= input[1];
            Student student = new Student();
            student.setMarks(Integer.parseInt(b));
            student.setName(a);
            list.add(student);
        }*/


        Student student0 = new Student();
        student0.setMarks(45);
        student0.setName("AAB");
        list.add(student0);
        // 2
        Student student = new Student();
        student.setMarks(45);
        student.setName("AAA");
        list.add(student);
        // 2
        Student student2 = new Student();
        student2.setMarks(32);
        student2.setName("chatur");
        list.add(student2);
        //3
        Student student3 = new Student();
        student3.setMarks(30);
        student3.setName("raju");
        list.add(student3);
        //5
        Student student4 = new Student();
        student4.setMarks(28);
        student4.setName("farhan");
        list.add(student4);
        // 5
        Student student5 = new Student();
        student5.setMarks(32);
        student5.setName("virus");
        list.add(student5);
        //6
        Student student6 = new Student();
        student6.setMarks(45);
        student6.setName("joy");
        list.add(student6);
        //67
        Student student7 = new Student();
        student7.setMarks(32);
        student7.setName("Raghu");
        list.add(student7);
        //8
        Student student8 = new Student();
        student8.setMarks(32);
        student8.setName("student8");
        list.add(student7);
        // 9
        Student student9 = new Student();
        student9.setMarks(34);
        student9.setName("student9");
        list.add(student9);
        //10
        Student student10 = new Student();
        student10.setMarks(48);
        student10.setName("rancho2");
        list.add(student10);

        list.sort((s1, s2) -> {

            if (s1.marks == s2.marks) {
                char[] xarray = s1.name.toCharArray();
                char[] yarray = s2.name.toCharArray();
                for(int i=0;i<xarray.length;i++) {
                    char left = xarray[i];
                    char right = yarray[i];

                    if (right < left)
                        return 1;
                    else if (right > left)
                        return -1;
                }
            } else if (s1.marks > s2.marks) {

                return -1;
            }

            return 1;

        });


        int rank = 1;
        boolean conseqEqual = false;
        list.get(0).setRank(rank);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getMarks() == list.get(i - 1).getMarks()) {
                list.get(i).setRank(rank);
                list.get(i - 1).setRank(rank);
                conseqEqual = true;
            } else {
                if(conseqEqual){
                    rank = rank+2;
                    list.get(i).setRank(rank);
                    conseqEqual = false;
                }else {
                    rank = rank + 1;
                    list.get(i).setRank(rank);
                }

            }
        }

        for (Student value : list) {
            System.out.println(value.name + " " + value.rank + " " + value.marks);
        }
    }
}

class Student {
    int marks;
    String name;
    int rank;

    public int getMarks() {
        return marks;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
