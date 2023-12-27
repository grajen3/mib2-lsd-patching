/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.hwr;

import de.vw.mib.speller.hwr.HWREngineListenerAdapter;
import de.vw.mib.widgets.speller.hwr.HWRWrapper;
import edu.emory.mathcs.backport.java.util.Arrays;

final class HWRWrapper$HWREngineHandler
extends HWREngineListenerAdapter {
    private final /* synthetic */ HWRWrapper this$0;

    public HWRWrapper$HWREngineHandler(HWRWrapper hWRWrapper) {
        this.this$0 = hWRWrapper;
    }

    @Override
    public void updateEngineReady(boolean bl) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("updateEngineReady=").append(bl).log();
        }
        if (!this.this$0.isReady && bl && this.this$0.hwrEngineState != null) {
            this.this$0.hwrEngineState.ready();
        } else if (this.this$0.isReady && !bl && this.this$0.hwrEngineState != null) {
            this.this$0.hwrEngineState.notReady();
        }
        this.this$0.isReady = bl;
    }

    @Override
    public void updateRecognizedCharacters(String[] stringArray) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("updateRecognizedCharacters=[").append(Arrays.toString(stringArray)).append("]").log();
        }
        if (this.this$0.hwrEngineState != null) {
            this.this$0.hwrEngineState.charactersRecognized(stringArray);
        }
    }
}

