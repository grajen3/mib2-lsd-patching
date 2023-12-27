/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.log.Loggable;
import de.vw.mib.widgets.speller.Alphabet;

public interface SpellerController
extends WidgetController,
Loggable,
PropertyChangedListener {
    public static final String IN_CURSORLEFTPRESS_NAME;
    public static final String IN_CURSORRIGHTPRESS_NAME;
    public static final String IN_DELETEPRESS_NAME;
    public static final String IN_DELETELONGPRESS_NAME;
    public static final String IN_OKPRESS_NAME;
    public static final String OUT_ALPHABETINDEXCHANGED_NAME;
    public static final String OUT_CURSORPOSITIONCHANGED_NAME;
    public static final String OUT_DELETED_NAME;
    public static final String OUT_KEYLONGPRESSED_NAME;
    public static final String OUT_KEYPRESSED_NAME;
    public static final String OUT_LANGUAGEINDEXCHANGED_NAME;
    public static final String OUT_LONGDELETED_NAME;
    public static final String OUT_OKLONGPRESSED_NAME;
    public static final String OUT_OKPRESSED_NAME;
    public static final String OUT_OK2LONGPRESSED_NAME;
    public static final String OUT_OK2PRESSED_NAME;
    public static final String OUT_OK3LONGPRESSED_NAME;
    public static final String OUT_OK3PRESSED_NAME;

    default public void fire_cursorLeftPress() {
    }

    default public void fire_cursorRightPress() {
    }

    default public void fire_deletePress() {
    }

    default public void fire_deleteLongPress() {
    }

    default public void fire_okPress() {
    }

    default public void fire_alphabetChanged() {
    }

    default public void fire_cursorPositionChanged(int n) {
    }

    default public void fire_deleted() {
    }

    default public void fire_keyLongPressed() {
    }

    default public void fire_keyPressed() {
    }

    default public void fire_languageChanged() {
    }

    default public void fire_longDeleted() {
    }

    default public void fire_okLongPressed() {
    }

    default public void fire_okPressed() {
    }

    default public void fire_ok2LongPressed() {
    }

    default public void fire_ok2Pressed() {
    }

    default public void fire_ok3LongPressed() {
    }

    default public void fire_ok3Pressed() {
    }

    default public String getLastEnteredCharacter() {
    }

    default public void setLastEnteredCharacter(String string) {
    }

    default public void closeSubSpeller() {
    }

    default public void openSubSpeller(Alphabet alphabet) {
    }

    default public void toggleLowerUpperCase() {
    }
}

