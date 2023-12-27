/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.arrays.powerprovider;

import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlPowerProviderCollector;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;

public class PowerProviderListArrayElementAdapter
extends BatteryControlPowerProviderCollector
implements BAPArrayElement {
    private ArrayHeader _arrayHeader;

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader, int n, int n2, int n3, int n4, int n5) {
        super(n, n2, n3, n4, n5);
        this._arrayHeader = arrayHeader;
    }

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    public PowerProviderListArrayElementAdapter() {
        this._arrayHeader = new ArrayHeader();
    }

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlPowerProviderRA0 batteryControlPowerProviderRA0) {
        this(arrayHeader, batteryControlPowerProviderRA0.pos, batteryControlPowerProviderRA0.nrStartHour, batteryControlPowerProviderRA0.nrStartMinute, batteryControlPowerProviderRA0.nrEndHour, batteryControlPowerProviderRA0.nrEndMinute);
    }

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlPowerProviderRA1 batteryControlPowerProviderRA1) {
        this(arrayHeader, batteryControlPowerProviderRA1.pos, batteryControlPowerProviderRA1.nrStartHour, batteryControlPowerProviderRA1.nrStartMinute, batteryControlPowerProviderRA1.nrEndHour, batteryControlPowerProviderRA1.nrEndMinute);
    }

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlPowerProviderRA2 batteryControlPowerProviderRA2) {
        this(arrayHeader, batteryControlPowerProviderRA2.pos, batteryControlPowerProviderRA2.nrStartHour, batteryControlPowerProviderRA2.nrStartMinute, batteryControlPowerProviderRA2.nrEndHour, batteryControlPowerProviderRA2.nrEndMinute);
    }

    public PowerProviderListArrayElementAdapter(ArrayHeader arrayHeader, BatteryControlPowerProviderRAE batteryControlPowerProviderRAE) {
        this(arrayHeader, 0, 0, 0, 0, 0);
    }

    public BatteryControlPowerProviderRA2 toPowerProviderListRA2() {
        return new BatteryControlPowerProviderRA2(this.getPos(), this.NR_StartHour, this.NR_StartMinutes, this.NR_EndHour, this.NR_EndMinutes);
    }

    @Override
    protected BatteryControlPowerProviderCollector copyCollector(int n, int n2, int n3, int n4, int n5) {
        return new PowerProviderListArrayElementAdapter(this.getArrayHeader(), n, n2, n3, n4, n5);
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
        return this.posID;
    }

    @Override
    public void setPos(int n) {
        this.posID = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        if (this._arrayHeader == null) {
            this._arrayHeader = new ArrayHeader();
        }
        return this._arrayHeader;
    }
}

