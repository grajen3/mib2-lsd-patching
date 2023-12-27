/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTourImportReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTourImportReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.online.DSIOnlineTourImportListener;

public class DSIOnlineTourImportDispatcher
extends AbstractDispatcher
implements DSIOnlineTourImportReply {
    private DSIOnlineTourImportReplyService service = new DSIOnlineTourImportReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTourImportListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineTourImportDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineTourImportListener == null ? (class$org$dsi$ifc$online$DSIOnlineTourImportListener = DSIOnlineTourImportDispatcher.class$("org.dsi.ifc.online.DSIOnlineTourImportListener")) : class$org$dsi$ifc$online$DSIOnlineTourImportListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void indicateToursAvailable(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTourImportListener dSIOnlineTourImportListener = (DSIOnlineTourImportListener)objectArray[i2];
                    dSIOnlineTourImportListener.indicateToursAvailable(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseTourDownload(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTourImportListener dSIOnlineTourImportListener = (DSIOnlineTourImportListener)objectArray[i2];
                    dSIOnlineTourImportListener.responseTourDownload(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateTourDownloadFinished(int n, String string, String string2, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIOnlineTourImportListener dSIOnlineTourImportListener = (DSIOnlineTourImportListener)objectArray[i2];
                    dSIOnlineTourImportListener.indicateTourDownloadFinished(n, string, string2, n2);
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
                    DSIOnlineTourImportListener dSIOnlineTourImportListener = (DSIOnlineTourImportListener)objectArray[i2];
                    dSIOnlineTourImportListener.asyncException(n, string, n2);
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
                    DSIOnlineTourImportListener dSIOnlineTourImportListener = (DSIOnlineTourImportListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineTourImportDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineTourImportDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineTourImportListener, new Object[]{string, string2});
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

