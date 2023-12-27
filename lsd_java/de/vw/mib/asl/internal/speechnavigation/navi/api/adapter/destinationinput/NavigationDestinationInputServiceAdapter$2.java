/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.speechengine.vde.Capabilities;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntryCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.NavigationDestinationInputServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;

class NavigationDestinationInputServiceAdapter$2
implements VoiceDestinationEntryCallback {
    private final /* synthetic */ INavigationLocation val$inputLocation;
    private final /* synthetic */ int[] val$possibleFields;
    private final /* synthetic */ NavigationDestinationInputServiceAdapter this$0;

    NavigationDestinationInputServiceAdapter$2(NavigationDestinationInputServiceAdapter navigationDestinationInputServiceAdapter, INavigationLocation iNavigationLocation, int[] nArray) {
        this.this$0 = navigationDestinationInputServiceAdapter;
        this.val$inputLocation = iNavigationLocation;
        this.val$possibleFields = nArray;
    }

    @Override
    public void setCapabilitiesResult(Capabilities capabilities) {
        String string = ServiceManager.configManagerDiag.getCurrentGuiLanguage();
        boolean bl = false;
        if (capabilities != null) {
            bl = this.this$0.checkLanguageDestinationCountryMatchesSystemLanguage(capabilities.getGrammarLanguage(), string);
        }
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            ServiceManager.logger2.trace(16384).append(new StringBuffer().append("ldcMatchesSl= ").append(bl).toString()).log();
        }
        Framework.updateUIValue(-1861733376, bl);
        this.this$0.speechCapabilities = capabilities;
        this.this$0.updateCountryChanged(this.val$inputLocation, this.this$0.speechCapabilities);
        this.this$0.initLocationCaller.release(0, this.val$inputLocation, this.val$possibleFields);
    }
}

