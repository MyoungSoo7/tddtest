package me.lms.tddtest.tdd;

public class Account {

    public void testAccount(){
        Account account = new Account();
        if(account == null){
            try {
                throw new Exception("Account is null");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        try {
            account.testAccount(); // 테스트 케이스 실행
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
