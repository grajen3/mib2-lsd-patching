/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Date
implements Serializable,
Cloneable,
Comparable {
    private static final long serialVersionUID;
    private transient long milliseconds;

    public Date() {
        this(System.currentTimeMillis());
    }

    public Date(long l) {
        this.setTime(l);
    }

    public boolean after(Date date) {
        return this.milliseconds > date.milliseconds;
    }

    public boolean before(Date date) {
        return this.milliseconds < date.milliseconds;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public int compareTo(Object object) {
        return this.compareTo((Date)object);
    }

    public int compareTo(Date date) {
        if (this.milliseconds < date.milliseconds) {
            return -1;
        }
        if (this.milliseconds == date.milliseconds) {
            return 0;
        }
        return 1;
    }

    public boolean equals(Object object) {
        return object == this || object instanceof Date && this.milliseconds == ((Date)object).milliseconds;
    }

    public long getTime() {
        return this.milliseconds;
    }

    public int hashCode() {
        return (int)(this.milliseconds >>> 32) ^ (int)this.milliseconds;
    }

    public void setTime(long l) {
        this.milliseconds = l;
    }

    public String toString() {
        return new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US).format(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.getTime());
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.setTime(objectInputStream.readLong());
    }
}

