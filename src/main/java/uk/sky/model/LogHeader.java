package uk.sky.model;

public class LogHeader {
//    REQUEST_TIMESTAMP,COUNTRY_CODE,RESPONSE_TIME

    private String timeStampHeaderName;
    private String countryCodeHeaderName;
    private String responseTimeHeaderName;


    public LogHeader(String timeStampHeaderName, String countryCodeHeaderName, String responseTimeHeaderName) {
        this.timeStampHeaderName = timeStampHeaderName;
        this.countryCodeHeaderName = countryCodeHeaderName;
        this.responseTimeHeaderName = responseTimeHeaderName;
    }

    public String getTimeStampHeaderName() {
        return timeStampHeaderName;
    }

    public void setTimeStampHeaderName(String timeStampHeaderName) {
        this.timeStampHeaderName = timeStampHeaderName;
    }

    public String getCountryCodeHeaderName() {
        return countryCodeHeaderName;
    }

    public void setCountryCodeHeaderName(String countryCodeHeaderName) {
        this.countryCodeHeaderName = countryCodeHeaderName;
    }

    public String getResponseTimeHeaderName() {
        return responseTimeHeaderName;
    }

    public void setResponseTimeHeaderName(String responseTimeHeaderName) {
        this.responseTimeHeaderName = responseTimeHeaderName;
    }

    public int indexOf(String headerName) {
        switch (headerName) {
            case "REQUEST_TIMESTAMP":
                return 0;
            case "COUNTRY_CODE":
                return 1;
            case "RESPONSE_TIME":
                return 2;
            default:
                throw new RuntimeException("IDK this header name! ["+headerName+"]");
        }
    }
}
