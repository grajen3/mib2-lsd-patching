/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public class UotASessionManager {
    private int _sessionID = -1;
    private int _request = 0;

    public int getSessionID() {
        return this._sessionID;
    }

    public void setSessionID(int n) {
        this._sessionID = n;
    }

    public void executedRequestWithSession(int n, int n2, boolean bl) {
        if (n > 0 || bl) {
            this.setSessionID(n);
            this.setRequest(n2);
        }
    }

    public int getRequest() {
        return this._request;
    }

    public void setRequest(int n) {
        this._request = n;
    }

    public boolean checkForRequestPending(int n) {
        return this._request >= n;
    }

    public boolean checkToResetRequest(int n, int n2) {
        if (this.getSessionID() != n) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.info(16384);
                logMessage.append(new StringBuffer().append("SESSION ID is INVALID for request ").append(n2).toString()).log();
            }
            return false;
        }
        if (this.getRequest() != n2) {
            if (ServiceManager.logger2.isTraceEnabled(16384)) {
                LogMessage logMessage = ServiceManager.logger2.info(16384);
                logMessage.append(new StringBuffer().append("REQUEST ID is INVALID ").append(n2).toString()).log();
            }
            return false;
        }
        this._request = 0;
        return true;
    }
}

