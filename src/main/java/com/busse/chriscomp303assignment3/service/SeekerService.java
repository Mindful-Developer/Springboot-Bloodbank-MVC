package com.busse.chriscomp303assignment3.service;

import com.busse.chriscomp303assignment3.model.Seeker;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SeekerService {
    private static final Map<Long, Seeker> seekerDB = new HashMap<>();
    private static long seekerId = 1;

    public List<Seeker> getAllSeekers() {
        return new ArrayList<>(seekerDB.values());
    }

    public Seeker getSeekerById(Long id) {
        return seekerDB.get(id);
    }

    public Seeker addSeeker(Seeker seeker) {
        seeker.setId(seekerId++);
        seekerDB.put(seeker.getId(), seeker);
        return seeker;
    }

    public Seeker updateSeeker(Long id, Seeker seeker) {
        if (seekerDB.containsKey(id)) {
            seeker.setId(id);
            seekerDB.put(id, seeker);
            return seeker;
        }
        return null;
    }

    public boolean deleteSeeker(Long id) {
        if (seekerDB.containsKey(id)) {
            seekerDB.remove(id);
            return true;
        }
        return false;
    }
}