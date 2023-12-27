/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.webradio;

import de.vw.mib.asl.internal.webradio.FifoArray;
import de.vw.mib.asl.internal.webradio.SessionManager;
import de.vw.mib.asl.internal.webradio.main.TargetMainWebRadio;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.connectedradio.DSIOnlineRadio;

public final class WebRadioServiceManager {
    private static WebRadioServiceManager webRadioServiceManager = null;
    private TargetMainWebRadio targetMain;
    private HsmState stateTopMain;
    private DSIOnlineRadio dsiOnlineRadio;
    private final SessionManager sessionManager = new SessionManager();
    private final FifoArray lastListenedList = new FifoArray(20);

    private WebRadioServiceManager() {
    }

    public static WebRadioServiceManager getServiceManager() {
        if (webRadioServiceManager == null) {
            webRadioServiceManager = new WebRadioServiceManager();
        }
        return webRadioServiceManager;
    }

    public void setTargetMain(TargetMainWebRadio targetMainWebRadio) {
        this.targetMain = targetMainWebRadio;
    }

    public TargetMainWebRadio getTargetMain() {
        return this.targetMain;
    }

    public void setStateTopMain(HsmState hsmState) {
        this.stateTopMain = hsmState;
    }

    public HsmState getStateTopMain() {
        return this.stateTopMain;
    }

    public DSIOnlineRadio getDsiOnlineRadio() {
        return this.dsiOnlineRadio;
    }

    public void setDsiOnlineRadio(DSIOnlineRadio dSIOnlineRadio) {
        this.dsiOnlineRadio = dSIOnlineRadio;
    }

    public SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public FifoArray getLastListenedList() {
        return this.lastListenedList;
    }
}

