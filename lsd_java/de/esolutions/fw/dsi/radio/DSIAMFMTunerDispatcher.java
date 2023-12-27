/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radio.DSIAMFMTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSIAMFMTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class DSIAMFMTunerDispatcher
extends AbstractDispatcher
implements DSIAMFMTunerReply {
    private DSIAMFMTunerReplyService service = new DSIAMFMTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAMFMTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = DSIAMFMTunerDispatcher.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateStationList(Station[] stationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateStationList(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateStationList(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStationListMW(Station[] stationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateStationListMW(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateStationListMW(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStationListLW(Station[] stationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateStationListLW(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateStationListLW(stationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateWavebandInfoList(wavebandInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateWavebandInfoList(wavebandInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(6, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateRadioText(aMFMRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateRadioText(aMFMRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAFSwitchStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(7, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateAFSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateAFSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateREGSwitchStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(8, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateREGSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateREGSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(9, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateLinkingUsageStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateLinkingUsageStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(10, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.tuneFrequencyStepsStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectStationStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.selectStationStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void seekStationStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.seekStationStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(11, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateRadioTextPlus(nArray, stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateRadioTextPlus(nArray, stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedStation(Station station, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateSelectedStation(station, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateSelectedStation(station, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedStationHD(Station station, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(20, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateSelectedStationHD(station, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateSelectedStationHD(station, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.prepareTuningStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectFrequencyStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.selectFrequencyStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAMBandRangeStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.setAMBandRangeStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void forceFMUpdateStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.forceFMUpdateStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(12, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updatePiIgnoreSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updatePiIgnoreSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.forceAMUpdateStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(13, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateRDSIgnoreSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateRDSIgnoreSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMESwitchStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(14, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateMESwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateMESwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHdStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(15, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateHdStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateHdStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHdMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(16, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateHdMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateHdMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(17, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateHdStationInfo(hdStationInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateHdStationInfo(hdStationInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(18, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(19, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateElectronicSerialCode(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateElectronicSerialCode(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    this.confirmNotificationListener(21, dSIAMFMTunerListener);
                    dSIAMFMTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)iterator.next();
                    dSIAMFMTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.profileChanged(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.profileCopied(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.profileReset(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void profileResetAll(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.profileResetAll(n);
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
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    dSIAMFMTunerListener.asyncException(n, string, n2);
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
                    DSIAMFMTunerListener dSIAMFMTunerListener = (DSIAMFMTunerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAMFMTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAMFMTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAMFMTunerListener, new Object[]{string, string2});
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

