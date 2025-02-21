## Typescript

-   자바스크립트의 슈퍼셋 오픈소스 프로그래밍 언어
-   마이크로소프트에서 개발 및 유지보수를 담당하여 엄격한 문법을 지원
-   컴파일러 제공으로 정적 타입을 지원하여 프로그래밍의 안정성을 높여줌

### 개발환경 구축

-

```bash
npm install -g typescript
tsc --version
```

-   파일의 ㅣ확장자 명을 .ts로 작성
-   .ts 파일을 .js파일로 트랜스파일링 후 실행

```bash
tsc 파일명.ts
node 파일명.js
```

-   기본적인 방식으로 트랜스파일링을 하면 ES5로 변환됨
-   타입스크립트 컴파일 설정을 위해서 tsconfig.json

```bash
tsc --init
```

-   타입스크립트를 바로 실행하기 위해서 ts-node 패키지 사용 가능

```bash
npm install -g ts-node
ts-node 파일명.ts
```
