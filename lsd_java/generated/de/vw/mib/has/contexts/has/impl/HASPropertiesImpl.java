/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.has.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.containers.ContextStatesContainer;
import generated.de.vw.mib.has.contexts.has.HASProperties;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;

public class HASPropertiesImpl
extends AbstractContextProperties
implements HASProperties {
    public HASPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateContextStates(ContextStatesContainer contextStatesContainer) {
        this.updateProperty(1, contextStatesContainer);
    }
}

