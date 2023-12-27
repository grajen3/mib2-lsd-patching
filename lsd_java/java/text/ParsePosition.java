/*
 * Decompiled with CFR 0.152.
 */
package java.text;

public class ParsePosition {
    private int currentPosition;
    private int errorIndex = -1;

    public ParsePosition(int n) {
        this.currentPosition = n;
    }

    public boolean equals(Object object) {
        if (!(object instanceof ParsePosition)) {
            return false;
        }
        ParsePosition parsePosition = (ParsePosition)object;
        return this.currentPosition == parsePosition.currentPosition && this.errorIndex == parsePosition.errorIndex;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public int getIndex() {
        return this.currentPosition;
    }

    public int hashCode() {
        return this.currentPosition + this.errorIndex;
    }

    public void setErrorIndex(int n) {
        this.errorIndex = n;
    }

    public void setIndex(int n) {
        this.currentPosition = n;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[index=").append(this.currentPosition).append(", errorIndex=").append(this.errorIndex).append("]").toString();
    }
}

