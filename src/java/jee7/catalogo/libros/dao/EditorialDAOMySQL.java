/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee7.catalogo.libros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.sql.DataSource;
import jee7.catalogo.libros.dao.util.ConnTest;
import jee7.catalogo.libros.modelo.Editorial;

/**
 *
 * @author Martin
 */
@Stateless
@Local(value = EditorialDAO.class)
@DAOMysql
@Dependent
public class EditorialDAOMySQL implements EditorialDAO {

    @Inject
    @ConnTest
    private DataSource ds;

    @Inject
    private Logger miLogger;

    @Override
    public void agregar(Editorial edt) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO TP_EDITORIAL ( NOMBRE) VALUES (?) ");
            pstm.setString(1, edt.getNombre());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            miLogger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                miLogger.log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void modificar(Editorial edt) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("UPDATE TP_EDITORIAL SET NOMBRE = ? WHERE ID = ? ");
            pstm.setString(1, edt.getNombre());
            pstm.setInt(2, edt.getId());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            miLogger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                miLogger.log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void borrar(int id) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM TP_EDITORIAL WHERE ID = ? ");
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            miLogger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                miLogger.log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Editorial buscar(int id) {
        Connection conn = null;
        Editorial resEdit = new Editorial();
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT ID,NOMBRE FROM TP_EDITORIAL WHERE ID = ?) ");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                resEdit.setId(id);
                resEdit.setNombre(rs.getString("NOMBRE"));
            }
        } catch (SQLException ex) {
            miLogger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                miLogger.log(Level.SEVERE, null, ex);
            }
        }
        return resEdit;
    }

    @Override
    public List<Editorial> buscar(String nombre) {
        Connection conn = null;
        List<Editorial> listaEdt = new ArrayList<>();
        try {
            conn = ds.getConnection();
            PreparedStatement pstm = conn.prepareStatement("SELECT ID,NOMBRE FROM TP_EDITORIAL");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Editorial aux = new Editorial();
                aux.setNombre(rs.getString("NOMBRE"));
                aux.setId(rs.getInt("ID"));
                listaEdt.add(aux);
            }
        } catch (SQLException ex) {
            miLogger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                miLogger.log(Level.SEVERE, null, ex);
            }
        }
        return listaEdt;
    }

    /**
     * @return the ds
     */
    public DataSource getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    /**
     * @return the miLogger
     */
    public Logger getMiLogger() {
        return miLogger;
    }

    /**
     * @param miLogger the miLogger to set
     */
    public void setMiLogger(Logger miLogger) {
        this.miLogger = miLogger;
    }

}
