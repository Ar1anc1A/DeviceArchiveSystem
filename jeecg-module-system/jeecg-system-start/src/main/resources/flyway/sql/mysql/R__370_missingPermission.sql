-- 补充缺少的请求权限配置

INSERT IGNORE  INTO `sys_permission` (`id`, `parent_id`, `name`, `url`, `component`, `is_route`, `component_name`, `redirect`, `menu_type`, `perms`, `perms_type`, `sort_no`, `always_show`, `icon`, `is_leaf`, `keep_alive`, `hidden`, `hide_tab`, `description`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `rule_flag`, `status`, `internal_or_external`) VALUES ('f15543b0263cf6c5fac85afdd3eba3f2', '3f915b2769fc80648e92d04e84ca059d', '用户导入', '', NULL, 0, NULL, NULL, 2, 'system:user:import', '1', 1.00, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2019-05-13 19:15:27', 'admin', '2022-06-30 15:05:12', 0, 0, '1', 0);
INSERT IGNORE INTO `sys_permission` (`id`, `parent_id`, `name`, `url`, `component`, `is_route`, `component_name`, `redirect`, `menu_type`, `perms`, `perms_type`, `sort_no`, `always_show`, `icon`, `is_leaf`, `keep_alive`, `hidden`, `hide_tab`, `description`, `create_by`, `create_time`, `update_by`, `update_time`, `del_flag`, `rule_flag`, `status`, `internal_or_external`) VALUES ('1801954937339428865', '1460888189937176577', '测试数据源连接', NULL, NULL, 0, NULL, NULL, 2, 'online:report:testConnection', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2024-06-15 20:28:30', NULL, NULL, 0, 0, '1', 0);