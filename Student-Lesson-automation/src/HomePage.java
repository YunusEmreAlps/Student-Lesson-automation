import java.util.Scanner; // API 

// IMPORTANT -> Student id must be 10 digit and different to another student id.
// IMPORTANT -> Lesson number must be bigger than 0
// IMPORTANT -> Exam number must be bigger than 0

public class HomePage {

	// ----------
	// global variables
	static Scanner scan = new Scanner(System.in);
	static int tot_student; // total student number
	static Student[] student;
	
	// Yunus Emre Alpu 17010011005
	// ----------
	// main function
	public static void main(String[] args) {

		// ----------
		System.out.printf(" - Total Student number : ");
		tot_student=scan.nextInt();
		student_info();
		System.out.println();

		// ----------
		boolean control=false; // exit control

		while(true) {

			switch(menu()) {

			case 1: // list
				list();
				break;

			case 2: // search by student name
				search_stname();
				break;

			case 3: // search by lesson name
				search_lename();
				break;

			case 4: // exit
				control=true;
				break;
			}

			if(control==true) { // exit
				break;
			}
		}
	}

	// ----------
	// menu function
	static int menu() {

		System.out.printf(" - ---------------\n");
		System.out.printf(" - 1.) List all information \n");
		System.out.printf(" - 2.) Search by Student name \n");
		System.out.printf(" - 3.) Search by Lesson name \n");
		System.out.printf(" - 4.) Exit \n");
		System.out.printf(" - ---------------\n");
		System.out.printf(" - Enter choice : ");

		float mn_pro=0; // menu process number

		// ----------
		// choice control
		while(true) {
			mn_pro=scan.nextFloat();

			if((mn_pro==1)||(mn_pro==2)||(mn_pro==3)||(mn_pro==4)) {
				System.out.println();
				break;
			}
			System.out.printf(" - Try again : ");
		}

		return (int)mn_pro; // type casting
	}

	// ----------
	// student assignment function
	static void student_info() { // student information

		student = new Student[tot_student];

		for(int i=0; i<tot_student; i++) {

			System.out.println();
			student[i]=new Student();

			// ----------
			System.out.printf(" - [%d.Student] Enter Student id : ",i+1);
			student[i].setStudentID(stu_idcont(i));
			scan.nextLine();

			// ----------
			System.out.printf(" - [%d.Student] Enter Name : ",i+1);
			student[i].setName(stu_namcont());

			// ----------
			System.out.printf(" - [%d.Student] Enter Surname : ",i+1);
			student[i].setSurname(stu_namcont());

			// ----------
			System.out.printf(" - [%d.Student] Enter Department : ",i+1);
			student[i].setDepartment(stu_namcont());

			// ----------
			System.out.println();
			System.out.printf(" - [%d.Student] Total Lesson number : ",i+1);
			int tot_lesson;
			
			// ----------
			// lesson number
			while(true) {
				tot_lesson=scan.nextInt();
				
				if(tot_lesson>0) { // lesson number control
					break;
				}
				System.out.printf(" - Try Again : ");
			}
			student[i].lessonsize(tot_lesson);
			lesson_info(i,tot_lesson);			
		}

	}

	// ----------
	// lesson assignment function
	static void lesson_info(int ind,int tot_l) { // lesson information

		for(int j=0; j<tot_l; j++) {

			System.out.println(); 
			student[ind].lstore(j);

			// ----------
			System.out.printf(" - [%d.Student] [%d Lesson] Enter Lesson id : ",ind+1,j+1);
			scan.nextLine();
			String l_id = les_idcont(ind , j);
			student[ind].setElementid(j,l_id);

			// ----------
			System.out.printf(" - [%d.Student] [%d Lesson] Enter Lesson name : ",ind+1,j+1);
			student[ind].setElementname(j,stu_namcont());

			// ----------
			System.out.printf(" - [%d.Student] [%d Lesson] Enter Lesson credit : ",ind+1,j+1);
			student[ind].setElementcredit(j,stu_poscont());

			// ----------
			System.out.printf(" - [%d.Student] [%d Lesson] Enter Lesson period : ",ind+1,j+1);
			student[ind].setElementperiod(j,stu_poscont());

		}

		// ----------
		System.out.println();
		System.out.printf(" - [%d.Student] Total Exam number : ",ind+1);
		int tot_exam;
		
		// ----------
		// exam number
		while(true) {
			tot_exam=scan.nextInt();

			if(tot_exam>0 && tot_exam<=tot_l) { // exam number control
				break;
			}
			System.out.printf(" - Try again : ");
		}

		student[ind].examsize(tot_exam);
		exam_info(ind,tot_exam,tot_l);

	}

	// ----------
	// exam assignment function
	static void exam_info(int ind, int tot_e,int tot_l) { // exam information

		for(int m=0; m<tot_e; m++) {

			System.out.println(); 
			student[ind].estore(m);

			// ----------
			System.out.printf(" - [%d.Student] [%d.Exam] Enter Exam id : ",ind+1,m+1);
			student[ind].sExamid(m,stu_poscont());
			scan.nextLine();

			// ----------

			System.out.printf(" - [%d.Student] [%d.Exam] Enter Lesson id : ",ind+1,m+1);
			student[ind].sMyid(m,exa_idcont(ind , m ,tot_l));


			// ----------
			System.out.printf(" - [%d.Student] [%d.Exam] Enter Exam date : ",ind+1,m+1);
			student[ind].sExamdate(m,stu_namcont());

		}

	}

	// ----------
	// student id control 
	static long stu_idcont(int ind) {

		long tmp_id1, tmp_id2; // temp id
		int dig_cnt=1; // digit counter
		boolean id_control=false;

		while(true) {
			dig_cnt=1;

			tmp_id1 = scan.nextLong();

			if(tmp_id1>0) {
				tmp_id2=tmp_id1;

				while(tmp_id2>9) {
					tmp_id2/=10;
					dig_cnt++;
				}

				if(dig_cnt==10) { // 1306040015 (10 digit)

					for(int k=0; k<ind; k++) {
						if(tmp_id1 == student[k].getStudentID()) {
							id_control=false;
							break;
						}
						if(k==ind-1) {
							id_control=true;
						}
					}

					if(ind==0) {
						id_control=true;
					}
				}

			}

			if(id_control==true) {
				break;
			}
			System.out.printf(" - Try Again : ");
		}

		return tmp_id1;
	}

	// ----------
	// student length control
	static String stu_namcont() {

		String tmp_nm;

		while(true) {
			tmp_nm=scan.nextLine();

			if(tmp_nm.length()>0) {
				break;
			}
			System.out.printf(" - Try again : ");
		}


		return tmp_nm;
	}

	// ----------
	// student sign control
	static int stu_poscont() {

		int tmp_num;

		while(true) {
			tmp_num=scan.nextInt();

			if(tmp_num>0) {
				break;
			}
			System.out.printf(" - Try again : ");
		}

		return tmp_num;
	}

	// ----------
	// lesson id control
	static String les_idcont(int indi,int indj) {

		String tmp_id;
		boolean les_control=false;
		while(true) {
			tmp_id=scan.nextLine();
			if(tmp_id.length()>0) {

				if(indj == 0) {
					les_control=true;
				}

				if(indj != 0) {
					for(int k=0; k<indj; k++) {
						if((tmp_id.compareToIgnoreCase(student[indi].getElementid(k))==0)) {
							les_control=false;
							break;
						}
						if(k==(indj-1)) {
							les_control=true;
						}
					}
				}
			}


			if(les_control==true) {
				break;
			}
			System.out.printf(" - Try Again : ");
		}


		return tmp_id;
	}

	// ----------
	// exam id control
	static String exa_idcont(int indi,int ma,int tot_l) {

		String temp_id;
		boolean ex_control=false;
		boolean ex_control2=false;
		
		while(true) {
			temp_id=scan.nextLine();
			ex_control=false;
			ex_control2=false;

			if(temp_id.length()>0) {

				for(int k=0; k<tot_l; k++) {
					if((temp_id.compareToIgnoreCase(student[indi].getElementid(k))==0)) {
						ex_control=true;
						break;
					}
					if(k==(tot_l-1)) {
						ex_control=false;
					}
				}
			}

			if(ex_control==true) {
				for(int a=0; a<ma; a++) {
					if((temp_id.compareToIgnoreCase(student[indi].getElementid(a))==0)) {
						ex_control2=false;
						break;
					}
					if(a==(ma-1)) {
						ex_control2=true;
					}
					
				}
				
				if(ma==0) {
					ex_control2=true;
				}
				
				if(ex_control2==false) {
				System.out.printf(" - You have this lesson in your exam list.\n");
				System.out.printf(" - Try Again : ");
				}
			}
			
			if(ex_control2==true) {
				break;
			}

			if(ex_control==false){
				System.out.printf(" - You have not this lesson.\n");
				System.out.printf(" - Try Again : ");
			}
		
		}

		return 	temp_id;
	}

	// ----------
	// list function
	static void list() {

		for(int i=0; i<tot_student; i++) {

			System.out.printf(" - [%d.Student] : %d  %s %s  %s \n",i+1,student[i].getStudentID(),
					student[i].getName(), student[i].getSurname(), student[i].getDepartment());

			// ----------
			System.out.printf(" - [%d.Student] Lessons : \n\n",i+1);
			for(int j=0; j<student[i].getLessons().length; j++) {
				System.out.printf(" - [%d.Lesson] : %s  %s  %d  %d \n",j+1,student[i].getElementid(j),
						student[i].getElementname(j), student[i].getElementcredit(j), student[i].getElementperiod(j));
			}
			if(student[i].getLessons().length==0) { 
				System.out.printf(" - None \n") ;
			}
			System.out.println();

			// ----------
			System.out.printf(" - [%d.Student] Exams : \n\n",i+1);
			for(int m=0; m<student[i].getExams().length; m++) {
				System.out.printf(" - [%d.Exam] : %d  %s  %s \n",m+1,student[i].gExamid(m),
						student[i].gLesid(m), student[i].gExamdate(m));
			}

			System.out.println();
		}
	}

	// ----------
	// search function
	static void search_stname() {

		int count=0; // counter (Student name)

		// ----------
		System.out.printf(" - Enter Name : ");
		scan.nextLine();
		String name = scan.nextLine();

		for(int i=0; i<tot_student; i++) {

			if(name.compareTo(student[i].getName())==0) {

				System.out.printf(" - [%d.Student] : %d  %s %s  %s \n",i+1,student[i].getStudentID(),
						student[i].getName(), student[i].getSurname(), student[i].getDepartment());

				// ----------
				System.out.printf(" - [%d.Student] Lessons : \n\n",i+1);
				for(int j=0; j<student[i].getLessons().length; j++) {
					System.out.printf(" - [%d.Lesson] : %s  %s  %d  %d \n",j+1,student[i].getElementid(j),
							student[i].getElementname(j), student[i].getElementcredit(j), student[i].getElementperiod(j));
				}
				if(student[i].getLessons().length==0) { 
					System.out.printf(" - None \n") ;
				}
				System.out.println();

				// ----------
				System.out.printf(" - [%d.Student] Exams : \n\n",i+1);
				for(int m=0; m<student[i].getExams().length; m++) {
					System.out.printf(" - [%d.Exam] : %d  %s  %s \n",m+1,student[i].gExamid(m),
							student[i].gLesid(m), student[i].gExamdate(m));
				}

				System.out.println();
				count++;
			}
		}

		if(count==0) {
			System.out.println(" - Search failed.");
		}

	}

	// ----------
	// search function
	static void search_lename() {

		int count=0; // counter (Lesson name)

		// ----------
		System.out.printf(" - Enter Lesson Name : ");
		scan.nextLine();
		String lename = scan.nextLine();

		for(int i=0; i<tot_student; i++) {

			count=0;
			for(int j=0; j<student[i].getExams().length; j++) {

				if(lename.compareTo(student[i].getElementname(j))==0) {

					System.out.printf(" - [%d.Student] : %d  %s %s  %s \n",i+1,student[i].getStudentID(),
							student[i].getName(), student[i].getSurname(), student[i].getDepartment());

					count++;
				}
			}
		}
		if(count==0) {
			System.out.println(" - Search failed.");
		}

	}
}