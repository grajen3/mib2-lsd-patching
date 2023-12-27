/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.global;

public class NavLocationDescriptor {
    public int selectionCriterion;
    public String data;

    public NavLocationDescriptor() {
        this.selectionCriterion = 0;
        this.data = null;
    }

    public NavLocationDescriptor(int n, String string) {
        this.selectionCriterion = n;
        this.data = string;
    }

    public int getSelectionCriterion() {
        return this.selectionCriterion;
    }

    public String getData() {
        return this.data;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LocationDescriptor {");
        stringBuffer.append("selectionCriterion=");
        stringBuffer.append(this.selectionCriterion);
        stringBuffer.append(", ");
        stringBuffer.append("data=");
        stringBuffer.append(this.data);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

