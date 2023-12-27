/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.BooleanIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;

public interface BAPStageContext
extends BAPFunctionControllerDelegate {
    default public void updateStages(BAPStage bAPStage, int[] nArray, Object object) {
    }

    default public BAPEntity dequeueBAPEntity(BAPStage bAPStage, Class clazz) {
    }

    default public boolean getBoolean(int n, boolean bl) {
    }

    default public int getInteger(int n, int n2) {
    }

    default public String getString(int n, String string) {
    }

    default public LongIterator getLongListIterator(int n, int n2) {
    }

    default public IntegerIterator getIntegerListIterator(int n, int n2) {
    }

    default public BooleanIterator getBooleanListIterator(int n, int n2) {
    }

    default public StringIterator getStringListIterator(int n, int n2) {
    }

    default public long getLongListValue(int n, int n2) {
    }

    default public int getIntegerListValue(int n, int n2) {
    }

    default public boolean getBooleanListValue(int n, int n2) {
    }

    default public String getStringListValue(int n, int n2) {
    }

    default public int getLogicalControlUnitID() {
    }
}

