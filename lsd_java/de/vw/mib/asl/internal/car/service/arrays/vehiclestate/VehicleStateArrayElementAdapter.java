/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.internal.car.service.transformer.CarVehicleStatusWarningCollector;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;

final class VehicleStateArrayElementAdapter
extends CarVehicleStatusWarningCollector
implements BAPArrayElement {
    private ArrayHeader _arrayHeader;

    public VehicleStateArrayElementAdapter() {
        this(new ArrayHeader());
    }

    public VehicleStateArrayElementAdapter(ArrayHeader arrayHeader, int n, String string) {
        this(arrayHeader, n, -1, "", string);
    }

    public VehicleStateArrayElementAdapter(ArrayHeader arrayHeader, ListWarningIDsDynValues listWarningIDsDynValues) {
        this(arrayHeader, listWarningIDsDynValues.pos, listWarningIDsDynValues.warningID, listWarningIDsDynValues.dynValue, "");
    }

    public VehicleStateArrayElementAdapter(ArrayHeader arrayHeader, ListDynValues listDynValues) {
        this(arrayHeader, listDynValues.pos, -1, listDynValues.dynValue, "");
    }

    public VehicleStateArrayElementAdapter(ArrayHeader arrayHeader, int n, int n2, String string, String string2) {
        super(n, n2, string, string2);
        this._arrayHeader = arrayHeader;
    }

    public VehicleStateArrayElementAdapter(VehicleStateArrayElementAdapter vehicleStateArrayElementAdapter) {
        this(vehicleStateArrayElementAdapter.getArrayHeader(), vehicleStateArrayElementAdapter.getPos(), vehicleStateArrayElementAdapter.getWarningID(), vehicleStateArrayElementAdapter.getDynValue(), vehicleStateArrayElementAdapter.getAlternativeText());
    }

    public VehicleStateArrayElementAdapter(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    public void setAlternativeText(String string) {
        this.alternativeText = string;
    }

    public String getAlternativeText() {
        return this.alternativeText;
    }

    public int getWarningID() {
        return this.warningId;
    }

    public void setWarningID(int n) {
        this.warningId = n;
    }

    public String getDynValue() {
        return this.warningText;
    }

    public void setDynValue(String string) {
        this.warningText = string;
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
    public void setPos(int n) {
        this.posValue = n;
    }

    @Override
    public int getPos() {
        return this.posValue;
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

