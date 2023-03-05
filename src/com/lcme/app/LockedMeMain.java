package com.lcme.app;

import com.sun.source.tree.SwitchTree;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class LockedMeMain {
    public static void main(String[] args) {
        LockedMeFileOps.init();
        System.out.println(LockedmeConstants.APPLICATION_INFO);
        Scanner sc = new Scanner(System.in);
        boolean runMainMenu = true;
        while(runMainMenu){
        System.out.println(LockedmeConstants.MAIN_MENU);
        if(sc.hasNext()){
            String option = sc.next();
            sc.nextLine();
            switch (option){
                case "1" : {
                    LockedMeFileOps.retrieveAllFileNamesInRootAsc(LockedMeFileOps.root);
                    break;
                }
                case "2" : {
                    boolean runBusinessmenu = true;
                    while(runBusinessmenu){
                        System.out.println(LockedmeConstants.BUSINESS_MENU);
                        if(sc.hasNext()){
                            option = sc.next();
                            sc.nextLine();
                            switch (option){
                                case "1" : {
                                    System.out.println("Enter file name with relative path");
                                    String fileNameWithRelativePath = sc.next();
                                    System.out.println("Enter file contents");
                                    String fileContent = sc.next();
                                    LockedMeFileOps.addFile(fileNameWithRelativePath,fileContent);
                                    break;
                                }
                                case "2" : {
                                    System.out.println("Enter file name with relative path");
                                    String fileNameWithRelativePath = sc.next();
                                    LockedMeFileOps.deleteFile(fileNameWithRelativePath);
                                    break;
                                }
                                case "3" : {
                                    System.out.println("Enter file name");
                                    String fileName = sc.next();
                                    LockedMeFileOps.searchFile(fileName);
                                    break;
                                }
                                case "4" : {
                                    runBusinessmenu = false;
                                    break;
                                }
                                default : {
                                    System.out.println("Invalid Input");
                                }
                            }
                        }
                    }
                    break;
                }
                case "3": {
                    runMainMenu = false;
                    break;
                }
                default :  {
                    System.out.println("Invalid Input");
                }
            }
        }

        }
        sc.close();
        System.out.println("Closing the application...");
    }
}
