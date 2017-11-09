/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.ClienteDAO;
import br.com.model.LoginCliente;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Cardoso
 */
@WebServlet(name = "LoginClienteServlet", urlPatterns = {"/login"})
public class LoginClienteServlet extends HttpServlet {

    protected void doPost(String request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");

        Gson gson = new Gson();
        
        LoginCliente login = gson.fromJson(request, LoginCliente.class);

        ClienteDAO cliente = new ClienteDAO();
        cliente.login(login.getEmail(), login.getSenha());
        
          //PAreiii
    }    
}
