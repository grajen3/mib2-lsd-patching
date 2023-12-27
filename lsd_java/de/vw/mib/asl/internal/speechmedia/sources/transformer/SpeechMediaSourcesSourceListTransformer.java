/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.sources.transformer;

import de.vw.mib.asl.internal.speechmedia.sources.model.SourceModel;
import generated.de.vw.mib.asl.internal.speechmedia.sources.transformer.AbstractSpeechMediaSourcesSourceListTransformer;

public class SpeechMediaSourcesSourceListTransformer
extends AbstractSpeechMediaSourcesSourceListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        SourceModel sourceModel = (SourceModel)object;
        switch (n) {
            case 1: {
                return sourceModel.available;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public int getInt(int n, Object object) {
        SourceModel sourceModel = (SourceModel)object;
        switch (n) {
            case 0: {
                return sourceModel.id;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }

    @Override
    public long getLong(int n, Object object) {
        SourceModel sourceModel = (SourceModel)object;
        switch (n) {
            case 2: {
                return sourceModel.id;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Parameter columnID=").append(n).append(" can not be resolved. ").toString());
    }
}

