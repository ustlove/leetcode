package org.example.mian;


import java.util.Random;
import java.util.concurrent.*;

public class FolkJoinDemo {
    public static void main(String[] args) {
        long[] generate = generate();
        Task task = new Task(generate,0,generate.length);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Long invoke = pool.invoke(task);
        System.out.println(invoke);
        System.out.println(task.getCount());
    }
    static long [] generate() {
        long[] a = new long[1000];
        for (int i = 0; i <1000; i++) {
            a[i] =random();
        }
        return a;
    }
  static long random(){
        return new Random().nextLong();
  }




static class Task extends RecursiveTask<Long> {
        private static int count = 0;
    long [] array;
    long expected_sum;
    int end;
    int start;
      Task(long [] array,int start,int end){
          this.array = array;
          this.start = start;
          this.end = end;
      }

    @Override
    protected Long compute() {
          count = count + 1;
          int length = end - start;
          if(end-start < 1000){
              for (int i = 0; i < length; i++){
                  expected_sum += array[i];
              }
              return expected_sum;
          }
          int  middle = length / 2;
          Task task1 = new Task(array,start,middle);
          Task task2 = new Task(array,middle,end);
        long r1,r2;
        try {

             r1 = task1.invoke();
             r2 = task2.invoke();
        }   finally {

        }
        return r1+r2;
    }

     int getCount() {
        return count;
    }
}

}
