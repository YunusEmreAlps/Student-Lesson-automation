public class Exam {

	private int examID; // 11
	private String lessonId; // BIL103
	private String examDate; // 19/05/2019

	// ----------
	// getters and setters

	public void setExamID(int examID) {
		this.examID=examID;
	}
	public int getExamID() {
		return examID;
	}

	public void setLessonId(String lessonId) {
		this.lessonId=lessonId;
	}
	public String getLessonId() {
		return lessonId;
	}

	public void setExamDate(String examDate) {
		this.examDate=examDate;
	}
	public String getExamDate() {
		return examDate;
	}

}
