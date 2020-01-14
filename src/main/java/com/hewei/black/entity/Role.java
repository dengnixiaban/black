package com.hewei.black.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.io.Serializable;

/**
 *  实体类
 */
@TableName("hw_role")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String rolename;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
