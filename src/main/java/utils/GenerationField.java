package utils;

public class GenerationField {
         public String generateField(int count){
           StringBuilder stringBuilder = new StringBuilder();
           for (int i = 0; i <count ; i++) {
               char z = (char)(97 + Math.random()*26);
               stringBuilder.append(z);
           }
           return stringBuilder.toString();
       }


}
