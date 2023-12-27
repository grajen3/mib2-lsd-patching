/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sat.transformer;

import de.vw.mib.asl.internal.radio.sat.transformer.SimilarContentCollector;
import generated.de.vw.mib.asl.internal.radio.sat.transformer.AbstractRadioSATSATSimilarContentListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class RadioSATSATSimilarContentListTransformer
extends AbstractRadioSATSATSimilarContentListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        SimilarContentCollector similarContentCollector = (SimilarContentCollector)object;
        switch (n) {
            case 9: {
                super.getClass();
                return false;
            }
        }
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        SimilarContentCollector similarContentCollector = (SimilarContentCollector)object;
        switch (n) {
            case 3: {
                return similarContentCollector.mImage;
            }
        }
        return new ResourceLocator();
    }

    @Override
    public String getString(int n, Object object) {
        SimilarContentCollector similarContentCollector = (SimilarContentCollector)object;
        switch (n) {
            case 0: {
                return similarContentCollector.mArtistName;
            }
            case 1: {
                return similarContentCollector.mChannelName;
            }
            case 2: {
                return similarContentCollector.mChannelNumber;
            }
            case 4: {
                super.getClass();
                return "";
            }
            case 5: {
                super.getClass();
                return "";
            }
            case 6: {
                return similarContentCollector.mSongName;
            }
            case 7: {
                super.getClass();
                return "";
            }
            case 8: {
                super.getClass();
                return "";
            }
        }
        return "";
    }
}

