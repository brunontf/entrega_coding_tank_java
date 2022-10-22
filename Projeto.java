import java.util.Scanner;

public class Projeto {

    // Funcao Scanner
    private static String digite(String pergunta) {
        Scanner input= new Scanner(System.in);
        System.out.print(pergunta);
        String i = input.next();
        // input.close();
        return i;
    }
    public static void main(String[] args) {
        
        // Dados de Entrada e primeiro tratamento de erros
        int quantidadeDeTemperaturas = Integer.parseInt(digite("Informe a quantidade de temperaturas a serem convertidas: "));
        
        // while (quantidadeDeTemperaturas != (int) quantidadeDeTemperaturas){
        //     quantidadeDeTemperaturas = Integer.parseInt(digite("Informe a quantidade de temperaturas a serem convertidas: "));

        // }

        String primeiraUnid= digite("Informe a unidade de origem da temperatura: (celsius, kelvin ou fahrenheit) ");
        while(!((primeiraUnid.equals("celsius")) || ( primeiraUnid.equals("kelvin")) || ( primeiraUnid.equals("fahrenheit")))){
            primeiraUnid= digite("Informe, CONFORME NOS PARENTESES, a unidade de origem da temperatura: (celsius, kelvin ou fahrenheit) ");
        }

        String segundaUnid= digite("Informe a unidade de temperatura a ser transformada: (celsius, kelvin ou fahrenheit) ");
        while(!((segundaUnid.equals("celsius")) || (segundaUnid.equals("kelvin")) || (segundaUnid.equals("fahrenheit")))){
            segundaUnid= digite("Informe, CONFORME NOS PARENTESES, a unidade de temperatura a ser transformada: (celsius, kelvin ou fahrenheit) ");
        }

        double[] temperaturasInciais = new double[quantidadeDeTemperaturas];
        double[] temperaturasConvertidas = new double[quantidadeDeTemperaturas];

        for(int i=0;i<quantidadeDeTemperaturas;i++){
            temperaturasInciais[i] = Double.parseDouble(digite("Informe a " +(i+1)+ " temperatura: "));
        }

        // Convertendo temperaturas
        for(int i=0;i<quantidadeDeTemperaturas;i++){

            if (primeiraUnid.equals("celsius")){
                if (segundaUnid.equals("celsius")){
                    temperaturasConvertidas[i]= temperaturasInciais[i];
                }
                else if (segundaUnid.equals("fahrenheit")){
                    temperaturasConvertidas[i]= ConversorTemperatura.celsiusParaFahrenheit(temperaturasInciais[i]);
                }
                else if (segundaUnid.equals("kelvin")){
                    temperaturasConvertidas[i]= ConversorTemperatura.celsiusParaKelvin(temperaturasInciais[i]);
                }

            }
            else if (primeiraUnid.equals("kelvin")){
                if (segundaUnid.equals("kelvin")){
                    temperaturasConvertidas[i]= temperaturasInciais[i];
                }
                else if (segundaUnid.equals("fahrenheit")){
                    temperaturasConvertidas[i]= ConversorTemperatura.kelvinParaFahrenheit(temperaturasInciais[i]);
                }
                else if (segundaUnid.equals("celsius")){
                    temperaturasConvertidas[i]= ConversorTemperatura.kelvinParaCelsius(temperaturasInciais[i]);
                }
            }
            else if (primeiraUnid.equals("fahrenheit")){
                if (segundaUnid.equals("fahrenheit")){
                    temperaturasConvertidas[i]= temperaturasInciais[i];
                }
                else if (segundaUnid.equals("celsius")){
                    temperaturasConvertidas[i]= ConversorTemperatura.fahrenheitParaCelsius(temperaturasInciais[i]);
                }
                else if (segundaUnid.equals("kelvin")){
                    temperaturasConvertidas[i]= ConversorTemperatura.fahrenheitParaKelvin(temperaturasInciais[i]);
                }
            }
        }

        // Imprimindo temperaturas e unidades
        for(int i=0;i<quantidadeDeTemperaturas;i++){
            // System.out.println("Temperatura "+(i+1)+" informada = "+temperaturasInciais[i]+" "+primeiraUnid+", temperatura resultante = "+temperaturasConvertidas[i]+" "+segundaUnid);
            System.out.printf("Temperatura %d informada = %.2f %s, temperatura resultante = %.2f %s \n",(i+1),temperaturasInciais[i],primeiraUnid,temperaturasConvertidas[i],segundaUnid);
        }
        // Cálculo da média das temperaturas
        double media1=0;
        double media2=0;

        for (int i = 0; i < quantidadeDeTemperaturas; i++) {
            media1 =  media1+temperaturasInciais[i]/quantidadeDeTemperaturas;
            media2 =  media2+temperaturasConvertidas[i]/quantidadeDeTemperaturas;
        }
        System.out.printf("Média das Temperaturas Iniciais = %.2f\n",media1);
        System.out.printf("Média das Temperaturas Transformadas = %.2f\n",media2);
 
    }
}
