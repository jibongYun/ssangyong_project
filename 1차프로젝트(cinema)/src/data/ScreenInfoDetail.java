package data;

public class ScreenInfoDetail {

		private String title;
		private String genre;
		private String runningTime;
		private String releaseDate;
		private String endDate;
		private String star;
		private String director;
		private String actor;
		private String scenario;
		
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getRunningTime() {
			return runningTime;
		}
		public void setRunningTime(String runningTime) {
			this.runningTime = runningTime;
		}
		public String getReleaseDate() {
			return releaseDate;
		}
		public void setReleaseDate(String releaseDate) {
			this.releaseDate = releaseDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		public String getStar() {
			return star;
		}
		public void setStar(String star) {
			this.star = star;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String getActor() {
			return actor;
		}
		public void setActor(String actor) {
			this.actor = actor;
		}
		public String getScenario() {
			return scenario;
		}
		public void setScenario(String scenario) {
			this.scenario = scenario;
		}
		
		public ScreenInfoDetail(String title, String genre, String runningTime, String releaseDate, String endDate,
				String star, String director, String actor, String scenario) {
			this.title = title;
			this.genre = genre;
			this.runningTime = runningTime;
			this.releaseDate = releaseDate;
			this.endDate = endDate;
			this.star = star;
			this.director = director;
			this.actor = actor;
			this.scenario = scenario;
		}


}
