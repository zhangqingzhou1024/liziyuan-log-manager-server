-- 第一步先创建数据库，库名：sys_log_manager

-- 第二步创建相关数据表
CREATE TABLE public.user_operate_log (
    id bigserial NOT NULL, -- 主键
    user_id int8 NULL, -- 用户id，目前系统中获取不到，用来备用
    user_account varchar NOT NULL, -- 用户账号
    user_name varchar NOT NULL, -- 用户名称
    sys_model_id int8 NOT NULL, -- 子系统模块Id
    sys_model_type varchar NOT NULL, -- 子系统模块名称，系统枚举值
    operate_time timestamp(0) NOT NULL DEFAULT now(), -- 操作时间
    operate_type_id int8 NOT NULL, -- 操作类型Id
    operate_type varchar NOT NULL, -- 操作类型，枚举类型-新增(insert)、删除(delete)、编辑(edit)、执行(execute)
    operate_object varchar NOT NULL, -- 操作对象
    request_url varchar NULL, -- 请求url
    request_type varchar NULL, -- 请求类型，POST、PUT、DEL等
    request_method varchar NULL, -- 请求方法路径
    request_params varchar NOT NULL, -- 请求参数
    remark varchar NULL, -- 备注说明
    insert_time timestamp(0) NOT NULL DEFAULT now() -- 入库时间
);
COMMENT ON TABLE public.user_operate_log IS '用户操作日志表';

-- Column comments

COMMENT ON COLUMN public.user_operate_log.id IS '主键';
COMMENT ON COLUMN public.user_operate_log.user_id IS '用户id，目前系统中获取不到，用来备用';
COMMENT ON COLUMN public.user_operate_log.user_account IS '用户账号';
COMMENT ON COLUMN public.user_operate_log.user_name IS '用户名称';
COMMENT ON COLUMN public.user_operate_log.sys_model_id IS '子系统模块Id';
COMMENT ON COLUMN public.user_operate_log.sys_model_type IS '子系统模块名称，系统枚举值';
COMMENT ON COLUMN public.user_operate_log.operate_time IS '操作时间';
COMMENT ON COLUMN public.user_operate_log.operate_type_id IS '操作类型Id';
COMMENT ON COLUMN public.user_operate_log.operate_type IS '操作类型，枚举类型-新增(insert)、删除(delete)、编辑(edit)、执行(execute)';
COMMENT ON COLUMN public.user_operate_log.operate_object IS '操作对象';
COMMENT ON COLUMN public.user_operate_log.request_url IS '请求url';
COMMENT ON COLUMN public.user_operate_log.request_type IS '请求类型，POST、PUT、DEL等';
COMMENT ON COLUMN public.user_operate_log.request_method IS '请求方法路径';
COMMENT ON COLUMN public.user_operate_log.request_params IS '请求参数';
COMMENT ON COLUMN public.user_operate_log.remark IS '备注说明';
COMMENT ON COLUMN public.user_operate_log.insert_time IS '入库时间';