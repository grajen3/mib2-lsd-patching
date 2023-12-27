/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.waveplayer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.waveplayer.DSIWavePlayerReply;
import de.esolutions.fw.comm.dsi.waveplayer.impl.DSIWavePlayerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.waveplayer.DSIWavePlayerListener;

public class DSIWavePlayerDispatcher
extends AbstractDispatcher
implements DSIWavePlayerReply {
    private DSIWavePlayerReplyService service = new DSIWavePlayerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIWavePlayerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayerListener = DSIWavePlayerDispatcher.class$("org.dsi.ifc.waveplayer.DSIWavePlayerListener")) : class$org$dsi$ifc$waveplayer$DSIWavePlayerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updatePlayTone(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)iterator.next();
                    this.confirmNotificationListener(1, dSIWavePlayerListener);
                    dSIWavePlayerListener.updatePlayTone(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)iterator.next();
                    dSIWavePlayerListener.updatePlayTone(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)iterator.next();
                    this.confirmNotificationListener(2, dSIWavePlayerListener);
                    dSIWavePlayerListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)iterator.next();
                    dSIWavePlayerListener.updateAudioRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setPlayTone(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)objectArray[i2];
                    dSIWavePlayerListener.setPlayTone(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void audioTriggerResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)objectArray[i2];
                    dSIWavePlayerListener.audioTriggerResponse(n);
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
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)objectArray[i2];
                    dSIWavePlayerListener.asyncException(n, string, n2);
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
                    DSIWavePlayerListener dSIWavePlayerListener = (DSIWavePlayerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIWavePlayerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIWavePlayerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIWavePlayerListener, new Object[]{string, string2});
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

