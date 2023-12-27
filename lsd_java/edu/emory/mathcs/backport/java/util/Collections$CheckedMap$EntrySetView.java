/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.AbstractSet;
import edu.emory.mathcs.backport.java.util.Collections;
import edu.emory.mathcs.backport.java.util.Collections$1;
import edu.emory.mathcs.backport.java.util.Collections$CheckedMap;
import edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntryView;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Set;

class Collections$CheckedMap$EntrySetView
extends AbstractSet
implements Set {
    final Set entrySet;
    private final /* synthetic */ Collections$CheckedMap this$0;

    Collections$CheckedMap$EntrySetView(Collections$CheckedMap collections$CheckedMap, Set set) {
        this.this$0 = collections$CheckedMap;
        this.entrySet = set;
    }

    @Override
    public int size() {
        return this.entrySet.size();
    }

    @Override
    public boolean isEmpty() {
        return this.entrySet.isEmpty();
    }

    @Override
    public boolean remove(Object object) {
        return this.entrySet.remove(object);
    }

    @Override
    public void clear() {
        this.entrySet.clear();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        return this.entrySet.contains(new Collections$CheckedMap$EntryView(this.this$0, (Map$Entry)object));
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = this.entrySet.iterator();
        return new Collections$1(this, iterator);
    }

    @Override
    public Object[] toArray() {
        Object[] objectArray = this.entrySet.toArray();
        if (super.getClass().getComponentType().isAssignableFrom(Collections.class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView == null ? (Collections.class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView = Collections.class$("edu.emory.mathcs.backport.java.util.Collections$CheckedMap$EntryView")) : Collections.class$edu$emory$mathcs$backport$java$util$Collections$CheckedMap$EntryView)) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                objectArray[i2] = new Collections$CheckedMap$EntryView(this.this$0, (Map$Entry)objectArray[i2]);
            }
            return objectArray;
        }
        Object[] objectArray2 = new Object[objectArray.length];
        for (int i3 = 0; i3 < objectArray.length; ++i3) {
            objectArray2[i3] = new Collections$CheckedMap$EntryView(this.this$0, (Map$Entry)objectArray[i3]);
        }
        return objectArray2;
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        Object[] objectArray2 = objectArray.length == 0 ? objectArray : (Object[])Array.newInstance(super.getClass().getComponentType(), objectArray.length);
        objectArray2 = this.entrySet.toArray(objectArray2);
        for (int i2 = 0; i2 < objectArray2.length; ++i2) {
            objectArray2[i2] = new Collections$CheckedMap$EntryView(this.this$0, (Map$Entry)objectArray2[i2]);
        }
        if (objectArray2.length > objectArray.length) {
            objectArray = objectArray2;
        } else {
            System.arraycopy((Object)objectArray2, 0, (Object)objectArray, 0, objectArray2.length);
            if (objectArray2.length < objectArray.length) {
                objectArray[objectArray2.length] = null;
            }
        }
        return objectArray;
    }

    static /* synthetic */ Collections$CheckedMap access$000(Collections$CheckedMap$EntrySetView collections$CheckedMap$EntrySetView) {
        return collections$CheckedMap$EntrySetView.this$0;
    }
}

