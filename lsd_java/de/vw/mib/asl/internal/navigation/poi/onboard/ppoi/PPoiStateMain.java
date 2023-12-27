/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.PPoiStateCategory;
import de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util.PPoiEvents;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class PPoiStateMain
extends PoiAbstractHsmState {
    private PPoiHsmTarget pPoiTarget;
    private boolean wasServiceStateListenerRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public PPoiStateMain(PPoiHsmTarget pPoiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.pPoiTarget = pPoiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.pPoiTarget.getTextLogger().isTraceEnabled(this.pPoiTarget.getSubClassifier())) {
            this.pPoiTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.pPoiTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.pPoiTarget.myTrace(this, "HSM_START");
                break;
            }
            case 4: {
                this.pPoiTarget.myTrace(this, "HSM_EXIT");
                PPoiEvents.removeObserver(this.pPoiTarget);
                break;
            }
            case 101001: {
                this.pPoiTarget.myTrace(this, "NAVI_TARGET_GO_ON");
                if (!this.wasServiceStateListenerRegistered) {
                    ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = PPoiStateMain.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this.pPoiTarget);
                    this.wasServiceStateListenerRegistered = true;
                }
                PPoiEvents.addObserver(this.pPoiTarget);
                break;
            }
            case 100600: {
                this.trans((HsmState)eventGeneric.getObject(0));
                break;
            }
            case 1074841973: {
                this.pPoiTarget.myTrace((AbstractHsmState)hsmState, "initPoiCategories");
                this.pPoiTarget.clearAllModelData();
                PPoiStateCategory.IGNORE_FURTHER_GROUP_ELEMENTS = true;
                this.pPoiTarget.transAfterCallback(this.pPoiTarget.statePPoiGroupCategory);
                break;
            }
        }
        return hsmState;
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

