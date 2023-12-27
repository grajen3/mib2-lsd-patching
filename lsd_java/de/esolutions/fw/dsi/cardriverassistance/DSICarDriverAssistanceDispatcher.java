/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.cardriverassistance;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.cardriverassistance.DSICarDriverAssistanceReply;
import de.esolutions.fw.comm.dsi.cardriverassistance.impl.DSICarDriverAssistanceReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener;
import org.dsi.ifc.cardriverassistance.FTASensorData;
import org.dsi.ifc.cardriverassistance.FTAViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;
import org.dsi.ifc.cardriverassistance.NVViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWARCTASensorData;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDSystemMessages;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCConsumption;
import org.dsi.ifc.global.CarBCSpeed;

public class DSICarDriverAssistanceDispatcher
extends AbstractDispatcher
implements DSICarDriverAssistanceReply {
    private DSICarDriverAssistanceReplyService service = new DSICarDriverAssistanceReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarDriverAssistanceDispatcher(int n) {
        super(n, (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener == null ? (class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener = DSICarDriverAssistanceDispatcher.class$("org.dsi.ifc.cardriverassistance.DSICarDriverAssistanceListener")) : class$org$dsi$ifc$cardriverassistance$DSICarDriverAssistanceListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCViewOptions(aCCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCViewOptions(aCCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCGongState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCGongState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCGongState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCGongVolume(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCDrivingProgram(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCDrivingProgram(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCDrivingProgram(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCTimeGap(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCTimeGap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCTimeGap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCDefaultMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCDefaultMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCDefaultMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCCurveAssist(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCCurveAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCCurveAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCSpeedLimitAdoption(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCSpeedLimitAdoption(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCSpeedLimitAdoption(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCTrafficJamAssist(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCTrafficJamAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCTrafficJamAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCSpeedLimitOffset(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCSpeedLimitOffset(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCSpeedLimitOffset(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateACCDistanceWarning(aCCDistanceWarning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateACCDistanceWarning(aCCDistanceWarning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCSensibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCSensibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCSensibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCMaxSpeed(CarBCSpeed carBCSpeed, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(67, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCMaxSpeed(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCMaxSpeed(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCMeanVelocity(CarBCSpeed carBCSpeed, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(68, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCMeanVelocity(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCMeanVelocity(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCMeanConsumption(CarBCConsumption carBCConsumption, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(69, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCMeanConsumption(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCMeanConsumption(carBCConsumption, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCCoastingPercentage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(70, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCCoastingPercentage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCCoastingPercentage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCDrivingProgram(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(71, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCDrivingProgram(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCDrivingProgram(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePACCSystemState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(72, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePACCSystemState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePACCSystemState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeACCSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeACCSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVDistanceWarning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVDistanceWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVDistanceWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVViewOptions(aWVViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVViewOptions(aWVViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVSystem(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVWarning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVGong(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVGong(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVGong(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVGongVolume(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVBrakeJerk(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVBrakeJerk(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVBrakeJerk(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVEmergencyBrake(AWVEmergencyBrake aWVEmergencyBrake, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVEmergencyBrake(aWVEmergencyBrake, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVEmergencyBrake(aWVEmergencyBrake, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAWVWarningTimegap(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateAWVWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateAWVWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAWVSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeAWVSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAViewOptions(sWAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAViewOptions(sWAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWABrightness(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWABrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWABrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAWarningTime(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAWarningTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAWarningTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAFrequency(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAFrequency(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAFrequency(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWASystem(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWASystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWASystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAGongState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAGongState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAGongState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAGongVolume(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAGongVolume(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWARCTASensorData(SWARCTASensorData sWARCTASensorData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWARCTASensorData(sWARCTASensorData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWARCTASensorData(sWARCTASensorData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWARCTA(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWARCTA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWARCTA(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSWAExitAssist(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateSWAExitAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateSWAExitAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVViewOptions(NVViewOptions nVViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVViewOptions(nVViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVViewOptions(nVViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVActivation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVContrast(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVContrast(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVContrast(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVBrightness(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVObjectDetection(NVObjectDetection nVObjectDetection, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVObjectDetection(nVObjectDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVObjectDetection(nVObjectDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVColorPA(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVColorPA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVColorPA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVDesignPA(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVDesignPA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVDesignPA(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVDisplay(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVDisplay(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVDisplay(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVZoomPanning(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVZoomPanning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVZoomPanning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVSound(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVSound(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVSound(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVSymbol(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVSymbol(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVSymbol(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeNVSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeNVSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVSystem(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(74, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVSystem(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNVWarningTimegap(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(75, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateNVWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateNVWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateLDWHCAViewOptions(lDWHCAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateLDWHCAViewOptions(lDWHCAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLDWWarningTime(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateLDWWarningTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateLDWWarningTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLDWSteeringWheelVibration(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateLDWSteeringWheelVibration(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateLDWSteeringWheelVibration(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHCAInterventionStyle(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateHCAInterventionStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateHCAInterventionStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHCAToleranceLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateHCAToleranceLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateHCAToleranceLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeLdwhcaSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeLdwhcaSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLDWHCASystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateLDWHCASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateLDWHCASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLDWHCAWarningSound(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(82, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateLDWHCAWarningSound(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateLDWHCAWarningSound(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDViewOptions(tSDViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDViewOptions(tSDViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDTrailerDetection(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDTrailerDetection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDTrailerDetection(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSign1(TSDSignFct tSDSignFct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSign1(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSign1(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSign2(TSDSignFct tSDSignFct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSign2(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSign2(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSign3(TSDSignFct tSDSignFct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSign3(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSign3(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSign4(TSDSignFct tSDSignFct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(77, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSign4(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSign4(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSign5(TSDSignFct tSDSignFct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(78, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSign5(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSign5(tSDSignFct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDRoadSignFilter(tSDRoadSignFilter, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDRoadSignFilter(tSDRoadSignFilter, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeTsdSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeTsdSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSpeedWarningThreshold(boolean bl, CarBCSpeed carBCSpeed, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSpeedWarningThreshold(bl, carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSpeedWarningThreshold(bl, carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDTrailerSpeedLimit(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDTrailerSpeedLimit(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSystemMessages(TSDSystemMessages tSDSystemMessages, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSystemMessages(tSDSystemMessages, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSystemMessages(tSDSystemMessages, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTSDSpeedWarningAcoustics(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(76, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateTSDSpeedWarningAcoustics(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateTSDSpeedWarningAcoustics(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateMKEViewOptions(mKEViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateMKEViewOptions(mKEViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMKESystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateMKESystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateMKESystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeMKESetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeMKESetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(58, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePAViewOptions(pAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePAViewOptions(pAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePASystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(59, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgePASetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgePASetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePAConfigInformation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(60, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePAConfigInformation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePAConfigInformation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePAConfigWarning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(61, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePAConfigWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePAConfigWarning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePAWarningTimegap(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(73, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updatePAWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updatePAWarningTimegap(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurveAssistSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateCurveAssistSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateCurveAssistSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeCurveAssistSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.acknowledgeCurveAssistSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFTAViewOptions(FTAViewOptions fTAViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(79, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateFTAViewOptions(fTAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateFTAViewOptions(fTAViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFTASystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(80, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateFTASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateFTASystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFTASensorData(FTASensorData fTASensorData, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    this.confirmNotificationListener(81, dSICarDriverAssistanceListener);
                    dSICarDriverAssistanceListener.updateFTASensorData(fTASensorData, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)iterator.next();
                    dSICarDriverAssistanceListener.updateFTASensorData(fTASensorData, n);
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
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    dSICarDriverAssistanceListener.asyncException(n, string, n2);
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
                    DSICarDriverAssistanceListener dSICarDriverAssistanceListener = (DSICarDriverAssistanceListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarDriverAssistanceDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarDriverAssistanceDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarDriverAssistanceListener, new Object[]{string, string2});
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

