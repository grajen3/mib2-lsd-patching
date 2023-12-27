/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreInterfaces.adapter.CoreServiceAdapterListener;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.asl.internal.online.coreInterfaces.core.server.User;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceListener;

public class CoreServiceCollector {
    private int _uniqueID;
    private String _serviceID;
    private String _serviceName;
    private OnlineUser _clientUser;
    private CoreServiceListener _clientListener;
    private User _user;
    private CoreServiceAdapterListener _adapterListener;
    private CoreServiceExternalListener _externalListener;

    public CoreServiceCollector(int n, String string, User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        this._uniqueID = n;
        this._serviceID = string;
        this._serviceName = "";
        this._user = user;
        this._adapterListener = coreServiceAdapterListener;
        this._externalListener = null;
    }

    public CoreServiceCollector(int n, String string, String string2, User user, CoreServiceAdapterListener coreServiceAdapterListener) {
        this._uniqueID = n;
        this._serviceID = string;
        this._serviceName = string2;
        this._user = user;
        this._adapterListener = coreServiceAdapterListener;
        this._externalListener = null;
    }

    public CoreServiceCollector(int n, String string, OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
        this._uniqueID = n;
        this._serviceID = string;
        this._serviceName = "";
        this._clientUser = onlineUser;
        this._clientListener = coreServiceListener;
        this._externalListener = null;
    }

    public CoreServiceCollector(int n, String string, String string2, OnlineUser onlineUser, CoreServiceListener coreServiceListener) {
        this._uniqueID = n;
        this._serviceID = string;
        this._serviceName = string2;
        this._clientUser = onlineUser;
        this._clientListener = coreServiceListener;
        this._externalListener = null;
    }

    public CoreServiceCollector(int n, String string, CoreServiceExternalListener coreServiceExternalListener) {
        this._uniqueID = n;
        this._serviceID = string;
        this._serviceName = "";
        this._clientUser = null;
        this._clientListener = null;
        this._externalListener = coreServiceExternalListener;
    }

    public int getUniqueID() {
        return this._uniqueID;
    }

    public String getServiceID() {
        return this._serviceID;
    }

    public String getServiceName() {
        return this._serviceName;
    }

    public User getUser() {
        return this._user;
    }

    public CoreServiceAdapterListener getAdapterListener() {
        return this._adapterListener;
    }

    public CoreServiceExternalListener getExternalListener() {
        return this._externalListener;
    }

    public OnlineUser getClientUser() {
        return this._clientUser;
    }

    public CoreServiceListener getClientListener() {
        return this._clientListener;
    }

    public String toClientString() {
        String string = "";
        return string;
    }

    public String toString() {
        String string = "";
        return string;
    }
}

