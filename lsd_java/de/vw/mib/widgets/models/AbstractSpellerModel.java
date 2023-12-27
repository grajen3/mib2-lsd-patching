/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.font.CursorManager;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.interfaces.WidgetCloneFactoryRegister;
import de.vw.mib.widgets.log.Loggable;
import de.vw.mib.widgets.models.BackgroundContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.PreviewLineChangedListener;
import de.vw.mib.widgets.speller.SpellerChangedListener;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates;

public interface AbstractSpellerModel
extends BackgroundContainerModel,
Focusable,
WidgetCloneFactoryRegister,
PreviewLineChangedListener,
Loggable {
    public static final int PID_BASE;
    public static final int PID_ALPHABET_INDEX;
    public static final int PID_ALPHABET_LIST;
    public static final int PID_CHAR_ENCODING;
    public static final int PID_CHAR_MAX;
    public static final int PID_CHAR_MIN;
    public static final int PID_IMAGES_SEPARATOR;
    public static final int PID_INACTIVE_AREA_REF;
    public static final int PID_INFO_TEXT;
    public static final int PID_LANGUAGE_INDEX;
    public static final int PID_LANGUAGE_LIST;
    public static final int PID_LOWER_UPPER;
    public static final int PID_MATCH_COUNT;
    public static final int PID_MODE;
    public static final int PID_OK_ENABLED;
    public static final int PID_SHIFT_MODE;
    public static final int PID_SHOW_SUBSPELLER;
    public static final int PID_SPELLER_DATA;
    public static final int PID_SUBSPELLER_IMAGE_BACKGROUND;
    public static final int PID_SUBSPELLER_IMAGE_BACKGROUND_REF;
    public static final int PID_SUBSPELLER_INSETS;
    public static final int PID_SUBSPELLER_OFFSET_X;
    public static final int PID_SUBSPELLER_OFFSET_Y;
    public static final int PID_COUNT_ABSTRACT_SPELLER;
    public static final int CHARENCODING_BASE;
    public static final int CHARENCODING_NONE;
    public static final int CHARENCODING_UTF8;
    public static final int CHARENCODING_UTF8_BOTH;
    public static final int CHARENCODING_COUNT_ABSTRACT_SPELLER;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_ABSTRACT_SPELLER;
    public static final int LOWERUPPER_BASE;
    public static final int LOWERUPPER_LOWER;
    public static final int LOWERUPPER_UPPER;
    public static final int LOWERUPPER_COUNT_ABSTRACT_SPELLER;
    public static final int SHIFTSTATE_SENTENCE_AUTOMATISM_BASE;
    public static final int SHIFTSTATE_SENTENCE_AUTOMATISM_UPPER;
    public static final int SHIFTSTATE_SENTENCE_AUTOMATISM_LOWER;
    public static final int SHIFTSTATE_SENTENCE_AUTOMATISM_AUTOMATIC;
    public static final int SHIFTSTATE_SENTENCE_AUTOMATISM_COUNT;
    public static final int SHIFTSTATE_DEFAULT_NO_TOGGLING;
    public static final int CHARACTERS_TO_CHECK;
    public static final String STRING_SPACE;
    public static final String STRING_FULL_STOP;
    public static final String STRING_QUESTION_MARK;
    public static final String STRING_EXCLAMATION_MARK;
    public static final int MID_BASE;
    public static final int MID_MATCH;
    public static final int MID_FREE;
    public static final int MID_NONE_CAPITALIZATION;
    public static final int MID_COUNT_ABSTRACT_SPELLER;
    public static final int MODE_BASE;
    public static final int MODE_MATCH;
    public static final int MODE_FREE;
    public static final int MODE_COUNT_ABSTRACT_SPELLER;
    public static final int MODE_NONE_CAPITALIZATION;
    public static final int SHIFTMODE_BASE;
    public static final int SHIFTMODE_MANUAL;
    public static final int SHIFTMODE_AUTOMATIC;
    public static final int SID_BASE;
    public static final int SID_OK_ENABLED;
    public static final int SID_SHOW_SUBSPELLER;
    public static final int SID_COUNT_ABSTRACT_SPELLER;

    default public int get_alphabetIndex() {
    }

    default public void set_alphabetIndex(int n) {
    }

    default public String[] get_alphabetList() {
    }

    default public void set_alphabetList(String[] stringArray) {
    }

    default public int get_charEncoding() {
    }

    default public void set_charEncoding(int n) {
    }

    default public int get_charMax() {
    }

    default public void set_charMax(int n) {
    }

    default public int get_charMin() {
    }

    default public void set_charMin(int n) {
    }

    default public int get_languageIndex() {
    }

    default public void set_languageIndex(int n) {
    }

    default public void set_languageList(String[] stringArray) {
    }

    default public String[] get_languageList() {
    }

    default public int get_lowerUpper() {
    }

    default public void set_lowerUpper(int n) {
    }

    default public Image[] get_imagesSeparator() {
    }

    default public void set_imagesSeparator(Image[] imageArray) {
    }

    default public InactiveAreaModel get_inactiveAreaRef() {
    }

    default public void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
    }

    default public String get_infoText() {
    }

    default public void set_infoText(String string) {
    }

    default public int get_mode() {
    }

    default public void set_mode(int n) {
    }

    default public int get_matchCount() {
    }

    default public void set_matchCount(int n) {
    }

    default public boolean is_okEnabled() {
    }

    default public void set_okEnabled(boolean bl) {
    }

    default public int get_shiftMode() {
    }

    default public void set_shiftMode(int n) {
    }

    default public int getShiftState() {
    }

    default public void setShiftState(int n) {
    }

    default public int setNextShiftState() {
    }

    default public boolean is_showSubspeller() {
    }

    default public void set_showSubspeller(boolean bl) {
    }

    default public SpellerData get_spellerData() {
    }

    default public void set_spellerData(SpellerData spellerData) {
    }

    default public Insets get_subspellerInsets() {
    }

    default public void set_subspellerInsets(Insets insets) {
    }

    default public int get_subspellerOffsetX() {
    }

    default public void set_subspellerOffsetX(int n) {
    }

    default public int get_subspellerOffsetY() {
    }

    default public void set_subspellerOffsetY(int n) {
    }

    default public Alphabet getAlphabet() {
    }

    default public SpellerButtonModel getButton(SpellerElement spellerElement) {
    }

    default public SpellerButtonModel getButton(Alphabet alphabet, SpellerElement spellerElement, boolean bl, boolean bl2) {
    }

    default public Alphabet getCurrentAlphabet() {
    }

    default public String getCurrentAlphabetName() {
    }

    default public String getCurrentLanguageName() {
    }

    default public CursorManager getCursorManager() {
    }

    default public void setCursorManager(CursorManager cursorManager) {
    }

    default public boolean isInCharBounds(String string, int n) {
    }

    default public boolean isInCharBounds(String string, int n, int n2) {
    }

    default public boolean willCharMaxExceed(String string) {
    }

    default public boolean willCharMaxExceed(String string, String string2) {
    }

    default public boolean isCharMaxReached() {
    }

    default public boolean isCharMinReached() {
    }

    default public boolean isMode(int n) {
    }

    default public boolean isSelectionDefined() {
    }

    default public SpellerElementStates getSpellerElementStates() {
    }

    default public Alphabet getSubAlphabet() {
    }

    default public void setSubAlphabet(Alphabet alphabet) {
    }

    default public boolean isSuppressAlphabetErrors() {
    }

    default public SpellerButtonModel getTemplateForElement(SpellerElement spellerElement) {
    }

    default public boolean isSpellerLanguage(String string) {
    }

    default public void switchAlphabet(int n) {
    }

    default public void updateClones(Alphabet alphabet, boolean bl) {
    }

    default public void addSpellerChangedListener(SpellerChangedListener spellerChangedListener) {
    }

    default public int getCursorPosition() {
    }

    default public void setCursorPosition(int n) {
    }

    default public String getEnteredText() {
    }

    default public String getMatchCompletion() {
    }

    default public String getMatchText() {
    }

    default public int getSelectionEnd() {
    }

    default public int getSelectionStart() {
    }

    default public void removeSpellerChangedListener(SpellerChangedListener spellerChangedListener) {
    }
}

