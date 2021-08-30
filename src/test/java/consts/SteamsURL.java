package consts;

public enum SteamsURL {
    BASE_URL("https://store.steampowered.com/");
    private String url;

    SteamsURL(String url) {
        this.url = url;
    }

    public String getBaseUrl() {
        return url;
    }
}
