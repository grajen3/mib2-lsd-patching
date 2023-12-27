/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMediaBaseReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaBaseReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.media.DSIMediaBaseListener;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class DSIMediaBaseDispatcher
extends AbstractDispatcher
implements DSIMediaBaseReply {
    private DSIMediaBaseReplyService service = new DSIMediaBaseReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaBaseDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = DSIMediaBaseDispatcher.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateParentalML(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateParentalML(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateParentalML(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePreferredLanguage(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaBaseListener);
                    dSIMediaBaseListener.updatePreferredLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updatePreferredLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMediaList(MediaInfo[] mediaInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateMediaList(mediaInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateMediaList(mediaInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDeviceList(DeviceInfo[] deviceInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateDeviceList(deviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateDeviceList(deviceInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCustomerUpdate(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateCustomerUpdate(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateCustomerUpdate(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateApplicationVersion(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateApplicationVersion(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateApplicationVersion(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMetadataDBVersion(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateMetadataDBVersion(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateMetadataDBVersion(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseResetFactorySettings(int n, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.responseResetFactorySettings(n, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void launchAppResult(long l, long l2, String string, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.launchAppResult(l, l2, string, bl);
                    continue;
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMediaBaseListener);
                    dSIMediaBaseListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)iterator.next();
                    dSIMediaBaseListener.updateProfileState(n, n2, n3);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.profileChanged(n, n2);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.profileCopied(n, n2, n3);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.profileReset(n, n2);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.profileResetAll(n);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    dSIMediaBaseListener.asyncException(n, string, n2);
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
                    DSIMediaBaseListener dSIMediaBaseListener = (DSIMediaBaseListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaBaseDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaBaseDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaBaseListener, new Object[]{string, string2});
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

