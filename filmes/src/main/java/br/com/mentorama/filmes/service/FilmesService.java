package br.com.mentorama.filmes.service;

import br.com.mentorama.filmes.entities.Filmes;
import br.com.mentorama.filmes.excepition.FilmesInexistenteException;
import br.com.mentorama.filmes.excepition.IlegalOcorrenciaException;
import br.com.mentorama.filmes.interfaces.IFilmes;
import br.com.mentorama.filmes.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService implements IFilmes {

    @Autowired
    private FilmesRepository filmesRepository;

    @Override
    public List<Filmes> findAll(String nome) {
        if(nome != null){
            return filmesRepository.findAll(nome);
        }
        if(filmesRepository.findAll().isEmpty()){
            throw new FilmesInexistenteException();
        }
        return filmesRepository.findAll();
    }

    @Override
    public Filmes buscaPorId(Integer id) {
        if(id != null){
            return filmesRepository.buscaPorId(id);
        }else{
            throw new FilmesInexistenteException();
        }
    }

    @Override
    public Integer add(Filmes filmes) {
        if(filmes.getId() == null){
            filmes.setId(filmesRepository.count() + 1);
        }
        if(filmes.getNota() < 1 || filmes.getNota() > 5){
            throw new IlegalOcorrenciaException();
        }
        if(filmesRepository.findAll().stream().anyMatch(f -> f.getNome().equalsIgnoreCase(filmes.getNome()))){
            if(filmesRepository.findAll().stream().anyMatch(f-> f.getNomeDiretor().equalsIgnoreCase(filmes.getNomeDiretor()))){
                if(filmesRepository.findAll().stream().anyMatch(f-> f.getAno().equals(filmes.getAno()))){
                    throw new IlegalOcorrenciaException();
                }
            }

        }
        filmesRepository.add(filmes);
        return filmes.getId();
    }

    @Override
    public void update(Filmes filmes) {
        if(filmes.getNota() >= 1 || filmes.getAno() <= 5){
            filmesRepository.update(filmes);
        }
        if(filmes.getNota() < 1 || filmes.getNota() >5){
            throw new IlegalOcorrenciaException();
        }
    }

    @Override
    public void delete(Integer id) {
        filmesRepository.delete(id);
    }
}
