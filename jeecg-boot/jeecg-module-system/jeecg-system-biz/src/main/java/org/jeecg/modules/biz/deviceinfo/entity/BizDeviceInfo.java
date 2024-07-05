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
 * @Description: 设备基础信息
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Data
@TableName("biz_device_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="biz_device_info对象", description="设备基础信息")
public class BizDeviceInfo implements Serializable {
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
	/**设备名称*/
	@Excel(name = "设备名称", width = 15)
    @ApiModelProperty(value = "设备名称")
    private java.lang.String deviceName;
	/**装置编号*/
	@Excel(name = "装置编号", width = 15)
    @ApiModelProperty(value = "装置编号")
    private java.lang.String deviceId;
	/**容器类别*/
	@Excel(name = "容器类别", width = 15)
    @ApiModelProperty(value = "容器类别")
    private java.lang.String containerCategory;
	/**容器图号*/
	@Excel(name = "容器图号", width = 15)
    @ApiModelProperty(value = "容器图号")
    private java.lang.String containerDiagramNumber;
	/**设计单位*/
	@Excel(name = "设计单位", width = 15)
    @ApiModelProperty(value = "设计单位")
    private java.lang.String designCompany;
	/**制造单位*/
	@Excel(name = "制造单位", width = 15)
    @ApiModelProperty(value = "制造单位")
    private java.lang.String manufactureCompany;
	/**制造年月*/
	@Excel(name = "制造年月", width = 15)
    @ApiModelProperty(value = "制造年月")
    private java.lang.String manufactureTime;
	/**出厂编号*/
	@Excel(name = "出厂编号", width = 15)
    @ApiModelProperty(value = "出厂编号")
    private java.lang.String factoryNumber;
	/**安装单位*/
	@Excel(name = "安装单位", width = 15)
    @ApiModelProperty(value = "安装单位")
    private java.lang.String installCompany;
	/**安装年月*/
	@Excel(name = "安装年月", width = 15)
    @ApiModelProperty(value = "安装年月")
    private java.lang.String installTime;
	/**设计使用年限*/
	@Excel(name = "设计使用年限", width = 15)
    @ApiModelProperty(value = "设计使用年限")
    private java.lang.Integer designYear;
	/**主体材质*/
	@Excel(name = "主体材质", width = 15)
    @ApiModelProperty(value = "主体材质")
    private java.lang.String bodyMaterial;
	/**管程材质*/
	@Excel(name = "管程材质", width = 15)
    @ApiModelProperty(value = "管程材质")
    private java.lang.String pipeMaterial;
	/**容器内径*/
	@Excel(name = "容器内径", width = 15)
    @ApiModelProperty(value = "容器内径")
    private java.lang.Integer containerInnerDiameter;
	/**容器壁厚*/
	@Excel(name = "容器壁厚", width = 15)
    @ApiModelProperty(value = "容器壁厚")
    private java.lang.Integer containerWallThickness;
	/**容器长(高)*/
	@Excel(name = "容器长(高)", width = 15)
    @ApiModelProperty(value = "容器长(高)")
    private java.lang.Integer containerLengthHeight;
	/**容器换热面积*/
	@Excel(name = "容器换热面积", width = 15)
    @ApiModelProperty(value = "容器换热面积")
    private java.lang.Integer containerHeatTransferArea;
	/**外壁防腐措施*/
	@Excel(name = "外壁防腐措施", width = 15)
    @ApiModelProperty(value = "外壁防腐措施")
    private java.lang.String exteriorWallAntisepticMeasure;
	/**重量筒体*/
	@Excel(name = "重量筒体", width = 15)
    @ApiModelProperty(value = "重量筒体")
    private java.lang.Integer weightCylinder;
	/**重量内件*/
	@Excel(name = "重量内件", width = 15)
    @ApiModelProperty(value = "重量内件")
    private java.lang.Integer weightInternal;
	/**重量总重*/
	@Excel(name = "重量总重", width = 15)
    @ApiModelProperty(value = "重量总重")
    private java.lang.Integer weightTotal;
	/**设计条件压力*/
	@Excel(name = "设计条件压力", width = 15)
    @ApiModelProperty(value = "设计条件压力")
    private java.lang.Integer designConditionPressure;
	/**设计条件温度*/
	@Excel(name = "设计条件温度", width = 15)
    @ApiModelProperty(value = "设计条件温度")
    private java.lang.Integer designConditionTemperature;
	/**操作条件压力*/
	@Excel(name = "操作条件压力", width = 15)
    @ApiModelProperty(value = "操作条件压力")
    private java.lang.Integer operateConditionPressure;
	/**操作条件温度*/
	@Excel(name = "操作条件温度", width = 15)
    @ApiModelProperty(value = "操作条件温度")
    private java.lang.Integer operateConditionTemperature;
	/**工艺介质*/
	@Excel(name = "工艺介质", width = 15)
    @ApiModelProperty(value = "工艺介质")
    private java.lang.String processMedia;
	/**投入生产年月*/
	@Excel(name = "投入生产年月", width = 15)
    @ApiModelProperty(value = "投入生产年月")
    private java.lang.String productionTime;
	/**检验时间外部*/
	@Excel(name = "检验时间外部", width = 15)
    @ApiModelProperty(value = "检验时间外部")
    private java.lang.String checkTimeExterior;
	/**检验时间内部*/
	@Excel(name = "检验时间内部", width = 15)
    @ApiModelProperty(value = "检验时间内部")
    private java.lang.String checkTimeInterior;
	/**检验时间全面*/
	@Excel(name = "检验时间全面", width = 15)
    @ApiModelProperty(value = "检验时间全面")
    private java.lang.String checkTimeOverall;
	/**安全装置名称*/
	@Excel(name = "安全装置名称", width = 15)
    @ApiModelProperty(value = "安全装置名称")
    private java.lang.String safetyDeviceName;
	/**安全装置规格型号*/
	@Excel(name = "安全装置规格型号", width = 15)
    @ApiModelProperty(value = "安全装置规格型号")
    private java.lang.String safetyDeviceSpecification;
	/**安全装置定压值*/
	@Excel(name = "安全装置定压值", width = 15)
    @ApiModelProperty(value = "安全装置定压值")
    private java.lang.String safetyDeviceConstantValue;
	/**安全装置数量*/
	@Excel(name = "安全装置数量", width = 15)
    @ApiModelProperty(value = "安全装置数量")
    private java.lang.String safetyDeviceQuantity;
	/**内壁防腐措施*/
	@Excel(name = "内壁防腐措施", width = 15)
    @ApiModelProperty(value = "内壁防腐措施")
    private java.lang.String innerAntisepticMeasure;
	/**设备图片路径*/
	@Excel(name = "设备图片路径", width = 15)
    @ApiModelProperty(value = "设备图片路径")
    private java.lang.String devicePicPath;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String deviceNote;
}
