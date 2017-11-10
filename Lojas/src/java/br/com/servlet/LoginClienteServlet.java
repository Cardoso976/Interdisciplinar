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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Cardoso
 */
@WebServlet(name = "LoginClienteServlet", urlPatterns = {"/login"})
public class LoginClienteServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String json = request.getParameter("login");
        Gson gson = new Gson();
        response.setContentType("application/json;charset=UTF-8");
        //response.setContentType(“application / json”);
        LoginCliente login = gson.fromJson(json, LoginCliente.class);

        ClienteDAO cliente = new ClienteDAO();
        cliente.login(login.getEmail(), login.getSenha());

        //response.getWriter(json);
        
    }
}
