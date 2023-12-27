/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi;

import de.vw.mib.asl.framework.api.persistence2.dsi.PersonalizedAppListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DelegatingPersonalizedAppAdapter$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DelegatingPersonalizedAppAdapter$ProfileStateMessage;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.PersonalizedAppAdapter;
import de.vw.mib.timer.Invoker;
import java.util.HashSet;
import java.util.Iterator;

class DelegatingPersonalizedAppAdapter
extends PersonalizedAppAdapter {
    private final HashSet delegates = new HashSet();
    private final Invoker invoker;
    DelegatingPersonalizedAppAdapter$ProfileStateMessage lastMessage;

    DelegatingPersonalizedAppAdapter(Invoker invoker) {
        this.invoker = invoker;
    }

    public void addDelegate(PersonalizedAppListener personalizedAppListener) {
        this.delegates.add(personalizedAppListener);
        if (this.lastMessage != null) {
            this.invoker.invoke(new DelegatingPersonalizedAppAdapter$1(this, personalizedAppListener));
        }
    }

    @Override
    public void profileChanged(int n, int n2) {
        Iterator iterator = this.delegates.iterator();
        while (iterator.hasNext()) {
            PersonalizedAppListener personalizedAppListener = (PersonalizedAppListener)iterator.next();
            personalizedAppListener.profileChanged(n, n2);
        }
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        Iterator iterator = this.delegates.iterator();
        while (iterator.hasNext()) {
            PersonalizedAppListener personalizedAppListener = (PersonalizedAppListener)iterator.next();
            personalizedAppListener.profileCopied(n, n2, n3);
        }
    }

    @Override
    public void profileReset(int n, int n2) {
        Iterator iterator = this.delegates.iterator();
        while (iterator.hasNext()) {
            PersonalizedAppListener personalizedAppListener = (PersonalizedAppListener)iterator.next();
            personalizedAppListener.profileReset(n, n2);
        }
    }

    @Override
    public void profileResetAll(int n) {
        Iterator iterator = this.delegates.iterator();
        while (iterator.hasNext()) {
            PersonalizedAppListener personalizedAppListener = (PersonalizedAppListener)iterator.next();
            personalizedAppListener.profileResetAll(n);
        }
    }

    public void removeDelegate(PersonalizedAppListener personalizedAppListener) {
        this.delegates.remove(personalizedAppListener);
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        if (n3 == 1) {
            this.lastMessage = new DelegatingPersonalizedAppAdapter$ProfileStateMessage(this, n, n2);
        }
        Iterator iterator = this.delegates.iterator();
        while (iterator.hasNext()) {
            PersonalizedAppListener personalizedAppListener = (PersonalizedAppListener)iterator.next();
            personalizedAppListener.updateProfileState(n, n2, n3);
        }
    }
}

