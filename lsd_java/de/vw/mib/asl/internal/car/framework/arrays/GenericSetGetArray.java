/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.asl.internal.car.framework.arrays.GenericGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;

final class GenericSetGetArray
extends GenericGetArray
implements BAPSetGetArray {
    private BAPArrayData _arrayData;
    private Class _arrayElementClass;

    public GenericSetGetArray(Class clazz) {
        this._arrayElementClass = clazz;
    }

    @Override
    public BAPArrayData getArrayData() {
        if (this._arrayData == null) {
            this._arrayData = new BAPArrayData(-129);
        }
        return this._arrayData;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this._arrayData = bAPArrayData;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        BAPArrayElement bAPArrayElement;
        try {
            bAPArrayElement = (BAPArrayElement)this._arrayElementClass.newInstance();
        }
        catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
        return bAPArrayElement;
    }
}

