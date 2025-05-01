src/main/kotlin/com/yourcompany/yourproject
├── domain                 # 순수 비즈니스 로직
│   ├── model              # Entity, Value Object
│   ├── service            # 도메인 서비스 (복합 비즈니스 로직)
│   └── repository         # Port(Interface) 정의
│
├── application            # 유즈케이스 계층 (시나리오)
│   ├── port
│   │   ├── in             # UseCase 인터페이스 (예: CreateOrderUseCase)
│   │   └── out            # 도메인 레포지토리 Port 재정의
│   ├── service            # Port 구현체(도메인 → 인프라 연결)
│   └── dto                # 입력/출력 데이터 전송 객체
│
├── adapter                # 외부 인터페이스 어댑터
│   ├── in
│   │   └── web            # REST/Web 계층
│   │       ├── controller # Controller 클래스
│   │       └── dto        # Request/Response DTO
│   └── out
│       └── persistence    # 영속성 계층
│           ├── mybatis
│           │   ├── mapper         # MyBatis Mapper 인터페이스 (.kt + XML 매핑 파일)
│           │   └── record         # DB 레코드용 데이터 클래스 (optional)
│           └── mapper             # Record ↔ Domain 변환기
│
├── config                 # Spring 설정 클래스 (ex. MyBatisConfig, WebConfig)
└── common                 # 예외, 유틸, 공통 DTO 등