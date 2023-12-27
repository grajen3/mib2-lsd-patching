/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconContent {
    public int zone1;
    public int zone2;
    public int zone3;
    public int zone4;
    public int zone5;
    public int zone6;
    public int master;

    public AirconContent() {
        this.zone1 = 0;
        this.zone2 = 0;
        this.zone3 = 0;
        this.zone4 = 0;
        this.zone5 = 0;
        this.zone6 = 0;
        this.master = 0;
    }

    public AirconContent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.zone1 = n;
        this.zone2 = n2;
        this.zone3 = n3;
        this.zone4 = n4;
        this.zone5 = n5;
        this.zone6 = n6;
        this.master = n7;
    }

    public int getZone1() {
        return this.zone1;
    }

    public int getZone2() {
        return this.zone2;
    }

    public int getZone3() {
        return this.zone3;
    }

    public int getZone4() {
        return this.zone4;
    }

    public int getZone5() {
        return this.zone5;
    }

    public int getZone6() {
        return this.zone6;
    }

    public int getMaster() {
        return this.master;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("AirconContent");
        stringBuffer.append('(');
        stringBuffer.append("zone1");
        stringBuffer.append('=');
        stringBuffer.append(this.zone1);
        stringBuffer.append(',');
        stringBuffer.append("zone2");
        stringBuffer.append('=');
        stringBuffer.append(this.zone2);
        stringBuffer.append(',');
        stringBuffer.append("zone3");
        stringBuffer.append('=');
        stringBuffer.append(this.zone3);
        stringBuffer.append(',');
        stringBuffer.append("zone4");
        stringBuffer.append('=');
        stringBuffer.append(this.zone4);
        stringBuffer.append(',');
        stringBuffer.append("zone5");
        stringBuffer.append('=');
        stringBuffer.append(this.zone5);
        stringBuffer.append(',');
        stringBuffer.append("zone6");
        stringBuffer.append('=');
        stringBuffer.append(this.zone6);
        stringBuffer.append(',');
        stringBuffer.append("master");
        stringBuffer.append('=');
        stringBuffer.append(this.master);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

