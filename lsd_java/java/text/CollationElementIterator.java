/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.Normalizer;
import com.ibm.oti.text.Normalizer$Mode;
import java.text.CharacterIterator;
import java.text.EntryPair;
import java.text.RBCollationTables;
import java.text.RuleBasedCollator;
import java.util.Vector;

public final class CollationElementIterator {
    public static final int NULLORDER;
    static final int UNMAPPEDCHARVALUE;
    private Normalizer text = null;
    private int[] buffer = null;
    private int[] ownBuffer = new int[2];
    private int expIndex = 0;
    private StringBuffer key = new StringBuffer(5);
    private int swapOrder = 0;
    private RBCollationTables ordering;
    private RuleBasedCollator owner;

    CollationElementIterator(String string, RuleBasedCollator ruleBasedCollator) {
        this.owner = ruleBasedCollator;
        this.ordering = ruleBasedCollator.getTables();
        if (string.length() != 0) {
            Normalizer$Mode normalizer$Mode = Normalizer.getMode(ruleBasedCollator.getDecomposition());
            this.text = new Normalizer(string, normalizer$Mode);
        }
    }

    CollationElementIterator(CharacterIterator characterIterator, RuleBasedCollator ruleBasedCollator) {
        this.owner = ruleBasedCollator;
        this.ordering = ruleBasedCollator.getTables();
        Normalizer$Mode normalizer$Mode = Normalizer.getMode(ruleBasedCollator.getDecomposition());
        this.text = new Normalizer(characterIterator, normalizer$Mode);
    }

    public void reset() {
        if (this.text != null) {
            this.text.reset();
            Normalizer$Mode normalizer$Mode = Normalizer.getMode(this.owner.getDecomposition());
            this.text.setMode(normalizer$Mode);
        }
        this.buffer = null;
        this.expIndex = 0;
    }

    public int next() {
        char c2;
        Normalizer$Mode normalizer$Mode;
        if (this.text == null) {
            return -1;
        }
        Normalizer$Mode normalizer$Mode2 = this.text.getMode();
        if (normalizer$Mode2 != (normalizer$Mode = Normalizer.getMode(this.owner.getDecomposition()))) {
            this.text.setMode(normalizer$Mode);
        }
        if (this.buffer != null) {
            if (this.expIndex < this.buffer.length) {
                return this.strengthOrder(this.buffer[this.expIndex++]);
            }
            this.buffer = null;
        }
        if ((c2 = this.text.next()) == '\uffff0000') {
            return -1;
        }
        int n = this.ordering.getUnicodeOrder(c2);
        if (n == -1) {
            this.ownBuffer[0] = 65407;
            this.ownBuffer[1] = c2 << 16;
            this.buffer = this.ownBuffer;
        } else if (n >= 127) {
            n = this.nextContractChar(c2);
        }
        if (n >= 126) {
            this.buffer = this.ordering.getExpandValueList(n);
        }
        if (this.ordering.isSEAsianSwapping()) {
            char c3;
            if (CollationElementIterator.isThaiPreVowel(c2)) {
                c3 = this.text.next();
                if (c3 == '\uffff0000') {
                    return -1;
                }
                if (CollationElementIterator.isThaiBaseConsonant(c3)) {
                    this.buffer = this.makeReorderedBuffer(c3, n, this.buffer, true);
                } else {
                    this.text.previous();
                }
            }
            if (CollationElementIterator.isLaoPreVowel(c2)) {
                c3 = this.text.next();
                if (c3 == '\uffff0000') {
                    return -1;
                }
                if (CollationElementIterator.isLaoBaseConsonant(c3)) {
                    this.buffer = this.makeReorderedBuffer(c3, n, this.buffer, true);
                } else {
                    this.text.previous();
                }
            }
        }
        if (this.buffer != null) {
            this.expIndex = 1;
            n = this.buffer[0];
        }
        return this.strengthOrder(n);
    }

    public int previous() {
        char c2;
        Normalizer$Mode normalizer$Mode;
        if (this.text == null) {
            return -1;
        }
        Normalizer$Mode normalizer$Mode2 = this.text.getMode();
        if (normalizer$Mode2 != (normalizer$Mode = Normalizer.getMode(this.owner.getDecomposition()))) {
            this.text.setMode(normalizer$Mode);
        }
        if (this.buffer != null) {
            if (this.expIndex > 0) {
                return this.strengthOrder(this.buffer[--this.expIndex]);
            }
            this.buffer = null;
        }
        if ((c2 = this.text.previous()) == '\uffff0000') {
            return -1;
        }
        int n = this.ordering.getUnicodeOrder(c2);
        if (n == -1) {
            this.ownBuffer[0] = 65407;
            this.ownBuffer[1] = c2 << 16;
            this.buffer = this.ownBuffer;
        } else {
            if (n >= 127) {
                n = this.prevContractChar(c2);
            }
            if (n >= 126) {
                this.buffer = this.ordering.getExpandValueList(n);
            }
            if (this.ordering.isSEAsianSwapping()) {
                char c3 = this.text.previous();
                if (CollationElementIterator.isThaiBaseConsonant(c2)) {
                    if (CollationElementIterator.isThaiPreVowel(c3)) {
                        this.buffer = this.makeReorderedBuffer(c3, n, this.buffer, false);
                    } else {
                        this.text.next();
                    }
                }
                if (CollationElementIterator.isLaoBaseConsonant(c2)) {
                    c3 = this.text.previous();
                    if (CollationElementIterator.isLaoPreVowel(c3)) {
                        this.buffer = this.makeReorderedBuffer(c3, n, this.buffer, false);
                        this.expIndex = this.buffer.length - 1;
                        n = this.buffer[this.expIndex];
                    } else {
                        this.text.next();
                    }
                }
            }
        }
        if (this.buffer != null) {
            this.expIndex = this.buffer.length - 1;
            n = this.buffer[this.expIndex];
        }
        return this.strengthOrder(n);
    }

    public static final int primaryOrder(int n) {
        return (n &= 0xFFFF) >>> 16;
    }

    public static final short secondaryOrder(int n) {
        return (short)((n &= 0xFF0000) >> 8);
    }

    public static final short tertiaryOrder(int n) {
        return (short)(n &= 0xFF);
    }

    final int strengthOrder(int n) {
        int n2 = this.owner.getStrength();
        if (n2 == 0) {
            n &= 0xFFFF;
        } else if (n2 == 1) {
            n &= 0xFFFFFF00;
        }
        return n;
    }

    public void setOffset(int n) {
        if (this.text != null) {
            if (n < this.text.getBeginIndex() || n >= this.text.getEndIndex()) {
                this.text.setIndexOnly(n);
            } else {
                char c2 = this.text.setIndex(n);
                if (this.ordering.usedInContractSeq(c2)) {
                    while (this.ordering.usedInContractSeq(c2)) {
                        c2 = this.text.previous();
                    }
                    int n2 = this.text.getIndex();
                    while (this.text.getIndex() <= n) {
                        n2 = this.text.getIndex();
                        this.next();
                    }
                    this.text.setIndexOnly(n2);
                }
            }
        }
        this.buffer = null;
        this.expIndex = 0;
        this.swapOrder = 0;
    }

    public int getOffset() {
        return this.text != null ? this.text.getIndex() : 0;
    }

    public int getMaxExpansion(int n) {
        return this.ordering.getMaxExpansion(n);
    }

    public void setText(String string) {
        this.buffer = null;
        Normalizer$Mode normalizer$Mode = Normalizer.getMode(this.owner.getDecomposition());
        if (this.text == null) {
            this.text = new Normalizer(string, normalizer$Mode);
        } else {
            this.text.setMode(normalizer$Mode);
            this.text.setText(string);
        }
    }

    public void setText(CharacterIterator characterIterator) {
        this.buffer = null;
        Normalizer$Mode normalizer$Mode = Normalizer.getMode(this.owner.getDecomposition());
        if (this.text == null) {
            this.text = new Normalizer(characterIterator, normalizer$Mode);
        } else {
            this.text.setMode(normalizer$Mode);
            this.text.setText(characterIterator);
        }
    }

    private static final boolean isThaiPreVowel(char c2) {
        return c2 >= '\u0e40' && c2 <= '\u0e44';
    }

    private static final boolean isThaiBaseConsonant(char c2) {
        return c2 >= '\u0e01' && c2 <= '\u0e2e';
    }

    private static final boolean isLaoPreVowel(char c2) {
        return c2 >= '\u0ec0' && c2 <= '\u0ec4';
    }

    private static final boolean isLaoBaseConsonant(char c2) {
        return c2 >= '\u0e81' && c2 <= '\u0eae';
    }

    private int[] makeReorderedBuffer(char c2, int n, int[] nArray, boolean bl) {
        int[] nArray2;
        int n2;
        int n3 = this.ordering.getUnicodeOrder(c2);
        if (n3 >= 127) {
            n3 = bl ? this.nextContractChar(c2) : this.prevContractChar(c2);
        }
        int[] nArray3 = null;
        if (n3 >= 126) {
            nArray3 = this.ordering.getExpandValueList(n3);
        }
        if (!bl) {
            n2 = n3;
            n3 = n;
            n = n2;
            int[] nArray4 = nArray3;
            nArray3 = nArray;
            nArray = nArray4;
        }
        if (nArray3 == null && nArray == null) {
            nArray2 = new int[]{n3, n};
        } else {
            n2 = nArray3 == null ? 1 : nArray3.length;
            int n4 = nArray == null ? 1 : nArray.length;
            nArray2 = new int[n2 + n4];
            if (nArray3 == null) {
                nArray2[0] = n3;
            } else {
                System.arraycopy((Object)nArray3, 0, (Object)nArray2, 0, n2);
            }
            if (nArray == null) {
                nArray2[n2] = n;
            } else {
                System.arraycopy((Object)nArray, 0, (Object)nArray2, n2, n4);
            }
        }
        return nArray2;
    }

    static final boolean isIgnorable(int n) {
        return CollationElementIterator.primaryOrder(n) == 0;
    }

    private int nextContractChar(char c2) {
        Vector vector = this.ordering.getContractValues(c2);
        EntryPair entryPair = (EntryPair)vector.firstElement();
        int n = entryPair.value;
        entryPair = (EntryPair)vector.lastElement();
        int n2 = entryPair.entryName.length();
        Normalizer normalizer = (Normalizer)this.text.clone();
        normalizer.previous();
        this.key.setLength(0);
        char c3 = normalizer.next();
        while (n2 > 0 && c3 != '\uffff0000') {
            this.key.append(c3);
            --n2;
            c3 = normalizer.next();
        }
        String string = this.key.toString();
        n2 = 1;
        int n3 = vector.size() - 1;
        while (n3 > 0) {
            entryPair = (EntryPair)vector.elementAt(n3);
            if (entryPair.fwd && string.startsWith(entryPair.entryName) && entryPair.entryName.length() > n2) {
                n2 = entryPair.entryName.length();
                n = entryPair.value;
            }
            --n3;
        }
        while (n2 > 1) {
            this.text.next();
            --n2;
        }
        return n;
    }

    private int prevContractChar(char c2) {
        Vector vector = this.ordering.getContractValues(c2);
        EntryPair entryPair = (EntryPair)vector.firstElement();
        int n = entryPair.value;
        entryPair = (EntryPair)vector.lastElement();
        int n2 = entryPair.entryName.length();
        Normalizer normalizer = (Normalizer)this.text.clone();
        normalizer.next();
        this.key.setLength(0);
        char c3 = normalizer.previous();
        while (n2 > 0 && c3 != '\uffff0000') {
            this.key.append(c3);
            --n2;
            c3 = normalizer.previous();
        }
        String string = this.key.toString();
        n2 = 1;
        int n3 = vector.size() - 1;
        while (n3 > 0) {
            entryPair = (EntryPair)vector.elementAt(n3);
            if (!entryPair.fwd && string.startsWith(entryPair.entryName) && entryPair.entryName.length() > n2) {
                n2 = entryPair.entryName.length();
                n = entryPair.value;
            }
            --n3;
        }
        while (n2 > 1) {
            this.text.previous();
            --n2;
        }
        return n;
    }
}

