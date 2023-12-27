/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingService;
import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingUpdate;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.phone.targets.abstracts.AbstractASLPhoneTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.wirelesscharging.DSIWirelessCharging;
import org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener;

public class TargetASLWirelessCharging
extends AbstractASLPhoneTarget
implements DSIWirelessChargingListener,
WirelessChargingService {
    DSIWirelessCharging dsiWirelessCharging;
    DSIWirelessChargingListener dsiWirelessChargingListener;
    private final HashMap listeners = new HashMap();
    private int wirelessChargingState = 0;
    private boolean alreadyRegistered = false;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging;
    static /* synthetic */ Class class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService;

    public TargetASLWirelessCharging(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    private void onWirelessChargingChanged(int n) {
        this.wirelessChargingState = n;
        Iterator iterator = this.listeners.values().iterator();
        while (iterator.hasNext()) {
            WirelessChargingUpdate wirelessChargingUpdate = (WirelessChargingUpdate)iterator.next();
            wirelessChargingUpdate.onWirelessChargingChanged(n);
        }
    }

    @Override
    public int getDefaultTargetId() {
        return 1905857536;
    }

    private void init() {
        if (!this.alreadyRegistered) {
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.dsiWirelessCharging = (DSIWirelessCharging)dSIProxy.getService(this, class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging = TargetASLWirelessCharging.class$("org.dsi.ifc.wirelesscharging.DSIWirelessCharging")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessCharging);
            this.dsiWirelessChargingListener = this;
            dSIProxy.addResponseListener(this, class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener == null ? (class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener = TargetASLWirelessCharging.class$("org.dsi.ifc.wirelesscharging.DSIWirelessChargingListener")) : class$org$dsi$ifc$wirelesscharging$DSIWirelessChargingListener, this.dsiWirelessChargingListener);
            ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
            aSLComponentRegistry.registerAPI(class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService == null ? (class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService = TargetASLWirelessCharging.class$("de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingService")) : class$de$vw$mib$asl$api$phone$services$wirelesscharging$WirelessChargingService, this);
        }
        this.alreadyRegistered = true;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.setNotification();
                break;
            }
        }
    }

    private void setNotification() {
        this.dsiWirelessCharging.setNotification(new int[]{2, 1}, (DSIListener)this.dsiWirelessChargingListener);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1000) {
            // empty if block
        }
    }

    @Override
    public void updateBatteryLevel(int n, int n2) {
    }

    @Override
    public void updateChargingInfo(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("updateChargingInfo: ").append(n).log();
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(-125627136, true);
        switch (n) {
            case 3: {
                AbstractASLHsmTarget.writeBooleanToDatapool(-92072704, true);
                this.sendHMIEvent(-578611968);
                this.onWirelessChargingChanged(2);
                break;
            }
            case 4: {
                AbstractASLHsmTarget.writeBooleanToDatapool(-75295488, true);
                AbstractASLHsmTarget.writeBooleanToDatapool(-92072704, true);
                this.sendHMIEvent(-561834752);
                this.onWirelessChargingChanged(1);
                break;
            }
            case 5: {
                AbstractASLHsmTarget.writeBooleanToDatapool(-75295488, false);
                AbstractASLHsmTarget.writeBooleanToDatapool(-92072704, true);
                this.onWirelessChargingChanged(0);
                break;
            }
            default: {
                AbstractASLHsmTarget.writeBooleanToDatapool(-75295488, false);
                AbstractASLHsmTarget.writeBooleanToDatapool(-92072704, false);
                this.onWirelessChargingChanged(0);
            }
        }
    }

    @Override
    public void register(WirelessChargingUpdate wirelessChargingUpdate) {
        WirelessChargingUpdate wirelessChargingUpdate2 = (WirelessChargingUpdate)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(wirelessChargingUpdate);
        this.listeners.put(wirelessChargingUpdate, wirelessChargingUpdate2);
        wirelessChargingUpdate.onWirelessChargingChanged(this.wirelessChargingState);
    }

    @Override
    public void unregister(WirelessChargingUpdate wirelessChargingUpdate) {
        this.listeners.remove(wirelessChargingUpdate);
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

