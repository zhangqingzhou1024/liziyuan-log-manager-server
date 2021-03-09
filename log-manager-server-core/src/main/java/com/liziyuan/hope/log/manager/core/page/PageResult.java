package com.liziyuan.hope.log.manager.core.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zqz
 * @version 1.0
 * @date 2021-03-02 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("分页查询结果")
public class PageResult<T> {
    @ApiModelProperty("页码-pageNo")
    @JsonProperty("number")
    private Integer number;

    @ApiModelProperty("当前页元素个数")
    @JsonProperty("numberOfElements")
    private Integer numberOfElements;

    @ApiModelProperty("pageSize")
    @JsonProperty("size")
    private Integer size;

    @ApiModelProperty("排序规则")
    @JsonProperty("sort")
    private String sort;

    @ApiModelProperty("总条数")
    @JsonProperty("totalElements")
    private Integer totalElements;

    @ApiModelProperty("总页码")
    @JsonProperty("totalPages")
    private Integer totalPages;

    @ApiModelProperty("是否为第一页")
    @JsonProperty("firstPage")
    private Boolean firstPage;

    @ApiModelProperty("是否为最后一页")
    @JsonProperty("lastPage")
    private Boolean lastPage;

    @ApiModelProperty("内容-列表")
    @JsonProperty("content")
    private List<T> content = null;
}
