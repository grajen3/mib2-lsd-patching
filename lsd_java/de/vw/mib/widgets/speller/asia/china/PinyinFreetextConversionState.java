/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.china;

import de.vw.mib.widgets.speller.asia.AbstractCommonFreetextConversionState;
import de.vw.mib.widgets.speller.asia.ConversionAwareState;
import de.vw.mib.widgets.speller.asia.china.ChinaStateMachine;

class PinyinFreetextConversionState
extends AbstractCommonFreetextConversionState {
    protected PinyinFreetextConversionState(ChinaStateMachine chinaStateMachine) {
        super(chinaStateMachine);
    }

    @Override
    public boolean equalConversionType(ConversionAwareState conversionAwareState) {
        if (this == conversionAwareState) {
            return true;
        }
        return conversionAwareState instanceof PinyinFreetextConversionState;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("PinyinFreetextConversion[").append(super.toString()).append("]").toString();
    }
}

