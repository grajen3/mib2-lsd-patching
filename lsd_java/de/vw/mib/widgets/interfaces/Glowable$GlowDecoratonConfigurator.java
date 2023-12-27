/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.interfaces;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.widgets.ui.util.EffectDecorator;
import de.vw.mib.widgets.ui.util.decoration.ConvolutionDecoration;

public final class Glowable$GlowDecoratonConfigurator {
    public static void configureGlowEffect(int n, EffectDecorator effectDecorator, Color4b color4b) {
        effectDecorator.resetDecoration();
        switch (n) {
            case 5: {
                ConvolutionDecoration convolutionDecoration = effectDecorator.addConvolutionDecoration();
                convolutionDecoration.setFilterType(1);
                convolutionDecoration.setFilterSize(11, 11);
                convolutionDecoration.setIntensity(0x3333F33F);
                convolutionDecoration.setGlowEnabled(true);
                convolutionDecoration.setGlowColor(color4b);
                effectDecorator.addOutlineDecoration();
                break;
            }
            case 4: {
                ConvolutionDecoration convolutionDecoration = effectDecorator.addConvolutionDecoration();
                convolutionDecoration.setFilterType(1);
                convolutionDecoration.setFilterSize(17, 17);
                convolutionDecoration.setIntensity(8256);
                convolutionDecoration.setGlowEnabled(true);
                convolutionDecoration.setGlowColor(color4b);
                break;
            }
            case 3: {
                ConvolutionDecoration convolutionDecoration = effectDecorator.addConvolutionDecoration();
                convolutionDecoration.setFilterType(1);
                convolutionDecoration.setFilterSize(17, 17);
                convolutionDecoration.setIntensity(2.0f);
                convolutionDecoration.setGlowEnabled(true);
                convolutionDecoration.setGlowColor(color4b);
                break;
            }
            default: {
                effectDecorator.addEllipseDecotraion();
                effectDecorator.addOutlineDecoration();
            }
        }
    }
}

