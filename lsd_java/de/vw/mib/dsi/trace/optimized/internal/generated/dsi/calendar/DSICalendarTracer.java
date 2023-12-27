/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.calendar;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.calendar.CalendarConfig;
import org.dsi.ifc.calendar.CalendarEntry;
import org.dsi.ifc.calendar.CalendarSummary;
import org.dsi.ifc.calendar.ICalParseResult;
import org.dsi.ifc.calendar.ProfileInfo;
import org.dsi.ifc.calendar.VAlarm;
import org.dsi.ifc.calendar.VAttendee;
import org.dsi.ifc.calendar.VCalendar;
import org.dsi.ifc.calendar.VEvent;
import org.dsi.ifc.calendar.VTimeZone;
import org.dsi.ifc.calendar.VTimeZoneStandard;

public final class DSICalendarTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CALENDARCONFIG;
    private static final int ID_CALENDARENTRY;
    private static final int ID_CALENDARSUMMARY;
    private static final int ID_ICALPARSERESULT;
    private static final int ID_PROFILEINFO;
    private static final int ID_VALARM;
    private static final int ID_VATTENDEE;
    private static final int ID_VCALENDAR;
    private static final int ID_VEVENT;
    private static final int ID_VTIMEZONE;
    private static final int ID_VTIMEZONESTANDARD;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$CalendarConfig;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$CalendarEntry;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$CalendarSummary;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$ICalParseResult;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$ProfileInfo;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VAlarm;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VAttendee;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VCalendar;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VEvent;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VTimeZone;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$VTimeZoneStandard;

    public DSICalendarTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$CalendarConfig == null ? (class$org$dsi$ifc$calendar$CalendarConfig = DSICalendarTracer.class$("org.dsi.ifc.calendar.CalendarConfig")) : class$org$dsi$ifc$calendar$CalendarConfig, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$CalendarEntry == null ? (class$org$dsi$ifc$calendar$CalendarEntry = DSICalendarTracer.class$("org.dsi.ifc.calendar.CalendarEntry")) : class$org$dsi$ifc$calendar$CalendarEntry, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$CalendarSummary == null ? (class$org$dsi$ifc$calendar$CalendarSummary = DSICalendarTracer.class$("org.dsi.ifc.calendar.CalendarSummary")) : class$org$dsi$ifc$calendar$CalendarSummary, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$ICalParseResult == null ? (class$org$dsi$ifc$calendar$ICalParseResult = DSICalendarTracer.class$("org.dsi.ifc.calendar.ICalParseResult")) : class$org$dsi$ifc$calendar$ICalParseResult, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$ProfileInfo == null ? (class$org$dsi$ifc$calendar$ProfileInfo = DSICalendarTracer.class$("org.dsi.ifc.calendar.ProfileInfo")) : class$org$dsi$ifc$calendar$ProfileInfo, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VAlarm == null ? (class$org$dsi$ifc$calendar$VAlarm = DSICalendarTracer.class$("org.dsi.ifc.calendar.VAlarm")) : class$org$dsi$ifc$calendar$VAlarm, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VAttendee == null ? (class$org$dsi$ifc$calendar$VAttendee = DSICalendarTracer.class$("org.dsi.ifc.calendar.VAttendee")) : class$org$dsi$ifc$calendar$VAttendee, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VCalendar == null ? (class$org$dsi$ifc$calendar$VCalendar = DSICalendarTracer.class$("org.dsi.ifc.calendar.VCalendar")) : class$org$dsi$ifc$calendar$VCalendar, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VEvent == null ? (class$org$dsi$ifc$calendar$VEvent = DSICalendarTracer.class$("org.dsi.ifc.calendar.VEvent")) : class$org$dsi$ifc$calendar$VEvent, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VTimeZone == null ? (class$org$dsi$ifc$calendar$VTimeZone = DSICalendarTracer.class$("org.dsi.ifc.calendar.VTimeZone")) : class$org$dsi$ifc$calendar$VTimeZone, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$calendar$VTimeZoneStandard == null ? (class$org$dsi$ifc$calendar$VTimeZoneStandard = DSICalendarTracer.class$("org.dsi.ifc.calendar.VTimeZoneStandard")) : class$org$dsi$ifc$calendar$VTimeZoneStandard, 11);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCalendarConfig(printWriter, (CalendarConfig)object);
                break;
            }
            case 2: {
                this.traceCalendarEntry(printWriter, (CalendarEntry)object);
                break;
            }
            case 3: {
                this.traceCalendarSummary(printWriter, (CalendarSummary)object);
                break;
            }
            case 4: {
                this.traceICalParseResult(printWriter, (ICalParseResult)object);
                break;
            }
            case 5: {
                this.traceProfileInfo(printWriter, (ProfileInfo)object);
                break;
            }
            case 6: {
                this.traceVAlarm(printWriter, (VAlarm)object);
                break;
            }
            case 7: {
                this.traceVAttendee(printWriter, (VAttendee)object);
                break;
            }
            case 8: {
                this.traceVCalendar(printWriter, (VCalendar)object);
                break;
            }
            case 9: {
                this.traceVEvent(printWriter, (VEvent)object);
                break;
            }
            case 10: {
                this.traceVTimeZone(printWriter, (VTimeZone)object);
                break;
            }
            case 11: {
                this.traceVTimeZoneStandard(printWriter, (VTimeZoneStandard)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCalendarConfig(PrintWriter printWriter, CalendarConfig calendarConfig) {
        if (calendarConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(calendarConfig.idProfile);
        if (calendarConfig.calendarWeekDays == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = calendarConfig.calendarWeekDays.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(calendarConfig.calendarWeekDays[i2]);
            }
        }
        this.trace(printWriter, calendarConfig.startTime);
        this.trace(printWriter, calendarConfig.endTime);
        printWriter.print(calendarConfig.weekStartDay);
        this.trace(printWriter, calendarConfig.ringToneRemindCalendar);
        this.trace(printWriter, calendarConfig.ringToneRemindTask);
        printWriter.print(calendarConfig.volRingToneCalendar);
        printWriter.print(calendarConfig.volRingToneTask);
        printWriter.print(calendarConfig.ringToneCalendarEnabled);
        printWriter.print(calendarConfig.ringToneTaskEnabled);
        printWriter.print(calendarConfig.weekView);
    }

    private void traceCalendarEntry(PrintWriter printWriter, CalendarEntry calendarEntry) {
        int n;
        int n2;
        if (calendarEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(calendarEntry.eventID);
        printWriter.print(calendarEntry.organizer);
        printWriter.print(calendarEntry.summary);
        printWriter.print(calendarEntry.location);
        if (calendarEntry.attendee == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = calendarEntry.attendee.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(calendarEntry.attendee[n]);
            }
        }
        printWriter.print(calendarEntry.description);
        this.trace(printWriter, calendarEntry.start);
        this.trace(printWriter, calendarEntry.end);
        printWriter.print(calendarEntry.entryClass);
        printWriter.print(calendarEntry.priority);
        printWriter.print(calendarEntry.status);
        if (calendarEntry.categories == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = calendarEntry.categories.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(calendarEntry.categories[n]);
            }
        }
        printWriter.print(calendarEntry.sequence);
        printWriter.print(calendarEntry.prodID);
        printWriter.print(calendarEntry.icalUID);
        printWriter.print(calendarEntry.version);
        this.trace(printWriter, calendarEntry.created);
        this.trace(printWriter, calendarEntry.lastModified);
    }

    private void traceCalendarSummary(PrintWriter printWriter, CalendarSummary calendarSummary) {
        if (calendarSummary == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, calendarSummary.start);
        this.trace(printWriter, calendarSummary.end);
        printWriter.print(calendarSummary.location);
        printWriter.print(calendarSummary.summary);
        printWriter.print(calendarSummary.eventID);
    }

    private void traceICalParseResult(PrintWriter printWriter, ICalParseResult iCalParseResult) {
        if (iCalParseResult == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(iCalParseResult.fileAbslPath);
        printWriter.print(iCalParseResult.errorText);
        printWriter.print(iCalParseResult.resultCode);
    }

    private void traceProfileInfo(PrintWriter printWriter, ProfileInfo profileInfo) {
        if (profileInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(profileInfo.numProfile);
        printWriter.print(profileInfo.name);
        printWriter.print(profileInfo.homeId);
        printWriter.print(profileInfo.pairingCode);
        printWriter.print(profileInfo.publicProfileVisibility);
    }

    private void traceVAlarm(PrintWriter printWriter, VAlarm vAlarm) {
        if (vAlarm == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vAlarm.action);
        printWriter.print(vAlarm.description);
        printWriter.print(vAlarm.trigger);
    }

    private void traceVAttendee(PrintWriter printWriter, VAttendee vAttendee) {
        if (vAttendee == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vAttendee.cn);
        printWriter.print(vAttendee.cutype);
        printWriter.print(vAttendee.mailto);
        printWriter.print(vAttendee.role);
        printWriter.print(vAttendee.rsvp);
    }

    private void traceVCalendar(PrintWriter printWriter, VCalendar vCalendar) {
        int n;
        int n2;
        if (vCalendar == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vCalendar.categories);
        printWriter.print(vCalendar.classType);
        printWriter.print(vCalendar.description);
        printWriter.print(vCalendar.dtEnd);
        printWriter.print(vCalendar.dtStamp);
        printWriter.print(vCalendar.dtStart);
        printWriter.print(vCalendar.method);
        printWriter.print(vCalendar.summary);
        if (vCalendar.timeZone == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vCalendar.timeZone.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, vCalendar.timeZone[n]);
            }
        }
        printWriter.print(vCalendar.tzID);
        printWriter.print(vCalendar.uid);
        printWriter.print(vCalendar.version);
        if (vCalendar.vevent == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vCalendar.vevent.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, vCalendar.vevent[n]);
            }
        }
    }

    private void traceVEvent(PrintWriter printWriter, VEvent vEvent) {
        if (vEvent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, vEvent.alarm);
        if (vEvent.attendeeList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = vEvent.attendeeList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, vEvent.attendeeList[i2]);
            }
        }
        printWriter.print(vEvent.categories);
        printWriter.print(vEvent.classTyp);
        printWriter.print(vEvent.created);
        printWriter.print(vEvent.description);
        printWriter.print(vEvent.dtEnd);
        printWriter.print(vEvent.dtStart);
        printWriter.print(vEvent.dtStamp);
        printWriter.print(vEvent.duration);
        printWriter.print(vEvent.lastModified);
        printWriter.print(vEvent.location);
        printWriter.print(vEvent.priority);
        this.trace(printWriter, vEvent.organizer);
        printWriter.print(vEvent.summary);
        printWriter.print(vEvent.uid);
        printWriter.print(vEvent.rrule);
        printWriter.print(vEvent.sequence);
        printWriter.print(vEvent.transp);
        printWriter.print(vEvent.url);
        printWriter.print(vEvent.entryType);
    }

    private void traceVTimeZone(PrintWriter printWriter, VTimeZone vTimeZone) {
        int n;
        int n2;
        if (vTimeZone == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vTimeZone.tzID);
        if (vTimeZone.daylight == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vTimeZone.daylight.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, vTimeZone.daylight[n]);
            }
        }
        if (vTimeZone.standard == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = vTimeZone.standard.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, vTimeZone.standard[n]);
            }
        }
    }

    private void traceVTimeZoneStandard(PrintWriter printWriter, VTimeZoneStandard vTimeZoneStandard) {
        if (vTimeZoneStandard == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(vTimeZoneStandard.dtStart);
        printWriter.print(vTimeZoneStandard.rdate);
        printWriter.print(vTimeZoneStandard.rrule);
        printWriter.print(vTimeZoneStandard.tzName);
        printWriter.print(vTimeZoneStandard.entryTyp);
        printWriter.print(vTimeZoneStandard.tzOffsetFrom);
        printWriter.print(vTimeZoneStandard.tzOffsetTo);
        printWriter.print(vTimeZoneStandard.due);
        printWriter.print(vTimeZoneStandard.exdate);
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

