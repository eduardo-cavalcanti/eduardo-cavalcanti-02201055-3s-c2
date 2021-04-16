package br.com.bandtec.ProvaYoshi.repositorio;

import br.com.bandtec.ProvaYoshi.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    @Query("select l from Lutador l order by vida desc")
    List<Lutador> findAllSimples();

    @Query("select count (vida) from Lutador where vida > 0")
    Integer findAllVivos();

    @Query("select l from Lutador l where vida = 0")
    List<Lutador> findAllMortos();

}
