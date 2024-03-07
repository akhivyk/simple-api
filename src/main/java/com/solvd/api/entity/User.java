package com.solvd.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.lang3.RandomStringUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public User(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public static User generateUser() {
        return new User(RandomStringUtils.randomAlphabetic(5),
                RandomStringUtils.randomAlphabetic(4) + "@mail.ex",
                "male",
                "inactive");
    }
}
