package assistance;

public enum ViewType {
	Home(""),
	Team("img/team/teamcontent.png"),
	Player(""),
	Ranking(""),
	Stats("");

	private String url;
	
	private ViewType(String str){
		this.url = str;
	}
	
	public String getUrl(){
		return url;
	}
}
