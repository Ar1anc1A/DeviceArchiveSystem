import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '设备名称',
    align:"center",
    dataIndex: 'deviceName'
   },
   {
    title: '装置编号',
    align:"center",
    dataIndex: 'deviceId',
    ifShow: false
   },
   {
    title: '容器类别',
    align:"center",
    dataIndex: 'containerCategory'
   },
   {
    title: '容器图号',
    align:"center",
    dataIndex: 'containerDiagramNumber',
    ifShow: false
   },
   {
    title: '设计单位',
    align:"center",
    dataIndex: 'designCompany',
    ifShow: false
   },
   {
    title: '制造单位',
    align:"center",
    dataIndex: 'manufactureCompany'
   },
   {
    title: '制造年月',
    align:"center",
    dataIndex: 'manufactureTime'
   },
   {
    title: '出厂编号',
    align:"center",
    dataIndex: 'factoryNumber'
   },
   {
    title: '安装单位',
    align:"center",
    dataIndex: 'installCompany'
   },
   {
    title: '安装年月',
    align:"center",
    dataIndex: 'installTime'
   },
   {
    title: '设计使用年限',
    align:"center",
    dataIndex: 'designYear'
   },
   {
    title: '主体材质',
    align:"center",
    dataIndex: 'bodyMaterial'
   },
   {
    title: '管程材质',
    align:"center",
    dataIndex: 'pipeMaterial'
   },
   {
    title: '容器内径',
    align:"center",
    dataIndex: 'containerInnerDiameter'
   },
   {
    title: '容器壁厚',
    align:"center",
    dataIndex: 'containerWallThickness'
   },
   {
    title: '容器长(高)',
    align:"center",
    dataIndex: 'containerLengthHeight'
   },
   {
    title: '容器换热面积',
    align:"center",
    dataIndex: 'containerHeatTransferArea'
   },
   {
    title: '外壁防腐措施',
    align:"center",
    dataIndex: 'exteriorWallAntisepticMeasure'
   },
   {
    title: '重量筒体',
    align:"center",
    dataIndex: 'weightCylinder'
   },
   {
    title: '重量内件',
    align:"center",
    dataIndex: 'weightInternal'
   },
   {
    title: '重量总重',
    align:"center",
    dataIndex: 'weightTotal'
   },
   {
    title: '设计条件压力',
    align:"center",
    dataIndex: 'designConditionPressure'
   },
   {
    title: '设计条件温度',
    align:"center",
    dataIndex: 'designConditionTemperature'
   },
   {
    title: '操作条件压力',
    align:"center",
    dataIndex: 'operateConditionPressure'
   },
   {
    title: '操作条件温度',
    align:"center",
    dataIndex: 'operateConditionTemperature'
   },
   {
    title: '工艺介质',
    align:"center",
    dataIndex: 'processMedia'
   },
   {
    title: '投入生产年月',
    align:"center",
    dataIndex: 'productionTime'
   },
   {
    title: '检验时间外部',
    align:"center",
    dataIndex: 'checkTimeExterior'
   },
   {
    title: '检验时间内部',
    align:"center",
    dataIndex: 'checkTimeInterior'
   },
   {
    title: '检验时间全面',
    align:"center",
    dataIndex: 'checkTimeOverall'
   },
   {
    title: '安全装置名称',
    align:"center",
    dataIndex: 'safetyDeviceName'
   },
   {
    title: '安全装置规格型号',
    align:"center",
    dataIndex: 'safetyDeviceSpecification'
   },
   {
    title: '安全装置定压值',
    align:"center",
    dataIndex: 'safetyDeviceConstantValue'
   },
   {
    title: '安全装置数量',
    align:"center",
    dataIndex: 'safetyDeviceQuantity'
   },
   {
    title: '内壁防腐措施',
    align:"center",
    dataIndex: 'innerAntisepticMeasure'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '设备名称',
    field: 'deviceName',
    component: 'Input',
  },
  {
    label: '装置编号',
    field: 'deviceId',
    component: 'Input',
  },
  {
    label: '容器类别',
    field: 'containerCategory',
    component: 'Input',
  },
  {
    label: '容器图号',
    field: 'containerDiagramNumber',
    component: 'Input',
  },
  {
    label: '设计单位',
    field: 'designCompany',
    component: 'Input',
  },
  {
    label: '制造单位',
    field: 'manufactureCompany',
    component: 'Input',
  },
  {
    label: '制造年月',
    field: 'manufactureTime',
    component: 'Input',
  },
  {
    label: '出厂编号',
    field: 'factoryNumber',
    component: 'Input',
  },
  {
    label: '安装单位',
    field: 'installCompany',
    component: 'Input',
  },
  {
    label: '安装年月',
    field: 'installTime',
    component: 'Input',
  },
  {
    label: '设计使用年限',
    field: 'designYear',
    component: 'InputNumber',
  },
  {
    label: '主体材质',
    field: 'bodyMaterial',
    component: 'Input',
  },
  {
    label: '管程材质',
    field: 'pipeMaterial',
    component: 'Input',
  },
  {
    label: '容器内径',
    field: 'containerInnerDiameter',
    component: 'InputNumber',
  },
  {
    label: '容器壁厚',
    field: 'containerWallThickness',
    component: 'InputNumber',
  },
  {
    label: '容器长(高)',
    field: 'containerLengthHeight',
    component: 'InputNumber',
  },
  {
    label: '容器换热面积',
    field: 'containerHeatTransferArea',
    component: 'InputNumber',
  },
  {
    label: '外壁防腐措施',
    field: 'exteriorWallAntisepticMeasure',
    component: 'Input',
  },
  {
    label: '重量筒体',
    field: 'weightCylinder',
    component: 'InputNumber',
  },
  {
    label: '重量内件',
    field: 'weightInternal',
    component: 'InputNumber',
  },
  {
    label: '重量总重',
    field: 'weightTotal',
    component: 'InputNumber',
  },
  {
    label: '设计条件压力',
    field: 'designConditionPressure',
    component: 'InputNumber',
  },
  {
    label: '设计条件温度',
    field: 'designConditionTemperature',
    component: 'InputNumber',
  },
  {
    label: '操作条件压力',
    field: 'operateConditionPressure',
    component: 'InputNumber',
  },
  {
    label: '操作条件温度',
    field: 'operateConditionTemperature',
    component: 'InputNumber',
  },
  {
    label: '工艺介质',
    field: 'processMedia',
    component: 'Input',
  },
  {
    label: '投入生产年月',
    field: 'productionTime',
    component: 'Input',
  },
  {
    label: '检验时间外部',
    field: 'checkTimeExterior',
    component: 'Input',
  },
  {
    label: '检验时间内部',
    field: 'checkTimeInterior',
    component: 'Input',
  },
  {
    label: '检验时间全面',
    field: 'checkTimeOverall',
    component: 'Input',
  },
  {
    label: '安全装置名称',
    field: 'safetyDeviceName',
    component: 'Input',
  },
  {
    label: '安全装置规格型号',
    field: 'safetyDeviceSpecification',
    component: 'Input',
  },
  {
    label: '安全装置定压值',
    field: 'safetyDeviceConstantValue',
    component: 'Input',
  },
  {
    label: '安全装置数量',
    field: 'safetyDeviceQuantity',
    component: 'Input',
  },
  {
    label: '内壁防腐措施',
    field: 'innerAntisepticMeasure',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  deviceName: {title: '设备名称',order: 0,view: 'text', type: 'string',},
  deviceId: {title: '装置编号',order: 1,view: 'text', type: 'string',},
  containerCategory: {title: '容器类别',order: 2,view: 'text', type: 'string',},
  containerDiagramNumber: {title: '容器图号',order: 3,view: 'text', type: 'string',},
  designCompany: {title: '设计单位',order: 4,view: 'text', type: 'string',},
  manufactureCompany: {title: '制造单位',order: 5,view: 'text', type: 'string',},
  manufactureTime: {title: '制造年月',order: 6,view: 'text', type: 'string',},
  factoryNumber: {title: '出厂编号',order: 7,view: 'text', type: 'string',},
  installCompany: {title: '安装单位',order: 8,view: 'text', type: 'string',},
  installTime: {title: '安装年月',order: 9,view: 'text', type: 'string',},
  designYear: {title: '设计使用年限',order: 10,view: 'number', type: 'number',},
  bodyMaterial: {title: '主体材质',order: 11,view: 'text', type: 'string',},
  pipeMaterial: {title: '管程材质',order: 12,view: 'text', type: 'string',},
  containerInnerDiameter: {title: '容器内径',order: 13,view: 'number', type: 'number',},
  containerWallThickness: {title: '容器壁厚',order: 14,view: 'number', type: 'number',},
  containerLengthHeight: {title: '容器长(高)',order: 15,view: 'number', type: 'number',},
  containerHeatTransferArea: {title: '容器换热面积',order: 16,view: 'number', type: 'number',},
  exteriorWallAntisepticMeasure: {title: '外壁防腐措施',order: 17,view: 'text', type: 'string',},
  weightCylinder: {title: '重量筒体',order: 18,view: 'number', type: 'number',},
  weightInternal: {title: '重量内件',order: 19,view: 'number', type: 'number',},
  weightTotal: {title: '重量总重',order: 20,view: 'number', type: 'number',},
  designConditionPressure: {title: '设计条件压力',order: 21,view: 'number', type: 'number',},
  designConditionTemperature: {title: '设计条件温度',order: 22,view: 'number', type: 'number',},
  operateConditionPressure: {title: '操作条件压力',order: 23,view: 'number', type: 'number',},
  operateConditionTemperature: {title: '操作条件温度',order: 24,view: 'number', type: 'number',},
  processMedia: {title: '工艺介质',order: 25,view: 'text', type: 'string',},
  productionTime: {title: '投入生产年月',order: 26,view: 'text', type: 'string',},
  checkTimeExterior: {title: '检验时间外部',order: 27,view: 'text', type: 'string',},
  checkTimeInterior: {title: '检验时间内部',order: 28,view: 'text', type: 'string',},
  checkTimeOverall: {title: '检验时间全面',order: 29,view: 'text', type: 'string',},
  safetyDeviceName: {title: '安全装置名称',order: 30,view: 'text', type: 'string',},
  safetyDeviceSpecification: {title: '安全装置规格型号',order: 31,view: 'text', type: 'string',},
  safetyDeviceConstantValue: {title: '安全装置定压值',order: 32,view: 'text', type: 'string',},
  safetyDeviceQuantity: {title: '安全装置数量',order: 33,view: 'text', type: 'string',},
  innerAntisepticMeasure: {title: '内壁防腐措施',order: 34,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}