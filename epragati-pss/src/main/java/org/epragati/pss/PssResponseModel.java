package org.epragati.pss;

public abstract class PssResponseModel<T> {

    private ResponseType responseType;
    private String responseDesc;

    public PssResponseModel(ResponseType responseType, String errorDesc) {
        this.responseType = responseType;
        this.responseDesc = errorDesc;
    }

    public String getErrorDesc() {
        return responseDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.responseDesc = errorDesc;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }
    
    public abstract T getResponseModel();

}
