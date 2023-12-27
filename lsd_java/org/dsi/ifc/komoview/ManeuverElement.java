/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komoview;

public class ManeuverElement {
    public int element;
    public short direction;
    public int attribute;

    public ManeuverElement() {
        this.element = 0;
        this.direction = 0;
        this.attribute = 0;
    }

    public ManeuverElement(int n, short s, int n2) {
        this.element = n;
        this.direction = s;
        this.attribute = n2;
    }

    public int getElement() {
        return this.element;
    }

    public short getDirection() {
        return this.direction;
    }

    public int getAttribute() {
        return this.attribute;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("ManeuverElement");
        stringBuffer.append('(');
        stringBuffer.append("element");
        stringBuffer.append('=');
        stringBuffer.append(this.element);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(',');
        stringBuffer.append("attribute");
        stringBuffer.append('=');
        stringBuffer.append(this.attribute);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

