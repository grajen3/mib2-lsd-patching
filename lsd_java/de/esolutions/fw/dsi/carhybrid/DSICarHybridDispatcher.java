/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carhybrid;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridReply;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class DSICarHybridDispatcher
extends AbstractDispatcher
implements DSICarHybridReply {
    private DSICarHybridReplyService service = new DSICarHybridReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarHybridDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = DSICarHybridDispatcher.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarHybridListener);
                    dSICarHybridListener.updateHybridViewOptions(hybridViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridViewOptions(hybridViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridCharge(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarHybridListener);
                    dSICarHybridListener.updateHybridCharge(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridCharge(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarHybridListener);
                    dSICarHybridListener.updateHybridEnergyFlowState(hybridEnergyFlowState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridEnergyFlowState(hybridEnergyFlowState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridRecoveredEnergy(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarHybridListener);
                    dSICarHybridListener.updateHybridRecoveredEnergy(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridRecoveredEnergy(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridEnergyFlow(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarHybridListener);
                    dSICarHybridListener.updateHybridEnergyFlow(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridEnergyFlow(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridEnergyAssistControl(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarHybridListener);
                    dSICarHybridListener.updateHybridEnergyAssistControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridEnergyAssistControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridEnergyAssistState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarHybridListener);
                    dSICarHybridListener.updateHybridEnergyAssistState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridEnergyAssistState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlViewOptions(batteryControlViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlViewOptions(batteryControlViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlPlug(batteryControlPlug, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlPlug(batteryControlPlug, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlChargeState(batteryControlChargeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlChargeState(batteryControlChargeState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlClimateState(batteryControlClimateState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlClimateState(batteryControlClimateState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTimerState(batteryControlTimerState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTimerState(batteryControlTimerState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTimer1(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTimer1(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTimer2(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTimer2(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTimer3(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTimer3(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTimer4(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTimer4(batteryControlTimer, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTotalNumberOfProfiles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTotalNumberOfProfiles(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlProfilesListUpdateInfo(batteryControlProfilesAH, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlProfilesListUpdateInfo(batteryControlProfilesAH, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlTotalNumberOfPowerProvider(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlTotalNumberOfPowerProvider(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlPowerProviderListUpdateInfo(batteryControlPowerProviderAH, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlPowerProviderListUpdateInfo(batteryControlPowerProviderAH, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeBatteryControlSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.acknowledgeBatteryControlSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.acknowledgeBatteryControlImmediately(bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA0(batteryControlProfilesAH, batteryControlProfileRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA1(batteryControlProfilesAH, batteryControlProfileRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA2(batteryControlProfilesAH, batteryControlProfileRA2Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA3(batteryControlProfilesAH, batteryControlProfileRA3Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA4(batteryControlProfilesAH, batteryControlProfileRA4Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA5(batteryControlProfilesAH, batteryControlProfileRA5Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA6(batteryControlProfilesAH, batteryControlProfileRA6Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRA7(batteryControlProfilesAH, batteryControlProfileRA7Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responseProfileListRAF(batteryControlProfilesAH, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responsePowerProviderListRA0(batteryControlPowerProviderAH, batteryControlPowerProviderRA0Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responsePowerProviderListRA1(batteryControlPowerProviderAH, batteryControlPowerProviderRA1Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responsePowerProviderListRA2(batteryControlPowerProviderAH, batteryControlPowerProviderRA2Array);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responsePowerProviderListRAE(batteryControlPowerProviderAH, batteryControlPowerProviderRAEArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.responsePowerProviderListRAF(batteryControlPowerProviderAH, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridTargetRange(HybridTargetRange hybridTargetRange, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarHybridListener);
                    dSICarHybridListener.updateHybridTargetRange(hybridTargetRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridTargetRange(hybridTargetRange, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        if ((n4 & 0x80) == 128) {
            n4 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlPastErrorReason(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlPastErrorReason(n, n2, n3, n4);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlPlugDisplayState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlPlugDisplayState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlRemainingChargeTime(BatteryControlRemainingChargeTime batteryControlRemainingChargeTime, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlRemainingChargeTime(batteryControlRemainingChargeTime, batteryControlRemainingChargeTime2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlRemainingChargeTime(batteryControlRemainingChargeTime, batteryControlRemainingChargeTime2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlLowestMaxCurrent(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarHybridListener);
                    dSICarHybridListener.updateBatteryControlLowestMaxCurrent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateBatteryControlLowestMaxCurrent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridInhibitReason(HybridInhibitReason hybridInhibitReason, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarHybridListener);
                    dSICarHybridListener.updateHybridInhibitReason(hybridInhibitReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridInhibitReason(hybridInhibitReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHybridActivePedal(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarHybridListener);
                    dSICarHybridListener.updateHybridActivePedal(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)iterator.next();
                    dSICarHybridListener.updateHybridActivePedal(bl, n);
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
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    dSICarHybridListener.asyncException(n, string, n2);
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
                    DSICarHybridListener dSICarHybridListener = (DSICarHybridListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarHybridDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarHybridDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarHybridListener, new Object[]{string, string2});
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

