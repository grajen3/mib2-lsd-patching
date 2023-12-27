/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.comfort;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;

public class HsmTargetCarOpenClose
extends AbstractASLTarget {
    private DSICarComfort dsiCarComfort;
    private DSICarComfortListener dsiCarComfortListener;
    private DoorLockingComfortOpenSettings comfortOpenWindowSettings;
    private boolean OPENCLOSE_AUTOLOCK_ACTIVESTATE;
    private boolean OPENCLOSE_AUTOTRUNKOPENING_ACTIVESTATE;
    private boolean OPENCLOSE_AUTOUNLOCK_ACTIVESTATE;
    private boolean OPENCLOSE_RAINPROTECTION_ACTIVESTATE;
    private boolean OPENCLOSE_THEFT_PROTECTION;
    private boolean OPENCLOSE_BOOT_COVER;
    private boolean isEasyEntryActive;
    private static final int NUMBER_OF_WINDOW;
    private boolean isWindowAutoClose;
    private DoorLockingTheftWarningSettings theftWarningSettings;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;

    public HsmTargetCarOpenClose(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1907420672;
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{386662464, 353108032, 369885248, 436994112, 470548544, 403439680, 420216896, 604708864, 453771328, 470614080, 537722944, 554500160, 1410138176, 1393360960});
    }

    private void registerOnCarComfort() {
        this.dsiCarComfort.setNotification(new int[]{14, 8, 13, 19, 11, 15, 18, 9, 28, 65, 12, 5, 84, 20}, (DSIListener)this.dsiCarComfortListener);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event for CarOpenClose: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarOpenClose.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
                this.dsiCarComfortListener = (DSICarComfortListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarOpenClose.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener);
                this.comfortOpenWindowSettings = new DoorLockingComfortOpenSettings();
                this.theftWarningSettings = new DoorLockingTheftWarningSettings();
                this.registerOnModelEvents();
                this.registerOnCarComfort();
                this.initDefaultValues();
                break;
            }
            case 2100004: {
                this.evaluateComfortOpenSettings();
                break;
            }
            case 1073744919: {
                this.toggleAutoLock(!this.OPENCLOSE_AUTOLOCK_ACTIVESTATE);
                break;
            }
            case 1073744917: {
                this.toggleComfortOpen(eventGeneric.getInt(0));
                break;
            }
            case 1073744918: {
                this.toggleManualUnlock(eventGeneric.getInt(0));
                break;
            }
            case 1073744922: {
                this.toggleAutoTrunkOpening(!this.OPENCLOSE_AUTOTRUNKOPENING_ACTIVESTATE);
                break;
            }
            case 1073744924: {
                this.toggleRainClosing(!this.OPENCLOSE_RAINPROTECTION_ACTIVESTATE);
                break;
            }
            case 1073744920: {
                this.toggleAutoUnlock(!this.OPENCLOSE_AUTOUNLOCK_ACTIVESTATE);
                break;
            }
            case 1073744921: {
                this.toggleTheftProtection(!this.OPENCLOSE_THEFT_PROTECTION);
                break;
            }
            case 1073744923: {
                this.comfortOpenWindowSettings.rearBlind = !this.OPENCLOSE_BOOT_COVER;
                this.dsiCarComfort.setDoorLockingComfortOpenSettings(this.comfortOpenWindowSettings);
                break;
            }
            case 1073745180: {
                this.dsiCarComfort.setEasyEntrySteeringColumn(!this.isEasyEntryActive);
                break;
            }
            case 1073745184: {
                this.dsiCarComfort.setDoorLockingWindowAutoClose(!this.isWindowAutoClose);
                break;
            }
            case 1073745185: {
                this.theftWarningSettings.interior = !this.theftWarningSettings.interior;
                this.dsiCarComfort.setDoorLockingTheftWarningSettings(this.theftWarningSettings);
                break;
            }
            case 1073745236: {
                DoorLockingRearBlind doorLockingRearBlind = new DoorLockingRearBlind();
                doorLockingRearBlind.rearBlindButton = false;
                doorLockingRearBlind.rearBlindSunProtection = false;
                doorLockingRearBlind.rearBlindReverseGear = true == eventGeneric.getBoolean(0);
                this.dsiCarComfort.setDoorLockingRearBlind(doorLockingRearBlind);
                break;
            }
            case 1073745235: {
                this.dsiCarComfort.setDoorLockingTurnIndRepeat(true == eventGeneric.getBoolean(0));
                break;
            }
        }
    }

    private void toggleAutoLock(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle autolock. Value: ").append(bl).log();
        }
        this.dsiCarComfort.setDoorLockingAutoLock(bl ? 2 : 0);
    }

    private void toggleComfortOpen(int n) {
        switch (n) {
            case 0: {
                if (ASLCarContainer.getInstance().getNumberOfWindows() == 4) {
                    this.comfortOpenWindowSettings.driverWindow = true;
                    this.comfortOpenWindowSettings.codriverWindow = true;
                    this.comfortOpenWindowSettings.driverRearWindow = true;
                    this.comfortOpenWindowSettings.codriverRearWindow = true;
                } else {
                    this.comfortOpenWindowSettings.driverWindow = true;
                    this.comfortOpenWindowSettings.codriverWindow = true;
                    this.comfortOpenWindowSettings.driverRearWindow = false;
                    this.comfortOpenWindowSettings.codriverRearWindow = false;
                }
                if (!ASLCarContainer.getInstance().getSunRoofAvailable()) break;
                this.comfortOpenWindowSettings.sunRoof = true;
                break;
            }
            case 1: {
                this.comfortOpenWindowSettings.driverWindow = true;
                this.comfortOpenWindowSettings.codriverWindow = false;
                this.comfortOpenWindowSettings.driverRearWindow = false;
                this.comfortOpenWindowSettings.codriverRearWindow = false;
                this.comfortOpenWindowSettings.sunRoof = false;
                break;
            }
            case 2: {
                this.comfortOpenWindowSettings.driverWindow = false;
                this.comfortOpenWindowSettings.codriverWindow = false;
                this.comfortOpenWindowSettings.driverRearWindow = false;
                this.comfortOpenWindowSettings.codriverRearWindow = false;
                this.comfortOpenWindowSettings.sunRoof = false;
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[ERROR] Unknown ID for ComfortOpen!").log();
            }
        }
        this.dsiCarComfort.setDoorLockingComfortOpenSettings(this.comfortOpenWindowSettings);
    }

    private void toggleAutoTrunkOpening(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle auto trunk open. Value: ").append(bl).log();
        }
        this.dsiCarComfort.setDoorLockingBootOpen(bl);
    }

    private void toggleManualUnlock(int n) {
        switch (n) {
            case 0: {
                this.dsiCarComfort.setDoorLockingUnlockingMode(3);
                break;
            }
            case 1: {
                this.dsiCarComfort.setDoorLockingUnlockingMode(1);
                break;
            }
            case 2: {
                this.dsiCarComfort.setDoorLockingUnlockingMode(2);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[INFO] Car.OpenClose: selection  does not exists for manual unlock!").log();
            }
        }
    }

    private void toggleRainClosing(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle rain closing. value: ").append(bl).log();
        }
        this.dsiCarComfort.setDoorLockingRainClosing(bl);
    }

    private void toggleAutoUnlock(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle auto unlock. value: ").append(bl).log();
        }
        this.dsiCarComfort.setDoorLockingAutoUnlock(bl);
    }

    private void toggleTheftProtection(boolean bl) {
        if (this.isTraceEnabled()) {
            this.trace().append("toggle theft protection. value: ").append(bl).log();
        }
        this.dsiCarComfort.setDoorLockingConfirmation(bl);
    }

    public void dsiCarComfortUpdateDoorLockingAutoLock(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: DoorLockingAutoLock. Values: ").append(n).log();
        }
        this.OPENCLOSE_AUTOLOCK_ACTIVESTATE = n != 0;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10202, this.OPENCLOSE_AUTOLOCK_ACTIVESTATE);
    }

    public void dsiCarComfortUpdateDoorLockingUnlockingMode(int n, int n2) {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: DoorLockingSettings. Values: ").append(n).log();
        }
        switch (n) {
            case 1: {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10200, 1);
                break;
            }
            case 2: {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10200, 2);
                break;
            }
            case 3: {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10200, 0);
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("[INFO] Car.OpenClose: update does not exists for manual unlock!").log();
            }
        }
    }

    public void dsiCarComfortUpdateEasyEntrySteeringColumn(boolean bl, int n) {
        this.isEasyEntryActive = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10587, this.isEasyEntryActive);
    }

    public void dsiCarComfortUpdateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
        this.theftWarningSettings = doorLockingTheftWarningSettings;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10591, doorLockingTheftWarningSettings.interior);
    }

    public void dsiCarComfortUpdateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        this.comfortOpenWindowSettings = doorLockingComfortOpenSettings;
        this.OPENCLOSE_BOOT_COVER = this.comfortOpenWindowSettings.isRearBlind();
        HsmTargetCarOpenClose.writeBooleanToDatapool(10206, this.OPENCLOSE_BOOT_COVER);
        this.evaluateComfortOpenSettings();
    }

    public void dsiCarComfortUpdateDoorLockingRainClosing(boolean bl, int n) {
        this.OPENCLOSE_RAINPROTECTION_ACTIVESTATE = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10207, bl);
    }

    public void dsiCarComfortUpdateDoorLockingWindowAutoClose(boolean bl, int n) {
        this.isWindowAutoClose = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10589, this.isWindowAutoClose);
    }

    public void dsiCarComfortUpdateDoorLockingBootOpen(boolean bl, int n) {
        this.OPENCLOSE_AUTOTRUNKOPENING_ACTIVESTATE = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10205, bl);
    }

    public void dsiCarComfortUpdateDoorLockingAutoUnlock(boolean bl, int n) {
        this.OPENCLOSE_AUTOUNLOCK_ACTIVESTATE = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10203, bl);
    }

    public void dsiCarComfortUpdateDoorLockingConfirmation(boolean bl, int n) {
        this.OPENCLOSE_THEFT_PROTECTION = bl;
        HsmTargetCarOpenClose.writeBooleanToDatapool(10204, bl);
    }

    public void dsiCarComfortUpdateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        if (1 == n && 2 == doorLockingViewOptions.rearBlind.state && 0 == doorLockingViewOptions.rearBlind.reason) {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10893, true);
        } else {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10893, false);
        }
        if (1 == n && 2 == doorLockingViewOptions.turnIndRepeat.state && 0 == doorLockingViewOptions.turnIndRepeat.reason) {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10894, true);
        } else {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10894, false);
        }
    }

    public void dsiCarComfortUpdateDoorLockingTurnIndRepeat(boolean bl, int n) {
        HsmTargetCarOpenClose.writeBooleanToDatapool(10890, bl);
    }

    public void dsiCarComfortUpdateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        if (1 == n && doorLockingRearBlind.rearBlindReverseGear && !doorLockingRearBlind.rearBlindButton && !doorLockingRearBlind.rearBlindSunProtection) {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10892, true);
        } else {
            HsmTargetCarOpenClose.writeBooleanToDatapool(10892, false);
        }
    }

    private void evaluateComfortOpenSettings() {
        if (this.isTraceEnabled()) {
            this.trace().append("DSI UPDATE: DoorLockingSettings. Values: ").append(this.comfortOpenWindowSettings.toString()).log();
            this.trace().append("IS SUN ROOF: ").append(ASLCarContainer.getInstance().getSunRoofAvailable()).log();
        }
        if (ASLCarContainer.getInstance().getNumberOfWindows() == 4) {
            if (ASLCarContainer.getInstance().getSunRoofAvailable()) {
                if (this.comfortOpenWindowSettings.isDriverWindow() && this.comfortOpenWindowSettings.isCodriverWindow() && this.comfortOpenWindowSettings.isCodriverRearWindow() && this.comfortOpenWindowSettings.isDriverRearWindow() && this.comfortOpenWindowSettings.isSunRoof()) {
                    HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 0);
                } else if (!(!this.comfortOpenWindowSettings.isDriverWindow() || this.comfortOpenWindowSettings.isCodriverWindow() || this.comfortOpenWindowSettings.isCodriverRearWindow() || this.comfortOpenWindowSettings.isDriverRearWindow() || this.comfortOpenWindowSettings.isSunRoof())) {
                    HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 1);
                } else if (!(this.comfortOpenWindowSettings.isDriverWindow() || this.comfortOpenWindowSettings.isCodriverWindow() || this.comfortOpenWindowSettings.isCodriverRearWindow() || this.comfortOpenWindowSettings.isDriverRearWindow() || this.comfortOpenWindowSettings.isSunRoof())) {
                    HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 2);
                }
            } else if (this.comfortOpenWindowSettings.isDriverWindow() && this.comfortOpenWindowSettings.isCodriverWindow() && this.comfortOpenWindowSettings.isCodriverRearWindow() && this.comfortOpenWindowSettings.isDriverRearWindow()) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 0);
            } else if (this.comfortOpenWindowSettings.isDriverWindow() && !this.comfortOpenWindowSettings.isCodriverWindow() && !this.comfortOpenWindowSettings.isCodriverRearWindow() && !this.comfortOpenWindowSettings.isDriverRearWindow()) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 1);
            } else if (!(this.comfortOpenWindowSettings.isDriverWindow() || this.comfortOpenWindowSettings.isCodriverWindow() || this.comfortOpenWindowSettings.isCodriverRearWindow() || this.comfortOpenWindowSettings.isDriverRearWindow())) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 2);
            }
        } else if (ASLCarContainer.getInstance().getSunRoofAvailable()) {
            if (this.comfortOpenWindowSettings.isDriverWindow() && this.comfortOpenWindowSettings.isCodriverWindow() && this.comfortOpenWindowSettings.isSunRoof()) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 0);
            } else if (this.comfortOpenWindowSettings.isDriverWindow() && !this.comfortOpenWindowSettings.isCodriverWindow() && !this.comfortOpenWindowSettings.isSunRoof()) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 1);
            } else if (!(this.comfortOpenWindowSettings.isDriverWindow() || this.comfortOpenWindowSettings.isCodriverWindow() || this.comfortOpenWindowSettings.isSunRoof())) {
                HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 2);
            }
        } else if (this.comfortOpenWindowSettings.driverWindow && this.comfortOpenWindowSettings.codriverWindow) {
            HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 0);
        } else if (this.comfortOpenWindowSettings.driverWindow && !this.comfortOpenWindowSettings.codriverWindow) {
            HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 1);
        } else if (!this.comfortOpenWindowSettings.driverWindow && !this.comfortOpenWindowSettings.codriverWindow) {
            HsmTargetCarOpenClose.writeIntegerToDatapool(10199, 2);
        }
    }

    private void initDefaultValues() {
        this.OPENCLOSE_AUTOLOCK_ACTIVESTATE = false;
        this.OPENCLOSE_RAINPROTECTION_ACTIVESTATE = false;
        this.OPENCLOSE_AUTOTRUNKOPENING_ACTIVESTATE = false;
        this.OPENCLOSE_AUTOUNLOCK_ACTIVESTATE = false;
        this.OPENCLOSE_THEFT_PROTECTION = false;
        this.OPENCLOSE_BOOT_COVER = false;
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

