### 자바 1회차 과제입니다.
아래 사항들을 구현했습니다.

[필수미션]
- 가렌 / 애쉬 등 챔피언을 기반으로한 클래스 2개 생성 후 상태(필드변수) / 행위(메서드) 지정하기 (캡슐화)
- 유사한 성격을 가진 메서드를 모아 추상 클래스로 묶어보기(추상화)
- 기존 클래스에 상속 후 코드 수정하기(상속)
- 다형성을 활용하여 메서드 설정 및 main함수에서 모의 전투 롤플레잉 (다형성)

[추가미션]
- 레벨업 메서드를 만들어 체력·공격력 증가하게 해보기
- takeDamage 후 체력이 0 이하가 되면 “가렌 사망!” 메시지 출력
- attackDamage 값을 난수(랜덤)로 만들어 “치명타 개념” 추가해보기
- Q/W/E/R 스킬을 모두 추상 메서드로 확장해보기
- “치명타 확률” 같은 고유 패시브를 메서드로 추가해보기

### 자바 2회차 과제입니다.
# [필수 미션] — 오늘 배운 개념을 반드시 활용하기

### 1. **챔피언의 기본 스탯을 GameConstants로 분리하기**

- 각 챔피언이 가지고 있던

  `기본 체력`, `기본 공격력`, `기본 방어력` 값을

  **GameConstants의 static final 상수**로 이동시킵니다.

- 챔피언 생성 시 해당 상수를 사용하도록 변경하세요.

---

### 2. **전투 횟수(static) 카운팅 기능 추가**

- 챔피언 생성 횟수와 별도로

  전투가 발생할 때마다 증가하는

  **static 변수 battleCount** 를 추가합니다.

- 평타/basicAttack() 또는 스킬 사용 시 battleCount 증가하도록 로직 추가.

---

### 3. **고정된 부활(resurrect) 규칙을 final 메서드로 만들기**

- 모든 챔피언은 동일한 방식으로만 부활하게 만들어야 합니다.
- `final void resurrect()` 메서드를 Champion 추상 클래스에 추가하고

  체력 1 혹은 기본 체력의 20% 회복 등,

  **고정된 규칙** 하나를 구현하세요.

- 자식 클래스에서 이 메서드를 오버라이드하지 못해야 합니다

# [선택 미션] — 조금 더 고민해보고 확장하기

### 1. **공통되지 않는 ‘부활 조건’은 어떻게 분리할까?**

- 부활 규칙(resurrect)은 고정이지만

  “부활할 수 있는 조건(예: 쿨타임, 1회 제한)”은 챔피언별로 다를 수 있다.

- 이 조건을 **추상 메서드**로 분리하거나

  **전략 패턴(Strategy)** 으로 나누는 방식 고민해보기.

### 2. **전투 로그를 static 중첩 클래스로 만들어보기**

- `Champion.Log` 같은 형태로

  **static nested class**를 만들어

  전투 메시지를 모아두는 기능을 구현해보세요.

### 3. **상수 그룹을 Enum으로 표현해보기**

- "챔피언 타입"이나 "속성(체력/공격/방어)" 같은 값을

  **enum + 상수 조합**으로 표현해보는 확장 미션.

### 4. **부활(resurrect) 메서드를 템플릿 메서드 패턴으로 확장해보기**

- final 메서드 내부에서

  “부활 시 부가 효과(예: 버프 적용)”를

  hook 메서드로 제공해보고

  자식 클래스에서만 다르게 구현하도록 제한해보기

# [필수 미션] - 랜덤 1:1 전투 시뮬레이션

이제 서로의 팀에서 랜덤한 챔피언 하나씩 꺼내 싸우게 해보자.
### 예시: 랜덤 전투 메서드

```java
public class Battle {

    private static Random random = new Random();

    public static void oneVsOne(Team<Champion> t1, Team<Champion> t2) {

        Champion c1 = randomPick(t1.getMembers());
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("\n===== 1:1 전투 시작 =====");
        System.out.println(c1.getName() + " vs " + c2.getName());

        c1.basicAttack(c2);
        c2.basicAttack(c1);

        c1.useQ(c2);
        c2.useQ(c1);
    }

    private static Champion randomPick(List<Champion> list) {
        return list.get(random.nextInt(list.size()));
    }
}
```

# [선택 미션]

### **1. 제네릭 와일드카드(? extends Champion) 적용해보기**

### 미션 내용

- 아래 메서드를 설계하세요.

```java
public static void printTeamMembers(List<? extends Champion> team)
```

- `List<Garen>` , `List<Champion>` 모두 받을 수 있어야 합니다.

---

### 2. **잘못된 제네릭 설계 사례 만들고 고쳐보기**

### 미션 내용

- 아래와 같은 잘못된 설계를 먼저 작성합니다.

```java
public class Team<T> {
    private List<T> members;
}
```

- 왜 이 설계가 위험한지 설명한 뒤 T extends Champion 으로 수정하세요.

T는 모든 타입을 받을 수 있다. 그래서 String, Integer, Champion과 같은 모든 타입들이 들어 올 수 있다. 과제에서는 Team에 Champion만이 들어오도록 하기 때문에
extends를 사용하여 타입을 한정짓는 것이 더 안정적이다.