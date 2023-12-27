/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.impl;

import com.sun.opengl.impl.GLObjectTracker;
import com.sun.opengl.impl.GLObjectTracker$Deleter;
import javax.media.opengl.GL;

class GLObjectTracker$ObjectList {
    private static final int MIN_CAPACITY;
    private int size;
    private int capacity;
    private int[] data;
    private GLObjectTracker$Deleter deleter;
    private String name;

    public GLObjectTracker$ObjectList(GLObjectTracker$Deleter gLObjectTracker$Deleter) {
        this.deleter = gLObjectTracker$Deleter;
        this.clear();
    }

    public void add(int n) {
        if (this.size == this.capacity) {
            int n2 = 2 * this.capacity;
            int[] nArray = new int[n2];
            System.arraycopy((Object)this.data, 0, (Object)nArray, 0, this.size);
            this.data = nArray;
            this.capacity = n2;
        }
        this.data[this.size++] = n;
    }

    public void addAll(GLObjectTracker$ObjectList gLObjectTracker$ObjectList) {
        if (gLObjectTracker$ObjectList == null) {
            return;
        }
        for (int i2 = 0; i2 < gLObjectTracker$ObjectList.size; ++i2) {
            this.add(gLObjectTracker$ObjectList.data[i2]);
        }
    }

    public boolean remove(int n) {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (this.data[i2] != n) continue;
            if (i2 < this.size - 1) {
                System.arraycopy((Object)this.data, i2 + 1, (Object)this.data, i2, this.size - i2 - 1);
            }
            --this.size;
            if (this.size < this.capacity / 4 && this.capacity > 4) {
                int n2 = this.capacity / 4;
                if (n2 < 4) {
                    n2 = 4;
                }
                int[] nArray = new int[n2];
                System.arraycopy((Object)this.data, 0, (Object)nArray, 0, this.size);
                this.data = nArray;
                this.capacity = n2;
            }
            return true;
        }
        return false;
    }

    public void setName(String string) {
        if (GLObjectTracker.access$000()) {
            this.name = string;
        }
    }

    public void delete(GL gL) {
        while (this.size > 0) {
            int n = this.data[this.size - 1];
            --this.size;
            if (GLObjectTracker.access$000()) {
                System.err.println(new StringBuffer().append("Deleting server-side OpenGL object ").append(n).append(this.name != null ? new StringBuffer().append(" (").append(this.name).append(")").toString() : "").toString());
            }
            this.deleter.delete(gL, n);
        }
    }

    public void clear() {
        this.size = 0;
        this.capacity = 4;
        this.data = new int[this.capacity];
    }
}

