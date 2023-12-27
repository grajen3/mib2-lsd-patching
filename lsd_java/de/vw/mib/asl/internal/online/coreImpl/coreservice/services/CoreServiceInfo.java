/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceStatusListener;

public class CoreServiceInfo {
    public static int TYPE_STATUS = 1;
    public static int TYPE_URL = 2;
    private String _serviceID;
    private CoreServiceCallback1 _callback;
    private CoreServiceCallback _callbackNoMoreUsed;
    private CoreServiceStatusListener _listener;
    private int _type;
    private int _serviceStatus;
    private String _url;

    public CoreServiceInfo(String string, CoreServiceCallback1 coreServiceCallback1, int n) {
        this._type = n;
        this._serviceID = string;
        this._callback = coreServiceCallback1;
    }

    public CoreServiceInfo(String string, CoreServiceStatusListener coreServiceStatusListener, int n) {
        this._type = n;
        this._serviceID = string;
        this._listener = coreServiceStatusListener;
    }

    public CoreServiceInfo(String string, CoreServiceCallback coreServiceCallback, int n) {
        this._type = n;
        this._serviceID = string;
        this._callbackNoMoreUsed = coreServiceCallback;
    }

    public void clear() {
        this._type = 0;
        this._serviceID = null;
        this._callbackNoMoreUsed = null;
        this._callback = null;
        this._listener = null;
    }

    public CoreServiceCallback getCallbackNotUsed() {
        return this._callbackNoMoreUsed;
    }

    public int getType() {
        return this._type;
    }

    public String getServiceID() {
        return this._serviceID;
    }

    public CoreServiceStatusListener getListener() {
        return this._listener;
    }

    public CoreServiceCallback1 getCallback() {
        return this._callback;
    }

    public int getServiceStatus() {
        return this._serviceStatus;
    }

    public void setServiceStatus(int n) {
        this._serviceStatus = n;
    }

    public String getUrl() {
        return this._url;
    }

    public void setUrl(String string) {
        this._url = string;
    }
}

