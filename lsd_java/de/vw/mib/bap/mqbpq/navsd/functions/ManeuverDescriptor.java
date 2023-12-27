/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_ChangedArray;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_GetArray;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_ManeuverDescription;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.ManeuverDescriptor_StatusArray;
import de.vw.mib.bap.mqbpq.navsd.api.stages.ManeuverDescriptorStage;

public final class ManeuverDescriptor
extends ManeuverDescriptorStage {
    private ManeuverDescriptor_StatusArray _temporaryManeuverList;
    private ManeuverDescriptor_StatusArray _currentManeuverList;
    private static final int NOT_FOUND_INDEX;
    private static final int LIST_OFFSET;
    private static final int MAX_ELEMENTS;
    private static final int ONE_ELEMENT_CHANGE_MAX_NUMBER;
    private static final int MANEUVER_DIRECTION_LEFT;
    private static final int MANEUVER_DIRECTION_RIGHT;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.maneuverDescriptorFullRangeUpdate();
    }

    private ManeuverDescriptor_StatusArray getTemporaryManeuverList() {
        if (this._temporaryManeuverList == null) {
            this._temporaryManeuverList = new ManeuverDescriptor_StatusArray();
        }
        return this._temporaryManeuverList;
    }

    private ManeuverDescriptor_StatusArray getCurrentManeuverList() {
        if (this._currentManeuverList == null) {
            this._currentManeuverList = new ManeuverDescriptor_StatusArray();
        }
        return this._currentManeuverList;
    }

    private void exchangeCurrentManeuverListWithTemporaryManeuverList() {
        ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray = this._currentManeuverList;
        this._currentManeuverList = this._temporaryManeuverList;
        this._temporaryManeuverList = maneuverDescriptor_StatusArray;
    }

    private int mapToBapDirectionFirstManeuver(int n, int n2) {
        int n3;
        switch (n) {
            case 34: {
                n3 = n2 == 192 ? 64 : 192;
                break;
            }
            case 35: {
                n3 = n2 == 192 ? 192 : 64;
                break;
            }
            default: {
                n3 = n2;
            }
        }
        return n3;
    }

    private int mapToBapDirectionSecondManeuver(int n, int n2) {
        int n3;
        switch (n) {
            case 34: {
                n3 = n2 == 192 ? 192 : 64;
                break;
            }
            case 35: {
                n3 = n2 == 192 ? 64 : 192;
                break;
            }
            default: {
                n3 = n2;
            }
        }
        return n3;
    }

    private int mapToBAPMainElement(int n) {
        int n2;
        switch (n) {
            case 33: {
                n2 = 16;
                break;
            }
            case 32: {
                n2 = 15;
                break;
            }
            case 34: 
            case 35: {
                n2 = 13;
                break;
            }
            case 38: {
                n2 = 2;
                break;
            }
            default: {
                n2 = n;
            }
        }
        return n2;
    }

    private ManeuverDescriptor_ManeuverDescription neededAdditionalManeuver(int n, int n2, String string, int n3) {
        ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription;
        switch (n2) {
            case 34: 
            case 35: {
                maneuverDescriptor_ManeuverDescription = new ManeuverDescriptor_ManeuverDescription(null);
                maneuverDescriptor_ManeuverDescription.direction = this.mapToBapDirectionSecondManeuver(n2, n);
                maneuverDescriptor_ManeuverDescription.mainElement = n2 == 35 ? 13 : 25;
                maneuverDescriptor_ManeuverDescription.sidestreets.setContent(string);
                maneuverDescriptor_ManeuverDescription.zLevelGuidance = n3;
                break;
            }
            default: {
                maneuverDescriptor_ManeuverDescription = null;
            }
        }
        return maneuverDescriptor_ManeuverDescription;
    }

    private ManeuverDescriptor_ManeuverDescription validateManeuverData(int n, int n2, String string, int n3) {
        ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription = new ManeuverDescriptor_ManeuverDescription(null);
        maneuverDescriptor_ManeuverDescription.direction = this.mapToBapDirectionFirstManeuver(n2, n);
        maneuverDescriptor_ManeuverDescription.mainElement = this.mapToBAPMainElement(n2);
        maneuverDescriptor_ManeuverDescription.sidestreets.setContent(string);
        maneuverDescriptor_ManeuverDescription.zLevelGuidance = n3;
        switch (maneuverDescriptor_ManeuverDescription.mainElement) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 8: 
            case 9: 
            case 10: {
                maneuverDescriptor_ManeuverDescription.zLevelGuidance = 0;
                maneuverDescriptor_ManeuverDescription.sidestreets.setEmptyString();
                break;
            }
            case 11: {
                maneuverDescriptor_ManeuverDescription.zLevelGuidance = 0;
                break;
            }
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 25: 
            case 26: 
            case 27: 
            case 28: 
            case 29: 
            case 30: 
            case 31: {
                maneuverDescriptor_ManeuverDescription.sidestreets.setEmptyString();
                break;
            }
        }
        return maneuverDescriptor_ManeuverDescription;
    }

    private void fillManeuverDescriptor(ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray) {
        IntegerIterator integerIterator = this.getDirection();
        IntegerIterator integerIterator2 = this.getMainElement();
        StringIterator stringIterator = this.getSidestreets();
        IntegerIterator integerIterator3 = this.getZLevelGuidance();
        int n = integerIterator2.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = integerIterator.nextInteger();
            int n3 = integerIterator2.nextInteger();
            String string = stringIterator.nextString();
            int n4 = integerIterator3.nextInteger();
            ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription = this.neededAdditionalManeuver(n2, n3, string, n4);
            ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription2 = this.validateManeuverData(n2, n3, string, n4);
            maneuverDescriptor_ManeuverDescription2.setArrayHeader(maneuverDescriptor_StatusArray.getArrayHeader());
            maneuverDescriptor_StatusArray.getArrayData().add(maneuverDescriptor_ManeuverDescription2);
            if (maneuverDescriptor_ManeuverDescription == null) continue;
            maneuverDescriptor_ManeuverDescription.setArrayHeader(maneuverDescriptor_StatusArray.getArrayHeader());
            maneuverDescriptor_StatusArray.getArrayData().add(maneuverDescriptor_ManeuverDescription);
        }
    }

    private ManeuverDescriptor_ChangedArray maneuverDescriptorFullRangeUpdate() {
        ManeuverDescriptor_ChangedArray maneuverDescriptor_ChangedArray = this.dequeueBAPEntity();
        maneuverDescriptor_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return maneuverDescriptor_ChangedArray;
    }

    private static int maneuverElementsEqual(ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription, ManeuverDescriptor_ManeuverDescription maneuverDescriptor_ManeuverDescription2) {
        int n = maneuverDescriptor_ManeuverDescription.mainElement == maneuverDescriptor_ManeuverDescription2.mainElement && maneuverDescriptor_ManeuverDescription.direction == maneuverDescriptor_ManeuverDescription2.direction && maneuverDescriptor_ManeuverDescription.zLevelGuidance == maneuverDescriptor_ManeuverDescription2.zLevelGuidance && maneuverDescriptor_ManeuverDescription.sidestreets.equalTo(maneuverDescriptor_ManeuverDescription2.sidestreets) ? -1 : (maneuverDescriptor_ManeuverDescription.mainElement != maneuverDescriptor_ManeuverDescription2.mainElement ? (maneuverDescriptor_ManeuverDescription.direction == maneuverDescriptor_ManeuverDescription2.direction && maneuverDescriptor_ManeuverDescription.zLevelGuidance == maneuverDescriptor_ManeuverDescription2.zLevelGuidance && maneuverDescriptor_ManeuverDescription.sidestreets.equalTo(maneuverDescriptor_ManeuverDescription2.sidestreets) ? 1 : 0) : (maneuverDescriptor_ManeuverDescription.direction != maneuverDescriptor_ManeuverDescription2.direction ? (maneuverDescriptor_ManeuverDescription.zLevelGuidance == maneuverDescriptor_ManeuverDescription2.zLevelGuidance && maneuverDescriptor_ManeuverDescription.sidestreets.equalTo(maneuverDescriptor_ManeuverDescription2.sidestreets) ? 2 : 0) : (maneuverDescriptor_ManeuverDescription.zLevelGuidance != maneuverDescriptor_ManeuverDescription2.zLevelGuidance ? (maneuverDescriptor_ManeuverDescription.sidestreets.equalTo(maneuverDescriptor_ManeuverDescription2.sidestreets) ? 3 : 0) : 4)));
        return n;
    }

    private ManeuverDescriptor_ChangedArray searchForChangeContent(ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray, ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray2) {
        ManeuverDescriptor_ChangedArray maneuverDescriptor_ChangedArray;
        int n = maneuverDescriptor_StatusArray.getArrayData().size() - maneuverDescriptor_StatusArray2.getArrayData().size();
        if (n == 0 && maneuverDescriptor_StatusArray.getArrayData().size() == 0) {
            maneuverDescriptor_ChangedArray = null;
        } else if (n == 0) {
            BAPArrayData bAPArrayData = maneuverDescriptor_StatusArray.getArrayData();
            BAPArrayData bAPArrayData2 = maneuverDescriptor_StatusArray2.getArrayData();
            int n2 = -1;
            boolean bl = false;
            int n3 = bAPArrayData.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                int n4 = ManeuverDescriptor.maneuverElementsEqual((ManeuverDescriptor_ManeuverDescription)bAPArrayData.get(i2), (ManeuverDescriptor_ManeuverDescription)bAPArrayData2.get(i2));
                if (n2 != -1 && n4 != n2) {
                    bl = true;
                    break;
                }
                n2 = n4;
            }
            if (bl || bAPArrayData.size() > 1) {
                maneuverDescriptor_ChangedArray = this.maneuverDescriptorFullRangeUpdate();
            } else if (n2 != -1) {
                maneuverDescriptor_ChangedArray = new ManeuverDescriptor_ChangedArray();
                maneuverDescriptor_ChangedArray.getArrayHeader().setElementChangedRequest(0, false, n2);
            } else {
                maneuverDescriptor_ChangedArray = null;
            }
        } else {
            maneuverDescriptor_ChangedArray = this.maneuverDescriptorFullRangeUpdate();
        }
        return maneuverDescriptor_ChangedArray;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.getTemporaryManeuverList().reset();
        this.fillManeuverDescriptor(this.getTemporaryManeuverList());
        ManeuverDescriptor_ChangedArray maneuverDescriptor_ChangedArray = this.searchForChangeContent(this.getTemporaryManeuverList(), this.getCurrentManeuverList());
        if (maneuverDescriptor_ChangedArray != null) {
            this.getDelegate().getArrayListener(this).changedArray(maneuverDescriptor_ChangedArray, this);
            this.exchangeCurrentManeuverListWithTemporaryManeuverList();
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        ManeuverDescriptor_GetArray maneuverDescriptor_GetArray = (ManeuverDescriptor_GetArray)bAPEntity;
        ArrayRequestData arrayRequestData = ArrayRequestData.computeArrayRequestData(maneuverDescriptor_GetArray.getArrayHeader(), this.getCurrentManeuverList().getArrayData().size(), maneuverDescriptor_GetArray.getArrayHeader().start - 0, 3);
        ManeuverDescriptor_StatusArray maneuverDescriptor_StatusArray = new ManeuverDescriptor_StatusArray();
        maneuverDescriptor_StatusArray.setArrayHeader(this.getCurrentManeuverList().getArrayHeader());
        arrayRequestData.setStatusArrayHeaderData(maneuverDescriptor_StatusArray, maneuverDescriptor_GetArray.getArrayHeader(), false);
        arrayRequestData.fillRequestData((BAPStatusArray)maneuverDescriptor_StatusArray, this.getCurrentManeuverList());
        arrayRequestData.setTransmissionPosForConsecutiveArray(maneuverDescriptor_StatusArray);
        arrayListener.statusArray(maneuverDescriptor_StatusArray, this);
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }
}

