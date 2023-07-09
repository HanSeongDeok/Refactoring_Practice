package org.example.codesmell.dataclumps.example.example_two.solution2;

/**
 * 추상화 빌더 패턴이 적용된 인터페이스
 */
public interface IFactorySolutionTwo{
    IFactorySolutionTwo setCustomerAddress(String customerAddress);
    IFactorySolutionTwo setCustomerName(String customerName);
    IFactorySolutionTwo setItemName(String itemName);
    IFactorySolutionTwo setQuantity(int quantity);
    Solution_Two build();
    /**
     * 생성자에 필요한 setting 추상화를 구현한 객체 생성
     * @return
     */
    static IFactory<FactorySolutionTwoImpl> builderFactory(){
        return FactorySolutionTwoImpl::new;
    }
    static IFactory<Solution_Two> solution_Two_Factory(FactorySolutionTwoImpl factorySolutionTwo){
        return () -> new Solution_Two(factorySolutionTwo);
    }
}
