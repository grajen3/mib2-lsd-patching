/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.appconnect.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.contexts.appconnect.AppConnectProperties;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;

public class AppConnectPropertiesImpl
extends AbstractContextProperties
implements AppConnectProperties {
    public AppConnectPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
        this.updateProperty(57, appConnectDeviceContainer);
    }
}

