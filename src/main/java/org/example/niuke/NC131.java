package org.example.niuke;

import java.util.*;
import java.util.function.Function;

/**
 * @ClassName NC131 数据流中的中位数
 * 输入：
 * [5,2,3,4,1,6,7,0,8]
 *
 * 返回值：
 * "5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
 *
 *
 * @Description TODO
 * @Author ASUS
 * @Date 2024/2/7 14:41
 * @Version 1.0
 */
public class NC131 {
    int count;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        count++;
        if((count & 1) == 0) { //偶数
            //如果大堆顶不为空并且num<大堆顶堆顶元素
            if(!maxHeap.isEmpty() && num< maxHeap.peek()){
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num); // 3 5
        }else {
            //如果小堆顶不为空并且num>小堆顶堆顶元素
            if(!minHeap.isEmpty() && num>minHeap.peek()){
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num); // 4 2
        }
    }

    public Double GetMedian() {
        if(count==0)
            throw new RuntimeException("no available number!");
        double result = 0;
        //总数为奇数时，大顶堆堆顶就是中位数
        if((count&1)==1)
            result=maxHeap.peek();
        else
            result=(minHeap.peek()+maxHeap.peek())/2.0;
        return result;
    }
    class  NC{
        ArrayList<Integer> arrayList = new ArrayList<>();
        public void insert(Integer num){
            arrayList.add(num);
            arrayList.sort((o1,o2)->o1-o2);
        }
        public double getMedian(){
            int size = arrayList.size();
            if((size & 1) ==0){
                return (double) (arrayList.get(size/2-1)+arrayList.get(size/2)) /2;
            }
            return (double) arrayList.get(size / 2);
        }
    }
}
