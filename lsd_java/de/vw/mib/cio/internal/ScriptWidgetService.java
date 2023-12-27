/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.framework.CioIntentVisualization;
import de.vw.mib.cio.framework.CioVisualizationChangeListener;
import de.vw.mib.cio.framework.CioVisualizationChangeService;
import de.vw.mib.cio.framework.CioVisualizationService;
import de.vw.mib.cio.framework.ScriptWidgetCioService;
import de.vw.mib.cio.internal.AbstractCio;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.Logger;

final class ScriptWidgetService
implements ScriptWidgetCioService,
CioVisualizationChangeService {
    private final Dictionary dictionary;
    private final Logger logger;
    private final CioVisualizationService visualizationService;
    private final CowArray listeners;

    ScriptWidgetService(Logger logger, Dictionary dictionary, CioVisualizationService cioVisualizationService) {
        this.logger = logger;
        this.dictionary = dictionary;
        this.visualizationService = cioVisualizationService;
        this.listeners = new CowArray();
    }

    @Override
    public Color[] getContextColors(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getContextColors();
    }

    @Override
    public Color[] getIconColors(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getIconColors();
    }

    @Override
    public Color[] getIconGlowColors(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getIconGlowColors();
    }

    @Override
    public Image[] getIcons(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getIcons();
    }

    @Override
    public String getText(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getText();
    }

    @Override
    public Color[] getTextColors(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getTextColors();
    }

    @Override
    public Color[] getTextGlowColors(long l) {
        CioIntentVisualization cioIntentVisualization = this.getVisualization(l);
        return cioIntentVisualization.getTextGlowColors();
    }

    @Override
    public void registerCioVisualizationChangeListener(CioVisualizationChangeListener cioVisualizationChangeListener) {
        this.listeners.addIfNotAlreadyIn(cioVisualizationChangeListener);
    }

    @Override
    public void unregisterCioVisualizationChangeListener(CioVisualizationChangeListener cioVisualizationChangeListener) {
        this.listeners.remove(cioVisualizationChangeListener);
    }

    private CioIntentVisualization getVisualization(long l) {
        AbstractCio abstractCio = this.dictionary.getCioIntentById(l);
        if (abstractCio == null) {
            this.logger.warn(8).append("Couldn't find cio intent visualization! Unknown cio intent id: ").append(l).log();
            return this.visualizationService.getVisualization(0L);
        }
        long l2 = abstractCio.getVisualizationId();
        return this.visualizationService.getVisualization(l2);
    }

    void notifyCioVisualizationChange(long l) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioVisualizationChangeListener)objectArray[i2]).cioVisualizationChanged(l);
        }
    }
}

