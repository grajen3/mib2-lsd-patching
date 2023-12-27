/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.activations;

import de.vw.mib.asl.framework.api.entertainmentmanager.EntertainmentActivation;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;

public abstract class AbstractActivation
implements Loggable,
EntertainmentActivation {
    private final int context;
    private int subcontext;
    private boolean explicitContextRequest;
    private int cause;
    private int targetId;
    private boolean contextSwitch;
    private boolean canceled = false;

    AbstractActivation(int n, int n2, boolean bl) {
        if (bl && n == -1) {
            ServiceManager.logger2.warn(16).append("negative context not expected in constructor, use AbsoluteActivation.INVALID instead.").log();
            throw new IllegalArgumentException("do not use invalid context for constructor, use AbsoluteActivation.INVALID");
        }
        this.context = n;
        this.subcontext = n2;
        this.explicitContextRequest = false;
        this.targetId = -1;
    }

    public final void activate(int n) {
        if (this.targetId != -1) {
            if (ServiceManager.logger2.isTraceEnabled(16)) {
                ServiceManager.logger2.trace(16).append("activation has explicit targetId=").append(this.targetId).append(", overriding the given targetId=").append(n).log();
            }
            n = this.targetId;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(272503040, n, -1017375488);
        eventGeneric.setObject(0, this);
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("sending activation: ").append(this).append(" to targetId=").append(n).log();
        }
        this.canceled = false;
        if (eventGeneric.getReceiverTargetId() != -1) {
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    public void setTargetId(int n) {
        this.targetId = n;
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("(").append(this.context).append(", ").append(this.subcontext);
        if (this.subcontext >> 16 != 0) {
            logMessage.append(" (").append(this.subcontext & 0xFFFF0000).append("/").append(this.subcontext >> 16).append(")");
        }
        if (this.explicitContextRequest) {
            logMessage.append('!');
        }
        logMessage.append(")");
    }

    public String toString() {
        return new StringBuffer().append("Activation(").append(this.context).append(", 0x").append(Integer.toHexString(this.subcontext)).append(") cause: ").append(this.cause).append("=0x").append(Integer.toHexString(this.cause)).toString();
    }

    public boolean isContextChangeRequired(AbstractActivation abstractActivation) {
        return this.context != abstractActivation.context;
    }

    @Override
    public int getContext() {
        return this.context;
    }

    @Override
    public boolean isContextSwitch() {
        return this.contextSwitch;
    }

    public void setContextSwitch(boolean bl) {
        this.contextSwitch = bl;
    }

    @Override
    public int getSubcontext() {
        return this.subcontext;
    }

    @Override
    public int getCause() {
        return this.cause;
    }

    public void setCause(int n) {
        this.cause = n;
    }

    public void setExplicitContextRequest(boolean bl) {
        this.explicitContextRequest = bl;
    }

    public boolean isExplicitContextRequest() {
        return this.explicitContextRequest;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.context;
        n2 = 31 * n2 + (this.subcontext & 0xFFFF0000);
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AbstractActivation abstractActivation = (AbstractActivation)object;
        if (this.context != abstractActivation.context) {
            return false;
        }
        return (this.subcontext & 0xFFFF0000) == (abstractActivation.subcontext & 0xFFFF0000);
    }

    public int getEntertainmentManagerListenerConstant() {
        return this.context << 16 + this.subcontext;
    }

    public void setActualSubcontext(int n) {
        this.subcontext = n;
    }

    @Override
    public boolean isCanceled() {
        return this.canceled;
    }

    public void setCanceled(boolean bl) {
        this.canceled = bl;
    }
}

