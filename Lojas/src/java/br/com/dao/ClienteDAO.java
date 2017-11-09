package br.com.dao;

import br.com.model.ClienteModel;
import br.com.rastreador.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {

    /*public void save(ClienteModel cliente) {

       
 //* Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
 //* na base de dados
         
        String sql = "INSERT INTO clientes(nome,idade,dataCadastro)"
                + " VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, cliente.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, cliente.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void removeById(int id) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void update(ClienteModel cliente) {

        String sql = "UPDATE clientes SET nome = ?, idade = ?, dataCadastro = ?"
                + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, cliente.getNome());
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setInt(2, cliente.getIdade());
            //Adiciona o valor do terceiro parâmetro da sql
            pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));

            pstm.setInt(4, cliente.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }*/

    public List<ClienteModel> getContatos() {

        String sql = "SELECT * FROM clientes";

        List<ClienteModel> clientes = new ArrayList<ClienteModel>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                ClienteModel cliente = new ClienteModel();

                //Recupera o id do banco e atribui ele ao objeto
                cliente.setCodigo(rset.getInt("codigo"));

                //Recupera o nome do banco e atribui ele ao objeto
                cliente.setNome(rset.getString("nome"));

                //Recupera a idade do banco e atribui ele ao objeto
                cliente.setEndereco(rset.getString("endereco"));

                //Recupera a data do banco e atribui ela ao objeto
                cliente.setCidade(rset.getString("cidade"));
                
                //Recupera a data do banco e atribui ela ao objeto
                cliente.setEstado(rset.getString("estado"));
                
                //Recupera a data do banco e atribui ela ao objeto
                cliente.setEmail(rset.getString("email"));
                
                //Recupera a data do banco e atribui ela ao objeto
                cliente.setSenha(rset.getString("senha"));

                //Adiciono o cliente recuperado, a lista de clientes
                clientes.add(cliente);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        return clientes;
    }
    
    public boolean login(String email, String senha) {
        
        boolean vdd = false;
        
        String sql = "select * from clientes where email = ? and senha = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            //Cria uma conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, email);
            //Adicionar o valor do segundo parâmetro da sql
            pstm.setString(2, senha);           

            //Executa a sql para inserção dos dados
            rset = pstm.executeQuery();
            
            if(rset.next()){
               vdd = true; 
            } 
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            //Fecha as conexões
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        return vdd;
    }

}
