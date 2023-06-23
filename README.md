# Book system

实现了一个简单的图书管理系统，包含添加、删除、更新、查找的功能。系统使用SpringBoot进行搭建，数据库采用h2 database。使用swagger提供了restful 接口。系统暂无图形界面。

It's a single book management system which has the function of adding, deleting, updating and searching. The system is built using sprintBoot, and the database uses h2database.

## 如何使用
1、确保安装java且java版本号为1.8。
2、安装 [Maven](https://maven.apache.org/)。
3、命令行执行`mvn spring-boot:run`。
4、访问 http://localhost:9090/swagger-ui.html 即可调试接口。请注意第一次登录时需要先注册才能登录。

## how to use

1. Install java and make sure the java version is 1.8.
2. Install [Maven](https://maven.apache.org/).
3. use `mvn spring-boot:run`.
4. visit http://localhost:9090/swagger-ui.html.Note When you log in for the first time, you need to register before logging in.

#### 1. 图书书目表Book
| 名           | 类型     | 用途     | 键   |
| :----------- | :------  | --------| ---- |
| id           | bigint   | id      | ✔    |
| name         | varchar  | 书名    |      |
| price        | float    | 价格    |      |
| type         | varchar  | 分类    |      |

#### 2. 用户表User
| 名       | 类型     | 用途   | 键   |
| :------- | :------ | ------ | ---- |
| username | bigint  | 账号   | ✔    |
| password | varchar | 密码   |      |