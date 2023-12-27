/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.daynight;

import de.vw.mib.asl.api.system.daynight.DayNightListener;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.system.daynight.DayNightServiceImpl$1;
import de.vw.mib.asl.internal.system.daynight.DayNightServiceImpl$2;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;

public class DayNightServiceImpl
implements DayNightService {
    private final Set listeners = new HashSet();
    private final Logger logger;
    private final DSIProxy dsiProxy;
    private int dayNightModeSensorValue = 1;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    private VehicleStatesListenerAdapter dsiListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public DayNightServiceImpl(DSIProxy dSIProxy, Logger logger) {
        this.dsiProxy = dSIProxy;
        this.logger = logger;
        this.connectToDsi();
        dSIProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DayNightServiceImpl.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this.createDsiServiceStateAdapter());
    }

    @Override
    public int getDayNightModeSensorValue() {
        return this.dayNightModeSensorValue;
    }

    @Override
    public void addListener(DayNightListener dayNightListener) {
        Preconditions.checkArgumentNotNull(dayNightListener);
        Preconditions.checkArgument(!this.listeners.contains(dayNightListener), "Same listener was added before");
        this.listeners.add(dayNightListener);
    }

    @Override
    public void removeListener(DayNightListener dayNightListener) {
        this.listeners.remove(dayNightListener);
    }

    void updateDayNightModeSenorValue(int n) {
        this.dayNightModeSensorValue = n;
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            DayNightListener dayNightListener = (DayNightListener)iterator.next();
            dayNightListener.onDayNightModeSensorValueChanged(n);
        }
    }

    void connectToDsi() {
        try {
            if (this.dsiListener == null) {
                this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)this.dsiProxy.getService(null, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = DayNightServiceImpl.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                this.dsiListener = this.createGeneralVehicleStatesListener();
                this.dsiProxy.addResponseListener(null, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = DayNightServiceImpl.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener, this.dsiListener);
            }
            this.dsiGeneralVehicleStates.setNotification(16, (DSIListener)this.dsiListener);
        }
        catch (Throwable throwable) {
            this.logger.info(2048, "Could not connect to DSIGeneralVehicleStates");
        }
    }

    private VehicleStatesListenerAdapter createGeneralVehicleStatesListener() {
        return new DayNightServiceImpl$1(this);
    }

    private DSIServiceStateListenerAdapter createDsiServiceStateAdapter() {
        return new DayNightServiceImpl$2(this);
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

