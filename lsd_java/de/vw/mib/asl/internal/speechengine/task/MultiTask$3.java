/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.MultiTask;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import java.util.ArrayList;
import java.util.Iterator;

class MultiTask$3
implements Runnable {
    private final /* synthetic */ MultiTask this$0;

    MultiTask$3(MultiTask multiTask) {
        this.this$0 = multiTask;
    }

    @Override
    public void run() {
        ArrayList arrayList = (ArrayList)this.this$0.taskListener.clone();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((TaskListener)iterator.next()).taskFinishedAborted(this.this$0.getMasterTask());
        }
    }
}

