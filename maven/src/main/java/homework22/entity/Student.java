package homework22.entity;

public record Student(Integer id, String firstName, String middleName, String secondName, Group group,
                      Integer enterYear, Boolean isDeleted) {
}
