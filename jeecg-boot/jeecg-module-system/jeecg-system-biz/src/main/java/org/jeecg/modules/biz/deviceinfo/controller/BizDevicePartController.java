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
import org.jeecg.modules.demo.deviceinfo.entity.BizDevicePart;
import org.jeecg.modules.demo.deviceinfo.service.IBizDevicePartService;

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
 * @Description: 装置零件
 * @Author: jeecg-boot
 * @Date:   2024-07-05
 * @Version: V1.0
 */
@Api(tags="装置零件")
@RestController
@RequestMapping("/bizDevicePart")
@Slf4j
public class BizDevicePartController extends JeecgController<BizDevicePart, IBizDevicePartService> {
	@Autowired
	private IBizDevicePartService bizDevicePartService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bizDevicePart
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "装置零件-分页列表查询")
	@ApiOperation(value="装置零件-分页列表查询", notes="装置零件-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<BizDevicePart>> queryPageList(BizDevicePart bizDevicePart,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BizDevicePart> queryWrapper = QueryGenerator.initQueryWrapper(bizDevicePart, req.getParameterMap());
		Page<BizDevicePart> page = new Page<BizDevicePart>(pageNo, pageSize);
		IPage<BizDevicePart> pageList = bizDevicePartService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param bizDevicePart
	 * @return
	 */
	@AutoLog(value = "装置零件-添加")
	@ApiOperation(value="装置零件-添加", notes="装置零件-添加")
	@RequiresPermissions("deviceinfo:biz_device_part:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody BizDevicePart bizDevicePart) {
		bizDevicePartService.save(bizDevicePart);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param bizDevicePart
	 * @return
	 */
	@AutoLog(value = "装置零件-编辑")
	@ApiOperation(value="装置零件-编辑", notes="装置零件-编辑")
	@RequiresPermissions("deviceinfo:biz_device_part:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody BizDevicePart bizDevicePart) {
		bizDevicePartService.updateById(bizDevicePart);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "装置零件-通过id删除")
	@ApiOperation(value="装置零件-通过id删除", notes="装置零件-通过id删除")
	@RequiresPermissions("deviceinfo:biz_device_part:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		bizDevicePartService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "装置零件-批量删除")
	@ApiOperation(value="装置零件-批量删除", notes="装置零件-批量删除")
	@RequiresPermissions("deviceinfo:biz_device_part:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bizDevicePartService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "装置零件-通过id查询")
	@ApiOperation(value="装置零件-通过id查询", notes="装置零件-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<BizDevicePart> queryById(@RequestParam(name="id",required=true) String id) {
		BizDevicePart bizDevicePart = bizDevicePartService.getById(id);
		if(bizDevicePart==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(bizDevicePart);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param bizDevicePart
    */
    @RequiresPermissions("deviceinfo:biz_device_part:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, BizDevicePart bizDevicePart) {
        return super.exportXls(request, bizDevicePart, BizDevicePart.class, "装置零件");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("deviceinfo:biz_device_part:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, BizDevicePart.class);
    }

}
