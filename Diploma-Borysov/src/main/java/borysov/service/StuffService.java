package borysov.service;

import borysov.entity.Stuff;
import borysov.entity.User;

import java.util.List;

public interface StuffService {

    List<Stuff> getStuff(int id);
    void addStuff(Stuff stuff);
 }
