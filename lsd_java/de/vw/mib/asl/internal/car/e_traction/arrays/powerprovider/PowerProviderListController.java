/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListArrayElementAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListContext;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListDsiAdapter;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListDsiListener;
import de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderModelUpdater;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlPowerProviderCollector;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;

public class PowerProviderListController
extends PowerProviderModelUpdater
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private PowerProviderListContext _context;
    private ASGArrayList _PowerProviderArrayList;
    private PowerProviderListDsiListener _PowerProviderListDsiListener;
    private static final int HIGH_LEVEL_RETRY_B_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_B_RETRY_TIME;
    private int MIN_NUMBER_TO_REQUEST = 4;
    public static int INDEX_NOT_FOUND;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$car$e_traction$arrays$powerprovider$PowerProviderListArrayElementAdapter;

    public PowerProviderListController(PowerProviderListContext powerProviderListContext) {
        super(powerProviderListContext);
        this._context = powerProviderListContext;
    }

    private PowerProviderListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    private ASGArrayList getPowerProviderListArrayList() {
        if (this._PowerProviderArrayList == null) {
            this._PowerProviderArrayList = new ArrayListFactory().createCompleteArrayList(this, this, this, 1, 0, true, 4, 0);
        }
        return this._PowerProviderArrayList;
    }

    public PowerProviderListDsiListener getPowerProviderListDsiListener() {
        if (this._PowerProviderListDsiListener == null) {
            this._PowerProviderListDsiListener = new PowerProviderListDsiAdapter(this.getContext(), this.getPowerProviderListArrayList());
        }
        return this._PowerProviderListDsiListener;
    }

    @Override
    public void reloaded(ASGArrayList aSGArrayList) {
        super.reloaded(aSGArrayList);
        if (!aSGArrayList.isLoading()) {
            this.getContext().powerProviderListLoadedState(true);
        }
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return BapArrayFactory.getInstance().createBapSetGetArray(class$de$vw$mib$asl$internal$car$e_traction$arrays$powerprovider$PowerProviderListArrayElementAdapter == null ? (class$de$vw$mib$asl$internal$car$e_traction$arrays$powerprovider$PowerProviderListArrayElementAdapter = PowerProviderListController.class$("de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider.PowerProviderListArrayElementAdapter")) : class$de$vw$mib$asl$internal$car$e_traction$arrays$powerprovider$PowerProviderListArrayElementAdapter);
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new PowerProviderListArrayElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        PowerProviderListArrayElementAdapter powerProviderListArrayElementAdapter;
        PowerProviderListArrayElementAdapter powerProviderListArrayElementAdapter2 = (PowerProviderListArrayElementAdapter)bAPArrayElement;
        PowerProviderListArrayElementAdapter powerProviderListArrayElementAdapter3 = (PowerProviderListArrayElementAdapter)bAPArrayElement2;
        switch (n) {
            case 0: {
                powerProviderListArrayElementAdapter = powerProviderListArrayElementAdapter2;
                break;
            }
            case 1: 
            case 2: {
                powerProviderListArrayElementAdapter = powerProviderListArrayElementAdapter3;
                powerProviderListArrayElementAdapter.NR_StartHour = powerProviderListArrayElementAdapter2.NR_StartHour;
                powerProviderListArrayElementAdapter.NR_EndHour = powerProviderListArrayElementAdapter2.NR_EndHour;
                powerProviderListArrayElementAdapter.NR_StartMinutes = powerProviderListArrayElementAdapter2.NR_StartMinutes;
                powerProviderListArrayElementAdapter.NR_EndMinutes = powerProviderListArrayElementAdapter2.NR_EndMinutes;
                break;
            }
            default: {
                powerProviderListArrayElementAdapter = powerProviderListArrayElementAdapter2;
                this.getContextLoger().error("PowerProviderList: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return powerProviderListArrayElementAdapter;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return BapArrayFactory.getInstance().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        BatteryControlPowerProviderAH batteryControlPowerProviderAH = new BatteryControlPowerProviderAH(n, bAPGetArray.getTransactionId(), arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getAsgId());
        this.getContext().getCarHybrid().requestBatteryControlPowerProviderList(batteryControlPowerProviderAH);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        switch (bAPSetGetArray.getArrayHeader().getRecordAddress()) {
            case 2: {
                Object object;
                int n;
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array = new BatteryControlPowerProviderRA2[bAPArrayElementArray.length];
                int n2 = bAPArrayElementArray.length;
                for (n = 0; n < n2; ++n) {
                    object = (PowerProviderListArrayElementAdapter)bAPArrayElementArray[n];
                    batteryControlPowerProviderRA2Array[n] = ((PowerProviderListArrayElementAdapter)object).toPowerProviderListRA2();
                }
                n = BapArrayFactory.getInstance().getBAPArrayConverter().toArrayContent(bAPSetGetArray);
                ArrayHeader arrayHeader = bAPSetGetArray.getArrayHeader();
                object = new BatteryControlPowerProviderAH(n, bAPSetGetArray.getTransactionId(), arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPSetGetArray.getAsgId());
                this.getContext().getCarHybrid().setBatteryControlPowerProviderRA2((BatteryControlPowerProviderAH)object, batteryControlPowerProviderRA2Array);
                break;
            }
        }
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        this.getContextLoger().error("ProwerProviderList: Request time out for ProwerProviderList request9000");
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = this.MIN_NUMBER_TO_REQUEST;
                break;
            }
            default: {
                n2 = this.MIN_NUMBER_TO_REQUEST + 1;
            }
        }
        return n2;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("PowerProviderList: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("PowerProviderList: Unknown log message called");
            }
        }
    }

    public boolean modifyProfile(int n) {
        boolean bl = false;
        int n2 = this.getPowerProviderListArrayList().size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPArrayElement bAPArrayElement = this.getPowerProviderListArrayList().get(i2);
            if (bAPArrayElement.getPos() != n) continue;
            this.getPowerProviderListArrayList().deleteArrayElements(this.getPowerProviderListArrayList().getElements(i2, 1), 2);
            bl = true;
            break;
        }
        return bl;
    }

    public void reloadData() {
        this.getContext().powerProviderListLoadedState(false);
        this.getPowerProviderListArrayList().reloadData();
    }

    public void stopLoadingData() {
        this.getPowerProviderListArrayList().stopFetchingData();
    }

    public int getIndexOfProvider(int n) {
        int n2 = INDEX_NOT_FOUND;
        int n3 = this.getPowerProviderListArrayList().size();
        for (int i2 = 0; i2 < n3; ++i2) {
            BAPArrayElement bAPArrayElement = this.getPowerProviderListArrayList().get(i2);
            if (bAPArrayElement.getPos() != n) continue;
            n2 = i2;
            break;
        }
        return n2;
    }

    public BatteryControlPowerProviderCollector getPowerProviderElement(int n) {
        return (BatteryControlPowerProviderCollector)((Object)this.getPowerProviderListArrayList().get(n));
    }

    @Override
    protected void updatePowerProviderList(ASGArrayList aSGArrayList) {
        super.updatePowerProviderList(aSGArrayList);
        this.getContext().powerProviderListUpdated();
    }

    public boolean modifyPowerProviderElement(BatteryControlPowerProviderCollector batteryControlPowerProviderCollector) {
        boolean bl;
        int n = this.getIndexOfProvider(batteryControlPowerProviderCollector.posID);
        if (n != INDEX_NOT_FOUND) {
            this.getPowerProviderListArrayList().modifyArrayElement((PowerProviderListArrayElementAdapter)batteryControlPowerProviderCollector, 2);
            bl = true;
        } else {
            bl = false;
        }
        return bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        INDEX_NOT_FOUND = -1;
    }
}

