/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.ExtendedResourceBundle$1;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public abstract class ExtendedResourceBundle
extends ResourceBundle {
    private Hashtable table;

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
        return new ExtendedResourceBundle$1(this);
    }

    public final Object getObject(Integer n) {
        ExtendedResourceBundle extendedResourceBundle;
        ExtendedResourceBundle extendedResourceBundle2 = this;
        do {
            Object object;
            if ((object = extendedResourceBundle2.handleGetObject(n)) != null) {
                return object;
            }
            extendedResourceBundle = extendedResourceBundle2;
        } while ((extendedResourceBundle2 = (ExtendedResourceBundle)extendedResourceBundle2.parent) != null);
        throw new MissingResourceException(null, super.getClass().getName(), n.toString());
    }

    @Override
    public Object handleGetObject(String string) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(string);
    }

    public Object handleGetObject(Integer n) {
        if (this.table == null) {
            this.initializeTable();
        }
        return this.table.get(n);
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

    static /* synthetic */ Hashtable access$0(ExtendedResourceBundle extendedResourceBundle) {
        return extendedResourceBundle.table;
    }

    static /* synthetic */ ResourceBundle access$1(ExtendedResourceBundle extendedResourceBundle) {
        return extendedResourceBundle.parent;
    }
}

