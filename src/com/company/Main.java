package com.company;



import jdk.jfr.TransitionTo;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.File;

public class Main {

    public static class Transition{
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
    public boolean[] isTerminate;

    public void openFile(String filename){
        try{
             readFile(new Scanner(new File(filename)));
        }
        catch (FileNotFoundException e){
            System.out.print("No file with this name: " + filename);
        }
    }

    public String reservedWord()
    {
        System.out.print("Enter reserved word>>");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    };

    public void readFile(Scanner sc){
        String r_word = reservedWord();
        int A_len = sc.nextInt();
        isTerminate = new boolean[A_len];
        automata = new ArrayList[A_len];
        for(int i = 0; i<A_len; i++)
            automata[i]=new ArrayList<Transition>();

        int S_len = sc.nextInt();
        while (S_len-- > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            char edge = sc.next().charAt(0);
            Transition transition = new Transition(to, edge);
            automata[from].add(transition);
        }

        int t = sc.nextInt();
        while(t-- > 0)
        {
            int state = sc.nextInt();
            isTerminate[state]= true;
        }

        int input_data = sc.nextInt();
        while (input_data-- > 0)
        {
            String word = r_word + sc.next();
        }
    }

    public boolean dfs(int v, String currstr, String word, int parent)
    {
        boolean ans = false;
        for (Transition x: automata[v])
        {
            if (x.letter==word.charAt(currstr.length()))
                ans |= dfs(x.to, currstr+x.letter, word, v);
        }
        System.out.print("");
        return ans;
    }
}