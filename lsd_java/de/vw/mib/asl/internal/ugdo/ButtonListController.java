/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ugdo;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.internal.ugdo.ButtonListArrayElementAdapter;
import de.vw.mib.asl.internal.ugdo.ButtonListContext;
import de.vw.mib.asl.internal.ugdo.ButtonListDsiAdapter;
import de.vw.mib.asl.internal.ugdo.ButtonListDsiListener;
import de.vw.mib.asl.internal.ugdo.ButtonListModelUpdater;
import de.vw.mib.asl.internal.ugdo.transformer.UGDOCollector;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ArrayListFactory;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carcomfort.UGDOButtonListRA0;
import org.dsi.ifc.carcomfort.UGDOButtonListRA1;
import org.dsi.ifc.carcomfort.UGDOButtonListRA2;
import org.dsi.ifc.carcomfort.UGDOButtonListRA3;
import org.dsi.ifc.carcomfort.UGDOButtonListRA4;
import org.dsi.ifc.carcomfort.UGDOButtonListRA5;
import org.dsi.ifc.carcomfort.UGDOButtonListUpdateInfo;

public class ButtonListController
extends ButtonListModelUpdater
implements ASGArrayListFactory,
ASGArrayListDelegate,
Logger {
    private ButtonListContext _context;
    private ASGArrayList buttonArrayList;
    private ButtonListDsiListener buttonListDsiListener;
    private static final int HIGH_LEVEL_RETRY_NUMBER_OF_RETRIES;
    private static final long HIGH_LEVEL_RETRY_RETRY_TIME;
    private int MIN_NUMBER_TO_REQUEST = 3;
    public static int INDEX_NOT_FOUND;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ugdo$ButtonListArrayElementAdapter;

    public ButtonListController(ButtonListContext buttonListContext) {
        super(buttonListContext);
        this._context = buttonListContext;
    }

    private ButtonListContext getContext() {
        return this._context;
    }

    private CarLogger getContextLoger() {
        return this.getContext().getCarLogger();
    }

    public ASGArrayList getButtonArrayList() {
        if (this.buttonArrayList == null) {
            this.buttonArrayList = new ArrayListFactory().createCompleteArrayList(this, new ButtonListModelUpdater(this.getContext()), this, 1, 0, true, 4, 0);
        }
        return this.buttonArrayList;
    }

    public ButtonListDsiListener getButtonListDsiListener() {
        if (this.buttonListDsiListener == null) {
            this.buttonListDsiListener = new ButtonListDsiAdapter(this.getContext(), this.getButtonArrayList());
        }
        return this.buttonListDsiListener;
    }

    @Override
    public BAPGetArray createGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapGetArray();
    }

    @Override
    public BAPSetGetArray createSetGetArrayRequest(ASGArrayList aSGArrayList) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapSetGetArray(class$de$vw$mib$asl$internal$ugdo$ButtonListArrayElementAdapter == null ? (class$de$vw$mib$asl$internal$ugdo$ButtonListArrayElementAdapter = ButtonListController.class$("de.vw.mib.asl.internal.ugdo.ButtonListArrayElementAdapter")) : class$de$vw$mib$asl$internal$ugdo$ButtonListArrayElementAdapter);
    }

    @Override
    public BAPArrayElement createEmptyElement(ASGArrayList aSGArrayList) {
        return new ButtonListArrayElementAdapter();
    }

    @Override
    public BAPArrayElement mergeArrayElementAttributes(ASGArrayList aSGArrayList, BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        ButtonListArrayElementAdapter buttonListArrayElementAdapter = new ButtonListArrayElementAdapter((ButtonListArrayElementAdapter)bAPArrayElement);
        ButtonListArrayElementAdapter buttonListArrayElementAdapter2 = (ButtonListArrayElementAdapter)bAPArrayElement2;
        switch (n) {
            case 0: {
                break;
            }
            case 1: {
                buttonListArrayElementAdapter.KeyName = buttonListArrayElementAdapter2.KeyName;
                buttonListArrayElementAdapter.hardKey = buttonListArrayElementAdapter2.hardKey;
                buttonListArrayElementAdapter.softKey = buttonListArrayElementAdapter2.softKey;
                buttonListArrayElementAdapter.nameState = buttonListArrayElementAdapter2.nameState;
                break;
            }
            case 2: {
                buttonListArrayElementAdapter.KeyName = buttonListArrayElementAdapter2.KeyName;
                buttonListArrayElementAdapter.positionLatitude = buttonListArrayElementAdapter2.positionLatitude;
                buttonListArrayElementAdapter.PositionLongitude = buttonListArrayElementAdapter2.PositionLongitude;
                buttonListArrayElementAdapter.hardKey = buttonListArrayElementAdapter2.hardKey;
                buttonListArrayElementAdapter.softKey = buttonListArrayElementAdapter2.softKey;
                buttonListArrayElementAdapter.nameState = buttonListArrayElementAdapter2.nameState;
                break;
            }
            case 3: {
                buttonListArrayElementAdapter.KeyName = buttonListArrayElementAdapter2.KeyName;
                buttonListArrayElementAdapter.positionLatitude = buttonListArrayElementAdapter2.positionLatitude;
                buttonListArrayElementAdapter.PositionLongitude = buttonListArrayElementAdapter2.PositionLongitude;
                buttonListArrayElementAdapter.learnedState = buttonListArrayElementAdapter2.learnedState;
                buttonListArrayElementAdapter.hardKey = buttonListArrayElementAdapter2.hardKey;
                buttonListArrayElementAdapter.softKey = buttonListArrayElementAdapter2.softKey;
                buttonListArrayElementAdapter.nameState = buttonListArrayElementAdapter2.nameState;
                break;
            }
            case 4: {
                buttonListArrayElementAdapter.positionLatitude = buttonListArrayElementAdapter2.positionLatitude;
                buttonListArrayElementAdapter.PositionLongitude = buttonListArrayElementAdapter2.PositionLongitude;
                buttonListArrayElementAdapter.learnedState = buttonListArrayElementAdapter2.learnedState;
                buttonListArrayElementAdapter.hardKey = buttonListArrayElementAdapter2.hardKey;
                buttonListArrayElementAdapter.softKey = buttonListArrayElementAdapter2.softKey;
                buttonListArrayElementAdapter.isBiDirectionalCommunication = buttonListArrayElementAdapter2.isBiDirectionalCommunication;
                buttonListArrayElementAdapter.isGpsSupervision = buttonListArrayElementAdapter2.isGpsSupervision;
                buttonListArrayElementAdapter.isKeyFob = buttonListArrayElementAdapter2.isKeyFob;
                if (!buttonListArrayElementAdapter.KeyName.equals("")) {
                    buttonListArrayElementAdapter.nameState = 2;
                    break;
                }
                buttonListArrayElementAdapter.nameState = buttonListArrayElementAdapter2.nameState;
                break;
            }
            case 5: {
                buttonListArrayElementAdapter.KeyName = buttonListArrayElementAdapter2.KeyName;
                buttonListArrayElementAdapter.positionLatitude = buttonListArrayElementAdapter2.positionLatitude;
                buttonListArrayElementAdapter.PositionLongitude = buttonListArrayElementAdapter2.PositionLongitude;
                buttonListArrayElementAdapter.hardKey = buttonListArrayElementAdapter2.hardKey;
                buttonListArrayElementAdapter.softKey = buttonListArrayElementAdapter2.softKey;
                buttonListArrayElementAdapter.nameState = buttonListArrayElementAdapter2.nameState;
                break;
            }
            default: {
                this.getContextLoger().error("VehicleStatus: Wrong recordAddress given in mergeArrayElementAttributes");
            }
        }
        return buttonListArrayElementAdapter;
    }

    @Override
    public Timer createTimer(ASGArrayList aSGArrayList, TimerNotifier timerNotifier, long l) {
        return ASLCarFactory.getCarApi().getCarBapArrayFactory().createBapArrayTimer(timerNotifier, l);
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        int n = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().toArrayContent(bAPGetArray);
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = new UGDOButtonListUpdateInfo(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPGetArray.getTransactionId(), bAPGetArray.getAsgId());
        this.getContext().getCarComfort().requestUGDOButtonList(uGDOButtonListUpdateInfo);
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        int n = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().toArrayContent(bAPSetGetArray);
        ArrayHeader arrayHeader = bAPSetGetArray.getArrayHeader();
        UGDOButtonListUpdateInfo uGDOButtonListUpdateInfo = new UGDOButtonListUpdateInfo(n, arrayHeader.getRecordAddress(), arrayHeader.start, arrayHeader.elements, bAPSetGetArray.getTransactionId(), bAPSetGetArray.getAsgId());
        switch (bAPSetGetArray.getArrayHeader().getRecordAddress()) {
            case 0: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA0[] uGDOButtonListRA0Array = new UGDOButtonListRA0[bAPArrayElementArray.length];
                int n2 = bAPArrayElementArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i2];
                    uGDOButtonListRA0Array[i2] = buttonListArrayElementAdapter.convertToUGDOButtonListRA0();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA0(uGDOButtonListUpdateInfo, uGDOButtonListRA0Array);
                break;
            }
            case 1: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA1[] uGDOButtonListRA1Array = new UGDOButtonListRA1[bAPArrayElementArray.length];
                int n3 = bAPArrayElementArray.length;
                for (int i3 = 0; i3 < n3; ++i3) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i3];
                    uGDOButtonListRA1Array[i3] = buttonListArrayElementAdapter.convertToUGDOButtonListRA1();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA1(uGDOButtonListUpdateInfo, uGDOButtonListRA1Array);
                break;
            }
            case 2: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA2[] uGDOButtonListRA2Array = new UGDOButtonListRA2[bAPArrayElementArray.length];
                int n4 = bAPArrayElementArray.length;
                for (int i4 = 0; i4 < n4; ++i4) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i4];
                    uGDOButtonListRA2Array[i4] = buttonListArrayElementAdapter.convertToUGDOButtonListRA2();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA2(uGDOButtonListUpdateInfo, uGDOButtonListRA2Array);
                break;
            }
            case 3: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA3[] uGDOButtonListRA3Array = new UGDOButtonListRA3[bAPArrayElementArray.length];
                int n5 = bAPArrayElementArray.length;
                for (int i5 = 0; i5 < n5; ++i5) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i5];
                    uGDOButtonListRA3Array[i5] = buttonListArrayElementAdapter.convertToUGDOButtonListRA3();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA3(uGDOButtonListUpdateInfo, uGDOButtonListRA3Array);
                break;
            }
            case 4: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA4[] uGDOButtonListRA4Array = new UGDOButtonListRA4[bAPArrayElementArray.length];
                int n6 = bAPArrayElementArray.length;
                for (int i6 = 0; i6 < n6; ++i6) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i6];
                    uGDOButtonListRA4Array[i6] = buttonListArrayElementAdapter.convertToUGDOButtonListRA4();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA4(uGDOButtonListUpdateInfo, uGDOButtonListRA4Array);
                break;
            }
            case 5: {
                BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
                UGDOButtonListRA5[] uGDOButtonListRA5Array = new UGDOButtonListRA5[bAPArrayElementArray.length];
                int n7 = bAPArrayElementArray.length;
                for (int i7 = 0; i7 < n7; ++i7) {
                    ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)bAPArrayElementArray[i7];
                    uGDOButtonListRA5Array[i7] = buttonListArrayElementAdapter.convertToUGDOButtonListRA5();
                }
                this.getContext().getCarComfort().setUGDOButtonListRA5(uGDOButtonListUpdateInfo, uGDOButtonListRA5Array);
                break;
            }
        }
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = this.MIN_NUMBER_TO_REQUEST;
                break;
            }
            default: {
                n2 = this.MIN_NUMBER_TO_REQUEST + 1;
            }
        }
        return n2;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 0;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public void log(ASGArrayList aSGArrayList, int n, String string) {
        String string2 = new StringBuffer().append("ButtonList: ").append(string).toString();
        switch (n) {
            case 1: {
                this.getContextLoger().fatal(string2);
                break;
            }
            case 2: {
                this.getContextLoger().error(string2);
                break;
            }
            case 4: {
                this.getContextLoger().warn(string2);
                break;
            }
            case 8: {
                this.getContextLoger().info(string2);
                break;
            }
            case 12: {
                this.getContextLoger().normal(string2);
                break;
            }
            case 16: {
                if (!this.getContextLoger().isTraceEnabled()) break;
                this.getContextLoger().trace(string2);
                break;
            }
            default: {
                this.getContextLoger().error("ButtonList: Unknown log message called");
            }
        }
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this;
    }

    public boolean activateFixkitMode(int n) {
        boolean bl = false;
        ButtonListArrayElementAdapter buttonListArrayElementAdapter = this.getKeyCopy(n);
        if (buttonListArrayElementAdapter != null) {
            buttonListArrayElementAdapter.learnedState = 5;
            bl = this.modifyKeyAttributes(buttonListArrayElementAdapter, 5);
        }
        return bl;
    }

    public boolean activateDefaultMode(int n) {
        boolean bl = false;
        ButtonListArrayElementAdapter buttonListArrayElementAdapter = this.getKeyCopy(n);
        if (buttonListArrayElementAdapter != null) {
            buttonListArrayElementAdapter.learnedState = 6;
            bl = this.modifyKeyAttributes(buttonListArrayElementAdapter, 5);
        }
        return bl;
    }

    public boolean renameKey(int n, String string) {
        boolean bl = false;
        ButtonListArrayElementAdapter buttonListArrayElementAdapter = this.getKeyCopy(n);
        if (buttonListArrayElementAdapter != null) {
            buttonListArrayElementAdapter.KeyName = string;
            bl = this.modifyKeyAttributes(buttonListArrayElementAdapter, 4);
        }
        return bl;
    }

    private boolean modifyKeyAttributes(UGDOCollector uGDOCollector, int n) {
        boolean bl = false;
        if (this.isButtonAvailable(uGDOCollector.fsgListPos)) {
            ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)uGDOCollector;
            this.getButtonArrayList().modifyArrayElement(buttonListArrayElementAdapter, n);
            bl = true;
        }
        return bl;
    }

    private boolean isButtonAvailable(int n) {
        boolean bl = false;
        int n2 = this.getButtonArrayList().size();
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPArrayElement bAPArrayElement = this.getButtonArrayList().get(i2);
            if (bAPArrayElement.getPos() != n) continue;
            bl = true;
            break;
        }
        return bl;
    }

    private ButtonListArrayElementAdapter getKeyCopy(int n) {
        ButtonListArrayElementAdapter buttonListArrayElementAdapter = (ButtonListArrayElementAdapter)this.getButtonArrayList().get(n - 1);
        ButtonListArrayElementAdapter buttonListArrayElementAdapter2 = new ButtonListArrayElementAdapter(buttonListArrayElementAdapter.getArrayHeader(), buttonListArrayElementAdapter.fsgListPos, buttonListArrayElementAdapter.KeyName, buttonListArrayElementAdapter.positionLatitude, buttonListArrayElementAdapter.PositionLongitude, buttonListArrayElementAdapter.learnedState, buttonListArrayElementAdapter.hardKey, buttonListArrayElementAdapter.softKey, buttonListArrayElementAdapter.doorNameExist, buttonListArrayElementAdapter.isGpsSupervision, buttonListArrayElementAdapter.isKeyFob, buttonListArrayElementAdapter.isBiDirectionalCommunication);
        return buttonListArrayElementAdapter2;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        INDEX_NOT_FOUND = -1;
    }
}

