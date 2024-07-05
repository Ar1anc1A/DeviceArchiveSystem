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
 * @Description: 检验检测
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Data
@TableName("biz_device_check_test")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="biz_device_check_test对象", description="检验检测")
public class BizDeviceCheckTest implements Serializable {
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
	/**检验日期*/
	@Excel(name = "检验日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "检验日期")
    private java.util.Date checkTime;
	/**检验单位*/
	@Excel(name = "检验单位", width = 15)
    @ApiModelProperty(value = "检验单位")
    private java.lang.String checkCompany;
	/**检验类型*/
	@Excel(name = "检验类型", width = 15)
    @ApiModelProperty(value = "检验类型")
    private java.lang.String checkType;
	/**检验报告编号*/
	@Excel(name = "检验报告编号", width = 15)
    @ApiModelProperty(value = "检验报告编号")
    private java.lang.String checkReportNum;
	/**检验描述*/
	@Excel(name = "检验描述", width = 15)
    @ApiModelProperty(value = "检验描述")
    private java.lang.String conclusionDescribe;
	/**整改情况*/
	@Excel(name = "整改情况", width = 15)
    @ApiModelProperty(value = "整改情况")
    private java.lang.String correctStatus;
	/**下次检验日期*/
	@Excel(name = "下次检验日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下次检验日期")
    private java.util.Date nextCheckTime;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String note;
}
