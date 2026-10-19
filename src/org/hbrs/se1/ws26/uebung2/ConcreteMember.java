package org.hbrs.se1.ws26.uebung2;

import org.hbrs.se1.ws26.exercises.uebung2.Member;

public class ConcreteMember implements Member {
    private int ID;

    public ConcreteMember(int ID) {
        this.ID = ID;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Member (ID = " + this.ID + ")";
    }
}