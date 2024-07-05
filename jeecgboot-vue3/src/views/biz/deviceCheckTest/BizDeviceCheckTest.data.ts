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
    dataIndex: 'deviceId'
   },
   {
    title: '检验日期',
    align:"center",
    dataIndex: 'checkTime'
   },
   {
    title: '检验单位',
    align:"center",
    dataIndex: 'checkCompany'
   },
   {
    title: '检验类型',
    align:"center",
    dataIndex: 'checkType'
   },
   {
    title: '检验报告编号',
    align:"center",
    dataIndex: 'checkReportNum'
   },
   {
    title: '检验描述',
    align:"center",
    dataIndex: 'conclusionDescribe'
   },
   {
    title: '整改情况',
    align:"center",
    dataIndex: 'correctStatus'
   },
   {
    title: '下次检验日期',
    align:"center",
    dataIndex: 'nextCheckTime'
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
  },
  {
    label: '检验日期',
    field: 'checkTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '检验单位',
    field: 'checkCompany',
    component: 'Input',
  },
  {
    label: '检验类型',
    field: 'checkType',
    component: 'Input',
  },
  {
    label: '检验报告编号',
    field: 'checkReportNum',
    component: 'Input',
  },
  {
    label: '检验描述',
    field: 'conclusionDescribe',
    component: 'Input',
  },
  {
    label: '整改情况',
    field: 'correctStatus',
    component: 'Input',
  },
  {
    label: '下次检验日期',
    field: 'nextCheckTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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
  checkTime: {title: '检验日期',order: 1,view: 'datetime', type: 'string',},
  checkCompany: {title: '检验单位',order: 2,view: 'text', type: 'string',},
  checkType: {title: '检验类型',order: 3,view: 'text', type: 'string',},
  checkReportNum: {title: '检验报告编号',order: 4,view: 'text', type: 'string',},
  conclusionDescribe: {title: '检验描述',order: 5,view: 'text', type: 'string',},
  correctStatus: {title: '整改情况',order: 6,view: 'text', type: 'string',},
  nextCheckTime: {title: '下次检验日期',order: 7,view: 'datetime', type: 'string',},
  note: {title: '备注',order: 8,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}