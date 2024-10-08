package com.ktdsuniversity.edu.hello_spring.member.vo;

public class MemberLoginVO {
    private String email;
    private String password;

    private String ip;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getIp() {
        return ip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
