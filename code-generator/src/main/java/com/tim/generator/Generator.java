package com.tim.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: mybatis-plus代码生成器(用于生成entity)<br>
 * @author: lizhiming
 * @since: 2017/11/10
 */
public class Generator {

    protected static Logger LOGGER = LoggerFactory.getLogger(Generator.class);

    private static final String TAB_PREFIX = "t_";

    private static final String UNDER_LINE = "_";

    public static void main(String[] args) {
        String[] models = {"code-generator"};
        /**
         * 更改此参数为生成代码的表名称,可一次性生成多个表
         */
        String[] tables = {
                "sys_role","sys_resource"
        };

       for (String table : tables) {
            shell(models[0], table);
        }
        System.out.println("【MybatisPlus代码生成器】代码生成完成！！！");

    }

    /**
     * 生成代码相关配置
     * @param model
     * @param tabName
     */
    private static void shell(String model,String tabName){
        File file = new File(model);
        String path = file.getAbsolutePath()+"\\src\\main\\java";
        String xmlPath = file.getAbsolutePath()+"/src/main/resources/mapper";

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //这里写你自己的java目录D://Generator//
        gc.setOutputDir(path);
        //是否覆盖
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(false);
        gc.setAuthor("lizhiming");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/tim-db?characterEncoding=utf8&useSSL=false");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        //strategy.setTablePrefix(new String[] { "t_" });
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(new String[] { tabName });
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        String tabPackage = getName(tabName,UNDER_LINE);

        pc.setParent("com.tim");
        pc.setEntity("entity"+tabPackage);
        pc.setMapper("dao"+tabPackage);
        pc.setXml("xml"+tabPackage);
        pc.setService("service"+tabPackage);
        pc.setServiceImpl("serviceImpl"+tabPackage);
        pc.setController("web"+tabPackage);
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(16);
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return  xmlPath+ getXmlUrl(tabName,UNDER_LINE) + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //多模块
        TemplateConfig tc = getTemplateConfig(xmlPath, gc, pc, model, tabName, false);
        if (tc.getMapper() == null && tc.getXml() == null && tc.getService() == null &&
                tc.getServiceImpl() == null && tc.getController() == null && tc.getEntity() == null) {
            return;
        }
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        System.out.println("【MybatisPlus代码生成器】当前生成完成代码的表名>>"+tabName);

        // 打印注入设置
        //System.err.println(mpg.getCfg().getMap().get("abc"));
    }

    /**
     * 控制包生成的路径与是否覆盖生成
     * @param gc 全局配置
     * @param pc 包配置
     * @param model model名
     * @param tabName 表名
     * @param isCover 是否覆盖生成代码
     * @return TemplateConfig
     */
    private static TemplateConfig getTemplateConfig(String xmlPath, GlobalConfig gc,  PackageConfig pc, String model, String tabName, boolean isCover) {
        TemplateConfig tc = new TemplateConfig();
        String entity = getEntityName(tabName,UNDER_LINE);

        File file = new File(model);
        String path = file.getAbsolutePath()+"/src/main/java/" + replace(pc.getParent());
        if (!isCover) {
            if ("code-generator".equals(model)) {
                String mapperPath = path + "/" + replace(pc.getMapper()) + "/" + gc.getMapperName().replace("%s",entity) + ".java";
                if (isExists(mapperPath)) {
                    tc.setMapper(null);
                    System.out.println("【MybatisPlus代码生成器】"+gc.getMapperName().replace("%s",entity) + ".java 文件已存在");
                }
                String mapperXmlPath = xmlPath + "/" + getXmlUrl(tabName,UNDER_LINE) + "/" + gc.getXmlName().replace("%s",entity) + ".xml";
                if (isExists(mapperXmlPath)) {
                    tc.setXml(null);
                    System.out.println("【MybatisPlus代码生成器】"+gc.getXmlName().replace("%s",entity) + ".xml 文件已存在");
                }
                tc.setXml(null);
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            }
        } else {
            if ("code-generator".equals(model)) {
                tc.setXml(null);
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            }
        }
        return tc;
    }

    /**
     * 根据驼峰命名，首字母大写
     * @param tabName 原名
     * @return 返回生成后的名字
     *  例如：t_user_info 返回 UserInfo
     */
    public static String getEntityName(String tabName, String reChar) {
        if(tabName.contains(TAB_PREFIX)){
            tabName = tabName.substring(2);
        }
        String[] arr = tabName.split(reChar);
        String str = "";
        for (int i = 0; i < arr.length; i++ ) {
            String startChar = arr[i].substring(0,1).toUpperCase();
            String lastChar = arr[i].substring(1, arr[i].length());
            String newStr = startChar + lastChar;
            str += newStr;
        }
        return str;
    }

    /**
     * 根据表名返回包名（包分类）
     * @param tabName 原名
     * @return 返回生成后的包路径名
     *  例如：t_user_bank 返回 .user.bank
     */
    public static String getName(String tabName, String reChar) {
        if(tabName.contains(TAB_PREFIX)){
            tabName = "." + tabName.substring(2).replaceAll(reChar,".");
        }else {
            tabName = "." + tabName.replaceAll(reChar,".");
        }
        return tabName;
    }

    /**
     * 根据表名返回XML文件路径地址
     * @param tabName 原名
     * @return 返回生成后的XML文件路径地址
     *  例如：t_user_bank 返回 /user/bank/
     */
    public static String getXmlUrl(String tabName, String reChar) {
        if(tabName.contains(TAB_PREFIX)){
            tabName = "/" + tabName.substring(2).replaceAll(reChar,"/") + "/";
        }else {
            tabName = "/" + tabName.replaceAll(reChar,"/") + "/";
        }
        return tabName;
    }

    /**
     * 判断文件是否存在
     * @param path 路径
     * @return
     */
    private static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 将点替换为斜杠
     * @param name
     * @return
     */
    private static String replace(String name) {
        return name.replace(".","/");
    }
}