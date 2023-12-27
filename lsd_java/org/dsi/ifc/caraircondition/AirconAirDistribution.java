/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconAirDistribution {
    public int up;
    public int body;
    public int footwell;
    public int indirect;
    public boolean automode;
    public boolean autoDemandOriented;
    public int side;

    public AirconAirDistribution() {
        this.up = 0;
        this.body = 0;
        this.footwell = 0;
        this.indirect = 0;
        this.automode = false;
        this.autoDemandOriented = false;
        this.side = 0;
    }

    public AirconAirDistribution(int n, int n2, int n3, int n4, boolean bl, boolean bl2, int n5) {
        this.up = n;
        this.body = n2;
        this.footwell = n3;
        this.indirect = n4;
        this.side = n5;
        this.automode = bl;
        this.autoDemandOriented = bl2;
    }

    public int getUp() {
        return this.up;
    }

    public int getBody() {
        return this.body;
    }

    public int getFootwell() {
        return this.footwell;
    }

    public int getIndirect() {
        return this.indirect;
    }

    public int getSide() {
        return this.side;
    }

    public boolean isAutomode() {
        return this.automode;
    }

    public boolean isAutoDemandOriented() {
        return this.autoDemandOriented;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("AirconAirDistribution");
        stringBuffer.append('(');
        stringBuffer.append("up");
        stringBuffer.append('=');
        stringBuffer.append(this.up);
        stringBuffer.append(',');
        stringBuffer.append("body");
        stringBuffer.append('=');
        stringBuffer.append(this.body);
        stringBuffer.append(',');
        stringBuffer.append("footwell");
        stringBuffer.append('=');
        stringBuffer.append(this.footwell);
        stringBuffer.append(',');
        stringBuffer.append("indirect");
        stringBuffer.append('=');
        stringBuffer.append(this.indirect);
        stringBuffer.append(',');
        stringBuffer.append("automode");
        stringBuffer.append('=');
        stringBuffer.append(this.automode);
        stringBuffer.append(',');
        stringBuffer.append("autoDemandOriented");
        stringBuffer.append('=');
        stringBuffer.append(this.autoDemandOriented);
        stringBuffer.append(',');
        stringBuffer.append("side");
        stringBuffer.append('=');
        stringBuffer.append(this.side);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

