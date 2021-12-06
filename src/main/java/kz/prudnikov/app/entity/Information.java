package kz.prudnikov.app.entity;
   ///authorities
public class Information {

    String username;
    String authority;
    String name;
    String surname;
    String email;
    int age;
    int balance;
    int id;
    static int number;

    public Information() {
    }

    public Information(String username, String authority, String name, String surname, String email, int age, int balance) {
        this.username = username;
        this.authority = authority;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.age = age;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public static int getNumber() {

           return number;
       }

       public void setNumber(int number) {
           this.number = number;
       }
   }
