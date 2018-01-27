package IO;

import java.io.File;
import java.io.IOException;

/**
 * File的学习
 *
 * **/
public class File_01 {

    public static void main(String[] args) throws IOException {
        //function1();
        //function2();
        //function4();
        //function5();
        //function6();
        //function7();
        //function8();
        /*File file = new File("D:\\learning");
        getAllDir(file);*/
        int t =getSum(100);
        System.out.println(t);
    }

    public static void function1(){
        //系统变量分割符 使用与Linux等系统       用途：java的跨平台性
        String separator = File.pathSeparator;
        System.out.println(separator);
        //文件夹分割符    window系统\    注意：java代码中路径需要\\来表示   原因：c:\abc系统无法区分为 "\a" 还是 "\ abc"
        String s = File.separator;
        System.out.println(s);
    }

    /**
     * File的三个构造方法
     *
     * **/
    public static void function2(){

        //构造方法传入文件路径名称
        File file = new File("D:\\ya.docx");
        System.out.println(file);

        //参数传入String => 父路径，String => 子路径
        File file_2 = new File("D:\\","ya.docx");
        System.out.println(file_2);

        File file_3 = new File("D:\\");
        File file_4 =new File(file_3,"ya.docx");
        System.out.println(file_4);
    }

    /**
     * file的常用方法
     *
     * **/
    public static void function3() throws IOException {
        //file 文件的创建(不能创建文件夹) 文件存在时返回false
        File file = new File("D:\\a.txt");
        boolean b = file.createNewFile();
        //System.out.println(b);

        //file 文件夹的创建 => 只能创建单层级文件夹
        File file_1 = new File("D:\\b");
        boolean c = file_1.mkdir();
        //System.out.println(c);

        //File 多层级文件夹的创建/单层创建也可以
        File file_2 = new File("D:\\c\\b\\a");
        boolean d =file_2.mkdirs();
        //System.out.println(d);

        //File 删除方法
        File file_3 = new File("D:\\a.txt");
        boolean e = file_3.delete();
        //System.out.println(e);
    }

    private static void function4(){
        //获取文件名称
        File file = new File("D:\\b\\c.txt");
        //获取路径中最后的文件或者文件夹的名称
        String name = file.getName();
        //System.out.println(name);
        //获取文件的字节大小
        long numBit = file.length();
        System.out.println(numBit);
        //获取文件绝对路径(返回值为String)
        String filePath = file.getAbsolutePath();
        //根据绝对路径获取文件(返回值为File)
        File file_1 = file.getAbsoluteFile();
    }

    private static void function5(){
        //获取文件父路径 => 返回值为String
        File file = new File("D:\\b\\c.txt");
        String parentPath = file.getParent();
        //System.out.println(parentPath);
        //根据路径获取父类 => 返回值为 File
        File file_1 = file.getParentFile();
        System.out.println(file_1);
    }

    private static void function6(){
        //判断文件是否存在
        File file = new File("D:\\b\\c.txt");
        boolean f = file.exists();
        System.out.println(f);
        //判断是否为文件夹
        boolean l = file.isDirectory();
        System.out.println(l);
    }

    public static void function7(){
        //获取文件下的列表 返回值为一个String数组
        File file = new File("D:\\Alipay");
        String[] fileArr = file.list();
        for(String f : fileArr){
            //System.out.println(f);
        }

        //获取文件下的列表 返回值为一个File数组
        File[] fileArrs = file.listFiles();
        for(File file_1 : fileArrs){
            System.out.println(file_1);
        }

        //listroots()获取系统根目录
    }

    public static void function8(){
        //文件过滤器
        //D:\learning\GitHub\JavaEE\src\IO
        File file = new File("D:\\learning\\GitHub\\JavaEE\\src\\IO");
        File[] fi = file.listFiles(new MyFilter());
        for(File f: fi){
            System.out.println(f);
        }
    }

    //递归遍历某个目录下的所有文件/.java文件夹
    public static void getAllDir(File filename){
        File[] files = filename.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                getAllDir(f);
            }else {
                if(f.getName().endsWith(".java")){
                    System.out.println(f);
                }
            }

        }
    }

    //100+99+98
    //递归求和
    public static int getSum(int n){
        if(n==1){
            return n;
        }
        return n+getSum(n-1);
    }
}
