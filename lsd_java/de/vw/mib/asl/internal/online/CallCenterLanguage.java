/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.states.OnlineCallCenterServiceTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public class CallCenterLanguage {
    private final String _classname = super.getClass().getName();
    private final OnlineCallCenterServiceTarget target;
    private String _language;

    public CallCenterLanguage(OnlineCallCenterServiceTarget onlineCallCenterServiceTarget) {
        this.target = onlineCallCenterServiceTarget;
    }

    private OnlineCallCenterServiceTarget getTarget() {
        return this.target;
    }

    public void setCallCenterServiceLanguage(String string) {
        if (this.getTarget().isTraceEnabled()) {
            LogMessage logMessage = this.getTarget().trace();
            logMessage.append(this._classname).append(".setCallCenterServiceLanguage(").append(string).append(")").log();
        }
        if (!Util.isNullOrEmpty(string)) {
            this._language = string;
            if (this.getTarget().getDSIOperatorCall() != null) {
                this.getTarget().getDSIOperatorCall().setLanguage(this._language);
            }
        }
    }

    public void setLanguage(String string, EventGeneric eventGeneric) {
        this.setCallCenterServiceLanguage(string);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append(this._classname).append(" .handle(LscTNGEventDeclaration.LSCTNG_CHANGE_LANGUAGE)-> Language ").append(string).log();
        }
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(1151074304);
        eventGeneric2.setInt(0, eventGeneric.getInt(0));
        eventGeneric2.setBoolean(1, true);
        eventGeneric2.setString(2, string);
        this.target.sendSafe(eventGeneric2);
    }

    public String getUotALanguage() {
        return this._language;
    }
}

