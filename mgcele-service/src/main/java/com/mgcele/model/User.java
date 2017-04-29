package com.mgcele.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author mgcele on 2017/4/26.
 */
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 3603452407836990742L;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    /**
     * 登陆命
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * 用户密码
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 用户昵称
     */
    @Column(name = "nickame")
    private String nickname;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
