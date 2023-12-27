/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.browser.transformer;

import de.vw.mib.asl.internal.mediacontrol.transformer.MediaControlDeviceListTransformerEntry;
import generated.de.vw.mib.asl.internal.mediacontrol.transformer.AbstractMediaControlDeviceListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MediaControlDeviceListTransformer
extends AbstractMediaControlDeviceListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MediaControlDeviceListTransformerEntry mediaControlDeviceListTransformerEntry = (MediaControlDeviceListTransformerEntry)object;
        switch (n) {
            case 4: {
                return mediaControlDeviceListTransformerEntry.selected;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }

    @Override
    public int getInt(int n, Object object) {
        MediaControlDeviceListTransformerEntry mediaControlDeviceListTransformerEntry = (MediaControlDeviceListTransformerEntry)object;
        switch (n) {
            case 3: {
                return mediaControlDeviceListTransformerEntry.playbackState;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        MediaControlDeviceListTransformerEntry mediaControlDeviceListTransformerEntry = (MediaControlDeviceListTransformerEntry)object;
        switch (n) {
            case 0: {
                return mediaControlDeviceListTransformerEntry.cover;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }

    @Override
    public String getString(int n, Object object) {
        MediaControlDeviceListTransformerEntry mediaControlDeviceListTransformerEntry = (MediaControlDeviceListTransformerEntry)object;
        switch (n) {
            case 1: {
                return mediaControlDeviceListTransformerEntry.id;
            }
            case 5: {
                return mediaControlDeviceListTransformerEntry.name;
            }
        }
        throw new IllegalArgumentException("The given columnId is not implemented");
    }
}

