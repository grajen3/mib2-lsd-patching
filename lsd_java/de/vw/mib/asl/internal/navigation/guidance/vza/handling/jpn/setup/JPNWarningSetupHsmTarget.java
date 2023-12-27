/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupServices;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupStateInit;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSetupStateWork;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup.JPNWarningSignsSetupHandling;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import java.util.HashMap;

public class JPNWarningSetupHsmTarget
extends AbstractResettableAslHsmTarget {
    JPNWarningSignsSetupHandling jpnWarningSignsSetupHandling = new JPNWarningSignsSetupHandling(this);
    JPNWarningSetupServices jpnWarningSetupServices = new JPNWarningSetupServices(this);
    private JPNWarningSetupStateInit jpnWarningSetupStateInit = new JPNWarningSetupStateInit(this, "jpnWarningSetupStateInit", this.getWorkStateParent());
    private JPNWarningSetupStateWork jpnWarningSetupStateWork = new JPNWarningSetupStateWork(this, "jpnWarningSetupStateWork", this.getWorkStateParent());
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;

    public JPNWarningSetupHsmTarget(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.jpnWarningSetupStateInit;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    public void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    protected void transStateWork() {
        this.traceState("transStateWork()");
        this.getHsm().trans(this.jpnWarningSetupStateWork);
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = JPNWarningSetupHsmTarget.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
        if (bl) {
            if (this.isTraceEnabled()) {
                this.trace("JPNWarningSetupHsmTarget: resetting values after DSI restart");
            }
            this.resetHsmToState(this.jpnWarningSetupStateInit);
            if (bl) {
                this.jpnWarningSetupServices.initDsiTrafficRegulationListener();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("JPNWarningSetupHsmTarget: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

