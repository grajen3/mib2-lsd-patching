/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.messages2;

import de.vw.mib.asl.internal.speechphone.messages2.SpeechPhoneMessagesStartTarget;
import de.vw.mib.asl.internal.speechphone.messages2.start.MessagingActivator;
import de.vw.mib.asl.internal.speechphone.messages2.start.MessagingParameters;

public class MessagingComponentStarter
implements MessagingActivator {
    @Override
    public void activate(MessagingParameters messagingParameters) {
        new SpeechPhoneMessagesStartTarget(messagingParameters);
    }
}

