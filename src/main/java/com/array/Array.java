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

    //leetcode26 有序数组去重
    //nums = [0,0,1,1,1,2,2,3,3,4]
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        /*int i = 0, j = 1;
        while (j < length) {
            if (nums[i] == nums[j]) {
                for (int p = i + 1; p < nums.length; ++p) {
                    nums[p - 1] = nums[p];
                }
                length--;
            } else {
                j++;
                i++;
            }
        }
        return length;*/

        //双指针
        int i = 0;
        for (int j = 1; j < length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }

    //leetcode 27 移除元素
    //移除值为给定值的元素
    public static int removeElement(int[] nums, int val) {
        //时间复杂度为 O(n^2),空间复杂度 O(1)
        /*int length = nums.length;
        if (nums == null || length == 0) return 0;

        //获取要删除元素下标，根据下标删除
        int a = 0, b = 1;
        while (b <= length) {
            if (nums[a] == val) {
                for (int i = a+1; i < length; i++) {
                    nums[i-1] = nums[i];
                }
                length--;
            }else {
                a++;
                b++;
            }
        }
        return length;*/

        int length = nums.length;
        if (nums == null || length == 0) return 0;

        //快慢指针，遇到元素与给定相等跳过
        //元素与val相等，跳过，慢指针i 不变
        //不相等，慢慢指针i 处元素赋值为快指针j处元素，慢指针 i+1
        //适用于要删除元素较多
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;


        //时间复杂度 O(n),空间复杂度 O(1)
        //赋值操作次数=要删除元素个数
        //适用于要删除元素较少
        /*int length = nums.length;
        if (nums == null || length == 0) return 0;

        int i = 0;
        while (i < length){
            if (nums[i] == val){
                nums[i] = nums[length-1];
                length--;
            }else {
                i++;
            }
        }
        return length;*/
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - (int) ((value) * Math.random());
        }
        return arr;
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
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        //int i = removeDuplicates(nums);
        //System.out.println("长度: "+i);
        /*for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);

        }*/
        //System.out.println(i);
        int i = removeElement(nums, 2);
        System.out.println("长度: " + i);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }
}
