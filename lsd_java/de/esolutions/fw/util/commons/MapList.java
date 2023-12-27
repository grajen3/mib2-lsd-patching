/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {
    private Map map = new HashMap();

    public boolean contains(Object object, Object object2) {
        List list = (List)this.map.get(object);
        return list != null && list.contains(object2);
    }

    public void add(Object object, Object object2) {
        List list = (List)this.map.get(object);
        if (list == null) {
            list = new ArrayList(10);
            this.map.put(object, list);
        }
        list.add(object2);
    }

    public List get(Object object) {
        return (List)this.map.get(object);
    }

    public void remove(Object object, Object object2) {
        List list = (List)this.map.get(object);
        if (list == null) {
            return;
        }
        list.remove(object2);
        if (list.isEmpty()) {
            this.map.remove(object);
        }
    }

    public void removeAll(Object object) {
        this.map.remove(object);
    }
}

