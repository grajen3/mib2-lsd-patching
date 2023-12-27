/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages.setup;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.messages.ASLMessagingData;
import de.vw.mib.asl.internal.messages.setup.TargetASLPhoneMessagesSetup;
import de.vw.mib.asl.internal.messages.setup.TargetASLPhoneMessagesSetup$1;

class TargetASLPhoneMessagesSetup$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLPhoneMessagesSetup this$0;

    private TargetASLPhoneMessagesSetup$Reset(TargetASLPhoneMessagesSetup targetASLPhoneMessagesSetup) {
        this.this$0 = targetASLPhoneMessagesSetup;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (!ASLPhoneFactory.getPhoneApi().isCallsActive()) {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1243476736, ASLMessagingData.setDefaultAccount(0));
            this.this$0.dsiMessagingServiceConfiguration.restoreFactorySettingsRequest();
            TargetASLPhoneMessagesSetup.access$102(this.this$0, factoryResetCallback);
        } else if (factoryResetCallback != null) {
            factoryResetCallback.notifyResetDone();
        }
    }

    /* synthetic */ TargetASLPhoneMessagesSetup$Reset(TargetASLPhoneMessagesSetup targetASLPhoneMessagesSetup, TargetASLPhoneMessagesSetup$1 targetASLPhoneMessagesSetup$1) {
        this(targetASLPhoneMessagesSetup);
    }
}

