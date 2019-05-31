package com.alexnine.entity;

import io.github.biezhi.anima.Model;
import io.github.biezhi.anima.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author alexnine
 * Date 2019/5/30 15:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User  extends Model {

    private long id;
    private String username;
    private String password;
    private String role;


}
