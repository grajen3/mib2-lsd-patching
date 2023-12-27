/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.srv.climate.impl;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerListener;
import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionListener;
import de.vw.mib.asl.api.car.vo.climate.ClimateViewOptionService;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.srv.CarEmptyTarget;
import de.vw.mib.asl.internal.car.srv.climate.impl.AirconViewOptionsMasterWrapper;
import de.vw.mib.asl.internal.car.srv.climate.impl.AirconViewOptionsRow1Wrapper;
import de.vw.mib.collections.ObjectArrayList;
import java.util.Iterator;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;

public final class ClimateViewOptionServiceImpl
extends CarEmptyTarget
implements ClimateViewOptionService,
DeviceManagerListener {
    public static final int AIRCONVIEWOPTIONSMASTER;
    public static final int AIRCONVIEWOPTIONSROW1;
    public static final int AIRCONVIEWOPTIONSROW2;
    private static ClimateViewOptionServiceImpl instance;
    ObjectArrayList listeners = new ObjectArrayList();
    private DSICarAirCondition dsiClimate;
    private DSICarAirConditionListener dsiClimateListener;
    private AirconViewOptionsMasterWrapper airconMasterWrapper;
    private AirconViewOptionsRow1Wrapper airconRowWrapper;
    private int masterDeviceReason;
    private int rowDeviceReason;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirConditionListener;

    private ClimateViewOptionServiceImpl() {
        ASLCarFactory.getCarApi().getDeviceManager().addListener(this);
        this.initDSI();
    }

    public static ClimateViewOptionServiceImpl getInstance() {
        if (instance == null) {
            instance = new ClimateViewOptionServiceImpl();
        }
        return instance;
    }

    private void initDSI() {
        this.dsiClimate = (DSICarAirCondition)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = ClimateViewOptionServiceImpl.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition);
        this.dsiClimateListener = (DSICarAirConditionListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = ClimateViewOptionServiceImpl.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener);
    }

    public void registerViewOption(int n) {
        this.dsiClimate.setNotification(n, (DSIListener)this.dsiClimateListener);
    }

    @Override
    public void addListener(ClimateViewOptionListener climateViewOptionListener) {
        this.listeners.add(climateViewOptionListener);
    }

    @Override
    public void removeListener(ClimateViewOptionListener climateViewOptionListener) {
        this.listeners.removeValue(climateViewOptionListener);
    }

    public void dsiCarAirConditionUpdateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        this.airconMasterWrapper = new AirconViewOptionsMasterWrapper(airconMasterViewOptions);
        if (this.masterDeviceReason == 0) {
            this.notifyLMasterListeners(0);
        }
    }

    private void notifyLMasterListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ClimateViewOptionListener climateViewOptionListener = (ClimateViewOptionListener)iterator.next();
            climateViewOptionListener.updateAirconMasterDivice(n);
            if (this.airconMasterWrapper == null) {
                if (this.masterDeviceReason != 14) continue;
                this.masterDeviceReason = 0;
                continue;
            }
            if (this.masterDeviceReason == 14) {
                this.masterDeviceReason = 0;
                return;
            }
            climateViewOptionListener.updateAirconViewOptionsMaster(this.airconMasterWrapper, n);
        }
    }

    public void dsiCarAirConditionUpdateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        this.airconRowWrapper = new AirconViewOptionsRow1Wrapper(airconRowViewOptions);
        if (this.rowDeviceReason == 0) {
            this.notifyLRowListeners(0);
        }
    }

    private void notifyLRowListeners(int n) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            ClimateViewOptionListener climateViewOptionListener = (ClimateViewOptionListener)iterator.next();
            climateViewOptionListener.updateAirconRow1Divice(n);
            if (this.airconRowWrapper == null) {
                if (this.rowDeviceReason != 14) continue;
                this.rowDeviceReason = 0;
                continue;
            }
            if (this.rowDeviceReason == 14) {
                this.rowDeviceReason = 0;
                return;
            }
            climateViewOptionListener.updateAirconViewOptionsRow1(this.airconRowWrapper, n);
        }
    }

    @Override
    public void onDeviceAvailableReasonChange(int n, int n2) {
        switch (n) {
            case 230: {
                this.masterDeviceReason = n2;
                this.rowDeviceReason = n2;
                if (n2 != 0) {
                    this.notifyLMasterListeners(n2);
                    this.notifyLRowListeners(n2);
                    break;
                }
                this.notifyLMasterListeners(0);
                this.notifyLRowListeners(0);
                break;
            }
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

