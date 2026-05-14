package com.test.commandline;

import cn.hutool.core.lang.hash.Hash;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.rowset.internal.Row;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@Component
public class TestEs implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
//        String ss = "/C:/Users/86151/Desktop/噪音器/11111.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ss)));
//        String sss = null;
//        Set<String> set = new HashSet<>();
//        Set<String> ewefwef = new HashSet<>();
//
//        while ((sss = bufferedReader.readLine()) != null) {
//            String[] split = sss.split("\t");
//            System.out.println("UPDATE gc_menu SET name='"+split[1]+"' where id='"+split[0]+"';" );
//        }

//        Pattern compile = compile("^云网采控中心.*");
//
//        System.out.println(compile.matcher("云网采控中心-IDC数通插件-系统文件查看功能-需求说明书-20251215.doc").matches());


//        String feuh="E:/111/2025-12-12/";
//        File file = new File(feuh);
//        File[] files = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                if (finalPathTemplateFileName !=null){
//                    String fileName = pathname.getName();
//                    if (finalPathTemplateFileName.contains("***")){
//                        Pattern compile = compile(finalPathTemplateFileName.startsWith("***") ? "^" + finalPathTemplateFileName.replaceAll("\\*\\*\\*", ".*")+"$" : finalPathTemplateFileName.replaceAll("\\*\\*\\*", ".*")+"$");
//                        return compile.matcher(fileName).matches() && pathname.isFile();
//                    }else{
//                        return finalPathTemplateFileName.equals(fileName);
//                    }
//                }else{
//                    return pathname.isFile();
//                }
//            }
//        });
//        for (File file1 : files) {
//            System.out.println(file1.getAbsolutePath());
//        }


//        String ss="/C:/Users/86151/Desktop/噪音器/2222.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(ss)));
//        String sss=null;
//        Set<String> set = new HashSet<>();
//        Set<String> ewefwef = new HashSet<>();
//
//        while ((sss=bufferedReader.readLine())!=null){
//            sss=sss.replace("缺失标准库相关数据;","");
//            String[] split = sss.split("：");
//            if (split.length==3&&split[1].contains("稽核未通过")){
//                split[1]="XXX";
//            }
//            String aa="";
//            for (String s : split) {
//                aa=aa+s;
//            }
//            if (aa.contains("，")){
//                String[] split1 = aa.split("，");
//                aa=split1[0];
//            }
//            set.add(aa);
//        }
//        ArrayList<String> list = new ArrayList<>(set);
//        Collections.sort(list);
//        for (String s : list) {
//            System.out.println(s);
//        }

        //--------------------------------------------------------------------------------------
//        Boolean aaa=true;
//        while ((sss=bufferedReader.readLine())!=null){
//            if (Objects.equals(sss,"-----------------------")){
//                aaa=false;
//                continue;
//            }
//            if (aaa){
//                set.add(sss);
//            }else{
//                ewefwef.add(sss);
//            }
//
//        }
//        set.removeAll(ewefwef);
//        for (String s : set) {
//            System.out.println(s);
//        }
        //--------------------------------------------------------------------------------------
//        while ((sss=bufferedReader.readLine())!=null){
//            if (!set.add(sss)){
//                System.out.println(sss);
//            }
//        }
        //--------------------------------------------------------------------------------------
//        Boolean aaa=true;
//        while ((sss=bufferedReader.readLine())!=null){
//            if (Objects.equals(sss,"----------------")){
//                aaa=false;
//                continue;
//            }
//            if (aaa){
//                JSONArray jsonArray = JSONArray.parseArray(sss);
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    String neType = jsonObject.getString("NeType");
//                    set.add(neType);
//                }
//            }else{
//                ewefwef.add(sss);
//            }
//        }
//        set.removeAll(ewefwef);
//        for (String s : set) {
//            System.out.println(s);
//        }

        //--------------------------------------------------------------------------------------
//        Boolean aaa=true;
//        while ((sss=bufferedReader.readLine())!=null){
//            if (Objects.equals(sss,"----------------")){
//                aaa=false;
//                continue;
//            }
//            if (aaa){
//                JSONArray jsonArray = JSONArray.parseArray(sss);
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    JSONObject jsonObject = jsonArray.getJSONObject(i);
//                    String neType = jsonObject.getString("Specialty");
//                    set.add(neType);
//                }
//            }else{
//                ewefwef.add(sss);
//            }
//        }
//        set.removeAll(ewefwef);
//        for (String s : set) {
//            System.out.println(s);
//        }
        //--------------------------------------------------------------------------------------

//        Map<String,String> map = new HashMap<>();
//        List<String> sdsdsd=new ArrayList<>();
//        Boolean aaa=true;
//        while ((sss=bufferedReader.readLine())!=null){
//            if (Objects.equals(sss,"-------------")){
//                aaa=false;
//                continue;
//            }
//            if (aaa){
//                String[] split = sss.split("\t");
//                map.put(split[0],split[1]);
//            }else{
//                sdsdsd.add(sss);
//            }
//        }
//        for (String s : sdsdsd) {
//            String s1 = map.get(s);
//            System.out.println(s+"\t"+s1);
//        }
        //--------------------------------------------------------------------------------------
//        Boolean aaa=true;
//        while ((sss = bufferedReader.readLine()) != null) {
//            if (Objects.equals(sss, "-----------------------")) {
//                aaa = false;
//                continue;
//            }
//            if (aaa) {
//                String[] split = sss.split(",");
//                set.removeAll(Arrays.asList(split));
//            } else {
//                ewefwef.add(sss);
//            }
//        }
//        set.removeAll(ewefwef);
//        for (String s : set) {
//            System.out.println(s);
//        }

        //--------------------------------------------------------------------------------------
//        Boolean aaa=true;
//        Map<String,String> map=new HashMap<>();
//        Map<String,String> map1=new HashMap<>();
//        while ((sss = bufferedReader.readLine()) != null) {
//            if (Objects.equals(sss, "-----------------------")) {
//                aaa = false;
//                continue;
//            }
//            String[] split = sss.split("\t");
//            if (aaa) {
//                map.put(split[0],split[1]);
//            } else {
//                map1.put(split[0],split[1]);
//            }
//        }
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            String key = next.getKey();
//            if (map.get(key)==null){
//                System.out.println(key);
//            }
//        }
//        System.out.println("------------------");
//        Iterator<Map.Entry<String, String>> iterator1 = map1.entrySet().iterator();
//        while (iterator1.hasNext()){
//            Map.Entry<String, String> next = iterator1.next();
//            String key = next.getKey();
//            if (map1.get(key)==null){
//                System.out.println(key);
//            }
//        }
//        System.out.println("------------------");
//        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();
//        while (iterator2.hasNext()){
//            Map.Entry<String, String> next = iterator2.next();
//            String s = map1.get(next.getKey());
//            String value = next.getValue();
//            String[] split = value.split(",");
//            ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
//            Collections.sort(strings);
//            String join = String.join(",", strings);
//
//            String[] split1 = s.split(",");
//            ArrayList<String> strings1 = new ArrayList<>(Arrays.asList(split1));
//            Collections.sort(strings1);
//            String join1 = String.join(",", strings1);
//
//            if (!Objects.equals(join,join1)){
//                System.out.println(next.getKey());
//            }
//        }
    }


    // 每个文件包含的行数
    private static final int LINES_PER_FILE = 5000;

    /**
     * 将大文件分割成多个小文件，每个小文件包含指定行数
     */
    private static void splitFile(File inputFile) throws IOException {
        // 获取文件名和路径信息
        String parentDir = inputFile.getParent();
        String fileName = inputFile.getName();
        String baseName;
        String extension = "";

        // 分离文件名和扩展名
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            baseName = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        } else {
            baseName = fileName;
        }

        // 使用缓冲流读取大文件，提高效率
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(inputFile.getAbsolutePath()),
                StandardCharsets.UTF_8)) {

            String line;
            int lineCount = 0;
            int fileNumber = 1;
            BufferedWriter writer = null;

            try {
                while ((line = reader.readLine()) != null) {
                    // 每LINES_PER_FILE行创建一个新文件
                    if (lineCount % LINES_PER_FILE == 0) {
                        // 关闭上一个文件的写入流
                        if (writer != null) {
                            writer.close();
                        }

                        // 创建新的输出文件
                        String outputFileName = baseName + "_part" + fileNumber + extension;
                        String outputFilePath = parentDir != null ?
                                parentDir + File.separator + outputFileName :
                                outputFileName;

                        writer = Files.newBufferedWriter(
                                Paths.get(outputFilePath),
                                StandardCharsets.UTF_8);

                        System.out.println("创建文件: " + outputFilePath);
                        fileNumber++;
                    }

                    // 写入行内容并计数
                    writer.write(line);
                    writer.newLine(); // 保持换行符
                    lineCount++;
                }
            } finally {
                // 确保最后一个文件的写入流被关闭
                if (writer != null) {
                    writer.close();
                }
            }

            System.out.println("总处理行数: " + lineCount);
            System.out.println("生成文件总数: " + (fileNumber - 1));

        }
    }

}