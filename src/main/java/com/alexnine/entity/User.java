package com.alexnine.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author alexnine
 * Date 2019/5/30 15:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "user")
public class User  extends Model {

    private long id;
    private String username;
    private String password;
    private String role;


}
