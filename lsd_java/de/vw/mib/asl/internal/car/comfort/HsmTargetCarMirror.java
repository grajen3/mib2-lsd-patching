/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.comfort;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.carcomfort.DSICarComfort;

public class HsmTargetCarMirror
extends AbstractASLTarget {
    private DSICarComfort dsiCarComfort;
    private boolean ADJUSTSYNC_ACTIVESTATE;
    private boolean FOLDING_ACTIVESTATE;
    private boolean LOWERING_ACTIVESTATE;
    private boolean autoMirrorHeatingActive;
    private boolean autoMirrorShadingActive;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    public HsmTargetCarMirror(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1924197888;
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{487325760, 520880192, 504102976, 571211840, 587989056});
    }

    private void registerOnCarComfort() {
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarMirror.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfort.setNotification(new int[]{42, 40, 41, 44, 43}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarMirror.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event for CarMirror: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerOnCarComfort();
                this.registerModelEvents();
                this.initDefaultValues();
                break;
            }
            case 1073744925: {
                this.toggleMirrorSyncAdjust(!this.ADJUSTSYNC_ACTIVESTATE);
                break;
            }
            case 1073744927: {
                this.toggleMirrorFold(!this.FOLDING_ACTIVESTATE);
                break;
            }
            case 1073744926: {
                this.toggleMirrorLowering(!this.LOWERING_ACTIVESTATE);
                break;
            }
            case 1073744930: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarMirror.TOGGLE_AUTO_MIRROR_HEATING").log();
                }
                this.dsiCarComfort.setMirrorHeating(!this.autoMirrorHeatingActive);
                break;
            }
            case 1073744931: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CarMirror.TOGGLE_AUTO_MIRROR_SHADING").log();
                }
                this.dsiCarComfort.setMirrorDimming(!this.autoMirrorShadingActive);
                break;
            }
        }
    }

    private void toggleMirrorSyncAdjust(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle mirror sync-adjust. Value: ").append(bl).log();
        }
        this.dsiCarComfort.setMirrorSyncAdjust(bl);
    }

    private void toggleMirrorFold(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle mirror folding. Value: ").append(bl).log();
        }
        this.dsiCarComfort.setMirrorFolding(bl);
    }

    private void toggleMirrorLowering(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle mirror lowering. Value: ").append(bl).log();
        }
        this.dsiCarComfort.setMirrorLowering(bl);
    }

    public void dsiCarComfortUpdateMirrorFolding(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: mirrorFolding. Values: ").append(bl).log();
        }
        HsmTargetCarMirror.writeBooleanToDatapool(10210, bl);
        this.FOLDING_ACTIVESTATE = bl;
    }

    public void dsiCarComfortUpdateMirrorLowering(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: mirrorLowering. Values: ").append(bl).log();
        }
        HsmTargetCarMirror.writeBooleanToDatapool(10209, bl);
        this.LOWERING_ACTIVESTATE = bl;
    }

    public void dsiCarComfortUpdateMirrorSyncAdjust(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: mirrorSyncAdjust. Values: ").append(bl).log();
        }
        HsmTargetCarMirror.writeBooleanToDatapool(10208, bl);
        this.ADJUSTSYNC_ACTIVESTATE = bl;
    }

    private void initDefaultValues() {
        this.ADJUSTSYNC_ACTIVESTATE = false;
        this.FOLDING_ACTIVESTATE = false;
        this.LOWERING_ACTIVESTATE = false;
    }

    public void dsiCarComfortUpdateMirrorHeating(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarMirror.dsiCarComfortUpdateMirrorHeating").append(bl).append(n).log();
        }
        this.autoMirrorHeatingActive = bl;
        HsmTargetCarMirror.writeBooleanToDatapool(10213, bl);
    }

    public void dsiCarComfortUpdateMirrorDimming(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("CarMirror.dsiCarComfortUpdateMirrorDimming").append(bl).append(n).log();
        }
        this.autoMirrorShadingActive = bl;
        HsmTargetCarMirror.writeBooleanToDatapool(10214, bl);
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

