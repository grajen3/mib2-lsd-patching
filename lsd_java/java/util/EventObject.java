/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.Serializable;

public class EventObject
implements Serializable {
    private static final long serialVersionUID;
    protected transient Object source;

    public EventObject(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
        this.source = object;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append("[source=").append(String.valueOf(this.source)).append(']').toString();
    }
}

