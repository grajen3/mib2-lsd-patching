/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.internal.util.RectanglePacker$BSPNode;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.defaultimpl.AbstractPooledObject;
import de.vw.mib.util.StringBuilder;

final class RectanglePacker$Divider
extends AbstractPooledObject
implements RectanglePacker$BSPNode {
    private int border;
    private short dividerClass;
    private RectanglePacker$BSPNode subNode1;
    private RectanglePacker$BSPNode subNode2;

    public RectanglePacker$Divider(ObjectPool objectPool) {
        super(objectPool);
        this.clear();
    }

    private void clear() {
        this.subNode1 = EMPTY_SPACE;
        this.subNode2 = EMPTY_SPACE;
    }

    @Override
    public void backToPool() {
        this.clear();
    }

    public void setDivideHorizontal(boolean bl) {
        this.dividerClass = (short)(bl ? 2 : 1);
    }

    public void setBorder(int n) {
        this.border = n;
    }

    @Override
    public short getDividerClass() {
        return this.dividerClass;
    }

    @Override
    public RectanglePacker$BSPNode insert(int n, int n2, int n3, int n4, int n5, int n6, Rectangle[] rectangleArray) {
        if (this.isDivideHorizontal()) {
            if (this.border - n3 >= n2) {
                this.subNode1 = this.subNode1.insert(n, n2, n3, this.border, n5, n6, rectangleArray);
            }
            if (rectangleArray[0] == null && n4 - this.border >= n2) {
                this.subNode2 = this.subNode2.insert(n, n2, this.border, n4, n5, n6, rectangleArray);
            }
        } else {
            if (this.border - n5 >= n) {
                this.subNode1 = this.subNode1.insert(n, n2, n3, n4, n5, this.border, rectangleArray);
            }
            if (rectangleArray[0] == null && n6 - this.border >= n) {
                this.subNode2 = this.subNode2.insert(n, n2, n3, n4, this.border, n6, rectangleArray);
            }
        }
        return this;
    }

    @Override
    public RectanglePacker$BSPNode rearrangeDivider(int n, int n2, int n3, int n4, int n5, int n6) {
        RectanglePacker$Divider rectanglePacker$Divider;
        if (n > n6 - n5 || n2 > n4 - n3) {
            return this;
        }
        if (this.isDivideHorizontal()) {
            this.subNode1 = this.subNode1.rearrangeDivider(n, n2, n3, this.border, n5, n6);
            this.subNode2 = this.subNode2.rearrangeDivider(n, n2, this.border, n4, n5, n6);
        } else {
            this.subNode1 = this.subNode1.rearrangeDivider(n, n2, n3, n4, n5, this.border);
            this.subNode2 = this.subNode2.rearrangeDivider(n, n2, n3, n4, this.border, n6);
        }
        if (this.subNode1 == EMPTY_SPACE && this.subNode2 != OCCUPIED_SPACE && ((RectanglePacker$Divider)this.subNode2).getDividerClass() != this.getDividerClass()) {
            rectanglePacker$Divider = (RectanglePacker$Divider)this.subNode2;
            if (rectanglePacker$Divider.subNode1 == EMPTY_SPACE) {
                RectanglePacker$BSPNode rectanglePacker$BSPNode = rectanglePacker$Divider.subNode2;
                rectanglePacker$Divider.subNode2 = this;
                this.subNode2 = rectanglePacker$BSPNode;
                return rectanglePacker$Divider;
            }
            if (rectanglePacker$Divider.subNode2 == EMPTY_SPACE) {
                RectanglePacker$BSPNode rectanglePacker$BSPNode = rectanglePacker$Divider.subNode1;
                rectanglePacker$Divider.subNode1 = this;
                this.subNode2 = rectanglePacker$BSPNode;
                return rectanglePacker$Divider;
            }
        }
        if (this.subNode2 == EMPTY_SPACE && this.subNode1 != OCCUPIED_SPACE && ((RectanglePacker$Divider)this.subNode1).getDividerClass() != this.getDividerClass()) {
            rectanglePacker$Divider = (RectanglePacker$Divider)this.subNode1;
            if (rectanglePacker$Divider.subNode1 == EMPTY_SPACE) {
                RectanglePacker$BSPNode rectanglePacker$BSPNode = rectanglePacker$Divider.subNode2;
                rectanglePacker$Divider.subNode2 = this;
                this.subNode1 = rectanglePacker$BSPNode;
                return rectanglePacker$Divider;
            }
            if (rectanglePacker$Divider.subNode2 == EMPTY_SPACE) {
                RectanglePacker$BSPNode rectanglePacker$BSPNode = rectanglePacker$Divider.subNode1;
                rectanglePacker$Divider.subNode1 = this;
                this.subNode1 = rectanglePacker$BSPNode;
                return rectanglePacker$Divider;
            }
        }
        return this;
    }

    @Override
    public RectanglePacker$BSPNode remove(Rectangle rectangle, int n, int n2, int n3, int n4) {
        if (rectangle.y < n || rectangle.y + rectangle.height > n2 || rectangle.x < n3 || rectangle.x + rectangle.width > n4) {
            return this;
        }
        if (this.isDivideHorizontal()) {
            if (this.border - n >= rectangle.height) {
                this.subNode1 = this.subNode1.remove(rectangle, n, this.border, n3, n4);
            }
            this.subNode2 = this.subNode2.remove(rectangle, this.border, n2, n3, n4);
        } else {
            if (n4 - n3 >= rectangle.width) {
                this.subNode1 = this.subNode1.remove(rectangle, n, n2, n3, this.border);
            }
            this.subNode2 = this.subNode2.remove(rectangle, n, n2, this.border, n4);
        }
        if (this.subNode1 != EMPTY_SPACE || this.subNode2 != EMPTY_SPACE) {
            return this;
        }
        this.releaseObject();
        return EMPTY_SPACE;
    }

    @Override
    public RectanglePacker$BSPNode merge() {
        RectanglePacker$Divider rectanglePacker$Divider;
        RectanglePacker$BSPNode rectanglePacker$BSPNode;
        this.subNode1 = this.subNode1.merge();
        this.subNode2 = this.subNode2.merge();
        if (!(this.subNode1 != EMPTY_SPACE && this.subNode2 != EMPTY_SPACE || this.subNode1 == OCCUPIED_SPACE || this.subNode2 == OCCUPIED_SPACE || (rectanglePacker$BSPNode = (RectanglePacker$Divider)(this.subNode1 == EMPTY_SPACE ? this.subNode2 : this.subNode1)).getDividerClass() == this.getDividerClass() || rectanglePacker$BSPNode.subNode1 != EMPTY_SPACE && rectanglePacker$BSPNode.subNode2 != EMPTY_SPACE || rectanglePacker$BSPNode.subNode1 == OCCUPIED_SPACE || rectanglePacker$BSPNode.subNode2 == OCCUPIED_SPACE || (rectanglePacker$Divider = (RectanglePacker$Divider)(rectanglePacker$BSPNode.subNode1 != EMPTY_SPACE ? rectanglePacker$BSPNode.subNode1 : rectanglePacker$BSPNode.subNode2)).getDividerClass() != this.getDividerClass() || this.subNode1 != rectanglePacker$Divider.subNode1 && this.subNode2 != rectanglePacker$Divider.subNode2)) {
            this.releaseObject();
            return rectanglePacker$BSPNode;
        }
        if (this.subNode2 == EMPTY_SPACE && this.dividerClass == this.subNode1.getDividerClass() && ((RectanglePacker$Divider)this.subNode1).subNode2 == EMPTY_SPACE) {
            rectanglePacker$BSPNode = this.subNode1;
            this.releaseObject();
            return rectanglePacker$BSPNode;
        }
        if (this.subNode1 == EMPTY_SPACE && this.dividerClass == this.subNode2.getDividerClass() && ((RectanglePacker$Divider)this.subNode2).subNode1 == EMPTY_SPACE) {
            rectanglePacker$BSPNode = this.subNode2;
            this.releaseObject();
            return rectanglePacker$BSPNode;
        }
        if (this.dividerClass == this.subNode1.getDividerClass() && this.dividerClass == this.subNode2.getDividerClass()) {
            rectanglePacker$BSPNode = (RectanglePacker$Divider)this.subNode1;
            rectanglePacker$Divider = (RectanglePacker$Divider)this.subNode2;
            if (rectanglePacker$BSPNode.subNode2 == EMPTY_SPACE && rectanglePacker$Divider.subNode1 == EMPTY_SPACE) {
                rectanglePacker$BSPNode.subNode2 = rectanglePacker$Divider;
                this.releaseObject();
                return rectanglePacker$BSPNode;
            }
        }
        return this;
    }

    private boolean isDivideHorizontal() {
        return this.dividerClass == 2;
    }

    @Override
    public int getCoverage(int n, int n2, int n3, int n4) {
        if (this.isDivideHorizontal()) {
            return this.subNode1.getCoverage(n, this.border, n3, n4) + this.subNode2.getCoverage(this.border, n2, n3, n4);
        }
        return this.subNode1.getCoverage(n, n2, n3, this.border) + this.subNode2.getCoverage(n, n2, this.border, n4);
    }

    @Override
    public int getDividerCount() {
        return 1 + this.subNode1.getDividerCount() + this.subNode2.getDividerCount();
    }

    @Override
    public int getOccupiedCount() {
        return this.subNode1.getOccupiedCount() + this.subNode2.getOccupiedCount();
    }

    @Override
    public String getDotDescription(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.isDivideHorizontal()) {
            stringBuilder.append(this.subNode1.getDotNodeDeclaration(n, this.border, n3, n4));
            stringBuilder.append(this.subNode2.getDotNodeDeclaration(this.border, n2, n3, n4));
            stringBuilder.append("\"").append(this.getDotNodeName(n, n2, n3, n4)).append("\":f0 -> ").append("\"").append(this.subNode1.getDotNodeName(n, this.border, n3, n4)).append("\":f1;\n");
            stringBuilder.append("\"").append(this.getDotNodeName(n, n2, n3, n4)).append("\":f2 -> ").append("\"").append(this.subNode2.getDotNodeName(this.border, n2, n3, n4)).append("\":f1;\n");
            stringBuilder.append(this.subNode1.getDotDescription(n, this.border, n3, n4));
            stringBuilder.append(this.subNode2.getDotDescription(this.border, n2, n3, n4));
        } else {
            stringBuilder.append(this.subNode1.getDotNodeDeclaration(n, n2, n3, this.border));
            stringBuilder.append(this.subNode2.getDotNodeDeclaration(n, n2, this.border, n4));
            stringBuilder.append("\"").append(this.getDotNodeName(n, n2, n3, n4)).append("\":f0 -> ").append("\"").append(this.subNode1.getDotNodeName(n, n2, n3, this.border)).append("\":f1;\n");
            stringBuilder.append("\"").append(this.getDotNodeName(n, n2, n3, n4)).append("\":f2 -> ").append("\"").append(this.subNode2.getDotNodeName(n, n2, this.border, n4)).append("\":f1;\n");
            stringBuilder.append(this.subNode1.getDotDescription(n, n2, n3, this.border));
            stringBuilder.append(this.subNode2.getDotDescription(n, n2, this.border, n4));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getDotNodeDeclaration(int n, int n2, int n3, int n4) {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.isDivideHorizontal() ? "blue" : "green";
        String string2 = this.isDivideHorizontal() ? "t" : "l";
        String string3 = this.isDivideHorizontal() ? "b" : "r";
        stringBuilder.append(this.getDotNodeName(n, n2, n3, n4)).append(" [ label=\"<f0> ").append(string2).append(" | <f1>").append(this.getDotNodeName(n, n2, n3, n4)).append(" | <f2> ").append(string3).append(" \" color=").append(string).append("];\n");
        return stringBuilder.toString();
    }

    @Override
    public String getDotNodeName(int n, int n2, int n3, int n4) {
        return new StringBuffer().append(this.isDivideHorizontal() ? "Hx" : "Vx").append(n3).append("y").append(n).append("w").append(n4 - n3).append("h").append(n2 - n).append("b").append(this.border).toString();
    }
}

