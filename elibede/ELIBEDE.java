/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elibede;

import elibede.database.MySql;
import elibede.model.Sala;
import elibede.model.Socio;
import elibede.model.Reserva;
import elibede.implementations.SalaDaoImpl;
import elibede.implementations.SalaSquashDaoImpl;
import elibede.implementations.SocioDaoImpl;
import elibede.implementations.ReservaDaoImpl;
import elibede.model.SalaSquash;

import java.util.Scanner;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author paulokim
 */
public class ELIBEDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectado!");
        } catch (ClassNotFoundException e){
            System.out.print("Driver não encontrado");
        }
        Scanner sc = new Scanner(System.in);
        SalaSquashDaoImpl salaSquashImplement = new SalaSquashDaoImpl();
        ReservaDaoImpl reservaImplement = new ReservaDaoImpl();
        SalaDaoImpl salaImplement = new SalaDaoImpl();
        SocioDaoImpl socioImplement = new SocioDaoImpl();
//        Connection conn = MySql.createConnection();
//        String query = "INSERT INTO teste.SalaSquash (Codigo, Estado, NroId) VALUES ";
//        String query = "INSERT INTO teste.Sala (NroId, Area, Localizacao) VALUES ";
//        String query = "INSERT INTO teste.Reserva (Data, NroSocio, NroId) VALUES ";
//        String query = "INSERT INTO teste.Socio (NroSocio, Nome, Telefone, Endereco, Profissao, DocsBancarios) VALUES ";
        
//        String[] a = {"RONALDAO", "ALEXANDRE", "PEDRO", "PAULOK", "ALEXZ1200", "O TAL DO PEDRINHO", "IGAO", "ATUN", "PARADAO NO BAILAO", "DENTRO DO CARRO"};
//        String[] b = {"RYCO", "RYCO DEMAIS"};
        
//        for (int i = 10001; i < 10003; i++) {
//            String NroId = Integer.toString(i);
//            if (i == 10001) {
//                query += String.format("('%s','2', '%s')", new Date(), NroId);
//            }
//            if (i%2 != 0) {
//                query += String.format(", ('%s','2', '%s')", new Date(), NroId);
//            }
//        }
//        int cont = 0;
//        for (int i = 0; i < 100000; i+=10) {
//            String NroId = Integer.toString(i);
//            String Nome = a[i%10];
//            String DocsBancarios = b[i%2];
//            if (cont == 500) {
//                cont = 0;
//                query += ";";
//                System.out.println(query);
//                PreparedStatement st = conn.prepareStatement(query);
//
//                int createCount = st.executeUpdate();
//                if (createCount > 0) {
//                    System.out.println("FOI!");
//                    query = "INSERT INTO teste.Reserva (Data, NroSocio, NroId) VALUES ";
//                    query = "INSERT INTO teste.SalaSquash (Codigo, Estado, NroId) VALUES ";
//                    query = "INSERT INTO teste.Sala (NroId, Area, Localizacao) VALUES ";
//                    query = "INSERT INTO teste.Socio (NroSocio, Nome, Telefone, Endereco, Profissao, DocsBancarios) VALUES ";
//                }
//            }
//            if (cont == 0) {
//                query += String.format("('%s','2','%s')", new Date(), NroId);
//            }
//            if (cont != 0) {
//                query += String.format(", ('%s','2','%s')", new Date(), NroId);
//            }
//            cont++;
//        }
        
        int resp;
        do {
            System.out.println("1- Verificar disponibilidade de todas salas de squash\n2- Verificar reservas por socio\n3- Verificar reservas por sala\n4- Menu de criacao\n0-Sair do programa");
            resp = sc.nextInt();
            sc.nextLine();
            if (resp == 0) return;
            switch(resp) {
                case 1:
                    String salasDisponiveis = salaSquashImplement.getSalasDisponiveis();
                    System.out.println(salasDisponiveis);
                    break;
                case 2:
                    String socio;
                    System.out.println("Qual o numero do sócio?");
                    socio = sc.nextLine();
                    String reservas = reservaImplement.getReservasFromSocios(socio);
                    System.out.println(reservas);
                    break;
                case 3:
                    String NroId;
                    System.out.println("Digite o NroId da sala: ");
                    NroId = sc.nextLine();
                    String reservasPorSala = reservaImplement.getReservasFromSalas(NroId);
                    System.out.println(reservasPorSala);
                    break;
                case 4:
                    int resp2;
                    do {
                        System.out.println("1- Criar sala\n2- Criar sala de squash\n3- Criar socio\n4- Criar reserva\n0-Voltar ao menu inicial");
                        resp2 = sc.nextInt();
                        sc.nextLine();
                        switch(resp2){
                            case 1:
                                NroId = "";
                                String Area = "";
                                String Localizacao = "";
                                System.out.println("Digite o seu ID: ");
                                NroId = sc.nextLine();
                                System.out.println("Digite a area: ");
                                Area = sc.nextLine();
                                System.out.println("Digite a localização: ");
                                Localizacao = sc.nextLine();
                                Sala sala = salaImplement.criarSala(NroId, Area, Localizacao);
                                System.out.println(sala.getNroId());
                                break;
                            case 2:
                                String Codigo = "";
                                String Estado = "";
                                String IdSala = "";
                                System.out.println("Digite o codigo da sala: ");
                                Codigo = sc.nextLine();
                                System.out.println("Digite o estado dela: ");
                                Estado = sc.nextLine();
                                System.out.println("Digite o ID da sala: ");
                                IdSala = sc.nextLine();
                                SalaSquash novaSala = salaSquashImplement.criarSalaSquash(Codigo, Estado, IdSala);
                                System.out.println(novaSala.getNroId());
                                break;
                            case 3:
                                String resposta = "";
                                System.out.println("Digite NroSocio, Nome, Telefone, Endereco, Profissao e DocsBancarios separados por vígula: ");
                                resposta = sc.nextLine();
                                String[] result = resposta.split(",");
                                Socio novoSocio = socioImplement.criarSocio(result[0].trim(), result[1].trim(), result[2].trim(), result[3].trim(), result[4].trim(), result[5].trim());
                                System.out.println(novoSocio.getNome());
                                break;
                            case 4:
                                String dataResp = "";
                                String NroSocio = "";
                                String Id = "";
                                System.out.println("Digite a data dessa forma 01/01/2019 8:30: ");
                                dataResp = sc.nextLine();
                                System.out.println("Digite o número do sócio: ");
                                NroSocio = sc.nextLine();
                                System.out.println("Digite o ID da sala: ");
                                Id = sc.nextLine();
                                String[] arrayData = dataResp.split(" ");
                                String data = arrayData[0];
                                String[] splittedData = data.split("/");
                                String hora = arrayData[1];
                                String[] splittedHora = hora.split(":");
                                LocalDateTime localData = LocalDateTime.of(Integer.parseInt(splittedData[2]), Integer.parseInt(splittedData[1]), Integer.parseInt(splittedData[0]), Integer.parseInt(splittedHora[0]), Integer.parseInt(splittedHora[1]));
                                Date Data = Date.from(localData.atZone(ZoneId.systemDefault()).toInstant());
                                Reserva novaReserva = reservaImplement.criarReserva(Data, NroSocio, Id);
                                System.out.println(novaReserva.getNroSocio());
                                break;
                        }
                    } while(resp2 != 0);
            }
        } while(resp != 0);
    }
}
