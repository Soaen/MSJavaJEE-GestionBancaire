package fr.example.services;

import fr.example.beans.Client;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientManagment {
    Scanner sc = new Scanner(System.in);
    public ArrayList<Client> clientList = new ArrayList<>();


    public void creerClient() {
        System.out.println("Identifiant Client : ");
        String id = sc.nextLine();
        System.out.println("Nom du client : ");
        String lastName = sc.nextLine();
        System.out.println("Prénom du client : ");
        String name = sc.nextLine();
        System.out.println("Date de naissance : (Format: yyyy-MM-dd)");
        LocalDate birthDate = LocalDate.parse(sc.nextLine());
        System.out.println("Email du client : ");
        String email = sc.nextLine();
        clientList.add(new Client(id, lastName, name, birthDate, email));
        System.out.println(clientList.size());
    }

    public void searchClient(){
        System.out.println("Quel est l'ID du client que vous recherchez ?");
        String id = sc.nextLine();
        clientList.forEach(e ->{
            if(Objects.equals(e.getId(), id)){
                System.out.println("ID : " + e.getId());
                System.out.println("Nom : " + e.getName());
                System.out.println("Numéro de compte : " + e.getNbAccount());
            }
        });
    }

    public void infoClient(){
        System.out.println("Quel est l'ID du client que vous recherchez ?");
        String id = sc.nextLine();
        clientList.forEach(e ->{
            if((e.getId().equals(id))){
                try{
                    FileWriter myClient = new FileWriter("client.txt");
                    PrintWriter out = new PrintWriter(myClient);
                    out.println("                      Fiche client");
                    out.println("Numéro client : " + e.getId());
                    out.println("Nom : " + e.getName());
                    out.println("Prénom : " + e.getSurname());
                    out.println("Date de naissance : " + e.getBirth());
                    out.println();
                    out.println("__________________________________________________________________________");
                    out.println("Liste de compte");
                    out.println("__________________________________________________________________________");
                    out.println("Numéro de compte                           Solde");
                    out.println("__________________________________________________________________________");
                    out.println("En cours");
                    out.println(e.getNbAccount() + e.getBalance()                     );
                    if(e.getBalance() > 0){
                        out.print(":-)");
                    }else{
                        out.print(":-(");
                    }
                    out.close();
                    System.out.println("Fichier télécharger !");
                } catch (IOException s) {
                    System.out.println("An error occurred.");
                    s.printStackTrace();
                }
            }
        });
    }

    public void listClient(){
        System.out.println("Quel est l'ID du client que vous souhaitez vois les comptes ?");
        String id = sc.nextLine();
        clientList.forEach(e -> {
            if(e.getId().equals(id)){
                System.out.println("Numéro de compte");
                System.out.println(e.getNbAccount());
                System.out.println("Solde de compte");
                System.out.println(e.getBalance());
                System.out.println("Code Agence");
                System.out.println(e.getCodeAgency());
                System.out.println("Découvert");
                System.out.println(e.isOverdraft() ? "Accepté" : "Refusé");
            }
        });
    }

    public void listAllClient(){
        clientList.forEach(e -> {
            System.out.println("ID : " + e.getId());
            System.out.println("Nom : " + e.getName());
            System.out.println("Prénom : " + e.getSurname());
            System.out.println("Date de Naissance : " + e.getBirth());
            System.out.println("E-Mail : " + e.getEmail());
        });
    }

    public Client searchClient(String id) {
        System.out.println("test 1");
        for (int j = 0; j < clientList.size()+1; j++) {
            System.out.println("test 2");
            System.out.println(id);
            System.out.println(clientList.size());
            System.out.println(clientList.get(j));
            if (clientList.get(j).getId().equals(id)) {
                System.out.println("yo");
                return clientList.get(j);
            }
        }
        return null;
    }
}

