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
import org.jeecg.modules.demo.deviceinfo.entity.BizDeviceReformSituation;
import org.jeecg.modules.demo.deviceinfo.service.IBizDeviceReformSituationService;

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
 * @Description: 改造情况
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Api(tags="改造情况")
@RestController
@RequestMapping("/bizDeviceReformSituation")
@Slf4j
public class BizDeviceReformSituationController extends JeecgController<BizDeviceReformSituation, IBizDeviceReformSituationService> {
	@Autowired
	private IBizDeviceReformSituationService bizDeviceReformSituationService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bizDeviceReformSituation
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "改造情况-分页列表查询")
	@ApiOperation(value="改造情况-分页列表查询", notes="改造情况-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BizDeviceReformSituation>> queryPageList(BizDeviceReformSituation bizDeviceReformSituation,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BizDeviceReformSituation> queryWrapper = QueryGenerator.initQueryWrapper(bizDeviceReformSituation, req.getParameterMap());
		Page<BizDeviceReformSituation> page = new Page<BizDeviceReformSituation>(pageNo, pageSize);
		IPage<BizDeviceReformSituation> pageList = bizDeviceReformSituationService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bizDeviceReformSituation
	 * @return
	 */
	@AutoLog(value = "改造情况-添加")
	@ApiOperation(value="改造情况-添加", notes="改造情况-添加")
//	@RequiresPermissions("deviceinfo:biz_device_reform_situation:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BizDeviceReformSituation bizDeviceReformSituation) {
		bizDeviceReformSituationService.save(bizDeviceReformSituation);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bizDeviceReformSituation
	 * @return
	 */
	@AutoLog(value = "改造情况-编辑")
	@ApiOperation(value="改造情况-编辑", notes="改造情况-编辑")
//	@RequiresPermissions("deviceinfo:biz_device_reform_situation:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BizDeviceReformSituation bizDeviceReformSituation) {
		bizDeviceReformSituationService.updateById(bizDeviceReformSituation);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "改造情况-通过id删除")
	@ApiOperation(value="改造情况-通过id删除", notes="改造情况-通过id删除")
//	@RequiresPermissions("deviceinfo:biz_device_reform_situation:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bizDeviceReformSituationService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "改造情况-批量删除")
	@ApiOperation(value="改造情况-批量删除", notes="改造情况-批量删除")
//	@RequiresPermissions("deviceinfo:biz_device_reform_situation:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bizDeviceReformSituationService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "改造情况-通过id查询")
	@ApiOperation(value="改造情况-通过id查询", notes="改造情况-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BizDeviceReformSituation> queryById(@RequestParam(name="id",required=true) String id) {
		BizDeviceReformSituation bizDeviceReformSituation = bizDeviceReformSituationService.getById(id);
		if(bizDeviceReformSituation==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bizDeviceReformSituation);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bizDeviceReformSituation
    */
    @RequiresPermissions("deviceinfo:biz_device_reform_situation:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BizDeviceReformSituation bizDeviceReformSituation) {
        return super.exportXls(request, bizDeviceReformSituation, BizDeviceReformSituation.class, "改造情况");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("deviceinfo:biz_device_reform_situation:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BizDeviceReformSituation.class);
    }

}
