/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.gem.AbstractContext
 *  de.audi.gem.AbstractGraphicsIFC
 *  de.audi.gem.ControllerIFC
 */
package de.vw.mib.widgets.gem;

import de.audi.gem.AbstractContext;
import de.audi.gem.AbstractGraphicsIFC;
import de.audi.gem.ControllerIFC;
import de.vw.mib.Disposable;
import de.vw.mib.widgets.gem.VWGEMController;
import de.vw.mib.widgets.gem.VWGEMGraphics;
import org.osgi.framework.BundleContext;

public final class VWGEMContext
extends AbstractContext
implements Disposable {
    private final VWGEMController controller;
    private final VWGEMGraphics graphics;

    public VWGEMContext(BundleContext bundleContext, VWGEMController vWGEMController, VWGEMGraphics vWGEMGraphics) {
        VWGEMContext.setBundleContext((BundleContext)bundleContext);
        this.controller = vWGEMController;
        this.graphics = vWGEMGraphics;
    }

    @Override
    public void dispose() {
    }

    public int getTerminalID() {
        return 0;
    }

    public ControllerIFC getEngineeringController() {
        return this.controller;
    }

    public AbstractGraphicsIFC getGraphics() {
        return this.graphics;
    }
}

