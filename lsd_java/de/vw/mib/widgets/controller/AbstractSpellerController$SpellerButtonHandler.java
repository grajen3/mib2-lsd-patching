/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.widgets.controller.AbstractSpellerController;
import de.vw.mib.widgets.event.OutEventAdapter;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates;

final class AbstractSpellerController$SpellerButtonHandler
extends OutEventAdapter {
    private boolean handledOnPressed = false;
    private String lastOutEvent = "";
    private SpellerButtonModel spellerButton;
    private final /* synthetic */ AbstractSpellerController this$0;

    public AbstractSpellerController$SpellerButtonHandler(AbstractSpellerController abstractSpellerController) {
        this.this$0 = abstractSpellerController;
    }

    public void setSpellerButton(SpellerButtonModel spellerButtonModel) {
        if (this.spellerButton != spellerButtonModel) {
            this.handledOnPressed = false;
            this.lastOutEvent = "";
        }
        this.spellerButton = spellerButtonModel;
    }

    @Override
    public void outHMIEventFired(String string) {
        if (this.spellerButton != null) {
            if ("pressed".equals(string)) {
                this.outEventFiredPressed();
            } else if ("released".equals(string)) {
                this.outEventFiredReleased();
            } else if ("longPressed".equals(string)) {
                this.outEventFiredLongPressed();
            } else if ("longReleased".equals(string)) {
                this.outEventFiredLongReleased();
            } else if ("cancelled".equals(string) || "cancelledLongpress".equals(string)) {
                this.outEventFiredCancelled();
            }
        }
        this.lastOutEvent = string != null ? string : "";
    }

    private void outEventFiredCancelled() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.spellerButton.getParent();
        if (abstractSpellerModel != null) {
            abstractSpellerModel.getSpellerElementStates().setPressed(this.spellerButton.getSpellerElement(), this.spellerButton.isPressed());
        }
        this.setSpellerButton(null);
        this.handledOnPressed = false;
    }

    private void outEventFiredLongPressed() {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)this.spellerButton.getParent();
        boolean bl = false;
        if (this.spellerButton.is_activateKeyLongPressedOnLongPressed()) {
            this.this$0.resolveFire(true, this.spellerButton);
            bl = true;
        } else if (abstractSpellerModel != null && abstractSpellerModel.getSubAlphabet() == null) {
            Alphabet alphabet;
            SpellerElement spellerElement = this.spellerButton.getSpellerElement();
            SpellerElementStates spellerElementStates = abstractSpellerModel.getSpellerElementStates();
            if (spellerElement != null && spellerElementStates.isSubSpellerAvailable(spellerElement) && (alphabet = spellerElement.getSubAlphabet()) != null) {
                this.this$0.openSubSpeller(alphabet);
                bl = true;
            }
        }
        this.handledOnPressed = bl ? bl : false;
    }

    private void outEventFiredLongReleased() {
        if (!this.handledOnPressed) {
            this.this$0.resolveFire(true, this.spellerButton);
        }
        this.setSpellerButton(null);
        this.handledOnPressed = false;
    }

    private void outEventFiredPressed() {
        if ("pressed".equals(this.lastOutEvent)) {
            switch (this.spellerButton.get_buttonMode()) {
                case 1: {
                    this.this$0.resolveFire(false, this.spellerButton);
                    this.handledOnPressed = true;
                    break;
                }
                case 2: {
                    this.this$0.resolveFire(true, this.spellerButton);
                    this.handledOnPressed = true;
                    break;
                }
                default: {
                    this.handledOnPressed = false;
                }
            }
        }
    }

    private void outEventFiredReleased() {
        if (!this.handledOnPressed) {
            this.this$0.resolveFire(false, this.spellerButton);
        }
        this.setSpellerButton(null);
        this.handledOnPressed = false;
    }
}

