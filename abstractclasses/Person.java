package abstractclasses;

public abstract class Person {
    private String id;
    private String name;
    private String college;

    // Constructor
    public Person(String id, String name, String college) {
        this.id = id;
        this.name = name;
        this.college = college;
    }

     public Person(String name) {
       this.name = name;
     }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCollege() {
        return college;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }



    public void setCollege(String college) {
        this.college = college;
    }

    // Optional: display person information
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", College: " + college);
    }

    // Abstract method (forces subclasses to implement)
    public abstract void roleDescription();
}


