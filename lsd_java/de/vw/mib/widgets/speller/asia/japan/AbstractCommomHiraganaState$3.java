/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import de.vw.mib.widgets.speller.asia.AsiaDatabase;
import de.vw.mib.widgets.speller.asia.AsiaDatabaseState;
import de.vw.mib.widgets.speller.asia.handler.AbstractStateStrategyUtilizingAsiaStateHandler;
import de.vw.mib.widgets.speller.asia.handler.AsiaStateProxy;
import de.vw.mib.widgets.speller.asia.japan.AbstractCommomHiraganaState;
import java.util.ArrayList;

class AbstractCommomHiraganaState$3
extends AbstractStateStrategyUtilizingAsiaStateHandler {
    private final /* synthetic */ AbstractCommomHiraganaState this$0;

    AbstractCommomHiraganaState$3(AbstractCommomHiraganaState abstractCommomHiraganaState) {
        this.this$0 = abstractCommomHiraganaState;
    }

    @Override
    protected void doGetState(AsiaStateProxy asiaStateProxy, AsiaDatabase asiaDatabase) {
        asiaStateProxy.getState(1, this);
    }

    @Override
    protected void onStateSuccessfullyReceived(AsiaDatabaseState asiaDatabaseState, AsiaDatabase asiaDatabase) {
        String[] stringArray = this.filterCandidates(asiaDatabaseState.getCandidates());
        this.getState().getWidget().setCandidates(stringArray);
    }

    private String[] filterCandidates(String[] stringArray) {
        if (stringArray != null) {
            int n = stringArray.length;
            if (n > 0) {
                int n2;
                ArrayList arrayList = new ArrayList(n);
                for (n2 = 0; n2 < n; ++n2) {
                    String string = stringArray[n2];
                    if (this.getState().getWidget().willCharMaxExceed(string)) continue;
                    arrayList.add(string);
                }
                n2 = arrayList.size();
                if (n2 > 0) {
                    if (n2 < n) {
                        return (String[])arrayList.toArray(new String[n2]);
                    }
                    return stringArray;
                }
            } else {
                return stringArray;
            }
        }
        return new String[0];
    }
}

