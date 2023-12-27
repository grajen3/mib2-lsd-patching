/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.dsi.ifc.base.DSIListener;

public class ListenerMap {
    private Map attribute2listeners = new TreeMap();

    public void add(int n, DSIListener dSIListener) {
        Set set = (Set)this.attribute2listeners.get(new Integer(n));
        if (set == null) {
            set = new HashSet();
            this.attribute2listeners.put(new Integer(n), set);
        }
        if (!set.contains(dSIListener)) {
            set.add(dSIListener);
        }
    }

    public void remove(DSIListener dSIListener) {
        Collection collection = this.attribute2listeners.values();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Set set = (Set)iterator.next();
            set.remove(dSIListener);
        }
    }

    public void remove(int n, DSIListener dSIListener) {
        Set set = (Set)this.attribute2listeners.get(new Integer(n));
        if (set == null) {
            return;
        }
        set.remove(dSIListener);
    }

    public boolean has(int n) {
        boolean bl = false;
        Object object = this.attribute2listeners.get(new Integer(n));
        if (object != null && !((Set)object).isEmpty()) {
            bl = true;
        }
        return bl;
    }

    public Iterator iterate(int n) {
        Set set = (Set)this.attribute2listeners.get(new Integer(n));
        if (set == null) {
            return new HashSet().iterator();
        }
        return new HashSet(set).iterator();
    }

    public void clear() {
        this.attribute2listeners.clear();
    }
}

