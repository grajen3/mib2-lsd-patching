/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui.cio;

import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import de.vw.mib.cio.framework.CioVisualizationService;
import de.vw.mib.collections.longs.LongIntMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.Preconditions;

public abstract class AbstractCioVisualizationService
implements CioVisualizationService {
    protected static final int NONE_VISUALIZATION_INDEX;
    private final String appName;
    private final String appInstanceName;
    private final LongIntMap visualizations;

    protected AbstractCioVisualizationService(String string, String string2, int n) {
        this.appName = string;
        this.appInstanceName = string2;
        this.visualizations = LongIntOptHashMap.createWithNeutralValue(n, 1.0f, 0.0f, -1);
    }

    @Override
    public final void load(CioIdService cioIdService) {
        this.visualizations.clear();
        this.loadMapping(cioIdService);
    }

    @Override
    public final void loadDone() {
    }

    @Override
    public final CioIntentVisualization getVisualization(long l) {
        int n = this.getVisualizationIndex(l);
        return this.getVisualizationByIndex(n);
    }

    protected final void putIndexIdMapping(int n, CioIdService cioIdService, String string, String string2) {
        Preconditions.checkArgument(n == this.visualizations.size(), "Index out of order.");
        long l = cioIdService.getCioVisualizationId(this.appName, this.appInstanceName, string, string2);
        this.visualizations.put(l, n);
    }

    private int getVisualizationIndex(long l) {
        return this.visualizations.get(l);
    }

    protected abstract void loadMapping(CioIdService cioIdService) {
    }

    protected abstract CioIntentVisualization getVisualizationByIndex(int n) {
    }

    protected final CioIntentVisualization defaultVisualization() {
        return CioIntentVisualizationImpl.DEFAULT;
    }

    protected final CioIntentVisualization visualizationNotAvailable() {
        return CioIntentVisualizationImpl.NOT_AVAILABLE;
    }

    protected String getI18nString(int n) {
        return ServiceManagerCommon.i18nDatapool.getString(n);
    }

    protected Image[] getImageArray(int n) {
        return ServiceManagerCommon.skinImagePool.getImageArray(n);
    }
}

