/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.util.RectanglePacker;
import de.vw.mib.graphics.internal.util.RectanglePacker$BSPNode;
import de.vw.mib.graphics.internal.util.RectanglePacker$Divider;
import de.vw.mib.util.StringBuilder;

final class RectanglePacker$EmptySpace
implements RectanglePacker$BSPNode {
    @Override
    public RectanglePacker$BSPNode insert(int n, int n2, int n3, int n4, int n5, int n6, Rectangle[] rectangleArray) {
        int n7 = n6 - n5 - n;
        int n8 = n4 - n3 - n2;
        if (n7 < 0 || n8 < 0) {
            return this;
        }
        if (n7 == 0 && n8 == 0) {
            rectangleArray[0] = new Rectangle(n5, n3, n, n2);
            return OCCUPIED_SPACE;
        }
        if (n7 > n8) {
            RectanglePacker$Divider rectanglePacker$Divider = (RectanglePacker$Divider)RectanglePacker.DIVIDER_POOL.borrowObject();
            rectanglePacker$Divider.setDivideHorizontal(false);
            rectanglePacker$Divider.setBorder(n5 + n);
            return rectanglePacker$Divider.insert(n, n2, n3, n4, n5, n6, rectangleArray);
        }
        RectanglePacker$Divider rectanglePacker$Divider = (RectanglePacker$Divider)RectanglePacker.DIVIDER_POOL.borrowObject();
        rectanglePacker$Divider.setDivideHorizontal(true);
        rectanglePacker$Divider.setBorder(n3 + n2);
        return rectanglePacker$Divider.insert(n, n2, n3, n4, n5, n6, rectangleArray);
    }

    @Override
    public RectanglePacker$BSPNode rearrangeDivider(int n, int n2, int n3, int n4, int n5, int n6) {
        return this;
    }

    @Override
    public RectanglePacker$BSPNode remove(Rectangle rectangle, int n, int n2, int n3, int n4) {
        return this;
    }

    @Override
    public short getDividerClass() {
        return 0;
    }

    @Override
    public RectanglePacker$BSPNode merge() {
        return this;
    }

    @Override
    public int getCoverage(int n, int n2, int n3, int n4) {
        return (n2 - n) * (n4 - n3);
    }

    @Override
    public String getDotNodeName(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ex").append(n3).append("y").append(n).append("w").append(n4 - n3).append("h").append(n2 - n);
        return stringBuilder.toString();
    }

    @Override
    public String getDotNodeDeclaration(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getDotNodeName(n, n2, n3, n4)).append(" [ label=\"<f0> -| <f1>").append(this.getDotNodeName(n, n2, n3, n4)).append(" | <f2> - \"];\n");
        return stringBuilder.toString();
    }

    @Override
    public String getDotDescription(int n, int n2, int n3, int n4) {
        return "";
    }

    @Override
    public int getOccupiedCount() {
        return 0;
    }

    @Override
    public int getDividerCount() {
        return 0;
    }
}

