/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class DCElementContentSelectionListRA2 {
    public int pos;
    public int elementContent;

    public DCElementContentSelectionListRA2() {
        this.pos = 0;
        this.elementContent = 0;
    }

    public DCElementContentSelectionListRA2(int n, int n2) {
        this.pos = n;
        this.elementContent = n2;
    }

    public int getPos() {
        return this.pos;
    }

    public int getElementContent() {
        return this.elementContent;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("DCElementContentSelectionListRA2");
        stringBuffer.append('(');
        stringBuffer.append("pos");
        stringBuffer.append('=');
        stringBuffer.append(this.pos);
        stringBuffer.append(',');
        stringBuffer.append("elementContent");
        stringBuffer.append('=');
        stringBuffer.append(this.elementContent);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

