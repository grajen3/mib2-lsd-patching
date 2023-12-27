/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.config.bcf;

import de.esolutions.fw.util.config.bcf.BCFStringEntry;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class BCFStringPool {
    private List entries = new ArrayList(10);

    BCFStringPool() {
    }

    void addString(String string) {
        this.entries.add(new BCFStringEntry(string));
    }

    int getStringOffset(int n) {
        BCFStringEntry bCFStringEntry = (BCFStringEntry)this.entries.get(n);
        return bCFStringEntry.getOffset();
    }

    byte[] buildTable() {
        Object object;
        int n;
        int n2;
        Object object2;
        int n3 = 0;
        int n4 = this.entries.size();
        BCFStringEntry[] bCFStringEntryArray = new BCFStringEntry[n4];
        ListIterator listIterator = this.entries.listIterator();
        while (listIterator.hasNext()) {
            object2 = (BCFStringEntry)listIterator.next();
            n2 = ((BCFStringEntry)object2).getLength();
            n = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                int n5;
                object = bCFStringEntryArray[i2];
                int n6 = ((BCFStringEntry)object).getLength();
                if (n6 > n2) {
                    n5 = ((BCFStringEntry)object).canMerge((BCFStringEntry)object2);
                    if (n5 < 0) continue;
                    n = 1;
                    ((BCFStringEntry)object2).setMerge((BCFStringEntry)object, n5);
                    continue;
                }
                n5 = ((BCFStringEntry)object2).canMerge((BCFStringEntry)object);
                if (n5 < 0) continue;
                n = 1;
                ((BCFStringEntry)object).setMerge((BCFStringEntry)object2, n5);
                bCFStringEntryArray[i2] = object2;
            }
            if (n != 0) continue;
            bCFStringEntryArray[n3] = object2;
            ++n3;
        }
        object2 = new ArrayList(n3);
        n2 = 0;
        for (n = 0; n < n3; ++n) {
            byte[] byArray = bCFStringEntryArray[n].toBytes();
            bCFStringEntryArray[n].setBaseOffset(n2);
            n2 += 1 + byArray.length;
            ((ArrayList)object2).add(byArray);
        }
        byte[] byArray = new byte[n2];
        int n7 = 0;
        object = ((AbstractList)object2).listIterator();
        while (object.hasNext()) {
            byte[] byArray2 = (byte[])object.next();
            System.arraycopy((Object)byArray2, 0, (Object)byArray, n7, byArray2.length);
            n7 += 1 + byArray2.length;
        }
        return byArray;
    }
}

