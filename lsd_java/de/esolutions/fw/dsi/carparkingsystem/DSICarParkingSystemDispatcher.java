/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carparkingsystem;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carparkingsystem.DSICarParkingSystemReply;
import de.esolutions.fw.comm.dsi.carparkingsystem.impl.DSICarParkingSystemReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carparkingsystem.ARACurrentTrailerAngle;
import org.dsi.ifc.carparkingsystem.ARAInfo;
import org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.PDCCrashWarning;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRear;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCDistanceValuesRightLeft;
import org.dsi.ifc.carparkingsystem.PDCInfo;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssistState;
import org.dsi.ifc.carparkingsystem.PDCPLABargraph;
import org.dsi.ifc.carparkingsystem.PDCPLAStatus;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;
import org.dsi.ifc.carparkingsystem.PDCPiloPaSystemState;
import org.dsi.ifc.carparkingsystem.PDCSound;
import org.dsi.ifc.carparkingsystem.PDCSoundReproduction;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRear;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelFrontRearExt;
import org.dsi.ifc.carparkingsystem.PDCStatusLevelRightLeft;
import org.dsi.ifc.carparkingsystem.PDCSteeringInformation;
import org.dsi.ifc.carparkingsystem.PDCWallDetection;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;
import org.dsi.ifc.carparkingsystem.VPSDynParkingMode;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;
import org.dsi.ifc.carparkingsystem.VPSRimProtection;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPinPukState;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;
import org.dsi.ifc.carparkingsystem.WCViewOptions;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

public class DSICarParkingSystemDispatcher
extends AbstractDispatcher
implements DSICarParkingSystemReply {
    private DSICarParkingSystemReplyService service = new DSICarParkingSystemReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarParkingSystemDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener == null ? (class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener = DSICarParkingSystemDispatcher.class$("org.dsi.ifc.carparkingsystem.DSICarParkingSystemListener")) : class$org$dsi$ifc$carparkingsystem$DSICarParkingSystemListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateParkingSystemViewOptions(parkingSystemViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDefaultParkingMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDefaultParkingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDefaultParkingMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFrequenceFront(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFrequenceFront(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFrequenceFront(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFrequenceRear(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFrequenceRear(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFrequenceRear(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFrequenceRight(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(27, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFrequenceRight(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFrequenceRight(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFrequenceLeft(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(28, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFrequenceLeft(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFrequenceLeft(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCVolumeFront(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCVolumeFront(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCVolumeFront(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCVolumeRear(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCVolumeRear(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCVolumeRear(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCVolumeRight(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(29, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCVolumeRight(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCVolumeRight(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCVolumeLeft(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(30, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCVolumeLeft(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCVolumeLeft(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCMute(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCMute(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCMute(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(8, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCTrailerHitched(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(9, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCTrailerHitched(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCTrailerHitched(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesFront(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(10, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesFront(pDCDistanceValuesFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesFront(pDCDistanceValuesFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesRear(PDCDistanceValuesFrontRear pDCDistanceValuesFrontRear, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(11, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesRear(pDCDistanceValuesFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesRear(pDCDistanceValuesFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesRight(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(33, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesRight(pDCDistanceValuesRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesRight(pDCDistanceValuesRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesLeft(PDCDistanceValuesRightLeft pDCDistanceValuesRightLeft, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(34, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesLeft(pDCDistanceValuesRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesLeft(pDCDistanceValuesRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelFront(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(35, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelFront(pDCStatusLevelFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelFront(pDCStatusLevelFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelRear(PDCStatusLevelFrontRear pDCStatusLevelFrontRear, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(36, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelRear(pDCStatusLevelFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelRear(pDCStatusLevelFrontRear, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelRight(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(37, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelRight(pDCStatusLevelRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelRight(pDCStatusLevelRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelLeft(PDCStatusLevelRightLeft pDCStatusLevelRightLeft, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(38, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelLeft(pDCStatusLevelRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelLeft(pDCStatusLevelRightLeft, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCOPSAutoActivation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(41, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCOPSAutoActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCOPSAutoActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCCrashWarning(PDCCrashWarning pDCCrashWarning, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(39, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCCrashWarning(pDCCrashWarning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCCrashWarning(pDCCrashWarning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSteeringInformation(PDCSteeringInformation pDCSteeringInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(40, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSteeringInformation(pDCSteeringInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSteeringInformation(pDCSteeringInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFlankGuard(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(42, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFlankGuard(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFlankGuard(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSoundReproduction(PDCSoundReproduction pDCSoundReproduction, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(43, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSoundReproduction(pDCSoundReproduction, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSoundReproduction(pDCSoundReproduction, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCInfo(PDCInfo pDCInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(31, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCInfo(pDCInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCInfo(pDCInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCFailure(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(32, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesFrontExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(51, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesFrontExt(pDCDistanceValuesFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesFrontExt(pDCDistanceValuesFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCDistanceValuesRearExt(PDCDistanceValuesFrontRearExt pDCDistanceValuesFrontRearExt, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(52, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCDistanceValuesRearExt(pDCDistanceValuesFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCDistanceValuesRearExt(pDCDistanceValuesFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelFrontExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(49, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelFrontExt(pDCStatusLevelFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelFrontExt(pDCStatusLevelFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCStatusLevelRearExt(PDCStatusLevelFrontRearExt pDCStatusLevelFrontRearExt, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(50, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCStatusLevelRearExt(pDCStatusLevelFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCStatusLevelRearExt(pDCStatusLevelFrontRearExt, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCWallDetection(PDCWallDetection pDCWallDetection, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(53, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCWallDetection(pDCWallDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCWallDetection(pDCWallDetection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPLAMessage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(54, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPLAMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPLAMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSoundFront(PDCSound pDCSound, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(55, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSoundFront(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(55);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSoundFront(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSoundRear(PDCSound pDCSound, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(56, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSoundRear(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(56);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSoundRear(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSoundLeft(PDCSound pDCSound, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(57, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSoundLeft(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(57);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSoundLeft(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCSoundRight(PDCSound pDCSound, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(58, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCSoundRight(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(58);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCSoundRight(pDCSound, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPLAStatus(PDCPLAStatus pDCPLAStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(59, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPLAStatus(pDCPLAStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(59);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPLAStatus(pDCPLAStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPLABargraph(PDCPLABargraph pDCPLABargraph, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(60, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPLABargraph(pDCPLABargraph, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(60);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPLABargraph(pDCPLABargraph, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPLAParkmodeSelection(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(61, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPLAParkmodeSelection(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(61);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPLAParkmodeSelection(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPLASystemState(PDCPLASystemState pDCPLASystemState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(62, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPLASystemState(pDCPLASystemState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(62);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPLASystemState(pDCPLASystemState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCOPSVisualisationPosition(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(65, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCOPSVisualisationPosition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(65);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCOPSVisualisationPosition(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCOffroadMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(63, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCOffroadMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(63);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCOffroadMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCParkboxVisualisation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(64, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCParkboxVisualisation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(64);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCParkboxVisualisation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSFollowUpTime(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(13, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSFollowUpTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSFollowUpTime(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSVideoInfo(VPSVideoInfo vPSVideoInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(14, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSVideoInfo(vPSVideoInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSVideoInfo(vPSVideoInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSColor(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(15, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSColor(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSColor(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSContrast(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(16, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSContrast(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSContrast(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSBrightness(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(17, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSBrightness(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDefaultModeRV(VPSDefaultMode vPSDefaultMode, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(18, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDefaultModeRV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDefaultModeRV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDefaultModeSV(VPSDefaultMode vPSDefaultMode, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(19, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDefaultModeSV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDefaultModeSV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDefaultModeFV(VPSDefaultMode vPSDefaultMode, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(20, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDefaultModeFV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDefaultModeFV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDefaultModeBV(VPSDefaultMode vPSDefaultMode, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(21, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDefaultModeBV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDefaultModeBV(vPSDefaultMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDefaultView(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(22, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDefaultView(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDefaultView(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSDynamicParkingMode(VPSDynParkingMode vPSDynParkingMode, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(23, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSDynamicParkingMode(vPSDynParkingMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSDynamicParkingMode(vPSDynParkingMode, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSOPSOverlay(VPSOPSOverlay vPSOPSOverlay, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(24, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSOPSOverlay(vPSOPSOverlay, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSOPSOverlay(vPSOPSOverlay, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(25, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSFailure(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(44, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSExtCamConfig(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(66, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSExtCamConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(66);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSExtCamConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSExtCamManActivation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(67, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSExtCamManActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(67);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSExtCamManActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPS3DBirdview(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(68, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPS3DBirdview(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(68);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPS3DBirdview(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSSystemState(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(69, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSSystemState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(69);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSSystemState(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSCameraStates(VPSCameraStates vPSCameraStates, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(70, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSCameraStates(vPSCameraStates, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(70);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSCameraStates(vPSCameraStates, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateParkingPopupContent(DisplayContent displayContent, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(26, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateParkingPopupContent(displayContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateParkingPopupContent(displayContent, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestParkingPopup(DisplayContent displayContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.requestParkingPopup(displayContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeParkingPopup(DisplayContent displayContent) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeParkingPopup(displayContent);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseLifeMonitoring(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.responseLifeMonitoring(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgePdcSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgePdcSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeVpsSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeVpsSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateARAFailure(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(45, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateARAFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateARAFailure(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateARAInfo(ARAInfo aRAInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(46, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateARAInfo(aRAInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateARAInfo(aRAInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateARACurrentTrailerAngle(ARACurrentTrailerAngle aRACurrentTrailerAngle, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(47, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateARACurrentTrailerAngle(aRACurrentTrailerAngle, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateARACurrentTrailerAngle(aRACurrentTrailerAngle, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateARATargetTrailerAngle(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(48, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateARATargetTrailerAngle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateARATargetTrailerAngle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCManeuverAssistConfig(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(71, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCManeuverAssistConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(71);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCManeuverAssistConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCManeuverAssist(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(72, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCManeuverAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(72);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCManeuverAssist(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCManeuverAssistState(PDCManeuverAssistState pDCManeuverAssistState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(73, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCManeuverAssistState(pDCManeuverAssistState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(73);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCManeuverAssistState(pDCManeuverAssistState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCManeuverAssistMessage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(74, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCManeuverAssistMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(74);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCManeuverAssistMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCIPAMessage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(75, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCIPAMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(75);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCIPAMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCContinueDrivingAssist(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(76, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCContinueDrivingAssist(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(76);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCContinueDrivingAssist(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCIpaConfig(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(77, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCIpaConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(77);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCIpaConfig(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePDCPiloPaSystemState(PDCPiloPaSystemState pDCPiloPaSystemState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(78, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updatePDCPiloPaSystemState(pDCPiloPaSystemState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(78);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updatePDCPiloPaSystemState(pDCPiloPaSystemState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSCameraCleaning(VPSCameraCleaning vPSCameraCleaning, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(79, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSCameraCleaning(vPSCameraCleaning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(79);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSCameraCleaning(vPSCameraCleaning, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateVPSRimProtection(VPSRimProtection vPSRimProtection, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(80, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateVPSRimProtection(vPSRimProtection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(80);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateVPSRimProtection(vPSRimProtection, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCViewOptions(WCViewOptions wCViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(102, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCViewOptions(wCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(102);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCViewOptions(wCViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCSystemOnOff(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(89, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(89);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCSystemOnOff(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCAutoActivation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(90);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(90, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCAutoActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(90);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCAutoActivation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCPopupContent(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(91, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCPopupContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(91);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCPopupContent(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCMessage(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(92, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(92);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCMessage(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCPanelPosition(WCPanelInfo wCPanelInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(93, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCPanelPosition(wCPanelInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(93);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCPanelPosition(wCPanelInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCSetFactoryDefault(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCSetFactoryDefault(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestWCPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.requestWCPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCPopup(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCPopup(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCPanelListUpdateInfo(CarArrayListUpdateInfo carArrayListUpdateInfo, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(96, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCPanelListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(96);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCPanelListUpdateInfo(carArrayListUpdateInfo, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCPanelListTotalNumberOfElements(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(97, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCPanelListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(97);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCPanelListTotalNumberOfElements(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCVehiclePanelInfo(WCVehiclePanelInfo wCVehiclePanelInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(94, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCVehiclePanelInfo(wCVehiclePanelInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(94);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCVehiclePanelInfo(wCVehiclePanelInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCPinPukState(WCPinPukState wCPinPukState, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(95, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCPinPukState(wCPinPukState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(95);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCPinPukState(wCPinPukState, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCScanningProgress(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(98, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCScanningProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(98);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCScanningProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWCSoftwareUpdateProgress(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    this.confirmNotificationListener(99, dSICarParkingSystemListener);
                    dSICarParkingSystemListener.updateWCSoftwareUpdateProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(99);
            while (iterator.hasNext()) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)iterator.next();
                    dSICarParkingSystemListener.updateWCSoftwareUpdateProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCEnterPinPuk(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCEnterPinPuk(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCScanning(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCScanning(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCPairing(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCPairing(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCSoftwareUpdate(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCSoftwareUpdate(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCChangePin(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCChangePin(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acknowledgeWCChangePanelName(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.acknowledgeWCChangePanelName(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseWCPanelList(CarArrayListUpdateInfo carArrayListUpdateInfo, WCPanelListRecord[] wCPanelListRecordArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.responseWCPanelList(carArrayListUpdateInfo, wCPanelListRecordArray);
                    continue;
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
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    dSICarParkingSystemListener.asyncException(n, string, n2);
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
                    DSICarParkingSystemListener dSICarParkingSystemListener = (DSICarParkingSystemListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarParkingSystemDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarParkingSystemDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarParkingSystemListener, new Object[]{string, string2});
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

