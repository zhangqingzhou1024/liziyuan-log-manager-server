package com.liziyuan.hope.log.manager.core.exception;

public enum APIReturnCode {

    /**********
     * COMMON *
     **********/
    /**
     * executed successfully
     **/
    SUCCESS(0, "执行成功。"),


    /**
     * Invalid account
     */
    ACCOUNT_NOT_FOUND(100, "账号不存在。"),

    ACCOUNT_UNAVAILABLE(101, "账号不可用。"),

    TOKEN_INVALID(102, "认证token缺失。"),
    /**
     * Invalid roleId
     */
    ROLE_NOT_FOUND(110, "角色'%s'不存在。"),


    /**
     * Invalid domain member params
     */
    ROLES_IS_EMPTY(120, "领域成员角色不能为空。"),

    DOMAIN_CODE_NOT_NULL(121, "domainCode不能为空"),

    /**
     * Invalid engineId
     */
    RESOURCE_ENGINE_NOT_FOUND(800, "资源引擎 '%s' 不存在。"),
    RESOURCE_TYPE_NOT_SUPPORTED(801, "资源引擎 '%s' 不支持的资源类型 '%s'。"),
    RESOURCE_ENGINE_NAME_DUPLICATE(802, "资源引擎名称已存在。"),
    CANNOT_DELETE_RESOURCE_ENGINE(803, "只有管理员和资源引擎拥有者可以删除或停用资源引擎！"),
    CANNOT_DELETE_BOUND_ENGINE_INSTANCE(804, "该资源引擎已绑定引擎实例，不能删除或停用！"),
    CANNOT_MODIFIED_RESOURCE_ENGINE(805, "只有管理员和资源引擎拥有者可以修改资源引擎！"),
    CANNOT_MODIFIED_BOUND_ENGINE_INSTANCE(806, "该资源引擎已绑定引擎实例，[%s]不可修改"),


    /**
     * Invalid engineInstanceId
     */
    RESOURCE_ENGINE_INSTANCE_NOT_FOUND(900, "资源引擎实例不存在。"),

    DOMAIN_ENGINE_INSTANCE_REL_NOT_FOUND(901, "领域未与该引擎实例绑定。"),


    /**
     * Invalid domainId or domainCode
     */
    DOMAIN_NOT_FOUND(10000, "领域不存在。"),
    /**
     * duplicate domain code
     */
    DOMAIN_DUPLICATE(10001, "领域已存在。"),
    
    /**
     * create domain failure message
     */
    DOMAIN_CREATE_FAILED(10002, "创建Domain失败。"),
    /**
     * delete domain failure message
     */
    DOMAIN_DELETE_FAILED(10003, "删除Domain失败。"),
    /**
     *delete domain failure message
     */
    DOMAIN_VIEW_BIND_DELETE_FAILED(10004,"领域视图被API Key为'%s'的应用绑定，不能删除"),

    CANNOT_CREATE_MORE_DOMAIN(10005,"每个用户只能最多能创建并拥有5个领域"),

    CANNOT_DELETE_DOMAIN(10006,"只有领域拥有者可以删除领域！"),

    DOMAIN_CODE_DUPLICATE(10007, "领域编码已存在。"),

    ACCOUNT_MISSED(10008, "非平台管理员用户，必须传account参数值。"),

    ACCESSIBLE_TYPE_IS_REQUIRED(10009, "'accessibleType'参数缺失"),

    DOMAIN_APP_BIND_DELETE_FAILED(10010, "当前域与API Key为'%s'的应用绑定，不可以删除"),

    CANNOT_RESUME_DOMAIN(10011, "只有领域拥有者可以恢复领域！"),


    /**
     * 领域成员
     */
    OWNER_MEMBER_NOT_FOUND(10100,"必须包含拥有者角色的成员，且拥有者只能是当前用户"),

    INCLUDE_INVALID_MEMBER_ROLE(10101,"领域成员包含非法角色，领域成员只能分配 '域拥有者''域管理员''域开发者'和'域运营者'中的一个或多个"),

    OWNER_MEMBER_DUPLICATE(10102,"域拥有者成员已存在"),

    DOMAIN_MEMBER_NOT_FOUND(10103,"领域成员不存在"),

    CANNOT_DELETE_OWNER_MEMBER(10104,"当前成员为域拥有者，不能删除"),

    CANNOT_REMOVE_OWNER_ROLE(10105,"当前成员为域拥有者，必须包含'域拥有者'角色"),

    CANNOT_UPDATE_MEMBER_ACCOUNT(10106,"不能更新领域成员的账号"),

    DOMAIN_MEMBER_DUPLICATE(10107,"'%s' 成员已存在"),

    CANNOT_QUERY_DOMAIN(10108,"当前用户不是该领域的成员，不能查看该领域！"),

    MEMBER_ROLE_DUPLICATE(10109,"领域成员角色'%s'已存在"),

    CANNOT_REMOVE_ROLE_OWNER_USER(10110,"不能移除领域成员的'访客'角色。"),

    CANNOT_DELETE_DOMAIN_USER_MEMBER(10111,"当前成员具有'访客'角色，不能删除"),

    CANNOT_BIND_DOMAIN(10112,"当前用户不是该领域的成员，不能绑定到应用！"),

    BINDINGS_EXIST(10113,"当前成员下的应用绑定了该领域，请先解绑 ！"),

    CANNOT_ADD_OWNER_ROLE(10114,"当前成员不是领域创建者，不能添加'域所有者'角色"),






    /**
     * Invalid model id
     */
    MODEL_NOT_FOUND(11000, "资源不存在[%s]。"),
    /**
     * duplicate resource model code
     */
    MODEL_DUPLICATE(11001, "资源已存在。"),
    /**
     * create model failure message
     */
    MODEL_CREATE_FAILED(11002, "创建资源失败。"),
    /**
     * delete model failure message
     */
    MODEL_DELETE_FAILED(11003, "删除资源失败。"),
    /**
     * at least one property
     */
    MODEL_PROPERTY_NOT_ALLOW_EMPTY(11004, "资源至少包含一个属性。"),

    RESOURCE_METADATA_DUPLICATE(11005, "资源'%s'已存在。"),

    MISS_STORE_CODE_FOR_REVERSE_MODELING(11006, "反向建模，storeCode不可缺失。"),

    /**
     * model filter not found
     */

    SQL_NOT_BIND_FOR_QUERY_MODEL(11009, "查询资源发布之前请先绑定SQL"),

    ID_IS_REQUIRED_FOR_ENTITY_MODEL(11010, "实体资源的业务属性必须包含id字段"),

    MODEL_UPDATE_FAILED(11011, "资源基本信息更新失败"),

    CANNOT_EDIT_PROPS_FOR_MODEL_MODIFICATION(11012, "更新资源基本信息时不能对资源属性进行编辑。"),

    DATATYPE_CANNOT_BE_JSON_OF_ID(11012, "资源的ID属性不能是JSON或BOOLEAN类型。"),

    MODEL_FILTER_DUPLICATE(11013, "资源过滤器已存在。"),

    INVALID_UPLOAD_FILE_FORMAT(11014, "上传文件格式不正确。"),

    MODEL_TYPE_REQUIRED(11015, "资源类型不能为空。[%s:%s]"),

    INVALID_MODEL_TYPE(11016, "指定资源类型不存在。[%s:%s]"),

    CANNOT_DELETE_MODEL_HAS_DATA(11017, "该资源已有数据，不能删除。"),

    CANNOT_DELETE_MODEL_RP_REF(11018, "该资源已被资源代理引用，不能删除。资源代理:%s"),
    CANNOT_DELETE_MODEL_LINK_REF(11019, "该资源已被关联引用，不能删除。关联名:%s"),

    PROPERTY_CANNOT_BE_JSON_AND_UNIQUE(11020, "资源属性数据类型为JSON时，不可设置为惟一。"),
    CREATE_BTREE_INDEX_PROPERTY_CANNOT_BE_JSON(11021, "索引属性的数据类型包含JSON类型时，BTREE索引不可创建。"),

    MODEL_CONFIG_DUPLICATE(11200, "资源配置已存在。"),

    CREATE_MODEL_CONFIG_FAILED(11201, "创建资源配置失败。"),

    DELETE_MODEL_CONFIG_FAILED(11202, "删除资源配置失败。"),

    ENTITY_MODEL_CANNOT_CONFIG_CLOUDT_PROXY(11203, "实体类资源不能配置Cloudt代理。"),

    CLOUDT_PROXY_NONSUPPORT_PAGEABLE(11204, "Cloudt代理不支持可分页。"),

    ID_PROPERTY_IS_REQUIRED_FOR_ENTITY_MODEL_GENERAL_PROXY(11205, "资源必须要有ID属性。"),

    INVALID_TS_PROXY_CONFIG_ITEMS(11207, "TS代理时间空间分区和分区数量必须同时配置或都不配置。"),

    INVALID_NUMBER_PARTITIONS_VALUE(11208, "空间分区Hash个数值必须大于0 小于32768。"),

    INVALID_PARTITIONING_COLUMN_VALUE(11209, "空间分区引用的属性代码不存在，请重新选择"),

    CANNOT_FIND_MODEL_CONFIG(11210, "资源配置不存在。"),

    CANNOT_UPDATE_MODEL_CONFIG_OF_PUBLISHED_MODEL(11211, "已发布的资源不可更改资源配置"),

    INVALID_ID_PROPERTY_DATA_TYPE_FOR_ENTITY_MODEL(11212, "实体资源%s的ID属性必须为整型或长整型。"),

    INVALID_METADATA_CONFIG_ID(11213, "TS代理配置项ID不合法"),

    CONFIG_PROPERTY_CREATE_FAILED(11214, "配置属性创建失败"),

    CONFIG_PROPERTY_DELETE_FAILED(11215, "配置属性删除失败"),

    MODEL_CONFIG_UPDATE_FAILED(11216, "资源配置更新失败"),

    CANNOT_FIND_PROXY_CONFIG_ITEMS(11217, "%s配置项不完整，缺少[%s]配置项"),
    SELECT_ITEM_REQUIRED(11218, "[%s] 为必须项，但当前为空。"),
    INVALID_COLUMN_CODE(11219, "%s 引用的属性代码不存在，请重新选择"),
    INVALID_TIME_PARTITION_DATA_TYPE_FOR_ENTITY_MODEL_TS_PROXY(11220, "实体资源时序代理类的时间分区属性必须为整型、长整型或时间类型。"),
    TIME_PARTITION_DATA_TYPE_CHUNK_TIME_INTERVAL_REQUIRED(11221, "时间分区属性数据类型为整型时，数据块间隔配置项为必须。"),
    INVALID_DATA_TYPE(11222, "输入数据类型不合法。应该为 %s"),
    INVALID_RANGE_VALUE(11223, "%s数值必须大于%s 小于%s。"),
    TS_RELATED_MODEL_PROPERTY_NOT_ALLOW_DELETE(11224, "时序数据库引用的时间分区或空间分区属性不能删除。"),
    INVALID_TIME_SPACE_PARTITIONING_COLUMN_VALUE(11225, "时间分区与空间分区引用的属性代码不能相同，请重新选择"),
    INVALID_CRON_EXPRESSION(11226, "Cron表达式语法错误：%s"),
    CREATE_TASK_JOB_FAILED(11227, "创建定时任务失败。"),
    START_TASK_JOB_FAILED(11228, "启动定时任务失败。请重新配置或到任务管理平台启动。"),
    REMOVE_TASK_JOB_FAILED(11229, "删除定时任务失败。"),
    UPDATE_TASK_JOB_FAILED(11230, "更新定时任务失败。"),
    INVALID_TIME_PARTITION_DATA_TYPE_FOR_ENTITY_MODEL_TS_PROXY_TIME(11231, "时序引擎类资源的时间分区属性必须为时间类型或整型。"),
    CANNOT_DELETE_BOUND_MODEL(11232, "该资源已绑定资源代理，不能删除。"),

    CANNOT_UPDATE_INCOMPATIBLE_FIELDS_OF_BOUND_MODEL(11233, "该资源已绑定资源代理，不能更新 '最大长度、必须、唯一' 字段。"),

    CANNOT_DELETE_REFERENCED_MODEL(11234, "该资源被引用资源[领域: %s, 资源： %s]引用，不能删除。"),
    CANNOT_SETTING_PARTITION(11235, "该资源类型不可设置分区。"),
    GET_TASK_JOB_FAILED(11236, "获取定时任务失败。"),

    AUTO_INCREASE_CANNOT_SET_DEFAULT(11237, "自增长数据类型不能设置默认值。[%s]"),

    ID_PROPERTY_REQUIRED_AND_UNIQUE(11238, "ID属性必须是必填且唯一。"),

    EMPTY_DATA_TYPE(11239, "数据类型不能为空。资源[%s].属性[%s]"),

    DATA_TYPE_NOT_EXIST(11240, "[%s]数据类型[%s]不暂支持或不存在。资源[%s].属性[%s]"),

    DATA_TYPE_NOT_SUPPORT(11241, "[%s]不暂支持或不存在[%s]。"),


    /**
     * 数据探查异常信息
     */
    DATA_DETECTION_FAILED(11242, "数据探查失败：'%s'。"),


    /**
     * Invalid model id or model code
     */
    MODEL_PROPERTY_NOT_FOUND(12000, "资源属性不存在。"),
    /**
     * duplicate model property code
     */
    MODEL_PROPERTY_DUPLICATE(12001, "资源属性已经存在。"),

    /**
     * create model property failure message
     */
    MODEL_PROPERTY_CREATE_FAILED(12002, "创建资源属性失败。"),
    /**
     * update model property failure message
     */
    MODEL_PROPERTY_UPDATE_FAILED(12003, "更新资源属性失败。"),
    /**
     * delete model property failure message
     */
    MODEL_PROPERTY_DELETE_FAILED(12004, "删除资源属性失败。"),

    INVALID_PROPERTY_DEFAULT_VALUE(12005, "属性'%s'的默认值不合法"),

    PROP_IS_REFERENCED_BY_SPACE_PARTITION(12007, "被修改的资源属性被空间分区配置引用。"),

    PROP_IS_REFERENCED_BY_SQL(12007, "被修改的资源属性被SQL引用。"),

    CANNOT_MODIFY_PROP_TYPE(12008, "该资源已绑定资源代理或已发布，不能修改资源的属性类型。"),

    CANNOT_MODIFY_PROP_CODE(12009, "该资源已绑定资源代理或已发布，不能修改资源的属性编码。"),

    CANNOT_OPEN_UNIQUE_OF_PROP_FOR_PUBLISHED_MODEL(12010, "该资源已发布，不能将属性从非唯一改为唯一。"),

    CANNOT_OPEN_REQUIRED_OF_PROP_FOR_PUBLISHED_MODEL(12011, "该资源已发布，不能将属性从非必须改为必须。"),

    CANNOT_DECREASE_MAXLENGTH_OF_PROP_FOR_PUBLISHED_MODEL(12012, "该资源已发布，不能减小属性的最大长度。"),

    CANNOT_MODIFY_MAXLENGTH_OF_PROP_REFERENCED_BY_SPATIAL_PARTITION(12013, "不能修改已发布资源的被空间分区引用的属性的最大长度。"),

    CANNOT_MODIFY_REQUIRED_OF_PROP_REFERENCED_BY_SPATIAL_PARTITION(12014, "不能修改已发布资源的被空间分区引用的属性的'必须'字段。"),

    CANNOT_MODIFY_DEFAULT_VALUE_OF_PROP_REFERENCED_BY_SPATIAL_PARTITION(12015, "不能修改已发布资源的被空间分区引用的属性的默认值。"),

    CANNOT_MODIFY_UNIQUE_OF_PROP_REFERENCED_BY_SPATIAL_PARTITION(12016, "不能修改已发布资源的被空间分区引用的属性的'唯一'字段。"),

    KEY_DUPLICATE(12017, "%s[%s]重复。"),

    CANNOT_DELETE_ID_PROP(12018, "不能删除资源的 id 字段。"),

    CANNOT_DELETE_TIME_PROP(12019, "不能删除时序类资源的 time 字段。"),

    CANNOT_DELETE_BINDING_RP_MODEL_PROPS(12020, "该资源已绑定资源代理，不能删除资源属性。"),

    INVALID_PROPERTY_DEFAULT_VALUE_OVER_MAXLENGTH(12021, "属性'%s'的默认值不合法，超过最大长度%s。"),

    INVALID_PROPERTY_MAX_LENGTH(12022, "属性'%s'的最大长度不能小于零。"),

    MODEL_PROPERTY_CREATE_FAILED_REQUIRED_NO_DEFAULT_VALUE(12023, "创建资源属性失败。表中已有数据，必须字段没设置默认值。"),

    REF_LOST_PRRAMS(12024,"引用资源refDomainCode或refModelId不能为空"),

    REFERENCE_MODEL_NOT_FOUND(12026,"被引用资源不存在"),

    REFERENCE_MODEL_MUST_ENTITY(12027,"被引用资源必须为实体类型"),

    CANNOT_REFERENCE_SAME_DOMAIN(12027,"被引用资源必须为非本域资源"),

    CANNOT_DELETE_REFERENCED_BY_SCOPE_PROPERTY(12018, "属性'%s'被范围 '%s' 引用，不能被删除。"),

    CANNOT_DELETE_REFERENCED_BY_REL_PROPERTY(12019, "属性'%s'被关联引用，不能被删除。"),

    /**
     * Invalid model operation id
     */
    MODEL_OPERATION_NOT_FOUND(13000, "未找到资源操作。"),
    /**
     * duplicate model operation name
     */
    MODEL_OPERATION_DUPLICATE(13001, "资源操作名称已经存在。"),
    /**
     * create model operation failure message
     */
    MODEL_OPERATION_CREATE_FAILED(13002, "创建资源操作失败。"),
    /**
     * update model operation failure message
     */
    MODEL_OPERATION_UPDATE_FAILED(13003, "更新资源操作失败。"),
    /**
     * delete model operation failure message
     */
    MODEL_OPERATION_DELETE_FAILED(13004, "删除资源操作失败。"),
    /**
     * cannot delete REST-LIST & REST-GET model operation
     */
    DEFAULT_MODEL_OPERATION_CANNOT_DELETE(13005, "不能删除资源默认操作 REST-LIST & REST-GET。"),

    CANNOT_MODIFY_MODEL_TYPE(13006, "不能修改资源类型。"),

    CANNOT_MODIFY_MODEL_STATUS_TYPE(13007, "不能修改资源发布状态。"),

    /**
     * Invalid model index name
     */
    MODEL_INDEX_NOT_FOUND(14000, "未找到资源索引。"),
    /**
     * duplicate model index name
     */
    MODEL_INDEX_DUPLICATE(14001, "资源索引已经存在。"),
    /**
     * create model index failure message
     */
    MODEL_INDEX_CREATE_FAILED(14002, "创建资源索引失败。"),
    /**
     * delete model index failure message
     */
    MODEL_INDEX_DELETE_FAILED(14003, "删除资源索引失败。"),

    DELETE_MODEL_INDEX_FAILED_DEPENDENT(14004, "删除资源索引失败。【有约束依赖，请删除约束。】"),
    CANNOT_DELETE_INDEX(14005, "该索引被节点过滤器引用 [领域: %s, 视图: %s, 节点: %s]"),
    MODEL_INDEX_CODE_DUPLICATE(14006, "资源索引编号已经存在。[%s]"),
    MODEL_INDEX_PROPERTY_NOT_EXIST(14007, "资源索引属性不存在。[%s]"),
    CANNOT_OPERATE_MODEL_INDEX(14008, "当前资源类型不支持索引操作。[%s]"),
    INDEX_AT_LEAST_CONTAINS_ONE_PROPERTY(14009, "至少选择一个索引字段。"),
    INVALID_INDEX_TYPE(14010, "在'%s'中，不存在ordinal为'%s'的索引枚举值。"),

    /**
     * Invalid link name
     */
    LINK_NOT_FOUND(15000, "未找到关联。"),
    /**
     * duplicate link name
     */
    LINK_DUPLICATE(15001, "关联已经存在。"),
    /**
     * create link failure message
     */
    LINK_CREATE_FAILED(15002, "创建关联失败, '%s'。"),
    /**
     * delete link failure message
     */
    LINK_DELETE_FAILED(15003, "删除关联失败。"),
    /**
     * cannot create query model link
     */
    QUERY_MODEL_NOT_ALLOW_CREATE_LINK(15004, "不能对查询类资源创建关联。"),
    /**
     * cannot create query model link
     */
    SOURCE_MDOEL_MUST_BELONG_TO_THE_DOMAIN(15005, "源资源必须属于本域。"),
    /**
     * cannot create query model link
     */
    TARGET_MDOEL_MUST_BELONG_TO_THE_DOMAIN_FOR_STATIC(15006, "静态关联目标资源必须属于本域。"),
    /**
     * invalid source model propertyId
     */
    SOURCE_MODEL_PROPERTY_NOT_FOUND(15007, "源资源属性不存在。"),
    /**
     * invalid target model propertyId
     */
    TARGET_MODEL_PROPERTY_NOT_FOUND(15008, "目标资源属性不存在。"),

    TARGET_MODEL_PROPERTY_NOT_ID(15108, "目标资源属性, 必须为单一主键。"),

    LINK_TYPE_INVALID(15009, "只有动态链接才能操作。"),
    LINK_SOURCE_OR_TARGET_DATA_IS_NULL(15010, "动态链接源数据及目标数据不能为空。"),
    LINK_SOURCE_OR_TARGET_NOT_EQUAL_SETTING(15011, "动态链接数据的源资源或目标资源与设置不一致。"),
    DATA_TRANSFORM_FAILED(15012, "数据转换失败。"),

    LINK_DATA_NOT_FOUND(15013, "未找到动态链接的数据关联。"),
    LINK_DATA_DUPLICATE(15014, "动态链接的数据关联已经存在。"),
    CANNOT_LINK_ITSELF(15015, "源资源与目标资源不能一样"),


    CANNOT_DELETE_REFERENCED_LINK(15016, "该关联已被视图引用，不能删除。"),

    CANNOT_UPDATE_TYPE_OF_REFERENCED_LINK(15017, "该关联已被视图引用，不能更新关联类型。"),

    CANNOT_UPDATE_SOURCE_DOMAIN_OF_REFERENCED_LINK(15018, "该关联被已被视图引用，不能更新源域。"),

    CANNOT_UPDATE_TARGET_DOMAIN_OF_REFERENCED_LINK(15018, "该关联被已被视图引用，不能更新目标域。"),

    CANNOT_UPDATE_SOURCE_MODEL_OF_REFERENCED_LINK(15019, "该关联已被视图引用，不能更新源资源。"),

    CANNOT_UPDATE_TARGET_MODEL_OF_REFERENCED_LINK(15020, "该关联已被视图引用，不能更新目标资源。"),

    CANNOT_UPDATE_SOURCE_MODEL_PROP_OF_REFERENCED_LINK(15021, "该关联已被视图引用，不能更新源资源属性。"),

    CANNOT_UPDATE_TARGET_MODEL_PROP_OF_REFERENCED_LINK(15022, "该关联已被视图引用，不能更新目标资源属性。"),

    CANNOT_CREATE_LINK_FOR_INACTIVE_MODEL(15023, "%s资源未发布，不能创建关联"),

    INVALID_TARGET_MODEL_PROPERTY_DATA_TYPE(15024, "源资源属性数据类型与目标资源属性数据类型不一致。[%s]"),

    SOURCE_AND_TARGET_MODEL_PROPERTY_IS_REQUIRED(15025, "静态关联必须选择源资源属性和目标资源属性。"),

    NOT_FOUND_MODEL_LINK_SHEET(15026, "上传文件中找不到 '资源关联' sheet。"),

    LINK_CODE_DUPLICATE(15027, "同域下关联编码重复, %s。"),

    /**
     * Invalid view code
     */
    VIEW_NOT_FOUND(16000, "未找到视图。"),
    /**
     * duplicate view code
     */
    VIEW_DUPLICATE(16001, "视图已经存在。"),
    /**
     * create view failure message
     */
    VIEW_CREATE_FAILED(16002, "创建视图失败。"),
    /**
     * delete view failure message
     */
    VIEW_DELETE_FAILED(16003, "删除视图失败。"),

    /**
     * Invalid view node code
     */
    VIEW_NODE_NOT_FOUND(16004, "未找到视图节点。"),
    /**
     * duplicate view node code
     */
    VIEW_NODE_DUPLICATE(16005, "相同编码的视图节点已经存在。"),
    /**
     * create view node failure message
     */
    VIEW_NODE_CREATE_FAILED(16006, "创建视图节点失败。"),
    /**
     * delete view node failure message
     */
    VIEW_NODE_DELETE_FAILED(16007, "删除视图节点失败。"),
    /**
     * delete view node failure message
     */
    NOT_ALLOW_CREATE_NODE_LINK_NOT_FOUND(16008, "当前资源与父亲节点资源不存在关联关系，不能创建该资源节点。"),

    /**
     * Invalid view node context code
     */
    NODE_CONTEXT_NOT_FOUND(16009, "未找到视图节点上下文。"),
    /**
     * duplicate view node context code
     */
    NODE_CONTEXT_DUPLICATE(16010, "视图节点上下文已经存在。"),
    /**
     * create view node context failure message
     */
    NODE_CONTEXT_CREATE_FAILED(16011, "创建视图节点上下文失败。"),
    /**
     * delete view node context failure message
     */
    NODE_CONTEXT_DELETE_FAILED(16012, "删除视图节点上下文失败。"),
    /**
     * only model nodes can create a node context
     */
    CANNOT_CREATE_VIEW_NODE_CONTEXT(16013, "只有资源类型节点才能创建节点上下文。"),

    MODELDOMAINCODE_IS_REQUIRED_FOR_NODE_CREATE(16014, "创建资源类视图节点必须传'modelDomainCode'参数。"),

    ENTITY_MODEL_NODE_FILTER_INDEXCODE_NULL_ERROR(16015, "实体资源类节点Filter的索引编码不能为空。"),

    FILTER_NOT_IN_INDEX_PROPERTIES(16016, "节点过滤字段 '%s' 不在资源索引属性中。"),

    MODEL_FILTER_UPDATE_FAILED(16017, "更新资源过滤器失败。"),

    MODEL_FILTER_CREATE_FAILED(16018, "创建资源过滤器失败。"),

    MODEL_FILTER_DELETE_FAILED(16019, "删除资源过滤器失败。"),
    /**
     * update view node failure message
     */
    VIEW_NODE_UPDATE_FAILED(16020, "更新视图节点失败。"),

    CANNOT_CREATE_VIEW_NODE_FOR_INACTIVE_MODEL(16021, "资源未发布，不能创建此资源节点"),

    VIEW_BEING_BOUND_BY_APP(16003, "该视图已被 '%s' 应用绑定，不能删除。"),


    /**
     * Tag failure message
     */
    TAG_NOT_FOUND(17000, "未找到该标签。"),
    TAG_DUPLICATE(17001, "该领域下存在同名标签。"),
    TAG_CREATE_FAILED(17002, "创建标签失败。"),
    TAG_UPDATE_FAILED(17003, "更新标签失败。"),
    TAG_LIST_FAILED(17004, "获取标签列表失败。"),
    TAG_GET_FAILED(17005, "获取标签详情失败。"),
    TAG_DELETE_FAILED(17006, "删除标签失败。"),
    CANNOT_UPDATE_TAG_PARENT_ID(17007, "不能修改标签的父标签 ID。"),
    CANNOT_CREATE_MORE_THAN_THREE_LEVEL_OF_TAGS(17008, "最多只能创建三级标签。"),
    TAG_NAME_DUPLICATE(17009, "标签名称已存在。"),
    TAG_RESOURCE_REL_DUPLICATE(17010, "资源已经配置标签。"),


    /**
     * Scope failure message
     */
    SCOPE_NOT_FOUND(17100, "范围'%s'不存在。"),
    SCOPE_DUPLICATE(17101, "范围已存在。"),
    SCOPE_CODE_PREFIX_INVALID(17102, "范围标识必须以'scope.'开头"),
    CANNOT_UPDATE_SCOPE_CODE(17103, "不能修改范围标识"),
    SCOPE_CREATE_FAILED(17104, "范围创建失败！"),
    OPERATOR_NOT_MATCH_PARAMETERS(17105, "操作符与参数个数不匹配"),
    FILTER_PARAMETER_DATA_TYPE_NOT_MATCH(17106, "过滤参数类型不匹配"),
    NOT_ROLE_SYS_ADMIN(17107, "当前用户非管理员用户，需要指定领域查看范围"),
    PARAMETER_NAME_DUPLICATE(17108, "参数名称重复"),
    CANNOT_UPDATE_SYSTEM_SCOPE(17109, "系统范围定义不能修改"),
    CANNOT_CONFIG_SCOPE(17110, "当前资源与范围 '%s' 的纬度表不是同一个表且不存在直接或间接关联关系，不能配置该范围！"),
    CANNOT_DELETE_SCOPE(17111, "该范围被资源 '%s' 引用，不能被删除！"),
    CANNOT_UPDATE_SCOPE(17112, "该范围被资源 '%s' 引用，不能修改纬度表、操作符和参数！"),
    SCOPE_PARAMETER_INDEX_INVALID(17113, "范围参数索引值不合法，index从'1'开始且不可重复，范围参数值按index有序"),
    CANNOT_REMOVE_SCOPE(17114, "存在基于范围[%s]的资源授权，不能移除当前资源的此范围配置！"),

    /**
     * Attachment failure message
     */
    UPLOAD_ATTACHMENT_FAILED(17200, "附件上传失败, %s。"),
    ATTACHMENT_NOT_FOUND(17201, "附件不存在。"),
    DOWNLOAD_ATTACHMENT_FAILED(17202, "附件下载失败, %s。"),
    ATTACHMENT_TOO_LARGE(17203, "上传附件过大, 附件限制最大为5MB。"),

    /**
     * resource permit failure message
     */
    PERMISSIONS_IS_EMPTY(17300, "资源的申请权限不能为空。"),
    WRONG_PARAMETER_FOR_GLOBAL_DOMAIN_PERMIT(17301, "全域资源申请的参不正确。"),
    PARAMETER_CANNOT_BE_NULL(17302, "是否只申请配置了选择的范围的资源参数不能为null。"),
    SCOPE_INVALID(17303, "资源[%s]未配置范围[%s]"),
    SCOPE_PARAMETER_VALUE_FORMAT_INVALID(17304, "范围'%s'参数格式不合法， between范围参数形如'paramName1:value; paramName2:value'分隔, 列表参数形如'paramName:value1,value2,...'分隔, 单参数形如'paramName:value'"),
    SCOPE_PARAMETER_VALUE_INVALID(17304, "范围'%s' 参数值类型不匹配，type: '%s', value: '%s'"),
    SCOPE_PARAMETER_NAME_INVALID(17305, "范围'%s'参数名称'%s'不存在。"),
    RESOURCE_APPLICATION_NOT_FOUND(17306, "资源申请单不存在。"),
    CANNOT_UPDATE_RESOURCE_APPLICATION(17307, "当前用户不是资源权限申请单的审批者，不能审批该申请单。"),
    REPEAT_APPROVAL(17308, "当前申请单已被审批。"),

    OPER_APPLY_CUSTOM_PERMISSION_CONSTRAINT(17309, "领域运营者只能申请除了查询以外的操作权限，且不能限制资源范围及安全等级。"),

    CANNOT_APPLY_CUSTOM_PERMISSION(17310, "领域所有者、管理员、开发者角色，不能申请资源自定义权限。"),

    PERMISSIONS_AT_LEAST_CONTAIN_SELECT(17311, "资源权限项不为空时，至少包含'查询'"),

    BETWEEN_OP_PARAMETERS_VALUE_INVALID(17312, "between操作符范围参数值必须按index的顺序有序"),

    SCOPE_PARAMETER_TYPE_NOT_SUPPORT(17313, "范围参数类型'%s'不支持"),

    INVISIBLE_DOMAIN_FOR_CURRENT_ACCOUNT(17314, "请求的领域为当前用户不可见领域。"),


    /**
     * data access failure message
     */
    REQUEST_METHOD_NOT_SUPPORT(17400, "请求方法'%s'不支持"),


    /**
     * import file failure message
     */
    FILESET_NOT_FOUND(17500, "文件集不存在。"),

    NOT_FILESET(17501, "'%s' 不是文件集。"),

    REQUIRED_FIELD_VALUE_IS_NULL(17502, "必填属性值不能为空。"),

    FILESET_FIELD_MISSING(17503, "文件集描述属性缺失。"),

    IMPORT_FILE_FAILED(17504, "导入文件失败 '%s'。"),

    APPLY_POLICY_FAILED(17505, "申请上传文件的operationCode失败 '%s'。"),





    /**
     * reserved word failure message
     */

    RESERVED_WORD_DOMAIN_CODE(19000, "Domain Code为保留字。"),
    
    RESERVED_WORD_MODEL_CODE(19001, "Model Code为保留字。"),
    
    RESERVED_WORD_SEGMENT(19002, "Node Code为保留字。"),

    CODE_MODIFICATION_IS_NOT_SUPPORTED(19999, "编码不允许修改。"),

    INVALID_RESERVED_WORD(19003, "%s:%s 为保留字。"),

    INVALID_SQL(20000, "SQL非法。"),
    INVALID_SQL_ITEM_TYPE(20001, "SQL拼接类型非法。"),

    PROXY_MODEL_PROPERTY_NOT_EXISTS(20002,"属性 '%s' 在资源中不存在。"),
    PROXY_PAYLOAD_NOT_EXISTS(20003,"payload 不能为空。"),
    PROXY_PROPERTIES_NOT_EXISTS(20004,"资源属性 不能为空。"),
    PROXY_DATA_MAXLENGTH_ERROR(20005,"属性%s 长度不能超过 %s 个字符。"),
    PROXY_DATA_FIELD_NULL_ERROR(20006,"字段%s 不能为空。"),
    MULTI_SQL_STATEMENTS(20007, "只能执行一条SQL语句。"),
    INVALID_SQL_STATEMENT(20008, "只支持INSERT、UPDATE、DELETE、SELECT等SQL语句。"),
    SQL_STATEMENT_IS_EMPTY(20009, "SQL语句不能为空。"),
    SQL_SELECT_FIELDS_NEED_ALIAS(20010, "字段类型不支持，请设置别名。"),
    SQL_SELECT_FIELDS_NOT_IN_MODEL(20011, "SQL 绑定的资源中不存在该属性名。"),
    SQL_WHERE_NOT_SUPPORT_JSON_TYPE(20012, "过滤条件暂不支持JSON类型。"),
    SQL_OPERATOR_NOT_SUPPORT_DATA_TYPE(20013, "该操作符%s不支持%s数据类型。"),
    SQL_DATA_VALUE_NOT_MATCH_DATA_TYPE(20014, "数据值%s与数据类型%s不匹配 。"),
    DATA_NOT_FOUND(20015, "数据不存在。"),
    INVALID_SQL_STATEMENT_TYPE(20016, "只支持SELECT等SQL语句。"),
    PROXY_FILTERS_NOT_EXISTS(20017,"数据过滤条件不能为空。"),
    RESOURCE_PROXY_SERVICE_NOT_FOUND(20018, "资源代理服务不存在。"),
    SQL_SELECT_FIELDS_ALL_NOT_IN_MODEL(20019, "SQL查询的字段在绑定的资源属性中都不存在。"),
    SQL_SELECT_ALL_FIELDS(20020, "SQL不支持*全字段查询。"),
    SQL_DATA_VALUE_INCLUDE_CHINESE_COMMA(20021, "IN和NIN操作符数据值不能包含中文逗号"),
    MISSING_ENTRY_FOR_TABLE(20022, "无法识别表的别名 '%s' 。"),
    VIEW_FILTERS_VALUE_ISBLANK(20023,"数据过滤条件的数据值不能为空。"),
    VIEW_FILTERS_NOT_MATCH_THE_INDEX(20024,"数据过滤条件不匹配索引。"),
    SQL_ID_TYPE_INVALID(20225,"不支持的id字段数据类型 '%s'"),
    SQL_SELECT_FIELDS_MISS_REQUIRED_FILED(20026, "SQL查询的字段缺失绑定资源的必须属性。"),

    /**
     * auth code
     */

    APP_VIEW_BIND_FAILED(30000,"应用绑定领域失败。"),
    APP_VIEW_GET_FAILED(30001,"获取绑定领域失败。"),
    CANNOT_FIND_APP(30002,"网关服务-未找到应用 '%s'。"),
    CANNOT_FIND_BOUND_DOMAIN(30004,"未找到绑定的领域"),
    DELETE_BOUND_VIEW_FAILED(30005,"删除绑定的领域失败"),
    DUPLICATE_APP_DOMAIN_BIND(30006,"应用领域绑定已存在。"),
    CANNOT_FIND_APPS(30007,"网关服务-未找到应用列表 '%s'。"),
    APP_CANNOT_BIND_VIEW(30008,"应用不能绑定领域，用户：'%s' 不是领域：'%s' 的所有者。"),


    /**
     * url pattern
     */
    EXIST_SPECIAL_CHARS(32000,"URL Pattern [%s] 中存在特殊字符 '%s'。"),

    NOT_START_WITH_SLASH(32001,"URL Pattern [%s] 必须以'/'开头。"),

    CANNOT_CONTINUOUS_SLASH(32002,"URL Pattern [%s] 中不能连续'/'。"),

    CANNOT_CONTINUOUS_SLASH_STAR(32003,"URL Pattern [%s] 中不能连续'/*'。"),

    TWO_STAR_ONLY_AT_THE_END(32004,"URL Pattern [%s] 中'**'出现在了非结尾的位置。"),

    CANNOT_END_WITH_SLASH(32005, "URL Pattern [%s] 不能以'/'结束。"),

    WILDCARD_CHARACTER_STAR_INVALID(32006, "URL Pattern [%s] 通配符'*' 不合法, url pattern 中只能使用'*'或'**'。"),

    STAR_CANNOT_REPRESENT_NODE_CODE_AT_NONEND(32007,"URL Pattern [%s] 非末尾'*'不能代表nodeCode。"),

    CANNOT_FOUND_URL_PATTERN_NODE(32008,"无法找到URL Pattern [%s] 中的节点 '%s'。"),

    BATCH_SAVE_URL_PATTERN_FAILED(32009, "批量插入url pattern 失败。"),

    DUPLICATE_URL_PATTERN(32010, "存在重复url pattern [%s] 。"),

    DUPLICATE_URL_PATTERN_RANK(32012, "存在重复url pattern 顺序标识 [%s] 。"),

    NOT_EMPTY_PERMISSION_ENTRIES_FOR_AUTHORIZATION(32013, "url pattern [%s] 至少选择一种权限条目。"),

    RESOURCE_PROXY_TEMPLATE_DELETE_FAILED(34000, "资源代理模板删除失败。"),

    RESOURCE_PROXY_EXISTS_TEMPLATE_DELETE_FAILED(34001, "存在资源代理实例，资源代理模板无法删除。"),
    RESOURCE_PROXY_TEMPLATE_NOT_FOUND(34002, "资源代理模板不存在。"),
    INVALID_DUPLICATE_KEY(34003, "违反主键或唯一约束。"),
    RESOURCE_PROXY_TEMPLATE_CREATE_FAILED(34004, "资源代理模板创建失败。"),
    RESOURCE_PROXY_TEMPLATE_MANIFEST_NOT_FOUND(34005, "资源代理模板声明取得失败。"),
    RESOURCE_PROXY_TEMPLATE_MANIFEST_DOMAIN_NOT_FOUND(34006, "资源代理模板声明的域[%s]不存在。"),
    RESOURCE_PROXY_TEMPLATE_MANIFEST_MODEL_NOT_FOUND(34007, "资源代理模板声明的域[%s]中资源[%s]不存在。"),
    INVALID_RESOURCE_PROXY_TEMPLATE_MANIFEST_MODEL_PROPERTY(34008, "域[%s]中资源[%s]属性与资源代理模板声明的资源属性不一致。"),
    INVALID_RESOURCE_PROXY_TEMPLATE_MANIFEST_MODEL_TYPE(34009, "域[%s]中资源[%s]类型与资源代理模板声明的资源类型不一致。"),
    RESOURCE_PROXY_TEMPLATE_MANIFEST_MODEL_TYPE_NOT_FOUND(34010, "没有与资源代理模板声明的资源类型一致的资源。"),
    INVALID_DUPLICATE_KEY_CODE(34011, "资源代理模板编号已经存在。"),
    INVALID_DUPLICATE_KEY_NAME(34012, "资源代理模板名称已经存在。"),
    INVALID_DUPLICATE_KEY_SERVICE_NAME(34013, "资源代理模板微服务名已经存在。"),

    /**
     * 资源代理
     */
    RESOURCE_PROXY_CREATE_FAILED(35000, "资源代理创建失败。"),

    RESOURCE_PROXY_UPDATE_FAILED(35001, "资源代理更新失败。"),

    RESOURCE_PROXY_GET_FAILED(35002, "资源代理获取失败。"),

    RESOURCE_PROXY_DELETE_FAILED(35003, "资源代理删除失败。"),

    RESOURCE_PROXY_DUPLICATE(35004, "资源代理已存在[%s]。"),

    INVALID_SELECTED_MODEL(35005, "选择的资源[领域：'%s', 资源：'%s'] 与代理模板声明不匹配。"),

    SELECTED_MODEL_REQUIRED(35006, "[%s] 代理模板必须选择资源，但当前为空。"),

    RESOURCE_PROXY_NOT_FOUND(35007, "资源代理不存在。"),

    NO_INTERSECTION_PROPERTY(35008, "选择的资源没有交集属性。"),

    SELECTED_MODEL_TYPE_DOES_NOT_MATCH_MANIFEST(35009, "选择的资源的类型 [领域：'%s', 资源：'%s'] 与代理模板声明的支持资源类型不匹配。"),

    RESOURCE_PROXY_BEING_REFERENCED(35010, "资源代理被引用，不能删除。"),

    CANNOT_FOUND_MODEL(35011, "资源不存在[domainCode: '%s', modelCode: '%s']。"),

    FILE_SET_NOT_SUPPORT(30512, "文件集资源不支持获取数据源配置信息。"),

    /**
     * 资源与资源代理绑定
     */
    MODEL_RP_BINDING_DUPLICATE(36000, "该资源已绑定资源代理 '%s'。"),

    CANNOT_BIND_THE_RP(36001, "该资源不在'%s' 资源代理选择的资源列表中，不能绑定 。"),

    CANNOT_CREATE_RESOURCE(36002, "该资源未发布，不能创建资源 。"),

    RESOURCE_NOT_FOUND(36003, "资源不存在。"),

    RESOURCE_OPERATION_DUPLICATE(36004, "资源操作已存在。"),

    RESOURCE_INDEX_DUPLICATE(36005, "资源索引已存在。"),

    RESOURCE_CODE_DUPLICATE(36006, "资源编码已存在。"),

    RESOURCE_NAME_DUPLICATE(36007, "资源名称已存在。"),

    RESOURCE_PROXYID_DUPLICATE(36008, "资源已绑定相同的资源代理，不能重复绑定。"),

    CANNOT_DELETE_RESOURCE(36009, "该资源被视图 [domainCode: %s, viewName: %s]绑定，不能删除。"),

    DELETE_RESOURCE_FAILED(36010, "删除资源失败。"),

    CANNOT_DELETE_RESOURCE_PROCESS(36011, "该资源被处理 [domainCode: %s, processCode: %s]绑定，不能删除。"),

    CANNOT_BIND_NONSYSTEM_CONN_ENGINE(36012, "领域创建只能绑定系统连接类型的引擎。"),

    CAN_ONLY_USE_SYSTEM_CONN_ENGINE(36013, "正向建模只能使用系统内置的引擎连接。"),

    CAN_ONLY_USE_NONSYSTEM_CONN_ENGINE(36014, "反向向建模只能使用非系统内置的引擎连接。"),

    CANNOT_OVERLAP_EXISTED_MODEL(36015, "资源'%s'已经被反向建模过，只有资源编码'%s'不变才能覆盖。"),

    CANNOT_DELETE_RESOURCE_REFERENCED_BY_SCOPE(36016, "该资源被范围 [domainCode: %s, scope: %s]引用，不能删除。"),



    /**
     * 资源同步RP资源
     */
    CANNOT_SYNC_RP(36100, "该资源的资源代理与参数不一致，不能同步。"),

    UNBOUND_CANNOT_SYNC_RP(36101, "该资源未绑定资源代理，不能同步。"),

    MODEL_SYN_RESOURCE_FAILED(36102, "资源同步资源失败。"),

    PROXY_SERVICE_ERROR(36103, "资源代理服务访问错误: %s。"),

    /**
     * 枚举类型服务失败信息
     */
    ENUM_ELEMENT_NOT_FOUND(37000, "枚举类型元素不存在，[enumCode: '%s', ordinal或value: '%s']"),

    ENUM_TYPE_NOT_FOUND(37001, "枚举定义不存在，[resourceType: '%s'， relation: '%s']"),

    ENUM_TYPE_CODE_NOT_FOUND(37002, "枚举定义不存在，[enumCode: '%s']"),







    /**
     * 认证与授权
     */
    WRONG_USERNAME_OR_PASSWORD(38000, "用户名或密码不正确。"),
    INVALID_TOKEN(38001, "无效的token。"),
    ILLEGAL_ACCOUNT_ACCESS(38002, "当前用户在访问其他用户的数据"),
    UNAUTHORIZED(38401, "未认证。"),// 未认证
    FORBIDDEN(38403, "未授权"),


    /**
     * 源数据迁移
     */
    DATA_MIGRATION_FAILED(39000, "数据迁移失失败, [领域:'%s', 详情：%s"),



    CLOUDT_PROXY_NOT_SURPORT_OPERATION(40001, "T代理支持 %s 操作。"),
    ID_IS_REQURIED_FOR_CLOUDT_PROXY_GET_OPERATION(40002, "T代理GET操作必须传ID filter"),
    CLOUDT_INTERNAL_EXCEPTION(40003, "Cloudt系统内部异常。"),

    ACCESS_GATEWAY_SERVER_EXCEPTION(40200, "访问网关服务异常[message :'%s', url: '%s']。"),

    UNIMPLEMENTED(40500, "接口未实现。"),
    DATABASE_ACCESS_ERROR(40600, "数据库访问错误。"),
    CLOUDT_GATEWAY_ACCESS_ERROR(40700, "cloudt网关访问错误。"),
    
    

    /**
     * 数据处理资源ProcessResource错误码定义
     */
    PROCESS_DUPLICATE(48001, "处理资源已存在。"),
    
    PROCESS_RESOURCES_REL_DUPLICATE(48002, "实时查询资源已存在对应处理资源。"),
    
    PROCESS_TYPE_INVALID(48003, "处理资源类型错误。"),
    
    ROCESS_NOT_ALLOWED_TO_UPDATE_PROPERTY(48004, "不允许更新属性。"),
    
    PROCESS_NOT_FOUND(48404, "处理资源不存在。"),
    
    PROCESS_SCRIPT_ILLEGAL(48405, "处理资源脚本格式错误。"),
    
    
    PROCESS_OUTPUT_RESOURCE_NOT_FOUND(48406, "处理资源的输出资源不存在。"),
    
    PROCESS_OUTPUT_RESOURCE_TYPE_MISMATCH(48407, "处理资源与输出资源类型不匹配。"),

    PROCESS_OUTPUT_RESOURCE_DOMAIN_MISMATCH(48408, "处理资源的输出不属于当前域。"),
    
    CAN_NOT_MODIFIED(60000, "[%s]不可修改"),
    UNIQUE_INDEX_NO_PARTITION_COLUMN(60001, "分区表的唯一索引必须必须包含分区字段。"),
    PARTITION_COLUMN_NOT_SELECTED(60002, "分区表的分区字段不能为空。"),
    PARTITION_COLUMN_MULTI_SELECTED(60003, "分区表的分区字段只能选一个。"),
    PARTITION_COLUMN_NOT_IN_PROPERTY(60004, "分区表的分区字段%s,不在属性列表中。"),
    PARTITION_SUB_TABLE_NOT_SET(60005, "分区表的子表信息必须设置。"),
    PARTITION_SUB_TABLE_EXIST(60006, "分区表的子表[%s]已经存在。"),
    PARTITION_MULTI_DEFAULT_TABLE(60007, "分区表的默认分区只能设置一个。"),
    PARTITION_OVERLAP(60008, "分区表的分区范围不能重叠。"),
    PARTITION_DETAILS_NOT_SET(60009, "分区表的分区信息不能为空。"),
    PARTITION_HASH_SETTING_DEFAULT(60010, "分区表的HASH分区方式不可设置默认分区。"),
    PARTITION_SETTING_DEFAULT_SET_DETAILS_VALUE(60011, "分区表设置为默认分区时，后面其它参数不可填写。"),
    PARTITION_HASH_SETTING_MULTI_DETAIL(60012, "分区表的HASH分区方式只可设置一个分区个数参数。"),
    PARTITION_HASH_SETTING_HASHNUM_INVALID(60013, "分区表的HASH分区方式分区个数必须大于等于1。"),
    PARTITION_COLUMN_CAN_NOT_DELETE(60014, "分区表的分区属性不能删除。"),
    SUB_PARTITION_CODE_CAN_NOT_NULL(60015, "分区表的子表名不能为空。"),
    NO_ACCESS_PERMISSIONS(60016, "没有访问权限。"),
    RESOURCE_TYPE_NOT_SUPPORT(60017, "资源类型[%s]暂不支持。"),
    UNUNIQUE_TO_UNIQUE(60018, "非唯一不可变成唯一。"),
    UNREQUIRED_TO_REQUIRED(60019, "非必须不可变成必须。"),
    COLUMN_CAN_NOT_DELETE(60020, "属性[%s]不能删除。"),

	ILLEGAL_REQUEST(50000, "非法请求。"),
	INTERNAL_SERVER_ERROR(50500, "系统内部错误。"),

    CHECK_PARAM_INDEX_ERROR(50600, "CheckParam 参数索引配置错误。"),
    CHECK_PARAM_TABLE_CODE_NOT_FOUND(50601, "校验参数不能为空。"),
    CHECK_PARAM_ANNOTATION_INVALID(50603, "注解参数不正确。"),
    PARAM_DATA_NOT_FOUND(50604, "数据%s不存在。"),
    PARAM_DATA_EXISTS(50605, "数据%s已经存在。"),
    CHECK_PARAM_BUSINESS_INVALID(50602, "参数业务校验失败。");

    /**
     * Numeric code
     */
    private long code;

    /**
     * Error message
     */
    private String message;

    private APIReturnCode(long code, String message) {
    	this.code = code;
    	this.message = message;
    }

    /**
     * Look up the enum based on error code.
     *
     * @param code
     * @return
     */
    public static APIReturnCode fromCode(long code) {
        for (APIReturnCode current : APIReturnCode.values()) {
            if (current.getCode() == code) {
                return current;
            }
        }
        throw new APIRuntimeException("Invalid error code: " + code);
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
