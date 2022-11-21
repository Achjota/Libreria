package com.example.libreria;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.data;
public class RegistroClienteServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("UsuariosBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP registroUsuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
        if(req.getParameter("edad").length()!=0 && req.getParameter("nombre").length()!=0  &&
                req.getParameter("rut").length()!=0){
            String nombre = req.getParameter("nombre");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Usuario usuario = new Usuario(nombre, edad, rut);
            try {
                if(agregarUsuario(usuario)){
                    req.setAttribute("usuario",usuario);
                    respuesta = req.getRequestDispatcher("/registroExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }
    private boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("UsuariosBD");
        List<Usuario> usuarios = UsuarioDAO.obtenerUsuario(query,"rut",usuario.getRut());
        if(usuarios.size()!=0){
            return false;
        }
        else{
            UsuarioDAO.agregarUsuario(query,usuario);
            return true;
        }
    }

}
