<template>
  <div>
    <!--引用表格-->
   <BasicTable @register="registerTable" :rowSelection="rowSelection">
     <!--插槽:table标题-->
      <template #tableTitle>
          <a-button type="primary" @click="handleAdd" preIcon="ant-design:plus-outlined"> 新增</a-button>
          <!-- <a-button  type="primary" preIcon="ant-design:export-outlined" @click="onExportXls"> 导出</a-button>
          <j-upload-button  type="primary" preIcon="ant-design:import-outlined" @click="onImportXls">导入</j-upload-button> -->
          <a-dropdown v-if="selectedRowKeys.length > 0">
              <template #overlay>
                <a-menu>
                  <a-menu-item key="1" @click="batchHandleDelete">
                    <Icon icon="ant-design:delete-outlined"></Icon>
                    删除
                  </a-menu-item>
                </a-menu>
              </template>
              <a-button>批量操作
                <Icon icon="mdi:chevron-down"></Icon>
              </a-button>
        </a-dropdown>
        <!-- 高级查询 -->
        <!--<super-query :config="superQueryConfig" @search="handleSuperQuery" />-->
      </template>
       <!--操作栏-->
      <template #action="{ record }">
        <TableAction :actions="getTableAction(record)"/>
      </template>
      <!--字段回显插槽-->
      <template v-slot:bodyCell="{ column, record, index, text }">
      </template>
    </BasicTable>
    <!-- 表单区域 -->
    <BizDeviceInfoModal @register="registerModal" @success="handleSuccess"></BizDeviceInfoModal>
    <AnnexDrawer @register="registerDeviceAnnex"/>
    <CheckTestDrawer @register="registerDeviceCheckTest"/>
    <DevicePartDrawer @register="registerDevicePart"/>
    <DeviceReformSituationDrawer @register="registerDeviceReformSituation"/>
    <DeviceRepairHistoryDrawer @register="registerDeviceRepairHistory"/>
  </div>
</template>

<script lang="ts" name="deviceinfo-bizDeviceInfo" setup>
  import {ref, reactive, computed, unref, watch} from 'vue';
  import {BasicTable, useTable, TableAction} from '/@/components/Table';
  import {useModal} from '/@/components/Modal';
  import { useDrawer } from '/@/components/Drawer';
  import { useListPage } from '/@/hooks/system/useListPage'
  import BizDeviceInfoModal from './components/BizDeviceInfoModal.vue'
  import {columns, searchFormSchema, superQuerySchema} from './BizDeviceInfo.data';
  import {list, deleteOne, batchDelete, getImportUrl,getExportUrl} from './BizDeviceInfo.api';
  import { downloadFile } from '/@/utils/common/renderUtils';
  import { useUserStore } from '/@/store/modules/user';
  import AnnexDrawer from '/@/views/biz/deviceInfo/drawer/AnnexDrawer.vue';
  import CheckTestDrawer from '/@/views/biz/deviceInfo/drawer/CheckTestDrawer.vue';
  import DevicePartDrawer from '/@/views/biz/deviceInfo/drawer/DevicePartDrawer.vue';
  import DeviceReformSituationDrawer from '/@/views/biz/deviceInfo/drawer/DeviceReformSituationDrawer.vue';
  import DeviceRepairHistoryDrawer from '/@/views/biz/deviceInfo/drawer/DeviceRepairHistoryDrawer.vue';
  const queryParam = reactive<any>({});
  const checkedKeys = ref<Array<string | number>>([]);
  const userStore = useUserStore();
  //注册model
  /** 编辑装置基础信息 */
  //注册drawer
  //设备附件
  const [registerDeviceAnnex, { openDrawer: openDeviceAnnexDrawer, setDrawerProps: setDeviceAnnexDrawerProps }] = useDrawer();
  //检验检测
  const [registerDeviceCheckTest, { openDrawer: openDeviceCheckTestDrawer, setDrawerProps: setDeviceCheckTestDrawerProps }] = useDrawer();
  //设备零件
  const [registerDevicePart, { openDrawer: openDevicePartDrawer, setDrawerProps: setDevicePartDrawerProps }] = useDrawer();
  //设备改造情况
  const [registerDeviceReformSituation, { openDrawer: openDeviceReformSituationDrawer, setDrawerProps: setDeviceReformSituationDrawerProps }] = useDrawer();
  //设备检修履历
  const [registerDeviceRepairHistory, { openDrawer: openDeviceRepairHistoryDrawer, setDrawerProps: setDeviceRepairHistoryDrawerProps }] = useDrawer();
  const [registerModal, {openModal}] = useModal();
  const props = defineProps({
    data: { require: true, type: Object },
  });
  // 当前选中的部门ID，可能会为空，代表未选择部门
  const departId = computed(() => props.data?.id);

  watch(
    () => props.data,
    () => reload()
  );

  //注册table数据
  const { prefixCls,tableContext,onExportXls,onImportXls } = useListPage({
      tableProps:{
           title: '设备基础信息',
           api: list,
           columns,
           canResize:false,
           showTableSetting: false,
           formConfig: {
              //labelWidth: 120,
              schemas: searchFormSchema,
              autoSubmitOnEnter:false,
              showAdvancedButton:false,
              showSubmitButton:false,
              fieldMapToNumber: [
              ],
              fieldMapToTime: [
              ],
            },
           actionColumn: {
               width: 400,
               fixed:'right'
            },
            beforeFetch: (params) => {
              params.deviceId = departId.value;
              return Object.assign(params, queryParam);
            },
      },
       exportConfig: {
            name:"设备基础信息",
            url: getExportUrl,
            params: queryParam,
          },
          importConfig: {
            url: getImportUrl,
            success: handleSuccess
          },
  })

  const [registerTable, {reload},{ rowSelection, selectedRowKeys }] = tableContext

  /**
   * 打开设备附件抽屉
   */
   function handleOpenDeviceAnnexDrawer(record: Recordable) {
    // checkDepartProgramRecord.value = toRaw(record)
    openDeviceAnnexDrawer(true, {
      deviceId: record.id,
      // isUpdate: true,
      // showFooter: true,
    })
  }

  /**
   * 打开设备检验检测抽屉
   */
   function handleOpenDeviceCheckTestDrawer(record: Recordable) {
    // checkDepartProgramRecord.value = toRaw(record)
    openDeviceCheckTestDrawer(true, {
      deviceId: record.id,
      // isUpdate: true,
      // showFooter: true,
    })
  }

  /**
   * 打开设备零件抽屉
   */
   function handleOpenDevicePartDrawer(record: Recordable) {
    // checkDepartProgramRecord.value = toRaw(record)
    openDevicePartDrawer(true, {
      deviceId: record.id,
      // isUpdate: true,
      // showFooter: true,
    })
  }

  /**
   * 打开设备改造情况抽屉
   */
   function handleOpenDeviceReformSituationDrawer(record: Recordable) {
    // checkDepartProgramRecord.value = toRaw(record)
    openDeviceReformSituationDrawer(true, {
      deviceId: record.id,
      // isUpdate: true,
      // showFooter: true,
    })
  }

  /**
   * 打开设备检修履历抽屉
   */
   function handleOpenDeviceRepairHistoryDrawer(record: Recordable) {
    // checkDepartProgramRecord.value = toRaw(record)
    openDeviceRepairHistoryDrawer(true, {
      deviceId: record.id,
      // isUpdate: true,
      // showFooter: true,
    })
  }

  // 高级查询配置
  const superQueryConfig = reactive(superQuerySchema);

  /**
   * 高级查询事件
   */
  function handleSuperQuery(params) {
    Object.keys(params).map((k) => {
      queryParam[k] = params[k];
    });
    reload();
  }
   /**
    * 新增事件
    */
  function handleAdd() {
     openModal(true, {
       deviceId: departId,
       isUpdate: false,
       showFooter: true,
     });
  }
   /**
    * 编辑事件
    */
  function handleEdit(record: Recordable) {
     openModal(true, {
       record,
       isUpdate: true,
       showFooter: true,
     });
   }
   /**
    * 详情
   */
  function handleDetail(record: Recordable) {
     openModal(true, {
       record,
       isUpdate: true,
       showFooter: false,
     });
   }
   /**
    * 删除事件
    */
  async function handleDelete(record) {
     await deleteOne({id: record.id}, handleSuccess);
   }
   /**
    * 批量删除事件
    */
  async function batchHandleDelete() {
     await batchDelete({ids: selectedRowKeys.value}, handleSuccess);
   }
   /**
    * 成功回调
    */
  function handleSuccess() {
      (selectedRowKeys.value = []) && reload();
   }
   /**
      * 操作栏
      */
  function getTableAction(record){
       return [
         {
           label: '编辑',
           onClick: handleEdit.bind(null, record),
         },
         {
           label: '详情查看',
           onClick: handleDetail.bind(null, record),
         },
        {
           label: '删除',
           popConfirm: {
             title: '是否确认删除',
             confirm: handleDelete.bind(null, record),
             placement: 'topLeft',
           }
         },
         {
           label: '零件结构',
           onClick: handleOpenDevicePartDrawer.bind(null, record),
         }, {
           label: '检修履历',
           onClick: handleOpenDeviceRepairHistoryDrawer.bind(null, record),
         }, {
           label: '检验检测',
           onClick: handleOpenDeviceCheckTestDrawer.bind(null, record),
         }, {
           label: '改造情况',
           onClick: handleOpenDeviceReformSituationDrawer.bind(null, record),
         }, {
           label: '设备附件',
           onClick: handleOpenDeviceAnnexDrawer.bind(null, record),
         }
       ]
   }
     /**
        * 下拉操作栏
        */
  function getDropDownAction(record){
       return [
          {
           label: '零件结构',
           onClick: handleOpenDevicePartDrawer.bind(null, record),
         }, {
           label: '检修履历',
           onClick: handleOpenDeviceRepairHistoryDrawer.bind(null, record),
         }, {
           label: '检验检测',
           onClick: handleOpenDeviceCheckTestDrawer.bind(null, record),
         }, {
           label: '改造情况',
           onClick: handleOpenDeviceReformSituationDrawer.bind(null, record),
         }, {
           label: '设备附件',
           onClick: handleOpenDeviceAnnexDrawer.bind(null, record),
         }
       ]
   }


</script>

<style scoped>
  :deep(.ant-picker),:deep(.ant-input-number){
    width: 100%;
  }
</style>