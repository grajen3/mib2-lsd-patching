/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.util.RectanglePacker$EmptySpace;
import de.vw.mib.graphics.internal.util.RectanglePacker$OccupiedSpace;

interface RectanglePacker$BSPNode {
    public static final RectanglePacker$BSPNode EMPTY_SPACE = new RectanglePacker$EmptySpace();
    public static final RectanglePacker$BSPNode OCCUPIED_SPACE = new RectanglePacker$OccupiedSpace();
    public static final short DIVIDER_CLASS_NONE;
    public static final short DIVIDER_CLASS_VERTICAL;
    public static final short DIVIDER_CLASS_HORIZONTAL;

    default public RectanglePacker$BSPNode insert(int n, int n2, int n3, int n4, int n5, int n6, Rectangle[] rectangleArray) {
    }

    default public RectanglePacker$BSPNode rearrangeDivider(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public RectanglePacker$BSPNode remove(Rectangle rectangle, int n, int n2, int n3, int n4) {
    }

    default public RectanglePacker$BSPNode merge() {
    }

    default public short getDividerClass() {
    }

    default public int getCoverage(int n, int n2, int n3, int n4) {
    }

    default public int getDividerCount() {
    }

    default public int getOccupiedCount() {
    }

    default public String getDotNodeName(int n, int n2, int n3, int n4) {
    }

    default public String getDotNodeDeclaration(int n, int n2, int n3, int n4) {
    }

    default public String getDotDescription(int n, int n2, int n3, int n4) {
    }
}

