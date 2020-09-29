package com.company;



import jdk.jfr.TransitionTo;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.File;

public class Main {
    public class Transition{
        int to;
        char letter;
        Transition(int to, char letter){
            this.to = to;
            this.letter = letter;
        }
        @Override
        public String toString()
        {
            return "{ "+to+","+letter+" }";
        }
    }
    public ArrayList<Transition>[] automata;
    public void openFile(String filename){
        try{
             readFile(new Scanner(new File(filename)));
        }
        catch (FileNotFoundException e){
            System.out.print("No file with this name: " + filename);
        }
    }
    public void readFile(Scanner sc){
        int a_len = sc.nextInt();
        automata = new ArrayList[a_len];
        for(int i = 0; i<a_len; i++)
            automata[i]=new ArrayList<Transition>();

    }


}