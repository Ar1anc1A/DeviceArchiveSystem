package org.jeecg.modules.demo.deviceinfo.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 装置零件
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Data
@TableName("biz_device_part")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="biz_device_part对象", description="装置零件")
public class BizDevicePart implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**装置编号*/
	@Excel(name = "装置编号", width = 15)
    @ApiModelProperty(value = "装置编号")
    private java.lang.String deviceId;
	/**名称*/
	@Excel(name = "名称", width = 15)
    @ApiModelProperty(value = "名称")
    private java.lang.String name;
	/**图片路径*/
	@Excel(name = "图片路径", width = 15)
    @ApiModelProperty(value = "图片路径")
    private java.lang.String partPicPath;
	/**材质*/
	@Excel(name = "材质", width = 15)
    @ApiModelProperty(value = "材质")
    private java.lang.String material;
	/**法兰规格型号*/
	@Excel(name = "法兰规格型号", width = 15)
    @ApiModelProperty(value = "法兰规格型号")
    private java.lang.String flangeModel;
	/**垫片规格型号*/
	@Excel(name = "垫片规格型号", width = 15)
    @ApiModelProperty(value = "垫片规格型号")
    private java.lang.String gasketModel;
	/**螺栓规格型号*/
	@Excel(name = "螺栓规格型号", width = 15)
    @ApiModelProperty(value = "螺栓规格型号")
    private java.lang.String boltModel;
	/**数量*/
	@Excel(name = "数量", width = 15)
    @ApiModelProperty(value = "数量")
    private java.lang.Integer amount;
	/**执行标准*/
	@Excel(name = "执行标准", width = 15)
    @ApiModelProperty(value = "执行标准")
    private java.lang.String executiveStandard;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String note;
}
