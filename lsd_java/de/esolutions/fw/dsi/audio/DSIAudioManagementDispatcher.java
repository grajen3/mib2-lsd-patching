/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.audio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.audio.DSIAudioManagementReply;
import de.esolutions.fw.comm.dsi.audio.impl.DSIAudioManagementReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.audio.DSIAudioManagementListener;

public class DSIAudioManagementDispatcher
extends AbstractDispatcher
implements DSIAudioManagementReply {
    private DSIAudioManagementReplyService service = new DSIAudioManagementReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSIAudioManagementListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAudioManagementDispatcher(int n) {
        super(n, (class$org$dsi$ifc$audio$DSIAudioManagementListener == null ? (class$org$dsi$ifc$audio$DSIAudioManagementListener = DSIAudioManagementDispatcher.class$("org.dsi.ifc.audio.DSIAudioManagementListener")) : class$org$dsi$ifc$audio$DSIAudioManagementListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.errorConnection(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.fadedIn(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.pauseConnection(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveConnection(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAudioManagementListener);
                    dSIAudioManagementListener.updateActiveConnection(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    dSIAudioManagementListener.updateActiveConnection(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAudioManagementListener);
                    dSIAudioManagementListener.updateActiveEntertainmentConnection(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    dSIAudioManagementListener.updateActiveEntertainmentConnection(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startConnection(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.startConnection(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopConnection(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.stopConnection(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAMAvailable(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAudioManagementListener);
                    dSIAudioManagementListener.updateAMAvailable(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)iterator.next();
                    dSIAudioManagementListener.updateAMAvailable(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseVolumelock(int n, int n2, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.responseVolumelock(n, n2, bl);
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
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    dSIAudioManagementListener.asyncException(n, string, n2);
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
                    DSIAudioManagementListener dSIAudioManagementListener = (DSIAudioManagementListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAudioManagementDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAudioManagementDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAudioManagementListener, new Object[]{string, string2});
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

