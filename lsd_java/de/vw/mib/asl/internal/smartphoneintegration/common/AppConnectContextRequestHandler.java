/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;

public class AppConnectContextRequestHandler {
    private final int STATE_IDLE;
    private final int STATE_REQPENDING;
    private final int STATE_ACTIVE;
    private final HsmTarget target;
    private boolean inSMIContext;
    private int state;
    private String historyLMC;

    public AppConnectContextRequestHandler(HsmTarget hsmTarget) {
        this.STATE_IDLE = 0;
        this.STATE_REQPENDING = 1;
        this.STATE_ACTIVE = 2;
        this.target = hsmTarget;
        this.state = 0;
        this.inSMIContext = false;
        this.historyLMC = null;
    }

    public void handleMainContextChange(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.state == 2 && 25 != n) {
            this.historyLMC = null;
        }
    }

    public void handleRequestContent(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("change content to: ").append(string).toString());
        }
        this.setInHMIContext(string.equals("HMI_SMARTPHONEINTEGRATION") || string.equals("HMI_MIRRORLINK"));
    }

    public void handleAppConnectContextRequested(boolean bl) {
        if (bl) {
            this.onRequestAppConnectTrue();
        } else {
            this.onRequestAppConnectFalse();
        }
    }

    private void onEnterSmartphoneIntegration() {
        switch (this.state) {
            case 0: {
                break;
            }
            case 1: {
                this.state = 2;
                break;
            }
            case 2: {
                break;
            }
        }
        this.target.getDSISmartphoneIntegration().requestAppConnectContextActive(true);
    }

    private void onLeaveSmartphoneIntegration() {
        switch (this.state) {
            case 0: {
                break;
            }
            case 1: {
                this.state = 0;
                break;
            }
            case 2: {
                this.state = 0;
                break;
            }
        }
        this.target.getDSISmartphoneIntegration().requestAppConnectContextActive(false);
    }

    private void onRequestAppConnectTrue() {
        this.state = 1;
        if (null != this.getSystemStateService()) {
            this.historyLMC = this.getSystemStateService().getCurrentLastContentId();
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("historyLMC = ").append(this.historyLMC).toString());
        }
        if (!this.inSMIContext) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(772481088);
            eventGeneric.setString(0, "HMI_SMARTPHONEINTEGRATION");
            this.target.sendSafe(eventGeneric);
        } else {
            this.onEnterSmartphoneIntegration();
        }
    }

    private void onRequestAppConnectFalse() {
        if (2 == this.state && null != this.historyLMC) {
            if (this.target.isTraceEnabled()) {
                this.target.trace(new StringBuffer().append("send change content to: ").append(this.historyLMC).toString());
            }
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(772481088);
            eventGeneric.setString(0, this.historyLMC);
            this.target.sendSafe(eventGeneric);
        }
        this.state = 0;
    }

    private void setInHMIContext(boolean bl) {
        if (bl != this.inSMIContext) {
            if (bl) {
                this.onEnterSmartphoneIntegration();
            } else {
                this.onLeaveSmartphoneIntegration();
            }
            this.inSMIContext = bl;
        }
    }

    private SystemStateService getSystemStateService() {
        return ASLSystemFactory.getSystemApi().getSystemStateService();
    }
}

