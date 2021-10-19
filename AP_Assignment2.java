package sem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

interface com{
    void setId(String id);
    void setTime(Date time);
    void setComment(String comment);
    void getDate();
}
interface stu{
    void setId(String id);
    String getId();
}
interface teach{
    String getId();
    void setId(String id);
}

class AssessmentsStudentAssignment{
    private String Question;
    private String Answer;
    private String id;
    private String MaxMarks;
    private String MarksObtained;
    private String status;
    private String Answered;
    private String GradedBy;
    public String getId() {
        return this.id;
    }
    public String getAnswer() {
        return this.Answer;
    }
    public String getQuestion() {
        return this.Question;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAnswer(String answer) {
        this.Answer = answer;
    }
    public void setQuestion(String question) {
        this.Question = question;
    }
    public Boolean checkAnswer(String answer){
        return answer.endsWith(".zip");
    }
    public String getStatus() {
        return this.status;
    }
    public String getMaxMarks() {
        return this.MaxMarks;
    }
    public String getMarksObtained() {
        return this.MarksObtained;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMaxMarks(String maxMarks) {
        this.MaxMarks = maxMarks;
    }
    public void setMarksObtained(String marksObtained) {
        this.MarksObtained = marksObtained;
    }
    public String getAnswered() {
        return this.Answered;
    }
    public void setAnswered(String answered) {
        this.Answered = answered;
    }
    public void setGradedBy(String gradedBy) {
        this.GradedBy = gradedBy;
    }
    public String getGradedBy() {
        return this.GradedBy;
    }
}

class AssessmentsStudentQuestion{
    private String Question;
    private String Answer;
    private String id;
    private String status;
    private String Answered;
    private final String MaxMarks = "1";
    private String marks;
    private String GradedBy;
    public String getId() {
        return this.id;
    }
    public String getAnswer() {
        return this.Answer;
    }
    public String getQuestion() {
        return this.Question;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAnswer(String answer) {
        this.Answer = answer;
    }
    public void setQuestion(String question) {
        this.Question = question;
    }
    public String getMaxMarks() {
        return this.MaxMarks;
    }
    public String getStatus() {
        return this.status;
    }
    public String getMarks() {
        return this.marks;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMarks(String marks) {
        this.marks = marks;
    }
    public void setAnswered(String answered) {
        this.Answered = answered;
    }
    public String getAnswered() {
        return this.Answered;
    }
    public void setGradedBy(String gradedBy) {
        this.GradedBy = gradedBy;
    }
    public String getGradedBy() {
        return this.GradedBy;
    }
}

class AssessmentTeacherQuestion{
    private String QuizQuestion;
    private final String Marks = "1";
    private String id;
    private String Status;
    public void setQuizQuestion(String quizQuestion) {
        this.QuizQuestion = quizQuestion;
    }
    public String getMarks() {
        return this.Marks;
    }
    public String getQuizQuestion() {
        return this.QuizQuestion;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return this.Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
}

class AssessmentTeacherAssignment{
    private String ProblemStatement;
    private String MaxMarks;
    private String Status;
    private String id;
    public void setMaxMarks(String maxMarks) {
        this.MaxMarks = maxMarks;
    }
    public void setProblemStatement(String problemStatement) {
        this.ProblemStatement = problemStatement;
    }
    public String getMaxMarks() {
        return this.MaxMarks;
    }
    public String getProblemStatement() {
        return this.ProblemStatement;
    }
    public String getStatus() {
        return this.Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return this.id;
    }
}

class student implements stu{
    private String id;
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getId() {
        return id;
    }
}

class Comments implements com{
    private String comment;
    private String id;
    private Date Time;
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public void setTime(Date time) {
        this.Time = time;
    }
    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }
    @Override
    public void getDate()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        setTime(localCalendar.getTime());
    }
    public String getId() {
        return this.id;
    }
    public Date getTime() {
        return this.Time;
    }
    public String getComment() {
        return this.comment;
    }
}

class Teacher implements teach{
    private String id;
    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
}

class Slides{
    Scanner sc = new Scanner(System.in);
    private String slideName;
    private int n;
    private String [] slides;
    private Date Time;
    private String id;
    public void setN(int n) {
        this.n = n;
        this.slides = new String[n+1];
    }
    public void setSlideName(String slideName) {
        this.slideName = slideName;
    }
    public void addSlide() {
        for (int i = 0; i < n; i++) {
            int index = i+1;
            System.out.print("Content of slide" + index + " :");
            this.slides[i] = sc.nextLine();
        }
    }
    public String getSlideName() {
        return slideName;
    }
    public String[] getSlides() {
        return this.slides;
    }
    public int getN() {
        return n;
    }
    public void setTime(Date Time) {
        this.Time = Time;
    }
    public Date getTime() {
        return this.Time;
    }
    public void getDate()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        setTime(localCalendar.getTime());
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}

class Videos{
    private String videoTopic;
    private String videoName;
    private Date Time;
    private String id;
    public void setVideoName(String lectureName) {
        this.videoName = lectureName;
    }
    public void setVideoTopic(String lectureTopic) {
        this.videoTopic = lectureTopic;
    }
    public Boolean checkName(String videoName){
        return videoName.endsWith(".mp4");
    }
    public String getVideoName() {
        return videoName;
    }
    public String getVideoTopic() {
        return videoTopic;
    }
    public void setTime(Date currentTime) {
        this.Time = currentTime;
    }
    public Date getTime() {
        return this.Time;
    }
    public void getDate()
    {
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        setTime(localCalendar.getTime());
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}

public class AP_Assignment2 {
    protected ArrayList<String> inst = new ArrayList<>();
    protected ArrayList<String> stu = new ArrayList<>();
    protected ArrayList<Slides> lectureSlides = new ArrayList<>();
    protected ArrayList<Videos> lectureVideos = new ArrayList<>();
    protected ArrayList<Comments> comments = new ArrayList<>();
    protected ArrayList<AssessmentsStudentAssignment> AssignmentAnswers = new ArrayList<>();
    protected ArrayList<AssessmentsStudentQuestion> QuestionAnswers = new ArrayList<>();
    protected ArrayList<AssessmentTeacherAssignment> Assignment = new ArrayList<>();
    protected ArrayList<AssessmentTeacherQuestion> Question = new ArrayList<>();

    protected HashMap<String,ArrayList<AssessmentsStudentAssignment>> AssignmentAnswer = new HashMap<>();
    protected HashMap<String,ArrayList<AssessmentsStudentQuestion>> QuestionAnswer = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AP_Assignment2 m = new AP_Assignment2();
        Scanner sc = new Scanner(System.in);
        m.stu.add("S0");
        m.stu.add("S1");
        m.stu.add("S2");
        m.inst.add("I0");
        m.inst.add("I1");
        while (true) {
            System.out.println("""
                    Welcome to Backpack
                    1. Enter as instructor
                    2. Enter as student
                    3. Exit""");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Instructors: ");
                    for (int i = 0; i < m.inst.size(); i++) {
                        System.out.println(i + "-" + m.inst.get(i));
                    }
                    int ID = sc.nextInt();
                    Teacher t = new Teacher();
                    t.setId(m.inst.get(ID));
                    while(true) {
                        System.out.println("Welcome " + t.getId() + "\n" + """
                                INSTRUCTOR MENU
                                1. Add class material
                                2. Add assessments
                                3. View lecture materials
                                4. View assessments
                                5. Grade assessments
                                6. Close assessment
                                7. View comments
                                8. Add comments
                                9. Logout""");
                        int c = sc.nextInt();
                        if (c == 9) {
                            break;
                        } else {
                            switch (c) {
                                case 1: {
                                    System.out.println("""
                                            1. Add Lecture Slide
                                            2. Add Lecture Video""");
                                    int mat = Integer.parseInt(reader.readLine());
                                    switch (mat) {
                                        case 1: {
                                            System.out.print("Enter topic of slides:");
                                            String slideName = reader.readLine();
                                            System.out.print("Enter number of slides:");
                                            String n = reader.readLine();
                                            Slides s = new Slides();
                                            s.setN(Integer.parseInt(n));
                                            s.setSlideName(slideName);
                                            s.addSlide();
                                            s.getDate();
                                            s.setId(String.valueOf(ID));
                                            m.lectureSlides.add(s);
                                        }
                                        break;
                                        case 2: {
                                            System.out.print("Enter topic of video: ");
                                            String lectureTopic = reader.readLine();
                                            System.out.print("Enter filename of video: ");
                                            String lectureName = reader.readLine();
                                            Videos v = new Videos();
                                            v.setVideoName(lectureName);
                                            v.setVideoTopic(lectureTopic);
                                            if (v.checkName(lectureName)) {
                                                v.setId(String.valueOf(ID));
                                                v.getDate();
                                                m.lectureVideos.add(v);
                                            } else {
                                                System.out.println("wrong format for the video file");
                                            }
                                        }
                                    }
                                }
                                break;
                                case 2: {
                                    System.out.println("""
                                            1. Add Assignment
                                            2. Add Quiz""");
                                    int ch = Integer.parseInt(reader.readLine());
                                    switch (ch) {
                                        case 1: {

                                            AssessmentTeacherAssignment a = new AssessmentTeacherAssignment();
                                            System.out.print("Enter problem statement: ");
                                            String question = reader.readLine();
                                            System.out.print("Enter max marks: ");
                                            String marks = reader.readLine();
                                            a.setMaxMarks(marks);
                                            a.setProblemStatement(question);
                                            a.setStatus("open");
                                            a.setId(String.valueOf(ID));
                                            for (int i = 0; i < m.stu.size(); i++) {
                                                AssessmentsStudentAssignment as = new AssessmentsStudentAssignment();
                                                ArrayList<AssessmentsStudentAssignment> b = new ArrayList<>();
                                                as.setStatus(a.getStatus());
                                                as.setMaxMarks(a.getMaxMarks());
                                                as.setQuestion(a.getProblemStatement());
                                                as.setMarksObtained("unchecked");
                                                as.setAnswered("unanswered");
                                                b.add(as);
                                                m.AssignmentAnswer.put(m.stu.get(i), b);
                                            }
                                            AssessmentsStudentAssignment as = new AssessmentsStudentAssignment();
                                            as.setStatus(a.getStatus());
                                            as.setMaxMarks(a.getMaxMarks());
                                            as.setQuestion(a.getProblemStatement());
                                            as.setMarksObtained("unchecked");
                                            as.setAnswered("unanswered");
                                            m.AssignmentAnswers.add(as);
                                            m.Assignment.add(a);
                                        }
                                        break;
                                        case 2: {
                                            AssessmentTeacherQuestion a = new AssessmentTeacherQuestion();
                                            System.out.print("Enter quiz question: ");
                                            String question = reader.readLine();
                                            a.setQuizQuestion(question);
                                            a.setId(String.valueOf(ID));
                                            a.setStatus("open");
                                            for (int i = 0; i < m.stu.size(); i++) {
                                                AssessmentsStudentQuestion as = new AssessmentsStudentQuestion();
                                                as.setQuestion(a.getQuizQuestion());
                                                as.setStatus(a.getStatus());
                                                as.setAnswered("unanswered");
                                                as.setMarks("unchecked");
                                                ArrayList<AssessmentsStudentQuestion> b = new ArrayList<>();
                                                b.add(as);
                                                m.QuestionAnswer.put(m.stu.get(i), b);
                                            }
                                            AssessmentsStudentQuestion as = new AssessmentsStudentQuestion();
                                            as.setQuestion(a.getQuizQuestion());
                                            as.setStatus(a.getStatus());
                                            as.setAnswered("unanswered");
                                            as.setMarks("unchecked");
                                            m.QuestionAnswers.add(as);
                                            m.Question.add(a);
                                        }
                                    }
                                }
                                break;
                                case 3: {
                                    for (int i = 0; i < m.lectureSlides.size(); i++) {
                                        Slides s = m.lectureSlides.get(i);
                                        System.out.println("Title: " + s.getSlideName());
                                        String[] a = s.getSlides();
                                        for (int j = 0; j < s.getN(); j++) {
                                            System.out.println("Slide " + j + 1 + a[j]);
                                        }
                                        System.out.println("Number of slides: " + s.getN());
                                        System.out.println("Date of upload: " + s.getTime());
                                        System.out.println("Uploaded by: " + s.getId());
                                        System.out.println();
                                    }
                                    for (int i = 0; i < m.lectureVideos.size(); i++) {
                                        Videos v = m.lectureVideos.get(i);
                                        System.out.println("Title of video: " + v.getVideoTopic());
                                        System.out.println("Video file: " + v.getVideoName());
                                        System.out.println("Date of upload: " + v.getTime());
                                        System.out.println("Uploaded by: " + v.getId());
                                        System.out.println();
                                    }
                                }
                                break;
                                case 4: {
                                    for (int i = 0; i < m.Assignment.size(); i++) {
                                        AssessmentTeacherAssignment a = m.Assignment.get(i);
                                        if (a.getStatus().equals("open")) {
                                            System.out.println("ID: " + i + " Assignment: " + a.getProblemStatement() + "Max Marks: " + a.getMaxMarks());
                                            System.out.println("----------------");
                                        }
                                    }
                                    for (int i = 0; i < m.Question.size(); i++) {
                                        AssessmentTeacherQuestion a = m.Question.get(i);
                                        if (a.getStatus().equals("open")) {
                                            int index = i + m.Assignment.size();
                                            System.out.println("ID: " + index + " Question: " + a.getQuizQuestion());
                                            System.out.println("----------------");
                                        }
                                    }
                                }
                                break;
                                case 5: {
                                    System.out.println("List of Assessments:");
                                    for (int i = 0; i < m.Assignment.size(); i++) {
                                        AssessmentTeacherAssignment a = m.Assignment.get(i);
                                        if (a.getStatus().equals("open")) {
                                            System.out.println("ID: " + i + " Assignment: " + a.getProblemStatement() + "Max Marks: " + a.getMaxMarks());
                                            System.out.println("----------------");
                                        }
                                    }
                                    for (int i = 0; i < m.Question.size(); i++) {
                                        AssessmentTeacherQuestion a = m.Question.get(i);
                                        if (a.getStatus().equals("open")) {
                                            int index = i + m.Assignment.size();
                                            System.out.println("ID: " + index + " Question: " + a.getQuizQuestion());
                                            System.out.println("----------------");
                                        }
                                    }
                                    System.out.print("Enter ID of assessment to view submissions: ");
                                    int pos = Integer.parseInt(reader.readLine());
                                    if (pos < m.Assignment.size()) {
                                        for (int i = 0; i < m.stu.size(); i++) {
                                            ArrayList<AssessmentsStudentAssignment> ap = m.AssignmentAnswer.get(m.stu.get(i));
                                            if (ap.get(pos).getAnswered().equals("answered") && m.AssignmentAnswer.get(m.stu.get(i)).get(pos).getMarksObtained().equals("unchecked")) {
                                                System.out.println(i + ". " + m.stu.get(i));
                                            }
                                        }
                                        int s = Integer.parseInt(reader.readLine());
                                        System.out.println("Submission" + m.AssignmentAnswer.get(m.stu.get(s)).get(pos).getAnswer());
                                        System.out.println("-------------------------------");
                                        System.out.println("Max Marks: " + m.AssignmentAnswer.get(m.stu.get(s)).get(pos).getMaxMarks());
                                        System.out.print("Marks scored: ");
                                        m.AssignmentAnswer.get(m.stu.get(s)).get(pos).setMarksObtained(reader.readLine());
                                        m.AssignmentAnswer.get(m.stu.get(s)).get(pos).setGradedBy(t.getId());
                                    } else {
                                        pos = pos - m.Assignment.size();
                                        for (int i = 0; i < m.stu.size(); i++) {
                                            ArrayList<AssessmentsStudentQuestion> ap = m.QuestionAnswer.get(m.stu.get(i));
                                            if (ap.get(pos).getAnswered().equals("answered") && m.QuestionAnswer.get(m.stu.get(i)).get(pos).getMarks().equals("unchecked")) {
                                                System.out.println(i + ". " + m.stu.get(i));
                                            }
                                        }
                                        int s = Integer.parseInt(reader.readLine());
                                        System.out.println("Submission" + m.QuestionAnswer.get(m.stu.get(s)).get(pos).getAnswer());
                                        System.out.println("-------------------------------");
                                        System.out.print("Marks scored: ");
                                        m.QuestionAnswer.get(m.stu.get(s)).get(pos).setMarks(reader.readLine());
                                        m.QuestionAnswer.get(m.stu.get(s)).get(pos).setGradedBy(t.getId());
                                    }
                                }
                                break;
                                case 6: {
                                    System.out.println("List of Open Assignments: ");
                                    for (int i = 0; i < m.Assignment.size(); i++) {
                                        AssessmentTeacherAssignment a = m.Assignment.get(i);
                                        if (a.getStatus().equals("open")) {
                                            System.out.println("ID: " + i + " Assignment: " + a.getProblemStatement() + "Max Marks: " + a.getMaxMarks());
                                            System.out.println("----------------");
                                        }
                                    }
                                    for (int i = 0; i < m.Question.size(); i++) {
                                        AssessmentTeacherQuestion a = m.Question.get(i);
                                        if (a.getStatus().equals("open")) {
                                            int index = i + m.Assignment.size();
                                            System.out.println("ID: " + index + " Question: " + a.getQuizQuestion());
                                            System.out.println("----------------");
                                        }
                                    }
                                    System.out.print("Enter id of assignment to close: ");
                                    int pos = Integer.parseInt(reader.readLine());
                                    if (pos < m.Assignment.size()) {
                                        for (int i = 0; i < m.stu.size(); i++) {
                                            ArrayList<AssessmentsStudentAssignment> ap = m.AssignmentAnswer.get(m.stu.get(i));
                                            ap.get(pos).setStatus("close");
                                        }
                                        m.Assignment.get(pos).setStatus("close");
                                    } else {
                                        int index = pos - m.Assignment.size();
                                        for (int i = 0; i < m.stu.size(); i++) {
                                            ArrayList<AssessmentsStudentQuestion> ap2 = m.QuestionAnswer.get(m.stu.get(i));
                                            ap2.get(pos).setStatus("close");
                                        }
                                        m.Question.get(index).setStatus("close");
                                    }
                                }
                                break;
                                case 7: {
                                    for (int i = 0; i < m.comments.size(); i++) {
                                        Comments c1 = m.comments.get(i);
                                        System.out.println(c1.getComment() + " - " + c1.getId());
                                        System.out.println(c1.getTime());
                                        System.out.println();
                                    }
                                }
                                break;
                                case 8: {
                                    System.out.print("Enter comment: ");
                                    String comment = reader.readLine();
                                    Comments c2 = new Comments();
                                    c2.setComment(comment);
                                    c2.getDate();
                                    c2.setId(t.getId());
                                    m.comments.add(c2);
                                }
                                break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + choice);
                            }
                        }
                        }
                    }
                break;
                case 2: {
                    System.out.println("Students:");
                    for (int i = 0; i < m.stu.size(); i++) {
                        System.out.println(i + "-" + m.stu.get(i));
                    }
                    int ID = sc.nextInt();
                    student s1 = new student();
                    s1.setId(m.stu.get(ID));
                    while(true){
                        System.out.println("Welcome " + s1.getId() + "\n" + """
                                STUDENT MENU
                                1. View lecture materials
                                2. View assessments
                                3. Submit assessment
                                4. View grades
                                5. View comments
                                6. Add comments
                                7. Logout""");
                        int c = sc.nextInt();
                        if(c == 7){
                            break;
                        }
                        else{
                            switch (c){
                                case 1:{
                                    for(int i = 0;i<m.lectureSlides.size();i++){
                                        Slides s = m.lectureSlides.get(i);
                                        System.out.println("Title: " + s.getSlideName());
                                        String [] a = s.getSlides();
                                        for(int j=0;j<s.getN();j++){
                                            System.out.println("Slide " + (j+1) + a[j]);
                                        }
                                        System.out.println("Number of slides: " + s.getN());
                                        System.out.println("Date of upload: " + s.getTime());
                                        System.out.println("Uploaded by: " + s.getId());
                                        System.out.println();
                                    }
                                    for(int i = 0;i<m.lectureVideos.size();i++){
                                        Videos v = m.lectureVideos.get(i);
                                        System.out.println("Title of video: " + v.getVideoTopic());
                                        System.out.println("Video file: " + v.getVideoName());
                                        System.out.println("Date of upload: " + v.getTime());
                                        System.out.println("Uploaded by: " + v.getId());
                                        System.out.println();
                                    }
                                }
                                break;
                                case 2:{
                                    ArrayList<AssessmentsStudentAssignment> ap = m.AssignmentAnswer.get(s1.getId());
                                    if(ap != null) {
                                        for (int i = 0; i < ap.size(); i++) {
                                            AssessmentsStudentAssignment a = ap.get(i);
                                            if (a.getStatus().equals("open") && a.getAnswered().equals("unanswered")) {
                                                System.out.println("ID: " + i + " Assignment: " + a.getQuestion() + "Max Marks: " + a.getMaxMarks());
                                                System.out.println("----------------");
                                            }
                                        }
                                    }
                                    ArrayList<AssessmentsStudentQuestion> ap2 = m.QuestionAnswer.get(s1.getId());
                                    if(ap2 != null) {
                                        for (int i = 0; i < ap2.size(); i++) {
                                            AssessmentsStudentQuestion a = ap2.get(i);
                                            if (a.getStatus().equals("open") && a.getAnswered().equals("unanswered")) {
                                                int index = i + m.Assignment.size();
                                                System.out.println("ID: " + index + " Question: " + a.getQuestion());
                                                System.out.println("----------------");
                                            }
                                        }
                                    }
                                }
                                break;
                                case 3:{
                                    boolean flag1 = false;
                                    boolean flag2 = false;
                                    ArrayList<AssessmentsStudentAssignment> ap = m.AssignmentAnswer.get(s1.getId());
                                    if(ap != null) {
                                        System.out.println("Pending assessments");
                                        for (int i = 0; i < ap.size(); i++) {
                                            AssessmentsStudentAssignment a = ap.get(i);
                                            if (a.getStatus().equals("open") && a.getAnswered().equals("unanswered")) {
                                                flag1 = true;
                                                System.out.println("ID: " + i + " Assignment: " + a.getQuestion() + " Max Marks: " + a.getMaxMarks());
                                                System.out.println("----------------");
                                            }
                                        }
                                    }
                                    ArrayList<AssessmentsStudentQuestion> ap2 = m.QuestionAnswer.get(s1.getId());
                                    if(ap2 != null) {
                                        if(!flag1){
                                            System.out.println("Pending assessments");
                                        }
                                        for(int i = 0;i<ap2.size();i++){
                                            AssessmentsStudentQuestion a = ap2.get(i);
                                            if(a.getStatus().equals("open") && a.getAnswered().equals("unanswered")) {
                                                flag2 = true;
                                                int index = i + m.Assignment.size();
                                                System.out.println("ID: " + index + " Question: " + a.getQuestion());
                                                System.out.println("----------------");
                                            }
                                        }
                                    }
                                    if(!flag1 && !flag2) {
                                        System.out.println("No Assessments Pending");
                                    }
                                    else{
                                        System.out.print("Enter ID of assessment: ");
                                        int pos = sc.nextInt();
                                        if (pos < m.Assignment.size()) {
                                            System.out.print("Enter filename of assignment: ");
                                            String answer = sc.next();
                                            if (ap.get(pos).checkAnswer(answer)) {
                                                ap.get(pos).setId(String.valueOf(ID));
                                                ap.get(pos).setAnswer(answer);
                                                ap.get(pos).setMarksObtained("unchecked");
                                                ap.get(pos).setAnswered("answered");
                                                m.AssignmentAnswer.put(s1.getId(), ap);
                                            }
                                            else {
                                                System.out.println("Wrong file format");
                                            }
                                        }
                                        else {
                                            pos = pos - m.Assignment.size();
                                            System.out.print(ap2.get(pos).getQuestion() + " ");
                                            String Answer = sc.next();
                                            ap2.get(pos).setAnswer(Answer);
                                            ap2.get(pos).setId(String.valueOf(ID));
                                            ap2.get(pos).setMarks("unchecked");
                                            ap2.get(pos).setAnswered("answered");
                                            m.QuestionAnswer.put(s1.getId(), ap2);
                                        }
                                    }
                                }
                                break;
                                case 4:{
                                    System.out.println("Graded submissions");
                                    if(m.AssignmentAnswer.get(s1.getId())!=null) {
                                        for (int i = 0; i < m.AssignmentAnswer.get(s1.getId()).size(); i++) {
                                            if (m.AssignmentAnswer.get(s1.getId()).get(i).getAnswered().equals("answered") && !m.AssignmentAnswer.get(s1.getId()).get(i).getMarksObtained().equals("unchecked")) {
                                                System.out.println("Submission: " + m.AssignmentAnswer.get(s1.getId()).get(i).getAnswer());
                                                System.out.println("Marks Scored: " + m.AssignmentAnswer.get(s1.getId()).get(i).getMarksObtained());
                                                System.out.println("Graded By: " + m.AssignmentAnswer.get(s1.getId()).get(i).getGradedBy());
                                            }
                                        }
                                    }
                                    if(m.QuestionAnswer.get(s1.getId())!=null) {
                                        for (int i = 0; i < m.QuestionAnswer.get(s1.getId()).size(); i++) {
                                            if (m.QuestionAnswer.get(s1.getId()).get(i).getAnswered().equals("answered") && !m.QuestionAnswer.get(s1.getId()).get(i).getMarks().equals("unchecked")) {
                                                System.out.println("Submission: " + m.QuestionAnswer.get(s1.getId()).get(i).getAnswer());
                                                System.out.println("Marks Scored: " + m.QuestionAnswer.get(s1.getId()).get(i).getMarks());
                                                System.out.println("Graded By: " + m.QuestionAnswer.get(s1.getId()).get(i).getGradedBy());
                                            }
                                        }
                                    }
                                    System.out.println("----------------------------");
                                    System.out.println("Ungraded submissions");
                                    if(m.AssignmentAnswer.get(s1.getId())!=null) {
                                        for (int i = 0; i < m.AssignmentAnswer.get(s1.getId()).size(); i++) {
                                            if (m.AssignmentAnswer.get(s1.getId()).get(i).getAnswered().equals("answered") && m.AssignmentAnswer.get(s1.getId()).get(i).getMarksObtained().equals("unchecked")) {
                                                System.out.println("Submission: " + m.AssignmentAnswer.get(s1.getId()).get(i).getAnswer());
                                            }
                                        }
                                    }
                                    if(m.QuestionAnswer.get(s1.getId())!=null) {
                                        for(int i = 0;i<m.QuestionAnswer.get(s1.getId()).size();i++) {
                                            if (m.QuestionAnswer.get(s1.getId()).get(i).getAnswered().equals("answered") && m.QuestionAnswer.get(s1.getId()).get(i).getMarks().equals("unchecked")) {
                                                System.out.println("Submission: " + m.QuestionAnswer.get(s1.getId()).get(i).getAnswer());
                                            }
                                        }
                                    }
                                }
                                break;
                                case 5:{
                                    for(int i = 0;i<m.comments.size();i++){
                                        Comments c1 = m.comments.get(i);
                                        System.out.println(c1.getComment() + " - " + c1.getId());
                                        System.out.println(c1.getTime());
                                        System.out.println();
                                    }
                                }
                                break;
                                case 6:{
                                    System.out.print("Enter comment: ");
                                    String comment = sc.next();
                                    Comments c2 = new Comments();
                                    c2.setComment(comment);
                                    c2.getDate();
                                    c2.setId(s1.getId());
                                    m.comments.add(c2);
                                }
                                break;
                            }
                        }
                        }
                    }
                break;
                case 3:
                    System.exit(0);
            }
        }
    }
}