/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.exlap.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASDatapool;
import generated.de.vw.mib.has.contexts.exlap.ExlapProperties;
import generated.de.vw.mib.has.contexts.impl.AbstractContextProperties;

public class ExlapPropertiesImpl
extends AbstractContextProperties
implements ExlapProperties {
    public ExlapPropertiesImpl(HASDatapool hASDatapool, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASDatapool, hASBaseContainerFactory);
    }

    @Override
    public void updateExlapRestrictionMode(int n) {
        this.updateProperty(30, 38, n);
    }
}

