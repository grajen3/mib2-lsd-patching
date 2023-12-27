/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler;

import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.AbstractCommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.MainMenuFeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerInternal;

class MainMenuFeatureHandler$1
extends AbstractCommandConsumer {
    private final /* synthetic */ MainMenuFeatureHandler this$0;

    MainMenuFeatureHandler$1(MainMenuFeatureHandler mainMenuFeatureHandler, DialogManagerInternal dialogManagerInternal, String string, String string2) {
        this.this$0 = mainMenuFeatureHandler;
        super(dialogManagerInternal, string, string2);
    }

    @Override
    public void recognizedCommand(Command command) {
        this.this$0.openMainMenu(true, true);
        this.dialogManager.startRecognition();
    }

    @Override
    public boolean isUniversal() {
        return true;
    }
}

