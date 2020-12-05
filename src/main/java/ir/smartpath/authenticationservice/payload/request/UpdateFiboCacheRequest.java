package ir.smartpath.authenticationservice.payload.request;

public class UpdateFiboCacheRequest {
    private boolean cacheStatus;

    public boolean isCacheStatus() {
        return cacheStatus;
    }

    public void setCacheStatus(boolean cacheStatus) {
        this.cacheStatus = cacheStatus;
    }
}
