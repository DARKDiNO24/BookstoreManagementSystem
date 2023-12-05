package Author;

public class Author {
    private String AName;
    private String Aemail;

    public Author(String aName, String aemail) {
        AName = aName;
        Aemail = aemail;
    }

    public String getAName() {
        return AName;
    }

    public void setAName(String AName) {
        this.AName = AName;
    }

    public String getAemail() {
        return Aemail;
    }

    public void setAemail(String aemail) {
        Aemail = aemail;
    }

    @Override
    public String toString() {
        return "Author{" +
                "AName='" + AName + '\'' +
                ", Aemail='" + Aemail + '\'' +
                '}';
    }
}
