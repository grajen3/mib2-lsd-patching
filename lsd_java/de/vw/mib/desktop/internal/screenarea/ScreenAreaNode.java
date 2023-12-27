/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.screenarea;

import de.vw.mib.desktop.internal.screenarea.Node;
import de.vw.mib.desktop.internal.screenarea.ViewNode;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.widgets.models.ScreenAreaModel;
import java.util.ArrayList;
import java.util.List;

public class ScreenAreaNode
extends Node {
    private String screenAreaPath;
    private ViewNode parent;
    private List children;
    private boolean active;

    public ScreenAreaNode(String string, ViewNode viewNode, boolean bl) {
        this.screenAreaPath = string;
        this.parent = viewNode;
        this.active = bl;
        this.children = new ArrayList();
    }

    public void addChild(ViewNode viewNode) {
        this.children.add(viewNode);
    }

    public ScreenAreaModel getScreenArea() {
        String string = this.screenAreaPath.substring(this.screenAreaPath.lastIndexOf(46) + 1);
        ScreenAreaModel[] screenAreaModelArray = this.parent.getViewHandler().getScreenAreas();
        for (int i2 = 0; i2 < screenAreaModelArray.length; ++i2) {
            if (!string.equals(screenAreaModelArray[i2].get_name())) continue;
            return screenAreaModelArray[i2];
        }
        return null;
    }

    protected ScreenAreaNode getChild(String string) {
        for (int i2 = 0; i2 < this.children.size(); ++i2) {
            ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.children.get(i2);
            if (!screenAreaNode.getScreenAreaPath().equals(string)) continue;
            return screenAreaNode;
        }
        return null;
    }

    public ViewNode getParent() {
        return this.parent;
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    public String getScreenAreaPath() {
        return this.screenAreaPath;
    }

    void setActive(boolean bl) {
        this.active = bl;
    }

    public boolean isActive() {
        return this.active;
    }

    public String toString() {
        return new StringBuffer().append("ScreenAreaNode [screenAreaPath=").append(this.screenAreaPath).append("; active=").append(this.active).append("]").toString();
    }

    protected ScreenAreaNode remove(String string, SmartViewHandler smartViewHandler) {
        SmartViewHandler smartViewHandler2 = this.parent.getViewHandler();
        for (int i2 = 0; i2 < this.children.size(); ++i2) {
            ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.children.get(i2);
            if (!screenAreaNode.getScreenAreaPath().equals(string) || !smartViewHandler.equals(smartViewHandler2)) continue;
            this.children.remove(i2);
            return screenAreaNode;
        }
        return null;
    }

    public void removeChild(int n) {
        this.children.remove(n);
    }
}

