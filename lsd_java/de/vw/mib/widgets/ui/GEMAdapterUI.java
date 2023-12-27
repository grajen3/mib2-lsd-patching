/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractContext
 *  de.audi.gem.controller.ScreenController
 */
package de.vw.mib.widgets.ui;

import de.audi.gem.AbstractContext;
import de.audi.gem.controller.ScreenController;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.gem.VWGEMContext;
import de.vw.mib.widgets.gem.VWGEMGraphics;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.GEMAdapterModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.ui.ViewUI;

public final class GEMAdapterUI
extends ViewUI {
    private VWGEMGraphics gemGraphics;
    private VWGEMContext gemContext;
    private ScreenController gemScreen;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.gemScreen != null) {
            this.gemScreen.onExit();
            this.gemScreen = null;
        }
        if (this.gemContext != null) {
            this.gemContext.dispose();
            this.gemContext = null;
        }
        if (this.gemGraphics != null) {
            this.gemGraphics.dispose();
            this.gemGraphics = null;
        }
        super.deInit();
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        GEMAdapterModel gEMAdapterModel = (GEMAdapterModel)containerModel;
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
        if (this.gemScreen == null) {
            this.gemGraphics = new VWGEMGraphics(graphics3D, ServiceManager.imageManager, ServiceManager.fontManager, gEMAdapterModel.get_width(), gEMAdapterModel.get_height());
            this.gemContext = new VWGEMContext(ServiceManager.bundleContext, gEMAdapterModel.getGEMController(), this.gemGraphics);
            this.gemScreen = new ScreenController();
            this.gemScreen.onEnter((AbstractContext)this.gemContext);
        }
        this.gemScreen.render();
    }
}

