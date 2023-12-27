/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.Format$Field;

public class FieldPosition {
    private int myField;
    private int beginIndex;
    private int endIndex;
    private Format$Field myAttribute;

    public FieldPosition(int n) {
        this.myField = n;
    }

    public FieldPosition(Format$Field format$Field) {
        this.myAttribute = format$Field;
        this.myField = -1;
    }

    public FieldPosition(Format$Field format$Field, int n) {
        this.myAttribute = format$Field;
        this.myField = n;
    }

    void clear() {
        this.endIndex = 0;
        this.beginIndex = 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof FieldPosition)) {
            return false;
        }
        FieldPosition fieldPosition = (FieldPosition)object;
        return this.myField == fieldPosition.myField && this.myAttribute == fieldPosition.myAttribute && this.beginIndex == fieldPosition.beginIndex && this.endIndex == fieldPosition.endIndex;
    }

    public int getBeginIndex() {
        return this.beginIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getField() {
        return this.myField;
    }

    public Format$Field getFieldAttribute() {
        return this.myAttribute;
    }

    public int hashCode() {
        int n = this.myAttribute == null ? 0 : this.myAttribute.hashCode();
        return n + this.myField * 10 + this.beginIndex * 100 + this.endIndex;
    }

    public void setBeginIndex(int n) {
        this.beginIndex = n;
    }

    public void setEndIndex(int n) {
        this.endIndex = n;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[attribute=").append(this.myAttribute).append(", field=").append(this.myField).append(", beginIndex=").append(this.beginIndex).append(", endIndex=").append(this.endIndex).append("]").toString();
    }
}

