/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.organizer;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSetupReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbSetupReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.organizer.DSIAdbSetupListener;

public class DSIAdbSetupDispatcher
extends AbstractDispatcher
implements DSIAdbSetupReply {
    private DSIAdbSetupReplyService service = new DSIAdbSetupReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$organizer$DSIAdbSetupListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAdbSetupDispatcher(int n) {
        super(n, (class$org$dsi$ifc$organizer$DSIAdbSetupListener == null ? (class$org$dsi$ifc$organizer$DSIAdbSetupListener = DSIAdbSetupDispatcher.class$("org.dsi.ifc.organizer.DSIAdbSetupListener")) : class$org$dsi$ifc$organizer$DSIAdbSetupListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAdbState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAdbSetupListener);
                    dSIAdbSetupListener.updateAdbState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    dSIAdbSetupListener.updateAdbState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSortOrder(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAdbSetupListener);
                    dSIAdbSetupListener.updateSortOrder(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    dSIAdbSetupListener.updateSortOrder(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePictureVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAdbSetupListener);
                    dSIAdbSetupListener.updatePictureVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    dSIAdbSetupListener.updatePictureVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setLanguageResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.setLanguageResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSortOrderResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.setSortOrderResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setPublicProfileVisibilityResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.setPublicProfileVisibilityResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetToFactorySettingsResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.resetToFactorySettingsResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetTopDestinationResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.resetTopDestinationResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void createBackupFileResult(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.createBackupFileResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void importBackupFileResult(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.importBackupFileResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setPictureVisibilityResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.setPictureVisibilityResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setContextSpecificVisibilityResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.setContextSpecificVisibilityResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateContextSpecificVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAdbSetupListener);
                    dSIAdbSetupListener.updateContextSpecificVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)iterator.next();
                    dSIAdbSetupListener.updateContextSpecificVisibility(bl, n);
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
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    dSIAdbSetupListener.asyncException(n, string, n2);
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
                    DSIAdbSetupListener dSIAdbSetupListener = (DSIAdbSetupListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAdbSetupDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAdbSetupDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAdbSetupListener, new Object[]{string, string2});
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

