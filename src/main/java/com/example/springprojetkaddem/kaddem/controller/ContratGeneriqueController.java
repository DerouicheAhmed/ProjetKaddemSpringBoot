package com.example.springprojetkaddem.kaddem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springprojetkaddem.kaddem.Generique.RestGeneriqueController;
import com.example.springprojetkaddem.kaddem.entity.Contrat;
@RestController
@RequestMapping("/contrat1")
public class ContratGeneriqueController extends RestGeneriqueController<Contrat,Integer> {
}
