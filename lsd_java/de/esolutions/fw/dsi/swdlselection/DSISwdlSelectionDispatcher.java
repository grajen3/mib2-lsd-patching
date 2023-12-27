/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdlselection;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.swdlselection.DSISwdlSelectionReply;
import de.esolutions.fw.comm.dsi.swdlselection.impl.DSISwdlSelectionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.swdlselection.DSISwdlSelectionListener;
import org.dsi.ifc.swdlselection.LameClient;

public class DSISwdlSelectionDispatcher
extends AbstractDispatcher
implements DSISwdlSelectionReply {
    private DSISwdlSelectionReplyService service = new DSISwdlSelectionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISwdlSelectionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener = DSISwdlSelectionDispatcher.class$("org.dsi.ifc.swdlselection.DSISwdlSelectionListener")) : class$org$dsi$ifc$swdlselection$DSISwdlSelectionListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateLameClients(LameClient[] lameClientArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(1, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateLameClients(lameClientArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateLameClients(lameClientArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEngineering(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(2, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateEngineering(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateEngineering(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUserSwdl(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(3, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateUserSwdl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateUserSwdl(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRingNotOK(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(4, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateRingNotOK(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateRingNotOK(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEndDownload(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(5, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateEndDownload(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateEndDownload(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableMedia(byte by, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(6, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateAvailableMedia(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateAvailableMedia(by, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUnitType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    this.confirmNotificationListener(7, dSISwdlSelectionListener);
                    dSISwdlSelectionListener.updateUnitType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)iterator.next();
                    dSISwdlSelectionListener.updateUnitType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getMedia(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.getMedia(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void storeNfsIpAddress(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.storeNfsIpAddress(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void storeNfsPath(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.storeNfsPath(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void storeFsPath(String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.storeFsPath(string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMedium(int n, String string, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.setMedium(n, string, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setRelease(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.setRelease(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getUserDefinedAllowed(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.getUserDefinedAllowed(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTargetLanguage(short s) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.setTargetLanguage(s);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.getIncompatibleDevices(stringArray, stringArray2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startVersionUpload(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.startVersionUpload(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void checkConsistency(int n, boolean bl, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.checkConsistency(n, bl, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void abortSetMedium() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.abortSetMedium();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void abortSetRelease() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.abortSetRelease();
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getFinalizeTargets(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.getFinalizeTargets(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setFinalizeTarget(int n, long l, long l2, long l3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.setFinalizeTarget(n, l, l2, l3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void enterComponentUpdateConfirmation() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.enterComponentUpdateConfirmation();
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
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    dSISwdlSelectionListener.asyncException(n, string, n2);
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
                    DSISwdlSelectionListener dSISwdlSelectionListener = (DSISwdlSelectionListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISwdlSelectionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISwdlSelectionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISwdlSelectionListener, new Object[]{string, string2});
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

