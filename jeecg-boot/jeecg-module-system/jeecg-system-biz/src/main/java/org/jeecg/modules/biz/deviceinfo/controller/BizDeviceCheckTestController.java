package org.jeecg.modules.biz.deviceinfo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.deviceinfo.entity.BizDeviceCheckTest;
import org.jeecg.modules.demo.deviceinfo.service.IBizDeviceCheckTestService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

 /**
 * @Description: 检验检测
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Api(tags="检验检测")
@RestController
@RequestMapping("/bizDeviceCheckTest")
@Slf4j
public class BizDeviceCheckTestController extends JeecgController<BizDeviceCheckTest, IBizDeviceCheckTestService> {
	@Autowired
	private IBizDeviceCheckTestService bizDeviceCheckTestService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bizDeviceCheckTest
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "检验检测-分页列表查询")
	@ApiOperation(value="检验检测-分页列表查询", notes="检验检测-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BizDeviceCheckTest>> queryPageList(BizDeviceCheckTest bizDeviceCheckTest,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BizDeviceCheckTest> queryWrapper = QueryGenerator.initQueryWrapper(bizDeviceCheckTest, req.getParameterMap());
		Page<BizDeviceCheckTest> page = new Page<BizDeviceCheckTest>(pageNo, pageSize);
		IPage<BizDeviceCheckTest> pageList = bizDeviceCheckTestService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bizDeviceCheckTest
	 * @return
	 */
	@AutoLog(value = "检验检测-添加")
	@ApiOperation(value="检验检测-添加", notes="检验检测-添加")
//	@RequiresPermissions("deviceinfo:biz_device_check_test:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BizDeviceCheckTest bizDeviceCheckTest) {
		bizDeviceCheckTestService.save(bizDeviceCheckTest);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bizDeviceCheckTest
	 * @return
	 */
	@AutoLog(value = "检验检测-编辑")
	@ApiOperation(value="检验检测-编辑", notes="检验检测-编辑")
//	@RequiresPermissions("deviceinfo:biz_device_check_test:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BizDeviceCheckTest bizDeviceCheckTest) {
		bizDeviceCheckTestService.updateById(bizDeviceCheckTest);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "检验检测-通过id删除")
	@ApiOperation(value="检验检测-通过id删除", notes="检验检测-通过id删除")
//	@RequiresPermissions("deviceinfo:biz_device_check_test:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bizDeviceCheckTestService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "检验检测-批量删除")
	@ApiOperation(value="检验检测-批量删除", notes="检验检测-批量删除")
//	@RequiresPermissions("deviceinfo:biz_device_check_test:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bizDeviceCheckTestService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "检验检测-通过id查询")
	@ApiOperation(value="检验检测-通过id查询", notes="检验检测-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BizDeviceCheckTest> queryById(@RequestParam(name="id",required=true) String id) {
		BizDeviceCheckTest bizDeviceCheckTest = bizDeviceCheckTestService.getById(id);
		if(bizDeviceCheckTest==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bizDeviceCheckTest);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bizDeviceCheckTest
    */
    @RequiresPermissions("deviceinfo:biz_device_check_test:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BizDeviceCheckTest bizDeviceCheckTest) {
        return super.exportXls(request, bizDeviceCheckTest, BizDeviceCheckTest.class, "检验检测");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("deviceinfo:biz_device_check_test:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BizDeviceCheckTest.class);
    }

}
