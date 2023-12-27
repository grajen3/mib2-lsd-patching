/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoList;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListNar$AMFrequencyTransformer;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListNar$FMPresetTransformer;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_Data;

public final class InfoListNar
extends InfoList {
    private int _bapInfoListType = 255;

    @Override
    protected String formatFrequency(int n, int n2, int n3) {
        return this.getLanguageUtil().formatFrequencyNAR(n, n2, n3);
    }

    @Override
    protected String computeReceptionListName(int n, String string, String string2) {
        String string3 = n == 1 || n == 0 ? string2 : super.computeReceptionListName(n, string, string2);
        return string3;
    }

    private void setBapInfoListType(int n) {
        if (this._bapInfoListType != n) {
            this._bapInfoListType = n;
            if (this.getUpdateTimer().isRunning()) {
                this.getUpdateTimer().stop();
                this.process(-1);
            }
        }
    }

    protected String formatFrequencyOrReturnPresetName(String string, int n, int n2, int n3) {
        String string2 = n != 0 ? this.getLanguageUtil().formatFrequencyNAR(n, n2, n3) : "";
        return string2;
    }

    private void computeFullPresetList(int n, StringIterator stringIterator) {
        int n2 = 0;
        while (stringIterator.hasNext()) {
            String string = stringIterator.nextString();
            if (string.length() != 0) {
                InfoList_Data infoList_Data = new InfoList_Data(null);
                infoList_Data.type = 3;
                infoList_Data.attributes.selectable = true;
                infoList_Data.name.setContent(string);
                this.getInfoList().putElement(AudioSDCommon.computeUniquePresetID(n, n2), infoList_Data, n2);
            }
            ++n2;
        }
    }

    private void computeInfoPresetListForAmFmDABSirius() {
        int n = this.getCurrentStationInfoBand();
        switch (n) {
            case 0: {
                this.computeFullPresetList(n, new InfoListNar$AMFrequencyTransformer(this, this.getAmPresetListInfoFrequence(), this.getAmPresetListInfoHDStationNumber()));
                break;
            }
            case 2: {
                this.computeFullPresetList(n, this.getDabPresetListInfoName());
                break;
            }
            case 1: {
                this.computeFullPresetList(n, new InfoListNar$FMPresetTransformer(this, this.getFmPresetListInfoName(), this.getFmPresetListInfoFrequencies(), this.getFmPresetListInfoHDStationNumber()));
                break;
            }
            case 3: {
                this.computeFullPresetList(n, this.getSiriusPresetListInfoName());
                break;
            }
        }
    }

    @Override
    protected void computeFullInfoList() {
        switch (this.getArrowKeyScopeMode()) {
            case 0: {
                this.computeInfoPresetListForAmFmDABSirius();
                break;
            }
            default: {
                super.computeFullInfoList();
            }
        }
    }

    @Override
    protected void setBapInfoListType(Integer n) {
        this.setBapInfoListType((int)n);
    }
}

