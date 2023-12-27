/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntryCallback;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;

class NavigationDestinationInputServiceAdapter$3
implements VoiceDestinationEntryCallback {
    private final /* synthetic */ INavigationLocation val$inputLocation;
    private final /* synthetic */ NavigationDestinationInputServiceAdapter this$0;

    NavigationDestinationInputServiceAdapter$3(NavigationDestinationInputServiceAdapter navigationDestinationInputServiceAdapter, INavigationLocation iNavigationLocation) {
        this.this$0 = navigationDestinationInputServiceAdapter;
        this.val$inputLocation = iNavigationLocation;
    }

    @Override
    public void setCapabilitiesResult(Capabilities capabilities) {
        this.this$0.speechCapabilities = capabilities;
        this.this$0.updateCountryChanged(this.val$inputLocation, this.this$0.speechCapabilities);
        if (AppLogger.isLoggingEnabled()) {
            AppLogger.trace(this, "updateInputState on startup SUCCESS");
        }
        NavigationDestinationInputServiceAdapter.access$000(this.this$0);
    }
}

