/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.calendar;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;
import org.dsi.ifc.calendar.DSICalendarListener;

public class DSICalendarDispatcher
extends AbstractDispatcher
implements DSICalendarReply {
    private DSICalendarReplyService service = new DSICalendarReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$calendar$DSICalendarListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICalendarDispatcher(int n) {
        super(n, (class$org$dsi$ifc$calendar$DSICalendarListener == null ? (class$org$dsi$ifc$calendar$DSICalendarListener = DSICalendarDispatcher.class$("org.dsi.ifc.calendar.DSICalendarListener")) : class$org$dsi$ifc$calendar$DSICalendarListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void getCalendarSummariesResult(int n, CalendarSummary[] calendarSummaryArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getCalendarSummariesResult(n, calendarSummaryArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getCalendarEntryResult(int n, CalendarEntry calendarEntry) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getCalendarEntryResult(n, calendarEntry);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateAlarm(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.indicateAlarm(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setCalendarConfigResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.setCalendarConfigResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getCalendarConfigResult(int n, CalendarConfig calendarConfig) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getCalendarConfigResult(n, calendarConfig);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setAlarmRepeatResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.setAlarmRepeatResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getAlarmRepeatResult(int n, long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getAlarmRepeatResult(n, l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getEmailAddressesResult(int n, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getEmailAddressesResult(n, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getTelephoneNumbersResult(int n, String[] stringArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.getTelephoneNumbersResult(n, stringArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void insertProfileResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.insertProfileResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteProfileResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.deleteProfileResult(n);
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
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    dSICalendarListener.asyncException(n, string, n2);
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
                    DSICalendarListener dSICalendarListener = (DSICalendarListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICalendarDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICalendarDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICalendarListener, new Object[]{string, string2});
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

