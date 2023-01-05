import java.util.*;
public class ToDoList{
    static class Task{ 
        /*if it's not defined as static ,
          then we have to create object of the outer class to add element in ArrayList*/
        String tasks;

        Task(String task){
           tasks=task;
        }

        public String toString(){
            return this.tasks;
        }
    }
    public static void main(String[] args){

       
        //contains our tasks
        ArrayList<Task> toDoList = new ArrayList<>();
        toDoList.add(new Task("Practice ArrayList Problems"));
        toDoList.add(new Task("Do Projects using ArrayList"));

        int choice;
        do{
            System.out.println("1: Add my task");
            System.out.println("2: Edit my existing task");
            System.out.println("3: Display all of my task");
            System.out.println("4: Remove specified task");
            System.out.print("Enter your choice : ");
            
            Scanner input = new Scanner(System.in);
            //input.nextLine();
            choice = input.nextInt();
            System.out.println("\n");
         switch(choice){
          case 1:{
            System.out.print("Add your task : ");
            input.nextLine();
            String addTask = input.nextLine();
            toDoList.add(new Task(addTask));
            break;
          }
             
          //edit the task
           case 2:{
             System.out.print("Which task do you want to edit ?");
             int getIndex = input.nextInt();
             input.nextLine(); 
             //if it's not define here, then line "String editTask = input.nextLine()" will skipped by compiler

             //why....? nextInt(),nextDouble()...etc., except the nextLine(),
             // ----  after getting the input from the user it's remains in the buffer. 
             //In that time, nextLine() will call . then the compiler goes to the nextline i.e., new line
             //so that only nextLine() after any of the method like nextInt(),..Etc., works as same as enter or new line
             //TO RESOLVE THIS ISSUE , USE "nextLine() before call nextLine()/after nextInt()..etc.,"
             
             //Scanner works like fill the buffer 
             //whenever the user enters the input and 
             //empty the buffer whenever scanner's object gets closed or another input is received from the user
        
            System.out.println(getIndex+" "+toDoList.get(getIndex-1));
            System.out.println("Enter task : ");
            String editTask = input.nextLine();
        
            toDoList.set(getIndex-1,new Task(editTask));
            System.out.println("\nAfter editing the task, here is the list of your toDoList\n"); 

            for(int index=0; index<toDoList.size(); index++)
                System.out.println((index+1)+" "+toDoList.get(index));
            System.out.println();
            break;
            }

           //display all the task  
            case 3:
           {
            for(int index=0; index<toDoList.size(); index++)
                System.out.println((index+1)+" "+toDoList.get(index));
            System.out.println();
            break;
            }

            case 4:{
                System.out.println("Which task do you want to remove from to-do list ?");
                int removeAtIndex=input.nextInt();
                //task list starts from 1.But, in arraylist index starts from 0.
                //whenever the user wants to remove specific task, then it should be removeAtIndex-1
                //eg: if the user wants to delete the first task,then he/she enter 1 i.e., first index of arraylist - 0
                toDoList.remove(removeAtIndex-1);
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