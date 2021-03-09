package com.liziyuan.hope.log.manager.core.enums;

import com.liziyuan.hope.log.manager.core.utils.FieldValueUtils;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 系统模块类型枚举
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-23 20:51
 */
@Getter
public enum SysModelTypeEnum {
    /**
     * 数据资源
     */
    CATALOG_RESOURCE(1L, "catalog_resource", "数据资源", true),
    /**
     * 数据集成
     */
    DATA_INTEGRATION(2L, "data_integration", "数据集成", true),
    /**
     * 数据质量
     */
    DATA_QUALITY(3L, "data_quality", "数据质量", true),
    /**
     * 数据标准
     */
    DATA_STANDARD(4L, "data_standard", "数据标准", true),
    /**
     * 控制台
     */
    CONSOLE(5L, "console", "控制台", true),
    /**
     * 数据标准
     */
    DATA_TAG(6L, "data_tag_manager", "数据标签管理", false),
    /**
     * 系统管理
     */
    SYSTEM_MANAGER(7L, "system_manager", "系统管理", true),
    /**
     * 主数据-当前不收集
     */
    MASTER_DATA(8L, "master_data", "主数据", false),
    /**
     * 元数据当前不收集
     */
    META_DATA(9L, "meta_data", "元数据", false);

    private Long id;
    private String modelType;
    private String modelName;
    private boolean isShow;

    SysModelTypeEnum(Long id, String modelType, String modelName, boolean isShow) {
        this.id = id;
        this.modelType = modelType;
        this.modelName = modelName;
        this.isShow = isShow;
    }

    /**
     * 获取系统模块类型
     *
     * @param modelType 系统模块类型
     * @return 操作系统模块类型
     */
    public static SysModelTypeEnum getModelType(String modelType) {
        return Arrays.stream(SysModelTypeEnum.values()).filter(item -> item.getModelType().equals(modelType)).findFirst().orElse(null);
    }

    /**
     * 获取系统模块类型
     *
     * @param modelTypes 系统模块类型
     * @return 操作系统模块类型
     */
    public static List<SysModelTypeEnum> getModelTypeList(String modelTypes) {
        if (FieldValueUtils.isNullType(modelTypes)) {
            return null;
        }
        Set<String> typeSet = Arrays.stream(modelTypes.split(",")).collect(Collectors.toSet());
        List<SysModelTypeEnum> typeEnumList = Arrays.stream(SysModelTypeEnum.values()).collect(Collectors.toList());
        List<SysModelTypeEnum> resultList = new ArrayList<>(typeSet.size());
        for (SysModelTypeEnum typeEnum : typeEnumList) {
            if (typeSet.contains(typeEnum.getModelType())) {
                resultList.add(typeEnum);
            }
        }
        return resultList;
    }

    /**
     * 获取系统模块类型
     *
     * @param modelName 系统模块名称
     * @return 操作系统模块类型
     */
    public static SysModelTypeEnum getModelTypeByName(String modelName) {
        return Arrays.stream(SysModelTypeEnum.values()).filter(item -> item.getModelName().equals(modelName)).findFirst().orElse(null);
    }

}
