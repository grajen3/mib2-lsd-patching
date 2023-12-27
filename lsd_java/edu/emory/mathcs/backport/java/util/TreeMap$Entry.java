/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util;

import edu.emory.mathcs.backport.java.util.TreeMap;
import java.io.Serializable;
import java.util.Map$Entry;

public class TreeMap$Entry
implements Map$Entry,
Cloneable,
Serializable {
    private static final boolean RED;
    private static final boolean BLACK;
    private Object key;
    private Object element;
    private boolean color;
    private TreeMap$Entry left;
    private TreeMap$Entry right;
    private TreeMap$Entry parent;

    public TreeMap$Entry(Object object, Object object2) {
        this.key = object;
        this.element = object2;
        this.color = true;
    }

    protected Object clone() {
        TreeMap$Entry treeMap$Entry = new TreeMap$Entry(this.key, this.element);
        treeMap$Entry.color = this.color;
        return treeMap$Entry;
    }

    @Override
    public final Object getKey() {
        return this.key;
    }

    @Override
    public final Object getValue() {
        return this.element;
    }

    @Override
    public final Object setValue(Object object) {
        Object object2 = this.element;
        this.element = object;
        return object2;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Map$Entry)) {
            return false;
        }
        Map$Entry map$Entry = (Map$Entry)object;
        return TreeMap.access$300(this.key, map$Entry.getKey()) && TreeMap.access$300(this.element, map$Entry.getValue());
    }

    @Override
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.element == null ? 0 : this.element.hashCode());
    }

    public String toString() {
        return new StringBuffer().append(this.key).append("=").append(this.element).toString();
    }

    static /* synthetic */ TreeMap$Entry access$000(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.left;
    }

    static /* synthetic */ TreeMap$Entry access$102(TreeMap$Entry treeMap$Entry, TreeMap$Entry treeMap$Entry2) {
        treeMap$Entry.parent = treeMap$Entry2;
        return treeMap$Entry.parent;
    }

    static /* synthetic */ TreeMap$Entry access$002(TreeMap$Entry treeMap$Entry, TreeMap$Entry treeMap$Entry2) {
        treeMap$Entry.left = treeMap$Entry2;
        return treeMap$Entry.left;
    }

    static /* synthetic */ TreeMap$Entry access$200(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.right;
    }

    static /* synthetic */ TreeMap$Entry access$202(TreeMap$Entry treeMap$Entry, TreeMap$Entry treeMap$Entry2) {
        treeMap$Entry.right = treeMap$Entry2;
        return treeMap$Entry.right;
    }

    static /* synthetic */ TreeMap$Entry access$100(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.parent;
    }

    static /* synthetic */ Object access$400(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.key;
    }

    static /* synthetic */ boolean access$502(TreeMap$Entry treeMap$Entry, boolean bl) {
        treeMap$Entry.color = bl;
        return treeMap$Entry.color;
    }

    static /* synthetic */ Object access$402(TreeMap$Entry treeMap$Entry, Object object) {
        treeMap$Entry.key = object;
        return treeMap$Entry.key;
    }

    static /* synthetic */ Object access$602(TreeMap$Entry treeMap$Entry, Object object) {
        treeMap$Entry.element = object;
        return treeMap$Entry.element;
    }

    static /* synthetic */ Object access$600(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.element;
    }

    static /* synthetic */ boolean access$500(TreeMap$Entry treeMap$Entry) {
        return treeMap$Entry.color;
    }
}

