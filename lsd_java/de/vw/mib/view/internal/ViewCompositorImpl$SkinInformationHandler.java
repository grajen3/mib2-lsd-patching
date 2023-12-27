/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.view.internal;

import de.vw.mib.Disposable;
import de.vw.mib.configuration.internal.DefaultSkinInformationReceiver;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.widgets.internal.ServiceManager;

final class ViewCompositorImpl$SkinInformationHandler
extends DefaultSkinInformationReceiver
implements Disposable {
    private boolean invalid;

    public ViewCompositorImpl$SkinInformationHandler() {
        ServiceManager.skinInformationService.addSkinInformationReceiver(this);
        this.updateGlobalDynamicColor();
        Color.setDayNightMode(ServiceManager.skinInformationService.getCurrentSkinMode());
    }

    @Override
    public void dispose() {
        ServiceManager.skinInformationService.removeSkinInformationReceiver(this);
    }

    @Override
    public void receiveAmbientColor(int n) {
        this.updateGlobalDynamicColor();
        this.invalidate();
    }

    @Override
    public void receiveAmbientColorEnabled(boolean bl) {
        this.updateGlobalDynamicColor();
        this.invalidate();
    }

    @Override
    public void receiveCurrentSkinMode(int n) {
        Color.setDayNightMode(n);
        this.invalidate();
    }

    private void invalidate() {
        if (!this.invalid) {
            this.invalid = true;
            ServiceManager.repaintManager.repaint();
        }
    }

    private void updateGlobalDynamicColor() {
        if (ServiceManager.skinInformationService.isAmbientColorEnabled()) {
            int n = 0xFF | ServiceManager.skinInformationService.getAmbientColor();
            Color.setGlobalDynamicColor(new Color4b(n));
        } else {
            Color.setGlobalDynamicColor(null);
        }
    }

    public boolean validate() {
        if (this.invalid) {
            this.invalid = false;
            return true;
        }
        return false;
    }
}

