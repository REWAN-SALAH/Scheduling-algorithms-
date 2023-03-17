
import java.util.*;
public class ShortestJobFirst {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Shortest Job First ");
        System.out.println("enter no of process:");
        int n = sc.nextInt();
        int id[] = new int[n];
        int arrival[] = new int[n];
        int brust[] = new int[n];
        int complete[] = new int[n];
        int turnaround[] = new int[n];
        int waiting[] = new int[n];
        int flag[] = new int[n];  // checks process is completed or not
        int st = 0, total = 0;
        float avgwaiting = 0, avgtunaround = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("enter process " + (i + 1) + " arrival time:");
            arrival[i] = sc.nextInt();
            System.out.println("enter process " + (i + 1) + " brust time:");
            brust[i] = sc.nextInt();
            id[i] = i+1;
            flag[i] = 0;
        }
        while(true)
        {
            int c=n, min=999;
            if (total == n)
                break;
            for (int i=0; i<n; i++)
            {

                if ((arrival[i] <= st) && (flag[i] == 0) && (brust[i]<min))
                {
                    min=brust[i];
                    c=i;
                }
            }
            if (c==n)
                st++;
            else
            {
                complete[c]=st+brust[c];
                st+=brust[c];
                turnaround[c]=complete[c]-arrival[c];
                waiting[c]=turnaround[c]-brust[c];
                flag[c]=1;
                total++;
            }
        }
        System.out.println("id  arrival brust  complete turn"+"\t" +"waiting");
        for(int i=0;i<n;i++)
        {
            avgwaiting+= waiting[i];
            avgtunaround+= turnaround[i];
            System.out.println(id[i]+"\t\t"+arrival[i]+"\t\t"+brust[i]+"\t\t"+complete[i]+"\t\t"+turnaround[i]+"\t\t"+waiting[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgtunaround/n));
        System.out.println ("average wt is "+ (float)(avgwaiting/n));
    }
}