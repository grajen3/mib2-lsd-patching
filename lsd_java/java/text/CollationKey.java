/*
 * Decompiled with CFR 0.152.
 */
package java.text;

public final class CollationKey
implements Comparable {
    private String string;
    private String key;

    CollationKey(String string, String string2) {
        this.string = string;
        this.key = string2;
    }

    public int compareTo(CollationKey collationKey) {
        return this.key.compareTo(collationKey.key);
    }

    @Override
    public int compareTo(Object object) {
        return this.key.compareTo(((CollationKey)object).key);
    }

    public boolean equals(Object object) {
        if (!(object instanceof CollationKey)) {
            return false;
        }
        CollationKey collationKey = (CollationKey)object;
        return this.key.equals(collationKey.key);
    }

    public String getSourceString() {
        return this.string;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public byte[] toByteArray() {
        int n = this.key.length();
        byte[] byArray = new byte[n * 2];
        int n2 = 0;
        while (n2 < n) {
            char c2 = this.key.charAt(n2);
            byArray[n2 * 2] = (byte)(c2 >> 8);
            byArray[n2 * 2 + 1] = (byte)(c2 & 0xFF);
            ++n2;
        }
        return byArray;
    }
}

