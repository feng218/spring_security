package com.yufeng.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/13.
 */
@Data
public class User
{
    public interface SimpleView{}
    public interface DetailView extends SimpleView{}

    @NotNull
    @JsonView(DetailView.class)
    private Integer id;

    @NotBlank(message = "参数username不能为空")
    @JsonView(SimpleView.class)
    private String username;

    @NotBlank(message = "参数password不能为空")
    @JsonView(DetailView.class)
    private String password;

    @JsonView(DetailView.class)
    private Date birthday;
}
