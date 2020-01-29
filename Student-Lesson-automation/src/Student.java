public class Student {

	private long studentID; // 1701011005 (10 digit)
	private String name; // Yunus Emre
	private String surname; // Alpu
	private String department; // Computer Science
	private Lesson[] lessons;
	private Exam[] exams;

	// ----------
	// getters and setters

	public void setStudentID(long studentID) {
		this.studentID=studentID;
	}
	public long getStudentID() {
		return studentID;
	}

	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setSurname(String surname) {
		this.surname=surname;
	}
	public String getSurname() {
		return surname;
	}

	public void setDepartment(String department) {
		this.department=department;
	}
	public String getDepartment() {
		return department;
	}

	public void setLessons(Lesson[] lessons) {
		this.lessons= lessons;
	}
	public Lesson[] getLessons() {
		return lessons;
	}

	public void setExams(Exam[] exams) {
		this.exams=exams;
	}
	public Exam[] getExams() {
		return exams;
	}

	// ----------
	// methods
	public void lessonsize(int Lsize) { // Lsize : lesson size
		lessons = new Lesson[Lsize];
	}

	public void lstore(int lind){
		lessons[lind] = new Lesson();
	}

	// ----------
	// set Lesson information
	public void setElementid(int lind, String lid) { // lid : lesson id
		lessons[lind].setLessonID(lid);
	}

	public void setElementname(int lind, String lname) { // lname : lesson name
		lessons[lind].setLessonName(lname);
	}

	public void setElementcredit(int lind, int lcredit) { // lcredit : lesson credit
		lessons[lind].setLessonCredit(lcredit);
	}
	public void setElementperiod(int lind, int lperiod) { // lperiod : lesson period
		lessons[lind].setLessonPeriod(lperiod);
	}

	// ----------
	// get Lesson information
	public String getElementid(int lind) { 
		return lessons[lind].getLessonID();
	}
	public String getElementname(int lind) { 
		return lessons[lind].getLessonName();
	}
	public int getElementcredit(int lind) { 
		return lessons[lind].getLessonCredit();
	}
	public int getElementperiod(int lind) { 
		return lessons[lind].getLessonPeriod();
	}
	
	// ----------
	public void examsize(int Esize) {
		exams = new Exam[Esize];
	}
	
	public void estore(int eind) {
		exams[eind] = new Exam();
	}
	
	// ----------
	// set exam information
	public void sExamid(int eind,int eid) { // set Exam id
		exams[eind].setExamID(eid); 
	}
	public void sMyid(int eind,String elid) { // set Lesson id
		exams[eind].setLessonId(elid);
	}
	public void sExamdate(int eind,String edate) { // set Exam date
		exams[eind].setExamDate(edate);
	}
	
	// ----------
	// get exam information
	public int gExamid(int eind) {
		return exams[eind].getExamID();
	}
	public String gLesid(int eind) {
		return exams[eind].getLessonId();
	}
	public String gExamdate(int eind) {
		return exams[eind].getExamDate();
	}
		
}