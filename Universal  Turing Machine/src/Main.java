import java.util.Scanner;
public class Main {
    public static int getindex(String[] array, String w) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(w)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of State");
        int x = sc.nextInt();
        System.out.println("Enter number of Alphapet");
        int y = sc.nextInt();
        System.out.println("Enter the states");
        String[] arr = new String[x];
        for (int i = 0; i < x; i++) {
            arr[i] = sc.next();
        }
        System.out.println("Enter the Alphapet");
        String[] arr2 = new String[y];
        for (int i = 0; i < y; i++) {
            arr2[i] = sc.next();
        }
        String[][] transiton = new String[x * y][5];
        for (int i = 0; i < x * y; i++) {
            System.out.println("enter the transition" + (i + 1) + "");
            String kk = sc.next();
            String[] temp = kk.split("-");
            for (int j = 0; j < 5; j++) {
                transiton[i][j] = temp[j];
            }
            System.out.println("");
        }
        System.out.println("Enter the Position of head");
        int head = sc.nextInt();
        System.out.println("Enter the string");
        String input = sc.next();
        char[] tape = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            tape[i] = input.charAt(i);
        }
        String cuurentstat = transiton[0][0];
        int headposition = head;
        while (true) {
            int indexofstate = getindex(arr, cuurentstat);
            String nextstat = " ";
            char newsymbol = 0;
            int direction = 0;
            for (int i = 0; i < y; i++) {
                if (String.valueOf(tape[headposition]).equals(transiton[(indexofstate * y) + i][1])) {
                    nextstat = transiton[(indexofstate * y) + i][2];
                    newsymbol = transiton[(indexofstate * y) + i][3].charAt(0);
                    direction = transiton[(indexofstate * y) + i][4].charAt(0);
                    break;
                }
            }
            tape[headposition] = newsymbol;
            if (direction == 'R') {
                if (headposition == tape.length - 1) {
                    char[] newtape = new char[tape.length + 1];
                    for (int i = 0; i < tape.length; i++) {
                        newtape[i] = tape[i];
                    }
                    newtape[newtape.length - 1] = '#';
                    tape = newtape;
                }
                headposition++;
            } else if (direction == 'L') {
                headposition--;
            } else if (direction == 'Y') {
                System.out.println("Accepted");
                System.out.println(new String(tape));
                System.out.println("Position of head at" + headposition);
                break;
            } else if (direction == 'N') {
                System.out.println("rejected");
                System.out.println(new String(tape));
                System.out.println("position of head" + headposition);
                break;
            }
            cuurentstat = nextstat;
        }
    }
}