/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.comfort;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.carcomfort.DSICarComfort;

public class HsmTargetCarWipers
extends AbstractASLTarget {
    private DSICarComfort dsiCarComfort;
    private boolean RAINSENSOR_ACTIVESTATE;
    private boolean REARWIPING_ACTIVESTATE;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    public HsmTargetCarWipers(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1890643456;
    }

    private void registerModelEvents() {
        this.addObservers(new int[]{537657408, 554434624});
    }

    private void registerOnCarComfort() {
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarWipers.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfort.setNotification(new int[]{23, 25, 27}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarWipers.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.registerModelEvents();
                this.registerOnCarComfort();
                this.RAINSENSOR_ACTIVESTATE = false;
                this.REARWIPING_ACTIVESTATE = false;
                break;
            }
            case 1073744928: {
                this.dsiCarComfort.setWiperRainSensorOnOff(!this.RAINSENSOR_ACTIVESTATE);
                break;
            }
            case 1073744929: {
                this.dsiCarComfort.setWiperRearWiping(!this.REARWIPING_ACTIVESTATE);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateWiperRainSensorOnOff(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: rain sensor. value: ").append(bl).log();
        }
        HsmTargetCarWipers.writeBooleanToDatapool(10211, bl);
        this.RAINSENSOR_ACTIVESTATE = bl;
    }

    public void dsiCarComfortUpdateWiperRearWiping(boolean bl, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: rear wiping. value: ").append(bl).log();
        }
        HsmTargetCarWipers.writeBooleanToDatapool(10212, bl);
        this.REARWIPING_ACTIVESTATE = bl;
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

