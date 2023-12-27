/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.browser.transformer;

import de.vw.mib.asl.internal.mediacontrol.browser.transformer.MediaControlBrowserListTransformerEntry;
import generated.de.vw.mib.asl.internal.mediacontrol.browser.transformer.AbstractMediaControlBrowserListTransformer;

public class MediaControlBrowserListTransformer
extends AbstractMediaControlBrowserListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MediaControlBrowserListTransformerEntry mediaControlBrowserListTransformerEntry = (MediaControlBrowserListTransformerEntry)object;
        switch (n) {
            case 3: {
                return mediaControlBrowserListTransformerEntry.active;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }

    @Override
    public int getInt(int n, Object object) {
        MediaControlBrowserListTransformerEntry mediaControlBrowserListTransformerEntry = (MediaControlBrowserListTransformerEntry)object;
        switch (n) {
            case 0: {
                return mediaControlBrowserListTransformerEntry.contentType;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }

    @Override
    public String getString(int n, Object object) {
        MediaControlBrowserListTransformerEntry mediaControlBrowserListTransformerEntry = (MediaControlBrowserListTransformerEntry)object;
        switch (n) {
            case 4: {
                return mediaControlBrowserListTransformerEntry.id;
            }
            case 2: {
                return mediaControlBrowserListTransformerEntry.name;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }
}

