package observer;

public class _2524764_UserObserver implements _2524764_Observer {

    private String userId;

    public _2524764_UserObserver(String userId) {
        this.userId = userId;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to User [" + userId + "]: " + message);
    }

    public String getUserId() {
        return userId;
    }
}
