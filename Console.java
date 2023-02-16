import java.util.LinkedList;
import java.util.Scanner;

public class Console{

    private static Scanner scan = new Scanner(System.in);

    public static boolean mainloop()
    {
        String foo = "";
        LinkedList<String> list = new LinkedList<String>();
        System.out.println("Program reads and saves entered text.\nTo print out saved text enter print");
        System.out.println("To terminate the program enter exit");
        while(true)
        {
            foo = scan.nextLine();
            if(foo.equals("print") && list.size() != 0)
            {
                for(int i = list.size() - 1; i >= 0; i--)
                    System.out.print(list.get(i) + " ");
                System.out.println();
            }
            if(foo.equals("exit"))
                break;
            else
            {
                list.addLast(foo);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while(true)
        {
            System.out.println("Program is running.");
            if(mainloop())
                break;
        }
        System.out.println("Program was terminated");
        scan.close();
    }
}