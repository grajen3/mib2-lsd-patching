/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.features.model.DynamicString;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterData;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterTextEntry;
import de.vw.mib.asl.internal.speechengine.teleprompter.TeleprompterTextEntryImpl;
import java.util.ArrayList;
import java.util.List;

public class TeleprompterDataImpl
implements TeleprompterData {
    private int teleprompterType;
    private List commandExamples;
    private TeleprompterTextEntry headline;

    public void setTeleprompterType(int n) {
        this.teleprompterType = n;
    }

    public void setHeadlineTitle(DynamicString dynamicString) {
        this.headline = dynamicString == null ? null : new TeleprompterTextEntryImpl(dynamicString);
    }

    public void setCommandExamples(DynamicString[] dynamicStringArray) {
        this.commandExamples = new ArrayList();
        for (int i2 = 0; i2 < dynamicStringArray.length; ++i2) {
            this.commandExamples.add(new TeleprompterTextEntryImpl(dynamicStringArray[i2]));
        }
    }

    @Override
    public int getTeleprompterType() {
        return this.teleprompterType;
    }

    @Override
    public List getCommandExamples() {
        return this.commandExamples;
    }

    @Override
    public TeleprompterTextEntry getHeadlineTitle() {
        return this.headline;
    }
}

