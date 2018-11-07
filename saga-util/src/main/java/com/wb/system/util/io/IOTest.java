package com.wb.system.util.io;

import java.io.*;

public class IOTest {

    public static void main(String[] args) throws IOException {
//        IOTest ioTest = new IOTest();
//        ioTest.readFileTest();
//        ioTest.writeFileTest();
//        System.out.println("----");
//        char a = ' ';
//        System.out.println((int)a);
//        ioTest.readFromByteArray();
//        int b;
//        try {
//            System.out.println("please Input:");
//            while ((b = System.in.read()) != -1) {
//                System.out.print((char) b);
//            }
//        } catch (IOException e) {
//            System.out.println(e.toString());
//        }

//        readByteFromFile();
//        writeFileTest();

//        randomAccessFileRead();
//        randomAccessFileWrite();
        bufferedReadTest();
    }

    public static void writeFileTest() throws IOException {
        File file = new File("/Users/wubing/work/iofile1");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        fileOutputStream.write("wubing's job.....".getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void readFileTest() throws IOException {
        File file = new File("/Users/wubing/work/iofile");
        FileInputStream fileInputStream = new FileInputStream(file);
        int i = 0;
        byte[] buffer = new byte[1024];
        while ((i = fileInputStream.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, buffer.length));
        }
        fileInputStream.close();
    }

    public void readFromByteArray() throws IOException {
        byte[] a = new byte[]{1,'a',5,'l',0};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a);
        int b = 0;
        while ((b = byteArrayInputStream.read()) != -1) {
            System.out.println(b);
        }
        byteArrayInputStream.close();

        StringReader stringReader = new StringReader("abbbbbdssd");
        System.out.println(stringReader.read());
    }


    public static void readByteFromFile() throws IOException{
        File file= new File( "/Users/wubing/work/iofile");
        byte[] byteArray= new byte[( int) file.length()];
        //因为是用字节流来读媒介，所以对应的是InputStream
        //又因为媒介对象是文件，所以用到子类是FileInputStream
        InputStream is= new FileInputStream( file);
        int size= is.read( byteArray);
        System. out.println( "大小:"+( int) file.length() +";内容:" +new String(byteArray));
        is.close();
    }

    public static void randomAccessFileRead() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile( "/Users/wubing/work/iofile", "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针开始读
        byte[] contents = new byte[1024];
        file.read( contents);
        long pointerEnd = file.getFilePointer();
        System. out.println("sizi:" + file.length() + "pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" + new String(contents));
        file.close();
    }

    public static void randomAccessFileWrite() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile( "/Users/wubing/work/iofile", "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针位置开始写
        file.write( "HELLO WORD.".getBytes());
        long pointerEnd = file.getFilePointer();
        System. out.println( "pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" );
        file.close();
    }

    public static void bufferedReadTest() throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/wubing/work/iofile"));
        byte[] a = new byte[1024];
        while (inputStream.read(a) != -1) {
            System.out.println(new String(a));
        }
    }

    public static void bufferedWriteTest() throws IOException {
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("/Users/wubing/work/iofile"));

    }
}
