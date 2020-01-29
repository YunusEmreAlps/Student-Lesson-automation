public class Lesson {

	private String lessonID; // BIL103
	private String lessonName; // English
	private int lessonCredit; // 3
	private int lessonPeriod; // 1

	// ----------
	// getters and setters

	public void setLessonID(String lessonID) {
		this.lessonID=lessonID;
	}
	public String getLessonID() {
		return lessonID;
	}

	public void setLessonName(String lessonName) {
		this.lessonName=lessonName;
	}
	public String getLessonName() {
		return lessonName;
	}

	public void setLessonCredit(int lessonCredit) {
		this.lessonCredit=lessonCredit;
	}
	public int getLessonCredit() {
		return lessonCredit;
	}

	public void setLessonPeriod(int lessonPeriod) {
		this.lessonPeriod=lessonPeriod;
	}
	public int getLessonPeriod() {
		return lessonPeriod;
	}
}