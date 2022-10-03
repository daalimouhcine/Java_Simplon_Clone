package validationMessage;

public class ValidationMessage {
    public String studentId;
    public String briefId;
    public String message;
    public String repoLink;

    public ValidationMessage(String studentId, String briefId, String message, String repoLink) {
        this.studentId = studentId;
        this.briefId = briefId;
        this.message = message;
        this.repoLink = repoLink;
    }

}
