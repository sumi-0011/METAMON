# [TEAM M] metamon_app

해당 레포지토리는 M팀으 안드로이드 레포지토리입니다.

다음과 같은 기능이 포함되어 있습니다.
- 로그인 기능
- 카메라, 사진 업로드 (메타버스 플랫폼 내 사진)
- 마이페이지
- 메타버스 플랫폼 별 상세 정보 확인 (qr이미지, 닉네임 등) 


## 프로젝트에서 사용한 기술

- 클린 아키텍처
- Hilt
- Jetpack DataBinding, Navigation, Security 등


## 실행 방법

안드로이드 스튜디오로 해당 프로젝트를 클론 받습니다.
local.properties 파일에 다음을 추가합니다.
```
METAMON_SERVER_BASE_URL_DEBUG="~~~"
METAMON_SERVER_BASE_URL_RELEASE="~~~"
AWS_ACCESS_KEY="~~~"
AWS_SECRET_KEY="~~~"
AWS_S3_BUCKET_NAME="~~~"
```

## 환경 변수 및 시크릿

```
METAMON_SERVER_BASE_URL_DEBUG="~~~"
METAMON_SERVER_BASE_URL_RELEASE="~~~"
AWS_ACCESS_KEY="~~~"
AWS_SECRET_KEY="~~~"
AWS_S3_BUCKET_NAME="~~~"
```
