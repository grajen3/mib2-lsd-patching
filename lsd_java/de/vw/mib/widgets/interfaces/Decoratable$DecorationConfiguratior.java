/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.widgets.ui.util.EffectDecorator;
import de.vw.mib.widgets.ui.util.decoration.ConvolutionDecoration;

public final class Decoratable$DecorationConfiguratior {
    private static int FILTER_SIZE_SOFT = 10;
    private static int FILTER_SIZE_STRONG = 15;

    public static void configureDecoration(int n, EffectDecorator effectDecorator) {
        effectDecorator.resetDecoration();
        switch (n) {
            case 2: {
                ConvolutionDecoration convolutionDecoration = effectDecorator.addConvolutionDecoration();
                convolutionDecoration.setFilterType(1);
                convolutionDecoration.setFilterSize(FILTER_SIZE_SOFT, FILTER_SIZE_SOFT);
                break;
            }
            case 1: {
                ConvolutionDecoration convolutionDecoration = effectDecorator.addConvolutionDecoration();
                convolutionDecoration.setFilterType(1);
                convolutionDecoration.setFilterSize(FILTER_SIZE_STRONG, FILTER_SIZE_STRONG);
                break;
            }
            default: {
                effectDecorator.addNullDecoration();
            }
        }
    }
}

