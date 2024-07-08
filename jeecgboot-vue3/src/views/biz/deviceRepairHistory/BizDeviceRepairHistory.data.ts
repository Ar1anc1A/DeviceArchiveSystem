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
    title: '检修内容',
    align:"center",
    dataIndex: 'repairContent'
   },
   {
    title: '检修时间',
    align:"center",
    dataIndex: 'repairTime'
   },
   {
    title: '负责人',
    align:"center",
    dataIndex: 'principal'
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
    label: '检修内容',
    field: 'repairContent',
    component: 'InputTextArea',
  },
  {
    label: '检修时间',
    field: 'repairTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '负责人',
    field: 'principal',
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
  repairContent: {title: '检修内容',order: 1,view: 'textarea', type: 'string',},
  repairTime: {title: '检修时间',order: 2,view: 'datetime', type: 'string',},
  principal: {title: '负责人',order: 3,view: 'text', type: 'string',},
  note: {title: '备注',order: 4,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}