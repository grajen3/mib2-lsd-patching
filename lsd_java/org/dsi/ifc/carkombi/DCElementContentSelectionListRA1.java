/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCElementContentSelectionListRA1 {
    public int pos;
    public int display;
    public int additionalInfo;
    public int element;
    public int elementContent;

    public DCElementContentSelectionListRA1() {
        this.pos = 0;
        this.display = 0;
        this.additionalInfo = 0;
        this.element = 0;
        this.elementContent = 0;
    }

    public DCElementContentSelectionListRA1(int n, int n2, int n3, int n4, int n5) {
        this.pos = n;
        this.display = n2;
        this.additionalInfo = n3;
        this.element = n4;
        this.elementContent = n5;
    }

    public int getPos() {
        return this.pos;
    }

    public int getDisplay() {
        return this.display;
    }

    public int getAdditionalInfo() {
        return this.additionalInfo;
    }

    public int getElement() {
        return this.element;
    }

    public int getElementContent() {
        return this.elementContent;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("DCElementContentSelectionListRA1");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("display");
        stringBuffer.append('=');
        stringBuffer.append(this.display);
        stringBuffer.append(',');
        stringBuffer.append("additionalInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo);
        stringBuffer.append(',');
        stringBuffer.append("element");
        stringBuffer.append('=');
        stringBuffer.append(this.element);
        stringBuffer.append(',');
        stringBuffer.append("elementContent");
        stringBuffer.append('=');
        stringBuffer.append(this.elementContent);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

