package model;

/**
 * Created by pc on 17-5-11.
 * +----------+-------------+------+-----+---------+----------------+
 | Field    | Type        | Null | Key | Default | Extra          |
 +----------+-------------+------+-----+---------+----------------+
 | id       | int(4)      | NO   | PRI | NULL    | auto_increment |
 | username | varchar(50) | YES  |     | NULL    |                |
 | password | varchar(50) | YES  |     | NULL    |                |
 | sex      | varchar(50) | YES  |     | NULL    |                |
 | question | varchar(50) | YES  |     | NULL    |                |
 | answer   | varchar(50) | YES  |     | NULL    |                |
 | email    | varchar(50) | YES  |     | NULL    |                |
 +----------+-------------+------+-----+---------+----------------+

 */
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String question;
    private String answer;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
