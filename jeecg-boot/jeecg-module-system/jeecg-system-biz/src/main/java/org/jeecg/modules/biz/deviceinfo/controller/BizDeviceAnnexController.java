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
import org.jeecg.modules.demo.deviceinfo.entity.BizDeviceAnnex;
import org.jeecg.modules.demo.deviceinfo.service.IBizDeviceAnnexService;

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
 * @Description: 设备附件
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Api(tags="设备附件")
@RestController
@RequestMapping("/bizDeviceAnnex")
@Slf4j
public class BizDeviceAnnexController extends JeecgController<BizDeviceAnnex, IBizDeviceAnnexService> {
	@Autowired
	private IBizDeviceAnnexService bizDeviceAnnexService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bizDeviceAnnex
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "设备附件-分页列表查询")
	@ApiOperation(value="设备附件-分页列表查询", notes="设备附件-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BizDeviceAnnex>> queryPageList(BizDeviceAnnex bizDeviceAnnex,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BizDeviceAnnex> queryWrapper = QueryGenerator.initQueryWrapper(bizDeviceAnnex, req.getParameterMap());
		Page<BizDeviceAnnex> page = new Page<BizDeviceAnnex>(pageNo, pageSize);
		IPage<BizDeviceAnnex> pageList = bizDeviceAnnexService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bizDeviceAnnex
	 * @return
	 */
	@AutoLog(value = "设备附件-添加")
	@ApiOperation(value="设备附件-添加", notes="设备附件-添加")
	@RequiresPermissions("deviceinfo:biz_device_annex:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BizDeviceAnnex bizDeviceAnnex) {
		bizDeviceAnnexService.save(bizDeviceAnnex);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bizDeviceAnnex
	 * @return
	 */
	@AutoLog(value = "设备附件-编辑")
	@ApiOperation(value="设备附件-编辑", notes="设备附件-编辑")
	@RequiresPermissions("deviceinfo:biz_device_annex:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BizDeviceAnnex bizDeviceAnnex) {
		bizDeviceAnnexService.updateById(bizDeviceAnnex);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "设备附件-通过id删除")
	@ApiOperation(value="设备附件-通过id删除", notes="设备附件-通过id删除")
	@RequiresPermissions("deviceinfo:biz_device_annex:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bizDeviceAnnexService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "设备附件-批量删除")
	@ApiOperation(value="设备附件-批量删除", notes="设备附件-批量删除")
	@RequiresPermissions("deviceinfo:biz_device_annex:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bizDeviceAnnexService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "设备附件-通过id查询")
	@ApiOperation(value="设备附件-通过id查询", notes="设备附件-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BizDeviceAnnex> queryById(@RequestParam(name="id",required=true) String id) {
		BizDeviceAnnex bizDeviceAnnex = bizDeviceAnnexService.getById(id);
		if(bizDeviceAnnex==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bizDeviceAnnex);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bizDeviceAnnex
    */
    @RequiresPermissions("deviceinfo:biz_device_annex:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BizDeviceAnnex bizDeviceAnnex) {
        return super.exportXls(request, bizDeviceAnnex, BizDeviceAnnex.class, "设备附件");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("deviceinfo:biz_device_annex:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BizDeviceAnnex.class);
    }

}
