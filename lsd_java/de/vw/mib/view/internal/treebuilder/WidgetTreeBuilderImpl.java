/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal.treebuilder;

import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.view.internal.CloneData;
import de.vw.mib.view.internal.treebuilder.ControllerFactory;
import de.vw.mib.view.internal.treebuilder.Dumpable;
import de.vw.mib.view.internal.treebuilder.UIFactory;
import de.vw.mib.view.internal.treebuilder.WidgetFactory;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilder;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilderImpl$Context;
import de.vw.mib.view.internal.treebuilder.WidgetTreeBuilderResDataAccess;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetUI;

public class WidgetTreeBuilderImpl
implements WidgetTreeBuilder {
    static final int TOP_CLASSIFIER;
    static final int SUB_CLASSIFIER;
    static final int DUMPING_COUNTER_RESET;
    private final Logger logger;
    private final WidgetTreeBuilderResDataAccess dataAccess;
    private final WidgetFactory widgetFactory;
    private final UIFactory uiFactory;
    private final ControllerFactory controllerFactory;
    private int dumingCounter = 10;

    public WidgetTreeBuilderImpl(WidgetTreeBuilderResDataAccess widgetTreeBuilderResDataAccess, WidgetFactory widgetFactory, ControllerFactory controllerFactory, UIFactory uIFactory, LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1024);
        this.dataAccess = widgetTreeBuilderResDataAccess;
        this.widgetFactory = widgetFactory;
        this.controllerFactory = controllerFactory;
        this.uiFactory = uIFactory;
    }

    @Override
    public CloneData createFullWidgetTree(int n, short[][] sArray) {
        Preconditions.checkArgument(sArray != null, "uiData");
        WidgetTreeBuilderImpl$Context widgetTreeBuilderImpl$Context = new WidgetTreeBuilderImpl$Context(n, -1, sArray);
        CloneData cloneData = this.createTreeRecursively(widgetTreeBuilderImpl$Context);
        return cloneData;
    }

    @Override
    public CloneData cloneSubWidgetTree(int n, CloneData cloneData, short[][] sArray) {
        Preconditions.checkArgument(cloneData != null, "cloneMaster");
        Preconditions.checkArgument(sArray != null, "uiData");
        WidgetTreeBuilderImpl$Context widgetTreeBuilderImpl$Context = new WidgetTreeBuilderImpl$Context(n, cloneData.masterId, sArray);
        CloneData cloneData2 = this.createTreeRecursively(widgetTreeBuilderImpl$Context);
        CloneData.add(cloneData, cloneData2);
        ((WidgetCloneable)((Object)cloneData2.widgets[0])).setCloneData(cloneData2);
        return cloneData2;
    }

    private CloneData createTreeRecursively(WidgetTreeBuilderImpl$Context widgetTreeBuilderImpl$Context) {
        int n = widgetTreeBuilderImpl$Context.consecutiveCloneId;
        byte[] byArray = this.dataAccess.getWidgetTypes(widgetTreeBuilderImpl$Context.internalViewId, n);
        byte[] byArray2 = this.dataAccess.getControllerTypes(widgetTreeBuilderImpl$Context.internalViewId, n);
        short[] sArray = WidgetTreeBuilderImpl$Context.getUITypes(widgetTreeBuilderImpl$Context.uiData, n);
        int n2 = byArray.length;
        CloneData cloneData = new CloneData(n2, n);
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = byArray[i2];
            if (by == 0) {
                ++widgetTreeBuilderImpl$Context.consecutiveCloneId;
                cloneData.widgets[i2] = this.createCloneableWidget(widgetTreeBuilderImpl$Context);
                continue;
            }
            cloneData.widgets[i2] = this.createWidget(by, byArray2[i2], sArray[i2]);
        }
        this.setupRelationship(widgetTreeBuilderImpl$Context.internalViewId, n, cloneData.widgets);
        return cloneData;
    }

    private WidgetModel createWidget(int n, int n2, int n3) {
        WidgetModel widgetModel = this.createWidgetInstance(n);
        WidgetController widgetController = this.createControllerInstance(n2);
        WidgetUI widgetUI = this.createUIInstance(n3);
        widgetModel.setController(widgetController);
        widgetModel.setUI(widgetUI);
        return widgetModel;
    }

    private WidgetModel createCloneableWidget(WidgetTreeBuilderImpl$Context widgetTreeBuilderImpl$Context) {
        CloneData cloneData = this.createTreeRecursively(widgetTreeBuilderImpl$Context);
        WidgetModel widgetModel = cloneData.widgets[0];
        ((WidgetCloneable)((Object)widgetModel)).setCloneData(cloneData);
        return widgetModel;
    }

    @Override
    public void destroyWidgetTree(int n, CloneData cloneData, short[][] sArray) {
        Preconditions.checkArgument(sArray != null, "uiData");
        this.destroyTreeRecursively(n, cloneData, sArray);
        CloneData.remove(cloneData.master, cloneData);
    }

    private void destroyTreeRecursively(int n, CloneData cloneData, short[][] sArray) {
        byte[] byArray = this.dataAccess.getWidgetTypes(n, cloneData.masterId);
        byte[] byArray2 = this.dataAccess.getControllerTypes(n, cloneData.masterId);
        short[] sArray2 = WidgetTreeBuilderImpl$Context.getUITypes(sArray, cloneData.masterId);
        int n2 = byArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by = byArray[i2];
            if (by == 0) {
                CloneData cloneData2 = (CloneData)((WidgetCloneable)((Object)cloneData.widgets[i2])).getCloneData();
                this.destroyTreeRecursively(n, cloneData2, sArray);
                continue;
            }
            this.destroyWidget(cloneData.widgets[i2], by, byArray2[i2], sArray2[i2]);
        }
    }

    private void destroyWidget(WidgetModel widgetModel, int n, int n2, int n3) {
        this.destroyControllerInstance(n2, widgetModel.getController());
        this.destroyUIInstance(n3, widgetModel.getUI());
        this.destroyWidgetInstance(n, widgetModel);
    }

    private void setupRelationship(int n, int n2, WidgetModel[] widgetModelArray) {
        int n3;
        short[] sArray = this.dataAccess.getRelationships(n, n2);
        for (int i2 = 0; i2 < sArray.length; i2 += n3 + 2) {
            n3 = sArray[i2 + 1];
            WidgetModel[] widgetModelArray2 = new WidgetModel[n3];
            for (int i3 = 0; i3 < n3; ++i3) {
                widgetModelArray2[i3] = widgetModelArray[sArray[i2 + i3 + 2]];
            }
            ContainerModel containerModel = (ContainerModel)widgetModelArray[sArray[i2]];
            containerModel.setChildren(widgetModelArray2);
        }
    }

    WidgetModel createWidgetInstance(int n) {
        return this.widgetFactory.getWidgetInstance(n);
    }

    private void destroyWidgetInstance(int n, WidgetModel widgetModel) {
        this.widgetFactory.releaseWidgetInstance(n, widgetModel);
    }

    @Override
    public void createViewSignalisation() {
        --this.dumingCounter;
        if (this.dumingCounter <= 0) {
            this.dump();
            this.dumingCounter = 10;
        }
    }

    private void dump() {
        if (this.isDumpEnabled()) {
            this.dump(this.widgetFactory);
            this.dump(this.controllerFactory);
            this.dump(this.uiFactory);
        }
    }

    private boolean isDumpEnabled() {
        return this.logger.isTraceEnabled(64);
    }

    private void dump(Object object) {
        if (object instanceof Dumpable) {
            ((Dumpable)object).dump(this.logger, 64);
        }
    }

    private WidgetController createControllerInstance(int n) {
        return this.controllerFactory.getControllerInstance(n);
    }

    private void destroyControllerInstance(int n, WidgetController widgetController) {
        this.controllerFactory.releaseControllerInstance(n, widgetController);
    }

    private WidgetUI createUIInstance(int n) {
        return this.uiFactory.getUIInstance(n);
    }

    private void destroyUIInstance(int n, WidgetUI widgetUI) {
        this.uiFactory.releaseUIInstance(n, widgetUI);
    }
}

