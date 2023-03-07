package com.lcme.app;

import java.io.File;
import java.io.FileWriter;

public class LockedMeFileOps {

    public static final String root = System.getProperty("user.dir")+"\\root";

    private static boolean fnf = true;

    public static void init(){
        File dir = new File(root);
        if(!dir.exists()){
            dir.mkdir();
        }
    }

    public static void retrieveAllFileNamesInRootAsc(String path){
        File rootfolder = new File(path);
        File[] files = rootfolder.listFiles();
        if(files!=null){
            for(File file: files){
                if(file.isDirectory()){
                    retrieveAllFileNamesInRootAsc(file.getAbsolutePath());
                }else {
                    System.out.println(file.getAbsolutePath().substring(root.length()+1));
                }
            }
        }
    }

    public static void addFile(String fileNameWithRelativePath,String fileContent){
        try{
            String absoluteFilePath = root + "\\" + fileNameWithRelativePath;
            File file = new File(absoluteFilePath);
            file.getParentFile().mkdirs();
            if (file.createNewFile()){
                FileWriter writer = new FileWriter(file);
                writer.write(fileContent);
                writer.close();
                System.out.println("File added successfully at relative path " + fileNameWithRelativePath );
            } else{
                System.out.println("File " + fileNameWithRelativePath + " already exists");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileNameWithRelativePath) {
        String absoluteFilePath = root + "\\" + fileNameWithRelativePath;
        File file = new File(absoluteFilePath);
        if(file.delete()){
            System.out.println("File deleted successfully");
        } else {
            System.out.println("File not found. Please check the file name and path");
        }
    }

    public static void searchFile(String fileName,String directoryPath) {
        File rootfolder = new File(directoryPath);
        File[] files = rootfolder.listFiles();
        if(files!=null){
            for(File file: files){
                if(file.isDirectory()){
                    searchFile(fileName,file.getAbsolutePath());
                }else {
                    if(file.getName().equalsIgnoreCase(fileName)){
                        fnf = false;
                        System.out.println("File found at location " + file.getAbsolutePath().substring(root.length()+1));
                    }
                }
            }
        }
    }

    public static void searchFile(String fileName){
        fnf = true;
        searchFile(fileName,root);
        if(fnf){
            System.out.println("File Not found in application root directory or any of its sub directories");
        }
    }
}
