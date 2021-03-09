package com.liziyuan.hope.log.manager.core.enums;

import com.liziyuan.hope.log.manager.core.utils.FieldValueUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 操作类型枚举类
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-23 20:48
 */
@Getter
public enum OperateTypeEnum {

    /**
     * 新增
     */
    QUERY(0L, "query", "查询", false),
    /**
     * 新增
     */
    INSERT(1L, "insert", "新增", true),
    /**
     * 删除
     */
    DELETE(2L, "delete", "删除", true),
    /**
     * 编辑
     */
    EDIT(3L, "edit", "编辑", true),
    /**
     * 执行
     */
    EXECUTE(4L, "execute", "执行", true),

    /**
     * 上传
     */
    UPLOAD(5L, "upload", "上传", false),

    /**
     * 下载
     */
    DOWNLOAD(6L, "download", "下载", false);

    private Long id;
    private String operateType;
    private String operateTypeName;
    private boolean isShow;


    OperateTypeEnum(Long id, String operateType, String operateTypeName, boolean isShow) {
        this.id = id;
        this.operateType = operateType;
        this.operateTypeName = operateTypeName;
        this.isShow = isShow;
    }

    /**
     * 获取操作类型枚举
     *
     * @param operateType 操作类型
     * @return 操作类型枚举¬
     */
    public static OperateTypeEnum getOperateType(String operateType) {
        return Arrays.stream(OperateTypeEnum.values()).filter(item -> item.getOperateType().equals(operateType)).findFirst().orElse(null);
    }

    /**
     * 获取操作类型枚举
     *
     * @param operateTypes 操作类型
     * @return 操作类型枚举¬
     */
    public static List<OperateTypeEnum> getOperateTypeList(String operateTypes) {
        if (FieldValueUtils.isNullType(operateTypes)) {
            return null;
        }
        Set<String> typeSet = Arrays.stream(operateTypes.split(",")).collect(Collectors.toSet());
        List<OperateTypeEnum> typeEnumList = Arrays.stream(OperateTypeEnum.values()).collect(Collectors.toList());
        List<OperateTypeEnum> resultList = new ArrayList<>(typeSet.size());
        for (OperateTypeEnum operateTypeEnum : typeEnumList) {
            if (typeSet.contains(operateTypeEnum.getOperateType())) {
                resultList.add(operateTypeEnum);
            }
        }
        return resultList;
    }

    /**
     * 获取操作类型枚举
     *
     * @param operateTypeName 操作类型
     * @return 操作类型枚举¬
     */
    public static OperateTypeEnum getOperateTypeByName(String operateTypeName) {
        return Arrays.stream(OperateTypeEnum.values()).filter(item -> item.getOperateTypeName().equals(operateTypeName)).findFirst().orElse(null);
    }

}
