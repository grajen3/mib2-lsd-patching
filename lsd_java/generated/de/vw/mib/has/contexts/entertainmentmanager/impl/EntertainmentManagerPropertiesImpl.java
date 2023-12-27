/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.entertainmentmanager.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.contexts.entertainmentmanager.EntertainmentManagerProperties;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;

public class EntertainmentManagerPropertiesImpl
extends AbstractContextProperties
implements EntertainmentManagerProperties {
    public EntertainmentManagerPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateEntertainmentContext(int n) {
        this.updateProperty(58, 65, n);
    }
}

