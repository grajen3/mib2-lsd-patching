/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class DirectionToWaypoint {
    public short directionRelative;
    public short directionAbsolute;

    public DirectionToWaypoint() {
        this.directionRelative = 0;
        this.directionAbsolute = 0;
    }

    public DirectionToWaypoint(short s, short s2) {
        this.directionRelative = s;
        this.directionAbsolute = s2;
    }

    public short getDirectionRelative() {
        return this.directionRelative;
    }

    public short getDirectionAbsolute() {
        return this.directionAbsolute;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DirectionToWaypoint");
        stringBuffer.append('(');
        stringBuffer.append("directionRelative");
        stringBuffer.append('=');
        stringBuffer.append(this.directionRelative);
        stringBuffer.append(',');
        stringBuffer.append("directionAbsolute");
        stringBuffer.append('=');
        stringBuffer.append(this.directionAbsolute);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

