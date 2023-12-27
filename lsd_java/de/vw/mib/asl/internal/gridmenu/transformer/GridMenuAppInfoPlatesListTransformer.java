/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.gridmenu.transformer;

import de.vw.mib.asl.internal.gridmenu.api.impl.GridMenuServicesProvider;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.asl.internal.gridmenu.transformer.AbstractGridMenuAppInfoPlatesListTransformer;

public class GridMenuAppInfoPlatesListTransformer
extends AbstractGridMenuAppInfoPlatesListTransformer {
    private final Logger logger = GridMenuServicesProvider.getGridMenuServices().getLogger();

    @Override
    public long getLong(int n, Object object) {
        if (object instanceof CioIntent) {
            return ((CioIntent)object).getCioIntentId();
        }
        this.logger.error(2048, "Unexpected argument in grid menu list transformer");
        return 0L;
    }
}

