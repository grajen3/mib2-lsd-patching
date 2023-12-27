/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map$Entry;

public class Header
implements Cloneable {
    private static final int incCapacity;
    private ArrayList props = new ArrayList(20);
    private HashMap keyTable = new HashMap(20);
    private String statusLine;

    public Object clone() {
        try {
            Header header = (Header)super.clone();
            header.props = (ArrayList)this.props.clone();
            HashMap hashMap = header.keyTable = new HashMap(20);
            Iterator iterator = this.keyTable.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                hashMap.put(map$Entry.getKey(), ((LinkedList)map$Entry.getValue()).clone());
            }
            return header;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public void add(String string, String string2) {
        if (string == null) {
            throw new NullPointerException();
        }
        LinkedList linkedList = (LinkedList)this.keyTable.get(string);
        if (linkedList == null) {
            linkedList = new LinkedList();
            this.keyTable.put(string.toLowerCase(), linkedList);
        }
        linkedList.add(string2);
        this.props.add(string);
        this.props.add(string2);
    }

    public void set(String string, String string2) {
        if (string == null) {
            throw new NullPointerException();
        }
        LinkedList linkedList = (LinkedList)this.keyTable.get(string);
        if (linkedList == null) {
            this.add(string, string2);
        } else {
            linkedList.clear();
            linkedList.add(string2);
            int n = 0;
            while (n < this.props.size()) {
                String string3 = (String)this.props.get(n);
                if (string3 != null && string.equals(string3)) {
                    this.props.set(n + 1, string2);
                }
                n += 2;
            }
        }
    }

    public Map getFieldMap() {
        HashMap hashMap = new HashMap(this.keyTable.size());
        Iterator iterator = this.keyTable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            hashMap.put(map$Entry.getKey(), Collections.unmodifiableList((LinkedList)map$Entry.getValue()));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String get(int n) {
        if (n >= 0 && n < this.props.size() / 2) {
            return (String)this.props.get(n * 2 + 1);
        }
        return null;
    }

    public String getKey(int n) {
        if (n >= 0 && n < this.props.size() / 2) {
            return (String)this.props.get(n * 2);
        }
        return null;
    }

    public String get(String string) {
        LinkedList linkedList = (LinkedList)this.keyTable.get(string.toLowerCase());
        if (linkedList == null) {
            return null;
        }
        return (String)linkedList.getLast();
    }

    public int length() {
        return this.props.size() / 2;
    }

    public void setStatusLine(String string) {
        this.statusLine = string;
        this.props.add(0, null);
        this.props.add(1, string);
    }

    public String getStatusLine() {
        return this.statusLine;
    }
}

