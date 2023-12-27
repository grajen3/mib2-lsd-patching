/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListener;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl;

class OnlineAuthenticationImpl$AuthenticationCollector {
    String _serviceID;
    String _sPin;
    String _challenge;
    String _userChallenge;
    int _version;
    OnlineAuthenticationListener _listener;
    private final /* synthetic */ OnlineAuthenticationImpl this$0;

    OnlineAuthenticationImpl$AuthenticationCollector(OnlineAuthenticationImpl onlineAuthenticationImpl, String string, String string2, String string3, String string4, int n, OnlineAuthenticationListener onlineAuthenticationListener) {
        this.this$0 = onlineAuthenticationImpl;
        this._serviceID = string;
        this._sPin = string2;
        this._challenge = string3;
        this._userChallenge = string4;
        this._version = n;
        this._listener = onlineAuthenticationListener;
    }

    String getServiceID() {
        return this._serviceID;
    }

    String getSPin() {
        return this._sPin;
    }

    String getChallenge() {
        return this._challenge;
    }

    String getUserChallenge() {
        return this._userChallenge;
    }

    int getVersion() {
        return this._version;
    }

    OnlineAuthenticationListener getListener() {
        return this._listener;
    }
}

