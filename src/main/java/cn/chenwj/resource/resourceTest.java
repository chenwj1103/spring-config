package cn.chenwj.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * resource测试类
 *
 * @author chen weijie
 * @date 2017-12-19 1:12 AM
 */
public class resourceTest {


    public static void main(String[] args) throws IOException {


        String filePath = "/home/zhuningning/IdeaProjects/masterSpring/chapter4/src/main/resources/resourceConfig/testResource.txt";

        //使用系统文件路径的方式加载文件
        WritableResource resource1 = new PathResource(filePath);
        //使用类路径的方式加载文件
        Resource resource2 = new ClassPathResource("resourceConfig/testResource.txt");

        //使用writableResource接口写文件
        OutputStream outputStream = resource1.getOutputStream();
        outputStream.write("欢迎光临小春论坛444444444444".getBytes());
        outputStream.close();

        //使用resource接口读资源文件
        InputStream ins1 = resource1.getInputStream();
        InputStream ins2 = resource2.getInputStream();


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;

        while ((i = ins1.read()) != -1) {
            byteArrayOutputStream.write(i);
        }


        System.out.println(byteArrayOutputStream.toString());

        System.out.println("file1Name:" + resource1.getFilename());
        System.out.println("file2Name:" + resource2.getFilename());


    }


}
