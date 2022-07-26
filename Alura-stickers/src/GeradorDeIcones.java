public class GeradorDeIcones {
    static void GerarEImprimir(String CodigoIcone, Double Nota){        
        String Campo = "";                
        for (int i = 0; i < Nota; i++) {
            Campo += CodigoIcone;
        }
        Imprmir(Campo);
    }

    static void Imprmir(String mensagem){
        System.out.println(mensagem);
    }
}
