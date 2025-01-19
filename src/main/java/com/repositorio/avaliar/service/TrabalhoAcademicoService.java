package com.repositorio.avaliar.service;

import com.repositorio.avaliar.model.TrabalhoAcademico;
import java.util.List;
import java.util.UUID;

public interface TrabalhoAcademicoService {

    List<TrabalhoAcademico> listarTrabalhos();

    TrabalhoAcademico buscarTrabalhoPorId(UUID id);

    TrabalhoAcademico criarTrabalho(TrabalhoAcademico trabalho);

    TrabalhoAcademico atualizarTrabalho(UUID id, TrabalhoAcademico trabalho);

    void deletarTrabalho(UUID id);
}
