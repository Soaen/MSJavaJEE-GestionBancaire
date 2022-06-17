package fr.example.services;

import fr.example.beans.*;


import java.util.ArrayList;
import java.util.Scanner;

public class AccountManagment {
    ArrayList<Compte> accountList = new ArrayList<>();
    ClientManagment cm = new ClientManagment();
    Scanner sc = new Scanner(System.in);
    int choix = 0;
    boolean i = false;


    public void creerCompte() {
        System.out.println("Numéro de compte : ");
        float nbAccount = sc.nextFloat();
        System.out.println("Code Agence : ");
        int agencyCode = sc.nextInt();
        System.out.println("Solde : ");
        int balance = sc.nextInt();
        sc.nextLine();
        System.out.println("Découvert autorisé O/N : ");
        String tooMuch = sc.nextLine();
        while(!tooMuch.equals("O") && !tooMuch.equals("N")){
            System.out.println("Merci d'écrire 'O' ou 'N' !");
            System.out.println("Découvert autorisé O/N : ");
            tooMuch = sc.nextLine();
        }
        boolean overdraft = tooMuch.equals("O");
        Client client = searchClient();
        System.out.println("Quel type de compte voulez-vous créer ? ");
        System.out.println("1 = Compte courant");
        System.out.println("2 = Livret A");
        System.out.println("3 = Plan Épargne Logement");
        choix = sc.nextInt();
        switch (choix) {
            case 1:
                accountList.add(new Courant(nbAccount, agencyCode, balance, overdraft, client));
                break;
            case 2 :
                accountList.add(new LivretA(nbAccount, agencyCode, balance, overdraft, client));
                break;
            case 3 :
                accountList.add(new Logement(nbAccount, agencyCode, balance, overdraft, client));
                break;
            default :
                System.out.println("Entrez un chiffre entre 1 et 3 !");
        }
    }

    public void searchAccount(){
        System.out.println("Quel est l'ID du compte ?");
        float id = sc.nextFloat();
        accountList.forEach(e -> {
            if(e.getNbAccount() == id){
                System.out.println("Numéro de compte : ");
                System.out.print(e.getNbAccount());
                System.out.println("Code de l'agence : ");
                System.out.print(e.getCodeAgency());
                System.out.println("Solde : ");
                System.out.print(e.getBalance());
                System.out.println("Client : ");
                System.out.print(e.getClient());
            }
        });
    }
    public Client searchClient(){
        System.out.println("quel est l'id du client du compte ?");
        String id = sc.nextLine();


        for(Client account : cm.clientList) {
            if(account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }
}