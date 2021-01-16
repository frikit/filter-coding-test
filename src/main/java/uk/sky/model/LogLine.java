package uk.sky.model;

public class LogLine {

    private final long timeStamp;
    private final String countryCode;
    private final long responseTime;

    public LogLine(Long timeStamp, String countryCode, Long responseTime) {
        this.timeStamp = timeStamp;
        this.countryCode = countryCode;
        this.responseTime = responseTime;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public String getCountryCode() {
        return countryCode.toUpperCase();
    }

    public Long getResponseTime() {
        return responseTime;
    }
}
