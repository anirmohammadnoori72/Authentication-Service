package ir.smartpath.authenticationservice.payload.request;

public class UpdateProfileRequest {

    private long id;

    private String token;

    private String name;

    private String family;

    private boolean isMale;

    private String birthDate;

    private String level;

    private String degree;

    private String educationFiled;

    private String sportFiled;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEducationFiled() {
        return educationFiled;
    }

    public void setEducationFiled(String educationFiled) {
        this.educationFiled = educationFiled;
    }

    public String getSportFiled() {
        return sportFiled;
    }

    public void setSportFiled(String sportFiled) {
        this.sportFiled = sportFiled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
