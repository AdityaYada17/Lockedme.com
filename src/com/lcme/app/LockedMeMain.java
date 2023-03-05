package com.lcme.app;

import com.sun.source.tree.SwitchTree;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class LockedMeMain {
    public static void main(String[] args) {
        LockedMeFileOps.init();
        System.out.println(LockedmeConstants.APPLICATION_INFO);
        System.out.println(LockedmeConstants.MAIN_MENU);
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            String option = sc.next();
            sc.nextLine();
            switch (option){
                case "1" : {
                    LockedMeFileOps.retrieveAllFileNamesInRootAsc(LockedMeFileOps.root);
                    break;
                }
                case "2" : {
                    System.out.println(LockedmeConstants.BUSINESS_MENU);
                    if(sc.hasNext()){
                    option = sc.next();
                    switch (option){
                        case "1" : {
                            System.out.println("Adding a file");
                            break;
                        }
                        case "2" : {
                            System.out.println("Deleting a file");
                            break;
                        }
                        case "3" : {
                            System.out.println("Searching for a file");
                            break;
                        }
                        case "4" : {
                            System.out.println("Navigating back to main menu");
                            break;
                        }
                        default : {
                            System.out.println("Invalid Input");
                        }
                    }
                    }
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
