/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractComposite
 *  de.audi.gem.AbstractElement
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.AbstractComposite;
import de.audi.gem.AbstractElement;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import java.util.ArrayList;
import java.util.List;

public final class VWGEMComposite
extends AbstractComposite {
    private final Graphics3D g3d;
    private final int width;
    private final int height;
    private int x;
    private int y;
    private boolean selected;
    private boolean visible;
    private List children;

    public VWGEMComposite(Graphics3D graphics3D, int n, int n2) {
        this.g3d = graphics3D;
        this.selected = false;
        this.visible = true;
        this.width = n;
        this.height = n2;
        this.children = new ArrayList();
    }

    public AbstractElement getChildren(int n) {
        return (AbstractElement)this.children.get(n);
    }

    public int getNumChildren() {
        return this.children.size();
    }

    public void addChild(AbstractElement abstractElement) {
        this.children.add(abstractElement);
    }

    public void clearChildren() {
        this.children.clear();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setColors(int n, int n2) {
    }

    public int getPositionX() {
        return this.x;
    }

    public int getPositionY() {
        return this.y;
    }

    public void setPosition(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean bl) {
        for (int i2 = this.children.size() - 1; i2 >= 0; --i2) {
            ((AbstractElement)this.children.get(i2)).setSelected(bl);
        }
        this.selected = bl;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean bl) {
        this.visible = bl;
    }

    public void draw() {
        if (this.isVisible()) {
            Rectangle rectangle = new Rectangle();
            this.g3d.getScissor(rectangle);
            this.g3d.setScissor(rectangle.x + this.getPositionX(), rectangle.y + this.getPositionY(), this.getWidth(), this.getHeight());
            this.g3d.pushMatrix(0);
            this.g3d.translateMatrix(0, this.getPositionX(), this.getPositionY(), 0.0f);
            int n = this.children.size();
            for (int i2 = 0; i2 < n; ++i2) {
                AbstractElement abstractElement = (AbstractElement)this.children.get(i2);
                abstractElement.draw();
            }
            this.g3d.popMatrix(0);
            this.g3d.setScissor(rectangle);
        }
    }

    public void cleanUp() {
        for (int i2 = this.children.size() - 1; i2 >= 0; --i2) {
            ((AbstractElement)this.children.get(i2)).cleanUp();
        }
    }
}

