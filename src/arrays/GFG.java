package arrays;

import java.util.*;
import java.lang.*;
import java.io.*;
class node{
    int x,y;
    node(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class myComparator implements Comparator <node> {
    public int compare(node a, node b) {
        if (Math.max(a.x, a.y) - Math.min(a.x, a.y) > Math.max(b.x, b.y) - Math.min(b.x, b.y)) return -1;
        return 1;
    }
}
class GFG
{
    public static void main (String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String buff[] = scan.readLine().split(" ");
        int t = Integer.parseInt(buff[0]);
        for(int p=0;p<t;p++){
            buff = scan.readLine().split(" ");
            int n = Integer.parseInt(buff[0]);
            int x = Integer.parseInt(buff[1]);
            int y = Integer.parseInt(buff[2]);
            ArrayList<node> arr = new ArrayList<node>();
            buff = scan.readLine().split(" ");
            String str[] = scan.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr.add(new node(Integer.parseInt(buff[i]),Integer.parseInt(str[i])));
            }
            Collections.sort(arr,new myComparator());
            for(node a:arr) {
                System.out.println(a.x+" "+a.y);
            }
            int ans=0;
            for(int i=0;i<n;i++){
                // System.out.print(((node)arr.get(i)).x+" "+((node)arr.get(i)).y);
                if(((node)arr.get(i)).x==((node)arr.get(i)).y){
                    ans += ((node)arr.get(i)).x;
                }
                else if(((node)arr.get(i)).x>((node)arr.get(i)).y){
                    if(x<=0){
                        // System.out.println("   taken by Y ");
                        ans += ((node)arr.get(i)).y;
                        y--;
                    }
                    else{
                        // System.out.println("   taken by X ");
                        ans += ((node)arr.get(i)).x;
                        x--;
                    }
                }
                else{
                    if(y<=0){
                        // System.out.println("   taken by X ");
                        ans += ((node)arr.get(i)).x;
                        x--;
                    }
                    else{
                        // System.out.println("   taken by Y ");
                        ans += ((node)arr.get(i)).y;
                        y--;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}

/*
5 3 2
717 913 885 149 624
761 880 774 255 877

Output: 3647
*/