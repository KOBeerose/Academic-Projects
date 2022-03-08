import java.util.*;

public class Hire{

    public static void main(String[] args) {

        Scanner in = new Scanner (Systen.in);
        int B,K,i,j,dist;String boxname;
        Point[] boxes;
        Point[] kids;
        // System.out.println(in.nextLine().trim());
        B= Integer.parseInt(in.next().trim());
        boxes = new Point[B];
        for (i=0;i<B;i++) 
            boxes[i]=new Point (in.next(), in.nextInt(), in.nextInt()); 
        K=in.nextInt();
        kids = new Point[K];
        for( i=0;i<K;i++) 
            kids[i]=new Point (in.next(), in.nextInt(), in.nextInt());
        
        //process data & display the results
        for 
    }
}


class Point{
    String name;
    int X;
    int Y;

    public Point (String name, final int X, final int Y){
        this.name = name;
        this.X = X;
        this.Y = Y;
    }
}