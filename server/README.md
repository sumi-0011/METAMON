# metamon_server
메타버스 신분증
# [TEAM M] MetaMon Server repo
 
이 Repository는 "메타버스 신분증 서비스" 의 백엔드를 담당하는 Repository 입니다. 

다음과 같은 기능이 포함되어 있습니다. 

- MetaMon 서비스 회원가입
- MetaMon 서비스 로그인
- MetaMon 서비스 마이페이지 조회
- 회원가입을 위한 이메일 인증 요청
- MetaMon 서비스 신분증 이미지 업로드
- MetaMon 서비스 신분증 조회

## 프로젝트에서 사용한 기술 

본 Repository는 `build.gradle` 에 있는 오픈소스 패키지를 사용하였습니다.

또 다음 Code Snippet 이 포함되어 있습니다.

- [QR 코드 생성](https://shanepark.tistory.com/394)
- [S3에 이미지 업로드](https://www.sunny-son.space/spring/Springboot%EB%A1%9C%20S3%20%ED%8C%8C%EC%9D%BC%20%EC%97%85%EB%A1%9C%EB%93%9C/)

[참고] 위 오픈소스 및 Code Snippet 첨부는 부정행위 방지를 위한 것이며, 개발에 있어 유의미한 소스만 첨부해 주셔도 괜찮습니다.


## Dev Server 실행 방법

1. 본 Repository를 로컬 환경에 Clone 받습니다.
2. `./gradlew clean build` 로 필요한 패키지를 설치와 빌드 파일을 생성합니다.
3. MySQL RDS 환경이 접속 가능한지 확인합니다.
4. nohup java -jar ./build/libs/metamon-0.0.1-SNAPSHOT.jar > server-ver2.log 2>&1 & 명령어를 실행하여 백그라운드에서 동작하게 합니다.


[참고] Dev Server 실행 방법은 부정행위 방지를 위한 사후 발표 자료와의 대조를 위한 것이며, 임원진이 검증 가능한 정도로 작성해 주셔도 괜찮습니다.

## Production 배포 방법

1. Ubuntu 20.04 환경의 서버를 준비합니다.
2. 본 Repository를 로컬 환경에 Clone 받습니다.
3. Dev 실행 방법과 동일합니다.

[참고] Dev Server 실행 방법은 부정행위 방지를 위한 사후 발표 자료와의 대조를 위한 것이며, 임원진이 검증 가능한 정도로 작성해 주셔도 괜찮습니다. 또한, 이후 해커톤 홍보를 위한 데모의 목적으로 활용될 수 있습니다.


## 환경 변수 및 시크릿
1. 필요한 환경 변수는 `src/main/resourses/application.yml` 에 명시되어 있습니다.

## 기타
- api server
- https://docs.google.com/spreadsheets/d/1fpKc3fHqVRKMT0XforTMapp1OD0ZxwcWD-95hKU4hCw/edit?usp=sharing
