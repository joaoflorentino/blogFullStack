package br.com.jflorentino.TrabFinalSpringBFS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jflorentino.TrabFinalSpringBFS.entities.PostagemAssunto;
import br.com.jflorentino.TrabFinalSpringBFS.entities.PostagemAssunto.IdPk;

public interface PostagemAssuntoRepository extends JpaRepository<PostagemAssunto, IdPk>{

}
