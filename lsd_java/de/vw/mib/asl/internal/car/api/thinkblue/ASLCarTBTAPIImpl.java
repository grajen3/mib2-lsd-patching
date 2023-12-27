/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.thinkblue;

import de.vw.mib.asl.api.car.thinkblue.ASLCarTBTAPI;
import de.vw.mib.asl.api.car.thinkblue.TBTService;
import de.vw.mib.asl.api.car.thinkblue.TBTServiceListener;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.thinkblue.NotAvailableTBTService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.HashSet;
import java.util.Iterator;

public class ASLCarTBTAPIImpl
implements ASLCarTBTAPI,
ServiceClient,
TBTServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public TBTService getTBTService() {
        TBTService tBTService = (TBTService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$thinkblue$TBTService == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTService = ASLCarTBTAPIImpl.class$("de.vw.mib.asl.api.car.thinkblue.TBTService")) : class$de$vw$mib$asl$api$car$thinkblue$TBTService);
        if (tBTService == null) {
            tBTService = new NotAvailableTBTService();
        }
        return tBTService;
    }

    @Override
    public void addTBTServiceListener(TBTServiceListener tBTServiceListener) {
        this.getRegisteredCarClients().add(tBTServiceListener);
    }

    @Override
    public void removeTBTServiceListener(TBTServiceListener tBTServiceListener) {
        this.getRegisteredCarClients().remove(tBTServiceListener);
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$thinkblue$TBTService == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTService = ASLCarTBTAPIImpl.class$("de.vw.mib.asl.api.car.thinkblue.TBTService")) : class$de$vw$mib$asl$api$car$thinkblue$TBTService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener == null ? (class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener = ASLCarTBTAPIImpl.class$("de.vw.mib.asl.api.car.thinkblue.TBTServiceListener")) : class$de$vw$mib$asl$api$car$thinkblue$TBTServiceListener, this);
        }
    }

    @Override
    public void updateBluePointsTrend(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateBluePointsTrend(bl);
        }
    }

    @Override
    public void updateEcoAverageTrip(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateEcoAverageTrip(n);
        }
    }

    @Override
    public void updateConsumptionTrend(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateConsumptionTrend(bl);
        }
    }

    @Override
    public void updateCurrentConsumption(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateCurrentConsumption(n);
        }
    }

    @Override
    public void updateCurrentConsumptionDecimal(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateCurrentConsumptionDecimal(n);
        }
    }

    @Override
    public void updateBluePoints(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateBluePoints(n);
        }
    }

    @Override
    public void updateCurrentGear(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateCurrentGear(n);
        }
    }

    @Override
    public void updateCurrentIrisSegment(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateCurrentIrisSegment(n);
        }
    }

    @Override
    public void updateIrisSegmentsValues(int[] nArray) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateIrisSegmentsValues(nArray);
        }
    }

    @Override
    public void updateMaxAcceleration(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateMaxAcceleration(n);
        }
    }

    @Override
    public void updateRecommendedGear(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateRecommendedGear(n);
        }
    }

    @Override
    public void updateCurrentAcceleration(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateCurrentAcceleration(n);
        }
    }

    @Override
    public void updateDisplayDurationHintIcon(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateDisplayDurationHintIcon(n);
        }
    }

    @Override
    public void updateDrivingBehaviorMode(int n) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            TBTServiceListener tBTServiceListener = (TBTServiceListener)iterator.next();
            tBTServiceListener.updateDrivingBehaviorMode(n);
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

