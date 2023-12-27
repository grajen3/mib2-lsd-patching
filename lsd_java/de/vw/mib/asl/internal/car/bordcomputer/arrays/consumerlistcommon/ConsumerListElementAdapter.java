/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.bordcomputer.arrays.consumerlistcommon;

import de.vw.mib.asl.internal.car.bordcomputer.transformer.CarEcoConsumerIdCollector;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;

public class ConsumerListElementAdapter
extends CarEcoConsumerIdCollector
implements BAPArrayElement {
    private ArrayHeader _arrayHeader;
    private int _pos;

    public ConsumerListElementAdapter() {
        this(new ArrayHeader());
    }

    public ConsumerListElementAdapter(ArrayHeader arrayHeader) {
        super(0, 0);
        this._arrayHeader = arrayHeader;
    }

    public ConsumerListElementAdapter(BCmEConsumerList bCmEConsumerList, ArrayHeader arrayHeader) {
        super(bCmEConsumerList.consumer, 0);
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerList.listPosition;
    }

    public ConsumerListElementAdapter(BCmEConsumerListConsumptionRA0 bCmEConsumerListConsumptionRA0, ArrayHeader arrayHeader) {
        super(bCmEConsumerListConsumptionRA0.consumer, (int)((double)bCmEConsumerListConsumptionRA0.getConsumptionRelative() * 0.5));
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerListConsumptionRA0.pos;
    }

    public ConsumerListElementAdapter(BCmEConsumerListConsumptionRA1 bCmEConsumerListConsumptionRA1, ArrayHeader arrayHeader) {
        super(bCmEConsumerListConsumptionRA1.consumer, 0);
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerListConsumptionRA1.pos;
    }

    public ConsumerListElementAdapter(BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0, ArrayHeader arrayHeader) {
        super(bCmEConsumerListRangeRA0.consumer, (int)((double)bCmEConsumerListRangeRA0.getRangeGainSecondary() * 0.01));
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerListRangeRA0.pos;
    }

    public ConsumerListElementAdapter(BCmEConsumerListRangeRA1 bCmEConsumerListRangeRA1, ArrayHeader arrayHeader) {
        super(bCmEConsumerListRangeRA1.consumer, (int)((double)bCmEConsumerListRangeRA1.getRangeGainPrimary() * 0.01));
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerListRangeRA1.pos;
    }

    public ConsumerListElementAdapter(BCmEConsumerListRangeRA2 bCmEConsumerListRangeRA2, ArrayHeader arrayHeader) {
        super(bCmEConsumerListRangeRA2.consumer, (int)((double)bCmEConsumerListRangeRA2.getRangeGainSecondary() * 0.01));
        this._arrayHeader = arrayHeader;
        this._pos = bCmEConsumerListRangeRA2.pos;
    }

    public ConsumerListElementAdapter(ConsumerListElementAdapter consumerListElementAdapter) {
        super(consumerListElementAdapter.consumerId, consumerListElementAdapter.rangeValue);
        this._arrayHeader = consumerListElementAdapter.getArrayHeader();
        this._pos = consumerListElementAdapter.getPos();
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public int getPos() {
        return this._pos;
    }

    @Override
    public void setPos(int n) {
        this._pos = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this._arrayHeader;
    }
}

