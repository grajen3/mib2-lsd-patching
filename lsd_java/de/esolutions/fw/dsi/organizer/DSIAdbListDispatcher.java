/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbListReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbListReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DSIAdbListListener;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public class DSIAdbListDispatcher
extends AbstractDispatcher
implements DSIAdbListReply {
    private DSIAdbListReplyService service = new DSIAdbListReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbListListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbListDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbListListener == null ? (class$org$dsi$ifc$organizer$DSIAdbListListener = DSIAdbListDispatcher.class$("org.dsi.ifc.organizer.DSIAdbListListener")) : class$org$dsi$ifc$organizer$DSIAdbListListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateViewSize(AdbViewSize adbViewSize, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAdbListListener);
                    dSIAdbListListener.updateViewSize(adbViewSize, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)iterator.next();
                    dSIAdbListListener.updateViewSize(adbViewSize, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void invalidData(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.invalidData(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void stopSpellerResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.stopSpellerResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.spellerResult(n, n2, dataSetArray, n3, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.validateSpellerCharsResult(n, n2, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getViewWindowResult(int n, DataSet[] dataSetArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.getViewWindowResult(n, dataSetArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getSpellerViewWindowResult(int n, int n2, DataSet[] dataSetArray, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.getSpellerViewWindowResult(n, n2, dataSetArray, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.getValidHanziCharsWindowResult(n, n2, n3, string, n4);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setListStyleResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.setListStyleResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAlphabeticalIndex(IndexInformation[] indexInformationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAdbListListener);
                    dSIAdbListListener.updateAlphabeticalIndex(indexInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)iterator.next();
                    dSIAdbListListener.updateAlphabeticalIndex(indexInformationArray, n);
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
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    dSIAdbListListener.asyncException(n, string, n2);
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
                    DSIAdbListListener dSIAdbListListener = (DSIAdbListListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbListDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbListDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbListListener, new Object[]{string, string2});
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

