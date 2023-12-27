/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TraceTimeStamp
implements Comparable {
    private static final String fullFormat;
    private static final SimpleDateFormat ftf;
    private static final SimpleDateFormat ftfLoc;
    private static final String timeFormat;
    private static final SimpleDateFormat stf;
    private static final SimpleDateFormat stfLoc;
    private static final String dateFormat;
    private static final SimpleDateFormat dtf;
    private static final SimpleDateFormat dtfLoc;
    private Date date;

    public TraceTimeStamp(long l) {
        this.date = new Date(l);
    }

    public TraceTimeStamp() {
        this.date = new Date();
    }

    public TraceTimeStamp(Date date) {
        this.date = date;
    }

    public long getMillis() {
        return this.date.getTime();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toUTCTimeString(boolean bl) {
        if (bl) {
            SimpleDateFormat simpleDateFormat = ftf;
            synchronized (simpleDateFormat) {
                ftf.setTimeZone(TimeZone.getTimeZone("UTC"));
                return ftf.format(this.date);
            }
        }
        SimpleDateFormat simpleDateFormat = stf;
        synchronized (simpleDateFormat) {
            stf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return stf.format(this.date);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean parseUTCTimeString(String string, boolean bl) {
        try {
            if (bl) {
                SimpleDateFormat simpleDateFormat = ftf;
                synchronized (simpleDateFormat) {
                    ftf.setTimeZone(TimeZone.getTimeZone("UTC"));
                    this.date = ftf.parse(string);
                    return true;
                }
            }
            SimpleDateFormat simpleDateFormat = stf;
            synchronized (simpleDateFormat) {
                stf.setTimeZone(TimeZone.getTimeZone("UTC"));
                this.date = stf.parse(string);
                return true;
            }
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toUTCDateString() {
        SimpleDateFormat simpleDateFormat = dtf;
        synchronized (simpleDateFormat) {
            dtf.setTimeZone(TimeZone.getTimeZone("UTC"));
            return dtf.format(this.date);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean parseUTCDateString(String string) {
        try {
            SimpleDateFormat simpleDateFormat = dtf;
            synchronized (simpleDateFormat) {
                dtf.setTimeZone(TimeZone.getTimeZone("UTC"));
                this.date = dtf.parse(string);
            }
            return true;
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toLocalTimeString(boolean bl) {
        if (bl) {
            SimpleDateFormat simpleDateFormat = ftfLoc;
            synchronized (simpleDateFormat) {
                return ftfLoc.format(this.date);
            }
        }
        SimpleDateFormat simpleDateFormat = stfLoc;
        synchronized (simpleDateFormat) {
            return stfLoc.format(this.date);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean parseLocalTimeString(String string, boolean bl) {
        try {
            if (bl) {
                SimpleDateFormat simpleDateFormat = ftfLoc;
                synchronized (simpleDateFormat) {
                    this.date = ftfLoc.parse(string);
                    return true;
                }
            }
            SimpleDateFormat simpleDateFormat = stfLoc;
            synchronized (simpleDateFormat) {
                this.date = stfLoc.parse(string);
                return true;
            }
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toLocalDateString() {
        SimpleDateFormat simpleDateFormat = dtfLoc;
        synchronized (simpleDateFormat) {
            return dtfLoc.format(this.date);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean parseLocalDateString(String string) {
        try {
            SimpleDateFormat simpleDateFormat = dtfLoc;
            synchronized (simpleDateFormat) {
                this.date = dtfLoc.parse(string);
            }
            return true;
        }
        catch (ParseException parseException) {
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        SimpleDateFormat simpleDateFormat = ftf;
        synchronized (simpleDateFormat) {
            return ftf.format(this.date);
        }
    }

    public static String longToUTCTimeString(long l, boolean bl) {
        return new TraceTimeStamp(l).toUTCTimeString(bl);
    }

    public static String longToLocalTimeString(long l, boolean bl) {
        return new TraceTimeStamp(l).toLocalTimeString(bl);
    }

    public static String longToUTCDateString(long l) {
        return new TraceTimeStamp(l).toUTCDateString();
    }

    public static String longToLocalDateString(long l) {
        return new TraceTimeStamp(l).toLocalDateString();
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof TraceTimeStamp)) {
            return false;
        }
        TraceTimeStamp traceTimeStamp = (TraceTimeStamp)object;
        return this.date.equals(traceTimeStamp.date);
    }

    public int hashCode() {
        int n = 1;
        n = n * 17 + (this.date == null ? 0 : this.date.hashCode());
        return n;
    }

    @Override
    public int compareTo(Object object) {
        if (object == null) {
            return -1;
        }
        if (!(object instanceof TraceTimeStamp)) {
            return -1;
        }
        TraceTimeStamp traceTimeStamp = (TraceTimeStamp)object;
        return this.date.compareTo(traceTimeStamp.date);
    }

    static {
        ftf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        ftfLoc = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SSS");
        stf = new SimpleDateFormat("HH:mm:ss.SSS");
        stfLoc = new SimpleDateFormat("HH:mm:ss.SSS");
        dtf = new SimpleDateFormat("dd.MM.yyyy");
        dtfLoc = new SimpleDateFormat("dd.MM.yyyy");
    }
}

