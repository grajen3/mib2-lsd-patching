/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessage;
import de.esolutions.fw.comm.core.message.AnnounceFeatureMessageV4;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV3;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV4;
import de.esolutions.fw.comm.core.message.CallMethodMessage;
import de.esolutions.fw.comm.core.message.CreateRRStubMessage;
import de.esolutions.fw.comm.core.message.CreateStubMessage;
import de.esolutions.fw.comm.core.message.DestroyStubMessage;
import de.esolutions.fw.comm.core.message.DropMessage;
import de.esolutions.fw.comm.core.message.ExitMessage;
import de.esolutions.fw.comm.core.message.HelloMessage;
import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.comm.core.message.InitMessageV4;
import de.esolutions.fw.comm.core.message.PingMessage;
import de.esolutions.fw.comm.core.message.ProxyAliveMessage;
import de.esolutions.fw.comm.core.message.RRStubCreatedMessage;
import de.esolutions.fw.comm.core.message.RawMessage;
import de.esolutions.fw.comm.core.message.RejectMessage;
import de.esolutions.fw.comm.core.message.SetFeatureMessage;
import de.esolutions.fw.comm.core.message.StubCreatedMessage;
import de.esolutions.fw.comm.core.message.StubFailedMessage;
import de.esolutions.fw.util.serializer.IDeserializer;

public class MessageType {
    private static final byte TYPE_INIT;
    private static final byte TYPE_ANNOUNCE_FEATURE;
    private static final byte TYPE_SET_FEATURE;
    private static final byte TYPE_CREATE_STUB;
    private static final byte TYPE_STUB_CREATED;
    private static final byte TYPE_DESTROY_STUB;
    private static final byte TYPE_CALL_METHOD;
    private static final byte TYPE_PROXY_ALIVE;
    private static final byte TYPE_EXIT;
    private static final byte TYPE_BROKER_ACK;
    private static final byte TYPE_DROP;
    private static final byte TYPE_STUB_FAILED;
    private static final byte TYPE_CREATE_RRSTUB;
    private static final byte TYPE_RRSTUB_CREATED;
    private static final byte TYPE_PING;
    private static final byte TYPE_HELLO;
    private static final byte TYPE_REJECT;
    public static final MessageType INIT;
    public static final MessageType ANNOUNCE_FEATURE;
    public static final MessageType SET_FEATURE;
    public static final MessageType CREATE_STUB;
    public static final MessageType STUB_CREATED;
    public static final MessageType DESTROY_STUB;
    public static final MessageType CALL_METHOD;
    public static final MessageType PROXY_ALIVE;
    public static final MessageType EXIT;
    public static final MessageType BROKER_ACK;
    public static final MessageType DROP;
    public static final MessageType STUB_FAILED;
    public static final MessageType CREATE_RRSTUB;
    public static final MessageType RRSTUB_CREATED;
    public static final MessageType PING;
    public static final MessageType HELLO;
    public static final MessageType REJECT;
    public static final String UNKNOWN_MESSAGE_STRING;
    private final byte type;

    private MessageType(byte by) {
        this.type = by;
    }

    public byte toByte() {
        return this.type;
    }

    public static MessageType getType(byte by) {
        MessageType messageType;
        switch (by) {
            case 0: {
                messageType = INIT;
                break;
            }
            case 1: {
                messageType = ANNOUNCE_FEATURE;
                break;
            }
            case 2: {
                messageType = SET_FEATURE;
                break;
            }
            case 3: {
                messageType = CREATE_STUB;
                break;
            }
            case 4: {
                messageType = STUB_CREATED;
                break;
            }
            case 5: {
                messageType = DESTROY_STUB;
                break;
            }
            case 6: {
                messageType = CALL_METHOD;
                break;
            }
            case 7: {
                messageType = PROXY_ALIVE;
                break;
            }
            case 8: {
                messageType = EXIT;
                break;
            }
            case 9: {
                messageType = BROKER_ACK;
                break;
            }
            case 10: {
                messageType = DROP;
                break;
            }
            case 11: {
                messageType = STUB_FAILED;
                break;
            }
            case 12: {
                messageType = CREATE_RRSTUB;
                break;
            }
            case 13: {
                messageType = RRSTUB_CREATED;
                break;
            }
            case 14: {
                messageType = PING;
                break;
            }
            case 16: {
                messageType = HELLO;
                break;
            }
            case 17: {
                messageType = REJECT;
                break;
            }
            default: {
                messageType = new MessageType(by);
            }
        }
        return messageType;
    }

    public AbstractMessage createMessage(IDeserializer iDeserializer, boolean bl, byte by) {
        switch (this.type) {
            case 0: {
                if (by < 4) {
                    return new InitMessage(iDeserializer, bl);
                }
                return new InitMessageV4(iDeserializer, bl);
            }
            case 1: {
                if (by < 4) {
                    return new AnnounceFeatureMessage(iDeserializer, bl);
                }
                return new AnnounceFeatureMessageV4(iDeserializer, bl);
            }
            case 2: {
                return new SetFeatureMessage(iDeserializer, bl);
            }
            case 3: {
                return new CreateStubMessage(iDeserializer, bl);
            }
            case 4: {
                return new StubCreatedMessage(iDeserializer, bl);
            }
            case 5: {
                return new DestroyStubMessage(iDeserializer, bl);
            }
            case 6: {
                return new CallMethodMessage(iDeserializer, bl);
            }
            case 7: {
                return new ProxyAliveMessage(iDeserializer, bl);
            }
            case 8: {
                return new ExitMessage(iDeserializer, bl);
            }
            case 9: {
                if (by < 3) {
                    return new BrokerAckMessage(iDeserializer, bl);
                }
                if (by == 3) {
                    return new BrokerAckMessageV3(iDeserializer, bl);
                }
                return new BrokerAckMessageV4(iDeserializer, bl);
            }
            case 10: {
                return new DropMessage(iDeserializer, bl);
            }
            case 11: {
                return new StubFailedMessage(iDeserializer, bl);
            }
            case 12: {
                return new CreateRRStubMessage(iDeserializer, bl);
            }
            case 13: {
                return new RRStubCreatedMessage(iDeserializer, bl);
            }
            case 14: {
                return new PingMessage(iDeserializer, bl);
            }
            case 16: {
                return new HelloMessage(iDeserializer, bl);
            }
            case 17: {
                return new RejectMessage(iDeserializer, bl);
            }
        }
        return new RawMessage(new MessageType(this.type), iDeserializer, bl);
    }

    public String toString() {
        switch (this.type) {
            case 0: {
                return "INIT";
            }
            case 1: {
                return "ANNOUNCE_FEATURE";
            }
            case 2: {
                return "SET_FEATURE";
            }
            case 3: {
                return "CREATE STUB";
            }
            case 4: {
                return "STUB_CREATED";
            }
            case 5: {
                return "DESTROY_STUB";
            }
            case 6: {
                return "CALL_METHOD";
            }
            case 7: {
                return "PROXY_ALIVE";
            }
            case 8: {
                return "EXIT";
            }
            case 9: {
                return "BROKER_ACK";
            }
            case 10: {
                return "DROP";
            }
            case 11: {
                return "STUB_FAILED";
            }
            case 12: {
                return "CREATE_RRSTUB";
            }
            case 13: {
                return "RRSTUB_CREATED";
            }
            case 14: {
                return "PING";
            }
            case 16: {
                return "HELLO";
            }
            case 17: {
                return "REJECT";
            }
        }
        return "UNKNOWN";
    }

    static {
        INIT = new MessageType(0);
        ANNOUNCE_FEATURE = new MessageType(1);
        SET_FEATURE = new MessageType(2);
        CREATE_STUB = new MessageType(3);
        STUB_CREATED = new MessageType(4);
        DESTROY_STUB = new MessageType(5);
        CALL_METHOD = new MessageType(6);
        PROXY_ALIVE = new MessageType(7);
        EXIT = new MessageType(8);
        BROKER_ACK = new MessageType(9);
        DROP = new MessageType(10);
        STUB_FAILED = new MessageType(11);
        CREATE_RRSTUB = new MessageType(12);
        RRSTUB_CREATED = new MessageType(13);
        PING = new MessageType(14);
        HELLO = new MessageType(16);
        REJECT = new MessageType(17);
    }
}

