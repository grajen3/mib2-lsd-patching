/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.common;

import de.vw.mib.asl.internal.internetbrowser.states.IBrowserTarget;
import de.vw.mib.util.Util;
import generated.de.vw.mib.has.containers.AmbientLightContainer;

public final class HASPropertyReceiver {
    private IBrowserTarget _target;
    final String _classname = super.getClass().getName();
    private boolean isUpdateSkinInfoPending = false;
    private String pendingSkinID;
    private int resultCode4Skin;
    private boolean isUpdateAmbientLightPending = false;
    private AmbientLightContainer pendingAmbientLight;
    private int resultCode4AmbientLight;

    public void setTarget(IBrowserTarget iBrowserTarget) {
        this._target = iBrowserTarget;
        if (this.isUpdateSkinInfoPending) {
            this._target.getDSIBrowser().setPreference(144, 0, this.pendingSkinID);
            this.isUpdateSkinInfoPending = false;
        }
        if (this.isUpdateAmbientLightPending) {
            this._target.getDSIBrowser().setPreference(145, 0, this.pendingAmbientLight.getColorSRGB());
            this.isUpdateAmbientLightPending = false;
        }
    }

    public void updateSkinInfo(String string, int n) {
        if (this._target == null) {
            this.isUpdateSkinInfoPending = true;
        }
        if (!this.isUpdateSkinInfoPending) {
            if (!Util.isNullOrEmpty(string) && this._target.getDSIBrowser() != null) {
                this._target.getDSIBrowser().setPreference(144, 0, string);
            }
        } else {
            this.pendingSkinID = string;
            this.resultCode4Skin = n;
        }
    }

    public void updateAmbientLight(AmbientLightContainer ambientLightContainer, int n) {
        if (this._target == null) {
            this.isUpdateAmbientLightPending = true;
        }
        if (!this.isUpdateAmbientLightPending) {
            if (!Util.isNullOrEmpty(ambientLightContainer.getColorSRGB()) && this._target.getDSIBrowser() != null) {
                this._target.getDSIBrowser().setPreference(145, 0, ambientLightContainer.getColorSRGB());
            }
        } else {
            this.pendingAmbientLight = ambientLightContainer;
            this.resultCode4AmbientLight = n;
        }
    }

    public void retryUpdateSkinInfo() {
        this.updateSkinInfo(this.pendingSkinID, this.resultCode4Skin);
    }

    public void retryUpdateAmbientLight() {
        this.updateAmbientLight(this.pendingAmbientLight, this.resultCode4AmbientLight);
    }
}

