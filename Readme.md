##liziyuan-user-operate-log-manager(日志管理服务)  
###代码结构说明
1：公共模块：log-manager-server-core  
2：数据库操作模块：log-manager-server-das  
3：业务逻辑模块：log-manager-server-service  
4：控制层模块：log-manager-server-api
5：日志收集模块：log-manager-server-collector
6：日志处理模块：log-manager-server-processor
###pom文件引包规
1：通用的jar包引入，放在log-manager-server-core模块下  
2：只有某个模块用到的jar包引入，放在对应的模块下，比如applo相关的jar只有web模块用到，就将该jar在web模块引入  
3：所有引入jar包的版本需要以变量的形式生命在<properties>中  
###数据库表设计
 script/log-manager-server_1.0.0.sql
###数据库脚本
1：每个版本都对应一个单独的数据库脚本文件，版本从1.0.0开始，1.1.0版本的脚本在1.0.0的基础上执行，  

###系统架构图可参考  - 用户日志操作日志-流程设计.png

### logstash配置,安装方法可在网上搜索，进行日志收集并发送日志信息到kafka
input {
    file {
        path => ["../user-operate-logs/*"]
    }
}

filter {
}
output {
   stdout {}
   kafka {
    bootstrap_servers => "127.0.0.1:9092"    #生产者
    topic_id => "liziyuan-sys-log-logstash-topic"    #设置写入kafka的topic
    codec => json 
  }
}


### 子系统如何进行集成和配置
一、引用相关依赖
修改pom文件，增加相关依赖，如果有冲突则根据子系统进行排除
<!--增加用户日志收集依赖-->
<dependency>
    <groupId>com.liziyuan.hope</groupId>
    <artifactId>log-manager-server-collector</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>

二、添加配置文件,operate-log-collector.properties
##配置如下
## 设置默认系统模块名-必填项，名称必须在枚举类内，参考com.liziyuan..hope.log.manager.core.enums.SysModelTypeEnum
## 系统模块名称枚举：数据资源、数据集成、数据质量、数据标准、控制台、系统管理、数据标签管理
defSysModelName=数据质量

## 用户操作日志文件写入path,默认为"../user-operate-logs/"
userOperateLogPath=../user-operate-logs/

## 是否输出操作日志,默认是不输出，true是输出
operateLogSystemOut=true

## 配置 api-method 操作映射关系
## 结构为 "方法全路径(all path of controller.method)=操作类型#操作对象#对应模块名(非必填-模块名如不填写，则取defSysModelName设置对默认系统模块名),如果结构不正确，则不进行处理
## 操作类型：必填，枚举类型-新增、删除、编辑、执行
## 操作对象：必填，如数据集、领域、集成任务、数据源、标签等关键操作
## 对应模块：非必填，填写的模块名必须为上面SysModelTypeEnum的一种，如不填写，则取defSysModelName设置对默认系统模块名

## 开始配置
com.liziyuan.hope.web.controller.VerifyController.addTask=新增#任务
com.liziyuan.hope.web.controller.VerifyController.delTask=删除#任务
com.liziyuan.hope.web.controller.VerifyController.editTask=编辑#任务
com.liziyuan.hope.web.controller.VerifyController.executeVTask=执行#任务

