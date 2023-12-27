/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.guidance.GuidanceInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.guidance.transformer.VZACollector;
import de.vw.mib.asl.internal.navigation.guidance.transformer.VZAIconsCollector;
import de.vw.mib.asl.internal.navigation.guidance.vza.Services;
import de.vw.mib.asl.internal.navigation.guidance.vza.StateWork;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.VZAHandling;
import de.vw.mib.asl.internal.navigation.guidance.vza.handling.VZEHandling;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.HashMap;

public class HsmTargetVZA
extends AbstractResettableAslHsmTarget {
    VZAHandling vzaHandlingUG;
    VZEHandling vzeHandlingUG;
    public Services services;
    public final StateWork stateWork;
    private GuidanceInternalAPINotifier guidanceInternalAPINotifier;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulation;
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance;

    public HsmTargetVZA(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.stateWork = new StateWork(this, this.hsm, "stateWork", this.getWorkStateParent());
        this.vzaHandlingUG = new VZAHandling(this);
        this.vzeHandlingUG = new VZEHandling(this);
        this.guidanceInternalAPINotifier = new GuidanceInternalAPINotifier();
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateWork;
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

    public GuidanceInternalAPINotifier getGuidanceAPINotifier() {
        return this.guidanceInternalAPINotifier;
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulation = HsmTargetVZA.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulation")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulation).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance = HsmTargetVZA.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistance")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistance).getName(), 0);
        if (bl || bl2) {
            this.traceState("resetting values after DSI restart");
            this.initEmptyList();
            this.vzaHandlingUG.stopDisplayWarningIcon();
            if (bl) {
                this.services.initDsiTrafficRegulation();
            }
            if (bl2) {
                this.services.initDsiCarDriverAssistance();
            }
        } else {
            this.traceState("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    void initEmptyList() {
        this.traceState("initEmptyList()");
        ListManager.getGenericASLList(833).updateList(new VZACollector[]{new VZACollector(), new VZACollector(), new VZACollector()});
        ListManager.getGenericASLList(-2131750912).updateList(new VZAIconsCollector[]{new VZAIconsCollector(), new VZAIconsCollector(), new VZAIconsCollector()});
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

