import java.time.LocalDateTime;
import java.time.LocalDateTime;

public abstract class Notification {
    private int notificationId;
    private LocalDateTime createdOn;
    private String content;

    public Notification(int notificationId, String content) {
        this.notificationId = notificationId;
        this.content = content;
        this.createdOn = LocalDateTime.now();
    }
    
    public int getNotificationId() { return notificationId; }
    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }
    public LocalDateTime getCreatedOn() { return createdOn; }
    public void setCreatedOn(LocalDateTime createdOn) { this.createdOn = createdOn; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public abstract boolean send();
}
