package com.example.appgarcon;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB {

    private static Connection Conexao() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        StrictMode.ThreadPolicy Politica;
        Politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(Politica);

//        Class.forName("net.sourceforge.jtds:jtds:1.3.1");
        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String ipHost = "179.127.22.91:1450";
        String dbHost = "BD_BUTIQUIM";
        String usHost = "sa";
        String pwHost = "sa123456";
        String urlDB  = "jdbc:jtds:sqlserver://"+ipHost+";databaseName="+dbHost+";user="+usHost+";password="+pwHost+";";

        conn = DriverManager.getConnection(urlDB);

        return conn;
    }

    public static String ConsultaCNPJ(String nrCNPJ) {

        try {
            Connection conn = ConexaoDB.Conexao();

            if (conn!= null) {

                String sql = "SELECT * FROM BD_RMNET..AUTORIZACAO WHERE CD_CLIENTE = " + nrCNPJ;

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {
                    String nome;

                    nome = rs.getString("DS_NOME");

                    conn.close();

                    return nome;
                }

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static List<String> ListaAtendimentos() {

        try {
            Connection conn = ConexaoDB.Conexao();

            if (conn!= null) {

                String sql = "SELECT * FROM BD_BUTIQUIM..R_ATENDIMENTO_TMP";

                Statement st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);

                List<String> Retorno = new ArrayList<>();

                while (rs.next()) {
                    Retorno.add(
                        "Atendimento: "+rs.getString("NR_ATENDIMENTO")+" "+
                        "Hora: "+rs.getString("HR_INICIO")+" "+
                        "Valor: "+rs.getString("VL_CONTA")
                    );
                }
                conn.close();
                return Retorno;

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }




}
