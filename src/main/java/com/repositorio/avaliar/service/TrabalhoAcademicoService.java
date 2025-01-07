package com.repositorio.avaliar.service;

import com.repositorio.avaliar.model.TrabalhoAcademico;

import java.util.List;

public interface TrabalhoAcademicoService {

    List<TrabalhoAcademico> listarTrabalhos();

    TrabalhoAcademico buscarTrabalhoPorId(Long id);

    TrabalhoAcademico criarTrabalho(TrabalhoAcademico trabalho);

    TrabalhoAcademico atualizarTrabalho(Long id, TrabalhoAcademico trabalho);

    void deletarTrabalho(Long id);
}
