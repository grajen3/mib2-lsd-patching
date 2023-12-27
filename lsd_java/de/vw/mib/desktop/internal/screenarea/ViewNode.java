/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.screenarea;

import de.vw.mib.desktop.internal.screenarea.Node;
import de.vw.mib.desktop.internal.screenarea.ScreenAreaNode;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import java.util.ArrayList;
import java.util.List;

public class ViewNode
extends Node {
    private SmartViewHandler viewHandler;
    private ScreenAreaNode parent;
    private List children;

    public ViewNode(SmartViewHandler smartViewHandler, ScreenAreaNode screenAreaNode) {
        this.viewHandler = smartViewHandler;
        this.parent = screenAreaNode;
        this.children = new ArrayList();
    }

    public void addChild(ScreenAreaNode screenAreaNode) {
        this.children.add(screenAreaNode);
    }

    public SmartViewHandler getViewHandler() {
        return this.viewHandler;
    }

    protected ScreenAreaNode getChild(String string) {
        for (int i2 = 0; i2 < this.children.size(); ++i2) {
            ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.children.get(i2);
            if (!screenAreaNode.getScreenAreaPath().equals(string)) continue;
            return screenAreaNode;
        }
        return null;
    }

    public ScreenAreaNode getParent() {
        return this.parent;
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    public String toString() {
        return new StringBuffer().append("ViewNode [viewHandler=").append(this.viewHandler).append(" (").append(this.children.size()).append(" screenarea(s)]").toString();
    }
}

