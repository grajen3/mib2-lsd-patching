/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemList {
    private String sp = ",";
    List items = new ArrayList();

    public ItemList() {
    }

    public ItemList(String string) {
        this.split(string, this.sp, this.items);
    }

    public ItemList(String string, String string2) {
        this.sp = string;
        this.split(string, string2, this.items);
    }

    public ItemList(String string, String string2, boolean bl) {
        this.split(string, string2, this.items, bl);
    }

    public List getItems() {
        return this.items;
    }

    public String[] getArray() {
        return (String[])this.items.toArray();
    }

    public void split(String string, String string2, List list, boolean bl) {
        if (string == null || string2 == null) {
            return;
        }
        if (bl) {
            StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
            while (stringTokenizer.hasMoreTokens()) {
                list.add(stringTokenizer.nextToken().trim());
            }
        } else {
            this.split(string, string2, list);
        }
    }

    public void split(String string, String string2, List list) {
        if (string == null || string2 == null) {
            return;
        }
        int n = 0;
        int n2 = 0;
        do {
            n2 = n;
            if ((n = string.indexOf(string2, n)) == -1) break;
            list.add(string.substring(n2, n).trim());
        } while ((n += string2.length()) != -1);
        list.add(string.substring(n2).trim());
    }

    public void setSP(String string) {
        this.sp = string;
    }

    public void add(int n, String string) {
        if (string == null) {
            return;
        }
        this.items.add(n, string.trim());
    }

    public void add(String string) {
        if (string == null) {
            return;
        }
        this.items.add(string.trim());
    }

    public void addAll(ItemList itemList) {
        this.items.addAll(itemList.items);
    }

    public void addAll(String string) {
        this.split(string, this.sp, this.items);
    }

    public void addAll(String string, String string2) {
        this.split(string, string2, this.items);
    }

    public void addAll(String string, String string2, boolean bl) {
        this.split(string, string2, this.items, bl);
    }

    public String get(int n) {
        return (String)this.items.get(n);
    }

    public int size() {
        return this.items.size();
    }

    public String toString() {
        return this.toString(this.sp);
    }

    public String toString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.items.size(); ++i2) {
            if (i2 == 0) {
                stringBuffer.append(this.items.get(i2));
                continue;
            }
            stringBuffer.append(string);
            stringBuffer.append(this.items.get(i2));
        }
        return stringBuffer.toString();
    }

    public void clear() {
        this.items.clear();
    }

    public void reset() {
        this.sp = ",";
        this.items.clear();
    }
}

