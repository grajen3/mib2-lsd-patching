/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

public class MainStatemachineOrder {
    private static final short RETURN_ACTIVE_ID;
    public static final short NONE;
    private final short[] categoryById;
    private final short[] subPriorityById;
    final int[][] idsByCategory;
    private int activeId;
    private short activeCategory;
    private short activeSubPriority;
    private short itCategory;
    private short itSubPriority;

    public MainStatemachineOrder(short[] sArray, short[] sArray2) {
        this.categoryById = sArray;
        this.subPriorityById = sArray2;
        this.idsByCategory = MainStatemachineOrder.computeOrder(sArray, sArray2);
    }

    static int[][] computeOrder(short[] sArray, short[] sArray2) {
        int n = MainStatemachineOrder.maxCategory(sArray) + 1;
        int[] nArray = MainStatemachineOrder.maxSubPriorityByCategory(n, sArray, sArray2);
        int[][] nArray2 = MainStatemachineOrder.buildIdsByCategory(nArray, sArray, sArray2);
        return nArray2;
    }

    private static int maxCategory(short[] sArray) {
        int n = 0;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            n = Math.max(n, sArray[i2]);
        }
        return n;
    }

    private static int[] maxSubPriorityByCategory(int n, short[] sArray, short[] sArray2) {
        int[] nArray = new int[n];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            short s = sArray[i2];
            if (s == -1) continue;
            short s2 = sArray2[i2];
            nArray[s] = Math.max(nArray[s], s2);
        }
        return nArray;
    }

    private static int[][] buildIdsByCategory(int[] nArray, short[] sArray, short[] sArray2) {
        int n;
        int n2;
        int[][] nArrayArray = new int[nArray.length][];
        for (n2 = 0; n2 < nArrayArray.length; ++n2) {
            n = nArray[n2] + 1;
            nArrayArray[n2] = new int[n];
        }
        for (n2 = 0; n2 < sArray.length; ++n2) {
            n = sArray[n2];
            if (n == -1) continue;
            short s = sArray2[n2];
            nArrayArray[n][s] = n2;
        }
        return nArrayArray;
    }

    public int firstId() {
        return this.firstId(-1);
    }

    public int firstId(int n) {
        this.activeId = n;
        if (n >= 0) {
            this.activeCategory = this.categoryById[n];
            this.activeSubPriority = this.subPriorityById[n];
        } else {
            this.activeCategory = (short)-1;
            this.activeSubPriority = (short)-1;
        }
        this.itCategory = 0;
        this.itSubPriority = this.firstSubPriorityInCategory();
        return this.nextId();
    }

    public int nextId() {
        if (this.itCategory >= this.idsByCategory.length) {
            return -1;
        }
        int[] nArray = this.idsByCategory[this.itCategory];
        if (this.itSubPriority >= nArray.length) {
            this.itCategory = (short)(this.itCategory + 1);
            this.itSubPriority = this.firstSubPriorityInCategory();
            return this.nextId();
        }
        if (this.itSubPriority == -1) {
            this.itSubPriority = 0;
            int n = this.idsByCategory[this.activeCategory][this.activeSubPriority];
            return n;
        }
        short s = this.itSubPriority;
        this.itSubPriority = (short)(s + 1);
        int n = nArray[s];
        if (n == this.activeId) {
            return this.nextId();
        }
        return n;
    }

    private short firstSubPriorityInCategory() {
        return this.itCategory == this.activeCategory ? (short)-1 : 0;
    }
}

