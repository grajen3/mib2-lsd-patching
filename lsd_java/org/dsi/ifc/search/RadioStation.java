/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.search;

public class RadioStation {
    public long id;
    public String data1;
    public String data2;
    public String data3;

    public RadioStation() {
        this.id = -1L;
        this.data1 = null;
        this.data2 = null;
        this.data3 = null;
    }

    public RadioStation(long l, String string, String string2, String string3) {
        this.id = l;
        this.data1 = string;
        this.data2 = string2;
        this.data3 = string3;
    }

    public long getId() {
        return this.id;
    }

    public String getData1() {
        return this.data1;
    }

    public String getData2() {
        return this.data2;
    }

    public String getData3() {
        return this.data3;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("RadioStation");
        stringBuffer.append('(');
        stringBuffer.append("id");
        stringBuffer.append('=');
        stringBuffer.append(this.id);
        stringBuffer.append(',');
        stringBuffer.append("data1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.data1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("data2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.data2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("data3");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.data3);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

