package org.epragati.pss.aadharhousehold.model;

import org.epragati.pss.PssResponseModel;
import org.epragati.pss.ResponseType;

import com.codetree.bean.SPSVerificationbean;

public class PssAadharResponseModel<T> extends PssResponseModel<T> {

    private T bean;
    
   
    public PssAadharResponseModel(ResponseType responseType, String errorDesc) {
        super(responseType, errorDesc);
    }
    
    public PssAadharResponseModel(ResponseType responseType, String errorDesc, T bean) {
        super(responseType, errorDesc);
        this.bean = bean;
    }

    public void setResponseModel(T bean) {
        this.bean = bean;
    }

    @Override
    public T getResponseModel() {
        return bean;
    }

}
