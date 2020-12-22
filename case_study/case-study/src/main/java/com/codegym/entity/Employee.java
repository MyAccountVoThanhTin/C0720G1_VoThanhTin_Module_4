package com.codegym.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.regex.Pattern;


@Entity(name = "employee")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column(columnDefinition = "VARCHAR(45)")
    @NotEmpty(message = "Name Not Null !")
    private String employeeName;
    @Column(columnDefinition = "DATE")
    private String employeeBirthday;
    @NotEmpty(message = "Id Not Null !")
    private String employeeIdCard;
    private double emoloyeeSalary;
    @Column(columnDefinition = "VARCHAR(45)")
    @NotEmpty(message = "numberPhone Not Null !")
    private String employeePhone;
    @Column(columnDefinition = "VARCHAR(45)")
    private String employeeEmail;
    @Column(columnDefinition = "VARCHAR(45)")
    private String emoloyeeAddress;
    @ManyToOne
    @JoinColumn(name = "id_position",nullable = false,referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "id_eucation_degree",nullable = false,referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "id_division",nullable = false,referencedColumnName = "id")
    private Division division;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "userName")
    private User user;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contractList;
    public Employee() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmoloyeeSalary() {
        return emoloyeeSalary;
    }

    public void setEmoloyeeSalary(double emoloyeeSalary) {
        this.emoloyeeSalary = emoloyeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmoloyeeAddress() {
        return emoloyeeAddress;
    }

    public void setEmoloyeeAddress(String emoloyeeAddress) {
        this.emoloyeeAddress = emoloyeeAddress;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if(!Pattern.compile("^([A-Z][a-z]+)(\\s[A-Z][a-z0-9]*)*$").matcher(employee.getEmployeeName()).matches()){
            errors.rejectValue("employeeName","name.employee");
        }

        if(!Pattern.compile("\\d{9}").matcher(employee.getEmployeeIdCard()).matches()){
            errors.rejectValue("employeeIdCard","id-card.employee");
        }

        if(!Pattern.compile("(^(090|091)+\\d{7}$)|(^\\(84\\)\\+(90|91)+\\d{7}$)").matcher(employee.getEmployeePhone()).matches()){
            errors.rejectValue("employeePhone","phone.employee");
        }

        if(!Pattern.compile("^\\w{3,}.?\\w+(@\\w{3,8})(.\\w{3,8})+$").matcher(employee.getEmployeeEmail()).matches()){
            errors.rejectValue("employeeEmail","email.employee");
        }


    }
}
