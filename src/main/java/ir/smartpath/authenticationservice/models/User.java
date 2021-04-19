package ir.smartpath.authenticationservice.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "number")

        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 20)
    private String username;

    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 120)
    private String password;

    private String name;

    private String family;

    private boolean isMale;

    private String birthDate;

    private String level;

    private String degree;

    private String educationFiled;

    private String sportFiled;

    private int otp;

    @NotBlank
    private String number;

    private boolean verifiedNumber;

    private boolean filledProfile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }


    public User(@NotBlank String number, int otp) {
        this.otp = otp;
        this.number = number;
        this.verifiedNumber = false;
        this.filledProfile = false;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
       return String.valueOf(getOtp());
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

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

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isVerifiedNumber() {
        return verifiedNumber;
    }

    public void setVerifiedNumber(boolean verifiedNumber) {
        this.verifiedNumber = verifiedNumber;
    }

    public boolean isFilledProfile() {
        return filledProfile;
    }

    public void setFilledProfile(boolean filledProfile) {
        this.filledProfile = filledProfile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", isMale=" + isMale +
                ", birthDate='" + birthDate + '\'' +
                ", level='" + level + '\'' +
                ", degree='" + degree + '\'' +
                ", educationFiled='" + educationFiled + '\'' +
                ", sportFiled='" + sportFiled + '\'' +
                ", number='" + number + '\'' +
                ", verifiedNumber=" + verifiedNumber +
                ", filledProfile=" + filledProfile +
                '}';
    }
}
