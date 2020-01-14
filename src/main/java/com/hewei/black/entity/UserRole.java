package com.hewei.black.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.io.Serializable;

/**
 *  实体类
 */
@TableName("hw_user_role")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("user_id")
	@ApiModelProperty(value = "")
	private Integer userId;
	@TableField("role_id")
	@ApiModelProperty(value = "")
	private Integer roleId;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
