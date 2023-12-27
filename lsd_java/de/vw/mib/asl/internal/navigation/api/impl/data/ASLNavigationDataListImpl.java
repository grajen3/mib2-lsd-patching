/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.data;

import de.vw.mib.asl.api.navigation.data.ASLNavigationDataList;
import de.vw.mib.asl.internal.navigation.api.impl.data.ASLNavigationDataContainerImpl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ASLNavigationDataListImpl
extends ASLNavigationDataContainerImpl
implements ASLNavigationDataList {
    private final Vector data = new Vector();

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    public void setItem(int n, Object object) {
        this.data.set(n, object);
    }

    @Override
    public Object get(int n) {
        return this.data.get(n);
    }

    @Override
    public boolean add(Object object) {
        return this.data.add(object);
    }

    public String toString() {
        return this.data.toString();
    }

    @Override
    public void add(int n, Object object) {
        this.data.add(n, object);
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        return this.data.addAll(n, collection);
    }

    @Override
    public boolean addAll(Collection collection) {
        return this.data.addAll(collection);
    }

    @Override
    public boolean contains(Object object) {
        return this.data.contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.data.containsAll(collection);
    }

    @Override
    public int indexOf(Object object) {
        return this.data.indexOf(object);
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return this.data.iterator();
    }

    @Override
    public int lastIndexOf(Object object) {
        return this.data.lastIndexOf(object);
    }

    @Override
    public Object remove(int n) {
        return this.data.remove(n);
    }

    @Override
    public boolean remove(Object object) {
        return this.data.remove(object);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.data.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.data.retainAll(collection);
    }

    @Override
    public Object set(int n, Object object) {
        return this.data.set(n, object);
    }

    @Override
    public ListIterator listIterator() {
        return this.data.listIterator();
    }

    @Override
    public ListIterator listIterator(int n) {
        return this.data.listIterator(n);
    }

    @Override
    public List subList(int n, int n2) {
        return this.data.subList(n, n2);
    }

    @Override
    public Object[] toArray() {
        return this.data.toArray();
    }

    @Override
    public Object[] toArray(Object[] objectArray) {
        return this.data.toArray(objectArray);
    }

    @Override
    public int getInt(int n) {
        Object object = this.get(n);
        if (object instanceof Number) {
            return ((Number)object).intValue();
        }
        return 0;
    }

    @Override
    public void setInt(int n, int n2) {
        this.set(n, new Integer(n2));
    }

    @Override
    public void addInt(int n, int n2) {
        this.add(n, new Integer(n2));
    }

    @Override
    public void addInt(int n) {
        this.add(new Integer(n));
    }

    @Override
    public void addBoolean(boolean bl) {
        this.add(bl);
    }

    @Override
    public void addBoolean(int n, boolean bl) {
        this.add(n, bl);
    }

    @Override
    public boolean getBoolean(int n) {
        Object object = this.data.get(n);
        if (object == null) {
            return false;
        }
        if (object instanceof Boolean) {
            return (Boolean)object;
        }
        if (object instanceof String) {
            return Boolean.getBoolean((String)object);
        }
        if (object instanceof Number) {
            return ((Number)object).longValue() != 0L;
        }
        return false;
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.set(n, bl);
    }

    @Override
    public void addString(int n, String string) {
        this.add(n, string);
    }

    @Override
    public void addString(String string) {
        this.add(string);
    }

    @Override
    public String getString(int n) {
        Object object = this.data.get(n);
        if (object instanceof String) {
            return (String)object;
        }
        return "";
    }

    @Override
    public void setString(int n, String string) {
        this.set(n, string);
    }
}

