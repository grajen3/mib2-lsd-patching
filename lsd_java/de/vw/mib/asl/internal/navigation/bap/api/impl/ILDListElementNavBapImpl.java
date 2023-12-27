/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.bap.api.impl;

import de.vw.mib.asl.api.navbap.ILDListElementNavBap;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.navigation.LDListElement;

public class ILDListElementNavBapImpl
implements ILDListElementNavBap {
    private String title;
    private long id;

    public ILDListElementNavBapImpl(LDListElement lDListElement) {
        if (lDListElement != null) {
            this.title = lDListElement.getTitle();
            this.id = lDListElement.getId();
        } else {
            ServiceManager.logger.error(16384, "[ILDListElementNavBapImpl] ldListElement was null");
        }
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public long getId() {
        return this.id;
    }
}

