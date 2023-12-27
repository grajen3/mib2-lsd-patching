/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.CursorManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.widgets.controller.AbstractSpellerController$InactiveAreaHandler;
import de.vw.mib.widgets.controller.AbstractSpellerController$SpellerButtonHandler;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.SpellerController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.log.Logger;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates;
import java.util.List;

public abstract class AbstractSpellerController
extends AbstractWidgetController
implements SpellerController,
TouchDelegatable {
    private static final int LOG_CLASSIFIER;
    private AbstractSpellerController$InactiveAreaHandler inactiveAreaHandler;
    protected String lastEnteredCharacter;
    protected String spellerDataEnteredText;
    private AbstractSpellerController$SpellerButtonHandler spellerButtonHandler;
    protected TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
        this.inactiveAreaHandler = new AbstractSpellerController$InactiveAreaHandler(this);
        this.lastEnteredCharacter = "";
        this.spellerDataEnteredText = "";
        this.spellerButtonHandler = new AbstractSpellerController$SpellerButtonHandler(this);
    }

    @Override
    public void init() {
        super.init();
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (this.spellerButtonHandler == null) {
            this.spellerButtonHandler = new AbstractSpellerController$SpellerButtonHandler(this);
        }
        this.touchDelegator = new DefaultTouchDelegator(this, this.spellerButtonHandler);
        if (abstractSpellerModel != null) {
            abstractSpellerModel.removePropertyChangedListener(this);
            abstractSpellerModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        this.closeSubSpeller();
        this.spellerButtonHandler = null;
        this.touchDelegator = null;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (abstractSpellerModel != null) {
            abstractSpellerModel.removePropertyChangedListener(this);
        }
        super.deInit();
    }

    @Override
    public final String getLastEnteredCharacter() {
        if (this.lastEnteredCharacter == null) {
            return "";
        }
        return this.lastEnteredCharacter;
    }

    @Override
    public final void setLastEnteredCharacter(String string) {
        this.lastEnteredCharacter = string;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("cursorLeftPress".equals(string)) {
            this.fire_cursorLeftPress();
            bl = true;
        } else if ("cursorRightPress".equals(string)) {
            this.fire_cursorRightPress();
            bl = true;
        } else if ("deletePress".equals(string)) {
            this.fire_deletePress();
            bl = true;
        } else if ("deleteLongPress".equals(string)) {
            this.fire_deleteLongPress();
            bl = true;
        } else if ("okPress".equals(string)) {
            this.fire_okPress();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        boolean bl = this.touchDelegator.forwardTouchEvent(touchEvent);
        SpellerButtonModel spellerButtonModel = (SpellerButtonModel)this.touchDelegator.getUtilizedWidget();
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerElementStates spellerElementStates = abstractSpellerModel.getSpellerElementStates();
        if (spellerButtonModel != null) {
            spellerElementStates.setPressed(spellerButtonModel.getSpellerElement(), spellerButtonModel.isPressed());
        } else {
            spellerElementStates.releaseAllPressed();
        }
        return bl;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 48: {
                this.spellerDataEnteredText = ((AbstractSpellerModel)this.getWidget()).get_spellerData().getEnteredText();
                break;
            }
        }
    }

    @Override
    public void findActiveWidgets(List list, TouchEvent touchEvent) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        boolean bl = abstractSpellerModel.getSubAlphabet() != null;
        Alphabet alphabet = bl ? abstractSpellerModel.getSubAlphabet() : abstractSpellerModel.getAlphabet();
        SpellerButtonModel spellerButtonModel = this.findTouchedSpellerButton(alphabet, touchEvent);
        if (spellerButtonModel == null && bl) {
            alphabet = abstractSpellerModel.getAlphabet();
            spellerButtonModel = this.findTouchedSpellerButton(alphabet, touchEvent);
        }
        if (spellerButtonModel != null) {
            list.add(spellerButtonModel);
        }
    }

    @Override
    public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
        SpellerButtonModel spellerButtonModel = (SpellerButtonModel)widgetModel;
        this.prepareSpellerButton(spellerButtonModel);
        this.spellerButtonHandler.setSpellerButton(spellerButtonModel);
    }

    @Override
    public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
        SpellerButtonModel spellerButtonModel = (SpellerButtonModel)widgetModel;
        switch (touchEvent.getType()) {
            case 1: 
            case 6: {
                if (!bl) break;
                this.trace(SpellerLogger.getLogger()).append(spellerButtonModel.getSpellerElement()).append(" is going to be touched.").log();
                break;
            }
            case 0: 
            case 2: 
            case 11: {
                if (!bl) break;
                this.trace(SpellerLogger.getLogger()).append(spellerButtonModel.getSpellerElement()).append(" will have been touched.").log();
                break;
            }
        }
        if (!bl) {
            bl = !bl;
        }
        return bl;
    }

    @Override
    public void fire_cursorLeftPress() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        CursorManager cursorManager = abstractSpellerModel.getCursorManager();
        if (cursorManager != null) {
            cursorManager.moveCursorLeft();
        }
    }

    @Override
    public void fire_cursorRightPress() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        CursorManager cursorManager = abstractSpellerModel.getCursorManager();
        if (cursorManager != null) {
            cursorManager.moveCursorRight();
        }
    }

    @Override
    public void fire_deletePress() {
        boolean bl;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        CursorManager cursorManager = abstractSpellerModel.getCursorManager();
        boolean bl2 = bl = cursorManager == null || cursorManager.isDeleteAllowed();
        if (bl) {
            this.fire_deleted();
        }
    }

    @Override
    public void fire_deleteLongPress() {
        boolean bl;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        CursorManager cursorManager = abstractSpellerModel.getCursorManager();
        boolean bl2 = bl = cursorManager == null || cursorManager.isDeleteAllowed();
        if (bl) {
            this.fire_longDeleted();
        }
    }

    @Override
    public void fire_okPress() {
        this.fire_okPressed();
    }

    protected final void fireSpellerEvent(String string) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerData spellerData = abstractSpellerModel.get_spellerData();
        int n = spellerData != null ? spellerData.getCursorPosition() : 0;
        this.fireSpellerEvent(string, n);
    }

    protected final void fireSpellerEvent(String string, int n) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerData spellerData = abstractSpellerModel.get_spellerData();
        int n2 = spellerData != null ? spellerData.getSelectionStart() : 0;
        int n3 = spellerData != null ? spellerData.getSelectionEnd() : 0;
        this.fireSpellerEvent(string, this.getLastEnteredCharacter(), n, n2, n3);
    }

    @Override
    public void fire_okPressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("okPressed");
        }
    }

    @Override
    public void fire_okLongPressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("okLongPressed");
        }
    }

    @Override
    public void fire_ok2Pressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("ok2Pressed");
        }
    }

    @Override
    public void fire_ok2LongPressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("ok2LongPressed");
        }
    }

    @Override
    public void fire_ok3Pressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("ok3Pressed");
        }
    }

    @Override
    public void fire_ok3LongPressed() {
        if (this.isCharMinReached()) {
            this.fireSpellerEvent("ok3LongPressed");
        }
    }

    @Override
    public void fire_deleted() {
        this.handleCapitalization();
        this.fireSpellerEvent("deleted");
    }

    @Override
    public void fire_longDeleted() {
        this.handleCapitalization();
        this.fireSpellerEvent("longDeleted");
    }

    @Override
    public void fire_keyPressed() {
        boolean bl;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerData spellerData = abstractSpellerModel.get_spellerData();
        int n = spellerData != null ? spellerData.getSelectionStart() : 0;
        int n2 = spellerData != null ? spellerData.getSelectionEnd() : 0;
        int n3 = n2 - n;
        if (spellerData != null && ((bl = abstractSpellerModel.isInCharBounds(this.spellerDataEnteredText, abstractSpellerModel.get_charMax() - 1)) || !bl && n3 > 0)) {
            this.handleCapitalization();
            this.fireSpellerEvent("keyPressed");
        }
    }

    @Override
    public void fire_keyLongPressed() {
        if (!this.isCharMaxReached()) {
            this.handleCapitalization();
            this.fireSpellerEvent("keyLongPressed");
        }
    }

    @Override
    public void fire_alphabetChanged() {
        this.fireIntegerEvent("alphabetIndexChanged", ((AbstractSpellerModel)this.getWidget()).get_alphabetIndex());
    }

    @Override
    public void fire_languageChanged() {
        this.fireIntegerEvent("languageIndexChanged", ((AbstractSpellerModel)this.getWidget()).get_languageIndex());
    }

    @Override
    public void fire_cursorPositionChanged(int n) {
        this.handleCapitalization();
        this.fireSpellerEvent("cursorPositionChanged", n);
    }

    @Override
    public void closeSubSpeller() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        Alphabet alphabet = abstractSpellerModel.getSubAlphabet();
        if (alphabet != null) {
            abstractSpellerModel.setSubAlphabet(null);
            InactiveAreaModel inactiveAreaModel = abstractSpellerModel.get_inactiveAreaRef();
            if (inactiveAreaModel != null) {
                WidgetController widgetController = inactiveAreaModel.getController();
                if (widgetController != null) {
                    widgetController.removeOutEventListener(this.inactiveAreaHandler);
                }
                inactiveAreaModel.unFocus();
                inactiveAreaModel.set_visible(false);
                inactiveAreaModel.setAdditionalExclusionAreas(null);
            } else {
                this.error(SpellerLogger.getLogger()).append("Property 'inactiveAreaRef' is not properly initialized!").log();
            }
            this.onSubSpellerClosed();
        }
    }

    protected void onAlphabetSwitch(int n) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        abstractSpellerModel.switchAlphabet(n);
        this.fire_alphabetChanged();
    }

    protected void onSubSpellerClosed() {
    }

    protected void onSubSpellerOpened() {
    }

    @Override
    public void openSubSpeller(Alphabet alphabet) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        abstractSpellerModel.setSubAlphabet(alphabet);
        InactiveAreaModel inactiveAreaModel = abstractSpellerModel.get_inactiveAreaRef();
        if (inactiveAreaModel != null) {
            WidgetController widgetController = inactiveAreaModel.getController();
            if (widgetController != null) {
                widgetController.addOutEventListener(this.inactiveAreaHandler);
            }
            inactiveAreaModel.focus(abstractSpellerModel, true);
            inactiveAreaModel.set_visible(true);
            SpellerElement spellerElement = alphabet.getParent();
            Rectangle rectangle = new Rectangle(spellerElement.getAbsX(), spellerElement.getAbsY(), spellerElement.getWidth(), spellerElement.getHeight());
            inactiveAreaModel.setAdditionalExclusionAreas(new Rectangle[]{rectangle});
        } else {
            this.error(SpellerLogger.getLogger()).append("Property 'inactiveAreaRef' is not properly initialized!").log();
        }
        this.onSubSpellerOpened();
    }

    private SpellerButtonModel findTouchedSpellerButton(Alphabet alphabet, TouchEvent touchEvent) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        boolean bl = abstractSpellerModel.getSubAlphabet() != null;
        boolean bl2 = alphabet == abstractSpellerModel.getSubAlphabet();
        int n = touchEvent.getX();
        int n2 = touchEvent.getY();
        SpellerButtonModel spellerButtonModel = null;
        SpellerElement spellerElement = null;
        boolean bl3 = false;
        if (bl && !bl2) {
            Alphabet alphabet2 = abstractSpellerModel.getSubAlphabet();
            spellerElement = alphabet2.getParent();
            SpellerButtonModel spellerButtonModel2 = abstractSpellerModel.getButton(spellerElement);
            bl3 = spellerButtonModel2.is_visible() && spellerButtonModel2.get_alpha() > 0 && spellerButtonModel2.isAbsPointInside(n, n2);
        } else if (alphabet != null) {
            for (int i2 = alphabet.getElementCount() - 1; i2 >= 0; --i2) {
                spellerElement = alphabet.getElement(i2);
                SpellerButtonModel spellerButtonModel3 = abstractSpellerModel.getButton(spellerElement);
                boolean bl4 = bl3 = spellerButtonModel3 != null && spellerButtonModel3.is_visible() && spellerButtonModel3.get_alpha() > 0 && spellerButtonModel3.isAbsPointInside(n, n2);
                if (bl3) break;
            }
        }
        if (bl3) {
            spellerButtonModel = spellerElement != null ? abstractSpellerModel.getButton(spellerElement) : null;
        }
        return spellerButtonModel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void prepareSpellerButton(SpellerButtonModel spellerButtonModel) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerElementStates spellerElementStates = abstractSpellerModel.getSpellerElementStates();
        SpellerElement spellerElement = spellerButtonModel.getSpellerElement();
        abstractSpellerModel.disableAnimations();
        try {
            spellerButtonModel.set_enabled(spellerElementStates.isEnabled(spellerElement));
            spellerButtonModel.setPressed(spellerElementStates.isPressed(spellerElement));
        }
        finally {
            abstractSpellerModel.enableAnimations();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void resolveFire(boolean bl, SpellerButtonModel spellerButtonModel) {
        String string;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        SpellerElement spellerElement = spellerButtonModel.getSpellerElement();
        String string2 = string = spellerElement != null ? spellerElement.getReturnFunction() : "";
        if (string.equalsIgnoreCase("FUNC_NONE")) {
            if (spellerElement != null) {
                this.lastEnteredCharacter = spellerElement.getReturnValue();
                CursorManager cursorManager = abstractSpellerModel.getCursorManager();
                if (cursorManager != null) {
                    for (int i2 = 0; i2 < this.lastEnteredCharacter.length(); ++i2) {
                        cursorManager.updateCursorPositionByNextInsertionCharacter(this.lastEnteredCharacter.charAt(i2));
                    }
                }
                if (!bl) {
                    this.fire_keyPressed();
                } else {
                    this.fire_keyLongPressed();
                }
                this.spellerDataEnteredText = new StringBuffer().append(this.spellerDataEnteredText).append(this.lastEnteredCharacter).toString();
                this.lastEnteredCharacter = "";
            }
            this.closeSubSpeller();
            return;
        }
        if (string.equalsIgnoreCase("FUNC_OK")) {
            if (!bl) {
                this.fire_okPressed();
                return;
            } else {
                this.fire_okLongPressed();
            }
            return;
        }
        if (string.equalsIgnoreCase("FUNC_OK2")) {
            if (!bl) {
                this.fire_ok2Pressed();
                return;
            } else {
                this.fire_ok2LongPressed();
            }
            return;
        }
        if (string.equalsIgnoreCase("FUNC_OK3")) {
            if (!bl) {
                this.fire_ok3Pressed();
                return;
            } else {
                this.fire_ok3LongPressed();
            }
            return;
        }
        if (string.equalsIgnoreCase("FUNC_DEL")) {
            if (bl) {
                this.fire_deleteLongPress();
                return;
            } else {
                this.fire_deletePress();
            }
            return;
        }
        if (string.equalsIgnoreCase("FUNC_SHIFT")) {
            if (bl) return;
            int n = abstractSpellerModel.setNextShiftState();
            switch (abstractSpellerModel.get_shiftMode()) {
                case 1: {
                    spellerButtonModel.set_stateOffset(n);
                    switch (n) {
                        case 1: {
                            if (!this.isLowerUpperCase(1)) return;
                            this.toggleLowerUpperCase();
                            return;
                        }
                        case 0: {
                            if (!this.isLowerUpperCase(0)) return;
                            this.toggleLowerUpperCase();
                            return;
                        }
                        case 2: {
                            this.handleCapitalization();
                            return;
                        }
                        default: {
                            return;
                        }
                    }
                }
                default: {
                    this.toggleLowerUpperCase();
                    return;
                }
            }
        }
        if (string.toUpperCase().startsWith("FUNC_ALT")) {
            if (bl) return;
            spellerButtonModel.stopInternalAnimations();
            this.switchAlphabet(string.toUpperCase());
            return;
        } else if (string.equalsIgnoreCase("FUNC_LANG")) {
            if (bl) return;
            this.fire_languageChanged();
            return;
        } else if (string.equalsIgnoreCase("FUNC_CURSOR_LEFT")) {
            if (bl) return;
            this.fire_cursorLeftPress();
            return;
        } else if (string.equalsIgnoreCase("FUNC_CURSOR_RIGHT")) {
            if (bl) return;
            this.fire_cursorRightPress();
            return;
        } else if (string.equalsIgnoreCase("FUNC_ONLY_SUBSPELLER")) {
            if (abstractSpellerModel != null && abstractSpellerModel.getSubAlphabet() == null) {
                Alphabet alphabet;
                SpellerElementStates spellerElementStates = abstractSpellerModel.getSpellerElementStates();
                if (spellerElement == null || !spellerElementStates.isSubSpellerAvailable(spellerElement) || (alphabet = spellerElement.getSubAlphabet()) == null) return;
                this.openSubSpeller(alphabet);
                return;
            } else {
                this.closeSubSpeller();
            }
            return;
        } else {
            LogMessage logMessage = LOGGER.error(64);
            logMessage.append("Widget '").append(spellerButtonModel.getQualifiedName()).append("': Unable to process return function '").append(string.toUpperCase()).append("'.").log();
        }
    }

    @Override
    public final void toggleLowerUpperCase() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (abstractSpellerModel != null) {
            int n = abstractSpellerModel.get_lowerUpper();
            if (n == 0) {
                abstractSpellerModel.set_lowerUpper(1);
            } else if (n == 1) {
                abstractSpellerModel.set_lowerUpper(0);
            }
        }
    }

    private boolean isLowerUpperCase(int n) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (abstractSpellerModel != null) {
            return abstractSpellerModel.get_lowerUpper() == n;
        }
        return false;
    }

    private void switchAlphabet(String string) {
        String string2 = string.substring(string.lastIndexOf("_") + 1);
        try {
            int n = Integer.parseInt(string2);
            this.onAlphabetSwitch(n);
        }
        catch (NumberFormatException numberFormatException) {
            LogMessage logMessage = LOGGER.error(64);
            logMessage.append("Invalid alphabet index detected in function '").append(string).append("'!").log();
        }
    }

    protected boolean isCharMaxReached() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (abstractSpellerModel != null) {
            return abstractSpellerModel.isCharMaxReached();
        }
        return false;
    }

    protected boolean isCharMinReached() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        if (abstractSpellerModel != null) {
            return abstractSpellerModel.isCharMinReached();
        }
        return false;
    }

    protected final void handleCapitalization() {
        boolean bl;
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.getWidget();
        boolean bl2 = abstractSpellerModel.isMode(1);
        boolean bl3 = !abstractSpellerModel.isMode(256);
        boolean bl4 = abstractSpellerModel.get_shiftMode() == 1;
        boolean bl5 = bl = abstractSpellerModel.getShiftState() == 2;
        if (bl2 && bl3 && bl4 && bl) {
            this.handleCapitalizationFree(abstractSpellerModel);
        }
    }

    protected final void handleCapitalizationFree(AbstractSpellerModel abstractSpellerModel) {
        WidgetModel widgetModel = this.touchDelegator.getUtilizedWidget();
        if (widgetModel instanceof SpellerButtonModel) {
            SpellerButtonModel spellerButtonModel = (SpellerButtonModel)widgetModel;
            SpellerElement spellerElement = spellerButtonModel.getSpellerElement();
            String string = spellerElement.getReturnFunction();
            boolean bl = string.equalsIgnoreCase("FUNC_NONE");
            boolean bl2 = string.equalsIgnoreCase("FUNC_DEL");
            boolean bl3 = string.equalsIgnoreCase("FUNC_CURSOR_LEFT");
            boolean bl4 = string.equalsIgnoreCase("FUNC_CURSOR_RIGHT");
            boolean bl5 = bl3 || bl4;
            boolean bl6 = string.equalsIgnoreCase("FUNC_SHIFT");
            SpellerData spellerData = abstractSpellerModel.get_spellerData();
            if (spellerData == null) {
                return;
            }
            String string2 = spellerData.getEnteredText();
            String string3 = spellerElement.getReturnValue();
            int n = spellerData.getCursorPosition();
            if (string2 != null) {
                if (spellerData.isSelectionActive()) {
                    if (bl && this.isLowerUpperCase(1)) {
                        this.toggleLowerUpperCase();
                    } else if (bl6 && this.isLowerUpperCase(0)) {
                        this.toggleLowerUpperCase();
                    } else if (bl5) {
                        if (bl3) {
                            --n;
                        } else if (bl4) {
                            ++n;
                        }
                        boolean bl7 = this.isSentenceMark(string2, n);
                        if (n == 0 || bl7) {
                            if (this.isLowerUpperCase(0)) {
                                this.toggleLowerUpperCase();
                            }
                        } else if (!bl7 && this.isLowerUpperCase(1)) {
                            this.toggleLowerUpperCase();
                        }
                    }
                } else {
                    switch (string2.length()) {
                        case 0: {
                            if (bl && this.isLowerUpperCase(1)) {
                                this.toggleLowerUpperCase();
                                break;
                            }
                            if (!bl6 || !this.isLowerUpperCase(0)) break;
                            this.toggleLowerUpperCase();
                            break;
                        }
                        default: {
                            if (bl) {
                                String string4 = string2.substring(0, Math.min(string2.length(), n)).concat(string3).concat(string2.substring(Math.min(string2.length(), n)));
                                boolean bl8 = this.isSentenceMark(string4, n + 1);
                                if (bl8 && this.isLowerUpperCase(0)) {
                                    this.toggleLowerUpperCase();
                                    break;
                                }
                                if (bl8 || !this.isLowerUpperCase(1)) break;
                                this.toggleLowerUpperCase();
                                break;
                            }
                            if (bl2) {
                                int n2 = Math.max(0, n - 1);
                                if (n2 == 0) {
                                    if (!this.isLowerUpperCase(0)) break;
                                    this.toggleLowerUpperCase();
                                    break;
                                }
                                boolean bl9 = this.isSentenceMark(string2, n2);
                                if (bl9 && this.isLowerUpperCase(0)) {
                                    this.toggleLowerUpperCase();
                                    break;
                                }
                                if (bl9 || !this.isLowerUpperCase(1)) break;
                                this.toggleLowerUpperCase();
                                break;
                            }
                            if (bl6) {
                                boolean bl10 = this.isSentenceMark(string2, n);
                                if (bl10 && this.isLowerUpperCase(0)) {
                                    this.toggleLowerUpperCase();
                                    break;
                                }
                                if (bl10 || !this.isLowerUpperCase(1)) break;
                                this.toggleLowerUpperCase();
                                break;
                            }
                            if (!bl5) break;
                            if (bl3) {
                                --n;
                            } else if (bl4) {
                                ++n;
                            }
                            boolean bl11 = this.isSentenceMark(string2, n);
                            if (n == 0 || bl11) {
                                if (!this.isLowerUpperCase(0)) break;
                                this.toggleLowerUpperCase();
                                break;
                            }
                            if (bl11 || !this.isLowerUpperCase(1)) break;
                            this.toggleLowerUpperCase();
                        }
                    }
                }
            }
        }
    }

    private boolean isSentenceMark(String string, int n) {
        String string2;
        String string3 = this.getLastTwoCharacters(string, n);
        return string3.length() == 2 && string3.substring(1, 2).equals(" ") && ((string2 = string3.substring(0, 1)).equals(".") || string2.equals("?") || string2.equals("!"));
    }

    private String getLastTwoCharacters(String string, int n) {
        int n2 = n - 2;
        if (n2 >= 0 && string.length() >= 2 && n <= string.length()) {
            return string.substring(n2, n);
        }
        return "";
    }

    @Override
    public LogMessage error(Logger logger) {
        return logger.error(this);
    }

    @Override
    public LogMessage normal(Logger logger) {
        return logger.normal(this);
    }

    @Override
    public LogMessage trace(Logger logger) {
        return logger.trace(this);
    }

    @Override
    public LogMessage warn(Logger logger) {
        return logger.warn(this);
    }
}

