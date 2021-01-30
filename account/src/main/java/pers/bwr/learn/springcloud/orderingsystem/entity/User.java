package pers.bwr.learn.springcloud.orderingsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User extends Account{
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date registerdate;
    private String address;
}
