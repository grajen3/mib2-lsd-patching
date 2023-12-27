/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.util.RectanglePacker$BSPNode;
import de.vw.mib.graphics.internal.util.RectanglePacker$DividerPool;
import de.vw.mib.util.StringBuilder;

public final class RectanglePacker {
    private static final int DIVIDER_POOL_MAXIMUM_CAPACITY;
    protected static final RectanglePacker$DividerPool DIVIDER_POOL;
    private final int width;
    private final int height;
    private final boolean mergeAfterRemove;
    private RectanglePacker$BSPNode root;

    public RectanglePacker(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public RectanglePacker(int n, int n2) {
        this(n, n2, true);
    }

    public RectanglePacker(int n, int n2, boolean bl) {
        this.width = n;
        this.height = n2;
        this.mergeAfterRemove = bl;
        this.reset();
    }

    public void reset() {
        this.root = RectanglePacker$BSPNode.EMPTY_SPACE;
    }

    public void merge() {
        this.root = this.root.merge();
    }

    public int getRectangleCount() {
        return this.root.getOccupiedCount();
    }

    public boolean isEmpty() {
        return this.root == RectanglePacker$BSPNode.EMPTY_SPACE;
    }

    public Rectangle insert(int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            throw new IllegalArgumentException("width and height must not be zero or less");
        }
        Rectangle[] rectangleArray = new Rectangle[]{null};
        this.root = this.root.insert(n, n2, 0, this.height, 0, this.width, rectangleArray);
        return rectangleArray[0];
    }

    protected void rearrangeDivider(int n, int n2) {
        this.root = this.root.rearrangeDivider(n, n2, 0, this.height, 0, this.width);
    }

    public void removeRectangle(Rectangle rectangle) {
        this.root = this.root.remove(rectangle, 0, this.height, 0, this.width);
        if (this.mergeAfterRemove) {
            this.merge();
        }
    }

    public int getCoverage() {
        return this.root.getCoverage(0, this.height, 0, this.width);
    }

    public int getDividerCount() {
        return this.root.getDividerCount();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("digraph G{\n").append(" node [shape = record];\n");
        stringBuilder.append(this.root.getDotNodeDeclaration(0, this.height, 0, this.width));
        stringBuilder.append(this.root.getDotDescription(0, this.height, 0, this.width));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static {
        DIVIDER_POOL = new RectanglePacker$DividerPool(500);
    }
}

