/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.statemachine;

import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.log4mib.BinaryMessage;

public final class StatemachineCodec
extends AbstractProbeCodec {
    public StatemachineCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encodeActivatorChecked(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)3);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeActivatorChecking(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)4);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeConsumingEvent(HMIEvent hMIEvent) {
        BinaryMessage binaryMessage = this.createMessage((byte)5);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(hMIEvent.getType());
        binaryMessage.append(hMIEvent.getId());
        binaryMessage.send();
    }

    public void encodeCurrentStatemachine(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)6);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeDeactivatorChecked(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)7);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeDeactivatorChecking(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)8);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeEventForwardingToSelectedStatemachine(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)9);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeEventProcessed(int n, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)10);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    public void encodeEventProcessing(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)11);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeFatalError(int n, int n2, int n3, RuntimeException runtimeException) {
        BinaryMessage binaryMessage = this.createMessage((byte)12);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(runtimeException.getMessage());
        binaryMessage.send();
    }

    public void encodeInternalTransitionActed(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)13);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeInternalTransitionActing(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)14);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeInternalTransitionPerformed(int n, int n2, int n3, int n4, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)15);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    public void encodeInternalTransitionPerforming(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)16);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeManagerFinished(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)17);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeManagerStarted(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)18);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeSelectStatemachine(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)19);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeStateDoActed(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)20);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateDoActing(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)21);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateEntryActed(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)22);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateEntryActing(int n, int n2, int n3, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)23);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    public void encodeStateExitActed(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)24);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateExitActing(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)25);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateFocusGainedActed(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)26);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateFocusGainedActing(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)27);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateFocusLostActed(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)28);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStateFocusLostActing(int n, int n2, int n3) {
        BinaryMessage binaryMessage = this.createMessage((byte)29);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.send();
    }

    public void encodeStatemachineActivated(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)30);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeStatemachineActivating(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)31);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeStatemachineDeactivated(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)32);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeStatemachineDeactivating(int n) {
        BinaryMessage binaryMessage = this.createMessage((byte)33);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.send();
    }

    public void encodeSubStatemachineActivated(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)34);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeSubStatemachineActivating(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)35);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeSubStatemachineDeactivated(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)36);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeSubStatemachineDeactivating(int n, int n2) {
        BinaryMessage binaryMessage = this.createMessage((byte)37);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.send();
    }

    public void encodeTriggeredTransitionActed(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)38);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeTriggeredTransitionActing(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)39);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeTriggeredTransitionPerformed(int n, int n2, int n3, int n4, boolean bl) {
        BinaryMessage binaryMessage = this.createMessage((byte)40);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.append(bl);
        binaryMessage.send();
    }

    public void encodeTriggeredTransitionPerforming(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)41);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeUntriggeredTransitionActed(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)42);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeUntriggeredTransitionActing(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)43);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeUntriggeredTransitionPerformed(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)44);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    public void encodeUntriggeredTransitionPerforming(int n, int n2, int n3, int n4) {
        BinaryMessage binaryMessage = this.createMessage((byte)45);
        this.appendCurrentInvocation(binaryMessage);
        binaryMessage.append(n);
        binaryMessage.append(n2);
        binaryMessage.append(n3);
        binaryMessage.append(n4);
        binaryMessage.send();
    }

    @Override
    protected byte getCodecVersion() {
        return -6;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 58;
    }

    @Override
    protected short getMessageType() {
        return 265;
    }
}

