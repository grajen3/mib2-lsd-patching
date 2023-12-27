/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.app.appadapter;

import de.vw.mib.app.appadapter.CellValueConstants;

public class CellValue {
    private Object NULL = new Object();
    private byte type = 0;
    private long number;
    private Object object = this.NULL;

    public byte getType() {
        return this.type;
    }

    public CellValue withDefaultBoolean(boolean bl) {
        return this.setDefaultObject((byte)1, bl);
    }

    public CellValue setBoolean(boolean bl) {
        return this.setObject((byte)1, bl);
    }

    public boolean asBoolean() {
        return this.getObject((byte)1) == Boolean.TRUE;
    }

    public CellValue withDefaultInt(int n) {
        return this.setDefaultNumber((byte)5, n);
    }

    public CellValue setInt(int n) {
        return this.setNumber((byte)5, n);
    }

    public int asInt() {
        return (int)this.getNumber((byte)5);
    }

    public CellValue withDefaultLong(long l) {
        return this.setDefaultNumber((byte)6, l);
    }

    public CellValue setLong(long l) {
        return this.setNumber((byte)6, l);
    }

    public long asLong() {
        return this.getNumber((byte)6);
    }

    public CellValue withDefaultFloat(float f2) {
        return this.setDefaultNumber((byte)7, Float.floatToRawIntBits(f2));
    }

    public CellValue setFloat(float f2) {
        return this.setNumber((byte)7, Float.floatToRawIntBits(f2));
    }

    public float asFloat() {
        return Float.intBitsToFloat((int)this.getNumber((byte)7));
    }

    public CellValue withDefaultDouble(double d2) {
        return this.setDefaultNumber((byte)8, Double.doubleToRawLongBits((double)d2));
    }

    public CellValue setDouble(double d2) {
        return this.setNumber((byte)8, Double.doubleToRawLongBits((double)d2));
    }

    public double asDouble() {
        return Double.longBitsToDouble((long)this.getNumber((byte)8));
    }

    public CellValue withDefaultString(String string) {
        return this.setDefaultObject((byte)9, string);
    }

    public CellValue setString(String string) {
        return this.setObject((byte)9, string);
    }

    public String asString() {
        return (String)this.getObject((byte)9);
    }

    public CellValue withDefaultObject(Object object) {
        return this.setDefaultObject((byte)10, object);
    }

    public CellValue setObject(Object object) {
        return this.setObject((byte)10, object);
    }

    public Object asObject() {
        return this.getObject((byte)10);
    }

    private CellValue setDefaultNumber(byte by, long l) {
        this.type = by;
        this.number = l;
        this.object = null;
        return this;
    }

    private CellValue setNumber(byte by, long l) {
        if (this.type != by) {
            throw new IllegalStateException(new StringBuffer().append("CellValue accept ").append(CellValue.simpleNameOf(this.type)).append(" but setter was called for ").append(CellValue.simpleNameOf(by)).append(".").toString());
        }
        this.number = l;
        this.object = null;
        return this;
    }

    private long getNumber(byte by) {
        if (this.type != by) {
            throw new IllegalStateException(new StringBuffer().append("CellValue contains ").append(CellValue.simpleNameOf(this.type)).append(" but getter was called for ").append(CellValue.simpleNameOf(by)).append(".").toString());
        }
        return this.number;
    }

    private CellValue setDefaultObject(byte by, Object object) {
        this.type = by;
        this.object = object;
        return this;
    }

    private CellValue setObject(byte by, Object object) {
        if (this.type != by) {
            throw new IllegalStateException(new StringBuffer().append("CellValue accept ").append(CellValue.simpleNameOf(this.type)).append(" but setter was called for ").append(CellValue.simpleNameOf(by)).append(".").toString());
        }
        this.object = object;
        return this;
    }

    private Object getObject(byte by) {
        if (this.type != by) {
            throw new IllegalStateException(new StringBuffer().append("CellValue contains ").append(CellValue.simpleNameOf(this.type)).append(" but getter was called for ").append(CellValue.simpleNameOf(by)).append(".").toString());
        }
        return this.object;
    }

    static String simpleNameOf(byte by) {
        return CellValueConstants.TYPE_NAMES[by];
    }
}

