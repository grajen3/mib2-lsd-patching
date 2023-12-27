/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.screenarea;

import de.vw.mib.desktop.internal.common.ServiceManager;
import de.vw.mib.desktop.internal.screenarea.Node;
import de.vw.mib.desktop.internal.screenarea.ScreenAreaNode;
import de.vw.mib.desktop.internal.screenarea.ViewNode;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandler;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.models.ScreenAreaModel;
import java.util.HashMap;
import java.util.List;

public class ScreenTree {
    private static final boolean DEBUG;
    private final Logger logger = ServiceManager.loggerFactory.getLogger(1024);
    private ScreenAreaNode root;
    private HashMap screenAreaPath2ScreenAreaNode = new HashMap();

    public ScreenTree(SmartViewHandler smartViewHandler) {
        this.root = new ScreenAreaNode("", null, true);
        this.screenAreaPath2ScreenAreaNode.put("", this.root);
        this.registerViewHandler("", smartViewHandler);
    }

    public void setActive(String string, boolean bl) {
        ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.screenAreaPath2ScreenAreaNode.get(string);
        screenAreaNode.setActive(bl);
    }

    private void outputNode(Node node, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < n; ++i2) {
            stringBuilder.append("  ");
        }
        stringBuilder.append(node);
        this.logger.trace(2048).append("ST ").append(stringBuilder.toString()).log();
        List list = node.getChildren();
        for (int i3 = 0; i3 < list.size(); ++i3) {
            this.outputNode((Node)list.get(i3), n + 1);
        }
    }

    private void outputTree() {
        if (this.logger.isTraceEnabled(2048)) {
            this.outputNode(this.root, 0);
        }
    }

    public ScreenAreaNode getScreenAreaNode(String string) {
        return (ScreenAreaNode)this.screenAreaPath2ScreenAreaNode.get(string);
    }

    public void registerViewHandler(String string, SmartViewHandler smartViewHandler) {
        ScreenAreaModel[] screenAreaModelArray;
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("registerViewHandler ").append(string).append(" ").append(smartViewHandler.getNameForTraces()).log();
        }
        ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.screenAreaPath2ScreenAreaNode.get(string);
        List list = screenAreaNode.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            screenAreaModelArray = (ScreenAreaModel[])list.get(i2);
            if (!smartViewHandler.equals(screenAreaModelArray.getViewHandler())) continue;
            if (this.logger.isTraceEnabled(2048)) {
                this.logger.trace(2048).append("registerViewHandler ").append(string).append(" ").append(smartViewHandler.getNameForTraces()).append(" ignored because it's already registered").log();
            }
            return;
        }
        ViewNode viewNode = new ViewNode(smartViewHandler, screenAreaNode);
        screenAreaModelArray = smartViewHandler.getScreenAreas();
        if (string.length() > 0) {
            string = new StringBuffer().append(string).append(".").toString();
        }
        for (int i3 = 0; i3 < screenAreaModelArray.length; ++i3) {
            String string2 = new StringBuffer().append(string).append(screenAreaModelArray[i3].get_name()).toString();
            ScreenAreaNode screenAreaNode2 = new ScreenAreaNode(string2, viewNode, true);
            viewNode.addChild(screenAreaNode2);
            this.screenAreaPath2ScreenAreaNode.put(string2, screenAreaNode2);
        }
        screenAreaNode.addChild(viewNode);
        this.outputTree();
    }

    public void unregisterViewHandler(String string, SmartViewHandler smartViewHandler) {
        if (this.logger.isTraceEnabled(2048)) {
            this.logger.trace(2048).append("unregisterViewHandler ").append(string).append(" ").append(smartViewHandler.getNameForTraces()).log();
        }
        ScreenAreaNode screenAreaNode = (ScreenAreaNode)this.screenAreaPath2ScreenAreaNode.get(string);
        List list = screenAreaNode.getChildren();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            if (!((ViewNode)list.get(i2)).getViewHandler().equals(smartViewHandler)) continue;
            screenAreaNode.removeChild(i2);
        }
        this.outputTree();
    }
}

