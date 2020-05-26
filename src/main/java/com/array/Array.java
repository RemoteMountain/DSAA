package com.array;

/**
 * @Description : 数组的基本操作  //描述
 * @Author : Liwang  //作者
 * @Date: 2020-04-29 17:45  //时间
 */
public class Array {

    //int类型数组
    public int data[];
    //数组长度
    private int n;
    //数组中元素个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0; //一开始一个数都没有存所以为0
    }

    public int findByIndex(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    //插入元素:头部插入（index=0），尾部插入
    public boolean insert(int index, int value) {
        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }
        // 如果count还没满，那么就可以插入数据到数组中
        // 位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        // 位置合法
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        //删除数组末尾元素  这段代码不需要也可以
        /*int[] arr = new int[count-1];
        for (int i=0; i<count-1;i++){
            arr[i] = data[i];
        }
        this.data = arr;*/
        --count;
        return true;
    }

    //有序数组去重
    //nums = [0,0,1,1,1,2,2,3,3,4]
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums == null)return 0;
        if(nums.length < 2){
            return nums.length;
        }
        int i = 1;
        while (i<length){
            if (nums[i] == nums[i+1]){
                for (int p = i + 1; p < nums.length; ++p) {
                    nums[p - 1] = nums[p];
                }
                length--;
            }else {
                i++;
            }
        }
        return length+1;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();*/
        int[] nums = {1,2};
        int i = removeDuplicates(nums);
        System.out.println(i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);

        }
        //System.out.println(i);

    }
}
