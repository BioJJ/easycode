package EasyCode;




import EasyCode.Pais.Variavel;
import EasyCode.Pais.Bloco;
import EasyCode.BlocosFuncionais.BFEscrevaTXT;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author CCE
 */
public class test {
        public static String imprime(ArrayList<Bloco> lista, ArrayList<Variavel> listaVar) {
         int ident=0;
         boolean estrutura = false;
         String txt = "#include<stdio.h>\n#include<stdlib.h>\n";
         
         for (int i = 0; i < lista.size(); i++) {
             String nome = lista.get(i).getNome();
             switch (nome) {
                 case "Inicio":
                     txt += "int main () {\n";
                     for(int a=0;a<ident;a++){txt +="        ";}
                     ident++;
                     estrutura = true;
                     break;
                 case "Se":
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "if (" + lista.get(i).getCondicao() + ") {\n";
                     ident++;
                     estrutura = true;
                     break;
                 case "Para":
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "for (" + lista.get(i).getCondicao() + "=" + lista.get(i).getRecebe() + " ; " + lista.get(i).getCondicao()
                             + " < " + lista.get(i).getAte() + " ; " + lista.get(i).getCondicao().trim() + "++ ) {\n";
                     ident++;
                     estrutura = true;
                     break;
                 case "Enquanto":
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "while (" + lista.get(i).getCondicao() + ") {\n";
                     ident++;
                     estrutura = true;
                     break;
                 case "Escolha":
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "switch (" + lista.get(i).getCondicao() + ") {\n";
                     ident++;
                     estrutura = true;
                     break;
                 case "Caso":
                     txt += "case " + lista.get(i).getCondicao() + ":\n";
                     estrutura = true;
                     break;
                 case "Fim":
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "return 0;}";
                     estrutura = false;
                     break;
                     case "Variavel":
                     String tipo = "";
                     switch (lista.get(i).getTipo()) {
                         case "Inteiro": tipo = "int";
                         break;
                         case "Real": tipo = "float";
                         break;
                         case "Caracter" : tipo = "char";
                         break;
                     }    
                      for(int a=0;a<ident;a++){txt +="        ";}
                     txt += tipo + " " + lista.get(i).getVar() + ";\n";
                     if(ident>1)ident--;
                     estrutura = false;
                     break;
                     
                case "FimCaso":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "break;\n";
                     if(ident>1)ident--;
                     estrutura = false;
                     break;
                case "Igual":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "=" + lista.get(i).getN2() + ";\n";
                     if(ident>1)ident--;
                     break;
                case "IgualSoma":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "+=" + lista.get(i).getN2() + ";\n";
                     if(ident>1)ident--;
                     break;
                case "IgualSubtracao":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "-=" + lista.get(i).getN2() + ";\n";
                     if(ident>1)ident--;
                     break;
                case "IgualDivisao":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "/=" + lista.get(i).getN2() + ";\n";
                     if(ident>1)ident--;
                     break;
                case "IgualMultiplicacao":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "*=" + lista.get(i).getN2() + ";\n";
                     if(ident>1)ident--;
                     break;
                case "Incrementa":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "++;\n";
                     if(ident>1)ident--;
                     break; 
                case "Decrementa":
                    for(int a=0;a<ident;a++){txt +="        ";}
                     txt += lista.get(i).getN1() + "--;\n";
                     if(ident>1)ident--;
                     break;
                case "Escreva":
                    ArrayList<Integer> list = new ArrayList();
                    ArrayList<String> str2 = new ArrayList();
                    ArrayList<String> var2 = new ArrayList();
                    String word = lista.get(i).getCondicao();
                    for (int index = word.indexOf("\"");index >= 0; index = word.indexOf("\"", index + 1)) {
                        list.add(index);
                      }
                    for (int n = 0; n < list.size(); n+=2) {
                        str2.add(word.substring(list.get(n)+1, list.get(n+1)));
                    }
                    String escreva = word.replace("\"", " ");
                    
                    String str3[] = escreva.split(",");
                  
             for (String str31 : str3) {
                 if (!str2.contains(str31.trim())) {
                     var2.add(str31.trim());
                 }
             }
                        String str[] = new String[var2.size()];
                        var2.toArray(str);

                     
             
                    ArrayList <String> var = new ArrayList();
                    
                    txt+="printf(\"";
                  for (int j = 0; j < listaVar.size(); j++) { 
                    for (int k = 0; k < str.length; k++) {
                        if (str[k].equals(listaVar.get(j).getVar())) {
                            var.add(listaVar.get(j).getVar());
                            String replace;
                            switch (listaVar.get(j).getTipo()) {
                                case "Inteiro":
                                    replace = "%d";
                                    break;
                                case "Real":
                                    replace = "%f";
                                    break;
                               case "Caracter":
                                    replace = "%c";
                                    break;
                               default:
                                    replace = " ";
                                    break;
                            }
                            str[k]=replace;
                        }
                        
                    }
                  }
                        escreva="";
                         for (int j = 0; j < str2.size(); j++) {
                             escreva+=str2.get(j) + " " + str[j] + " ";
                             if (j==str2.size()-1 && !var.isEmpty())
                                 escreva+=", ";
                         }
                         
                         txt += escreva + "\"";
                      
                       for (int k = 0; k < var.size(); k++) {
                           txt += var.get(k);
                           if (k < var.size()-1)
                               txt+=", ";
                       }
                        txt += ");\n";
                    if(ident>1)ident--;
                    break;
                case "Leia":
                    for(int a=0;a<ident;a++){txt +="        ";}
                    String leia = lista.get(i).getCondicao().replace(",", " ");
                   
                  str = leia.split(" ");
                    var = new ArrayList();
                    
                    txt+="scanf(\"";
                  for (int j = 0; j < listaVar.size(); j++) { 
                    for (int k = 0; k < str.length; k++) {
                                      
                        if (str[k].equals(listaVar.get(j).getVar())) {
                            var.add(listaVar.get(j).getVar());
                            String replace;
                            switch (listaVar.get(j).getTipo()) {
                               case "Inteiro":
                                    replace = "%d";
                                    break;
                               case "Real":
                                    replace = "%f";
                                    break;
                               case "Caracter":
                                    replace = "%c";
                                    break;
                               default:
                                    replace = " ";
                                    break;
                            }
                            str[k] = replace;
                         
                       }
                     }
                   }
                       leia = ""; 
                      for (int l = 0; l < str.length; l++) {
                           leia += str[l];
                         }
                    txt += leia + " \",";
                       for (int k = 0; k < var.size(); k++) {
                           txt +="&"+ var.get(k);
                           if (k <= var.size()-1)
                               txt+=", ";
                       }
                       txt += ");\n";
                    if(ident>1)ident--;
                   break;
                 default:
                     if(estrutura==true) ident--;
                     for(int a=0;a<ident;a++){txt +="        ";}
                     txt += "}\n";
                     if(ident>1)ident--;
                     estrutura = false;
                     break;
                     
             }
             if(ident<0) ident =0;
         }
         return txt;
     }


     
     
     public static void main(String[] args) {

        BFEscrevaTXT escreva = new BFEscrevaTXT();
//        BVariavel var = new BVariavel();
//        var.setTipo("Inteiro");
//        var.setVar("a");
//        BVariavel var2 = new BVariavel();
//        var2.setTipo("Real");
//        var2.setVar("s");

        escreva.setCondicao("\"a tem valor\", a,\"e s tem valor\", s");
        ArrayList<Variavel> listaVar = new ArrayList();   
        ArrayList<Bloco> lista = new ArrayList();
//        listaVar.add(var);
//        lista.add(var);
//        listaVar.add(var2);
//        lista.add(var2);

        lista.add(escreva);
         System.out.println(test.imprime(lista, listaVar));
 
         
    }
     
}



