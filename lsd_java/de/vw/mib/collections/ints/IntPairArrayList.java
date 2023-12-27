/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.collections.ints;

public class IntPairArrayList {
    private int[] left;
    private int[] right;
    private int size;
    private int arraylength;

    public IntPairArrayList() {
        this(10);
    }

    public IntPairArrayList(int n) {
        this.initArrays(n);
        this.size = 0;
    }

    private void initArrays(int n) {
        this.arraylength = n;
        this.left = new int[this.arraylength];
        this.right = new int[this.arraylength];
    }

    private void resizeIfNecessary() {
        if (this.size + 1 > this.arraylength) {
            int[] nArray = this.left;
            int[] nArray2 = this.right;
            int n = this.arraylength;
            this.initArrays(2 * this.arraylength + 1);
            System.arraycopy((Object)nArray, 0, (Object)this.left, 0, n);
            System.arraycopy((Object)nArray2, 0, (Object)this.right, 0, n);
        }
    }

    public void add(int n, int n2) {
        this.resizeIfNecessary();
        this.left[this.size] = n;
        this.right[this.size] = n2;
        ++this.size;
    }

    public void clear() {
        this.size = 0;
    }

    public int getLeft(int n) {
        this.checkLocation(n);
        return this.left[n];
    }

    private void checkLocation(int n) {
        if (n < 0 || n >= this.size) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("index=").append(n).append(", size=").append(this.size).toString());
        }
    }

    public int getRight(int n) {
        this.checkLocation(n);
        return this.right[n];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean removeLast() {
        if (this.size > 0) {
            --this.size;
            return true;
        }
        return false;
    }

    public void remove(int n) {
        this.checkLocation(n);
        int[] nArray = this.left;
        int[] nArray2 = this.right;
        this.left = new int[this.arraylength];
        this.right = new int[this.arraylength];
        System.arraycopy((Object)nArray, 0, (Object)this.left, 0, n);
        System.arraycopy((Object)nArray2, 0, (Object)this.right, 0, n);
        int n2 = n + 1;
        System.arraycopy((Object)nArray, n2, (Object)this.left, n, this.arraylength - n2);
        System.arraycopy((Object)nArray2, n2, (Object)this.right, n, this.arraylength - n2);
        --this.size;
    }

    public int size() {
        return this.size;
    }

    public int setLeft(int n, int n2) {
        this.checkLocation(n);
        int n3 = this.left[n];
        this.left[n] = n2;
        return n3;
    }

    public int setRight(int n, int n2) {
        this.checkLocation(n);
        int n3 = this.right[n];
        this.right[n] = n2;
        return n3;
    }

    public void set(int n, int n2, int n3) {
        this.checkLocation(n);
        this.left[n] = n2;
        this.right[n] = n3;
    }
}

