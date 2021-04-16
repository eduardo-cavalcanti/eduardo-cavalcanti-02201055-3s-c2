package br.com.bandtec.ProvaYoshi.controle;

import br.com.bandtec.ProvaYoshi.dominio.Lutador;
import br.com.bandtec.ProvaYoshi.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @GetMapping
    public ResponseEntity getLutadores() {
        List<Lutador> lutadores = repository.findAll();

        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores.");
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findAllSimples());
        }
    }

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        System.out.println("Lutador adicionado!");
        return ResponseEntity.status(201).build();
    }


    @GetMapping("/contagem-vivos")
    public ResponseEntity getQtdLutadoresVivos(){
        List<Lutador> lutadores = repository.findAll();

        if (lutadores.isEmpty()) {
            System.out.println("Valor não existente.");
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body("Há " +repository.findAllVivos()+ " lutadores vivo(s).");
        }

    }

    @GetMapping("/mortos")
    public ResponseEntity getLutadoresMortos(){
        List<Lutador> lutadores = repository.findAll();

        if (lutadores.isEmpty()) {
            System.out.println("Não há lutadores mortos.");
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.status(200).body(repository.findAllMortos());
        }

    }


}
