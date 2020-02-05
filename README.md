# SpringBoot整合JDBC 
###### 原文链接：https://www.cnblogs.com/hellokuangshen/p/11331338.html
## MySQL
1.  **运行MySQL服务**    
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580726471676.png)
2.  **数据库mybatis下执行以下建表语句新建user表**    
```
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'A', '1');
INSERT INTO `user` VALUES (2, 'B', '2');
INSERT INTO `user` VALUES (3, 'C', '3');
INSERT INTO `user` VALUES (5, 'E', ' 5');

SET FOREIGN_KEY_CHECKS = 1;
```
## IDEA    
1. **新建项目，选择Spring Web，JDBC API与MySQL Driver。**
2. **IDEA-Database配置**      v
- 右侧Database新建MySQL连接，填入用户名密码
- Advanced中时区要设置
- Schemas中选择一个数据库
- 点击OK，在Database中即可实时看到数据库的变化
3. **application.yml中配置应用的MySQL连接**    
```
spring:
  datasource:
    username: root
    password: chen
    url: jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC
    driver-class-name: com.mysql.cj.jdbc.Driver
```
4. **测试连接**      
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580735838609.png)
5.  **编写controller实现对数据库的CRUD操作**      
- *注入JdbcTemplate，对数据库进行操作*      
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580737818709.png)
-  *查询user表中的所有数据*  
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580737782045.png)
- *为user表插入一条数据*    
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580738206114.png)
- *修改user表中的一条数据*    
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580738324865.png)
- *删除user表中的一条记录*       
![enter description here](http://q5053ip41.bkt.clouddn.com/xsj/1580738418696.png)
