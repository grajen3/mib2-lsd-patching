/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.ddp20;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.ddp20.DSIDDP20Reply;
import de.esolutions.fw.comm.dsi.ddp20.impl.DSIDDP20ReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.ddp20.DSIDDP20Listener;
import org.dsi.ifc.ddp20.DisplayStatus;
import org.dsi.ifc.ddp20.VersionInfo;

public class DSIDDP20Dispatcher
extends AbstractDispatcher
implements DSIDDP20Reply {
    private DSIDDP20ReplyService service = new DSIDDP20ReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$ddp20$DSIDDP20Listener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDDP20Dispatcher(int n) {
        super(n, (class$org$dsi$ifc$ddp20$DSIDDP20Listener == null ? (class$org$dsi$ifc$ddp20$DSIDDP20Listener = DSIDDP20Dispatcher.class$("org.dsi.ifc.ddp20.DSIDDP20Listener")) : class$org$dsi$ifc$ddp20$DSIDDP20Listener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateVersionInfo(VersionInfo versionInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    this.confirmNotificationListener(1, dSIDDP20Listener);
                    dSIDDP20Listener.updateVersionInfo(versionInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    dSIDDP20Listener.updateVersionInfo(versionInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePowerStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    this.confirmNotificationListener(2, dSIDDP20Listener);
                    dSIDDP20Listener.updatePowerStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    dSIDDP20Listener.updatePowerStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDisplayStatus(DisplayStatus displayStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    this.confirmNotificationListener(3, dSIDDP20Listener);
                    dSIDDP20Listener.updateDisplayStatus(displayStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    dSIDDP20Listener.updateDisplayStatus(displayStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBufferStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    this.confirmNotificationListener(4, dSIDDP20Listener);
                    dSIDDP20Listener.updateBufferStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)iterator.next();
                    dSIDDP20Listener.updateBufferStatus(n, n2);
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
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)objectArray[i2];
                    dSIDDP20Listener.asyncException(n, string, n2);
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
                    DSIDDP20Listener dSIDDP20Listener = (DSIDDP20Listener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDDP20Dispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDDP20Dispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDDP20Listener, new Object[]{string, string2});
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

