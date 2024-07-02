# 밋업 활동을 통한 리팩토링 연습
***
> - Han: 2024.05.21 Supermarket  
> [슈퍼마켓 리팩토링 링크](https://github1s.com/HanSeongDeok/Refactoring_Practice/blob/master/src/main/java/org/example/refactoring3/supermarketreceipt/supermarket/model/ShoppingCart.java)
1. 반복되는 Switch/Case 냄새 -> 반복문 안에 If/else 구조가 들어가 있음
2. 불친절한 변수명 -> 'x' 와 같은 의미를 알 수 없는 변수명이 들어있음
3. 긴 함수 -> handleOffers 메서드는 길고 복잡합니다. 여러 가지 로직이 혼재되어 있어 가독성이 떨어짐
4. 중복 코드 -> offer 타입을 확인하는 여러 if 블록이 중복된 코드가 있음
5. 데이터 뭉치 냄새 -> receipt, offers, catalog와 같은 많은 매개E변수를 가지고 있다.