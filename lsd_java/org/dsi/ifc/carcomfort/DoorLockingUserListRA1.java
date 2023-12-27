/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

public class DoorLockingUserListRA1 {
    public int pos;
    public int type;
    public String name;

    public DoorLockingUserListRA1() {
        this.pos = 0;
        this.type = 0;
        this.name = null;
    }

    public DoorLockingUserListRA1(int n, int n2, String string) {
        this.pos = n;
        this.type = n2;
        this.name = string;
    }

    public int getPos() {
        return this.pos;
    }

    public int getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DoorLockingUserListRA1");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

