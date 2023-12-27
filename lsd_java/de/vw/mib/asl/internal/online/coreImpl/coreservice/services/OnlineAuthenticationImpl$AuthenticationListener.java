/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListener;
import de.vw.mib.asl.api.online.services.authenticate.OnlineAuthenticationListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.services.OnlineAuthenticationImpl;
import de.vw.mib.log4mib.LogMessage;

class OnlineAuthenticationImpl$AuthenticationListener
extends OnlineAuthenticationListenerAdapter {
    OnlineAuthenticationListener _listener;
    private final /* synthetic */ OnlineAuthenticationImpl this$0;

    OnlineAuthenticationImpl$AuthenticationListener(OnlineAuthenticationImpl onlineAuthenticationImpl, OnlineAuthenticationListener onlineAuthenticationListener) {
        this.this$0 = onlineAuthenticationImpl;
        this._listener = onlineAuthenticationListener;
    }

    @Override
    public void updateSpinHashResult(String string, int n) {
        if (this._listener != null) {
            this._listener.updateSpinHashResult(string, n);
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(OnlineAuthenticationImpl.access$000(this.this$0)).append(".updateSpinHashResult() --> Listener is NULL").log();
        }
    }

    @Override
    public void updateSpinRequired(String string) {
        if (this._listener != null) {
            this._listener.updateSpinRequired(string);
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(OnlineAuthenticationImpl.access$000(this.this$0)).append(".updateSpinRequired() --> Listener is NULL").log();
        }
    }

    @Override
    public void setSPinResponse(String string, int n) {
        if (this._listener != null) {
            this._listener.setSPinResponse(string, n);
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(OnlineAuthenticationImpl.access$000(this.this$0)).append(".setSPinResponse() --> Listener is NULL").log();
        }
    }
}

