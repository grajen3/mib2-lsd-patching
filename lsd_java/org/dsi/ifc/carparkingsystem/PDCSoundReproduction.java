/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCSoundReproduction {
    public boolean front;
    public boolean rear;
    public boolean right;
    public boolean left;

    public PDCSoundReproduction() {
        this.front = false;
        this.rear = false;
        this.right = false;
        this.left = false;
    }

    public PDCSoundReproduction(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.front = bl;
        this.rear = bl2;
        this.right = bl3;
        this.left = bl4;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isRear() {
        return this.rear;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("PDCSoundReproduction");
        stringBuffer.append('(');
        stringBuffer.append("front");
        stringBuffer.append('=');
        stringBuffer.append(this.front);
        stringBuffer.append(',');
        stringBuffer.append("rear");
        stringBuffer.append('=');
        stringBuffer.append(this.rear);
        stringBuffer.append(',');
        stringBuffer.append("right");
        stringBuffer.append('=');
        stringBuffer.append(this.right);
        stringBuffer.append(',');
        stringBuffer.append("left");
        stringBuffer.append('=');
        stringBuffer.append(this.left);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

