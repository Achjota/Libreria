package com.example.libreria;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaClientes extends HttpServlet {
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
        try {
            req.setAttribute("usuarios",agregarUsuariosEjemplo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/mostrarUsuarios.jsp");
        respuesta.forward(req,resp);
    }

    private List agregarUsuariosEjemplo() throws ClassNotFoundException {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = UsuarioDAO.obtenerUsuarios(DBGenerator.conectarBD("UsuariosBD"));
        return usuarios;
    }
}
