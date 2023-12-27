/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.internal.ugdo.transformer.UGDOCollector;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOSpecialFeatures;

public class ButtonListArrayElementAdapter
extends UGDOCollector
implements BAPArrayElement {
    private ArrayHeader _arrayHeader;

    public ButtonListArrayElementAdapter() {
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, int n, String string, float f2, float f3, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super(n, string, f2, f3, n2, n3, n4, bl, bl2, bl3, bl4, ButtonListArrayElementAdapter.provideNameState(string, n2));
        this._arrayHeader = arrayHeader;
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA0 uGDOButtonListRA0) {
        this(arrayHeader, uGDOButtonListRA0.pos, uGDOButtonListRA0.name, uGDOButtonListRA0.positionLatitude, uGDOButtonListRA0.positionLongitude, uGDOButtonListRA0.learnedState, uGDOButtonListRA0.hardkey, uGDOButtonListRA0.softkey, uGDOButtonListRA0.specialFeatures.doorName, uGDOButtonListRA0.specialFeatures.gpsSupervision, uGDOButtonListRA0.specialFeatures.keyFob, uGDOButtonListRA0.specialFeatures.biDirectionalCommunication);
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA1 uGDOButtonListRA1) {
        this(arrayHeader, uGDOButtonListRA1.pos, "free", uGDOButtonListRA1.positionLatitude, uGDOButtonListRA1.positionLongitude, uGDOButtonListRA1.learnedState, 0, 0, uGDOButtonListRA1.specialFeatures.doorName, uGDOButtonListRA1.specialFeatures.gpsSupervision, uGDOButtonListRA1.specialFeatures.keyFob, uGDOButtonListRA1.specialFeatures.biDirectionalCommunication);
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA2 uGDOButtonListRA2) {
        this(arrayHeader, uGDOButtonListRA2.pos, "free", 0.0f, 0.0f, uGDOButtonListRA2.learnedState, 0, 0, uGDOButtonListRA2.specialFeatures.doorName, uGDOButtonListRA2.specialFeatures.gpsSupervision, uGDOButtonListRA2.specialFeatures.keyFob, uGDOButtonListRA2.specialFeatures.biDirectionalCommunication);
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA3 uGDOButtonListRA3) {
        this(arrayHeader, uGDOButtonListRA3.pos, "free", 0.0f, 0.0f, 0, 0, 0, uGDOButtonListRA3.specialFeatures.doorName, uGDOButtonListRA3.specialFeatures.gpsSupervision, uGDOButtonListRA3.specialFeatures.keyFob, uGDOButtonListRA3.specialFeatures.biDirectionalCommunication);
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA4 uGDOButtonListRA4) {
        this(arrayHeader, uGDOButtonListRA4.pos, uGDOButtonListRA4.name, 0.0f, 0.0f, 0, 0, 0, false, false, false, false);
    }

    public ButtonListArrayElementAdapter(ArrayHeader arrayHeader, UGDOButtonListRA5 uGDOButtonListRA5) {
        this(arrayHeader, uGDOButtonListRA5.pos, "free", 0.0f, 0.0f, uGDOButtonListRA5.learnedState, 0, 0, false, false, false, false);
    }

    public ButtonListArrayElementAdapter(ButtonListArrayElementAdapter buttonListArrayElementAdapter) {
        this(buttonListArrayElementAdapter.getArrayHeader(), buttonListArrayElementAdapter.getPos(), buttonListArrayElementAdapter.KeyName, buttonListArrayElementAdapter.positionLatitude, buttonListArrayElementAdapter.PositionLongitude, buttonListArrayElementAdapter.learnedState, buttonListArrayElementAdapter.hardKey, buttonListArrayElementAdapter.softKey, buttonListArrayElementAdapter.doorNameExist, buttonListArrayElementAdapter.isGpsSupervision, buttonListArrayElementAdapter.isKeyFob, buttonListArrayElementAdapter.isBiDirectionalCommunication);
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void reset() {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public ArrayHeader getArrayHeader() {
        if (this._arrayHeader == null) {
            this._arrayHeader = new ArrayHeader();
        }
        return this._arrayHeader;
    }

    @Override
    public int getPos() {
        return this.fsgListPos;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this._arrayHeader = arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.fsgListPos = n;
    }

    public UGDOButtonListRA0 convertToUGDOButtonListRA0() {
        return new UGDOButtonListRA0(this.getPos(), this.KeyName, 0.0f, 0.0f, this.learnedState, this.hardKey, this.softKey, this.createUGDOSpecialFeatures());
    }

    public UGDOButtonListRA1 convertToUGDOButtonListRA1() {
        return new UGDOButtonListRA1(this.getPos(), this.positionLatitude, this.positionLatitude, this.learnedState, this.createUGDOSpecialFeatures());
    }

    public UGDOButtonListRA2 convertToUGDOButtonListRA2() {
        return new UGDOButtonListRA2(this.getPos(), this.learnedState, this.createUGDOSpecialFeatures());
    }

    public UGDOButtonListRA3 convertToUGDOButtonListRA3() {
        return new UGDOButtonListRA3(this.getPos(), this.createUGDOSpecialFeatures());
    }

    public UGDOButtonListRA4 convertToUGDOButtonListRA4() {
        return new UGDOButtonListRA4(this.getPos(), this.KeyName);
    }

    public UGDOButtonListRA5 convertToUGDOButtonListRA5() {
        return new UGDOButtonListRA5(this.getPos(), this.learnedState);
    }

    public UGDOSpecialFeatures createUGDOSpecialFeatures() {
        return new UGDOSpecialFeatures(this.doorNameExist, this.isGpsSupervision, this.isKeyFob, this.isBiDirectionalCommunication);
    }

    private static int provideNameState(String string, int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                if (string == null || string.equals("")) {
                    n2 = 1;
                    break;
                }
                n2 = 2;
                break;
            }
        }
        return n2;
    }
}

