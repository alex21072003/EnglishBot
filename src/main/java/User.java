import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String firstName;
    private Integer countBallov;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getCountBallov() {
        System.out.println("Колл.баллов: " + countBallov);
        return countBallov;
    }

    public void setCountBallov(Integer countBallov) {
        this.countBallov = countBallov;
    }
    public void addBall() {
        countBallov += 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", countBallov=" + countBallov +
                ",firstName=" + firstName +
                '}';
    }
}
