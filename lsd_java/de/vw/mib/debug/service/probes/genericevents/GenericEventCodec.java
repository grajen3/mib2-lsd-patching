/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.probes.genericevents;

import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.debugmanager.internal.AbstractProbeCodec;
import de.vw.mib.debugmanager.probes.ProbeSystemServices;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.log4mib.BinaryMessage;
import java.io.IOException;

public final class GenericEventCodec
extends AbstractProbeCodec {
    public GenericEventCodec(ProbeSystemServices probeSystemServices) {
        super(probeSystemServices);
    }

    public void encode(byte by, byte by2, int n, EventGeneric eventGeneric) {
        BinaryMessage binaryMessage = this.createMessage((byte)2);
        this.appendInvocation(binaryMessage, eventGeneric.getInvocationContext());
        binaryMessage.append(by);
        binaryMessage.append(by2);
        binaryMessage.append(n);
        binaryMessage.append(eventGeneric.getReceiverEventId());
        binaryMessage.append(eventGeneric.getReceiverTargetId());
        binaryMessage.append(eventGeneric.getSenderEventId());
        binaryMessage.append(eventGeneric.getSenderTargetId());
        binaryMessage.append(eventGeneric.getResult());
        this.appendSlots(binaryMessage, eventGeneric);
        binaryMessage.send();
    }

    private void appendSlots(BinaryMessage binaryMessage, EventGeneric eventGeneric) {
        IntSet intSet = eventGeneric.getParamIndexes();
        IntIterator intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            int n = intIterator.next();
            byte by = eventGeneric.getParamType(n);
            binaryMessage.append(n);
            binaryMessage.append(by);
            try {
                switch (by) {
                    case 0: {
                        break;
                    }
                    case 1: {
                        binaryMessage.append(eventGeneric.getInt(n));
                        break;
                    }
                    case 2: {
                        binaryMessage.append(eventGeneric.getBoolean(n));
                        break;
                    }
                    case 3: {
                        binaryMessage.append(eventGeneric.getFloat(n));
                        break;
                    }
                    case 4: {
                        binaryMessage.append(eventGeneric.getDouble(n));
                        break;
                    }
                    case 5: {
                        String string = eventGeneric.getString(n);
                        if (string != null) {
                            binaryMessage.append(true);
                            binaryMessage.append(string);
                            break;
                        }
                        binaryMessage.append(false);
                        break;
                    }
                    case 6: {
                        binaryMessage.append(eventGeneric.getByte(n));
                        break;
                    }
                    case 7: {
                        if (eventGeneric.getByteArray(n) != null) {
                            binaryMessage.append(true);
                            binaryMessage.append(eventGeneric.getByteArray(n));
                            break;
                        }
                        binaryMessage.append(false);
                        break;
                    }
                    case 8: {
                        binaryMessage.append(eventGeneric.getChar(n));
                        break;
                    }
                    case 9: {
                        break;
                    }
                    case 10: {
                        binaryMessage.append(eventGeneric.getLong(n));
                        break;
                    }
                    case 11: {
                        binaryMessage.append(eventGeneric.getShort(n));
                        break;
                    }
                    case 12: {
                        Object object = eventGeneric.getObject(n);
                        if (object != null) {
                            binaryMessage.append(true);
                            if (object.getClass().isArray()) {
                                binaryMessage.append(this.arrayToString(object));
                                break;
                            }
                            binaryMessage.append(object.toString());
                            break;
                        }
                        binaryMessage.append(false);
                        break;
                    }
                }
            }
            catch (GenericEventException genericEventException) {
                throw new IOException(genericEventException.toString());
            }
        }
    }

    @Override
    protected byte getCodecVersion() {
        return -6;
    }

    @Override
    protected short getConfigurationMessageType() {
        return 54;
    }

    @Override
    protected short getMessageType() {
        return 258;
    }
}

