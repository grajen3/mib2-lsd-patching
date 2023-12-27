/*
 * Decompiled with CFR 0.152.
 */
package java.text;

public class Annotation {
    private Object value;

    public Annotation(Object object) {
        this.value = object;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[value=").append(this.value).append(']').toString();
    }
}

