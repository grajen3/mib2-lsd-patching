/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.speller;

import de.vw.mib.asl.api.car.speller.Speller;
import de.vw.mib.asl.api.car.speller.SpellerDelegate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.Util;
import java.util.ArrayList;

public class GenericSpeller
implements Speller {
    private final int CURSOR_POS_START;
    private final int spellerId;
    private final int dataPoolSpellerDataPropertyId;
    private SpellerDelegate spellerDelegate;
    private boolean supportsSpellerBlocks;
    private SpellerData _spellerData;
    private ArrayList _spellerBlocks;

    public GenericSpeller(int n, int n2) {
        this.CURSOR_POS_START = 0;
        this.spellerId = n;
        this.dataPoolSpellerDataPropertyId = n2;
    }

    @Override
    public void setCursorPosition(int n) {
        if (this.getSpellerData().isSelectionActive()) {
            this.getSpellerData().resetSelection();
        }
        this.getSpellerData().setCursorPosition(n);
        this.updateSpellerDataProperty();
    }

    @Override
    public void deleteCharacterBlock() {
        if (!Util.isNullOrEmpty(this.getSpellerData().getEnteredText()) && this.getSupportsSpellerBlocks() && this.getSpellerBlocks().size() > 0) {
            this.getSpellerBlocks().remove(this.getSpellerBlocks().size() - 1);
            this.updateSpellerDataWithSpellerBlocks();
        }
    }

    @Override
    public void deleteCharacter() {
        if (this.getSpellerData().getCursorPosition() > 0 && !Util.isNullOrEmpty(this.getSpellerData().getEnteredText())) {
            if (this.getSupportsSpellerBlocks() && this.getSpellerBlocks().size() > 0) {
                if (((String)this.getSpellerBlocks().get(this.getSpellerBlocks().size() - 1)).length() == 1) {
                    this.getSpellerBlocks().remove(this.getSpellerBlocks().size() - 1);
                } else {
                    String string = (String)this.getSpellerBlocks().get(this.getSpellerBlocks().size() - 1);
                    this.getSpellerBlocks().remove(this.getSpellerBlocks().size() - 1);
                    string = string.substring(0, string.length() - 1);
                    for (int i2 = 0; i2 < string.length(); ++i2) {
                        this.getSpellerBlocks().add(string.substring(i2, i2 + 1));
                    }
                }
                this.updateSpellerDataWithSpellerBlocks();
            } else {
                if (this.getSpellerData().isSelectionActive()) {
                    this.replaceSelectionWithinSpellerDataWith("");
                    this.getSpellerData().resetSelection();
                } else {
                    this.getSpellerData().setEnteredText(new StringBuffer().append(this.getSpellerData().getEnteredText().substring(0, this.getSpellerData().getCursorPosition() - 1)).append(this.getSpellerData().getEnteredText().substring(this.getSpellerData().getCursorPosition())).toString());
                    this.getSpellerData().setCursorPosition(this.getSpellerData().getCursorPosition() - 1);
                }
                this.updateSpellerDataProperty();
            }
        }
    }

    @Override
    public void deleteAllCharacters() {
        this.getSpellerData().setEnteredText("");
        this.getSpellerData().setCursorPosition(0);
        if (this.getSpellerData().isSelectionActive()) {
            this.getSpellerData().resetSelection();
        }
        this.updateSpellerDataProperty();
    }

    @Override
    public void addCharacter(String string) {
        if (this.getSpellerData().getSelectionStart() != this.getSpellerData().getSelectionEnd()) {
            this.getSpellerData().setEnteredText(string);
            this.getSpellerData().setCursorPosition(1);
        } else {
            this.getSpellerData().setEnteredText(new StringBuffer().append(this.getSpellerData().getEnteredText().substring(0, this.getSpellerData().getCursorPosition())).append(string).append(this.getSpellerData().getEnteredText().substring(this.getSpellerData().getCursorPosition())).toString());
            this.getSpellerData().setCursorPosition(this.getSpellerData().getCursorPosition() + string.length());
        }
        this.getSpellerData().setSelectionStart(0);
        this.getSpellerData().setSelectionEnd(0);
        this.updateSpellerDataProperty();
    }

    @Override
    public void addCharacter(String string, int n, int n2, int n3) {
        if (this.getSpellerData().isSelectionActive()) {
            this.replaceSelectionWithinSpellerDataWith(string);
            this.getSpellerData().resetSelection();
        } else {
            this.insertAtCursorPositionWithinSpellerData(string);
            if (n2 < n3) {
                this.getSpellerData().setSelectionStart(n2);
                this.getSpellerData().setSelectionEnd(n3);
            }
        }
        this.updateSpellerDataProperty();
    }

    @Override
    public void addCharacterBlock(String string) {
        this.addCharacter(string);
        this.getSpellerBlocks().add(string);
    }

    @Override
    public int getSpellerId() {
        return this.spellerId;
    }

    @Override
    public String getEnteredText() {
        return this.getSpellerData().getEnteredText();
    }

    @Override
    public void setEnteredText(String string) {
        this.getSpellerData().setEnteredText(string);
        this.initSpeller(string);
    }

    @Override
    public void setSupportsSpellerBlocks(boolean bl) {
        this.supportsSpellerBlocks = bl;
    }

    @Override
    public boolean getSupportsSpellerBlocks() {
        return this.supportsSpellerBlocks;
    }

    @Override
    public void setDelegate(SpellerDelegate spellerDelegate) {
        this.spellerDelegate = spellerDelegate;
    }

    @Override
    public SpellerDelegate getSpellerDelegate() {
        return this.spellerDelegate;
    }

    private SpellerData getSpellerData() {
        if (this._spellerData == null) {
            this._spellerData = new SpellerData();
        }
        return this._spellerData;
    }

    private void setSpellerData(SpellerData spellerData) {
        this._spellerData = spellerData;
    }

    private ArrayList getSpellerBlocks() {
        if (this._spellerBlocks == null) {
            this._spellerBlocks = new ArrayList();
        }
        return this._spellerBlocks;
    }

    private int getDataPoolSpellerDataPropertyId() {
        return this.dataPoolSpellerDataPropertyId;
    }

    private void resetSpellerData(String string) {
        this.setSpellerData(new SpellerData());
        this.setEnteredText(string);
    }

    private void replaceSelectionWithinSpellerDataWith(String string) {
        if (this.getSpellerData().isSelectionActive()) {
            int n = this.getSpellerData().getSelectionStart();
            int n2 = this.getSpellerData().getSelectionEnd();
            int n3 = this.getSpellerData().getEnteredText().length();
            String string2 = this.getSpellerData().getEnteredText().substring(0, Math.min(n, n3));
            String string3 = this.getSpellerData().getEnteredText().substring(Math.min(n2, n3));
            this.getSpellerData().setEnteredText(string2.concat(string).concat(string3));
            this.getSpellerData().setCursorPosition(string2.length() + string.length());
        }
    }

    private void insertAtCursorPositionWithinSpellerData(String string) {
        if (!this.getSpellerData().isSelectionActive()) {
            int n = this.getSpellerData().getCursorPosition();
            int n2 = this.getSpellerData().getEnteredText().length();
            String string2 = this.getSpellerData().getEnteredText().substring(0, Math.min(n, n2));
            String string3 = this.getSpellerData().getEnteredText().substring(Math.min(n, n2));
            this.getSpellerData().setEnteredText(string2.concat(string).concat(string3));
            this.getSpellerData().setCursorPosition(string2.length() + string.length());
        }
    }

    private void initSpeller(String string) {
        this.getSpellerData().setEnteredText(string);
        this.getSpellerData().setCursorPosition(string.length());
        if (string.length() != 0) {
            this.getSpellerData().setSelectionStart(0);
            this.getSpellerData().setSelectionEnd(string.length());
        }
        this.updateSpellerDataProperty();
        if (this.getSupportsSpellerBlocks() && !Util.isNullOrEmpty(string)) {
            this.getSpellerBlocks().add(string);
        }
    }

    private void updateSpellerDataWithSpellerBlocks() {
        String string = "";
        int n = this.getSpellerBlocks().size();
        for (int i2 = 0; i2 < n; ++i2) {
            string = new StringBuffer().append(string).append(this.getSpellerBlocks().get(i2)).toString();
        }
        this.getSpellerData().setEnteredText(string);
        this.getSpellerData().setCursorPosition(this.getSpellerData().getEnteredText().length());
        this.updateSpellerDataProperty();
    }

    private void updateSpellerDataProperty() {
        ServiceManager.aslPropertyManager.valueChangedSpellerData(this.getDataPoolSpellerDataPropertyId(), this.getSpellerData());
    }

    private Logger getContextLogger() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
    }
}

