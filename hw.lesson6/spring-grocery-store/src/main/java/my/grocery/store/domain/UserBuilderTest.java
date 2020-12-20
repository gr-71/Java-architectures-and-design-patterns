package my.grocery.store.domain;

public class UserBuilderTest {
    public static void main(String[] args) {
        User.UserBuilder userBuilder = new User.UserBuilder("TestPerson", "testPassword");
        System.out.println(userBuilder.build());

        System.out.println("-------------------------");

        System.out.println(userBuilder
                .withName("Ivanov")
                .withPassword("testPass")
                .build());
    }
}