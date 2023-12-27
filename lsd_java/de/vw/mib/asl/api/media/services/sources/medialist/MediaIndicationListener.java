/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources.medialist;

import de.vw.mib.asl.api.media.services.sources.medialist.Source;

public interface MediaIndicationListener {
    default public void onSourceChanged(Source source, Source source2) {
    }
}

