/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class CommandList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_COMMAND_ID_COMMAND_TEXT;
    public static final int RECORD_ADDRESS_COMMAND_ID;
    public static final int RECORD_ADDRESS_COMMAND_TEXT;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int commandId;
    public final BAPString commandText;
    private static final int MAX_COMMAND_TEXT_LENGTH;
    public final BAPString extension;
    private static final int MAX_EXTENSION_LENGTH;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public CommandList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.commandText = new BAPString(61);
        this.extension = new BAPString(2);
        this.internalReset();
        this.customInitialization();
    }

    public CommandList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.commandId = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.commandText.reset();
        this.extension.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CommandList_Data commandList_Data = (CommandList_Data)bAPEntity;
        return this.arrayHeader.equalTo(commandList_Data.arrayHeader) && this.pos == commandList_Data.pos && this.commandId == commandList_Data.commandId && this.commandText.equalTo(commandList_Data.commandText) && this.extension.equalTo(commandList_Data.extension);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CommandList_Data:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushShort((short)this.commandId);
                this.commandText.serialize(bitStream);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushShort((short)this.commandId);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.commandText.serialize(bitStream);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

