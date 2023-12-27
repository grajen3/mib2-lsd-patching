/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tvtuner;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tvtuner.DSITVTunerReply;
import de.esolutions.fw.comm.dsi.tvtuner.impl.DSITVTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.tvtuner.DSITVTunerListener;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class DSITVTunerDispatcher
extends AbstractDispatcher
implements DSITVTunerReply {
    private DSITVTunerReplyService service = new DSITVTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITVTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tvtuner$DSITVTunerListener == null ? (class$org$dsi$ifc$tvtuner$DSITVTunerListener = DSITVTunerDispatcher.class$("org.dsi.ifc.tvtuner.DSITVTunerListener")) : class$org$dsi$ifc$tvtuner$DSITVTunerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateTunerState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(1, dSITVTunerListener);
                    dSITVTunerListener.updateTunerState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTunerState(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(3, dSITVTunerListener);
                    dSITVTunerListener.updateServiceList(serviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateServiceList(serviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedService(ProgramInfo programInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(4, dSITVTunerListener);
                    dSITVTunerListener.updateSelectedService(programInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateSelectedService(programInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedSource(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(2, dSITVTunerListener);
                    dSITVTunerListener.updateSelectedSource(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateSelectedSource(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTVNormArea(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(11, dSITVTunerListener);
                    dSITVTunerListener.updateTVNormArea(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTVNormArea(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioChannel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(7, dSITVTunerListener);
                    dSITVTunerListener.updateAudioChannel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateAudioChannel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMuteState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(5, dSITVTunerListener);
                    dSITVTunerListener.updateMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateInfoTextState(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(6, dSITVTunerListener);
                    dSITVTunerListener.updateInfoTextState(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateInfoTextState(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTerminalMode(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(14, dSITVTunerListener);
                    dSITVTunerListener.updateTerminalMode(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTerminalMode(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceLinking(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(8, dSITVTunerListener);
                    dSITVTunerListener.updateServiceLinking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateServiceLinking(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTVNormList(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(12, dSITVTunerListener);
                    dSITVTunerListener.updateTVNormList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTVNormList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTVNormAreaSubList(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(13, dSITVTunerListener);
                    dSITVTunerListener.updateTVNormAreaSubList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTVNormAreaSubList(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAVNorm(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(10, dSITVTunerListener);
                    dSITVTunerListener.updateAVNorm(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateAVNorm(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEWSInfoList(EWSInfo[] eWSInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(15, dSITVTunerListener);
                    dSITVTunerListener.updateEWSInfoList(eWSInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateEWSInfoList(eWSInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectService(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    dSITVTunerListener.selectService(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void selectNextService(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    dSITVTunerListener.selectNextService(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void abortSeek(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    dSITVTunerListener.abortSeek(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void switchSource(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    dSITVTunerListener.switchSource(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSubtitle(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(9, dSITVTunerListener);
                    dSITVTunerListener.updateSubtitle(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateSubtitle(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLogoList(LogoInfo[] logoInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(21, dSITVTunerListener);
                    dSITVTunerListener.updateLogoList(logoInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateLogoList(logoInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCASInfo(boolean bl, String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(19, dSITVTunerListener);
                    dSITVTunerListener.updateCASInfo(bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateCASInfo(bl, string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(18, dSITVTunerListener);
                    dSITVTunerListener.updateTuneStatus(bl, bl2, bl3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTuneStatus(bl, bl2, bl3, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMessageService(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(17, dSITVTunerListener);
                    dSITVTunerListener.updateMessageService(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateMessageService(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(16, dSITVTunerListener);
                    dSITVTunerListener.updateStartUpMUConfig(startUpConfig, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateStartUpMUConfig(startUpConfig, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTMTVKeyPanel(short s, short s2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(20, dSITVTunerListener);
                    dSITVTunerListener.updateTMTVKeyPanel(s, s2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateTMTVKeyPanel(s, s2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBrowserListSort(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    this.confirmNotificationListener(22, dSITVTunerListener);
                    dSITVTunerListener.updateBrowserListSort(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)iterator.next();
                    dSITVTunerListener.updateBrowserListSort(n, n2);
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
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    dSITVTunerListener.asyncException(n, string, n2);
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
                    DSITVTunerListener dSITVTunerListener = (DSITVTunerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITVTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITVTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITVTunerListener, new Object[]{string, string2});
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

