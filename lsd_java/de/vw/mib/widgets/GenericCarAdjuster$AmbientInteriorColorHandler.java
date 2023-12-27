/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.Disposable;
import de.vw.mib.configuration.internal.DefaultSkinInformationReceiver;
import de.vw.mib.graphics.Color;
import de.vw.mib.widgets.internal.ServiceManager;

final class GenericCarAdjuster$AmbientInteriorColorHandler
extends DefaultSkinInformationReceiver
implements Disposable {
    private Color ambietInteriorColor;

    public GenericCarAdjuster$AmbientInteriorColorHandler() {
        if (ServiceManager.skinInformationService != null) {
            ServiceManager.skinInformationService.addSkinInformationReceiver(this);
            this.ambietInteriorColor = new Color(0xFF | ServiceManager.skinInformationService.getAmbientInteriorColor());
        }
    }

    @Override
    public void receiveAmbientColor(int n) {
        this.ambietInteriorColor = new Color(0xFF | ServiceManager.skinInformationService.getAmbientInteriorColor());
    }

    public Color getAmbientInteriorColor() {
        return this.ambietInteriorColor;
    }

    @Override
    public void dispose() {
        if (ServiceManager.skinInformationService != null) {
            ServiceManager.skinInformationService.removeSkinInformationReceiver(this);
        }
    }
}

