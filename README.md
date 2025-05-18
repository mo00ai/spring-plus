# SPRING PLUS

실무 중심의 고급 백엔드 기술을 적용하며, 신뢰성과 성능을 고려한 개발 역량을 강화하는 목적의 프로젝트입니다.
사용 기술: Java 17, Spring Boot, JPA, QueryDSL

---

# 커밋 이력 설명 ( 꼭 봐주세요!)
- 생각 없이 개발하느라 커밋 메시지 확인이 어렵습니다 ㅜㅜㅜㅜ..

### refactor : lv 3 jpql 수정 완료
- 레벨 1-1 : @Transational의 이해
  - TodoService.java
- 레벨 1-2 : JWT 이해
  - JwtFilter.java
  - User.java
- 레벨 1-3 : JPA 이해
  - TodoSearchCond.java
  - TodoController.java
  - TodoService.java
  - TodoRepository.java
 
### refactor : todo 컨트롤러 테스트 수정
- 레벨 1-4 : 컨트롤러 테스트의 이해
  - TodoController.java
  - TodoContollerTest.java
 
### refactor : lv1-5 aop 수정 완료
- 레벨 1-5 : AOP의 이해
  - AdminAccessLoggingAspect.java

### refactor : lv1-6 cascade 수정 완료
- 레벨 2-6 : JPA Cascade
  - Todo.java
 
### refactor : lv1-7 n+1문제 해결(repository에 join 뒤 fetch 추가)
- 레벨 2-7 : N+1
  - CommentRepository.java
 
### refactor : lv1-8 querydsl로 투두 단건 조회
- 레벨 2-8 : QueryDSL

### feat : lv2-9 spring security 적용
- 레벨 2-9 : Spring Security

### Merge pull request #1 from mo00ai/mandatory/lv1
- 죄송합니다.. 실수로 머지해서 커밋 메시지 내역이 다 묶였어요
- 3-10 QueryDsl 사용하여 검색 기능 만들기
- 3-11 Transaction 심화

---

# 주요 초점

JPA 심화
- 효율적인 데이터베이스 설계 및 JPA 내부 동작 이해
- QueryDSL을 통한 동적 쿼리 작성과 실무 활용 패턴 적용

테스트 코드 수정
- 단위 테스트와 통합 테스트를 활용해 안정적인 코드 구조 구축
- 테스트를 통한 사전 오류 방지 및 리팩터링 기반 마련

성능 최적화
- 쿼리 최적화와 리소스 효율화를 통한 성능 개선
- 실무에서 요구되는 응답 속도와 처리량에 대한 고려

---


