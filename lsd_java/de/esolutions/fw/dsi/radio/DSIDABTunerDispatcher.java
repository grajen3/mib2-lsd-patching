/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radio.DSIDABTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSIDABTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public class DSIDABTunerDispatcher
extends AbstractDispatcher
implements DSIDABTunerReply {
    private DSIDABTunerReplyService service = new DSIDABTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDABTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = DSIDABTunerDispatcher.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIDABTunerListener);
                    dSIDABTunerListener.updateSelectedEnsemble(ensembleInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSelectedEnsemble(ensembleInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedService(ServiceInfo serviceInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIDABTunerListener);
                    dSIDABTunerListener.updateSelectedService(serviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSelectedService(serviceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedComponent(ComponentInfo componentInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(3, dSIDABTunerListener);
                    dSIDABTunerListener.updateSelectedComponent(componentInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSelectedComponent(componentInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(4, dSIDABTunerListener);
                    dSIDABTunerListener.updateSelectedFrequency(frequencyInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSelectedFrequency(frequencyInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(5, dSIDABTunerListener);
                    dSIDABTunerListener.updateEnsembleList(ensembleInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEnsembleList(ensembleInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceList(ServiceInfo[] serviceInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(6, dSIDABTunerListener);
                    dSIDABTunerListener.updateServiceList(serviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateServiceList(serviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateComponentList(ComponentInfo[] componentInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(7, dSIDABTunerListener);
                    dSIDABTunerListener.updateComponentList(componentInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateComponentList(componentInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(8, dSIDABTunerListener);
                    dSIDABTunerListener.updateDataServiceList(dataServiceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateDataServiceList(dataServiceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(9, dSIDABTunerListener);
                    dSIDABTunerListener.updateFrequencyList(frequencyInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateFrequencyList(frequencyInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(10, dSIDABTunerListener);
                    dSIDABTunerListener.updateRadioText(dABRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateRadioText(dABRadioText, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSyncStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(11, dSIDABTunerListener);
                    dSIDABTunerListener.updateSyncStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSyncStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateQuality(short s, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(12, dSIDABTunerListener);
                    dSIDABTunerListener.updateQuality(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateQuality(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDRCSwitchStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(13, dSIDABTunerListener);
                    dSIDABTunerListener.updateDRCSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateDRCSwitchStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLinkingSwitchStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(14, dSIDABTunerListener);
                    dSIDABTunerListener.updateLinkingSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateLinkingSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(15, dSIDABTunerListener);
                    dSIDABTunerListener.updateFrequencyTableSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateFrequencyTableSwitchStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLinkingStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(18, dSIDABTunerListener);
                    dSIDABTunerListener.updateLinkingStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateLinkingStatus(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(19, dSIDABTunerListener);
                    dSIDABTunerListener.updateLinkingUsageStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateLinkingUsageStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioStatus(AudioStatus audioStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(20, dSIDABTunerListener);
                    dSIDABTunerListener.updateAudioStatus(audioStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateAudioStatus(audioStatus, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(21, dSIDABTunerListener);
                    dSIDABTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateDetectedDevice(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateQualityInfo(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(22, dSIDABTunerListener);
                    dSIDABTunerListener.updateQualityInfo(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateQualityInfo(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectServiceStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.selectServiceStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void seekServiceStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.seekServiceStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void tuneEnsembleStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.tuneEnsembleStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectDataServiceStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.selectDataServiceStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(33, dSIDABTunerListener);
                    dSIDABTunerListener.updateRadioTextPlusInfo(dABRadioTextPlusInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateRadioTextPlusInfo(dABRadioTextPlusInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDecodedDataService(DataServiceInfo dataServiceInfo, boolean bl, String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(24, dSIDABTunerListener);
                    dSIDABTunerListener.updateDecodedDataService(dataServiceInfo, bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateDecodedDataService(dataServiceInfo, bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.forceLMUpdateStatus(n);
                    continue;
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.prepareTuningStatus(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEpgLogo(int[] nArray, ResourceLocator[] resourceLocatorArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(25, dSIDABTunerListener);
                    dSIDABTunerListener.updateEpgLogo(nArray, resourceLocatorArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEpgLogo(nArray, resourceLocatorArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEpgLogoList(EPGLogo[] ePGLogoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(34, dSIDABTunerListener);
                    dSIDABTunerListener.updateEpgLogoList(ePGLogoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEpgLogoList(ePGLogoArray, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(32, dSIDABTunerListener);
                    dSIDABTunerListener.updateSlideShowInfo(dABSlideShowInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateSlideShowInfo(dABSlideShowInfo, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(27, dSIDABTunerListener);
                    dSIDABTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIntellitext(IntellitextMenu[] intellitextMenuArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(28, dSIDABTunerListener);
                    dSIDABTunerListener.updateIntellitext(intellitextMenuArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateIntellitext(intellitextMenuArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEPGMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(31, dSIDABTunerListener);
                    dSIDABTunerListener.updateEPGMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEPGMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(29, dSIDABTunerListener);
                    dSIDABTunerListener.updateEPGListData(ePGShortInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEPGListData(ePGShortInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEPGDetailData(EPGFullInfo ePGFullInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(30, dSIDABTunerListener);
                    dSIDABTunerListener.updateEPGDetailData(ePGFullInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateEPGDetailData(ePGFullInfo, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    this.confirmNotificationListener(35, dSIDABTunerListener);
                    dSIDABTunerListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)iterator.next();
                    dSIDABTunerListener.updateProfileState(n, n2, n3);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.profileChanged(n, n2);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.profileCopied(n, n2, n3);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.profileReset(n, n2);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.profileResetAll(n);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    dSIDABTunerListener.asyncException(n, string, n2);
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
                    DSIDABTunerListener dSIDABTunerListener = (DSIDABTunerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDABTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDABTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDABTunerListener, new Object[]{string, string2});
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

