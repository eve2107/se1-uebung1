package org.hbrs.se1.ws26.uebung2;
import org.hbrs.se1.ws26.exercises.uebung2.Member;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private List<Member> membersListe;

    public Container() {

        this.membersListe = new ArrayList<>();
    }

    public void addMember(Member member) throws ContainerException {
        for (Member m : membersListe) {
            if (m.getID().equals(member.getID())) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden!");
            }

        }
        membersListe.add(member);
    }

    public String deleteMember(int ID) {
        for (Member m : membersListe) {
            if (m.getID().equals(ID)) {
                membersListe.remove(m);
                return "Member mit der ID: " + ID + " wurde erfolgreich gelöscht.";
            }

        }
        return "Fehler: Kein Member mit der ID " + ID + " vorhanden.";
    }

    public void dump() {
        for (Member m : membersListe) {
            System.out.println(m.toString());
        }
    }
        public int size () {
            return membersListe.size();
        }
    }
