/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

public class BapManeuverDescriptor {
    public int mainElement;
    public int direction;
    public int zLevelGuidance;
    public byte[] sideStreets;

    public BapManeuverDescriptor() {
        this.mainElement = 0;
        this.direction = 0;
        this.zLevelGuidance = 0;
        this.sideStreets = null;
    }

    public BapManeuverDescriptor(int n, int n2, int n3, byte[] byArray) {
        this.mainElement = n;
        this.direction = n2;
        this.zLevelGuidance = n3;
        this.sideStreets = byArray;
    }

    public int getMainElement() {
        return this.mainElement;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getZLevelGuidance() {
        return this.zLevelGuidance;
    }

    public byte[] getSideStreets() {
        return this.sideStreets;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("BapManeuverDescriptor");
        stringBuffer.append('(');
        stringBuffer.append("mainElement");
        stringBuffer.append('=');
        stringBuffer.append(this.mainElement);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(',');
        stringBuffer.append("zLevelGuidance");
        stringBuffer.append('=');
        stringBuffer.append(this.zLevelGuidance);
        stringBuffer.append(',');
        stringBuffer.append("sideStreets");
        stringBuffer.append('[');
        if (this.sideStreets != null) {
            stringBuffer.append(this.sideStreets.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.sideStreets != null) {
            int n = this.sideStreets.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.sideStreets[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.sideStreets);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

