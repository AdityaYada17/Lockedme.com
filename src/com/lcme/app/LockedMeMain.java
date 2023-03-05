package com.lcme.app;

import java.util.Scanner;

public class LockedMeMain {
    public static void main(String[] args) {

        LockedMeFileOps.init();
        System.out.println(LockedmeConstants.APPLICATION_INFO);
        System.out.println(LockedmeConstants.MAIN_MENU);
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            String option = sc.next();
            switch (option){
                case "1" : {
                    LockedMeFileOps.retrieveAllFileNamesInRootAsc(LockedMeFileOps.root);
                    break;
                }
                default :  {
                    System.out.println("Invalid Input");
                }
            }
        }
        sc.close();
    }
}
