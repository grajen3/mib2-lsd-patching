/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class SessionManager {
    public static int SESSION_TYPE_GET_RADIO_STATION_LOGO = 0;
    public static int SESSION_TYPE_GET_STREAM_URL = 1;
    public static int SESSION_TYPE_GET_META_INFORMATION = 2;
    public static int SESSION_TYPE_DOWNLOAD_DATABASE = 3;
    public static int SESSION_TYPE_CANCEL_DOWNLOAD_DATABASE = 4;
    private int[] sessionIds = new int[200];
    public static final int INVALID_SESSION_ID;
    private int sessionId = 0;

    SessionManager() {
        for (int i2 = 0; i2 < this.sessionIds.length; ++i2) {
            this.sessionIds[i2] = 0;
        }
    }

    public int getNewSessionId() {
        try {
            ++this.sessionId;
            if (this.sessionId < 0) {
                this.sessionId = 1;
            }
            return this.sessionId;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 0;
        }
    }

    public void setCurrentSessionId(int n, int n2) {
        try {
            if (null == this.sessionIds) {
                ServiceManager.logger2.error(2).append("SessionManager - setCurrentSessionId() - null == sessionIds").log();
                return;
            }
            if (n >= 0 && n < this.sessionIds.length) {
                this.sessionIds[n] = n2;
            } else {
                ServiceManager.logger2.error(2).append("SessionManager - setCurrentSessionId() - Session type ").append(n).append(" is not valid!").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int getCurrentSessionId(int n) {
        try {
            if (null == this.sessionIds) {
                ServiceManager.logger2.error(2).append("SessionManager - getCurrentSessionId() - null == sessionIds").log();
                return 0;
            }
            if (n >= 0 && n < this.sessionIds.length) {
                return this.sessionIds[n];
            }
            ServiceManager.logger2.error(2).append("SessionManager - getCurrentSessionId() - Session type ").append(n).append(" is not valid!").log();
            return 0;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return 0;
        }
    }
}

