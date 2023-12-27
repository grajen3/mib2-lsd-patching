/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.physics.internal;

import de.vw.mib.physics.GeoAngle;

class GeoAngleImpl
implements GeoAngle {
    private static final int MODULO_LATITUDE;
    private static final int MODULO_LONGITUDE;
    private final int modulo;
    private double decimal;
    private int degrees;
    private int minutes;
    private double seconds;
    private boolean negative;

    static GeoAngleImpl createLatitude() {
        return new GeoAngleImpl(90);
    }

    static GeoAngleImpl createLongitude() {
        return new GeoAngleImpl(180);
    }

    private GeoAngleImpl(int n) {
        this.modulo = n;
    }

    @Override
    public double getDecimal() {
        return this.decimal;
    }

    @Override
    public int getDegrees() {
        return this.degrees;
    }

    @Override
    public int getMinutes() {
        return this.minutes;
    }

    @Override
    public double getSeconds() {
        return this.seconds;
    }

    @Override
    public boolean isNegative() {
        return this.negative;
    }

    @Override
    public void set(int n, int n2, double d2, boolean bl) {
        int n3 = Math.abs(n);
        int n4 = Math.abs(n2);
        double d3 = Math.abs(d2);
        double d4 = (d3 / 60.0 + (double)n4) / 60.0 + (double)n3;
        this.set(bl ? -d4 : d4);
    }

    @Override
    public void set(double d2) {
        this.negative = 0.0 > d2;
        d2 = Math.abs(d2);
        if (0 < this.modulo && (double)this.modulo < d2) {
            d2 = this.modulo;
        }
        this.decimal = d2;
        this.degrees = (int)this.decimal;
        d2 = (d2 - (double)this.degrees) * 60.0;
        this.minutes = (int)d2;
        this.seconds = (d2 - (double)this.minutes) * 60.0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(80);
        stringBuffer.append("GeoAngle[");
        stringBuffer.append("dec=").append(this.decimal);
        stringBuffer.append(",dms=");
        if (this.negative) {
            stringBuffer.append("-");
        }
        stringBuffer.append(this.degrees).append("\u00b0");
        stringBuffer.append(this.minutes).append("'");
        stringBuffer.append(this.seconds).append("\"");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}

