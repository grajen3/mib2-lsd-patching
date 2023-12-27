/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.master;

import de.vw.mib.asl.api.speechengine.features.master.FeatureParamMasterKeys;
import de.vw.mib.asl.api.speechengine.features.model.Event;
import de.vw.mib.asl.api.speechengine.features.model.OrderedPrompts;
import de.vw.mib.asl.internal.speechengine.features.AbstractGenericFeature;
import de.vw.mib.asl.internal.speechengine.features.master.MainMenuMasterFeature;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;

public class MainMenuFeatureImpl
extends AbstractGenericFeature
implements MainMenuMasterFeature,
FeatureParamMasterKeys {
    private int mainMenuCommand;
    private Event mainMenuEvent;
    private OrderedPrompts mainMenuPrompts;
    private boolean mainMenuCommandValid = false;

    public MainMenuFeatureImpl(AbstractClassifiedLogger abstractClassifiedLogger) {
        super(abstractClassifiedLogger);
    }

    private void setMainMenuCommand(int n) {
        this.mainMenuCommand = n;
        this.mainMenuCommandValid = true;
    }

    private void setMainMenuEvent(Event event) {
        this.mainMenuEvent = event;
    }

    private void setMainMenuPrompts(OrderedPrompts orderedPrompts) {
        this.mainMenuPrompts = orderedPrompts;
    }

    @Override
    public boolean isMainMenuCommandValid() {
        return this.mainMenuCommandValid;
    }

    @Override
    public boolean isMainMenuEventValid() {
        return this.mainMenuEvent != null;
    }

    @Override
    public boolean isMainMenuPromptsValid() {
        return this.mainMenuPrompts != null;
    }

    @Override
    public int getMainMenuCommand() {
        return this.mainMenuCommand;
    }

    @Override
    public Event getMainMenuEvent() {
        return this.mainMenuEvent;
    }

    @Override
    public OrderedPrompts getMainMenuPrompts() {
        return this.mainMenuPrompts;
    }

    @Override
    public int getFeatureType() {
        return 105;
    }

    @Override
    public void setInt(int n, int n2) {
        switch (n) {
            case 1040: {
                this.setMainMenuCommand(n2);
                break;
            }
            default: {
                super.setInt(n, n2);
            }
        }
    }

    @Override
    public void setOrderedPrompts(int n, OrderedPrompts orderedPrompts) {
        switch (n) {
            case 1042: {
                this.setMainMenuPrompts(orderedPrompts);
                break;
            }
            default: {
                super.setOrderedPrompts(n, orderedPrompts);
            }
        }
    }

    @Override
    public void setEvent(int n, Event event) {
        switch (n) {
            case 1041: {
                this.setMainMenuEvent(event);
                break;
            }
            default: {
                super.setEvent(n, event);
            }
        }
    }
}

