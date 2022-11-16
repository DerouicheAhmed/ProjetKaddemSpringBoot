package com.example.springprojetkaddem.kaddem.Generique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RestGeneriqueController<T,ID> {
    @Autowired
    IGeneriqueService<T,ID> iGeneriqueService;
    @PostMapping("/add")
    public T add (@RequestBody T entity ){
        return iGeneriqueService.add(entity);
    }

}
