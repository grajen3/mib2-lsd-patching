/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.ambiencelight;

import de.vw.mib.asl.api.car.ambiencelight.ASLAmbienceLightAPI;
import de.vw.mib.asl.api.car.ambiencelight.AmbienceColorAreaSettings;
import de.vw.mib.asl.api.car.ambiencelight.AmbienceLightService;
import de.vw.mib.asl.api.car.ambiencelight.AmbienceLightServiceListener;
import de.vw.mib.asl.api.car.ambiencelight.RGBColorList;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.ambiencelight.NotAvailableAmbienceLightService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLAmbienceLightAPIImpl
implements ASLAmbienceLightAPI,
ServiceClient,
AmbienceLightServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService == null ? (class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService = ASLAmbienceLightAPIImpl.class$("de.vw.mib.asl.api.car.ambiencelight.AmbienceLightService")) : class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightServiceListener == null ? (class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightServiceListener = ASLAmbienceLightAPIImpl.class$("de.vw.mib.asl.api.car.ambiencelight.AmbienceLightServiceListener")) : class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightServiceListener, this);
            this.updateServiceExisting(true);
        }
    }

    @Override
    public void updateServiceExisting(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateServiceExisting(bl);
        }
    }

    @Override
    public void addAmbienceLightServiceListener(AmbienceLightServiceListener ambienceLightServiceListener) {
        this.getRegisteredCarClients().add(ambienceLightServiceListener);
    }

    @Override
    public void removeAmbienceLightServiceListener(AmbienceLightServiceListener ambienceLightServiceListener) {
        this.getRegisteredCarClients().remove(ambienceLightServiceListener);
    }

    @Override
    public AmbienceLightService getAmbienceLightService() {
        AmbienceLightService ambienceLightService = (AmbienceLightService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService == null ? (class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService = ASLAmbienceLightAPIImpl.class$("de.vw.mib.asl.api.car.ambiencelight.AmbienceLightService")) : class$de$vw$mib$asl$api$car$ambiencelight$AmbienceLightService);
        if (ambienceLightService == null) {
            ambienceLightService = new NotAvailableAmbienceLightService();
        }
        return ambienceLightService;
    }

    @Override
    public void updateAmbianceLightStateOff(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateAmbianceLightStateOff(bl);
        }
    }

    @Override
    public void updateRGBColorList(RGBColorList rGBColorList) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateRGBColorList(rGBColorList);
        }
    }

    @Override
    public void updateAmbienceColorAreaSettings(AmbienceColorAreaSettings ambienceColorAreaSettings) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateAmbienceColorAreaSettings(ambienceColorAreaSettings);
        }
    }

    @Override
    public void updateBrightnessValues(int[] nArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateBrightnessValues(nArray);
        }
    }

    @Override
    public void updateAmbienceLightPackage1O2Installed(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateAmbienceLightPackage1O2Installed(bl);
        }
    }

    @Override
    public void updateDoorlockingBlindsControl(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateDoorlockingBlindsControl(bl);
        }
    }

    @Override
    public void updateIntLightBrightness(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateIntLightBrightness(n);
        }
    }

    @Override
    public void updateBrightnessValue(int n, int n2) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateBrightnessValue(n, n2);
        }
    }

    @Override
    public void updateIntLightState(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            AmbienceLightServiceListener ambienceLightServiceListener = (AmbienceLightServiceListener)iterator.next();
            ambienceLightServiceListener.updateIntLightState(n);
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

