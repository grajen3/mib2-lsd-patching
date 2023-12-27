/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.DroppedDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExecuteCallbackMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExitMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileRequestMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileStatusMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileTransferMessage;
import de.esolutions.fw.util.tracing.protocol.message.InitMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.LoggerDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.LoggerTimeMessage;
import de.esolutions.fw.util.tracing.protocol.message.RawMessage;
import de.esolutions.fw.util.tracing.protocol.message.RegisterTimezoneMessage;
import de.esolutions.fw.util.tracing.protocol.message.SyncMarkerMessage;
import de.esolutions.fw.util.tracing.protocol.message.TimeSyncMessage;
import de.esolutions.fw.util.tracing.protocol.message.ToggleEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.UpdateTimezoneMessage;

public class MessageType {
    public static final byte TYPE_INIT;
    public static final byte TYPE_EXIT;
    public static final byte TYPE_TIME_SYNC;
    public static final byte TYPE_CREATE_ENTITY;
    public static final byte TYPE_LOG_DATA;
    public static final byte TYPE_DROPPED_DATA;
    public static final byte TYPE_TOGGLE_ENTITY;
    public static final byte TYPE_CHANGE_LEVEL;
    public static final byte TYPE_EXECUTE_CALLBACK;
    public static final byte TYPE_REGISTER_TIMEZONE;
    public static final byte TYPE_UPDATE_TIMEZONE;
    public static final byte TYPE_SYNC_MARKER;
    public static final byte TYPE_FILE_REQUEST;
    public static final byte TYPE_FILE_STATUS;
    public static final byte TYPE_FILE_TRANSFER;
    public static final byte TYPE_LOGGER_TIME;
    public static final byte TYPE_LOGGER_DATA;
    public static final byte TYPE_BULK_CREATE_ENTITY;
    public static final byte TYPE_BULK_LOG_DATA;
    public static final byte TYPE_BULK_CHANGE_LEVEL;
    public static final byte TYPE_MLP;
    public static final MessageType INIT;
    public static final MessageType EXIT;
    public static final MessageType TIME_SYNC;
    public static final MessageType CREATE_ENTITY;
    public static final MessageType LOG_DATA;
    public static final MessageType DROPPED_DATA;
    public static final MessageType TOGGLE_ENTITY;
    public static final MessageType CHANGE_LEVEL;
    public static final MessageType EXECUTE_CALLBACK;
    public static final MessageType REGISTER_TIMEZONE;
    public static final MessageType UPDATE_TIMEZONE;
    public static final MessageType SYNC_MARKER;
    public static final MessageType LOGGER_TIME;
    public static final MessageType LOGGER_DATA;
    public static final MessageType FILE_REQUEST;
    public static final MessageType FILE_STATUS;
    public static final MessageType FILE_TRANSFER;
    public static final MessageType BULK_CREATE_ENTITY;
    public static final MessageType BULK_LOG_DATA;
    public static final MessageType BULK_CHANGE_LEVEL;
    public static final MessageType MLP;
    public static final MessageType[] ALL_MESSAGE_TYPES;
    private byte type;

    public MessageType(byte by) {
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
                messageType = EXIT;
                break;
            }
            case 2: {
                messageType = TIME_SYNC;
                break;
            }
            case 3: {
                messageType = CREATE_ENTITY;
                break;
            }
            case 4: {
                messageType = LOG_DATA;
                break;
            }
            case 5: {
                messageType = DROPPED_DATA;
                break;
            }
            case 16: {
                messageType = TOGGLE_ENTITY;
                break;
            }
            case 17: {
                messageType = CHANGE_LEVEL;
                break;
            }
            case 18: {
                messageType = EXECUTE_CALLBACK;
                break;
            }
            case 19: {
                messageType = REGISTER_TIMEZONE;
                break;
            }
            case 20: {
                messageType = UPDATE_TIMEZONE;
                break;
            }
            case 21: {
                messageType = SYNC_MARKER;
                break;
            }
            case 32: {
                messageType = LOGGER_TIME;
                break;
            }
            case 33: {
                messageType = LOGGER_DATA;
                break;
            }
            case 22: {
                messageType = FILE_REQUEST;
                break;
            }
            case 23: {
                messageType = FILE_STATUS;
                break;
            }
            case 24: {
                messageType = FILE_TRANSFER;
                break;
            }
            case 48: {
                messageType = BULK_CREATE_ENTITY;
                break;
            }
            case 49: {
                messageType = BULK_LOG_DATA;
                break;
            }
            case 50: {
                messageType = BULK_CHANGE_LEVEL;
                break;
            }
            case -128: {
                messageType = MLP;
                break;
            }
            default: {
                messageType = new MessageType(by);
            }
        }
        return messageType;
    }

    public AbstractMessage createMessage() {
        switch (this.type) {
            case 0: {
                return new InitMessage();
            }
            case 1: {
                return new ExitMessage();
            }
            case 2: {
                return new TimeSyncMessage();
            }
            case 3: {
                return new CreateEntityMessage();
            }
            case 4: {
                return new LogDataMessage();
            }
            case 5: {
                return new DroppedDataMessage();
            }
            case 16: {
                return new ToggleEntityMessage();
            }
            case 17: {
                return new ChangeLevelMessage();
            }
            case 18: {
                return new ExecuteCallbackMessage();
            }
            case 19: {
                return new RegisterTimezoneMessage();
            }
            case 20: {
                return new UpdateTimezoneMessage();
            }
            case 21: {
                return new SyncMarkerMessage();
            }
            case 32: {
                return new LoggerTimeMessage();
            }
            case 33: {
                return new LoggerDataMessage();
            }
            case 22: {
                return new FileRequestMessage();
            }
            case 23: {
                return new FileStatusMessage();
            }
            case 24: {
                return new FileTransferMessage();
            }
            case 48: {
                return new CreateEntityBulkMessage();
            }
            case 49: {
                return new LogDataBulkMessage();
            }
            case 50: {
                return new ChangeLevelBulkMessage();
            }
            case -128: {
                return new RawMessage(-128);
            }
        }
        return new RawMessage(this.type);
    }

    public String toString() {
        switch (this.type) {
            case 0: {
                return "INIT";
            }
            case 1: {
                return "EXIT";
            }
            case 2: {
                return "TIME_SYNC";
            }
            case 3: {
                return "CREATE_ENTITY";
            }
            case 4: {
                return "LOG_DATA";
            }
            case 5: {
                return "DROPPED_DATA";
            }
            case 16: {
                return "TOGGLE_ENTITY";
            }
            case 17: {
                return "CHANGE_LEVEL";
            }
            case 18: {
                return "EXECUTE_CALLBACK";
            }
            case 19: {
                return "REGISTER_TIMEZONE";
            }
            case 20: {
                return "UPDATE_TIMEZONE";
            }
            case 21: {
                return "SYNC_MARKER";
            }
            case 32: {
                return "LOGGER_TIME";
            }
            case 33: {
                return "LOGGER_DATA";
            }
            case 22: {
                return "FILE_REQUEST";
            }
            case 23: {
                return "FILE_STATUS";
            }
            case 24: {
                return "FILE_TRANSFER";
            }
            case 48: {
                return "BULK_CREATE_ENTITY";
            }
            case 49: {
                return "BULK_LOG_DATA";
            }
            case 50: {
                return "BULK_CHANGE_LEVEL";
            }
            case -128: {
                return "MLP";
            }
        }
        return "UNKNOWN";
    }

    public int hashCode() {
        int n = 1;
        return n += 17 * this.type;
    }

    public boolean equals(Object object) {
        if (!(object instanceof MessageType)) {
            return false;
        }
        MessageType messageType = (MessageType)object;
        return messageType.type == this.type;
    }

    static {
        INIT = new MessageType(0);
        EXIT = new MessageType(1);
        TIME_SYNC = new MessageType(2);
        CREATE_ENTITY = new MessageType(3);
        LOG_DATA = new MessageType(4);
        DROPPED_DATA = new MessageType(5);
        TOGGLE_ENTITY = new MessageType(16);
        CHANGE_LEVEL = new MessageType(17);
        EXECUTE_CALLBACK = new MessageType(18);
        REGISTER_TIMEZONE = new MessageType(19);
        UPDATE_TIMEZONE = new MessageType(20);
        SYNC_MARKER = new MessageType(21);
        LOGGER_TIME = new MessageType(32);
        LOGGER_DATA = new MessageType(33);
        FILE_REQUEST = new MessageType(22);
        FILE_STATUS = new MessageType(23);
        FILE_TRANSFER = new MessageType(24);
        BULK_CREATE_ENTITY = new MessageType(48);
        BULK_LOG_DATA = new MessageType(49);
        BULK_CHANGE_LEVEL = new MessageType(50);
        MLP = new MessageType(-128);
        ALL_MESSAGE_TYPES = new MessageType[]{INIT, EXIT, TIME_SYNC, LOG_DATA, DROPPED_DATA, TOGGLE_ENTITY, EXECUTE_CALLBACK, REGISTER_TIMEZONE, UPDATE_TIMEZONE, SYNC_MARKER, LOGGER_TIME, LOGGER_DATA, CHANGE_LEVEL, CREATE_ENTITY, FILE_REQUEST, FILE_STATUS, FILE_TRANSFER, BULK_CREATE_ENTITY, BULK_LOG_DATA, BULK_CHANGE_LEVEL, MLP};
    }
}

