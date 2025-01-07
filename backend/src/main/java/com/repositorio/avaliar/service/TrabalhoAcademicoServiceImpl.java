package com.repositorio.avaliar.service;

import com.repositorio.avaliar.model.TrabalhoAcademico;
import com.repositorio.avaliar.repository.TrabalhoAcademicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoAcademicoServiceImpl implements TrabalhoAcademicoService {

    @Autowired
    private TrabalhoAcademicoRepository repository;

    @Override
    public List<TrabalhoAcademico> listarTrabalhos() {
        return repository.findAll();
    }

    @Override
    public TrabalhoAcademico buscarTrabalhoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Trabalho acadêmico não encontrado!"));
    }

    @Override
    public TrabalhoAcademico criarTrabalho(TrabalhoAcademico trabalho) {
        return repository.save(trabalho);
    }

    @Override
    public TrabalhoAcademico atualizarTrabalho(Long id, TrabalhoAcademico trabalho) {
        return repository.findById(id)
                .map(trabalhoExistente -> {
                    trabalhoExistente.setTitulo(trabalho.getTitulo());
                    trabalhoExistente.setTipoProducao(trabalho.getTipoProducao());
                    trabalhoExistente.setAno(trabalho.getAno());
                    trabalhoExistente.setAutor(trabalho.getAutor());
                    trabalhoExistente.setOrientador(trabalho.getOrientador());
                    trabalhoExistente.setPalavrasChave(trabalho.getPalavrasChave());
                    trabalhoExistente.setUniversidade(trabalho.getUniversidade());
                    trabalhoExistente.setLink(trabalho.getLink());
                    return repository.save(trabalhoExistente);
                }).orElseThrow(() -> new RuntimeException("Trabalho acadêmico não encontrado!"));
    }

    @Override
    public void deletarTrabalho(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Trabalho acadêmico não encontrado!");
        }
        repository.deleteById(id);
    }
}
