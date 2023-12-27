/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

public class Character$Subset {
    String name;

    protected Character$Subset(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name = string;
    }

    public final boolean equals(Object object) {
        return super.equals(object);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return this.name;
    }
}

