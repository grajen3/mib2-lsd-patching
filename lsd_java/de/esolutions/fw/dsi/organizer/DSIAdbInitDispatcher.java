/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbInitReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbInitReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.DSIAdbInitListener;

public class DSIAdbInitDispatcher
extends AbstractDispatcher
implements DSIAdbInitReply {
    private DSIAdbInitReplyService service = new DSIAdbInitReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbInitListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbInitDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbInitListener == null ? (class$org$dsi$ifc$organizer$DSIAdbInitListener = DSIAdbInitDispatcher.class$("org.dsi.ifc.organizer.DSIAdbInitListener")) : class$org$dsi$ifc$organizer$DSIAdbInitListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateDefaultPublicProfileVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAdbInitListener);
                    dSIAdbInitListener.updateDefaultPublicProfileVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateDefaultPublicProfileVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxLocalEntries(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAdbInitListener);
                    dSIAdbInitListener.updateMaxLocalEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateMaxLocalEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxPhoneEntries(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAdbInitListener);
                    dSIAdbInitListener.updateMaxPhoneEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateMaxPhoneEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxTopDestEntries(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAdbInitListener);
                    dSIAdbInitListener.updateMaxTopDestEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateMaxTopDestEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxSpeedDialEntries(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAdbInitListener);
                    dSIAdbInitListener.updateMaxSpeedDialEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateMaxSpeedDialEntries(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAutoProfileAllocation(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(6, dSIAdbInitListener);
                    dSIAdbInitListener.updateAutoProfileAllocation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateAutoProfileAllocation(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDefaultPublicProfileVisibilityResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setDefaultPublicProfileVisibilityResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMaxLocalEntriesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setMaxLocalEntriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMaxPhoneEntriesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setMaxPhoneEntriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMaxTopDestEntriesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setMaxTopDestEntriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMaxSpeedDialEntriesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setMaxSpeedDialEntriesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setNumericalSpellerEnabledResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setNumericalSpellerEnabledResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAutoProfileAllocationResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setAutoProfileAllocationResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSpeedDialTypeResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setSpeedDialTypeResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setProfileHandlingType(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setProfileHandlingType(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDefaultSortOrderResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setDefaultSortOrderResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setOnlineDestinationEnabledResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setOnlineDestinationEnabledResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDefaultSOSButtonResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.setDefaultSOSButtonResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDefaultSOSButton(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    this.confirmNotificationListener(7, dSIAdbInitListener);
                    dSIAdbInitListener.updateDefaultSOSButton(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)iterator.next();
                    dSIAdbInitListener.updateDefaultSOSButton(bl, n);
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
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    dSIAdbInitListener.asyncException(n, string, n2);
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
                    DSIAdbInitListener dSIAdbInitListener = (DSIAdbInitListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbInitDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbInitDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbInitListener, new Object[]{string, string2});
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

