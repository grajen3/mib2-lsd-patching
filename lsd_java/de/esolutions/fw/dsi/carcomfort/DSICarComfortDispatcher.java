/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carcomfort;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carcomfort.DSICarComfortReply;
import de.esolutions.fw.comm.dsi.carcomfort.impl.DSICarComfortReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DSICarComfortListener;
import org.dsi.ifc.carcomfort.DoorLockingBootBlindState;
import org.dsi.ifc.carcomfort.DoorLockingComfortOpenSettings;
import org.dsi.ifc.carcomfort.DoorLockingLockStatus;
import org.dsi.ifc.carcomfort.DoorLockingMessage;
import org.dsi.ifc.carcomfort.DoorLockingRearBlind;
import org.dsi.ifc.carcomfort.DoorLockingTheftWarningSettings;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;
import org.dsi.ifc.carcomfort.DoorLockingUserListUpdateInfo;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingWindowStatus;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKResidualBatteryLifetime;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RGSBeltPretensionData;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;
import org.dsi.ifc.carcomfort.UGDOContent;
import org.dsi.ifc.carcomfort.UGDODestinationReached;
import org.dsi.ifc.carcomfort.UGDOLearningData;
import org.dsi.ifc.carcomfort.UGDOOpenDoor;
import org.dsi.ifc.carcomfort.UGDOSynchronisation;
import org.dsi.ifc.carcomfort.UGDOVersionData;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public class DSICarComfortDispatcher
extends AbstractDispatcher
implements DSICarComfortReply {
    private DSICarComfortReplyService service = new DSICarComfortReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarComfortDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = DSICarComfortDispatcher.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarComfortListener);
                    dSICarComfortListener.updateRGSViewOptions(rGSViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSViewOptions(rGSViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSBeltPretensionDataFront(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarComfortListener);
                    dSICarComfortListener.updateRGSBeltPretensionDataFront(rGSBeltPretensionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSBeltPretensionDataFront(rGSBeltPretensionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSBeltPretensionDataRear(RGSBeltPretensionData rGSBeltPretensionData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarComfortListener);
                    dSICarComfortListener.updateRGSBeltPretensionDataRear(rGSBeltPretensionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSBeltPretensionDataRear(rGSBeltPretensionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSPreCrashSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarComfortListener);
                    dSICarComfortListener.updateRGSPreCrashSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSPreCrashSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeRgsSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeRgsSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSPreSenseSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarComfortListener);
                    dSICarComfortListener.updateRGSPreSenseSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSPreSenseSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSPreSenseWarning(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarComfortListener);
                    dSICarComfortListener.updateRGSPreSenseWarning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSPreSenseWarning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRGSLocalHazardDetection(RGSLocalHazardDetection rGSLocalHazardDetection, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarComfortListener);
                    dSICarComfortListener.updateRGSLocalHazardDetection(rGSLocalHazardDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRGSLocalHazardDetection(rGSLocalHazardDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingViewOptions(doorLockingViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingViewOptions(doorLockingViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingMessage(DoorLockingMessage doorLockingMessage, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingMessage(doorLockingMessage, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingMessage(doorLockingMessage, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingLockStatus(DoorLockingLockStatus doorLockingLockStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingLockStatus(doorLockingLockStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingLockStatus(doorLockingLockStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingWindowStatus(DoorLockingWindowStatus doorLockingWindowStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingWindowStatus(doorLockingWindowStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingWindowStatus(doorLockingWindowStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingComfortOpenSettings(DoorLockingComfortOpenSettings doorLockingComfortOpenSettings, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingComfortOpenSettings(doorLockingComfortOpenSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingComfortOpenSettings(doorLockingComfortOpenSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingTheftWarningSettings(DoorLockingTheftWarningSettings doorLockingTheftWarningSettings, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingTheftWarningSettings(doorLockingTheftWarningSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingTheftWarningSettings(doorLockingTheftWarningSettings, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingClBootOpen(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingClBootOpen(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingClBootOpen(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingBootOpen(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingBootOpen(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingBootOpen(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingBootClose(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingBootClose(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingBootClose(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingUnlockingMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingUnlockingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingUnlockingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingAutoLock(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingAutoLock(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingAutoLock(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingAutoUnlock(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingAutoUnlock(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingAutoUnlock(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingClBootLock(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingClBootLock(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingClBootLock(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingMirrorProtection(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingMirrorProtection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingMirrorProtection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingConfirmation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingConfirmation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingConfirmation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingRainClosing(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingRainClosing(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingRainClosing(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingRearBlind(DoorLockingRearBlind doorLockingRearBlind, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingRearBlind(doorLockingRearBlind, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingRearBlind(doorLockingRearBlind, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteLockUnlock(String string, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingRemoteLockUnlock(string, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteBlinking(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingRemoteBlinking(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingRemoteHorn(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingRemoteHorn(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockSignatureVerification(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.receivedDoorLockingRemoteLockUnlockSignatureVerification(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void receivedDoorLockingRemoteLockUnlockAuthentification(String string, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.receivedDoorLockingRemoteLockUnlockAuthentification(string, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDoorLockingUserListRA1(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, DoorLockingUserListRA1[] doorLockingUserListRA1Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseDoorLockingUserListRA1(doorLockingUserListUpdateInfo, doorLockingUserListRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDoorLockingUserListRAF(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseDoorLockingUserListRAF(doorLockingUserListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingUserListUpdateInfo(DoorLockingUserListUpdateInfo doorLockingUserListUpdateInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingUserListUpdateInfo(doorLockingUserListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingUserListUpdateInfo(doorLockingUserListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingUserListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(58, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingUserListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingUserListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingActiveUser(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(59, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingActiveUser(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingActiveUser(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(60, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingUserProfileOnOff(doorLockingUserProfileOnOff, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingUserProfileOnOff(doorLockingUserProfileOnOff, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingUserProfileControl(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingUserProfileControl(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingUserProfileControlProcessing(boolean bl, int n, boolean bl2, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(82, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingUserProfileControlProcessing(bl, n, bl2, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingUserProfileControlProcessing(bl, n, bl2, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingWindowAutoClose(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(65, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingWindowAutoClose(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingWindowAutoClose(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingBlindsControl(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingBlindsControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingBlindsControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingBlindsControlExtended(DoorLockingBootBlindState doorLockingBootBlindState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(79, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingBlindsControlExtended(doorLockingBootBlindState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingBlindsControlExtended(doorLockingBootBlindState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingLeftSideBlindControl(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(80, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingLeftSideBlindControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingLeftSideBlindControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingRightSideBlindControl(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(81, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingRightSideBlindControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingRightSideBlindControl(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingTurnIndRepeat(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(84, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingTurnIndRepeat(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(84);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingTurnIndRepeat(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingKeyless(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(85, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingKeyless(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(85);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingKeyless(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarComfortListener);
                    dSICarComfortListener.updateWiperViewOptions(wiperViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperViewOptions(wiperViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperServicePosition(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarComfortListener);
                    dSICarComfortListener.updateWiperServicePosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperServicePosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperRainSensorOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarComfortListener);
                    dSICarComfortListener.updateWiperRainSensorOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperRainSensorOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperRainSensorConfig(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarComfortListener);
                    dSICarComfortListener.updateWiperRainSensorConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperRainSensorConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperRearWiping(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarComfortListener);
                    dSICarComfortListener.updateWiperRearWiping(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperRearWiping(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperTearsWiping(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarComfortListener);
                    dSICarComfortListener.updateWiperTearsWiping(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperTearsWiping(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWiperWinterPosition(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarComfortListener);
                    dSICarComfortListener.updateWiperWinterPosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateWiperWinterPosition(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEasyEntrySteeringColumn(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarComfortListener);
                    dSICarComfortListener.updateEasyEntrySteeringColumn(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateEasyEntrySteeringColumn(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWiperSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeWiperSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOViewOptions(uGDOViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOViewOptions(uGDOViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOLearningData(UGDOLearningData uGDOLearningData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOLearningData(uGDOLearningData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOLearningData(uGDOLearningData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDODestinationReached(UGDODestinationReached uGDODestinationReached, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarComfortListener);
                    dSICarComfortListener.updateUGDODestinationReached(uGDODestinationReached, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDODestinationReached(uGDODestinationReached, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOOpenDoor(UGDOOpenDoor uGDOOpenDoor, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOOpenDoor(uGDOOpenDoor, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOOpenDoor(uGDOOpenDoor, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOContent(UGDOContent uGDOContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOContent(uGDOContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOContent(uGDOContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOVersionData(UGDOVersionData uGDOVersionData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOVersionData(uGDOVersionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOVersionData(uGDOVersionData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUGDOSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeUGDOSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOButtonListUpdateInfo(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOButtonListUpdateInfo(uGDOButtonListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOButtonListUpdateInfo(uGDOButtonListUpdateInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUGDOButtonListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarComfortListener);
                    dSICarComfortListener.updateUGDOButtonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateUGDOButtonListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestUGDOPopup(UGDOContent uGDOContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.requestUGDOPopup(uGDOContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUGDOPopup(UGDOContent uGDOContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeUGDOPopup(uGDOContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUGDODeleteButton(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeUGDODeleteButton(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeUGDOSynchronisation(uGDOSynchronisation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeUGDOLearning(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeUGDOLearning(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestUGDOSynchronisation(UGDOSynchronisation uGDOSynchronisation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.requestUGDOSynchronisation(uGDOSynchronisation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA0(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA0[] uGDOButtonListRA0Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA1(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA1[] uGDOButtonListRA1Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA2(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA2[] uGDOButtonListRA2Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA3(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA3[] uGDOButtonListRA3Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA4(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA4[] uGDOButtonListRA4Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRA5(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, UGDOButtonListRA5[] uGDOButtonListRA5Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUGDOButtonListRAF(UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseUGDOButtonListRAF(uGDOButtonListUpdateInfo, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarComfortListener);
                    dSICarComfortListener.updateRDKViewOptions(rDKViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKViewOptions(rDKViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarComfortListener);
                    dSICarComfortListener.updateRDKSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarComfortListener);
                    dSICarComfortListener.updateRDKTireSetupTireList(rDKTireInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKTireSetupTireList(rDKTireInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKTireSetupSelectedTire(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarComfortListener);
                    dSICarComfortListener.updateRDKTireSetupSelectedTire(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKTireSetupSelectedTire(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarComfortListener);
                    dSICarComfortListener.updateRDKTireDisplay(rDKTireDisplayData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKTireDisplay(rDKTireDisplayData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKSpeedLimit(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarComfortListener);
                    dSICarComfortListener.updateRDKSpeedLimit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKSpeedLimit(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRDKTireChanged(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseRDKTireChanged(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRDKPressureChanged(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseRDKPressureChanged(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRDKLifeMonitoring() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.responseRDKLifeMonitoring();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKPressureLevel(byte by, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarComfortListener);
                    dSICarComfortListener.updateRDKPressureLevel(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKPressureLevel(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeRDKSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeRDKSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeRDKPressureChanged(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeRDKPressureChanged(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorViewOptions(mirrorViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorViewOptions(mirrorViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorLowering(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorLowering(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorLowering(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorSyncAdjust(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorSyncAdjust(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorSyncAdjust(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorFolding(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorFolding(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorFolding(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorDimming(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorDimming(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorDimming(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMirrorHeating(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarComfortListener);
                    dSICarComfortListener.updateMirrorHeating(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateMirrorHeating(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeMirrorSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeMirrorSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarComfortListener);
                    dSICarComfortListener.updateBrakeViewOptions(brakeViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateBrakeViewOptions(brakeViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrakeElectricalParking(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarComfortListener);
                    dSICarComfortListener.updateBrakeElectricalParking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateBrakeElectricalParking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrakeAutoHold(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarComfortListener);
                    dSICarComfortListener.updateBrakeAutoHold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateBrakeAutoHold(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrakeEscMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarComfortListener);
                    dSICarComfortListener.updateBrakeEscMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateBrakeEscMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrakeHdcMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(61, dSICarComfortListener);
                    dSICarComfortListener.updateBrakeHdcMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateBrakeHdcMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKDifferentialPressure(RDKWheelPressures rDKWheelPressures, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarComfortListener);
                    dSICarComfortListener.updateRDKDifferentialPressure(rDKWheelPressures, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKDifferentialPressure(rDKWheelPressures, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDKResidualBatteryLifetime(RDKResidualBatteryLifetime rDKResidualBatteryLifetime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarComfortListener);
                    dSICarComfortListener.updateRDKResidualBatteryLifetime(rDKResidualBatteryLifetime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateRDKResidualBatteryLifetime(rDKResidualBatteryLifetime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeDoorLockingPrompt(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.acknowledgeDoorLockingPrompt(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestDoorLockingPrompt(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.requestDoorLockingPrompt(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDoorLockingPromptContent(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    this.confirmNotificationListener(83, dSICarComfortListener);
                    dSICarComfortListener.updateDoorLockingPromptContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)iterator.next();
                    dSICarComfortListener.updateDoorLockingPromptContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    dSICarComfortListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarComfortListener dSICarComfortListener = (DSICarComfortListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarComfortDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarComfortDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarComfortListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
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

