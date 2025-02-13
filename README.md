## Spring Framework Project
- 프로젝트 세팅
- 로그인/로그아웃
- 회원가입
- 목록조회
- 회원수정
- 중복아이디 체크


## 개발환경
- IntelliJ IDEA
- jdk 11
- mysql
- mybatis
- jsp
- tomcat 9.0.98


## 진행과정
- 회원가입
- DB연동(root-context.xml)
- root-context gitignore처리
- 로그인(http session 활용)
- ..ing

## 현재상황(계속 올릴거)
- 400에러
- 98124bce 여기 버전으로 돌려야함 

## 화면
메인화면<br>
![Image](https://github.com/user-attachments/assets/66c5c81f-3490-49f5-9292-df577c058695)
<br>
회원가입&중복체크<br>
![Image](https://github.com/user-attachments/assets/c763d315-b365-47fa-89aa-6d2c34448cc7)
<br>
로그인<br>
![Image](https://github.com/user-attachments/assets/d3bd1358-c63d-4a5f-a95e-01bfed16c5aa)
<br>
회원수정<br>
![Image](https://github.com/user-attachments/assets/b4d51ecb-2d30-4b98-ba67-26d2fcce86de)


```sql
show databases;

use db_khdev;


create table board_table(
    id bigint primary key auto_increment,
    boardWriter varchar(50),
    boardPass varchar(20),
    boardTitle varchar(50),
    boardContents varchar(500),
    boardCreatedTime datetime default now(),
    boardHits int default 0,
    fileAttached int default 0
);

show tables;

create table board_file_table
(
    id	bigint auto_increment primary key,
    originalFileName varchar(100),
    storedFileName varchar(100),
    boardId bigint,
    constraint fk_board_file foreign key(boardId) references board_table(id) on delete cascade
);

show tables;

create table comment_table(
    id bigint primary key auto_increment,
    commentWriter varchar(50),
    commentContents varchar(200),
    boardId bigint,
    commentCreatedTime datetime default now(),
    constraint fk_comment_table foreign key (boardId) references board_table(id) on delete cascade
);

show tables;



```

## 글쓰기 기능

### 페이징<br>
![Image](https://github.com/user-attachments/assets/84c55442-3fa5-4855-b918-a29ed4a387e1)<br>

### 수정
![Image](https://github.com/user-attachments/assets/ec9eb018-249c-46a4-b2af-b724acde1e69)