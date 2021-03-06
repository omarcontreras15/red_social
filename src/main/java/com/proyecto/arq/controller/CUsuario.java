package com.proyecto.arq.controller;

import com.proyecto.arq.entity.Usuario;
import com.proyecto.arq.model.MAmigo;
import com.proyecto.arq.model.MUsuario;
import com.proyecto.arq.service.SUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CUsuario {

    @Autowired
    private SUsuario sUsuario;

    @PutMapping("/usuario")
    public int registrarUsuario(@RequestBody @Valid Usuario usuario){
        return sUsuario.registrar(usuario);
    }

    @PutMapping("/usuario/seguir")
    public boolean registrarSeguidos(@RequestBody @Valid MAmigo amigo){
        return sUsuario.registrarSeguidor(amigo);
    }

    @GetMapping("/usuario/seguidos/{id}")
    public List<MUsuario> listarSeguidos(@PathVariable("id") int id){
        return sUsuario.listarSeguidos(id);
    }
    @GetMapping("/usuario/seguidores/{id}")
    public List<MUsuario> listarSeguidores(@PathVariable("id") int id){
        return sUsuario.listarSeguidores(id);
    }

    @PostMapping("usuario/login")
    public int login(HttpServletRequest request,@RequestBody @Valid MUsuario usuario){
      int res=sUsuario.login(usuario);
      return res;
    }

    @GetMapping("usuario/seguidores/cantidad/{id}")
    public int cantidadSeguidores(@PathVariable("id") int id){
        return sUsuario.cantidadSeguidores(id);
    }
    @GetMapping("usuario/seguidos/cantidad/{id}")
    public int cantidadSeguidos(@PathVariable("id") int id){
        return sUsuario.cantidadSeguidos(id);
    }
    @GetMapping("usuario/{nombre}")
    public List<MUsuario> listarUsuariosNombre(@PathVariable("nombre") String nombre){
        return sUsuario.listarUsuariosNombre(nombre);
    }
    @GetMapping("usuario/{id}")
    public MUsuario consultarUsuario(@PathVariable("id") int id){
        return sUsuario.consultarUsuario(id);
    }

    @PostMapping("usuario")
    public boolean actualizarUsuario(@RequestBody @Valid Usuario usuario){
        return sUsuario.actualizar(usuario);
    }

}
