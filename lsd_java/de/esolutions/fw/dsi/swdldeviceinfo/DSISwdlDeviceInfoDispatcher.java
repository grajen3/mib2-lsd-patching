/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdldeviceinfo;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.swdldeviceinfo.DSISwdlDeviceInfoReply;
import de.esolutions.fw.comm.dsi.swdldeviceinfo.impl.DSISwdlDeviceInfoReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener;

public class DSISwdlDeviceInfoDispatcher
extends AbstractDispatcher
implements DSISwdlDeviceInfoReply {
    private DSISwdlDeviceInfoReplyService service = new DSISwdlDeviceInfoReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISwdlDeviceInfoDispatcher(int n) {
        super(n, (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener = DSISwdlDeviceInfoDispatcher.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfoListener")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfoListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateSummaryChanged(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)iterator.next();
                    this.confirmNotificationListener(1, dSISwdlDeviceInfoListener);
                    dSISwdlDeviceInfoListener.updateSummaryChanged(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)iterator.next();
                    dSISwdlDeviceInfoListener.updateSummaryChanged(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDevices(String[] stringArray, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getDevices(stringArray, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getModules(int n, String[] stringArray, int[] nArray, short[] sArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getModules(n, stringArray, nArray, sArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getLanguages(int n, String[] stringArray, short s, short s2, short s3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getLanguages(n, stringArray, s, s2, s3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getErrors(int n, int[] nArray, short[] sArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getErrors(n, nArray, sArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void isDataModule(int n, int n2, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.isDataModule(n, n2, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void isNoExclusiveBoloUpdate(int n, int n2, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.isNoExclusiveBoloUpdate(n, n2, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getVersions(int n, int n2, long[] lArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getVersions(n, n2, lArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getTargetVersions(int n, int n2, long[] lArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getTargetVersions(n, n2, lArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getAdditionalInfo(int n, int n2, int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getAdditionalInfo(n, n2, nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getFileNames(int n, int n2, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getFileNames(n, n2, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getFileDetails(int n, int n2, int n3, long l, long l2, long l3, boolean bl, boolean bl2, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getFileDetails(n, n2, n3, l, l2, l3, bl, bl2, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getInfoFilePath(int n, String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getInfoFilePath(n, string, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getNumberOfPopups(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getNumberOfPopups(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getPopup(int n, int n2, String string, int n3, int n4, int n5, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.getPopup(n, n2, string, n3, n4, n5, string2);
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
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    dSISwdlDeviceInfoListener.asyncException(n, string, n2);
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
                    DSISwdlDeviceInfoListener dSISwdlDeviceInfoListener = (DSISwdlDeviceInfoListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISwdlDeviceInfoDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISwdlDeviceInfoDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISwdlDeviceInfoListener, new Object[]{string, string2});
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

