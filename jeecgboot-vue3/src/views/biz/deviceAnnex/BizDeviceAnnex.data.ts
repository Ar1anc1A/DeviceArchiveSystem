import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '附件名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '规格型号',
    align:"center",
    dataIndex: 'model'
   },
   {
    title: '安装部位',
    align:"center",
    dataIndex: 'installPosition'
   },
   {
    title: '校验日期',
    align:"center",
    dataIndex: 'checkTime'
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
    label: '附件名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '规格型号',
    field: 'model',
    component: 'Input',
  },
  {
    label: '安装部位',
    field: 'installPosition',
    component: 'Input',
  },
  {
    label: '校验日期',
    field: 'checkTime',
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
  name: {title: '附件名称',order: 0,view: 'text', type: 'string',},
  model: {title: '规格型号',order: 1,view: 'text', type: 'string',},
  installPosition: {title: '安装部位',order: 2,view: 'text', type: 'string',},
  checkTime: {title: '校验日期',order: 3,view: 'datetime', type: 'string',},
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