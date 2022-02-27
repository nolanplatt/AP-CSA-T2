package com.nighthawk.csa.data.SQL;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/*
Person is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=5)
    @Email
    private String email;

    /*
    @NonNull: Places this in @RequiredArgsConstructor
    @Size(min=2, max=30): Allows names between 2 and 30 characters long.
     */

    @NonNull
    @Size(min = 7, max = 11, message = "Phone Number (7 chars)")
    private String phonenumber;

    @NonNull
    @Size(min = 1, max = 2, message = "Experience (1 to 2 chars)")
    private String experience;

    @NonNull
//    @Size(min = 4, max = 5, message = "Recruited")
    private Boolean recruited;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    @NonNull
    @Size(min = 2, max = 30, message = "Sport (2 to 30 chars)")
    private String sport;

    @NonNull
    @Size(min = 2, max = 500, message = "Image Link")
    private String image;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    /* Initializer used when setting data from an API */
    public Person(String email, String phonenumber, String experience, Boolean recruited,String name, String sport, String image, Date dob) {
        this.email = email;
        this.phonenumber = phonenumber;
        this.experience = experience;
        this.recruited = recruited;
        this.name = name;
        this.sport = sport;
        this.image = image;
        this.dob = dob;
    }

    /* A custom getter to return age from dob calculation */
    public int getAge() {
        if (this.dob != null) {
            LocalDate birthDay = this.dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return Period.between(birthDay, LocalDate.now()).getYears(); }
        return -1;
    }

}