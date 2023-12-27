/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.util.RectanglePacker$BSPNode;
import de.vw.mib.util.StringBuilder;

final class RectanglePacker$OccupiedSpace
implements RectanglePacker$BSPNode {
    @Override
    public RectanglePacker$BSPNode insert(int n, int n2, int n3, int n4, int n5, int n6, Rectangle[] rectangleArray) {
        return this;
    }

    @Override
    public RectanglePacker$BSPNode rearrangeDivider(int n, int n2, int n3, int n4, int n5, int n6) {
        return this;
    }

    @Override
    public RectanglePacker$BSPNode remove(Rectangle rectangle, int n, int n2, int n3, int n4) {
        return rectangle.contains(n3, n, n4 - n3, n2 - n) ? EMPTY_SPACE : this;
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
        return 0;
    }

    @Override
    public String getDotNodeName(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ox").append(n3).append("y").append(n).append("w").append(n4 - n3).append("h").append(n2 - n);
        return stringBuilder.toString();
    }

    @Override
    public String getDotNodeDeclaration(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getDotNodeName(n, n2, n3, n4)).append(" [ label=\"<f0> -| <f1>").append(this.getDotNodeName(n, n2, n3, n4)).append(" | <f2> - \" color=red];\n");
        return stringBuilder.toString();
    }

    @Override
    public String getDotDescription(int n, int n2, int n3, int n4) {
        return "";
    }

    @Override
    public int getOccupiedCount() {
        return 1;
    }

    @Override
    public int getDividerCount() {
        return 0;
    }
}

