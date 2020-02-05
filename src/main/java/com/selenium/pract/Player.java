package day3;

import java.util.Comparator;

public class Player implements Comparable<Player> {
	String cnt;
	String name;
	int score;
	
	public Player(String cnt, String name, int score ) {
		this.cnt = cnt;
		this.name = name;
		this.score = score;
		
	}

	@Override
	public String toString() {
		return "Player [cnt=" + cnt + ", name=" + name + ", score=" + score + "]" + "\n";
	}

	@Override
	public int compareTo(Player pl) {
		// TODO Auto-generated method stub
		//return (  p2.score - this.score ); // descending order
		return (this.name.compareTo(pl.name));
		
	}
	

}

class scoreComparatorDesc implements Comparator<Player> {

	@Override
	public int compare(Player p1, Player p2) {
		// TODO Auto-generated method stub
		return (p2.score - p1.score);
	}
	
	
}


class NameComparatorDesc implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return (o2.name.compareTo(o1.name));
	}
	
}










