package com.nmq.es.api;

import com.nmq.es.common.util.JsonResult;
import com.nmq.es.service.ItemsEsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Es搜索api", tags = {"提供es的查询api接口"})
@RestController
@RequestMapping("items")
public class ItemController {

    @Autowired
    private ItemsEsService itemsEsService;

    @GetMapping("/es/search")
    @ApiOperation(value = "根据关键字进行分页搜索", httpMethod = "GET")
    public JsonResult search(
           @ApiParam(name="keywords", value = "搜索关键字", required = true)
           String keywords,
           @ApiParam(name="sort", value = "排序字段", required = false)
           String sort,
           @ApiParam(name="page", value = "开始页数", required = false,defaultValue = "1")
           Integer page,
           @ApiParam(name="pageSize", value = "每页的大小", required = false,defaultValue = "10")
           Integer pageSize) {
        if (StringUtils.isBlank(keywords)) {
            return JsonResult.errorMsg(null);
        }

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = 20;
        }
        // es 的分页从0开始
        page--;

        return JsonResult.ok(itemsEsService.searchItems(keywords, sort, page, pageSize));
    }

}
