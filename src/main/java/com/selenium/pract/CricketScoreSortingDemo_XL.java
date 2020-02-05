package day3;

//import day13.CricketScoreComparator;
//import day13.CricketTeam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CricketScoreSortingDemo_XL {
    public static void main(String[] args) throws IOException {

        String[][] datafromxl = utils.DataReaders.getExcelDataUsingPoi("src\\test\\resources\\data\\Cricket_Score_India_Eng_SA.xlsx", "India");
        ArrayList<Player> teamInd = new ArrayList<Player>();
        for (int i = 0; i < datafromxl.length; i++){

            String country = datafromxl[i][0];
            String name = datafromxl[i][1];
            String strscore = datafromxl[i][2];
            int score = Integer.parseInt(strscore);

            Player pl = new Player(country, name, score);
            teamInd.add(pl);
        }
        System.out.println("Indian Team before sorting\n" +teamInd);
        Collections.sort(teamInd); //,new CricketScoreComparator());
        System.out.println("Indian Team After sorting\n" +teamInd);



    }
}