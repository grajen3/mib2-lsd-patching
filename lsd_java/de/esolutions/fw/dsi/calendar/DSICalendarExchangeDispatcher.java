/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.calendar;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchangeReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarExchangeReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.calendar.DSICalendarExchangeListener;

public class DSICalendarExchangeDispatcher
extends AbstractDispatcher
implements DSICalendarExchangeReply {
    private DSICalendarExchangeReplyService service = new DSICalendarExchangeReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$calendar$DSICalendarExchangeListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICalendarExchangeDispatcher(int n) {
        super(n, (class$org$dsi$ifc$calendar$DSICalendarExchangeListener == null ? (class$org$dsi$ifc$calendar$DSICalendarExchangeListener = DSICalendarExchangeDispatcher.class$("org.dsi.ifc.calendar.DSICalendarExchangeListener")) : class$org$dsi$ifc$calendar$DSICalendarExchangeListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void parseICalResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    dSICalendarExchangeListener.parseICalResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void parseICalDirectoryResult(int[] nArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    dSICalendarExchangeListener.parseICalDirectoryResult(nArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void exportICalResult(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    dSICalendarExchangeListener.exportICalResult(n, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void finishExportResult(int n, long[] lArray, int n2, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    dSICalendarExchangeListener.finishExportResult(n, lArray, n2, string);
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
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    dSICalendarExchangeListener.asyncException(n, string, n2);
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
                    DSICalendarExchangeListener dSICalendarExchangeListener = (DSICalendarExchangeListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICalendarExchangeDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICalendarExchangeDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICalendarExchangeListener, new Object[]{string, string2});
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

