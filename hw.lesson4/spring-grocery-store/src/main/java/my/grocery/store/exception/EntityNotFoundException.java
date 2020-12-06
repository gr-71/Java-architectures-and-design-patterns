package my.grocery.store.exception;

public class EntityNotFoundException extends RuntimeException {

    private String name;
    private Long id;

    public EntityNotFoundException(String name, Long id, String message) {
        super(message);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
