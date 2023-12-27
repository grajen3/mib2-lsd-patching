/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.timer.internal.TimerTask;

final class TimerTaskList {
    private TimerTask first = null;

    TimerTaskList() {
    }

    void clear() {
        this.first = null;
    }

    boolean contains(TimerTask timerTask) {
        for (TimerTask timerTask2 = this.first; timerTask2 != null; timerTask2 = timerTask2.getNextTask()) {
            if (timerTask2.isOlderThan(timerTask)) {
                return false;
            }
            if (timerTask2 != timerTask) continue;
            return true;
        }
        return false;
    }

    TimerTask getFirst() {
        return this.first;
    }

    void insert(TimerTask timerTask) {
        if (this.isEmpty()) {
            this.first = timerTask;
            this.first.setNextTask(null);
            this.first.setPrevTask(null);
            return;
        }
        if (!this.insertBehind(timerTask, this.first)) {
            timerTask.setNextTask(this.first);
            this.first.setPrevTask(timerTask);
            this.first = timerTask;
        }
    }

    private boolean insertBehind(TimerTask timerTask, TimerTask timerTask2) {
        if (timerTask2.isOlderThan(timerTask)) {
            return false;
        }
        TimerTask timerTask3 = timerTask2;
        TimerTask timerTask4 = timerTask3.getNextTask();
        while (timerTask.isOlderThan(timerTask4)) {
            timerTask3 = timerTask4;
            timerTask4 = timerTask4.getNextTask();
        }
        timerTask3.setNextTask(timerTask);
        timerTask.setPrevTask(timerTask3);
        timerTask.setNextTask(timerTask4);
        if (timerTask4 != null) {
            timerTask4.setPrevTask(timerTask);
        }
        return true;
    }

    void insertAll(TimerTaskList timerTaskList) {
        if (timerTaskList.isEmpty()) {
            return;
        }
        if (this.isEmpty()) {
            this.first = timerTaskList.first;
            timerTaskList.first = null;
            return;
        }
        TimerTask timerTask = timerTaskList.removeFirst();
        TimerTask timerTask2 = this.first;
        if (this.first.isOlderThan(timerTask)) {
            this.insert(timerTask);
            timerTask2 = timerTask;
            timerTask = timerTaskList.removeFirst();
        }
        while (timerTask != null) {
            this.insertBehind(timerTask, timerTask2);
            timerTask2 = timerTask;
            timerTask = timerTaskList.removeFirst();
        }
    }

    boolean isEmpty() {
        return this.first == null;
    }

    void remove(TimerTask timerTask) {
        TimerTask timerTask2 = timerTask.getPrevTask();
        TimerTask timerTask3 = timerTask.getNextTask();
        if (timerTask2 == null) {
            this.first = timerTask3;
        } else {
            timerTask2.setNextTask(timerTask3);
        }
        if (timerTask3 != null) {
            timerTask3.setPrevTask(timerTask2);
        }
        timerTask.setPrevTask(null);
        timerTask.setNextTask(null);
    }

    TimerTask removeFirst() {
        if (this.first == null) {
            return null;
        }
        TimerTask timerTask = this.first;
        this.first = this.first.getNextTask();
        if (this.first != null) {
            this.first.setPrevTask(null);
        }
        timerTask.setNextTask(null);
        timerTask.setPrevTask(null);
        return timerTask;
    }

    int size() {
        if (this.first == null) {
            return 0;
        }
        int n = 1;
        for (TimerTask timerTask = this.first.getNextTask(); timerTask != null; timerTask = timerTask.getNextTask()) {
            ++n;
        }
        return n;
    }
}

