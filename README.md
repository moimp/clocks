# Clock Library
* Clock Library는 시간에 의존적인 코드를 테스트하기 위해 존재합니다.
* 시시각각 변하는 시간을 원하는 값으로 고정시켜 특수한 상황을 제어합니다.
* Clocks의 freeze()는 Elsa 에서만 접근 가능합니다.

<br/>

**🕰 clock**은 프로덕션에서 사용합니다.   
**❄️ clock-frozen**은 테스트 코드에서 사용합니다.

<br/>

**How To Use [clock-frozen] In TestCode**
```
[EX]
    @BeforeEach 
    void setUp() {
        Elsa.freeze(purchasedAt); 📍 테스트를 위해 원하는 시간을 고정시킵니다.
        member = factory.create(USER, MEMBERSHIP, purchasedAt);
    }

    @AfterEach
    void tearDown() {
        Elsa.rollback(); 📍 고정시켰던 시간을 되돌립니다.
    }

```

<br/>

**How To Use [clock] In Code**
```
[EX]
        public MemberInfoChangeCommand create(ClubInfoChangedEvent event) {

            MemberInfoChangeCommand command = new MemberInfoChangeCommand();
            command.setMembershipId(event.getMembershipId));
            command.setClub(event.getClub);
            command.setMeetings(event.getMeetings);
            command.setEventedAt(Clocks.now()); 📍 Clocks의 LocalDateTime.now()을 사용합니다.

        return command;
    }

```

