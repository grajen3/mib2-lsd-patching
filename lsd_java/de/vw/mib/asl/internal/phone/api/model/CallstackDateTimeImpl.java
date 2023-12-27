/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.services.callstack.CallstackDateTime;

public final class CallstackDateTimeImpl
implements CallstackDateTime {
    private final short year;
    private final short month;
    private final short day;
    private final short hour;
    private final short minute;
    private final short second;

    public CallstackDateTimeImpl(short s, short s2, short s3, short s4, short s5, short s6) {
        this.year = s;
        this.month = s2;
        this.day = s3;
        this.hour = s4;
        this.minute = s5;
        this.second = s6;
    }

    @Override
    public short getYear() {
        return this.year;
    }

    @Override
    public short getMonth() {
        return this.month;
    }

    @Override
    public short getDay() {
        return this.day;
    }

    @Override
    public short getHour() {
        return this.hour;
    }

    @Override
    public short getMinute() {
        return this.minute;
    }

    @Override
    public short getSecond() {
        return this.second;
    }
}

