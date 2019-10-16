package com.yufeng.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * Created by Administrator on 2019/10/13.
 */
@Data
public class User
{
    public interface SimpleView{}
    public interface DetailView extends SimpleView{}

    private Integer id;

    @JsonView(SimpleView.class)
    private String username;

    @JsonView(DetailView.class)
    private String password;
}
