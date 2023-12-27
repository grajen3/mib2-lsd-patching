/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.browser;

public class SelectionEntry {
    public int entryIdentifier;
    public String text;
    public String value;
    public boolean selected;

    public SelectionEntry() {
        this.entryIdentifier = 0;
        this.text = null;
        this.value = null;
        this.selected = false;
    }

    public SelectionEntry(int n, String string, String string2, boolean bl) {
        this.entryIdentifier = n;
        this.text = string;
        this.value = string2;
        this.selected = bl;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String string) {
        this.value = string;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public int getEntryIdentifier() {
        return this.entryIdentifier;
    }

    public void setEntryIdentifier(int n) {
        this.entryIdentifier = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("SelectionEntry");
        stringBuffer.append('(');
        stringBuffer.append("entryIdentifier");
        stringBuffer.append('=');
        stringBuffer.append(this.entryIdentifier);
        stringBuffer.append(',');
        stringBuffer.append("text");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.text);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("value");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.value);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("selected");
        stringBuffer.append('=');
        stringBuffer.append(this.selected);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

