/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ListResourceBundle$1;
import java.util.ResourceBundle;

public abstract class ListResourceBundle
extends ResourceBundle {
    Hashtable table;

    protected abstract Object[][] getContents() {
    }

    @Override
    public Enumeration getKeys() {
        if (this.table == null) {
            this.initializeTable();
        }
        if (this.parent == null) {
            return this.table.keys();
        }
        return new ListResourceBundle$1(this);
    }

    @Override
    public final Object handleGetObject(String string) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(string);
    }

    private synchronized void initializeTable() {
        if (this.table == null) {
            Object[][] objectArray = this.getContents();
            this.table = new Hashtable(objectArray.length / 3 * 4 + 3);
            int n = 0;
            while (n < objectArray.length) {
                this.table.put(objectArray[n][0], objectArray[n][1]);
                ++n;
            }
        }
    }
}

