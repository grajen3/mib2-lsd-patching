/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

public class RequestDescriptor {
    public String appID;
    public String serviceID;
    public String url;
    public int method;
    public int encoding;
    public int connectTimeout;
    public int finalTimeout;
    public String addURLTemplate;

    public String getAppID() {
        return this.appID;
    }

    public void setAppID(String string) {
        this.appID = string;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(String string) {
        this.serviceID = string;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String string) {
        this.url = string;
    }

    public int getMethod() {
        return this.method;
    }

    public void setMethod(int n) {
        this.method = n;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public void setEncoding(int n) {
        this.encoding = n;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int n) {
        this.connectTimeout = n;
    }

    public int getFinalTimeout() {
        return this.finalTimeout;
    }

    public void setFinalTimeout(int n) {
        this.finalTimeout = n;
    }

    public String getAddURLTemplate() {
        return this.addURLTemplate;
    }

    public void setAddURLTemplate(String string) {
        this.addURLTemplate = string;
    }

    public RequestDescriptor() {
    }

    public RequestDescriptor(String string, String string2, String string3, int n, int n2, int n3, int n4, String string4) {
        this.appID = string;
        this.serviceID = string2;
        this.url = string3;
        this.method = n;
        this.encoding = n2;
        this.connectTimeout = n3;
        this.finalTimeout = n4;
        this.addURLTemplate = string4;
    }

    public String toString() {
        return new StringBuffer("RequestDescriptor{").append("appID=").append(this.appID).append(", serviceID=").append(this.serviceID).append(", url=").append(this.url).append(", method=").append(this.method).append(", encoding=").append(this.encoding).append(", connectTimeout=").append(this.connectTimeout).append(", finalTimeout=").append(this.finalTimeout).append(", addURLTemplate=").append(this.addURLTemplate).append("}").toString();
    }
}

