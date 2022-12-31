package com.example.server.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 页面信息
 */
public class PageInfo {
    @ApiModelProperty(value = "是否有下一页")
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @ApiModelProperty(value = "一共需要多少页")
    private int sum;
    @ApiModelProperty(value = "一页多少个条目")
    private int count;
    @ApiModelProperty(value = "一共有多少个条目")
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
