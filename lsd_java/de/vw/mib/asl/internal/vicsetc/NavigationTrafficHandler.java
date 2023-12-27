/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.traffic.INavRectangle;
import de.vw.mib.asl.api.navigation.traffic.IResourceLocatorExtern;
import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITrafficSource;
import de.vw.mib.asl.api.navigation.traffic.NavigationTrafficListenerAdapter;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.asl.internal.vicsetc.VicsVenmMessage;

public class NavigationTrafficHandler
extends NavigationTrafficListenerAdapter {
    private final VicsTarget target;

    public NavigationTrafficHandler(VicsTarget vicsTarget) {
        this.target = vicsTarget;
    }

    @Override
    public void indicateTrafficEventNoticeMap(ITmcMessage iTmcMessage, INavRectangle iNavRectangle, int n) {
        this.target.traceMsg(new StringBuffer().append("New emergency Event received! \nTmcMessage: ").append(iTmcMessage).append("\nNavRectangle: ").append(iNavRectangle).append("\nSoundID: ").append(n).toString(), this);
        this.target.venmHandler.addVenmMessageToStack(new VicsVenmMessage(false, iTmcMessage, iNavRectangle, n, null));
        this.target.venmHandler.requestResourceLocatorForTmcIcon();
    }

    @Override
    public void updateResourceIdForTMCEventIcon(IResourceLocatorExtern iResourceLocatorExtern) {
        super.updateResourceIdForTMCEventIcon(iResourceLocatorExtern);
        this.target.venmHandler.handleVenmMessageReceived(iResourceLocatorExtern);
    }

    @Override
    public void updateUrgentMessages(ITmcMessage[] iTmcMessageArray, boolean bl) {
        this.target.traceMsg(new StringBuffer().append("New emergency Events received! \nTmcMessage: ").append(iTmcMessageArray).append("\nValidFlag: ").append(bl).toString(), this);
        if (bl) {
            for (int i2 = 0; i2 < iTmcMessageArray.length; ++i2) {
                ITmcMessage iTmcMessage = iTmcMessageArray[i2];
                this.target.venmHandler.addVenmMessageToStack(new VicsVenmMessage(true, iTmcMessage, null, -1, iTmcMessage.getTmcPhoneme()));
            }
            this.target.venmHandler.requestResourceLocatorForTmcIcon();
        }
    }

    @Override
    public void updateTrafficSourceInformation(ITrafficSource[] iTrafficSourceArray, boolean bl) {
        this.target.traceMsg(new StringBuffer().append("New traffic source information received! \nTrafficSources: ").append(iTrafficSourceArray).append("\nValidFlag: ").append(bl).toString(), this);
        if (!bl) {
            return;
        }
        for (int i2 = 0; i2 < iTrafficSourceArray.length; ++i2) {
            if (iTrafficSourceArray[i2].getTrafficSourceType() != 4) continue;
            this.target.handleServiceOnlineTrafficAvailable();
            return;
        }
        this.target.handleServiceOnlineTrafficNotAvailable();
    }
}

