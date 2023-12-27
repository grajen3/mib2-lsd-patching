/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.internal.car.fpk.commons.AppLogger;
import de.vw.mib.asl.internal.car.fpk.usecases.content.selection.arrays.ContentSelectionBAPElement;
import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.logger.Logger;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPSetGetArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;
import org.dsi.ifc.carkombi.DCElementContentSelectionListUpdateInfo;
import org.dsi.ifc.carkombi.DSICarKombi;

public class ContentSelectionBAPListDelegate
implements ASGArrayListDelegate {
    private final Logger bapLogger;
    private final DSICarKombi dsiCarKombi;
    private static final int MAX_ELEMENTS_PER_REQUEST;

    public ContentSelectionBAPListDelegate(Logger logger, DSICarKombi dSICarKombi) {
        this.bapLogger = logger;
        this.dsiCarKombi = dSICarKombi;
    }

    @Override
    public void requestGetArray(ASGArrayList aSGArrayList, BAPGetArray bAPGetArray) {
        this.dsiCarKombi.requestDCElementContentSelectionList(ContentSelectionBAPListDelegate.toArrayHeader(bAPGetArray));
    }

    @Override
    public void requestSetGetArray(ASGArrayList aSGArrayList, BAPSetGetArray bAPSetGetArray) {
        BAPArrayElement[] bAPArrayElementArray = bAPSetGetArray.getArrayData().toArray();
        switch (bAPSetGetArray.getArrayHeader().getRecordAddress()) {
            case 1: {
                DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = new DCElementContentSelectionListRA1[bAPArrayElementArray.length];
                int n = bAPArrayElementArray.length;
                for (int i2 = 0; i2 < n; ++i2) {
                    ContentSelectionBAPElement contentSelectionBAPElement = (ContentSelectionBAPElement)bAPArrayElementArray[i2];
                    dCElementContentSelectionListRA1Array[i2] = contentSelectionBAPElement.getDCElementContentSelectionListRAX();
                }
                this.dsiCarKombi.setDCElementContentSelectionListRA1(ContentSelectionBAPListDelegate.toArrayHeader(bAPSetGetArray), dCElementContentSelectionListRA1Array);
                break;
            }
            case 2: {
                DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array = new DCElementContentSelectionListRA2[bAPArrayElementArray.length];
                int n = bAPArrayElementArray.length;
                for (int i3 = 0; i3 < n; ++i3) {
                    ContentSelectionBAPElement contentSelectionBAPElement = (ContentSelectionBAPElement)bAPArrayElementArray[i3];
                    dCElementContentSelectionListRA2Array[i3].pos = contentSelectionBAPElement.getDCElementContentSelectionListRAX().pos;
                    dCElementContentSelectionListRA2Array[i3].elementContent = contentSelectionBAPElement.getDCElementContentSelectionListRAX().elementContent;
                }
                this.dsiCarKombi.setDCElementContentSelectionListRA2(ContentSelectionBAPListDelegate.toArrayHeader(bAPSetGetArray), dCElementContentSelectionListRA2Array);
                break;
            }
        }
    }

    @Override
    public void requestTimeout(ASGArrayList aSGArrayList, int n, boolean bl) {
        AppLogger.error(this, new StringBuffer().append(".requestTimeout( arrayList = ['DCElementContentSelectionList' AsgId = ").append(aSGArrayList.getAsgId()).append(", ListId = ").append(aSGArrayList.getListId()).append("]").append(", counter = ").append(n).append(", finished = ").append(bl).append(" ), request time out for content element selections").toString());
    }

    @Override
    public int getMaxRequestableElements(ASGArrayList aSGArrayList, int n) {
        return 10;
    }

    @Override
    public int getDefaultRecordAddress(ASGArrayList aSGArrayList) {
        return 1;
    }

    @Override
    public boolean continueLoading(ASGArrayList aSGArrayList) {
        return true;
    }

    @Override
    public Logger getLogger(ASGArrayList aSGArrayList) {
        return this.bapLogger;
    }

    private static DCElementContentSelectionListUpdateInfo toArrayHeader(BAPGetArray bAPGetArray) {
        int n = ASLCarFactory.getCarApi().getCarBapArrayFactory().getBAPArrayConverter().toArrayContent(bAPGetArray);
        DCElementContentSelectionListUpdateInfo dCElementContentSelectionListUpdateInfo = new DCElementContentSelectionListUpdateInfo(n, bAPGetArray.getArrayHeader().getRecordAddress(), bAPGetArray.getArrayHeader().start, bAPGetArray.getArrayHeader().elements, bAPGetArray.getTransactionId(), bAPGetArray.getAsgId());
        return dCElementContentSelectionListUpdateInfo;
    }
}

