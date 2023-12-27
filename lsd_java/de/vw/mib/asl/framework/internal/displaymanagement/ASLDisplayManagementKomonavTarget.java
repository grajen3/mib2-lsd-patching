/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.displaymanagement;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.dsi.adaptor.AdaptorFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;

public class ASLDisplayManagementKomonavTarget
extends AbstractASLTarget {
    private static final String LOGGING_DELIM;
    private DSIDisplayManagement dsiDisplayManagement;
    private boolean isDisplayTypeSet = false;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagement;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener;

    public ASLDisplayManagementKomonavTarget(GenericEvents genericEvents) {
        super(genericEvents, 35066112);
        this.register(this.getMainObject(), 35066112, "hsmtask");
    }

    public void dsiDisplayManagementActiveContext(int n, int n2, int n3) {
        if (n2 == 4) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementKomonavTarget] ").append("dsiDisplayManagementActiveContext DISPLAYID_CLUSTER: displayContextId ").append(n).log();
            }
            ASLDisplayManagementKomonavTarget.writeIntegerToDatapool(976363520, n);
            return;
        }
    }

    public void dsiDisplayManagementSetUpdateRateResult(int n, int n2) {
        if (n == 4) {
            if (this.isTraceEnabled()) {
                this.trace().append("[ASLDisplayManagementKomonavTarget] ").append("dsiDisplayManagementSetUpdateRateResult updaterate: ").append(n2).log();
            }
            ASLDisplayManagementKomonavTarget.writeIntegerToDatapool(993140736, n2);
            return;
        }
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 8: {
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementKomonavTarget] ").append("NOTIFY_TARGET_REGISTERED").log();
                }
                DSIServiceLocator dSIServiceLocator = ServiceManager.dsiServiceLocator;
                this.dsiDisplayManagement = (DSIDisplayManagement)dSIServiceLocator.getService(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagement == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagement = ASLDisplayManagementKomonavTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagement")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagement);
                DSIListener dSIListener = AdaptorFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = ASLDisplayManagementKomonavTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener);
                dSIServiceLocator.addResponseListener(this, class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener == null ? (class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener = ASLDisplayManagementKomonavTarget.class$("org.dsi.ifc.displaymanagement.DSIDisplayManagementListener")) : class$org$dsi$ifc$displaymanagement$DSIDisplayManagementListener, dSIListener);
                this.registerServices(new int[]{604708928, 621486144}, true);
                this.addObservers(new int[]{604708928, 621486144, 815612160, 832389376});
                ASLDisplayManagementKomonavTarget.writeIntegerToDatapool(976363520, -1);
                break;
            }
            case 4300080: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                ASLDisplayManagementKomonavTarget.writeIntegerToDatapool(1043472384, n);
                ASLDisplayManagementKomonavTarget.writeIntegerToDatapool(1060249600, n2);
                break;
            }
            case 4300081: {
                boolean bl = eventGeneric.getBoolean(0);
                boolean bl2 = eventGeneric.getBoolean(1);
                boolean bl3 = eventGeneric.getBoolean(2);
                ASLDisplayManagementKomonavTarget.writeBooleanToDatapool(1077026816, bl);
                ASLDisplayManagementKomonavTarget.writeBooleanToDatapool(1093804032, bl2);
                ASLDisplayManagementKomonavTarget.writeBooleanToDatapool(1110581248, bl3);
                break;
            }
            case 1075841828: {
                int n = eventGeneric.getInt(0);
                if (this.isTraceEnabled()) {
                    this.trace().append("[ASLDisplayManagementKomonavTarget] ").append("ASLSystemKombiServiceConstants.SWITCH_TO_KOMBI_DISPLAY_CONTEXT received with id: ").append(n).log();
                }
                if (!this.isDisplayTypeSet) {
                    this.dsiDisplayManagement.setDisplayType(4, 2);
                    this.isDisplayTypeSet = true;
                }
                this.dsiDisplayManagement.switchContext(n, 4, 0);
                break;
            }
            case 1075841829: {
                int n = eventGeneric.getInt(0);
                this.dsiDisplayManagement.setUpdateRate(4, n);
                break;
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 4096;
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

