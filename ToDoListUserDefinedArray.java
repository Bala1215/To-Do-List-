import java.util.*;
public class ToDoListUserDefinedArray {

    static class Task{
        String tasks;
        static int count=0;

        Task(String task){
           tasks = task;
        }

        public String toString(){
            return this.tasks;
        }
    }
    public static void main(String[] args) {
        //assign length as 100(limit)
        Task[] toDoList = new Task[100];
        toDoList[Task.count++] = new Task("Practice ArrayList Problems");


        //System.out.println(Arrays.toString(toDoList)+" "+Task.count);

        int choice;
        do{
            System.out.println("1: Add my task");
            System.out.println("2: Edit my existing task");
            System.out.println("3: Display all of my task");
            System.out.println("4: Remove specified task");
            System.out.print("Enter your choice : ");
            //
            Scanner input = new Scanner(System.in);
            //input.nextLine();
            choice = input.nextInt();
            System.out.println("\n");
         switch(choice){
          case 1:{
            System.out.print("Add your task : ");
            input.nextLine();
            String addTask = input.nextLine();
            //static field of Nested class should be accessed by using it's class name like a normal static field in concrete class
            toDoList[Task.count++]=new Task(addTask);
            break;
          }
             
          //edit the task
           case 2:{
             System.out.print("Which task do you want to edit ?");
             int getIndex = input.nextInt();
             input.nextLine(); //if it's not define here, then line 57 will skipped by compiler

             //why....? nextInt(),nextDouble()...etc., except the nextLine(),
             // ----  after getting the input from the user it's remains in the buffer. 
             //In that time, nextLine() will call . then the compiler goes to the nextline i.e., new line
             //so that only nextLine() after any of the method like nextInt(),..Etc., works as same as enter or new line
             //TO RESOLVE THIS ISSUE , USE "nextLine() before call nextLine()/after nextInt()..etc.,"
             
             //Scanner works like fill the buffer 
             //whenever the user enters the input and 
             //empty the buffer whenever scanner's object gets closed or another input is received from the user
        
            System.out.println(getIndex+" "+toDoList[getIndex-1]);
            System.out.println("Enter task : ");
            String editTask = input.nextLine();
        
            toDoList[getIndex-1] = new Task(editTask);
            System.out.println("After editing the task, here is the list of your toDoList"); 

            for(int index=0; index<toDoList.length && toDoList[index]!=null/* to avoid printing null values */; index++)
                //toDoList[index]!="" --> should not use "" in Array of objects 
                //i.e., it's a User-Defined class not a String type
                //Task[] toDoList --> it's considered as an array of objects. so, it's default value should be "null"
                System.out.println((index+1)+" "+toDoList[index]);
            System.out.println();
            break;
            }

           //display all the task  
            case 3:
           {
            for(int index=0; index<toDoList.length && toDoList[index]!=null; index++)
                   System.out.println((index+1)+" "+toDoList[index]);
            System.out.println();
            break;
           }

            case 4:{
                System.out.println("Which task do you want to remove from to-do list ?");
                int removeAtIndex=input.nextInt();
                //task list starts from 1.But, in array's index starts from 0.
                //whenever the user wants to remove specific task, then it should be removeAtIndex-1
                //eg: if the user wants to delete the first task,then he/she enter 1 i.e., first index of arraylist - 0
                toDoList[removeAtIndex-1]=null;
                Task.count--;
                break;
            }
            default:
                System.exit(1);
                break;

        }
        //input.close();      

    }while(choice!=5);
    }
}
