package com.hewei.black.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.*;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.io.Serializable;

/**
 *  实体类
 */
@TableName("hw_role_menu")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("role_id")
	@ApiModelProperty(value = "")
	private Integer roleId;
	@TableField("menu_id")
	@ApiModelProperty(value = "")
	private Integer menuId;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
