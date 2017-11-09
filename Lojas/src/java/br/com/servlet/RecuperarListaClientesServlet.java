/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servlet;

import br.com.dao.ClienteDAO;
import br.com.model.ClienteModel;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rodrigo Cardoso
 */
@WebServlet(name = "RecuperarListaClientesServlet", urlPatterns = {"/lista"})
public class RecuperarListaClientesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO cliente = new ClienteDAO();
        
        List<ClienteModel> clientes = cliente.getContatos();
        
        Gson gson = new Gson();
        String json = gson.toJson(clientes);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        /*return json;*/
    }
}
