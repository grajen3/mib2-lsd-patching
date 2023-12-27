/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.e_traction.BatterManagerMainController;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlAvailable;
import de.vw.mib.asl.internal.car.e_traction.StateBatteryControlNotAvailable;
import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlCollector;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;

public class HsmTargetBatteryManager
extends AbstractASLHsmTarget
implements CarLogger {
    DSICarHybrid dsiCarHybrid;
    DSIListener dsiCarHybirdListener;
    private DSICarTimeUnitsLanguage dsiCarTimeUnitsLanguage;
    private HsmState stateBatteryControlAvailable;
    private HsmState stateBatteryControlNotAvailable;
    protected BatterManagerMainController batterManagerMainController;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener;

    HsmState getStateBatteryControlAvailable() {
        if (this.stateBatteryControlAvailable == null) {
            this.stateBatteryControlAvailable = new StateBatteryControlAvailable(this, this.hsm, "stateBatteryControlAvailable", this.getWorkStateParent());
        }
        return this.stateBatteryControlAvailable;
    }

    HsmState getStateBatteryControlNotAvailable() {
        if (this.stateBatteryControlNotAvailable == null) {
            this.stateBatteryControlNotAvailable = new StateBatteryControlNotAvailable(this, this.hsm, "stateBatteryContorlNotAvailable", this.getWorkStateParent());
        }
        return this.stateBatteryControlNotAvailable;
    }

    BatterManagerMainController getBatterManagerMainController() {
        if (this.batterManagerMainController == null) {
            this.batterManagerMainController = new BatterManagerMainController(this);
        }
        return this.batterManagerMainController;
    }

    public HsmTargetBatteryManager(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getDefaultTargetId() {
        return -2008083968;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.getStateBatteryControlNotAvailable();
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    void init() {
        this.dsiCarHybrid = (DSICarHybrid)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = HsmTargetBatteryManager.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid);
        this.dsiCarHybirdListener = ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = HsmTargetBatteryManager.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener);
        this.dsiCarTimeUnitsLanguage = (DSICarTimeUnitsLanguage)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage = HsmTargetBatteryManager.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguage);
    }

    void registerModelEvents() {
        this.addObservers(new int[]{-1911816128, -1811152832, -1861484480, -1844707264, -1895038912, -1509162944, -1525940160, -1492385728, -1693712320, -1442054080, -1458831296, -1425276864, -1744043968, -1760821184, -1727266752, -1777598400, -1710489536, -1626603456, -1593049024, -1576271808, -1794375616, -1559494592, -1542717376, -1475608512, -1408499648, -1643380672, -1307836352, -1358168000, -1324613568, -1676935104, -1291059136, -1391722432, -955514816, -1190395840, -1022623680, -1106509760, -921960384, -938737600, 135069760, -1123286976, 118292544, -502595520, -1223950272, -1660157888, -552861632, 487391296, -1173618624, -1140064192, 504168512, -1005846464, -972292032, 638386240, 655163456, 571277376});
    }

    void registerOnCharingState() {
        this.dsiCarHybrid.setNotification(new int[]{8, 7, 9}, this.dsiCarHybirdListener);
    }

    void registerOnCarHybridViewOptions() {
        this.dsiCarHybrid.setNotification(new int[]{6}, this.dsiCarHybirdListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = HsmTargetBatteryManager.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener, this.dsiCarHybirdListener);
    }

    void registerOnCarHybridTotalNumbersOfProfiles() {
        this.dsiCarHybrid.setNotification(new int[]{15}, this.dsiCarHybirdListener);
    }

    void registerOnCarHybridProfilesListUpdateInfo() {
        this.dsiCarHybrid.setNotification(new int[]{16}, this.dsiCarHybirdListener);
    }

    void clearOnCarHybridProfilesListUpdateInfo() {
        this.dsiCarHybrid.clearNotification(new int[]{16}, this.dsiCarHybirdListener);
    }

    void registerOnTimer() {
        this.dsiCarHybrid.setNotification(new int[]{11, 12, 13}, this.dsiCarHybirdListener);
    }

    void clearOnTimer() {
        this.dsiCarHybrid.clearNotification(new int[]{11, 12, 13}, this.dsiCarHybirdListener);
    }

    void registerOnTimerState() {
        this.dsiCarHybrid.setNotification(new int[]{10}, this.dsiCarHybirdListener);
    }

    void clearOnTimerState() {
        this.dsiCarHybrid.clearNotification(new int[]{10}, this.dsiCarHybirdListener);
    }

    void registerOnAmPm() {
        this.dsiCarTimeUnitsLanguage.setNotification(new int[]{2, 3, 19, 13}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this.getHsm(), class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener == null ? (class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener = HsmTargetBatteryManager.class$("org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener")) : class$org$dsi$ifc$cartimeunitslanguage$DSICarTimeUnitsLanguageListener));
    }

    void registerOnPowerProviderTotalNumbers() {
        this.dsiCarHybrid.setNotification(new int[]{17}, this.dsiCarHybirdListener);
    }

    void registerOnPowerProviderListUpdateInfo() {
        this.dsiCarHybrid.setNotification(new int[]{18}, this.dsiCarHybirdListener);
    }

    void clearOnPowerProviderListUpdateInfo() {
        this.dsiCarHybrid.clearNotification(new int[]{18}, this.dsiCarHybirdListener);
    }

    void registerOnActivePedal() {
        this.dsiCarHybrid.setNotification(new int[]{27}, this.dsiCarHybirdListener);
    }

    boolean isTimerIsActive(boolean bl, boolean bl2) {
        return bl;
    }

    BatteryControlCollector createNewEntry(int n, int n2, int n3, String string, int n4, boolean bl, boolean bl2, int n5) {
        return new BatteryControlCollector(n, 0, 0, n4, n3, string, bl, bl2, false, false, 0, 0, 0, 0, n2, n2 != 0, n5);
    }

    int getWeekDayHmi(int n) {
        switch (n) {
            case 1: {
                return 6;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 7: {
                return 5;
            }
        }
        return -1;
    }

    boolean isExisting(BatteryControlViewOptions batteryControlViewOptions) {
        return batteryControlViewOptions.getProfileList().getState() != 2 || batteryControlViewOptions.getTimer1().getState() != 2 || batteryControlViewOptions.getTimer2().getState() != 2 || batteryControlViewOptions.getTimer3().getState() != 2 || batteryControlViewOptions.getTimerState().getState() != 2;
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

