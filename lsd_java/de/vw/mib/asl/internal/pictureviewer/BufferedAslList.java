/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.list.impl.GenericASLList;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Arrays;

public final class BufferedAslList {
    private final GenericASLList genericASLList;
    private final ArrayList list;
    private static final Object INVALID = new Object();

    public BufferedAslList(int n) {
        this.genericASLList = ListManager.getGenericASLList(n);
        this.list = new ArrayList(Arrays.asList(this.genericASLList.getDSIObjects()));
    }

    public int getSize() {
        return this.list.size();
    }

    public void setSize(int n) {
        this.genericASLList.setSize(n);
        if (n == 0) {
            this.list.clear();
        }
        while (this.list.size() > n) {
            this.list.remove(this.list.size() - 1);
        }
        while (this.list.size() < n) {
            this.list.add(INVALID);
        }
    }

    public void updateListItems(int n, Object[] objectArray) {
        this.genericASLList.updateListItems(n, objectArray);
        int n2 = n;
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (n2 < this.list.size()) {
                this.list.set(n2, objectArray[i2]);
            } else {
                this.list.add(objectArray[i2]);
            }
            ++n2;
        }
    }

    public int getItemCount() {
        return this.list.size();
    }

    public Object getRowItemCacheOnly(int n) {
        return this.list.get(n);
    }

    public boolean isValidItem(Object object) {
        return object != INVALID && this.genericASLList.isValidItem(object);
    }

    public Object getRowItem(int n) {
        if (this.list.get(n) == INVALID) {
            this.list.set(n, this.genericASLList.getRowItem(n));
        }
        return this.list.get(n);
    }
}

