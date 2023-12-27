/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.collections.HashCodeBuilder;

final class IdService
implements CioIdService {
    private final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

    IdService() {
    }

    @Override
    public long getCioIntentId(String string, String string2, String string3, String string4, String string5) {
        return this.getCioIntentIdAsHashCode(string, string2, string3, string4, string5);
    }

    @Override
    public long getCioVisualizationId(String string, String string2, String string3, String string4) {
        return this.getCioVisualizationIdAsHashCode(string, string2, string3, string4);
    }

    @Override
    public long getUniqueCioIntentId(CioIntent cioIntent) {
        AbstractCio abstractCio = (AbstractCio)cioIntent;
        String string = abstractCio.getCioIntentClass();
        String string2 = abstractCio.getCioIntentName();
        String string3 = abstractCio.getCioName();
        return this.getUniqueCioIntentIdAsHashCode(string, string3, string2);
    }

    private synchronized long getCioIntentIdAsHashCode(String string, String string2, String string3, String string4, String string5) {
        this.hashCodeBuilder.reset();
        this.hashCodeBuilder.append(string);
        this.hashCodeBuilder.append(string2);
        this.hashCodeBuilder.append(string3);
        this.hashCodeBuilder.append(string4);
        this.hashCodeBuilder.append(string5);
        long l = this.hashCodeBuilder.longHashCode();
    }

    private synchronized long getCioVisualizationIdAsHashCode(String string, String string2, String string3, String string4) {
        this.hashCodeBuilder.reset();
        this.hashCodeBuilder.append(string);
        this.hashCodeBuilder.append(string2);
        this.hashCodeBuilder.append(string3);
        this.hashCodeBuilder.append(string4);
        long l = this.hashCodeBuilder.longHashCode();
    }

    private synchronized long getUniqueCioIntentIdAsHashCode(String string, String string2, String string3) {
        this.hashCodeBuilder.reset();
        this.hashCodeBuilder.append(string);
        this.hashCodeBuilder.append(string2);
        this.hashCodeBuilder.append(string3);
        long l = this.hashCodeBuilder.longHashCode();
    }
}

