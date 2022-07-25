package com.pratica1.storeimplementacao2.service;

import com.pratica1.storeimplementacao2.model.Joia;

import java.util.List;
import java.util.Map;

public interface IJoiaService {
    public Long create(Joia newJoia);
    public Joia update(Long id, Map<String, String> changes);
    public List<Joia> getAll();
    public Void remove(Long id);
}
