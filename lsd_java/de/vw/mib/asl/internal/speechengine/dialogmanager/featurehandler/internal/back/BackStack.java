/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStackListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.GapDialogBackHandler;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackStack {
    private Stack stack;
    private List backStackListeners;
    private DialogBackHandler rootHandler;

    public BackStack(DialogBackHandler dialogBackHandler) {
        this.rootHandler = dialogBackHandler;
        this.backStackListeners = new ArrayList();
        this.stack = new Stack();
    }

    public void addBackStackListener(BackStackListener backStackListener) {
        if (!this.backStackListeners.contains(backStackListener)) {
            this.backStackListeners.add(backStackListener);
        }
        backStackListener.onBackStackChanged(this);
    }

    public void removeBackStackListener(BackStackListener backStackListener) {
        this.backStackListeners.remove(backStackListener);
    }

    private void notifyChanges() {
        for (int i2 = 0; i2 < this.backStackListeners.size(); ++i2) {
            BackStackListener backStackListener = (BackStackListener)this.backStackListeners.get(i2);
            backStackListener.onBackStackChanged(this);
        }
    }

    public void clear() {
        this.stack.clear();
        this.notifyChanges();
    }

    public void push(DialogBackHandler dialogBackHandler) {
        this.removeGAP();
        this.stack.push(dialogBackHandler);
        this.notifyChanges();
    }

    private void removeGAP() {
        DialogBackHandler dialogBackHandler = this.peek();
        if (dialogBackHandler == GapDialogBackHandler.INSTANCE) {
            this.stack.pop();
        }
    }

    public DialogBackHandler peek() {
        if (this.stack.isEmpty()) {
            return this.rootHandler;
        }
        return (DialogBackHandler)this.stack.peek();
    }

    public DialogBackHandler pop() {
        if (this.stack.isEmpty()) {
            return this.rootHandler;
        }
        this.stack.pop();
        this.notifyChanges();
        return this.peek();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stackroot\n");
        for (int i2 = 0; i2 < this.stack.size(); ++i2) {
            stringBuilder.append(" |\n +-- ");
            stringBuilder.append(String.valueOf(this.stack.get(i2)));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void pushGAP() {
        this.push(GapDialogBackHandler.INSTANCE);
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}

