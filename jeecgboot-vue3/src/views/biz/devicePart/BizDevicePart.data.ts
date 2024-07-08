import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '装置编号',
    align:"center",
    dataIndex: 'deviceId',
    ifShow: false
   },
   {
    title: '名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '图片路径',
    align:"center",
    dataIndex: 'partPicPath',
    customRender:render.renderImage,
   },
   {
    title: '材质',
    align:"center",
    dataIndex: 'material'
   },
   {
    title: '法兰规格型号',
    align:"center",
    dataIndex: 'flangeModel'
   },
   {
    title: '垫片规格型号',
    align:"center",
    dataIndex: 'gasketModel'
   },
   {
    title: '螺栓规格型号',
    align:"center",
    dataIndex: 'boltModel'
   },
   {
    title: '数量',
    align:"center",
    dataIndex: 'amount'
   },
   {
    title: '执行标准',
    align:"center",
    dataIndex: 'executiveStandard'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'note'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '装置编号',
    field: 'deviceId',
    component: 'Input',
    ifShow: false
  },
  {
    label: '名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '图片路径',
    field: 'partPicPath',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
  },
  {
    label: '材质',
    field: 'material',
    component: 'Input',
  },
  {
    label: '法兰规格型号',
    field: 'flangeModel',
    component: 'Input',
  },
  {
    label: '垫片规格型号',
    field: 'gasketModel',
    component: 'Input',
  },
  {
    label: '螺栓规格型号',
    field: 'boltModel',
    component: 'Input',
  },
  {
    label: '数量',
    field: 'amount',
    component: 'InputNumber',
  },
  {
    label: '执行标准',
    field: 'executiveStandard',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'note',
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
  deviceId: {title: '装置编号',order: 0,view: 'text', type: 'string',},
  name: {title: '名称',order: 1,view: 'text', type: 'string',},
  partPicPath: {title: '图片路径',order: 2,view: 'image', type: 'string',},
  material: {title: '材质',order: 3,view: 'text', type: 'string',},
  flangeModel: {title: '法兰规格型号',order: 4,view: 'text', type: 'string',},
  gasketModel: {title: '垫片规格型号',order: 5,view: 'text', type: 'string',},
  boltModel: {title: '螺栓规格型号',order: 6,view: 'text', type: 'string',},
  amount: {title: '数量',order: 7,view: 'number', type: 'number',},
  executiveStandard: {title: '执行标准',order: 8,view: 'text', type: 'string',},
  note: {title: '备注',order: 9,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}