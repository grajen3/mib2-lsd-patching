/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.connectedradio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.connectedradio.DSIOnlineRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIOnlineRadioReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.connectedradio.DSIOnlineRadioListener;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIOnlineRadioDispatcher
extends AbstractDispatcher
implements DSIOnlineRadioReply {
    private DSIOnlineRadioReplyService service = new DSIOnlineRadioReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineRadioDispatcher(int n) {
        super(n, (class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener == null ? (class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener = DSIOnlineRadioDispatcher.class$("org.dsi.ifc.connectedradio.DSIOnlineRadioListener")) : class$org$dsi$ifc$connectedradio$DSIOnlineRadioListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getRadioStationLogoResult(int n, int n2, RadioStation radioStation, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.getRadioStationLogoResult(n, n2, radioStation, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getStreamUrlResult(int n, int n2, RadioStation radioStation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.getStreamUrlResult(n, n2, radioStation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getMetaInformationResult(int n, int n2, RadioStation radioStation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.getMetaInformationResult(n, n2, radioStation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void downloadDatabaseResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.downloadDatabaseResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void cancelDownloadDatabaseResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.cancelDownloadDatabaseResult(n, n2);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlineRadioListener);
                    dSIOnlineRadioListener.updateProfileState(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)iterator.next();
                    dSIOnlineRadioListener.updateProfileState(n, n2, n3);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.profileChanged(n, n2);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.profileCopied(n, n2, n3);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.profileReset(n, n2);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.profileResetAll(n);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    dSIOnlineRadioListener.asyncException(n, string, n2);
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
                    DSIOnlineRadioListener dSIOnlineRadioListener = (DSIOnlineRadioListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineRadioDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineRadioDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineRadioListener, new Object[]{string, string2});
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

