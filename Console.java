import java.util.LinkedList;
import java.util.Scanner;

public class Console{

    private static Scanner scan = new Scanner(System.in);

    public static boolean mainloop()
    {
        String foo = "";
        LinkedList<String> list = new LinkedList<String>();
        System.out.println("Program reads, deletes and saves entered text.\nTo print out saved text enter print.\nTo delete previously entered word enter revert.");
        System.out.println("To terminate the program enter exit");
        while(true)
        {
            foo = scan.nextLine();
            switch (foo) {
                case "print":
                    if(list.size() != 0)
                        {
                        for(int i = list.size() - 1; i >= 0; i--)
                            System.out.print(list.get(i) + " ");
                        System.out.println();
                        break;
                        }
                    continue;
                case "revert":
                    if(list.size() != 0)
                    {
                        list.removeLast();
                        break;
                    }
                    continue;
                case "exit":
                    return true;
                default:
                    list.addLast(foo);
                    break;
            }
        }
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