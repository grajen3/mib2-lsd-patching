/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.text.CompactIntArray;
import com.ibm.oti.text.IntHashtable;
import java.text.EntryPair;
import java.text.RBCollationTables$BuildAPI;
import java.text.RBTableBuilder;
import java.util.Vector;

final class RBCollationTables {
    static final int EXPANDCHARINDEX;
    static final int CONTRACTCHARINDEX;
    static final int UNMAPPED;
    static final int PRIMARYORDERMASK;
    static final int SECONDARYORDERMASK;
    static final int TERTIARYORDERMASK;
    static final int PRIMARYDIFFERENCEONLY;
    static final int SECONDARYDIFFERENCEONLY;
    static final int PRIMARYORDERSHIFT;
    static final int SECONDARYORDERSHIFT;
    private String rules = null;
    private boolean frenchSec = false;
    private boolean seAsianSwapping = false;
    private CompactIntArray mapping = null;
    private Vector contractTable = null;
    private Vector expandTable = null;
    private IntHashtable contractFlags = null;
    private short maxSecOrder = 0;
    private short maxTerOrder = 0;

    public RBCollationTables(String string, int n) {
        this.rules = string;
        RBTableBuilder rBTableBuilder = new RBTableBuilder(new RBCollationTables$BuildAPI(this, null));
        rBTableBuilder.build(string, n);
    }

    public String getRules() {
        return this.rules;
    }

    public boolean isFrenchSec() {
        return this.frenchSec;
    }

    public boolean isSEAsianSwapping() {
        return this.seAsianSwapping;
    }

    Vector getContractValues(char c2) {
        int n = this.mapping.elementAt(c2);
        return this.getContractValues(n - 127);
    }

    Vector getContractValues(int n) {
        if (n >= 0) {
            return (Vector)this.contractTable.elementAt(n);
        }
        return null;
    }

    boolean usedInContractSeq(char c2) {
        return this.contractFlags.get(c2) == 1;
    }

    int getMaxExpansion(int n) {
        int n2 = 1;
        if (this.expandTable != null) {
            int n3 = 0;
            while (n3 < this.expandTable.size()) {
                int[] nArray = (int[])this.expandTable.elementAt(n3);
                int n4 = nArray.length;
                if (n4 > n2 && nArray[n4 - 1] == n) {
                    n2 = n4;
                }
                ++n3;
            }
        }
        return n2;
    }

    final int[] getExpandValueList(int n) {
        return (int[])this.expandTable.elementAt(n - 126);
    }

    int getUnicodeOrder(char c2) {
        return this.mapping.elementAt(c2);
    }

    short getMaxSecOrder() {
        return this.maxSecOrder;
    }

    short getMaxTerOrder() {
        return this.maxTerOrder;
    }

    static void reverse(StringBuffer stringBuffer, int n, int n2) {
        int n3 = n;
        int n4 = n2 - 1;
        while (n3 < n4) {
            char c2 = stringBuffer.charAt(n3);
            stringBuffer.setCharAt(n3, stringBuffer.charAt(n4));
            stringBuffer.setCharAt(n4, c2);
            ++n3;
            --n4;
        }
    }

    static final int getEntry(Vector vector, String string, boolean bl) {
        int n = 0;
        while (n < vector.size()) {
            EntryPair entryPair = (EntryPair)vector.elementAt(n);
            if (entryPair.fwd == bl && entryPair.entryName.equals(string)) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    static /* synthetic */ void access$0(RBCollationTables rBCollationTables, boolean bl) {
        rBCollationTables.frenchSec = bl;
    }

    static /* synthetic */ void access$1(RBCollationTables rBCollationTables, boolean bl) {
        rBCollationTables.seAsianSwapping = bl;
    }

    static /* synthetic */ void access$2(RBCollationTables rBCollationTables, CompactIntArray compactIntArray) {
        rBCollationTables.mapping = compactIntArray;
    }

    static /* synthetic */ void access$3(RBCollationTables rBCollationTables, Vector vector) {
        rBCollationTables.contractTable = vector;
    }

    static /* synthetic */ void access$4(RBCollationTables rBCollationTables, Vector vector) {
        rBCollationTables.expandTable = vector;
    }

    static /* synthetic */ void access$5(RBCollationTables rBCollationTables, IntHashtable intHashtable) {
        rBCollationTables.contractFlags = intHashtable;
    }

    static /* synthetic */ void access$6(RBCollationTables rBCollationTables, short s) {
        rBCollationTables.maxSecOrder = s;
    }

    static /* synthetic */ void access$7(RBCollationTables rBCollationTables, short s) {
        rBCollationTables.maxTerOrder = s;
    }
}

