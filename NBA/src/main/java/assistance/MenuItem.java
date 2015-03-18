package assistance;

public enum MenuItem {
	Home("Home"),
	Team("Team"),
	Player("Player"),
	Ranking("Ranking"),
	Stats("Stats");
	
	private String str;
	
	private MenuItem(String str){
		this.str = str;
	}
	
	public String getStr(){
		return str;
	}
}
