# Book system

It's a single book management system which has the function of adding, deleting, updating and searching. The system is built using sprintBoot, and the database uses h2database.

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