
package wad.olutvarasto.service;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.olutvarasto.domain.Olut;

@Service
public class BeerWagon implements OlutPalvelu {
    
    LinkedList<Olut> oluet = new LinkedList<Olut>();

    @Override
    public Olut lisaaOlut(Olut olut) {
        System.out.println("Lisätään olut");
        oluet.add(olut);
        System.out.println("OOOOOOOOLLLLLLLUUUUUUUUUUUUTTTTTT!!!" + oluet);
        return olut;
    }

    @Override
    public void poistaOlut(int tunnus) {
        for (Olut olut : oluet) {
            if (olut.getId() == tunnus) oluet.remove(olut);
        }
        
    }

    @Override
    public Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut) {
        for (Olut kalja : oluet) {
            if (kalja.getId() == tunnus) {
                oluet.remove(kalja);
                oluet.add(olut);
                return kalja;
            }
        }
        olut.setId(tunnus);
        return lisaaOlut(olut);
        
    }

    @Override
    public Olut annaOlut(int tunnus) {
        for (Olut olut : oluet) {
            if (olut.getId() == tunnus) return olut;
        }
        return null;
    }

    @Override
    public List<Olut> listaaOluet() {
        return oluet;
    }
    
}
