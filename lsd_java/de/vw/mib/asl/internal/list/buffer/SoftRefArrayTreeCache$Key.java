/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

class SoftRefArrayTreeCache$Key {
    int startIndex;

    SoftRefArrayTreeCache$Key() {
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        return object instanceof SoftRefArrayTreeCache$Key && ((SoftRefArrayTreeCache$Key)object).startIndex == this.startIndex;
    }

    public int hashCode() {
        return this.startIndex;
    }
}

