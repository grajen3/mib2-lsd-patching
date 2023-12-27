/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioPresetContainerImpl
extends AbstractContainer
implements RadioPresetContainer {
    private static final byte ELEMENT_PRESET_LOGO;
    private static final byte ELEMENT_STATION;
    private ResourceLocator attrPresetLogo;
    private RadioStationInfoContainer attrStation;

    @Override
    public int getContainerId() {
        return 40;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public ResourceLocator getPresetLogo() {
        return this.attrPresetLogo;
    }

    @Override
    public RadioStationInfoContainer getStation() {
        return this.attrStation;
    }

    @Override
    public boolean isPresetLogoSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isStationSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public void setPresetLogo(ResourceLocator resourceLocator) {
        this.attrPresetLogo = resourceLocator;
        this._setElement((byte)0, null != resourceLocator);
    }

    @Override
    public void setStation(RadioStationInfoContainer radioStationInfoContainer) {
        this.attrStation = radioStationInfoContainer;
        this._setElement((byte)1, null != radioStationInfoContainer);
        if (null != radioStationInfoContainer) {
            radioStationInfoContainer.setElementId(90);
        }
    }

    @Override
    public void unsetPresetLogo() {
        this.attrPresetLogo = null;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetStation() {
        this.attrStation = null;
        this._setElement((byte)1, false);
    }
}

