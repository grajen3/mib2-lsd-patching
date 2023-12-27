/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

public class sTmcLocationReference {
    public int location;
    public short countryCode;
    public short ltn;
    public short extent;
    public short direction;
    public long offset;
    public long hzd;

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int n) {
        this.location = n;
    }

    public short getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(short s) {
        this.countryCode = s;
    }

    public short getLtn() {
        return this.ltn;
    }

    public void setLtn(short s) {
        this.ltn = s;
    }

    public short getExtent() {
        return this.extent;
    }

    public void setExtent(short s) {
        this.extent = s;
    }

    public short getDirection() {
        return this.direction;
    }

    public void setDirection(short s) {
        this.direction = s;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long l) {
        this.offset = l;
    }

    public long getHzd() {
        return this.hzd;
    }

    public void setHzd(long l) {
        this.hzd = l;
    }

    public sTmcLocationReference() {
    }

    public sTmcLocationReference(int n, short s, short s2, short s3, short s4, long l, long l2) {
        this.location = n;
        this.countryCode = s;
        this.ltn = s2;
        this.extent = s3;
        this.direction = s4;
        this.offset = l;
        this.hzd = l2;
    }

    public String toString() {
        return new StringBuffer("sTmcLocationReference{").append("location=").append(this.location).append(", countryCode=").append(this.countryCode).append(", ltn=").append(this.ltn).append(", extent=").append(this.extent).append(", direction=").append(this.direction).append(", offset=").append(this.offset).append(", hzd=").append(this.hzd).append("}").toString();
    }
}

