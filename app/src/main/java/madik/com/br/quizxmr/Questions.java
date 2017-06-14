package madik.com.br.quizxmr;

/**
 * Created by Marcelo on 07/06/2017.
 */
public class Questions {


    int id=1;
    String question="";
    String r1="";
    String r2="";
    String r3="";
    String r4="";
    String r5="";
    String r6="";

    boolean r1bool=false;
    boolean r2bool=false;
    boolean r3bool=false;
    boolean r4bool=false;
    boolean r5bool=false;
    boolean r6bool=false;

    //para mysql
    int r1boolean=0;
    int r2boolean=0;
    int r3boolean=0;
    int r4boolean=0;
    int r5boolean=0;
    int r6boolean=0;


    public int getR1boolean() {
        return r1boolean;
    }

    public void setR1boolean(int r1boolean) {
        this.r1boolean = r1boolean;
    }

    public int getR2boolean() {
        return r2boolean;
    }

    public void setR2boolean(int r2boolean) {
        this.r2boolean = r2boolean;
    }

    public int getR3boolean() {
        return r3boolean;
    }

    public void setR3boolean(int r3boolean) {
        this.r3boolean = r3boolean;
    }

    public int getR4boolean() {
        return r4boolean;
    }

    public void setR4boolean(int r4boolean) {
        this.r4boolean = r4boolean;
    }

    public int getR5boolean() {
        return r5boolean;
    }

    public void setR5boolean(int r5boolean) {
        this.r5boolean = r5boolean;
    }

    public int getR6boolean() {
        return r6boolean;
    }

    public void setR6boolean(int r6boolean) {
        this.r6boolean = r6boolean;
    }



    //para mysql

    public Questions(

            String question, String r1, String r2, String r3, String r4, String r5, String r6,
            int r1boolean, int r2boolean, int r3boolean, int r4boolean, int r5boolean, int r6boolean) {

        this.question=question;
        this.r1 = r1;
        this.r2=r2;
        this.r3=r3;
        this.r4=r4;
        this.r5=r5;
        this.r6=r6;
        this.r1boolean=r1boolean;
        this.r2boolean=r2boolean;
        this.r3boolean=r3boolean;
        this.r4boolean=r4boolean;
        this.r5boolean=r5boolean;
        this.r6boolean=r6boolean;
    }

    public Questions(
            String question, String r1, String r2, String r3, String r4, String r5, String r6,
            boolean r1bool, boolean r2bool, boolean r3bool, boolean r4bool, boolean r5bool, boolean r6bool) {

        this.question=question;
        this.r1 = r1;
        this.r2=r2;
        this.r3=r3;
        this.r4=r4;
        this.r5=r5;
        this.r6=r6;
        this.r1bool=r1bool;
        this.r2bool=r2bool;
        this.r3bool=r3bool;
        this.r4bool=r4bool;
        this.r5bool=r5bool;
        this.r6bool=r6bool;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getR1() {
        return r1;
    }
    public void setR1(String r1) {
        this.r1 = r1;
    }
    public String getR2() {
        return r2;
    }
    public void setR2(String r2) {
        this.r2 = r2;
    }
    public String getR3() {
        return r3;
    }
    public void setR3(String r3) {
        this.r3 = r3;
    }
    public String getR4() {
        return r4;
    }
    public void setR4(String r4) {
        this.r4 = r4;
    }
    public String getR5() {
        return r5;
    }
    public void setR5(String r5) {
        this.r5 = r5;
    }
    public String getR6() {
        return r6;
    }
    public void setR6(String r6) {
        this.r6 = r6;
    }

    public boolean isR1bool() {
        return r1bool;
    }
    public void setR1bool(boolean r1bool) {
        this.r1bool = r1bool;
    }
    public boolean isR2bool() {
        return r2bool;
    }
    public void setR2bool(boolean r2bool) {
        this.r2bool = r2bool;
    }
    public boolean isR3bool() {
        return r3bool;
    }
    public void setR3bool(boolean r3bool) {
        this.r3bool = r3bool;
    }
    public boolean isR4bool() {
        return r4bool;
    }
    public void setR4bool(boolean r4bool) {
        this.r4bool = r4bool;
    }
    public boolean isR5bool() {
        return r5bool;
    }
    public void setR5bool(boolean r5bool) {
        this.r5bool = r5bool;
    }
    public boolean isR6bool() {
        return r6bool;
    }
    public void setR6bool(boolean r6bool) {
        this.r6bool = r6bool;
    }

}
