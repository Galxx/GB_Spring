package gorokhov.exception;

public class EntityNotFoundException extends RuntimeException {

    private String entityName;
    private Integer entityId;

    public EntityNotFoundException(String entityName, Integer entityId, String message) {
        super(message);
        this.entityName = entityName;
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public Integer getEntityId() {
        return entityId;
    }
}

