/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.data;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.data.SpellerDataAdapter$SpellerDataAdapterPoolHolder;

public final class SpellerDataAdapter
extends SpellerData
implements PooledObject {
    protected static final Logger LOGGER = ServiceManager.loggerFactory.getLogger(2048);
    private static final SpellerData EMPTY_SPELLER_DATA = new SpellerData();
    private SpellerData rawSpellerData;
    static /* synthetic */ Class class$de$vw$mib$properties$values$SpellerData;

    public static SpellerDataAdapter getAdapter(SpellerData spellerData) {
        SpellerDataAdapter spellerDataAdapter = (SpellerDataAdapter)SpellerDataAdapter$SpellerDataAdapterPoolHolder.POOL.borrowObject();
        spellerDataAdapter.fillSpellerData(spellerData != null ? spellerData : EMPTY_SPELLER_DATA);
        if (spellerData != null && super.getClass() == (class$de$vw$mib$properties$values$SpellerData == null ? (class$de$vw$mib$properties$values$SpellerData = SpellerDataAdapter.class$("de.vw.mib.properties.values.SpellerData")) : class$de$vw$mib$properties$values$SpellerData)) {
            spellerDataAdapter.setRawSpellerData(spellerData);
        } else if (spellerData instanceof SpellerDataAdapter) {
            spellerDataAdapter.setRawSpellerData(((SpellerDataAdapter)spellerData).getRawSpellerData());
        } else {
            spellerDataAdapter.setRawSpellerData((SpellerData)EMPTY_SPELLER_DATA.clone());
        }
        return spellerDataAdapter;
    }

    public static SpellerDataAdapter getAdapter(SpellerData spellerData, SpellerData spellerData2) {
        SpellerDataAdapter spellerDataAdapter = SpellerDataAdapter.getAdapter(spellerData2);
        SpellerDataAdapter.removeAdapter(spellerData);
        return spellerDataAdapter;
    }

    public static boolean hasAnySelection(SpellerData spellerData) {
        boolean bl = false;
        if (spellerData != null && super.getClass() == (class$de$vw$mib$properties$values$SpellerData == null ? (class$de$vw$mib$properties$values$SpellerData = SpellerDataAdapter.class$("de.vw.mib.properties.values.SpellerData")) : class$de$vw$mib$properties$values$SpellerData)) {
            SpellerDataAdapter spellerDataAdapter = SpellerDataAdapter.getAdapter(spellerData);
            bl = spellerDataAdapter.hasAnySelection();
            SpellerDataAdapter.removeAdapter(spellerDataAdapter);
        } else if (spellerData instanceof SpellerDataAdapter) {
            bl = ((SpellerDataAdapter)spellerData).hasAnySelection();
        }
        return bl;
    }

    public static SpellerData removeAdapter(SpellerData spellerData) {
        SpellerData spellerData2 = spellerData;
        if (spellerData instanceof SpellerDataAdapter) {
            spellerData2 = ((SpellerDataAdapter)spellerData).getRawSpellerData();
            SpellerDataAdapter$SpellerDataAdapterPoolHolder.POOL.releaseObject((SpellerDataAdapter)spellerData);
        }
        return spellerData2;
    }

    protected SpellerDataAdapter() {
    }

    @Override
    public void backToPool() {
        this.fillSpellerData(EMPTY_SPELLER_DATA);
        this.reset();
    }

    protected void checkConsistency() {
        boolean bl;
        boolean bl2 = this.getEnteredText() != null && this.getEnteredText().length() > 0;
        boolean bl3 = this.getSelectionStart() != this.getSelectionEnd();
        boolean bl4 = bl = this.getSelectionStart() >= 0 && this.getEnteredText() != null && this.getSelectionStart() <= this.getEnteredText().length() && this.getSelectionStart() <= this.getSelectionEnd() && this.getEnteredText() != null && this.getSelectionEnd() <= this.getEnteredText().length();
        if (!bl2 && bl3) {
            LOGGER.warn(64).append("[SpellerDataAdapter]: ").append("No 'enteredText' but selection defined!").log();
        }
        if (bl2 && !bl) {
            LOGGER.warn(64).append("[SpellerDataAdapter]: ").append("Selection invalid!").log();
        }
    }

    protected void fillSpellerData(SpellerData spellerData) {
        this.fillSpellerData(spellerData.getAvailableCharacters(), spellerData.getCursorPosition(), spellerData.getEnteredText(), spellerData.getMatchCompletion(), spellerData.getMatchCount(), spellerData.getMatchText(), spellerData.getSelectionEnd(), spellerData.getSelectionStart(), spellerData.getUnavailableCharacters(), spellerData.getWordDatabaseNames());
    }

    protected void fillSpellerData(String string, int n, String string2, String string3, int n2, String string4, int n3, int n4, String string5, String[] stringArray) {
        super.setAvailableCharacters(string);
        super.setCursorPosition(n);
        super.setEnteredText(string2);
        super.setMatchCompletion(string3);
        super.setMatchCount(n2);
        super.setMatchText(string4);
        super.setSelectionEnd(n3);
        super.setSelectionStart(n4);
        super.setUnavailableCharacters(string5);
        super.setWordDatabaseNames(stringArray);
    }

    public void reset() {
        this.rawSpellerData = null;
    }

    public SpellerData getRawSpellerData() {
        return this.rawSpellerData;
    }

    protected void setRawSpellerData(SpellerData spellerData) {
        this.rawSpellerData = spellerData;
    }

    public boolean hasAnySelection() {
        boolean bl = this.getEnteredText() != null && this.getEnteredText().length() > 0;
        boolean bl2 = this.getSelectionStart() != this.getSelectionEnd();
        return bl && bl2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpellerDataAdapter");
        stringBuilder.append("[availableCharacters='").append(this.getAvailableCharacters()).append("'");
        stringBuilder.append(",unavailableCharacters='").append(this.getUnavailableCharacters()).append("'");
        stringBuilder.append(",enteredText='").append(this.getEnteredText()).append("'");
        stringBuilder.append(",matchText='").append(this.getMatchText()).append("'");
        stringBuilder.append(",matchCount=").append(this.getMatchCount());
        stringBuilder.append(",cursorPosition=").append(this.getCursorPosition());
        stringBuilder.append(",selectionStart=").append(this.getSelectionStart());
        stringBuilder.append(",selectionEnd=").append(this.getSelectionEnd());
        String[] stringArray = this.getWordDatabaseNames();
        if (stringArray != null) {
            stringBuilder.append(",wordDatabaseNames=[");
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                stringBuilder.append("[").append(stringArray[i2]).append("]");
            }
            stringBuilder.append("]");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

