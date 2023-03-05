package com.lcme.app;

import java.io.File;

public class LockedMeFileOps {

    public static final String root = System.getProperty("user.dir")+"\\root";


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

}
