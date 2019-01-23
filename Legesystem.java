import java.util.*;

class Legesystem{
    
    static Lenkeliste<Pasient> pasientListe = new Lenkeliste<>();
    static Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<>();
    static SortertLenkeliste<Lege> legeListe = new SortertLenkeliste<>();
    static Lenkeliste<Resept> reseptListe = new Lenkeliste<>();


    public static void main(String[] args){
        int lokke = -1;

        while(lokke != 0){
            System.out.println("=====================================================");
            System.out.println("\n Velkommen til IFI legesystem. \n");
            System.out.println("=====================================================");
            System.out.println("Velg en av de foelgende ved aa skrive tallet: \n");
            System.out.println("1   Skrive hele oversikten av systemet");
            System.out.println("2   Opprette og legge til nye elementer i systemet");
            System.out.println("3   Bruke resept til en pasient");
            System.out.println("4   Statistikk");
          //  System.out.println("5   Skrive alle data til fil");
            System.out.println("0   Avslutt programmet");
            System.out.println("===================================================== \n");
            System.out.print("Skriv her: ");
            
            
            Scanner s = new Scanner(System.in);
            lokke = tallInput(s);
            /*
            while(true){
                try{
                    lokke = Integer.parseInt(s.nextLine());
                    break;

                }catch(NumberFormatException e){
                    System.out.println("Vennligst tast heltall.");
                    System.out.print("Skriv her: ");
                }
            }
            */
                       
            switch(lokke){
               case 0:
                    System.out.println("\n\nProgrammet avsluttes. Ha det bra!\n\n");
                    break;

                case 1: 
                    System.out.println("Her har du hele oversikten av systemet:\n");
                    //Pasienter
                    System.out.println("Pasienter:");
                    for(Pasient p : pasientListe){
                        String navn = p.hentNavn();
                        System.out.println(navn);
                        //System.out.println(p.hentNavn());
                    }
                    System.out.println("Antall pasienter: " + pasientListe.stoerrelse() + "\n");

                    //Legemiddler
                    System.out.println("\nLegemidller:\n");

                    System.out.println("LegemiddelA:");
                    int antA = 0;
                    for(Legemiddel l : legemiddelListe){
                        if(l instanceof LegemiddelA){
                            LegemiddelA tmp = (LegemiddelA) l;
                            System.out.println(tmp.hentNavn() + " pris: " + tmp.hentPris() + " virkestoff: " + tmp.hentVirkestoff() + " narkotisk: " + tmp.hentNarkotiskStyrke());
                            antA ++;
                        }
                    }
                    System.out.println("Antall legemiddelA: " + antA);

                    System.out.println("\nLegemiddelB:");
                    int antB = 0;
                    for(Legemiddel l : legemiddelListe){
                        if(l instanceof LegemiddelB){
                            LegemiddelB tmp = (LegemiddelB) l;
                            System.out.println(tmp.hentNavn() + " pris: " + tmp.hentPris() + " virkestoff: " + tmp.hentVirkestoff() + " styrke: " + tmp.hentVanedannendeStyrke());
                            antB ++;
                        }
                    }
                    System.out.println("Antall legemiddelB: " + antB);

                    System.out.println("\nLegemiddelC:");
                    int antC = 0;
                    for(Legemiddel l : legemiddelListe){
                        if(l instanceof LegemiddelC){
                            LegemiddelC tmp = (LegemiddelC) l;
                            System.out.println(tmp.hentNavn() + " pris: " + tmp.hentPris() + " virkestoff: " + tmp.hentVirkestoff());
                            antC ++;
                        }
                    }
                    System.out.println("Antall legemiddelC: " + antC);
                    System.out.println("\nTotal antall legemiddler: " + legemiddelListe.stoerrelse() + "\n");

                    //Leger
                    System.out.println("\nLeger:\n");
                    for(Lege l : legeListe){
                        if(l instanceof Fastlege){
                            Fastlege tmp = (Fastlege) l;
                            System.out.println(tmp.hentNavn() + "     " + tmp.hentAvtalenummer());
                        }else{
                            System.out.println(l.hentNavn());
                        }
                    }
                    System.out.println("Antall Leger: " + legeListe.stoerrelse());


                    //Resepter
                    System.out.println("\n\nResepter: \n");
                    for(Resept r : reseptListe){
                        String farge = r.farge();
                        String legeNavn = (r.hentLege()).hentNavn();
                        String pasientNavn = (r.hentPasient()).hentNavn();
                        
                        System.out.println(farge + "resept skrevet av " + legeNavn + " til pasienten " + pasientNavn);
                    }
                    System.out.println("Antall resepter: " + reseptListe.stoerrelse());
                    break;

                case 2:
                    System.out.println("===================================================== \n");
                    System.out.println("Her kan du legge til nye elementer i systemet");
                    int comand = -1;
                    while(comand != 0){
                        System.out.println("\nHva vil du legge til?");
                        System.out.println("1   Pasient");
                        System.out.println("2   Legemiddel");
                        System.out.println("3   Lege");
                        System.out.println("4   Resept");
                        System.out.println("0   gaa til hovedmeny\n");
                        System.out.println("Skriv her:");
                        comand = tallInput(s);
                        /*
                        while(true){
                            try{
                                comand = Integer.parseInt(s.nextLine());
                                break;
                            }catch(NumberFormatException e){
                                System.out.println("Vennligst tast heltall");
                                System.out.println("Skriv her");
                            }
                        }
                        */
                        switch(comand){
                            //hovedmeny
                            case 0:
                                break;
                            
                            //Legg til pasient
                            case 1:
                                System.out.println("Hva heter pasienten?");
                                System.out.println("Skriv her: ");
                                String pasientNavn = s.nextLine();
                                
                                System.out.println("Hva er foedselsnummeret til pasienten?");
                                System.out.println("Skriv her: ");
                                String foedselsnummer = s.nextLine();

                                leggTilPassient(pasientNavn, foedselsnummer);
                                break;
                            
                            //Legg til legemiddel
                            case 2:
                                int legemiddelType = -1;
                                
                                System.out.println("Hvilken type er legemiddelen?");
                                System.out.println("1   Type A");
                                System.out.println("2   Type B");
                                System.out.println("3   Type C");
                                System.out.println("0   gaa et nivaa opp");
                                
                                System.out.println("Skriv her: ");
                                legemiddelType = tallInput(s);

                                switch(legemiddelType){
                                    //opp et nivaa
                                    case 0:
                                        break;

                                    //Legg til legemiddelA
                                    case 1:
                                        System.out.println("Hva heter legemiddelA?");
                                        System.out.println("Skriv her: ");
                                        String legemiddelANavn = stringInput(s);

                                        System.out.println("Hva koster den?");
                                        System.out.println("Skriv her: ");
                                        Double legemiddelAPris = doubleInput(s);

                                        System.out.println("Hvor mye virkemiddel har den?");
                                        System.out.println("Skriv her: ");
                                        Double virkestoffA = doubleInput(s);

                                        System.out.println("Hvor narkostisk er den?");
                                        System.out.println("Skriv her: ");
                                        int narkotisk = tallInput(s);

                                        leggTilLegemiddelA(legemiddelANavn, legemiddelAPris, virkestoffA, narkotisk);
                                        break;

                                    //Legg til legemiddelB
                                    case 2:
                                        System.out.println("Hva heter legemiddelB?");
                                        System.out.println("Skriv her: ");
                                        String legemiddelBNavn = stringInput(s);

                                        System.out.println("Hva koster den?");
                                        System.out.println("Skriv her: ");
                                        Double legemiddelBPris = doubleInput(s);

                                        System.out.println("Hvor mye virkemiddel har den?");
                                        System.out.println("Skriv her: ");
                                        Double virkestoffB = doubleInput(s);

                                        System.out.println("Hvor vanndannende er den?");
                                        System.out.println("Skriv her: ");
                                        int vanedannende = tallInput(s);

                                        leggTilLegemiddelB(legemiddelBNavn, legemiddelBPris, virkestoffB, vanedannende);
                                        break;

                                    //legg til legemiddelC
                                    case 3:
                                        System.out.println("Hva heter legemiddelC?");
                                        System.out.println("Skriv her: ");
                                        String legemiddelCNavn = stringInput(s);

                                        System.out.println("Hva koster den?");
                                        System.out.println("Skriv her: ");
                                        Double legemiddelCPris = doubleInput(s);

                                        System.out.println("Hvor mye virkemiddel har den?");
                                        System.out.println("Skriv her: ");
                                        Double virkestoffC = doubleInput(s);

                                        leggTilLegemiddelC(legemiddelCNavn, legemiddelCPris, virkestoffC);
                                        break;

                                    default:
                                        System.out.println("Vennligst skrive et heltall mellom 0 og 3");
                                        break;
                                }   
                                break;
                            
                            //Legg til lege
                            case 3:
                                System.out.println("Hvilken type lege er det?");
                                System.out.println("1   Vanlig lege");
                                System.out.println("2   Fastlege");
                                System.out.println("0   opp et nivaa");

                                System.out.println("Skriv her: ");
                                int legeType = tallInput(s);

                                switch(legeType){
                                    case 0:
                                        break;

                                    case 1:
                                        System.out.println("Hva heter legen?");
                                        String vanligLegeNavn = stringInput(s);

                                        leggTilLege(vanligLegeNavn, 0);
                                        break;

                                    case 2:
                                        System.out.println("Hva heter legen?");
                                        String fastLegeNavn = stringInput(s);

                                        System.out.println("Hva er avtalenummeret?");
                                        int avtalenummer = tallInput(s);

                                        leggTilLege(fastLegeNavn, avtalenummer);
                                        break;
                                    
                                    default:
                                        System.out.println("Vennligst skrive heltall mellom 0 og 2");
                                        
                                }

                                break;

                            //Legg til resept
                            case 4:
                                System.out.println("Hvilken type resept er det?");
                                System.out.println("1   P-resept");
                                System.out.println("2   Blaaresept");
                                System.out.println("3   Hvitresept");
                                System.out.println("4   Militaer-resept");
                                System.out.println("0   opp et nivaa");

                                System.out.println("Skriv her: ");
                                int reseptType = tallInput(s);
                                
                                if(reseptType > 0 && reseptType < 5){
                                    
                                    System.out.println("Hva er legemiddelnummeret til resepten?");
                                    int legemiddelNummer = tallInput(s);
                                    if( !gyldigLegemiddel(legemiddelNummer) ){
                                        System.out.println("ugyldig legemiddel");
                                        break;
                                    }

                                    System.out.println("Hva heter legen?");
                                    String legeNavn = stringInput(s);
                                    if( !gyldigLege(legeNavn) ){
                                        System.out.println("Ugyldig lege");
                                        break;
                                    }

                                    System.out.println("Hva er personID til pasienten?");
                                    int personID = tallInput(s);
                                    if( !gyldigPasient(personID) ){
                                        System.out.println("Ugyldig pasient");
                                        break;
                                    }

                                    System.out.println("Hva er reiten til resepten?(skriv 0 for p resepter)");
                                    int reit = tallInput(s);

                                    leggTilResept(reseptType, legemiddelNummer, legeNavn, personID, reit);


                                }else if(reseptType == 0){
                                    break;
                                }
                                   
                                break;
                            
                            default:
                                System.out.println("Vennligst skrive et heltall mellom 0 og 4");
                        }

                    }

                    break;

                case 3:
                    if(reseptListe.stoerrelse() == 0){
                        System.out.println("Det finnes ingen resepter i systemet");
                        break;
                    }
                    System.out.println("Her kan du bruke resept til en pasitent:");

                    System.out.println("Hvilken pasient vil du se resepter for?");
                    int count = 0;
                    for(Pasient p : pasientListe){
                        System.out.println(count + ": " + p.hentNavn() + "(fnr " + p.hentID() + ")");
                        count ++;
                    }
                    System.out.print("> ");
                    int option = tallInput(s);

                    if(option > pasientListe.stoerrelse() || option < 0){
                        System.out.println("Ugyldig valg");
                        break;
                    }

                    Pasient valgtPasient = pasientListe.hent(option);
                    System.out.println("Valgt pasient: " + valgtPasient.hentNavn() + "(fnr " + valgtPasient.hentID() + ")");
                    Lenkeliste<Resept> pasientResepter = valgtPasient.hentReseptList();

                    System.out.print("Hvilken resept vil du bruke?");
                    count = 0;
                    for(Resept r : pasientResepter){
                        Legemiddel middel = r.hentLegemiddel();
                        System.out.println(count + ": " + middel.hentNavn() + "  reit: " + r.hentReit());
                    }
                    System.out.print("> ");
                    option = tallInput(s);
                    if(option > pasientResepter.stoerrelse() || option < 0){
                        System.out.println("Ugyldig valg");
                        break;
                    }
                    Resept valgtResept = pasientResepter.hent(option);

                    if(valgtResept.bruk()){
                        System.out.println("Brukte resept paa " + valgtResept.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit: " + valgtResept.hentReit());

                    }else{
                        System.out.println("Kunne ikke bruke resept paa " + valgtResept.hentLegemiddel().hentNavn() + ", ingen gjenvaerende reit");
                    }
                    
                    break;

                case 4:
                    System.out.println("Her har du statistikken:");
                    int antVanedannende = 0;
                    int antVaneOgMil = 0;
                    Lenkeliste<String[]> narkoLeger = new Lenkeliste<>();
                    Lenkeliste<String[]> narkoPasienter = new Lenkeliste<>();

                    for(Resept r : reseptListe){
                        Legemiddel middel = r.hentLegemiddel();
                        if(middel instanceof LegemiddelB){
                            antVanedannende ++;
            
                        }else if(r instanceof MilitaerResept && middel instanceof LegemiddelB){
                            antVaneOgMil ++;
                        }
                        
                    }

                    for(Lege l : legeListe){
                        Lenkeliste<Resept> legeResepter = l.hentListe();
                        
                        if(narko(legeResepter)){
                            String[] narkoLege= new String[2];
                            int lAntallNarko = 0; 
                            
                            for(Resept r : legeResepter){
                                Legemiddel lNarkoMiddel = r.hentLegemiddel();
                                if(lNarkoMiddel instanceof LegemiddelA){
                                    lAntallNarko ++;
                                } 
                            }
                            narkoLege[0] = l.hentNavn();
                            narkoLege[1] = Integer.toString(lAntallNarko);
                            narkoLeger.leggTil(narkoLege);
                        }
                    }
                    
                    for(Pasient p : pasientListe){
                        pasientResepter = p.hentReseptList();
                        
                        if(narko(pasientResepter)){
                            String[] narkoPasient= new String[2];
                            int pAntallNarko = 0; 
                            
                            for(Resept r : pasientResepter){
                                Legemiddel pNarkoMiddel = r.hentLegemiddel();
                                if(pNarkoMiddel instanceof LegemiddelA){
                                    pAntallNarko ++;
                                } 
                            }
                            narkoPasient[0] = p.hentNavn();
                            narkoPasient[1] = Integer.toString(pAntallNarko);
                            narkoPasienter.leggTil(narkoPasient);
                        }
                    }

                    System.out.println("\nTotal antall utskrvne resepter paa vanedannende legemidler: " + antVanedannende);
                    System.out.println("\nAntall vanedannende resepter utskrevne til militaere: " + antVaneOgMil);
                    System.out.println("\nLeger som har skrevet resept med narkotisk stoffer: ");
                    for(String[] a : narkoLeger){
                        System.out.println(a[0] + "  " + a[1]);
                    }
                    System.out.println("\nPasienter som har faatt resepter med narkotisk stoffer: ");
                    for(String[] a : narkoPasienter){
                        System.out.println(a[0] + "  " + a[1]);
                    }


                    break;
                /*
                case 5:
                    System.out.println("Her kan du skrive alle data til fil:");
                    break;
                */

                default:
                    System.out.println("Vennligst skrive et heltall mellom 0 og 4");
            }

        }
    }
/*
    static boolean gjyldigObjekt(Object objekt, Lenkeliste<Object> liste){
        for(Object element : liste){
            if(objekt == element){
                return true;
            }
        }
        return false;
    }
*/  
    static boolean narko(Lenkeliste<Resept> liste){
        for(Resept r : liste){
            Legemiddel middel = r.hentLegemiddel();
            if(middel instanceof LegemiddelA){
                return true;
            }
        }
        return false;
    }

    static boolean gyldigLegemiddel(int legemiddelNummer){
        for(Legemiddel l : legemiddelListe){
            if(l.hentID() == legemiddelNummer){
                return true;
            }
        }
        return false;
    }

    static boolean gyldigPasient(int personID){
        for(Pasient p : pasientListe){
            if(p.hentID() == personID){
                return true;
            }
        }
        return false;
    }

    static boolean gyldigLege(String legeNavn){
        for(Lege l : legeListe){
            if(l.hentNavn().equals(legeNavn)){
                return true;
            }
        }
        return false;
    }

    static int tallInput(Scanner s){
        while(true){
           try{
                int inp = Integer.parseInt(s.nextLine());
                return inp;
            }catch(NumberFormatException e){
                System.out.println("Vennligst tast heltall");
                System.out.println("Skriv her: ");
                }
            }
    }

    static double doubleInput(Scanner s){
        while(true){
           try{
                double inp = Double.parseDouble(s.nextLine());
                return inp;
            }catch(NumberFormatException e){
                System.out.println("Vennligst tast double-tall");
                System.out.println("Skriv her: ");
                }
            }
    }

    static String stringInput(Scanner s){
        String inp = s.nextLine();
        return inp;
    }

    static void leggTilPassient(String navn, String fnr){
        Pasient p = new Pasient(navn, fnr);
        pasientListe.leggTil(p);
        System.out.println("En ny pasient er lagt til i systemet");

    }

    static void leggTilLegemiddelA(String navn, Double pris, Double virkestoff, int narkotisk){
        LegemiddelA legemiddel = new LegemiddelA(navn, pris, virkestoff, narkotisk);
        legemiddelListe.leggTil(legemiddel);
        System.out.println("En ny legemiddelA er lagt til i systemet");
    }

    static void leggTilLegemiddelB(String navn, Double pris, Double virkestoff, int vanedannende){
        LegemiddelB legemiddel = new LegemiddelB(navn, pris, virkestoff, vanedannende);
        legemiddelListe.leggTil(legemiddel);
        System.out.println("En ny legemiddelB er lagt til i systemet");

    }

    static void leggTilLegemiddelC(String navn, Double pris, Double virkestoff){
        LegemiddelC legemiddel = new LegemiddelC(navn, pris, virkestoff);
        legemiddelListe.leggTil(legemiddel);
        System.out.println("En ny legemiddelC er lagt til i systemet");

    }

    static void leggTilLege(String navn, int avtaleNummer){
        if(avtaleNummer == 0){
            Lege l = new Lege(navn);
            legeListe.leggTil(l);
            System.out.println("En ny lege er lagt til i systemet");

        }else{
            Fastlege l = new Fastlege(navn, avtaleNummer);
            legeListe.leggTil(l);
            System.out.println("En ny fastlege er lagt til i systemet");
        }
            
    }

    static void leggTilResept(int type, int legemiddelNummer, String legeNavn, int personID, int reit){
        Legemiddel legemiddel = null;
        Lege lege = null;
        Pasient pasient = null;

        for(Legemiddel l : legemiddelListe){
            if(l.hentID() == legemiddelNummer){
                legemiddel = l;
            }
        }
        
        for(Lege l : legeListe){
            if(l.hentNavn().equals(legeNavn)){
                lege = l;
            }
        }

        for(Pasient p : pasientListe){
            if(p.hentID() == personID){
                pasient = p;
            }
        }

        switch(type){
            case 1:
                PResept presept = new PResept(legemiddel, lege, pasient);
                reseptListe.leggTil(presept);
                pasient.addResept(presept);
                lege.leggTilResept(presept);
                System.out.println("En ny P-Resept er lagt til i systemet");
                break;

            case 2:
                BlaaResept blaaresept = new BlaaResept(legemiddel, lege, reit, pasient);
                reseptListe.leggTil(blaaresept);
                pasient.addResept(blaaresept);
                lege.leggTilResept(blaaresept);
                System.out.println("En ny Blaa-Resept er lagt til i systemet");
                break;
            
            case 3:
                HvitResept hvitresept = new HvitResept(legemiddel, lege, reit, pasient);
                reseptListe.leggTil(hvitresept);
                pasient.addResept(hvitresept);
                lege.leggTilResept(hvitresept);
                System.out.println("En ny Hvit-Resept er lagt til i systemet");
                break;

            case 4:
                MilitaerResept militaerresept = new MilitaerResept(legemiddel, lege, reit, pasient);
                reseptListe.leggTil(militaerresept);
                pasient.addResept(militaerresept);
                lege.leggTilResept(militaerresept);
                System.out.println("En ny Militaer-Resept er lagt til i systemet");
                break;

                
        }

    }
}