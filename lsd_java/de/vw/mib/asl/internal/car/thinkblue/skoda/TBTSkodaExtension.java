/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.thinkblue.skoda;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.car.thinkblue.ASLTargetThinkBlue;
import de.vw.mib.asl.internal.car.thinkblue.AverageData;
import de.vw.mib.asl.internal.car.thinkblue.BCGeneralData;
import de.vw.mib.asl.internal.car.thinkblue.TBTExtensionInterface;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCCycleGeneralData;
import org.dsi.ifc.carkombi.BCLongTermGeneralData;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;

public class TBTSkodaExtension
implements Target,
TBTExtensionInterface {
    private BCGeneralData oldLongTerm = new BCGeneralData();
    private BCGeneralData sinceRefuel = new BCGeneralData();
    private AverageData longTermBluePointAvg = new AverageData();
    private AverageData sinceRefuelBluePointAvg = new AverageData();
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;

    public TBTSkodaExtension() {
        this.registerDSI();
    }

    private void registerDSI() {
        DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        DSICarKombi dSICarKombi = (DSICarKombi)dSIProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = TBTSkodaExtension.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        DSICarKombiListener dSICarKombiListener = (DSICarKombiListener)dSIProxy.getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = TBTSkodaExtension.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
        dSICarKombi.setNotification(new int[]{16, 19}, (DSIListener)dSICarKombiListener);
    }

    @Override
    public GenericEvents getMainObject() {
        return null;
    }

    @Override
    public int getTargetId() {
        return -1789980160;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public void setTargetId(int n) {
    }

    public void dsiCarKombiUpdateBCLongTermGeneral(BCLongTermGeneralData bCLongTermGeneralData, int n) {
        if (ASLTargetThinkBlue.checkForReset(bCLongTermGeneralData.distance, bCLongTermGeneralData.timeValue, this.oldLongTerm)) {
            this.longTermBluePointAvg.reset();
        }
    }

    public void dsiCarKombiUpdateBCCycleGeneral(BCCycleGeneralData bCCycleGeneralData, int n) {
        if (ASLTargetThinkBlue.checkForReset(bCCycleGeneralData.distance, bCCycleGeneralData.timeValue, this.sinceRefuel)) {
            this.sinceRefuelBluePointAvg.reset();
        }
    }

    @Override
    public void addBluePoints(int n) {
        this.longTermBluePointAvg.addValue(n);
        this.sinceRefuelBluePointAvg.addValue(n);
    }

    @Override
    public AverageData getLongTermData() {
        return this.longTermBluePointAvg;
    }

    @Override
    public AverageData getSinceRefuelData() {
        return this.sinceRefuelBluePointAvg;
    }

    @Override
    public void setLongTermData(AverageData averageData) {
        this.longTermBluePointAvg.setAverage(averageData.getAverage());
        this.longTermBluePointAvg.setCounter(averageData.getCounter());
    }

    @Override
    public void setSinceRefuelData(AverageData averageData) {
        this.sinceRefuelBluePointAvg.setAverage(averageData.getAverage());
        this.sinceRefuelBluePointAvg.setCounter(averageData.getCounter());
    }

    @Override
    public int getLongTermAverage() {
        return this.longTermBluePointAvg.calculateAverage();
    }

    @Override
    public int getSinceRefuelAverage() {
        return this.sinceRefuelBluePointAvg.calculateAverage();
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

