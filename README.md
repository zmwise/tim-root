# spring cloud 微服务项目(tim-root)

### 项目服务模块
- server-config:spring cloud config 分布式配置中心
- server-eureka:spring cloud eureka 服务注册与发现
- server-gateway:spring cloud gatewary 网关服务
- common-dao:数据模型层（Dao、Entity、Mapper生成）
- common-dto:数据交互层（VO、PO、BO、DTO等）
- service-user:用户服务提供者（用户注册、登录、权限等）
- operation-system:运营系统（服务消费者）

### 集成技术
- spring
- spring mvc
- spring boot
- spring boot actuator（暂时未用）
- spring cloud config
- spring cloud eureka
- spring cloud feign
- spring cloud hystrix
- spring cloud ribbon
- spring cloud zuul
- mybatis plus
- redis
- druid

## 快速开始（运行前提条件）
1.安装redis、配置redis（server-config项目的resources/config/application.yml）
2.创建数据库执行demo.sql
3.server-config项目的resources/config下面的文件复制到D:\\server-config\\config-files下面作为公共配置
4.项目导入IDEA中、按spring boot项目启动方式启动项目
  启动顺序基本先启动server-config、server-eureka、service-user、operation-system、server-eureka
5.目前实现了分布式配置、服务注册与发现、消费者调用服务提供者提供的查询用户服务、基本已经可以在该项目上进行开发了，其它功能后续完善

## 开发建议
- 【创建表】表名建议使用小写，多个单词使用下划线拼接，新表表字段统一采用驼峰式命名，旧表保持原来用户"_"分隔
- 【对象使用】生成的实体对象不可当业务对象使用po,bo,dto,pojo等,Entity内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解
- 【业务代码位置】涉及到非查询操作业务请放业务实现类中
- 【事物使用】在业务层实现类中存在非查询操作请添加相应事务
- 【API数据传递格式】所有API接口请求响应数据都采用JSON格式(除特殊情况)
- 【业务异常处理】建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 【公共工具使用】需要工具类的话建议先从```tim-utils```中找，实在没有再造轮子或引入类库，尽量精简项目
- 【代码规范】开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://github.com/lihengming/shared-files/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8Cv1.2.0.pdf))
- 【API文档】建议在公司内部使用[ShowDoc](https://github.com/star7th/showdoc)、[SpringFox-Swagger2](https://github.com/springfox/springfox) 、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档
- 【系统状态码】除HttpStatus所有状态,系统业务状态码从1000开始,不同的业务代码请以100递增（如：1100，1200等）
