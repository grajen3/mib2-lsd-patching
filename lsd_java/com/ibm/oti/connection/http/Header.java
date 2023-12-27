/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import java.util.Hashtable;
import java.util.Vector;

public class Header {
    private static final int incCapacity;
    private Vector props = new Vector(5);
    private Hashtable keyTable = new Hashtable(5);
    private boolean duplicates = false;

    public Header(boolean bl) {
        this.duplicates = bl;
    }

    public void add(String string, String string2) {
        if (this.duplicates || this.keyTable.get(string) == null) {
            this.props.addElement(string);
            this.props.addElement(this.duplicates ? string2 : null);
        }
        if (string == null) {
            this.keyTable.put(this, string2);
        } else {
            this.keyTable.put(string.toLowerCase(), string2);
        }
    }

    public String get(int n) {
        if (n >= 0 && n < this.props.size() / 2) {
            return this.duplicates ? (String)this.props.elementAt(n * 2 + 1) : this.get((String)this.props.elementAt(n * 2));
        }
        return null;
    }

    public String get(String string) {
        if (string == null) {
            return (String)this.keyTable.get(this);
        }
        return (String)this.keyTable.get(string.toLowerCase());
    }

    public String getKey(int n) {
        if (n >= 0 && n < this.props.size() / 2) {
            return (String)this.props.elementAt(n * 2);
        }
        return null;
    }

    public int length() {
        return this.props.size() / 2;
    }
}

