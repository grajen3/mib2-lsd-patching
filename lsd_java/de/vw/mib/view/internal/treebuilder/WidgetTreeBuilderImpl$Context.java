/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

class WidgetTreeBuilderImpl$Context {
    final int internalViewId;
    int consecutiveCloneId;
    final short[][] uiData;

    public WidgetTreeBuilderImpl$Context(int n, int n2, short[][] sArray) {
        this.internalViewId = n;
        this.consecutiveCloneId = n2;
        this.uiData = sArray;
    }

    public static short[] getUITypes(short[][] sArray, int n) {
        return sArray[n - -1];
    }
}

