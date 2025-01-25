class Participant {
    private static int counter;
    private long contact_no;
    private String name;
    private String branch;
    private String reg_id;
    
    static {
        counter = 1001;
    }
    public Participant (String name, long contact_no, String branch) {
        this.name = name;
        this.contact_no = contact_no;
        this.branch = branch;
        reg_id = "D" + counter;
        counter++;
    }
    public String getName() {
        return name;
    }
    public String getReg_id() {
        return reg_id;
    }
    public String getBranch() {
        return branch;
    }
}

class Tester {
    public static void main(String[] args) {
        
        Participant participant1 = new Participant ("Rohit", 1234567889L, "Computer");
        Participant participant2 = new Participant ("Sayli", 1988612300L, "Mechanical");
        
        Participant[] participants = { participant1, participant2 };

        for (Participant participant : participants) {
            System.out.println("Hi "+participant.getName()+"! Your registration id is "+participant.getReg_id());
            System.out.println("Your branch is "+participant.getBranch());
        }
    }
}
