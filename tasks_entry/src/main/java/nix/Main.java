package nix;

import nix.data.ListOfCities;
import nix.data.ListOfDates;
import nix.data.ListOfNames;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException{

        System.out.println("____________Task 1______________");
        List<String> dates = new ArrayList<>();
        dates.add("2021/11/01");//right
        dates.add("2003:11:01");//wrong
        dates.add("11-01-2021");//right
        dates.add("01/11/2021");//right
        dates.add("2021.11.01");//wrong
        ListOfDates.task(dates);
        System.out.println();

        System.out.println("____________Task 2______________");
        List<String> names = new ArrayList<>();
        names.add("Alina");
        names.add("Inga");
        names.add("Alina");
        names.add("Inga");
        names.add("Alina");
        names.add("Oleg");
        names.add("Dima");
        ListOfNames.task(names);
        System.out.println();

        System.out.println("____________Task 3______________");
        List<String> cities = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("tasks_data/src/main/resources/input.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("tasks_data/src/main/resources/output.txt")));
        int n = Integer.parseInt(reader.readLine());
        int [][] values = new int [n][n];//create array for values
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                values[i][j] = 0; //fill with zeros
            }
        }

        int p;
        for(int i=0; i<n; i++){
            cities.add(reader.readLine());
            p = Integer.parseInt(reader.readLine());
            for(int j=0; j<p; j++){
                StringTokenizer numbers = new StringTokenizer(reader.readLine(), " ");
                values[i][Integer.parseInt(numbers.nextToken())-1] = Integer.parseInt(numbers.nextToken());
            }
        }
        int r = Integer.parseInt(reader.readLine());
        String directions ="";
        for(int i=0; i<r; i++)
            directions+=reader.readLine()+";";

        StringTokenizer direct = new StringTokenizer(directions, ";");
        for(int j=0; j<r; j++){
            StringTokenizer fromTo = new StringTokenizer(direct.nextToken(), " ");
            String temp1 = fromTo.nextToken();int start=0;
            String temp2 = fromTo.nextToken();int end=0;
            for(int i=0; i<cities.size(); i++)
                if (cities.get(i).equals(temp1)) start = i;
            for(int i=0; i<cities.size(); i++)
                if (cities.get(i).equals(temp2)) end = i;

            int result = ListOfCities.task(start, end, values);
            System.out.println(result);
            writer.append(String.valueOf(result)+"\n");
        }
        reader.close();
        writer.close();


    }
}
