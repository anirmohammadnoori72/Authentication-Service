package ir.smartpath.authenticationservice.configuration;

public class Config {

    private static final Config conf = new Config();

    private boolean enableFiboCache = true;

    private Config() {

    }


    public static Config getInstance() {
        return conf; //TODO It may need to be thread safe in the future _ i dont know
    }

    public boolean isEnableFiboCache() {
        return enableFiboCache;
    }

    public void setEnableFiboCache(boolean enableFiboCache) {
        this.enableFiboCache = enableFiboCache;
    }
}
