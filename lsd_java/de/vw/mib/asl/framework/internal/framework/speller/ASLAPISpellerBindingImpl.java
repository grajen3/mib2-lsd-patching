/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.speller;

import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerBinding;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.Util;
import java.util.ArrayList;

public class ASLAPISpellerBindingImpl
implements ASLAPISpellerBinding {
    private static final int ADD_CHAR;
    private static final int ADD_CHAR__TEXT;
    private static final int ADD_CHAR__SELECTION_START;
    private static final int ADD_CHAR__SELECTION_END;
    private static final int DEL_CHAR;
    private static final int ADD_CHAR_BLOCK;
    private static final int DEL_CHAR_BLOCK;
    private static final int SET_CURSOR_POS;
    private static final int SET_CURSOR_POS__POS;
    static final int UNSET_ID;
    private final int addCharServiceId;
    private final int delCharServiceId;
    private final int addCharBlockServiceId;
    private final int delCharBlockServiceId;
    private int setCursorPosServiceId = -1;
    private final int spellerPropertyId;
    private final ArrayList spellerBlocks;
    private SpellerData spellerData = new SpellerData();

    @Override
    public boolean handleEvent(EventGeneric eventGeneric) {
        int n = this.resolveEventId(eventGeneric.getReceiverEventId());
        switch (n) {
            case 0: {
                this.onAddChar(eventGeneric);
                break;
            }
            case 2: {
                this.onAddCharBlock(eventGeneric);
                break;
            }
            case 1: {
                this.onDelChar(eventGeneric);
                break;
            }
            case 3: {
                this.onDelCharBlock(eventGeneric);
                break;
            }
            case 4: {
                this.onSetCursorPos(eventGeneric);
                break;
            }
        }
        return -1 != n;
    }

    @Override
    public void resetSpellerData() {
        this.initSpeller("");
    }

    @Override
    public void initSpeller(String string) {
        if (null == string) {
            string = "";
        }
        int n = string.length();
        this.spellerData = new SpellerData();
        this.spellerData.setEnteredText(string);
        this.spellerData.setCursorPosition(n);
        if (null != this.spellerBlocks) {
            this.spellerBlocks.clear();
            if (0 < n) {
                this.spellerBlocks.add(string);
            }
        }
        this.updateSpellerData();
    }

    @Override
    public SpellerData getSpellerData() {
        return this.spellerData;
    }

    @Override
    public void setAvailableCharacters(String string) {
        this.spellerData.setAvailableCharacters(string);
        this.updateSpellerData();
    }

    @Override
    public void setMatchCount(int n) {
        this.spellerData.setMatchCount(n);
        this.updateSpellerData();
    }

    private int resolveEventId(int n) {
        int n2 = this.addCharServiceId == n ? 0 : (this.delCharServiceId == n ? 1 : (this.setCursorPosServiceId == n ? 4 : (this.addCharBlockServiceId == n ? 2 : (this.delCharBlockServiceId == n ? 3 : -1))));
        return n2;
    }

    private void onAddChar(EventGeneric eventGeneric) {
        this.handleAddChar_internal(eventGeneric);
    }

    private void onAddCharBlock(EventGeneric eventGeneric) {
        this.handleAddChar_internal(eventGeneric);
    }

    private void handleAddChar_internal(EventGeneric eventGeneric) {
        int n;
        int n2;
        String string = eventGeneric.getString(0);
        int n3 = string.length();
        String string2 = this.spellerData.getEnteredText();
        if (this.spellerData.isSelectionActive()) {
            n2 = this.spellerData.getSelectionStart();
            n = this.spellerData.getSelectionEnd();
            this.spellerData.setEnteredText(new StringBuffer().append(string2.substring(0, n2)).append(string).append(string2.substring(n)).toString());
            this.spellerData.setCursorPosition(n2 + n3);
        } else if (0 < n3) {
            n2 = Math.min(this.spellerData.getCursorPosition(), string2.length());
            this.spellerData.setEnteredText(new StringBuffer().append(string2.substring(0, n2)).append(string).append(string2.substring(n2)).toString());
            this.spellerData.setCursorPosition(n2 + n3);
        }
        if (1 < eventGeneric.getParamCount()) {
            n2 = eventGeneric.getInt(1);
            n = eventGeneric.getInt(2);
            this.spellerData.setSelectionStart(n2);
            this.spellerData.setSelectionEnd(n);
        }
        if (null != this.spellerBlocks && 0 < n3) {
            this.spellerBlocks.add(string);
        }
        this.updateSpellerData();
    }

    private void onDelChar(EventGeneric eventGeneric) {
        this.spellerData.resetSelection();
        String string = this.spellerData.getEnteredText();
        int n = this.spellerData.getCursorPosition();
        if (!Util.isNullOrEmpty(string) && 0 < n) {
            if (null != this.spellerBlocks) {
                int n2 = this.spellerBlocks.size();
                if (0 < n2) {
                    String string2 = (String)this.spellerBlocks.get(n2 - 1);
                    int n3 = string2.length();
                    if (1 == n3) {
                        this.spellerBlocks.remove(n2 - 1);
                    } else {
                        this.spellerBlocks.set(n2 - 1, string2.substring(0, n3 - 1));
                    }
                }
                this.updateSpellerDataWithBlocks();
            } else {
                this.spellerData.setEnteredText(new StringBuffer().append(string.substring(0, n - 1)).append(string.substring(n)).toString());
                this.spellerData.setCursorPosition(n - 1);
                this.updateSpellerData();
            }
        }
    }

    private void onDelCharBlock(EventGeneric eventGeneric) {
        int n;
        if (null != this.spellerBlocks && 0 < (n = this.spellerBlocks.size())) {
            this.spellerBlocks.remove(n - 1);
            this.updateSpellerDataWithBlocks();
        }
    }

    private void onSetCursorPos(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.spellerData.setCursorPosition(n);
        this.updateSpellerData();
    }

    private void updateSpellerDataWithBlocks() {
        int n = this.spellerBlocks.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < n; ++i2) {
            stringBuffer.append(this.spellerBlocks.get(i2));
        }
        String string = stringBuffer.toString();
        this.spellerData.setEnteredText(string);
        this.spellerData.setCursorPosition(string.length());
        this.updateSpellerData();
    }

    private void updateSpellerData() {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(this.spellerPropertyId, this.spellerData);
    }

    ASLAPISpellerBindingImpl(int n, int n2, int n3, int n4) {
        this.spellerPropertyId = n;
        this.addCharServiceId = n2;
        this.delCharServiceId = n3;
        this.addCharBlockServiceId = -1;
        this.delCharBlockServiceId = -1;
        this.spellerBlocks = null;
        this.setCursorPosServiceId = n4;
    }

    ASLAPISpellerBindingImpl(int n, int n2, int n3, int n4, int n5, int n6) {
        this.spellerPropertyId = n;
        this.addCharServiceId = n2;
        this.delCharServiceId = n3;
        this.addCharBlockServiceId = n4;
        this.delCharBlockServiceId = n5;
        this.spellerBlocks = new ArrayList();
        this.setCursorPosServiceId = n6;
    }
}

