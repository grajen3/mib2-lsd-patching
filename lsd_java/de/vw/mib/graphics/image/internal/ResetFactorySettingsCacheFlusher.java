/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.event.RestoreFactorySettingsEvent;
import de.vw.mib.event.consumer.RestoreFactorySettingsEventConsumer;
import de.vw.mib.graphics.image.ImageManager;

public final class ResetFactorySettingsCacheFlusher
implements RestoreFactorySettingsEventConsumer {
    private final ImageManager imageManager;

    public ResetFactorySettingsCacheFlusher(ImageManager imageManager) {
        this.imageManager = imageManager;
    }

    @Override
    public void consumeEvent(RestoreFactorySettingsEvent restoreFactorySettingsEvent) {
        this.imageManager.flushDynamicImageCache();
    }
}

