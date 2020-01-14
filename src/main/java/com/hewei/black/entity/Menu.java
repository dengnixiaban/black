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
@TableName("hw_menu")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	@TableField("parent_id")
	@ApiModelProperty(value = "")
	private String parentId;
	private String name;
	private String url;
	private String perms;
	private Integer type;
	@TableField("order_num")
	@ApiModelProperty(value = "")
	private Integer orderNum;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
