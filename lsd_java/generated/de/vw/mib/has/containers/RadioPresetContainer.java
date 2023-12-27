/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import org.dsi.ifc.global.ResourceLocator;

public interface RadioPresetContainer
extends HASContainer {
    default public ResourceLocator getPresetLogo() {
    }

    default public RadioStationInfoContainer getStation() {
    }

    default public boolean isPresetLogoSet() {
    }

    default public boolean isStationSet() {
    }

    default public void setPresetLogo(ResourceLocator resourceLocator) {
    }

    default public void setStation(RadioStationInfoContainer radioStationInfoContainer) {
    }

    default public void unsetPresetLogo() {
    }

    default public void unsetStation() {
    }
}

