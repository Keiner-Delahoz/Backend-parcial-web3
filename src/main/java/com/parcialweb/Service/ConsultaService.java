package com.parcialweb.Service;

import com.parcialweb.Model.Consulta;
import com.parcialweb.Repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<Consulta> getConsultas(){
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Long id) throws Exception {
        Consulta consulta = consultaRepository.findById(id).orElse(null);
        if (consulta != null) {
            return consulta;
        } else {
            throw new Exception("El usuario no existe");
        }
    }

    public void create(Consulta consulta) {
            consultaRepository.save(consulta);
    }

    public void delete(Long id) throws Exception {
        if (consultaRepository.existsById(id)){
            consultaRepository.deleteById(id);
        } else {
            throw new Exception("El usuario no existe");
        }
    }
}
