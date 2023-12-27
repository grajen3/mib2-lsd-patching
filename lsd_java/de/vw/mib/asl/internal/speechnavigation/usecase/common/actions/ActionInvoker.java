/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common.actions;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.actions.Action;
import de.vw.mib.collections.ObjectArrayList;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class ActionInvoker
implements DialogStateConsumer {
    private final IntObjectMap dialogStatusToActions;
    private final DialogStateRouter dialogStateService;

    public ActionInvoker() {
        this(SpeechServices.getDialogStateService());
    }

    public ActionInvoker(DialogStateRouter dialogStateRouter) {
        this.dialogStateService = dialogStateRouter;
        this.dialogStatusToActions = new IntObjectOptHashMap(1);
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (!this.dialogStatusToActions.containsKey(n)) {
            return;
        }
        ObjectArrayList objectArrayList = (ObjectArrayList)this.dialogStatusToActions.remove(n);
        if (objectArrayList != null) {
            Action[] actionArray = (Action[])objectArrayList.toArray(new Action[objectArrayList.size()]);
            for (int i2 = 0; i2 < actionArray.length; ++i2) {
                actionArray[i2].invoke();
            }
            if (this.dialogStatusToActions.isEmpty()) {
                this.dialogStateService.unregister(this);
            }
        }
    }

    public void invokeOn(Action action, int n) {
        this.dialogStateService.register(this);
        if (!this.dialogStatusToActions.containsKey(n)) {
            this.dialogStatusToActions.put(n, new ObjectArrayList(1));
        }
        ObjectArrayList objectArrayList = (ObjectArrayList)this.dialogStatusToActions.get(n);
        objectArrayList.add(action);
    }

    public void invokeWhenSdsSessionEnds(Action action) {
        this.invokeOn(action, 3);
    }

    public void invokeWhenSdsPromptEnds(Action action) {
        this.invokeOn(action, 5);
    }
}

