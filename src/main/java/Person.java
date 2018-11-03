
public class Person
{
   private String imie;
   private String nazwisko;
   private String pesel;

   public String getImie() {
      return imie;
   }

   public void setImie(String imie) {
      this.imie = imie;
   }

   public String getNazwisko() {
      return nazwisko;
   }

   public void setNazwisko(String nazwisko) {
      this.nazwisko = nazwisko;
   }

   public String getPesel() {
      return pesel;
   }

   public void setPesel(String pesel) {
      this.pesel = pesel;
   }

   public Person(String imie, String nazwisko, String pesel) {
      this.imie = imie;
      this.nazwisko = nazwisko;
      this.pesel = pesel;
   }


}
