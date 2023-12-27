/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.caraircondition;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.caraircondition.DSICarAirConditionReply;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirQuality;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconBCMeasuresConfiguration;
import org.dsi.ifc.caraircondition.AirconBlowerCompensation;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconFreshAirCartridge;
import org.dsi.ifc.caraircondition.AirconFreshAirConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirConditionListener;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarAirConditionDispatcher
extends AbstractDispatcher
implements DSICarAirConditionReply {
    private DSICarAirConditionReplyService service = new DSICarAirConditionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirConditionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarAirConditionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = DSICarAirConditionDispatcher.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void requestAirconPopup(AirconContent airconContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.requestAirconPopup(airconContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowlegdeAirconPopup(AirconContent airconContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowlegdeAirconPopup(airconContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconContent(AirconContent airconContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconContent(airconContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconContent(airconContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirCirculationMan(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirCirculationMan(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirCirculationMan(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirCirculationAuto(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirCirculationAuto(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirCirculationSensitivity(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirCirculationSensitivity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirCirculationSensitivity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirCirculationMiddleExhaustion(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirCirculationMiddleExhaustion(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirCirculationMiddleExhaustion(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconRearWindowHeater(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconRearWindowHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconRearWindowHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndirectVentilation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndirectVentilation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndirectVentilation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconPopupTime(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconPopupTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconPopupTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconHeater(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconRearAuxHeater(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconRearAuxHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconRearAuxHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFrontWindowHeater(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(12, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFrontWindowHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFrontWindowHeater(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconDefrost(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconMaxDefrost(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(81, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconMaxDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(81);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconMaxDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSolar(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSolar(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSolar(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAC(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconMaxAC(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(82, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconMaxAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(82);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconMaxAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconEcoAC(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(83, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconEcoAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(83);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconEcoAC(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconRearControl(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconRearControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconRearControl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconRearControlFondPlus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(91, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconRearControlFondPlus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconRearControlFondPlus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSteeringWheelHeater(airconSteeringWheelHeater, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSteeringWheelHeater(airconSteeringWheelHeater, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFrontWindowHeaterAuto(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFrontWindowHeaterAuto(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBlowerCompensation(AirconBlowerCompensation airconBlowerCompensation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBlowerCompensation(airconBlowerCompensation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBlowerCompensation(airconBlowerCompensation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSynchronisation(airconSynchronisation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSynchronisation(airconSynchronisation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSuppressVisualisation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSuppressVisualisation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSuppressVisualisation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconResidualHeat(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconResidualHeat(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconResidualHeat(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSystemOnOffRow1(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(152);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(152, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSystemOnOffRow1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(152);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSystemOnOffRow1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSystemOnOffRow2(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(153);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(153, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSystemOnOffRow2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(153);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSystemOnOffRow2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSystemOnOffRow3(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(154);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(154, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSystemOnOffRow3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(154);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSystemOnOffRow3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone1(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone1(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone1(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone1(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone1(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone1(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone1(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(167);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(167, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(167);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone1(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(168);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(168, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(168);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone2(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone2(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone2(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone2(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone2(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone2(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone2(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(169);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(169, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(169);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone2(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(170);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(170, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(170);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone3(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone3(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone3(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone3(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone3(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone3(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone3(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(171);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(171, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(171);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone3(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(172);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(172, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(172);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone4(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone4(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone4(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone4(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone4(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone4(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone4(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(173);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(173, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(173);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone4(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(174);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(174, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(174);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone5(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone5(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone5(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone5(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone5(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone5(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone5(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone5(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone5(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone5(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(175);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(175, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(175);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone5(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(176);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(176, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(176);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempZone6(AirconTemp airconTemp, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempZone6(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempZone6(airconTemp, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirVolumeZone6(AirconAirVolume airconAirVolume, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirVolumeZone6(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirVolumeZone6(airconAirVolume, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirDistributionZone6(AirconAirDistribution airconAirDistribution, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirDistributionZone6(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirDistributionZone6(airconAirDistribution, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFootwellTempZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFootwellTempZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFootwellTempZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterZone6(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(177);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(177, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(177);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationZone6(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(178);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(178, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(178);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(65, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(67, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatHeaterDistributionZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(68, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatHeaterDistributionZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(69, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(70, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(71, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(72, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(73, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatVentilationDistributionZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(74, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatVentilationDistributionZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone1(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(75, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone1(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone2(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(76, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone2(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone3(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(77, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone3(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone4(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(78, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone4(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone5(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(79, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone5(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconTempStepZone6(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(80, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconTempStepZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconTempStepZone6(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(92, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconViewOptionsMaster(airconMasterViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconViewOptionsMaster(airconMasterViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(93, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconViewOptionsRow1(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconViewOptionsRow1(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(94, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconViewOptionsRow2(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconViewOptionsRow2(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconViewOptionsRow3(AirconRowViewOptions airconRowViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(95, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconViewOptionsRow3(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconViewOptionsRow3(airconRowViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultMaster(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowledgeAirconSetFactoryDefaultMaster(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAirconSetFactoryDefaultRow(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowledgeAirconSetFactoryDefaultRow(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow1(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowledgeAirconNozzleControlRow1(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow2(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowledgeAirconNozzleControlRow2(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeAirconNozzleControlRow3(boolean bl, boolean bl2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.acknowledgeAirconNozzleControlRow3(bl, bl2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAirconNozzleListRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.responseAirconNozzleListRow1(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAirconNozzleListRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.responseAirconNozzleListRow2(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAirconNozzleListRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.responseAirconNozzleListRow3(carArrayListUpdateInfo, airconNozzleListRecordArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow1(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(96, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow1(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow1(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow2(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(97, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow2(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow2(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListUpdateInfoRow3(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(98, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow3(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListUpdateInfoRow3(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(99, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(100, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(100);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleListTotalNumberOfElementsRow3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(101, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(101);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleListTotalNumberOfElementsRow3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSideWindowDefrost(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(102, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSideWindowDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSideWindowDefrost(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(103, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconPureAir(airconPureAirSetup, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(103);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconPureAir(airconPureAirSetup, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFreshAirState(AirconFreshAirCartridge airconFreshAirCartridge, AirconFreshAirCartridge airconFreshAirCartridge2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(104, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFreshAirState(airconFreshAirCartridge, airconFreshAirCartridge2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(104);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFreshAirState(airconFreshAirCartridge, airconFreshAirCartridge2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconFreshAirConfig(AirconFreshAirConfiguration airconFreshAirConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(105, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconFreshAirConfig(airconFreshAirConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(105);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconFreshAirConfig(airconFreshAirConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconAirQuality(AirconAirQuality airconAirQuality, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(106, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconAirQuality(airconAirQuality, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(106);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconAirQuality(airconAirQuality, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleStatusRow1(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(107, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleStatusRow1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(107);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleStatusRow1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleStatusRow2(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(108);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(108, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleStatusRow2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(108);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleStatusRow2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconNozzleStatusRow3(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(109);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(109, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconNozzleStatusRow3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(109);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconNozzleStatusRow3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(110);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(110, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(110);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(112);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(112, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(112);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(114);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(114, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(114);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(116);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(116, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(116);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(118);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(118, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(118);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStyleZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(120);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(120, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStyleZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(120);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStyleZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(111);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(111, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(111);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(113);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(113, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(113);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(115);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(115, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(115);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(117);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(117, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(117);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(119);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(119, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(119);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconClimateStateZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(121);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(121, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconClimateStateZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(121);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconClimateStateZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone1(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(122);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(122, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone1(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(122);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone1(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone2(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(123);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(123, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone2(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(123);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone2(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone3(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(124);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(124, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone3(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(124);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone3(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone4(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(125);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(125, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone4(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(125);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone4(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone5(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(126);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(126, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone5(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(126);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone5(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatNeckHeaterZone6(boolean bl, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(127);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(127, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone6(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(127);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatNeckHeaterZone6(bl, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone1(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(128);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(128, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone1(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(128);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone1(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone2(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(129);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(129, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone2(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(129);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone2(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone3(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(130);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(130, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone3(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(130);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone3(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone4(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(131);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(131, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone4(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(131);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone4(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone5(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(132);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(132, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone5(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(132);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone5(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconSeatSurfaceHeaterZone6(boolean bl, boolean bl2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(133);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(133, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone6(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(133);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconSeatSurfaceHeaterZone6(bl, bl2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone1(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(134);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(134, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(134);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone1(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone2(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(135);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(135, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(135);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone2(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone3(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(136);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(136, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(136);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone3(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone4(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(137);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(137, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone4(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(137);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone4(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone5(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(138);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(138, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone5(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(138);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone5(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIndividualClimatisationZone6(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(139);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(139, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone6(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(139);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIndividualClimatisationZone6(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone1(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(140);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(140, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(140);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone1(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone2(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(141);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(141, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(141);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone2(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone3(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(142);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(142, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(142);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone3(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone4(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(143);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(143, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(143);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone4(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone5(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(144);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(144, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(144);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone5(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconIonisatorZone6(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(145);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(145, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconIonisatorZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(145);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconIonisatorZone6(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone1(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(146);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(146, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone1(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(146);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone1(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone2(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(147);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(147, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone2(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(147);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone2(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone3(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(148);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(148, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone3(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(148);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone3(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone4(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(149);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(149, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone4(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(149);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone4(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone5(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(150);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(150, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone5(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(150);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone5(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAirconBodyCloseMeasuresZone6(boolean bl, AirconBCMeasuresConfiguration airconBCMeasuresConfiguration, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(151);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    this.confirmNotificationListener(151, dSICarAirConditionListener);
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone6(bl, airconBCMeasuresConfiguration, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(151);
            while (iterator.hasNext()) {
                try {
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)iterator.next();
                    dSICarAirConditionListener.updateAirconBodyCloseMeasuresZone6(bl, airconBCMeasuresConfiguration, n);
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
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    dSICarAirConditionListener.asyncException(n, string, n2);
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
                    DSICarAirConditionListener dSICarAirConditionListener = (DSICarAirConditionListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarAirConditionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarAirConditionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarAirConditionListener, new Object[]{string, string2});
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

