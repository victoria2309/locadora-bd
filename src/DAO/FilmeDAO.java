/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL{
    
        public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
       String sql  = "insert into filme values(0,?,?,?,?,?,?)";
       try{
       PreparedStatement ps = getCon().prepareStatement(sql);
       
       ps.setInt(1, a.getIdfilme());
       ps.setString(2, a.getTitulo());
       ps.setString(3, a.getAno());
       ps.setString(4, a.getDuracao());
       ps.setInt(5, a.getIdcategoria());
       ps.setInt(6, a.getIdclassificacao());
       ps.setString(7, a.getCapa());
       
       
       if(ps.executeUpdate() > 0){
          return "Inserido com sucesso";
       }else{
          return "Erro ao inserir";
       }
   } catch (SQLException e){
       return e.getMessage();
   } 
    
    
    }
    public List<Filme> ListarFilme(){
        
       String sql = "select idfilme, titulo, ano, duracao, idcategoria, idclassificacao from filme";
       List<Filme> lista = new ArrayList<>();
       
       try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
             while (rs.next()){
                Filme a = new Filme();
                
                a.setIdfilme(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getString(3));
                a.setDuracao(rs.getString(4));
                a.setIdcategoria(rs.getInt(5));
                a.setIdclassificacao(rs.getInt(6));
               
                
                lista.add(a);
                }
             return lista;
          }else{
             return null;
          }
       }catch(SQLException e){
           return null;
       }
    }
    
    public List<Filme> Pesquisar_Nome_Filme(String nome){
        
       String sql = "select idfilme, titulo, ano, duracao, idcategoria, idclassificacao from capa where nome = '"+ nome +"'";
       List<Filme> lista = new ArrayList<>();
       
       try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
             while (rs.next()){
                Filme a = new Filme();
                a.setIdfilme(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getString(3));
                a.setDuracao(rs.getString(4));
                a.setIdcategoria(rs.getInt(5));
                a.setIdclassificacao(rs.getInt(6));
                a.setCapa(rs.getString(7));
                
                lista.add(a);
                }
             return lista;
          }else{
             return null;
          }
       }catch(SQLException e){
           return null;
       }
    }
    
    public List<Filme> Pesquisar_Cod_Filme(int cod){
        
       String sql = "select idfilme, titulo, ano, duracao, idcategoria, idclassificacao from cliente where idcliente = '"+ cod +"'";
       List<Filme> lista = new ArrayList<>();
       
       try {
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
             while (rs.next()){
                Filme a = new Filme();
                a.setIdfilme(rs.getInt(1));
                a.setTitulo(rs.getString(2));
                a.setAno(rs.getString(3));
                a.setDuracao(rs.getString(4));
                a.setIdcategoria(rs.getInt(5));
                a.setIdclassificacao(rs.getInt(6));
                a.setCapa(rs.getString(7));
                
                lista.add(a);
                }
             return lista;
          }else{
             return null;
          }
       }catch(SQLException e){
           return null;
       }
    }
    public boolean Testar_Filme(int cod){
      boolean Resultado = false;
      try{
          String sql = "select + from filme where idfilme = " + cod +"";
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
             while(rs.next()){
             Resultado = true;
             }
          }
      }catch (SQLException ex){
         ex.getMessage();
      }
      return Resultado;
    }
    
    public List<Filme>CapturarFilme(int cod){
        String sql = "select * from filme where idfilme = " + cod +" ";
        List<Filme>lista = new ArrayList<>();
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
               while(rs.next()){
                   Filme a = new Filme();
                   a.setIdfilme(rs.getInt(1));
                   a.setTitulo(rs.getString(2));
                   a.setAno(rs.getString(3));
                   a.setDuracao(rs.getString(4));
                   a.setIdcategoria(rs.getInt(5));
                   a.setIdclassificacao(rs.getInt(6));
                   a.setCapa(rs.getString(7));
                   
                   lista.add(a);
               }
               return lista;
            }else{
               return null;
            }
        }catch(SQLException e){
           return null;
        }
    }
    public String Alterar_Filme(Filme a){
       String sql = "update filme set titulo = ?, idcategoria = ?, titulo = ?"
               + "',ano = ?, duracao = ?, idcategoria = ?, idclassificacao = ?, capa = ?";
        try{
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, a.getIdclassificacao());
           ps.setString(2, a.getTitulo());
           ps.setString(3, a.getDuracao());
           ps.setInt(4, a.getIdcategoria());
           ps.setInt(5, a.getIdclassificacao());
           ps.setString(6, a.getCapa());
           
           if(ps.executeUpdate() > 0){
              return "Atualizado c sucesso";
           }else{
              return "Erro ao atualizar"; 
           }
        }catch (SQLException e){
           return e.getMessage();
        }
    }
    }
    

