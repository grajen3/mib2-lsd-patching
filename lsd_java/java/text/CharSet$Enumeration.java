/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import java.text.CharSet;
import java.util.Enumeration;

class CharSet$Enumeration
implements Enumeration {
    int p;
    String chars;
    final /* synthetic */ CharSet this$0;

    CharSet$Enumeration(CharSet charSet, CharSet charSet2) {
        this.this$0 = charSet;
        this.chars = CharSet.access$0(charSet2);
        this.p = 0;
    }

    @Override
    public boolean hasMoreElements() {
        return this.p < this.chars.length();
    }

    @Override
    public Object nextElement() {
        char[] cArray = new char[]{this.chars.charAt(this.p), this.chars.charAt(this.p + 1)};
        this.p += 2;
        return cArray;
    }
}

