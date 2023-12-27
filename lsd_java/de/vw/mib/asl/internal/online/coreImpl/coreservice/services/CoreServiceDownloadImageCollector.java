/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.util.Util;

public class CoreServiceDownloadImageCollector {
    CoreServiceCallback1 _callback;
    String _url;
    String _checksum;
    int _category;
    String _serviceID;
    String _localFilePath;

    public CoreServiceDownloadImageCollector(CoreServiceCallback1 coreServiceCallback1, String string, String string2, int n) {
        this._callback = coreServiceCallback1;
        this._url = string;
        this._checksum = string2;
        this._category = n;
        this._serviceID = "";
        this._localFilePath = "";
    }

    public CoreServiceDownloadImageCollector(CoreServiceCallback1 coreServiceCallback1, String string, String string2, int n, String string3) {
        this._callback = coreServiceCallback1;
        this._url = string;
        this._checksum = string2;
        this._category = n;
        this._serviceID = string3;
        this._localFilePath = "";
    }

    public CoreServiceDownloadImageCollector(CoreServiceDownloadImageCollector coreServiceDownloadImageCollector) {
        if (coreServiceDownloadImageCollector != null) {
            this._callback = coreServiceDownloadImageCollector.getCallback();
            this._url = coreServiceDownloadImageCollector.getURL();
            this._checksum = coreServiceDownloadImageCollector.getChecksum();
            this._category = coreServiceDownloadImageCollector.getCategory();
            this._localFilePath = coreServiceDownloadImageCollector.getLocalFilePath();
            this._serviceID = Util.isNullOrEmpty(coreServiceDownloadImageCollector.getServiceID()) ? "" : coreServiceDownloadImageCollector.getServiceID();
        }
    }

    public void clear() {
        this._callback = null;
        this._url = null;
        this._checksum = null;
        this._category = 0;
        this._localFilePath = null;
    }

    public boolean isValid() {
        return this._callback != null && !Util.isNullOrEmpty(this._url);
    }

    public CoreServiceCallback1 getCallback() {
        return this._callback;
    }

    public String getURL() {
        return this._url;
    }

    public String getChecksum() {
        return this._checksum;
    }

    public int getCategory() {
        return this._category;
    }

    public String getServiceID() {
        return this._serviceID;
    }

    public void setServiceID(String string) {
        this._serviceID = string;
    }

    public String getLocalFilePath() {
        return this._localFilePath;
    }

    public void setLocalFilePath(String string) {
        this._localFilePath = string;
    }

    public boolean isLocalFilePathExists() {
        return !Util.isNullOrEmpty(this._localFilePath);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("OnlineCoreServicesDownloadImageCollector");
        stringBuffer.append('(');
        stringBuffer.append("CallBack");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._callback == null ? "NULL" : "CALLBACK");
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("URL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._url) ? "NULL" : this._url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("Category");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this._category);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("CheckSum");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._checksum) ? "NULL" : this._checksum);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("Service ID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._serviceID) ? "NULL" : this._serviceID);
        stringBuffer.append(',');
        stringBuffer.append("Filepath");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(Util.isNullOrEmpty(this._localFilePath) ? "NULL" : this._localFilePath);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

