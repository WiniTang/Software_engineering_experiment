package org.test1;

import java.util.Random;
/**
 *
 * @author doudou
 */
public class CArray {
    private int sum,max,min,data[];
    private double average;
    //构造函数
    public CArray(int[] data) {
        this.data = data;
        min=max=data[0];
        sum=0;
        for(int i=0;i<data.length;i++){
            if(data[i]<min)min=data[i];
            if(data[i]>max)max=data[i];
            sum+=data[i];
        }
        average=sum*1.0/data.length;
    }
    public CArray() {
        this.data=new int[10];
        Random ran=new Random();
         ran.setSeed(12345678);
        for(int i=0;i<10;i++)data[i]=ran.nextInt(50);
            min=max=data[0];
            sum=0;
        for(int i=0;i<data.length;i++){
            if(data[i]<min)min=data[i];
            if(data[i]>max)max=data[i];
            sum+=data[i];
        }
        average=sum*1.0/data.length;
    }
    //get set
    public int getSum() {
    return sum;
    }
    public int getMax() {
    return max;
    }
    public int getMin() {
    return min;
    }
    public int[] getData() {
    return data;
    }
    public double getAverage() {
    return average;
    }
    public void setData(int[] data) {
    this.data = data;
    }
    
    public String array2String(int[] arr){
    	 String s="";
    	 for(int i=0;i<10;i++)s+=arr[i]+" ";
    	 return s;
    	 }
    public String array2String(int[] arr,int n){
   	 String s="";
   	 for(int i=0;i<n;i++)s+=arr[i]+" ";
   	 return s;
   	 }
    //排序
    public void sort()
    {
        int i,j,t,len=data.length;
        for(i=0;i<len-1;i++){
            for(j=i+1;j<len;j++){
                if(data[j]<data[i]){
                    t=data[i];data[i]=data[j];data[j]=t;
                }
            }
        }
    }
    public void sort(int len){
        int i,j,t;
        for(i=0;i<len-1;i++){
            for(j=i+1;j<len;j++){
                if(data[j]<data[i]){
                    t=data[i];data[i]=data[j];data[j]=t;
                }
            }
        }
    }
    //插入
    public void insert(int x){
        int i,j,len=data.length;
        for(i=0;i<len;i++){
            if(data[i]>x){
                for(j=len-2;j>=i;j--)data[j+1]=data[j];
                    data[i]=x;break;
                }
            }
        }
    
  //删除
    public int delete(int x){
        int i,j,nDel=0,len=data.length;
        for(i=0;i<len-nDel;i++){
            if(data[i]==x){
                for(j=i;j<len-1;j++)data[j]=data[j+1];
                nDel++;
                i--;
            }
        }
        return len-nDel;
    }
    public void delete(int x,int nDeleted){
        int i,j,nDel=0,len=data.length;
        for(i=0;i<len-nDel;i++){
            if(data[i]==x){
                for(j=i;j<len-1;j++)data[j]=data[j+1];
                nDel++;i--;
            }
        }
        nDeleted=nDel;
    }
    //搜索
    public int search(int x){
        int a,b,k,len=data.length;
        a=0;
        b=len-1;
        while(a<b){
            k=(a+b)/2;
            if(data[k]==x){
                return k;
            }
            else if(x>data[k])a=k+1;
            else b=k;
        }
        return -1;
    }
    //reverse
    public void reverse(){
        int i,t,len=data.length;
        for(i=0;i<len/2;i++){
             t=data[i];
             data[i]=data[len-1-i];
             data[len-1-i]=t;
        }
    }
   
}