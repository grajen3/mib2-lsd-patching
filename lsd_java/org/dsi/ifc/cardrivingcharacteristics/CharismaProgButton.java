/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class CharismaProgButton {
    public boolean button1;
    public boolean button2;
    public boolean button3;
    public boolean button4;
    public boolean button5;

    public CharismaProgButton() {
        this.button1 = false;
        this.button2 = false;
        this.button3 = false;
        this.button4 = false;
        this.button5 = false;
    }

    public CharismaProgButton(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.button1 = bl;
        this.button2 = bl2;
        this.button3 = bl3;
        this.button4 = bl4;
        this.button5 = bl5;
    }

    public boolean isButton1() {
        return this.button1;
    }

    public boolean isButton2() {
        return this.button2;
    }

    public boolean isButton3() {
        return this.button3;
    }

    public boolean isButton4() {
        return this.button4;
    }

    public boolean isButton5() {
        return this.button5;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("CharismaProgButton");
        stringBuffer.append('(');
        stringBuffer.append("button1");
        stringBuffer.append('=');
        stringBuffer.append(this.button1);
        stringBuffer.append(',');
        stringBuffer.append("button2");
        stringBuffer.append('=');
        stringBuffer.append(this.button2);
        stringBuffer.append(',');
        stringBuffer.append("button3");
        stringBuffer.append('=');
        stringBuffer.append(this.button3);
        stringBuffer.append(',');
        stringBuffer.append("button4");
        stringBuffer.append('=');
        stringBuffer.append(this.button4);
        stringBuffer.append(',');
        stringBuffer.append("button5");
        stringBuffer.append('=');
        stringBuffer.append(this.button5);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

