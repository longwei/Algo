package ch3;

import java.util.Stack;

/*
 * 3.4 move n disks from tower 1 to tower 3, with tower 2 as buffer
 * sol: 
 * n = 1, just move it 
 * n = 2, move d1 to buffer, then move d2 to t3, then move d1 to t3
 * n = 3, do n=2, instead, move them to t2, move d3 to t3, then move n-1 to t3
 * 
 * moveDisks(int n, Tower origin, Tower destination, Tower buffer){
 *     if(n <= 0) return;
 *     moveDisks(n-1, origin, buffer, destination);
 *     move(origin, destination);
 *     moveDisks(n-1, buffer, destination, origin);
 * }
 */
public class HanoiTower {


    private Stack<Integer> disks;
    private int index;
    public HanoiTower (int i){
        disks = new Stack<Integer>();
        index  = i;
    }

    public void moveDisks(int n, HanoiTower destination, HanoiTower buffer){
        if(n > 0 ){
            moveDisks(n-1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n-1,destination,this);
        }
    }

    public void add(int d){
       if(!disks.isEmpty() && disks.peek() <= d){
           System.out.println("cant add bigger on top of small ones");
       } else {
           disks.push(d);
       }
    }

    public void moveTop(HanoiTower t){
        int top = disks.pop();
        t.add(top);
    }

    public String toString(){
		return disks.toString();
	}


    public static void main(String[] args) {
        int n = 5;
        HanoiTower[] towers = new HanoiTower[3];
        for(int i= 0; i < 3; ++i){
            towers[i] = new HanoiTower(i);
        }

        for(int i = 5; i > 0 ; i--){
            towers[0].add(i);
        }
        System.out.println(towers[0]);
        towers[0].moveDisks(n, towers[2], towers[1]);
        System.out.println(towers[2]);

    }
}
