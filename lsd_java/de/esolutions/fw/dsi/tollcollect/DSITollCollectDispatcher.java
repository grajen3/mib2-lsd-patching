/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tollcollect;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tollcollect.DSITollCollectReply;
import de.esolutions.fw.comm.dsi.tollcollect.impl.DSITollCollectReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.tollcollect.DSITollCollectListener;
import org.dsi.ifc.tollcollect.TCCardDateInformation;
import org.dsi.ifc.tollcollect.TCCardError;
import org.dsi.ifc.tollcollect.TCHardwareInformation;
import org.dsi.ifc.tollcollect.TCPaymentInfo;
import org.dsi.ifc.tollcollect.TCPaymentInfoDetails;

public class DSITollCollectDispatcher
extends AbstractDispatcher
implements DSITollCollectReply {
    private DSITollCollectReplyService service = new DSITollCollectReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tollcollect$DSITollCollectListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITollCollectDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tollcollect$DSITollCollectListener == null ? (class$org$dsi$ifc$tollcollect$DSITollCollectListener = DSITollCollectDispatcher.class$("org.dsi.ifc.tollcollect.DSITollCollectListener")) : class$org$dsi$ifc$tollcollect$DSITollCollectListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateCardState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    this.confirmNotificationListener(1, dSITollCollectListener);
                    dSITollCollectListener.updateCardState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    dSITollCollectListener.updateCardState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCardError(TCCardError tCCardError, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    this.confirmNotificationListener(2, dSITollCollectListener);
                    dSITollCollectListener.updateCardError(tCCardError, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    dSITollCollectListener.updateCardError(tCCardError, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCardDateInformation(TCCardDateInformation tCCardDateInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    this.confirmNotificationListener(3, dSITollCollectListener);
                    dSITollCollectListener.updateCardDateInformation(tCCardDateInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    dSITollCollectListener.updateCardDateInformation(tCCardDateInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHardwareInformation(TCHardwareInformation[] tCHardwareInformationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    this.confirmNotificationListener(4, dSITollCollectListener);
                    dSITollCollectListener.updateHardwareInformation(tCHardwareInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    dSITollCollectListener.updateHardwareInformation(tCHardwareInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentTollPayment(NavPriceInfo navPriceInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    this.confirmNotificationListener(5, dSITollCollectListener);
                    dSITollCollectListener.updateCurrentTollPayment(navPriceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)iterator.next();
                    dSITollCollectListener.updateCurrentTollPayment(navPriceInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestPaymentHistoryListResult(TCPaymentInfo[] tCPaymentInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)objectArray[i2];
                    dSITollCollectListener.requestPaymentHistoryListResult(tCPaymentInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestPaymentHistoryDetailsResult(int n, TCPaymentInfoDetails tCPaymentInfoDetails) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)objectArray[i2];
                    dSITollCollectListener.requestPaymentHistoryDetailsResult(n, tCPaymentInfoDetails);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)objectArray[i2];
                    dSITollCollectListener.setLanguageResponse(bl);
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
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)objectArray[i2];
                    dSITollCollectListener.asyncException(n, string, n2);
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
                    DSITollCollectListener dSITollCollectListener = (DSITollCollectListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITollCollectDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITollCollectDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITollCollectListener, new Object[]{string, string2});
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

