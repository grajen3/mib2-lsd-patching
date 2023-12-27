/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.Collections$CheckedMap;
import java.io.Serializable;
import java.util.Map$Entry;

class Collections$CheckedMap$EntryView
implements Map$Entry,
Serializable {
    final Map$Entry entry;
    private final /* synthetic */ Collections$CheckedMap this$0;

    Collections$CheckedMap$EntryView(Collections$CheckedMap collections$CheckedMap, Map$Entry map$Entry) {
        this.this$0 = collections$CheckedMap;
        this.entry = map$Entry;
    }

    @Override
    public Object getKey() {
        return this.entry.getKey();
    }

    @Override
    public Object getValue() {
        return this.entry.getValue();
    }

    @Override
    public int hashCode() {
        return ((Object)this.entry).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        return Collections.access$100(this.getKey(), map$Entry.getKey()) && Collections.access$100(this.getValue(), map$Entry.getValue());
    }

    @Override
    public Object setValue(Object object) {
        Collections$CheckedMap.access$200(this.this$0, object);
        return this.entry.setValue(object);
    }
}

