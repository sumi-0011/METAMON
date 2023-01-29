# [TEAM M] [METAMON](http://metamon.hackathon.sparcs.org/)


내 정체성을 지켜주는 메타버스 신분증


- METAMON 회원가입 기능
- METAMON onboarding
- METAMON 소개 및 사용방법 

## 프로젝트에서 사용한 기술

- Next.js
- React.js
- Typescript
- styled-component
- axois
- framer-motion

## Dev Server 실행 방법

yarn 사용시

```
$ yarn
$ yarn dev
```

## Production 배포 방법

- next.config.js 설정  

next.config.js

```
/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  images: {
    unoptimized: true,
  },
};

module.exports = nextConfig;


```

- `yarn build`를 이용하여 빌드
- 빌드 결과물을 aws s3 bucket에 upload
- 정적 페이지 호스팅을 이용해 배포

## 환경 변수 및 시크릿
`next.config.js`

## 기타

- 디자인 파일 : `public/static` 경로에 존재
- 기획/와이어 프레임 : https://www.figma.com/file/qsVapr2EEYQYCo9wyHFT55/METAMON?node-id=0%3A1&t=FxrtNIy4eQJcMCDh-0
