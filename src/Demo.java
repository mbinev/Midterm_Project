import shows.Show;

public class Demo {
	public static void main(String[] args) {
		
		users.User dasdas = new users.User("Nade", 28, "Bulgaria", "nadeto@abv,bg", "simPLe_89");
		Show grim = new Show("Grim");
		dasdas.addShow(grim);
		grim.addSeason(1);
		grim.getSeasons().get(1).addEpisode(1);
		grim.addSeason(1);
		grim.getSeasons().get(1).addEpisode(1);
	}
}
