/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

public final class MovieShowTime {
    private int hour = 0;
    private int minute = 0;
    private boolean isTomorrow = false;

    public MovieShowTime(int n, int n2, boolean bl) {
        this.setHour(n);
        this.setMinute(n2);
        this.setTomorrow(bl);
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int n) {
        this.hour = n;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int n) {
        this.minute = n;
    }

    public boolean isTomorrow() {
        return this.isTomorrow;
    }

    public void setTomorrow(boolean bl) {
        this.isTomorrow = bl;
    }
}

