/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radio.DSIUnifiedTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSIUnifiedTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public class DSIUnifiedTunerDispatcher
extends AbstractDispatcher
implements DSIUnifiedTunerReply {
    private DSIUnifiedTunerReplyService service = new DSIUnifiedTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIUnifiedTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIUnifiedTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radio$DSIUnifiedTunerListener == null ? (class$org$dsi$ifc$radio$DSIUnifiedTunerListener = DSIUnifiedTunerDispatcher.class$("org.dsi.ifc.radio.DSIUnifiedTunerListener")) : class$org$dsi$ifc$radio$DSIUnifiedTunerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void selectStationStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.selectStationStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateAudioStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateAudioStatus(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateSelectedStation(unifiedStation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateSelectedStation(unifiedStation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateStationList(unifiedStationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateStationList(unifiedStationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateRadioText(unifiedRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateRadioText(unifiedRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(6, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateEnhancedRadioText(unifiedRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateEnhancedRadioText(unifiedRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(7, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateRadioTextPlus(unifiedRadioTextPlus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateRadioTextPlus(unifiedRadioTextPlus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(8, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateEnhancedRadioTextPlus(unifiedRadioTextPlus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateEnhancedRadioTextPlus(unifiedRadioTextPlus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(9, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateSlideShowInfo(dABSlideShowInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateSlideShowInfo(dABSlideShowInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void listMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.listMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stationFollowingMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.stationFollowingMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(10, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateSoftLinkSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateSoftLinkSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRegModeStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(11, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateRegModeStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateRegModeStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceUsageStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(12, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateDeviceUsageStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateDeviceUsageStatus(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    this.confirmNotificationListener(13, dSIUnifiedTunerListener);
                    dSIUnifiedTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)iterator.next();
                    dSIUnifiedTunerListener.updateProfileState(n, n2, n3);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.profileChanged(n, n2);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.profileCopied(n, n2, n3);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.profileReset(n, n2);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.profileResetAll(n);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    dSIUnifiedTunerListener.asyncException(n, string, n2);
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
                    DSIUnifiedTunerListener dSIUnifiedTunerListener = (DSIUnifiedTunerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIUnifiedTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIUnifiedTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIUnifiedTunerListener, new Object[]{string, string2});
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

